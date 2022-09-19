/*
 * Copyright (c) 2022 Acadia, Inc.
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

import com.acadiasoft.im.simm.config.HoldingPeriod;
import com.acadiasoft.im.simm.config.SimmConfig;
import com.acadiasoft.im.simm.model.SensitivityIdentifier;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.cnq.CreditNonQualifyingRiskWeight;
import com.acadiasoft.im.simm.model.param.cnq.CreditNonQualifyingRiskWeight1d;
import com.acadiasoft.im.simm.model.param.commodity.CommodityRiskWeight;
import com.acadiasoft.im.simm.model.param.commodity.CommodityRiskWeight1d;
import com.acadiasoft.im.simm.model.param.cq.CreditQualifyingRiskWeight;
import com.acadiasoft.im.simm.model.param.cq.CreditQualifyingRiskWeight1d;
import com.acadiasoft.im.simm.model.param.equity.EquityRiskWeight;
import com.acadiasoft.im.simm.model.param.equity.EquityRiskWeight1d;
import com.acadiasoft.im.simm.model.param.fx.FXRiskWeight;
import com.acadiasoft.im.simm.model.param.fx.FXRiskWeight1d;
import com.acadiasoft.im.simm.model.param.interestrate.InterestRateRiskWeight;
import com.acadiasoft.im.simm.model.param.interestrate.InterestRateRiskWeight1d;

import java.math.BigDecimal;

public interface SimmRiskWeight {

  static BigDecimal get(SensitivityClass s, WeightingClass weightingClass, SimmConfig config) {
    RiskClass r = weightingClass.getRiskIdentifier();
    if (s.equals(SensitivityClass.DELTA)) {
      if (r.equals(RiskClass.FX) && config.holdingPeriod().equals(HoldingPeriod.TEN_DAY)) {
        return new FXRiskWeight().getDeltaRiskWeight(weightingClass, config.calculationCurrency());
      } else if (r.equals(RiskClass.FX) && config.holdingPeriod().equals(HoldingPeriod.ONE_DAY)) {
        return new FXRiskWeight1d().getDeltaRiskWeight(weightingClass, config.calculationCurrency());
      } else {
        return fromRiskClass(r, config.holdingPeriod()).getDeltaRiskWeight(weightingClass);
      }
    } else if (s.equals(SensitivityClass.VEGA)) {
      if (r.equals(RiskClass.FX) && config.holdingPeriod().equals(HoldingPeriod.TEN_DAY)) {
        return new FXRiskWeight().getVegaRiskWeight(weightingClass, config.calculationCurrency());
      } else if (r.equals(RiskClass.FX) && config.holdingPeriod().equals(HoldingPeriod.ONE_DAY)) {
        return new FXRiskWeight1d().getVegaRiskWeight(weightingClass, config.calculationCurrency());
      } else {
        return fromRiskClass(r, config.holdingPeriod()).getVegaRiskWeight(weightingClass);
      }
    } else if (s.equals(SensitivityClass.CURVATURE)) {
      return BigDecimal.ONE;
    } else if (s.equals(SensitivityClass.BASECORR)) {
      return SimmRiskWeightBaseCorr.get(weightingClass, config.holdingPeriod());
    } else {
      throw new IllegalStateException("tried to get risk weight for unexpected sensitivity type: " + s + "]!");
    }
  }

  static BigDecimal getForVolWeight(SensitivityIdentifier id, SimmConfig config) {
    RiskClass r = id.getRiskIdentifier();
    if (r.equals(RiskClass.FX)) {
      String ccy1 = id.getQualifier().substring(0, 3);
      String ccy2 = id.getQualifier().substring(3, 6);
      if (config.holdingPeriod().equals(HoldingPeriod.TEN_DAY)) {
        return new FXRiskWeight().getDeltaRiskWeight(ccy1, ccy2);
      } else {
        return new FXRiskWeight1d().getDeltaRiskWeight(ccy1, ccy2);
      }
    } else {
      return fromRiskClass(r, config.holdingPeriod()).getDeltaRiskWeight(id);
    }
  }

  public static SimmRiskWeight fromRiskClass(RiskClass riskClass, HoldingPeriod period) {
    if (period.equals(HoldingPeriod.TEN_DAY)) {
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
    } else {
      if (riskClass.equals(RiskClass.INTEREST_RATE)) {
        return new InterestRateRiskWeight1d();
      } else if (riskClass.equals(RiskClass.CREDIT_QUALIFYING)) {
        return new CreditQualifyingRiskWeight1d();
      } else if (riskClass.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
        return new CreditNonQualifyingRiskWeight1d();
      } else if (riskClass.equals(RiskClass.EQUITY)) {
        return new EquityRiskWeight1d();
      } else if (riskClass.equals(RiskClass.COMMODITY)) {
        return new CommodityRiskWeight1d();
      } else {
        throw new IllegalStateException("tried to get a threshold for unknown risk class: [" + riskClass + "]!");
      }
    }
  }

  public BigDecimal getDeltaRiskWeight(SensitivityIdentifier identifier);

  public BigDecimal getVegaRiskWeight(SensitivityIdentifier identifier);

}
