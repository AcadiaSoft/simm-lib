/*
 * Copyright (c) 2018 AcadiaSoft, Inc.
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

import com.acadiasoft.im.simm.model.utils.ConcentrationRiskGroup;
import com.acadiasoft.im.base.imtree.ImTree;
import com.acadiasoft.im.base.imtree.identifiers.MarginIdentifier;
import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.param.SimmSensitivityCorrelation;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BucketMargin implements ImTree {

  private final static String LEVEL = "6.Bucket";
  private final BigDecimal margin;
  private final BucketClass bucketClass;
  private final Optional<ConcentrationRiskGroup> concentrationRiskClass;
  private final List<WeightingMargin> children = new ArrayList<>();
  private final RiskClass riskClass;
  private final SensitivityClass sensitivityClass;

  private BucketMargin(RiskClass riskClass, SensitivityClass sensitivityClass, BucketClass bucketClass, BigDecimal margin, List<WeightingMargin> marginByIdentifier) {
    this.riskClass = riskClass;
    this.sensitivityClass = sensitivityClass;
    this.bucketClass = bucketClass;
    this.margin = margin;
    this.concentrationRiskClass = Optional.empty();
    this.children.addAll(marginByIdentifier);
  }

  private BucketMargin(RiskClass riskClass, SensitivityClass sensitivityClass, BucketClass bucketClass, BigDecimal margin, List<WeightingMargin> marginByIdentifier, Optional<ConcentrationRiskGroup> concentrationRiskClass) {
    this.riskClass = riskClass;
    this.sensitivityClass = sensitivityClass;
    this.bucketClass = bucketClass;
    this.margin = margin;
    this.concentrationRiskClass = concentrationRiskClass;
    this.children.addAll(marginByIdentifier);
  }

  public static BucketMargin calculate(RiskClass riskClass, SensitivityClass sensitivityClass, BucketClass bucketClass, List<Sensitivity> sensitivities, Map<String, ConcentrationRiskGroup> concentrationClasses) {
    List<WeightingMargin> weightMargins = getWeightingMargin(sensitivities, s -> {
      if (StringUtils.equalsIgnoreCase(s.getRiskType(), RiskClass.RISK_TYPE_XCCY_BASIS)) {
        return ConcentrationRiskGroup.buildWithConcentrationOfOne(riskClass, sensitivityClass, s.getConcentrationRiskIdentifier());
      } else {
        return ConcentrationRiskGroup.findConcentrationClass(s.getConcentrationRiskIdentifier(), concentrationClasses);
      }
    });
    BigDecimal sumSquared = BigDecimalUtils.sumSquared(weightMargins, m -> m.getMargin());
    BiFunction<WeightingMargin, WeightingMargin, BigDecimal> correlate = (r, s) -> {
       BigDecimal sensitivityCorrelation = SimmSensitivityCorrelation.get(riskClass, r.getWeightingClass(), s.getWeightingClass());
       BigDecimal concentrationCorrelation = ConcentrationRiskGroup.correlateClasses(
          ConcentrationRiskGroup.findConcentrationClass(r.getWeightingClass().getConcentrationRiskIdentifier(), concentrationClasses),
          ConcentrationRiskGroup.findConcentrationClass(s.getWeightingClass().getConcentrationRiskIdentifier(), concentrationClasses)
      );
      return sensitivityCorrelation.multiply(concentrationCorrelation);
    };
    BigDecimal sumCorrelated = sumCorrelatedForWeight(weightMargins, correlate);
    BigDecimal bucketTotal = BigDecimalUtils.sqrt(sumSquared.add(sumCorrelated));

    if (riskClass.equals(RiskClass.FX)) {
      // weighted sensitivity level values are exactly the currencies, so we store them
      return new BucketMargin(riskClass, sensitivityClass, bucketClass, bucketTotal, weightMargins);
    } else if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      // for interest rate we want to store the single calculated concentration class to the bucket margin itself, so we get the single class from the classes map
      // we don't store weighted sensitivity level values in the tree for IR
      Optional<ConcentrationRiskGroup> concentrationRiskClass = concentrationClasses.values().stream().findFirst();
      return new BucketMargin(riskClass, sensitivityClass, bucketClass, bucketTotal, new ArrayList<>(), concentrationRiskClass);
    } else {
      // we don't need weighted sensitivity level values in the tree for these classes
      return new BucketMargin(riskClass, sensitivityClass, bucketClass, bucketTotal, new ArrayList<>());
    }
  }

  public static BucketMargin calculate(RiskClass riskClass, SensitivityClass sensitivityClass, BucketClass bucketClass, List<Sensitivity> sensitivities, ConcentrationRiskGroup one) {
    // curvature sensitivities all have CR = 1
    List<WeightingMargin> weightMargins = getWeightingMargin(sensitivities, s -> one);
    BigDecimal sumSquared = BigDecimalUtils.sumSquared(weightMargins, m -> m.getMargin());
    // curvature uses the standard correlation squared
    BiFunction<WeightingMargin, WeightingMargin, BigDecimal> correlate = (r, s) -> BigDecimalUtils.square(SimmSensitivityCorrelation.get(riskClass, r.getWeightingClass(), s.getWeightingClass()));
    BigDecimal sumCorrelated = sumCorrelatedForWeight(weightMargins, correlate);
    BigDecimal bucketTotal = BigDecimalUtils.sqrt(sumSquared.add(sumCorrelated));
    return new BucketMargin(riskClass, sensitivityClass, bucketClass, bucketTotal, new ArrayList<>());
  }

  @Override
  public MarginIdentifier getMarginIdentifier() {
    return bucketClass;
  }

  @Override
  public BigDecimal getMargin() {
    return margin;
  }

  @Override
  public List<ImTree> getChildren() {
    List<ImTree> list = new ArrayList<>();
    list.addAll(children);
    return list;
  }

  @Override
  public String getTreeLevel() {
    return LEVEL;
  }

  public ConcentrationRiskGroup getBucketConcentrationClass() {
    return concentrationRiskClass.orElse(ConcentrationRiskGroup.buildWithConcentrationOfOne(riskClass, sensitivityClass, bucketClass.getLabel()));
  }

  public BucketClass getBucketClass() {
    return bucketClass;
  }

  // UTIL FUNCTIONS

  public static List<WeightingMargin> getWeightingMargin(List<Sensitivity> sensitivities, Function<Sensitivity, ConcentrationRiskGroup> convert) {
    return sensitivities.stream().map(s -> WeightingMargin.calculate(s, convert.apply(s))).collect(Collectors.toList());
  }

  public static BigDecimal sumCorrelatedForWeight(List<WeightingMargin> margins, BiFunction<WeightingMargin, WeightingMargin, BigDecimal> correlate) {
    return BigDecimalUtils.sumCorrelated(margins, (m) -> m.getMargin(), correlate, (r, s) -> !r.getWeightingClass().equals(s.getWeightingClass()));
  }

}
