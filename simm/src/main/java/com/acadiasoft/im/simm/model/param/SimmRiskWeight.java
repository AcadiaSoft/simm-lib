/*
 * Copyright (c) 2018 AcadiaSoft, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.acadiasoft.im.simm.model.param;

import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.cnq.CreditNonQualifyingRiskWeightV2_1;
import com.acadiasoft.im.simm.model.param.commodity.CommodityRiskWeightV2_1;
import com.acadiasoft.im.simm.model.param.cq.CreditQualifyingRiskWeightV2_1;
import com.acadiasoft.im.simm.model.param.equity.EquityRiskWeightV2_1;
import com.acadiasoft.im.simm.model.param.fx.FXRiskWeightV2_1;
import com.acadiasoft.im.simm.model.param.interestrate.InterestRateRiskWeightV2_1;

import java.math.BigDecimal;

public interface SimmRiskWeight {

  public static BigDecimal get(SensitivityClass s, WeightingClass weightingClass) {
    RiskClass r = weightingClass.getRiskClass();
    if (s.equals(SensitivityClass.DELTA)) {
      return fromRiskClass(r).getDeltaRiskWeight(weightingClass);
    } else if (s.equals(SensitivityClass.VEGA)) {
      return fromRiskClass(r).getVegaRiskWeight(weightingClass);
    } else if (s.equals(SensitivityClass.CURVATURE)) {
      return BigDecimal.ONE;
    } else if (s.equals(SensitivityClass.BASECORR)) {
      return SimmRiskWeightBaseCorr.get(weightingClass);
    } else {
      throw new IllegalStateException("tried to get risk weight for unexpected sensitivity type: " + s + "]!");
    }
  }

  public static SimmRiskWeight fromRiskClass(RiskClass riskClass) {
    if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      return new InterestRateRiskWeightV2_1();
    } else if (riskClass.equals(RiskClass.CREDIT_QUALIFYING)) {
      return new CreditQualifyingRiskWeightV2_1();
    } else if (riskClass.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return new CreditNonQualifyingRiskWeightV2_1();
    } else if (riskClass.equals(RiskClass.EQUITY)) {
      return new EquityRiskWeightV2_1();
    } else if (riskClass.equals(RiskClass.COMMODITY)) {
      return new CommodityRiskWeightV2_1();
    } else if (riskClass.equals(RiskClass.FX)) {
      return new FXRiskWeightV2_1();
    } else {
      throw new IllegalStateException("tried to get a threshold for unknown risk class: [" + riskClass + "]!");
    }
  }

  public BigDecimal getDeltaRiskWeight(WeightingClass weightingClass);

  public BigDecimal getVegaRiskWeight(WeightingClass weightingClass);

}
