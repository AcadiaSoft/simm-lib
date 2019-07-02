package com.acadiasoft.im.simm.model.param.fx;

import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;

import java.math.BigDecimal;

public class FXRiskOneDayWeightV2_1 implements SimmRiskWeight {

  private static final BigDecimal ALL = new BigDecimal("2.0");
  private static final BigDecimal VEGA = new BigDecimal("0.079");

  @Override
  public BigDecimal getDeltaRiskWeight(WeightingClass s) {
    // only one bucket for all currencies in FX org.acadiasoft.simm.model.risk class
    return ALL;
  }

  @Override
  public BigDecimal getVegaRiskWeight(WeightingClass s) {
    return VEGA;
  }

}
