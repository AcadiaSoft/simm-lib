package com.acadiasoft.simm.engine.margin;

import com.acadiasoft.simm.model.object.ConcentrationRiskGroup;
import com.acadiasoft.simm.model.object.imtree.ImTree;
import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import com.acadiasoft.simm.model.param.SimmRiskWeight;
import com.acadiasoft.simm.model.object.Sensitivity;
import com.acadiasoft.simm.model.object.imtree.identifiers.WeightingClass;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WeightingMargin implements ImTree {

  private final String LEVEL = "7.Weighted Sensitivity";
  private final WeightingClass weightingClass;
  private final BigDecimal margin;
  private final ConcentrationRiskGroup concentrationRiskClass;

  private WeightingMargin(WeightingClass weightingClass, BigDecimal margin, ConcentrationRiskGroup concentrationRiskClass) {
    this.weightingClass = weightingClass;
    this.margin = margin;
    this.concentrationRiskClass = concentrationRiskClass;
  }

  public static WeightingMargin calculate(Sensitivity sensitivity, ConcentrationRiskGroup concentrationRiskClass) {
    WeightingClass weightingClass = WeightingClass.determineWeightingClass(sensitivity.getWeightingClassIdentifier());
    BigDecimal riskWeight = SimmRiskWeight.get(sensitivity.getSensitivityIdentifier(), weightingClass);
    BigDecimal amountUsd = sensitivity.getAmountUsd();
    BigDecimal concentrationRisk = concentrationRiskClass.getConcentrationRisk();
    return new WeightingMargin(weightingClass, riskWeight.multiply(amountUsd).multiply(concentrationRisk), concentrationRiskClass);
  }

  @Override
  public MarginIdentifier getMarginIdentifier() {
    return weightingClass;
  }

  @Override
  public BigDecimal getMargin() {
    return margin;
  }

  @Override
  public List<ImTree> getChildren() {
    return new ArrayList<>();
  }

  @Override
  public String getTreeLevel() {
    return LEVEL;
  }

  public WeightingClass getWeightingClass() {
    return weightingClass;
  }

  public ConcentrationRiskGroup getConcentrationRiskClass() {
    return concentrationRiskClass;
  }
}
