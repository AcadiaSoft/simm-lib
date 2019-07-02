package com.acadiasoft.im.simm.model.param.equity;

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketType;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class EquityRiskOneDayWeightV2_1 implements SimmRiskWeight {

  private static final Map<BucketType, BigDecimal> WEIGHTS = new HashMap<>();

  static {
    WEIGHTS.put(BucketType.EQ1, new BigDecimal("8.3"));
    WEIGHTS.put(BucketType.EQ2, new BigDecimal("10"));
    WEIGHTS.put(BucketType.EQ3, new BigDecimal("10"));
    WEIGHTS.put(BucketType.EQ4, new BigDecimal("8.6"));
    WEIGHTS.put(BucketType.EQ5, new BigDecimal("7.1"));
    WEIGHTS.put(BucketType.EQ6, new BigDecimal("7.4"));
    WEIGHTS.put(BucketType.EQ7, new BigDecimal("9.2"));
    WEIGHTS.put(BucketType.EQ8, new BigDecimal("8.7"));
    WEIGHTS.put(BucketType.EQ9, new BigDecimal("10"));
    WEIGHTS.put(BucketType.EQ10, new BigDecimal("11"));
    WEIGHTS.put(BucketType.EQ11, new BigDecimal("6.4"));
    WEIGHTS.put(BucketType.EQ12, new BigDecimal("6.4"));
    WEIGHTS.put(BucketType.EQRESIDUAL, new BigDecimal("11"));
  }

  private static final BigDecimal VEGA = new BigDecimal("0.075");
  private static final BigDecimal VEGA12 = new BigDecimal("0.19");

  @Override
  public BigDecimal getDeltaRiskWeight(WeightingClass s) {
    return WEIGHTS.get(s.getBucketIdentifier().getBucketType());
  }

  @Override
  public BigDecimal getVegaRiskWeight(WeightingClass s) {
    if (s.getBucket().equals("12")) {
      // bucket 12 has its own VRW as per doc/ISDA-SIMM-v1.3.38 paragraph 57
      return VEGA12;
    } else {
      return VEGA;
    }
  }

}
