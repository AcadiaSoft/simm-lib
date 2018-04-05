package com.acadiasoft.simm.model.param;

import com.acadiasoft.simm.model.object.imtree.identifiers.RiskClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.SensitivityClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.WeightingClass;
import com.acadiasoft.simm.model.param.cnq.CreditNonQualifyingRiskWeightV2_0;
import com.acadiasoft.simm.model.param.commodity.CommodityRiskWeightV2_0;
import com.acadiasoft.simm.model.param.cq.CreditQualifyingRiskWeightV2_0;
import com.acadiasoft.simm.model.param.equity.EquityRiskWeightV2_0;
import com.acadiasoft.simm.model.param.fx.FXRiskWeightV2_0;
import com.acadiasoft.simm.model.param.interestrate.InterestRateRiskWeightV2_0;

import java.math.BigDecimal;

public interface SimmRiskWeight {

  public static BigDecimal get(SensitivityClass s, WeightingClass weightingClass) {
    RiskClass r = weightingClass.getRiskClass();
    if (s.equals(SensitivityClass.DELTA)) {
      return fromRiskClass(r).getDeltaRiskWeight(weightingClass);
    } else if (s.equals(SensitivityClass.VEGA)) {
      return fromRiskClass(r).getVegaRiskWeight(weightingClass);
    } else if (s.equals(SensitivityClass.CURVATURE)) {
      return BigDecimal.ONE;
    } else if (s.equals(SensitivityClass.BASECORR)) {
      return SimmRiskWeightBaseCorr.get(weightingClass);
    } else {
      throw new IllegalStateException("tried to get risk weight for unexpected sensitivity type: " + s + "]!");
    }
  }

  public static SimmRiskWeight fromRiskClass(RiskClass riskClass) {
    if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      return new InterestRateRiskWeightV2_0();
    } else if (riskClass.equals(RiskClass.CREDIT_QUALIFYING)) {
      return new CreditQualifyingRiskWeightV2_0();
    } else if (riskClass.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return new CreditNonQualifyingRiskWeightV2_0();
    } else if (riskClass.equals(RiskClass.EQUITY)) {
      return new EquityRiskWeightV2_0();
    } else if (riskClass.equals(RiskClass.COMMODITY)) {
      return new CommodityRiskWeightV2_0();
    } else if (riskClass.equals(RiskClass.FX)) {
      return new FXRiskWeightV2_0();
    } else {
      throw new IllegalStateException("tried to get a threshold for unknown risk class: [" + riskClass + "]!");
    }
  }

  public BigDecimal getDeltaRiskWeight(WeightingClass weightingClass);

  public BigDecimal getVegaRiskWeight(WeightingClass weightingClass);

}
