package com.acadiasoft.im.simm.model.param.cq;

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketType;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CreditQualifyingOneDayRiskWeightV2_1 implements SimmRiskWeight {

  private static final Map<BucketType, BigDecimal> WEIGHTS = new HashMap<>();

  static {
    WEIGHTS.put(BucketType.CRQ1, new BigDecimal("19"));
    WEIGHTS.put(BucketType.CRQ2, new BigDecimal("25"));
    WEIGHTS.put(BucketType.CRQ3, new BigDecimal("17"));
    WEIGHTS.put(BucketType.CRQ4, new BigDecimal("13"));
    WEIGHTS.put(BucketType.CRQ5, new BigDecimal("12"));
    WEIGHTS.put(BucketType.CRQ6, new BigDecimal("9.9"));
    WEIGHTS.put(BucketType.CRQ7, new BigDecimal("40"));
    WEIGHTS.put(BucketType.CRQ8, new BigDecimal("40"));
    WEIGHTS.put(BucketType.CRQ9, new BigDecimal("33"));
    WEIGHTS.put(BucketType.CRQ10, new BigDecimal("38"));
    WEIGHTS.put(BucketType.CRQ11, new BigDecimal("29"));
    WEIGHTS.put(BucketType.CRQ12, new BigDecimal("31"));
    WEIGHTS.put(BucketType.CRQRESIDUAL, new BigDecimal("40"));
  }

  private static final BigDecimal VEGA = new BigDecimal("0.07");

  @Override
  public BigDecimal getDeltaRiskWeight(WeightingClass s) {
    return WEIGHTS.get(s.getBucketIdentifier().getBucketType());
  }

  @Override
  public BigDecimal getVegaRiskWeight(WeightingClass s) {
    return VEGA;
  }

}
