package com.acadiasoft.simm.engine.margin;

import com.acadiasoft.simm.model.object.ConcentrationRiskGroup;
import com.acadiasoft.simm.model.object.imtree.ImTree;
import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import com.acadiasoft.simm.model.object.imtree.identifiers.BucketClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.BucketType;
import com.acadiasoft.simm.model.object.imtree.identifiers.RiskClass;
import com.acadiasoft.simm.model.param.SimmBucketCorrelation;
import com.acadiasoft.simm.model.object.Sensitivity;
import com.acadiasoft.simm.model.object.imtree.identifiers.SensitivityClass;
import com.acadiasoft.simm.model.param.SimmSensitivityCorrelationBaseCorr;
import com.acadiasoft.simm.model.util.SensitivityUtils;
import com.acadiasoft.simm.model.util.BigDecimalUtils;
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
  private static final BigDecimal PHI_INV = new BigDecimal(Math.sqrt(2.0) * Erf.erfInv(2 * .995 - 1));
  public static final BigDecimal IR_CURVATURE_MULTIPLIER = new BigDecimal("2.3");


  private final static String LEVEL = "5.Sensitivity Type";
  private final BigDecimal margin;
  private final SensitivityClass sensitivityClass;
  private final List<BucketMargin> children = new ArrayList<>();

  private SensitivityMargin(SensitivityClass sensitivityClass, BigDecimal margin, List<BucketMargin> marginByBucket) {
    this.sensitivityClass = sensitivityClass;
    this.margin = margin;
    this.children.addAll(marginByBucket);
  }

  public static SensitivityMargin calculate(RiskClass riskClass, SensitivityClass sensitivityClass, List<Sensitivity> sensitivities) {
    if (sensitivityClass.equals(SensitivityClass.BASECORR)) {
      return calculateForBaseCorr(sensitivities);
    } else if (sensitivityClass.equals(SensitivityClass.CURVATURE)) {
      return calculateForCurvature(riskClass, sensitivities);
    } else {
      Map<BucketClass, List<Sensitivity>> mapByBucket = SensitivityUtils.mapByIdentifier(s -> s.getBucketIdentifier(), sensitivities);
      Map<BucketClass, Map<String, ConcentrationRiskGroup>> classes = mapByBucket.entrySet().stream()
          .collect(Collectors.toMap(
              Map.Entry::getKey,
              e -> SensitivityUtils.mapByIdentifier(s -> s.getConcentrationRiskIdentifier(), e.getValue()).entrySet().stream()
                  .collect(Collectors.toMap(
                      Map.Entry::getKey,
                      k -> {
                        // most of the time, the threshold is based on the bucket and so we make out threshold identifier be the bucket name
                        // for the FX risk class, however, thresholds are over the currencies (i.e. the qualifier of the sensitivity)
                        // so for FX risk class we set identifier to the concentration identifier which is exactly the qualifier as the qualifiers
                        // of FX sensitivities give us a
                        String identifier = e.getKey().getBucketName();
                        if (riskClass.equals(RiskClass.FX)) identifier = k.getKey();
                        return ConcentrationRiskGroup.build(riskClass, sensitivityClass, identifier, k.getValue());
                      }
                  ))
          ));

      List<BucketMargin> marginByBucket = SensitivityUtils.listByMargin(
          e -> BucketMargin.calculate(riskClass, sensitivityClass, e.getKey(), e.getValue(), classes.get(e.getKey())),
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
          }
      );

      BigDecimal total = BigDecimalUtils.sqrt(nonResCrossSumSquared.add(nonResCrossCorrelation)).add(BigDecimalUtils.sqrt(resCrossSumSquared));
      return new SensitivityMargin(sensitivityClass, total, marginByBucket);
    }
  }

  private static SensitivityMargin calculateForBaseCorr(List<Sensitivity> sensitivities) {
    List<WeightingMargin> weighted = BucketMargin.getWeightingMargin(
        sensitivities,
        s -> ConcentrationRiskGroup.buildWithConcentrationOfOne(RiskClass.CREDIT_QUALIFYING, SensitivityClass.BASECORR, SensitivityClass.BASECORR.getLabel())
    );

    BigDecimal sumSquared = BigDecimalUtils.sumSquared(weighted, (m) -> m.getMargin());
    BiFunction<WeightingMargin, WeightingMargin, BigDecimal> correlate = (r, s) -> SimmSensitivityCorrelationBaseCorr.get(RiskClass.CREDIT_QUALIFYING, r.getWeightingClass(), s.getWeightingClass());
    BigDecimal sumCorrelated = BucketMargin.sumCorrelatedForWeight(weighted, correlate);
    BigDecimal total = BigDecimalUtils.sqrt(sumSquared.add(sumCorrelated));
    return new SensitivityMargin(SensitivityClass.BASECORR, total, new ArrayList<>());
  }

  private static SensitivityMargin calculateForCurvature(RiskClass riskClass, List<Sensitivity> sensitivities) {
    ConcentrationRiskGroup one = ConcentrationRiskGroup.buildWithConcentrationOfOne(riskClass, SensitivityClass.CURVATURE, SensitivityClass.CURVATURE.getLabel());
    Map<BucketClass, List<Sensitivity>> mapByBucketClass = SensitivityUtils.mapByIdentifier(s -> s.getBucketIdentifier(), sensitivities);
    List<BucketMargin> margins = SensitivityUtils.listByMargin(e -> BucketMargin.calculate(riskClass, SensitivityClass.CURVATURE, e.getKey(), e.getValue(), one), mapByBucketClass);
    BigDecimal nonResMargin = calculateCurvatureMarginPart(riskClass, margins, mapByBucketClass, one,true);
    BigDecimal resMargin = calculateCurvatureMarginPart(riskClass, margins, mapByBucketClass, one, false);

    if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      return new SensitivityMargin(SensitivityClass.CURVATURE, IR_CURVATURE_MULTIPLIER.multiply(nonResMargin.add(resMargin)), margins);
    } else {
      return new SensitivityMargin(SensitivityClass.CURVATURE, nonResMargin.add(resMargin), margins);
    }
  }

  private static BigDecimal calculateCurvatureMarginPart(RiskClass riskClass, List<BucketMargin> margins, Map<BucketClass, List<Sensitivity>> mapByBucketClass, ConcentrationRiskGroup one, boolean removeResidual) {
    List<BucketMargin> filtered = filterForResiduals(margins, removeResidual);
    BigDecimal crossBucketSumSquared = BigDecimalUtils.sumSquared(filtered, m -> m.getMargin());

    // there is only one bucket in residual bucket so we don't bother calculating correlations
    BigDecimal crossBucketCorrelation = BigDecimal.ZERO;
    if (removeResidual) crossBucketCorrelation = sumCorrelatedForBucket(
        filtered,
        filterForResiduals(mapByBucketClass, removeResidual),
        (s) -> one,
        (r, s) -> BigDecimalUtils.square(SimmBucketCorrelation.get(riskClass, r.getBucketClass(), s.getBucketClass()))
    );

    List<Sensitivity> allSensitivities = filterForResiduals(mapByBucketClass, removeResidual).values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    List<WeightingMargin> Weighted = BucketMargin.getWeightingMargin(allSensitivities, s -> one);
    BigDecimal lambda = calculateLambda(Weighted);
    BigDecimal rhs = lambda.multiply(BigDecimalUtils.sqrt(crossBucketSumSquared.add(crossBucketCorrelation)));
    BigDecimal lhs = BigDecimalUtils.sum(Weighted, m -> m.getMargin());
    return lhs.add(rhs).max(BigDecimal.ZERO);
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

  private static BigDecimal sumCorrelatedForBucket(List<BucketMargin> margins, Map<BucketClass, List<Sensitivity>> sensitivitiesByBucket, Function<Sensitivity, ConcentrationRiskGroup> convert, BiFunction<BucketMargin, BucketMargin, BigDecimal> correlate) {
    Map<BucketClass, BucketMargin> marginByBucket = margins.stream().collect(Collectors.toMap(b -> b.getBucketClass(), b -> b));
    Map<BucketClass, BigDecimal> sValue = sensitivitiesByBucket.entrySet().stream().collect(Collectors.toMap(
        e -> e.getKey(),
        e -> {
          BigDecimal sum = BigDecimalUtils.sum(BucketMargin.getWeightingMargin(e.getValue(), convert), m -> m.getMargin());
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
    return BigDecimalUtils.square(PHI_INV).subtract(ONE).multiply(ONE.add(theta)).subtract(theta);
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

