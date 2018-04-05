package com.acadiasoft.simm.model.param;

import com.acadiasoft.simm.model.object.imtree.identifiers.WeightingClass;
import com.acadiasoft.simm.model.param.cq.BaseCorrRiskV2_0;

import java.math.BigDecimal;

public interface SimmRiskWeightBaseCorr {

  public static BigDecimal get(WeightingClass weightingClass) {
    return new BaseCorrRiskV2_0().getRiskWeight(weightingClass);
  }

  public BigDecimal getRiskWeight(WeightingClass w);

}
