package com.acadiasoft.simm.model.param;

import com.acadiasoft.simm.model.param.cnq.CreditNonQualifyingConcentrationRiskV2_0;
import com.acadiasoft.simm.model.param.commodity.CommodityConcentrationRiskV2_0;
import com.acadiasoft.simm.model.param.cq.CreditQualifyingConcentrationRiskV2_0;
import com.acadiasoft.simm.model.param.equity.EquityConcentrationRiskV2_0;
import com.acadiasoft.simm.model.param.fx.FXConcentrationRiskV2_0;
import com.acadiasoft.simm.model.param.interestrate.InterestRateConcentrationRiskV2_0;
import com.acadiasoft.simm.model.object.imtree.identifiers.RiskClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.SensitivityClass;

import java.math.BigDecimal;

public interface SimmConcentrationThreshold {

  static BigDecimal getThreshold(RiskClass riskClass, SensitivityClass sensitivityClass, String identifier) {
    if (sensitivityClass.equals(SensitivityClass.VEGA)) {
      return fromRiskClass(riskClass).getVegaThreshold(identifier);
    } else if (sensitivityClass.equals(SensitivityClass.DELTA)) {
      // NOTE: for FX sensitivities, the thresholds are at the sensitivity level, and identifier
      //  must be the currency (qualifier) of the sensitivity
      //  all other thresholds are at bucket level or risk class level
      return fromRiskClass(riskClass).getDeltaThreshold(identifier);
    } else {
      throw new IllegalStateException("Called getThreshold from a non-concentration risk using sensitivity type: [" + sensitivityClass + "]!");
    }
  }

  static SimmConcentrationThreshold fromRiskClass(RiskClass riskClass) {
    if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      return new InterestRateConcentrationRiskV2_0();
    } else if (riskClass.equals(RiskClass.CREDIT_QUALIFYING)) {
      return new CreditQualifyingConcentrationRiskV2_0();
    } else if (riskClass.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return new CreditNonQualifyingConcentrationRiskV2_0();
    } else if (riskClass.equals(RiskClass.EQUITY)) {
      return new EquityConcentrationRiskV2_0();
    } else if (riskClass.equals(RiskClass.COMMODITY)) {
      return new CommodityConcentrationRiskV2_0();
    } else if (riskClass.equals(RiskClass.FX)) {
      return new FXConcentrationRiskV2_0();
    } else {
      throw new IllegalStateException("tried to get a threshold for unknown risk class: [" + riskClass + "]!");
    }
  }

  public BigDecimal getDeltaThreshold(String bucketName);

  public BigDecimal getVegaThreshold(String bucketName);

}
