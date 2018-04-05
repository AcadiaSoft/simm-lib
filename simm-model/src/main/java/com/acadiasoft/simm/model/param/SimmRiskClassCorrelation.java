package com.acadiasoft.simm.model.param;

import com.acadiasoft.simm.model.object.imtree.identifiers.RiskClass;
import com.acadiasoft.simm.model.param.risk.RiskClassCorrelationV2_0;

import java.math.BigDecimal;

public interface SimmRiskClassCorrelation {

  public static BigDecimal get(RiskClass r, RiskClass s) {
    return new RiskClassCorrelationV2_0().getRiskClassCorrelation(r, s);
  }

  public BigDecimal getRiskClassCorrelation(RiskClass r, RiskClass s);

}
