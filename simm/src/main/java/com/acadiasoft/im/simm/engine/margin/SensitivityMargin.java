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

import com.acadiasoft.im.base.imtree.ImTree;
import com.acadiasoft.im.base.imtree.identifiers.MarginIdentifier;
import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.BucketType;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;
import com.acadiasoft.im.simm.model.utils.ConcentrationRiskGroup;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.param.SimmBucketCorrelation;
import com.acadiasoft.im.simm.model.param.SimmHvr;
import com.acadiasoft.im.simm.model.param.SimmSensitivityCorrelationBaseCorr;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.simm.model.utils.SensitivityUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.special.Erf;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ONE;

public class SensitivityMargin implements ImTree {

  /**
   * Φ^−1(x) = √2 * erfinv(2x−1)
   *
   * Curvature Margin values
   */
  private static final BigDecimal PHI_INV = BigDecimal.valueOf(Math.sqrt(2.0) * Erf.erfInv(2 * .995 - 1));


  private final static String LEVEL = "5.Sensitivity Type";
  private final BigDecimal margin;
  private final SensitivityClass sensitivityClass;
  private final List<BucketMargin> children = new ArrayList<>();

  private SensitivityMargin(SensitivityClass sensitivityClass, BigDecimal margin, List<BucketMargin> marginByBucket) {
    this.sensitivityClass = sensitivityClass;
    this.margin = margin;
    this.children.addAll(marginByBucket);
  }

  public static SensitivityMargin calculate(RiskClass riskClass, SensitivityClass sensitivityClass,
                                            List<Sensitivity> sensitivities, String calculationCurrency) {
    if (sensitivityClass.equals(SensitivityClass.BASECORR)) {
      return calculateForBaseCorr(sensitivities, calculationCurrency);
    } else if (sensitivityClass.equals(SensitivityClass.CURVATURE)) {
      return calculateForCurvature(riskClass, sensitivities, calculationCurrency);
    } else {
      Map<BucketClass, List<Sensitivity>> mapByBucket = SensitivityUtils.mapByIdentifier(s -> s.getBucketIdentifier(), sensitivities);
      Map<BucketClass, Map<String, ConcentrationRiskGroup>> classes = mapByBucket.entrySet().stream()
          .collect(Collectors.toMap(
            // the key entries here are exactly the bucket classes
            Map.Entry::getKey,
            // map by identifiers creates a map where the concentration risk identifiers are the keys
            e -> SensitivityUtils.mapByIdentifier(s -> s.getConcentrationRiskIdentifier(), e.getValue()).entrySet().stream()
              .collect(Collectors.toMap(
                // the key entries here are the concentration risk identifiers of the sensitivity
                Map.Entry::getKey,
                k -> {
                  // most of the time, the threshold is based on the bucket and so we make out threshold identifier be the bucket name
                  // for the FX risk class, however, thresholds are over the currencies (i.e. the qualifier of the sensitivity)
                  String identifier = e.getKey().getBucketName(); // this is the bucket name since the
                  if (riskClass.equals(RiskClass.FX)) identifier = k.getKey(); // this is the concentration risk identifier
                  return ConcentrationRiskGroup.build(riskClass, sensitivityClass, identifier, k.getValue());
                }
              ))
          ));

      List<BucketMargin> marginByBucket = SensitivityUtils.listByMargin(
          e -> BucketMargin.calculate(riskClass, sensitivityClass, e.getKey(), e.getValue(), classes.get(e.getKey()), calculationCurrency),
          mapByBucket
      );

      List<BucketMargin> nonResidual = filterForResiduals(marginByBucket, true);
      List<BucketMargin> residual = filterForResiduals(marginByBucket, false);
      BigDecimal nonResCrossSumSquared = BigDecimalUtils.sumSquared(nonResidual, m -> m.getMargin());
      BigDecimal resCrossSumSquared = BigDecimalUtils.sumSquared(residual, m -> m.getMargin());
      BigDecimal nonResCrossCorrelation = sumCorrelatedForBucket(
          nonResidual,
          filterForResiduals(mapByBucket, true),
          (s) -> {
            // we use this "convert" function to re-weight our input sensitivities
            // thus, just as at the BucketMargin level, we have to make sure not to CR weight the Xccy Basis sensitivities
            if (StringUtils.equalsIgnoreCase(s.getRiskType(), RiskClass.RISK_TYPE_XCCY_BASIS)) {
              return ConcentrationRiskGroup.buildWithConcentrationOfOne(riskClass, sensitivityClass, s.getConcentrationRiskIdentifier());
            } else {
              return classes.get(s.getBucketIdentifier()).get(s.getConcentrationRiskIdentifier());
            }
          },
          (r, s) -> {
            BigDecimal concentrationCorrelation = ConcentrationRiskGroup.correlateClasses(r.getBucketConcentrationClass(), s.getBucketConcentrationClass());
            BigDecimal correlation = SimmBucketCorrelation.get(riskClass, r.getBucketClass(), s.getBucketClass());
            return concentrationCorrelation.multiply(correlation);
          },
          calculationCurrency
      );

      BigDecimal total = BigDecimalUtils.sqrt(nonResCrossSumSquared.add(nonResCrossCorrelation)).add(BigDecimalUtils.sqrt(resCrossSumSquared));
      return new SensitivityMargin(sensitivityClass, total, marginByBucket);
    }
  }

