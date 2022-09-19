/*
 * Copyright (c) 2022 Acadia, Inc.
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

import com.acadiasoft.im.base.margin.BatchMargin;
import com.acadiasoft.im.base.margin.BundleMargin;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.base.util.ListUtils;
import com.acadiasoft.im.simm.config.SimmConfig;
import com.acadiasoft.im.simm.model.ConcentrationRiskGroup;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.SensitivityIdentifier;
import com.acadiasoft.im.simm.model.imtree.identifiers.*;
import com.acadiasoft.im.simm.model.param.SimmBucketCorrelation;
import com.acadiasoft.im.simm.model.param.SimmHvr;
import com.acadiasoft.im.simm.model.param.SimmSensitivityCorrelationBaseCorr;
import com.acadiasoft.im.simm.model.utils.MarginUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.special.Erf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ONE;

public class SensitivityMargin extends BatchMargin {

  private static final long serialVersionUID = 1L;

  /**
   * Φ^−1(x) = √2 * erfinv(2x−1)
   *
   * Curvature Margin values
   */
  private static final BigDecimal PHI_INV = BigDecimal.valueOf(Math.sqrt(2.0) * Erf.erfInv(2 * .995 - 1));

  private final static String LEVEL = "5.SensitivityType";

  private SensitivityMargin(SensitivityClass sensitivityClass, BigDecimal margin, List<BundleMargin> marginByBucket) {
    super(LEVEL, sensitivityClass, margin, marginByBucket);
  }

  public static SensitivityMargin calculate(RiskClass riskClass, SensitivityClass sensitivityClass, List<Sensitivity> sensitivities, SimmConfig config) {
    if (sensitivityClass.equals(SensitivityClass.BASECORR)) {
      return calculateForBaseCorr(sensitivities, config);
    } else if (sensitivityClass.equals(SensitivityClass.CURVATURE)) {
      return calculateForCurvature(riskClass, sensitivities, config);
    } else {
      Map<BucketClass, List<Sensitivity>> mapByBucket = ListUtils.groupBy(sensitivities, SensitivityIdentifier::getBucketIdentifier);
      Map<BucketClass, Map<SensitivityIdentifier, ConcentrationRiskGroup>> classes = mapByBucket.entrySet().stream().collect(Collectors.toMap(
          // the key entries here are exactly the bucket classes
          Map.Entry::getKey,
          // map by identifiers creates a map where the concentration risk identifiers are the keys
          e -> ListUtils.groupBy(e.getValue(), SensitivityIdentifier::getConcentrationRiskIdentifier).entrySet().stream().collect(Collectors.toMap(
              // the key entries here are the concentration risk identifiers of the sensitivity
              Map.Entry::getKey, k -> {
                // most of the time, the threshold is based on the bucket and so we make out threshold identifier be the bucket name
                // for the FX risk class, however, thresholds are over the currencies (i.e. the qualifier of the sensitivity)
                String identifier = riskClass.equals(RiskClass.FX) ? k.getKey().getQualifier() : e.getKey().getBucketName();
                return ConcentrationRiskGroup.build(k.getKey(), identifier, k.getValue(), config);
              }))));

      List<BucketMargin> marginByBucket = mapByBucket.entrySet().stream()
          .map(e -> BucketMargin.calculate(riskClass, sensitivityClass, e.getKey(), e.getValue(), classes.get(e.getKey()), config)).collect(Collectors.toList());
      Map<BucketClass, BucketMargin> mappedMarginByBucket = marginByBucket.stream().collect(Collectors.toMap(BucketMargin::getBucketClass, Function.identity()));
      List<BucketMargin> nonResidual = filterForResiduals(marginByBucket, true);
      List<BucketMargin> residual = filterForResiduals(marginByBucket, false);
      BigDecimal nonResCrossSumSquared = BigDecimalUtils.sumSquared(nonResidual, BucketMargin::getMargin);
      BigDecimal resCrossSumSquared = BigDecimalUtils.sumSquared(residual, BucketMargin::getMargin);
      BigDecimal nonResCrossCorrelation = sumCorrelatedForBucket(nonResidual, filterForResiduals(mapByBucket, true), (s) -> {
        // we use this "convert" function to re-weight our input sensitivities
        // thus, just as at the BucketMargin level, we have to make sure not to CR weight the Xccy Basis sensitivities
        if (StringUtils.equalsIgnoreCase(s.getRiskType(), RiskClass.RISK_TYPE_XCCY_BASIS)) {
          return ConcentrationRiskGroup.buildWithConcentrationOfOne(null);
        } else {
          return classes.get(s.getBucketIdentifier()).get(s.getConcentrationRiskIdentifier());
        }
      }, (r, s) -> {
        ConcentrationRiskGroup one = mappedMarginByBucket.get(r).getBucketConcentrationClass();
        ConcentrationRiskGroup other = mappedMarginByBucket.get(s).getBucketConcentrationClass();
        BigDecimal concentrationCorrelation = ConcentrationRiskGroup.correlateClasses(one, other);
        BigDecimal correlation = SimmBucketCorrelation.get(riskClass, r, s, config);
        return concentrationCorrelation.multiply(correlation);
      }, config);

      BigDecimal total = BigDecimalUtils.sqrt(nonResCrossSumSquared.add(nonResCrossCorrelation)).add(BigDecimalUtils.sqrt(resCrossSumSquared));
      return new SensitivityMargin(sensitivityClass, total, new ArrayList<>(marginByBucket));
    }
  }

  private static SensitivityMargin calculateForBaseCorr(List<Sensitivity> sensitivities, SimmConfig config) {
    List<WeightingMargin> weighted = BucketMargin.getWeightingMargin(sensitivities, s -> ConcentrationRiskGroup.buildWithConcentrationOfOne(null), config);

    BigDecimal sumSquared = BigDecimalUtils.sumSquared(weighted, WeightingMargin::getMargin);
    BiFunction<WeightingClass, WeightingClass, BigDecimal> correlate = (r, s) -> SimmSensitivityCorrelationBaseCorr.get(RiskClass.CREDIT_QUALIFYING, r, s, config);
    BigDecimal sumCorrelated = MarginUtils.sumCorrelated(weighted, WeightingMargin::getMargin, correlate);
    BigDecimal total = BigDecimalUtils.sqrt(sumSquared.add(sumCorrelated));
    return new SensitivityMargin(SensitivityClass.BASECORR, total, new ArrayList<>());
  }

  private static SensitivityMargin calculateForCurvature(RiskClass riskClass, List<Sensitivity> sensitivities, SimmConfig config) {
    // there is no concentration risk for curvature margin so we use the concentration risk
    ConcentrationRiskGroup one = ConcentrationRiskGroup.buildWithConcentrationOfOne(null);
    Map<BucketClass, List<Sensitivity>> mapByBucketClass = ListUtils.groupBy(sensitivities, SensitivityIdentifier::getBucketIdentifier);
    List<BucketMargin> margins = mapByBucketClass.entrySet().stream()
        .map(entry -> BucketMargin.calculate(riskClass, SensitivityClass.CURVATURE, entry.getKey(), entry.getValue(), one, config)).collect(Collectors.toList());
    BigDecimal nonResMargin = calculateCurvatureMarginPart(riskClass, margins, mapByBucketClass, one, config, true);
    BigDecimal resMargin = calculateCurvatureMarginPart(riskClass, margins, mapByBucketClass, one, config, false);

    if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      // the interest rate curvature class is multiplied by a factor of HVR_{IR}^{-2}
      BigDecimal hvr = SimmHvr.get(RiskClass.INTEREST_RATE, config.holdingPeriod());
      BigDecimal factor = BigDecimalUtils.divideWithPrecision(BigDecimal.ONE, hvr.multiply(hvr));
      return new SensitivityMargin(SensitivityClass.CURVATURE, factor.multiply(nonResMargin.add(resMargin)), new ArrayList<>(margins));
    } else {
      return new SensitivityMargin(SensitivityClass.CURVATURE, nonResMargin.add(resMargin), new ArrayList<>(margins));
    }
  }

  private static BigDecimal calculateCurvatureMarginPart(RiskClass riskClass, List<BucketMargin> margins, Map<BucketClass, List<Sensitivity>> mapByBucketClass,
      ConcentrationRiskGroup one, SimmConfig config, boolean removeResidual) {
    List<BucketMargin> filtered = filterForResiduals(margins, removeResidual);
    BigDecimal crossBucketSumSquared = BigDecimalUtils.sumSquared(filtered, BucketMargin::getMargin);

    // there is only one bucket in residual bucket so we don't bother calculating correlations
    BigDecimal crossBucketCorrelation = BigDecimal.ZERO;
    if (removeResidual)
      crossBucketCorrelation = sumCorrelatedForBucket(filtered, filterForResiduals(mapByBucketClass, removeResidual), (s) -> one,
          (r, s) -> BigDecimalUtils.square(SimmBucketCorrelation.get(riskClass, r, s, config)), config);

    List<Sensitivity> allSensitivities = filterForResiduals(mapByBucketClass, removeResidual).values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    List<WeightingMargin> weighted = BucketMargin.getWeightingMargin(allSensitivities, s -> one, config);
    BigDecimal lambda = calculateLambda(weighted);
    BigDecimal rhs = lambda.multiply(BigDecimalUtils.sqrt(crossBucketSumSquared.add(crossBucketCorrelation)));
    BigDecimal lhs = BigDecimalUtils.sum(weighted, WeightingMargin::getMargin);
    return BigDecimal.ZERO.max(lhs.add(rhs));
  }

  // UTIL FUNCTIONS

  private static Function<BucketMargin, BigDecimal> getSMargin(Map<BucketClass, BigDecimal> sValue) {
    return margin -> sValue.get(margin.getBucketClass());
  }

  private static BigDecimal sumCorrelatedForBucket(List<BucketMargin> margins, Map<BucketClass, List<Sensitivity>> sensitivitiesByBucket,
      Function<SensitivityIdentifier, ConcentrationRiskGroup> convert, BiFunction<BucketClass, BucketClass, BigDecimal> correlate, SimmConfig config) {
    Map<BucketClass, BucketMargin> marginByBucket = margins.stream().collect(Collectors.toMap(BucketMargin::getBucketClass, Function.identity()));
    Map<BucketClass, BigDecimal> sValue = sensitivitiesByBucket.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> {
      BigDecimal sum = BigDecimalUtils.sum(BucketMargin.getWeightingMargin(e.getValue(), convert, config), WeightingMargin::getMargin);
      BigDecimal bucketMargin = marginByBucket.get(e.getKey()).getMargin();
      return sum.min(bucketMargin).max(bucketMargin.negate());
    }));
    return MarginUtils.sumCorrelated(margins, getSMargin(sValue), correlate);
  }

  private static List<BucketMargin> filterForResiduals(List<BucketMargin> margins, boolean removeResiduals) {
    return margins.stream().filter(b -> BucketType.isResidualBucket(b.getBucketClass().getBucketType()) != removeResiduals).collect(Collectors.toList());
  }

  private static Map<BucketClass, List<Sensitivity>> filterForResiduals(Map<BucketClass, List<Sensitivity>> margins, boolean removeResiduals) {
    return margins.entrySet().stream().filter(e -> BucketType.isResidualBucket(e.getKey().getBucketType()) != removeResiduals)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  private static BigDecimal calculateLambda(List<WeightingMargin> weighted) {
    BigDecimal theta = calculateTheta(weighted);
    return (BigDecimalUtils.square(PHI_INV).subtract(ONE)).multiply(ONE.add(theta)).subtract(theta);
  }

  private static BigDecimal calculateTheta(List<WeightingMargin> weighted) {
    BigDecimal sumOfRiskExposures = BigDecimalUtils.sum(weighted, WeightingMargin::getMargin);
    BigDecimal sumOfAbsRiskExposures = BigDecimalUtils.sum(weighted, m -> m.getMargin().abs());

    // need to check to make sure that sums are not equal to zero
    if (sumOfAbsRiskExposures.stripTrailingZeros().equals(BigDecimal.ZERO)) {
      return BigDecimal.ZERO;
    } else {
      BigDecimal quotient = BigDecimalUtils.divideWithPrecision(sumOfRiskExposures, sumOfAbsRiskExposures);
      return quotient.min(BigDecimal.ZERO);
    }
  }

}
