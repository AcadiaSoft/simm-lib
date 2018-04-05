package com.acadiasoft.simm.engine.margin;

import com.acadiasoft.simm.model.object.ConcentrationRiskGroup;
import com.acadiasoft.simm.model.object.imtree.ImTree;
import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import com.acadiasoft.simm.model.object.imtree.identifiers.BucketClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.RiskClass;
import com.acadiasoft.simm.model.param.SimmSensitivityCorrelation;
import com.acadiasoft.simm.model.object.Sensitivity;
import com.acadiasoft.simm.model.object.imtree.identifiers.SensitivityClass;
import com.acadiasoft.simm.model.util.BigDecimalUtils;
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

  private BucketMargin(RiskClass riskClass, SensitivityClass sensitivityClass, BucketClass bucketClass, BigDecimal margin, List<WeightingMargin> marginByIdentifier, ConcentrationRiskGroup concentrationRiskClass) {
    this.riskClass = riskClass;
    this.sensitivityClass = sensitivityClass;
    this.bucketClass = bucketClass;
    this.margin = margin;
    this.concentrationRiskClass = Optional.of(concentrationRiskClass);
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
      ConcentrationRiskGroup concentrationRiskClass = (ConcentrationRiskGroup) concentrationClasses.values().toArray()[0]; // TODO: better way to do this?
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
