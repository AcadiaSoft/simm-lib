/*
 * Copyright (c) 2019 AcadiaSoft, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.acadiasoft.im.simm.engine.margin;

import com.acadiasoft.im.base.margin.BundleMargin;
import com.acadiasoft.im.base.margin.SingleMargin;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.base.util.ListUtils;
import com.acadiasoft.im.simm.config.SimmConfig;
import com.acadiasoft.im.simm.model.ConcentrationRiskGroup;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.SensitivityIdentifier;
import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmSensitivityCorrelation;
import com.acadiasoft.im.simm.model.utils.MarginUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BucketMargin extends BundleMargin {

  private final static String LEVEL = "6.Bucket";
  private final BucketClass bucketClass;
  private final ConcentrationRiskGroup concentrationRiskClass;

  private BucketMargin(BucketClass bucketClass, BigDecimal margin, List<SingleMargin> marginByIdentifier) {
    this(bucketClass, margin, marginByIdentifier, null);
  }

  private BucketMargin(BucketClass bucketClass, BigDecimal margin, List<SingleMargin> marginByIdentifier, ConcentrationRiskGroup concentrationRiskClass) {
    super(LEVEL, bucketClass, margin, marginByIdentifier);
    this.bucketClass = bucketClass;
    this.concentrationRiskClass = concentrationRiskClass;
  }

  public BucketClass getBucketClass() {
    return bucketClass;
  }

  public static BucketMargin calculate(RiskClass riskClass, SensitivityClass sensitivityClass, BucketClass bucketClass,
                                       List<Sensitivity> sensitivities, Map<SensitivityIdentifier, ConcentrationRiskGroup> concentrationClasses,
                                       SimmConfig config) {
    List<WeightingMargin> weightMargins = getWeightingMargin(sensitivities, s -> {
      if (StringUtils.equalsIgnoreCase(s.getRiskType(), RiskClass.RISK_TYPE_XCCY_BASIS)) {
        return ConcentrationRiskGroup.buildWithConcentrationOfOne(s.getConcentrationRiskIdentifier());
      } else {
        return ConcentrationRiskGroup.findConcentrationClass(s.getConcentrationRiskIdentifier(), concentrationClasses);
      }
    }, config);
    BigDecimal sumSquared = BigDecimalUtils.sumSquared(weightMargins, WeightingMargin::getMargin);
    BiFunction<WeightingClass, WeightingClass, BigDecimal> correlate = (r, s) -> {
       BigDecimal sensitivityCorrelation = SimmSensitivityCorrelation.get(riskClass, sensitivityClass,
         r, s, config.calculationCurrency());
       BigDecimal concentrationCorrelation = ConcentrationRiskGroup.correlateClasses(
          ConcentrationRiskGroup.findConcentrationClass(r.getConcentrationRiskIdentifier(), concentrationClasses),
          ConcentrationRiskGroup.findConcentrationClass(s.getConcentrationRiskIdentifier(), concentrationClasses)
      );
      return sensitivityCorrelation.multiply(concentrationCorrelation);
    };
    BigDecimal sumCorrelated = MarginUtils.sumCorrelated(weightMargins, WeightingMargin::getMargin, correlate);
    BigDecimal bucketTotal = BigDecimalUtils.sqrt(sumSquared.add(sumCorrelated));

    if (riskClass.equals(RiskClass.FX)) {
      // weighted sensitivity level values are exactly the currencies, so we store them
      return new BucketMargin(bucketClass, bucketTotal, new ArrayList<>(weightMargins));
    } else if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      // for interest rate we want to store the single calculated concentration class to the bucket margin itself, so we get the single class from the classes map
      // we don't store weighted sensitivity level values in the tree for IR
      ConcentrationRiskGroup concentrationRiskClass = concentrationClasses.values().stream().findFirst()
          .orElseThrow(() -> new RuntimeException("There was no concentration risk class for the interest rate bucket level"));
      return new BucketMargin(bucketClass, bucketTotal, Collections.emptyList(), concentrationRiskClass);
    } else {
      // we don't need weighted sensitivity level values in the tree for these classes
      return new BucketMargin(bucketClass, bucketTotal, Collections.emptyList());
    }
  }

  public static BucketMargin calculate(RiskClass riskClass, SensitivityClass sensitivityClass, BucketClass bucketClass,
                                       List<Sensitivity> sensitivities, ConcentrationRiskGroup one, SimmConfig config) {
    // curvature sensitivities all have CR = 1
    List<WeightingMargin> weightMargins = getWeightingMargin(sensitivities, s -> one, config);
    BigDecimal sumSquared = BigDecimalUtils.sumSquared(weightMargins, WeightingMargin::getMargin);
    // curvature uses the standard correlation squared
    BiFunction<WeightingClass, WeightingClass, BigDecimal> correlate = (r, s) ->
      BigDecimalUtils.square(
        SimmSensitivityCorrelation.get(riskClass, sensitivityClass, r, s, config.calculationCurrency())
      );
    BigDecimal sumCorrelated = sumCorrelatedForWeight(weightMargins, correlate);
    BigDecimal bucketTotal = BigDecimalUtils.sqrt(sumSquared.add(sumCorrelated));
    return new BucketMargin(bucketClass, bucketTotal, Collections.emptyList());
  }

  public ConcentrationRiskGroup getBucketConcentrationClass() {
    return Optional.ofNullable(concentrationRiskClass)
      .orElse(ConcentrationRiskGroup.buildWithConcentrationOfOne(null));
  }

  // UTIL FUNCTIONS

  public static List<WeightingMargin> getWeightingMargin(List<Sensitivity> sensitivities,
                                                         Function<SensitivityIdentifier, ConcentrationRiskGroup> convert, SimmConfig config) {
    return ListUtils.groupBy(sensitivities, SensitivityIdentifier::determineRiskFactor).entrySet().stream()
      .map(group -> WeightingMargin.calculate(WeightingClass.determineWeightingClass(group.getKey()), group.getValue(), convert.apply(group.getKey()), config))
      .collect(Collectors.toList());
  }

  public static BigDecimal sumCorrelatedForWeight(List<WeightingMargin> margins, BiFunction<WeightingClass, WeightingClass, BigDecimal> correlate) {
    return MarginUtils.sumCorrelated(margins, WeightingMargin::getMargin, correlate);
  }

}
