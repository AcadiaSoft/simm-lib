package com.acadiasoft.im.simm.model.param.cnq;

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketType;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CreditNonQualifyingOneDayRiskWeightV2_1 implements SimmRiskWeight {

  private static final Map<BucketType, BigDecimal> WEIGHTS = new HashMap<>();

  static {
    WEIGHTS.put(BucketType.CRNQ1, new BigDecimal("36"));
    WEIGHTS.put(BucketType.CRNQ2, new BigDecimal("200"));
    WEIGHTS.put(BucketType.CRNQRESIDUAL, new BigDecimal("200"));
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
