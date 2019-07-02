package com.acadiasoft.im.simm.model.param.commodity;

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketType;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CommodityOneDayRiskWeightV2_1 implements SimmRiskWeight {

  private static final Map<BucketType, BigDecimal> WEIGHTS = new HashMap<>();

  static {
    WEIGHTS.put(BucketType.CM1, new BigDecimal("5.7"));
    WEIGHTS.put(BucketType.CM2, new BigDecimal("8.4"));
    WEIGHTS.put(BucketType.CM3, new BigDecimal("6.5"));
    WEIGHTS.put(BucketType.CM4, new BigDecimal("6.8"));
    WEIGHTS.put(BucketType.CM5, new BigDecimal("10"));
    WEIGHTS.put(BucketType.CM6, new BigDecimal("7.5"));
    WEIGHTS.put(BucketType.CM7, new BigDecimal("7.9"));
    WEIGHTS.put(BucketType.CM8, new BigDecimal("16"));
    WEIGHTS.put(BucketType.CM9, new BigDecimal("6.7"));
    WEIGHTS.put(BucketType.CM10, new BigDecimal("12"));
    WEIGHTS.put(BucketType.CM11, new BigDecimal("6.4"));
    WEIGHTS.put(BucketType.CM12, new BigDecimal("6.0"));
    WEIGHTS.put(BucketType.CM13, new BigDecimal("5.5"));
    WEIGHTS.put(BucketType.CM14, new BigDecimal("4.7"));
    WEIGHTS.put(BucketType.CM15, new BigDecimal("3.1"));
    WEIGHTS.put(BucketType.CM16, new BigDecimal("16"));
    WEIGHTS.put(BucketType.CM17, new BigDecimal("4.7"));
  }

  private static final BigDecimal VEGA = new BigDecimal("0.097");

  @Override
  public BigDecimal getDeltaRiskWeight(WeightingClass s) {
    return WEIGHTS.get(s.getBucketIdentifier().getBucketType());
  }

  @Override
  public BigDecimal getVegaRiskWeight(WeightingClass s) {
    return VEGA;
  }
}
