/*
 * Copyright (c) 2019 AcadiaSoft, Inc.
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
import com.acadiasoft.im.simm.model.param.cnq.CreditNonQualifyingRiskWeight;
import com.acadiasoft.im.simm.model.param.commodity.CommodityRiskWeight;
import com.acadiasoft.im.simm.model.param.cq.CreditQualifyingRiskWeight;
import com.acadiasoft.im.simm.model.param.equity.EquityRiskWeight;
import com.acadiasoft.im.simm.model.param.fx.FXRiskWeight;
import com.acadiasoft.im.simm.model.param.interestrate.InterestRateRiskWeight;

import java.math.BigDecimal;

public interface SimmRiskWeight {

  static BigDecimal get(SensitivityClass s, WeightingClass weightingClass, String calculationCurrency) {
    RiskClass r = weightingClass.getRiskClass();
    if (s.equals(SensitivityClass.DELTA)) {
      if (r.equals(RiskClass.FX)) {
        return new FXRiskWeight().getDeltaRiskWeight(weightingClass, calculationCurrency);
      } else {
        return fromRiskClass(r).getDeltaRiskWeight(weightingClass);
      }
    } else if (s.equals(SensitivityClass.VEGA)) {
      if (r.equals(RiskClass.FX)) {
        return new FXRiskWeight().getVegaRiskWeight(weightingClass, calculationCurrency);
      } else {
        return fromRiskClass(r).getVegaRiskWeight(weightingClass);
      }
    } else if (s.equals(SensitivityClass.CURVATURE)) {
      return BigDecimal.ONE;
    } else if (s.equals(SensitivityClass.BASECORR)) {
      return SimmRiskWeightBaseCorr.get(weightingClass);
    } else {
      throw new IllegalStateException("tried to get risk weight for unexpected sensitivity type: " + s + "]!");
    }
  }

  static BigDecimal getForVolWeight(WeightingClass weightingClass, String calculationCurrency) {
    RiskClass r = weightingClass.getRiskClass();
    if (r.equals(RiskClass.FX)) {
      String ccy1 = weightingClass.getQualifier().substring(0, 3);
      String ccy2 = weightingClass.getQualifier().substring(3, 6);
      return new FXRiskWeight().getDeltaRiskWeight(ccy1, ccy2);
    } else {
      return fromRiskClass(r).getDeltaRiskWeight(weightingClass);
    }
  }

  public static SimmRiskWeight fromRiskClass(RiskClass riskClass) {
    if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      return new InterestRateRiskWeight();
    } else if (riskClass.equals(RiskClass.CREDIT_QUALIFYING)) {
      return new CreditQualifyingRiskWeight();
    } else if (riskClass.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return new CreditNonQualifyingRiskWeight();
    } else if (riskClass.equals(RiskClass.EQUITY)) {
      return new EquityRiskWeight();
    } else if (riskClass.equals(RiskClass.COMMODITY)) {
      return new CommodityRiskWeight();
    } else {
      throw new IllegalStateException("tried to get a threshold for unknown risk class: [" + riskClass + "]!");
    }
  }

  public BigDecimal getDeltaRiskWeight(WeightingClass weightingClass);

  public BigDecimal getVegaRiskWeight(WeightingClass weightingClass);

}
