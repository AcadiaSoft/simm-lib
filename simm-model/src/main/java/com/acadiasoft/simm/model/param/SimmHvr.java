package com.acadiasoft.simm.model.param;

import com.acadiasoft.simm.model.object.Sensitivity;
import com.acadiasoft.simm.model.object.imtree.identifiers.RiskClass;

import java.math.BigDecimal;

public interface SimmHvr {

  BigDecimal CM_HVR = new BigDecimal("0.80");
  BigDecimal EQ_HVR = new BigDecimal("0.65");
  BigDecimal FX_HVR = new BigDecimal("0.60");

  public static BigDecimal get(RiskClass riskClass) {
    if (riskClass.equals(RiskClass.COMMODITY)) {
      return CM_HVR;
    } else if (riskClass.equals(RiskClass.EQUITY)) {
      return EQ_HVR;
    } else if (riskClass.equals(RiskClass.FX)) {
      return FX_HVR;
    } else {
      throw new RuntimeException("tried to get HVR for non-HVR risk class: [" + riskClass + "]!");
    }
  }

}