  private static SensitivityMargin calculateForBaseCorr(List<Sensitivity> sensitivities, String calculationCurrency) {
    List<WeightingMargin> weighted = BucketMargin.getWeightingMargin(
        sensitivities,
        s -> ConcentrationRiskGroup.buildWithConcentrationOfOne(RiskClass.CREDIT_QUALIFYING, SensitivityClass.BASECORR, SensitivityClass.BASECORR.getLabel()),
        calculationCurrency
    );

    BigDecimal sumSquared = BigDecimalUtils.sumSquared(weighted, (m) -> m.getMargin());
    BiFunction<WeightingMargin, WeightingMargin, BigDecimal> correlate = (r, s) -> SimmSensitivityCorrelationBaseCorr.get(RiskClass.CREDIT_QUALIFYING, r.getWeightingClass(), s.getWeightingClass());
    BigDecimal sumCorrelated = BucketMargin.sumCorrelatedForWeight(weighted, correlate);
    BigDecimal total = BigDecimalUtils.sqrt(sumSquared.add(sumCorrelated));
    return new SensitivityMargin(SensitivityClass.BASECORR, total, new ArrayList<>());
  }

  private static SensitivityMargin calculateForCurvature(RiskClass riskClass, List<Sensitivity> sensitivities, String calculationCurrency) {
    // there is no concentration risk for curvatire margin so we use the concentration risk
    ConcentrationRiskGroup one = ConcentrationRiskGroup.buildWithConcentrationOfOne(riskClass, SensitivityClass.CURVATURE, SensitivityClass.CURVATURE.getLabel());
    Map<BucketClass, List<Sensitivity>> mapByBucketClass = SensitivityUtils.mapByIdentifier(s -> s.getBucketIdentifier(), sensitivities);
    List<BucketMargin> margins = SensitivityUtils.listByMargin(e ->
      BucketMargin.calculate(riskClass, SensitivityClass.CURVATURE, e.getKey(), e.getValue(), one, calculationCurrency), mapByBucketClass);
    BigDecimal nonResMargin = calculateCurvatureMarginPart(riskClass, margins, mapByBucketClass, one, calculationCurrency,true);
    BigDecimal resMargin = calculateCurvatureMarginPart(riskClass, margins, mapByBucketClass, one, calculationCurrency, false);

    if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      // the interest rate curvature class is multiplied by a factor of HVR_{IR}^{-2}
      BigDecimal hvr = SimmHvr.get(RiskClass.INTEREST_RATE);
      BigDecimal factor = BigDecimalUtils.divideWithPrecision(BigDecimal.ONE, hvr.multiply(hvr));
      return new SensitivityMargin(SensitivityClass.CURVATURE, factor.multiply(nonResMargin.add(resMargin)), margins);
    } else {
      return new SensitivityMargin(SensitivityClass.CURVATURE, nonResMargin.add(resMargin), margins);
    }
  }

  private static BigDecimal calculateCurvatureMarginPart(RiskClass riskClass, List<BucketMargin> margins, Map<BucketClass,
    List<Sensitivity>> mapByBucketClass, ConcentrationRiskGroup one, String calculationCurrency, boolean removeResidual) {
    List<BucketMargin> filtered = filterForResiduals(margins, removeResidual);
    BigDecimal crossBucketSumSquared = BigDecimalUtils.sumSquared(filtered, m -> m.getMargin());

    // there is only one bucket in residual bucket so we don't bother calculating correlations
    BigDecimal crossBucketCorrelation = BigDecimal.ZERO;
    if (removeResidual) crossBucketCorrelation = sumCorrelatedForBucket(
        filtered,
        filterForResiduals(mapByBucketClass, removeResidual),
        (s) -> one,
        (r, s) -> BigDecimalUtils.square(SimmBucketCorrelation.get(riskClass, r.getBucketClass(), s.getBucketClass())),
        calculationCurrency
    );

    List<Sensitivity> allSensitivities = filterForResiduals(mapByBucketClass, removeResidual).values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    List<WeightingMargin> weighted = BucketMargin.getWeightingMargin(allSensitivities, s -> one, calculationCurrency);
    BigDecimal lambda = calculateLambda(weighted);
    BigDecimal rhs = lambda.multiply(BigDecimalUtils.sqrt(crossBucketSumSquared.add(crossBucketCorrelation)));
    BigDecimal lhs = BigDecimalUtils.sum(weighted, m -> m.getMargin());
    return BigDecimal.ZERO.max(lhs.add(rhs));
  }

  @Override
  public MarginIdentifier getMarginIdentifier() {
    return sensitivityClass;
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

  public SensitivityClass getSensitivityClass() {
    return sensitivityClass;
  }

  // UTIL FUNCTIONS

  private static BigDecimal sumCorrelatedForBucket(List<BucketMargin> margins, Map<BucketClass,
      List<Sensitivity>> sensitivitiesByBucket, Function<Sensitivity, ConcentrationRiskGroup> convert,
      BiFunction<BucketMargin, BucketMargin, BigDecimal> correlate, String calculationCurrency) {
    Map<BucketClass, BucketMargin> marginByBucket = margins.stream().collect(Collectors.toMap(b -> b.getBucketClass(), b -> b));
    Map<BucketClass, BigDecimal> sValue = sensitivitiesByBucket.entrySet().stream().collect(Collectors.toMap(
        e -> e.getKey(),
        e -> {
          BigDecimal sum = BigDecimalUtils.sum(BucketMargin.getWeightingMargin(e.getValue(), convert, calculationCurrency), m -> m.getMargin());
          BigDecimal bucketMargin = marginByBucket.get(e.getKey()).getMargin();
          return sum.min(bucketMargin).max(bucketMargin.negate());
        }));
    return BigDecimalUtils.sumCorrelated(margins, (m) -> sValue.get(m.getBucketClass()), correlate, (r, s) -> !r.getBucketClass().equals(s.getBucketClass()));
  }

  private static List<BucketMargin> filterForResiduals(List<BucketMargin> margins, boolean removeResiduals) {
    return margins.stream()
        .filter(b -> BucketType.isResidualBucket(b.getBucketClass().getBucketType()) != removeResiduals)
        .collect(Collectors.toList());
  }

  private static Map<BucketClass, List<Sensitivity>> filterForResiduals(Map<BucketClass, List<Sensitivity>> margins, boolean removeResiduals) {
    return margins.entrySet().stream()
        .filter(e -> BucketType.isResidualBucket(e.getKey().getBucketType()) != removeResiduals)
        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
  }

  private static BigDecimal calculateLambda(List<WeightingMargin> weighted) {
    BigDecimal theta = calculateTheta(weighted);
    return (BigDecimalUtils.square(PHI_INV).subtract(ONE)).multiply(ONE.add(theta)).subtract(theta);
  }

  private static BigDecimal calculateTheta(List<WeightingMargin> weighted) {
    BigDecimal sumOfRiskExposures = BigDecimalUtils.sum(weighted, m -> m.getMargin());
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

