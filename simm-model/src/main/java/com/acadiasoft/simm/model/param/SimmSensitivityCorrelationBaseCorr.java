package com.acadiasoft.simm.model.param;

import com.acadiasoft.simm.model.object.imtree.identifiers.RiskClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.WeightingClass;
import com.acadiasoft.simm.model.param.cq.BaseCorrRiskV2_0;

import java.math.BigDecimal;

public interface SimmSensitivityCorrelationBaseCorr {

  public static BigDecimal get(RiskClass riskClass, WeightingClass r, WeightingClass s) {
    return new BaseCorrRiskV2_0().getSensitivityCorrelation(r, s);
  }

  public BigDecimal getSensitivityCorrelation(WeightingClass r, WeightingClass s);

}
