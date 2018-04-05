package com.acadiasoft.simm.model.param;

import com.acadiasoft.simm.model.object.imtree.identifiers.RiskClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.WeightingClass;
import com.acadiasoft.simm.model.param.cnq.CreditNonQualifyingConcentrationRiskV2_0;
import com.acadiasoft.simm.model.param.cnq.CreditNonQualifyingCorrelationV2_0;
import com.acadiasoft.simm.model.param.commodity.CommodityConcentrationRiskV2_0;
import com.acadiasoft.simm.model.param.commodity.CommodityCorrelationV2_0;
import com.acadiasoft.simm.model.param.cq.CreditQualifyingConcentrationRiskV2_0;
import com.acadiasoft.simm.model.param.cq.CreditQualifyingCorrelationV2_0;
import com.acadiasoft.simm.model.param.equity.EquityConcentrationRiskV2_0;
import com.acadiasoft.simm.model.param.equity.EquityCorrelationV2_0;
import com.acadiasoft.simm.model.param.fx.FXConcentrationRiskV2_0;
import com.acadiasoft.simm.model.param.fx.FXCorrelationV2_0;
import com.acadiasoft.simm.model.param.interestrate.InterestRateConcentrationRiskV2_0;
import com.acadiasoft.simm.model.param.interestrate.InterestRateCorrelationV2_0;

import java.math.BigDecimal;

public interface SimmSensitivityCorrelation {

  public static BigDecimal get(RiskClass riskClass, WeightingClass r, WeightingClass s) {
    if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      return new InterestRateCorrelationV2_0().getSensitivityCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.CREDIT_QUALIFYING)) {
      return new CreditQualifyingCorrelationV2_0().getSensitivityCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return new CreditNonQualifyingCorrelationV2_0().getSensitivityCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.EQUITY)) {
      return new EquityCorrelationV2_0().getSensitivityCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.COMMODITY)) {
      return new CommodityCorrelationV2_0().getSensitivityCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.FX)) {
      return new FXCorrelationV2_0().getSensitivityCorrelation(r, s);
    } else {
      throw new IllegalStateException("tried to get a threshold for unknown risk class: [" + riskClass + "]!");
    }
  }

  public BigDecimal getSensitivityCorrelation(WeightingClass r, WeightingClass s);

}
