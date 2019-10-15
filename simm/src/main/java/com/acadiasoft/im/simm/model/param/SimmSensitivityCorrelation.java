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
import com.acadiasoft.im.simm.model.param.cnq.CreditNonQualifyingCorrelation;
import com.acadiasoft.im.simm.model.param.commodity.CommodityCorrelation;
import com.acadiasoft.im.simm.model.param.cq.CreditQualifyingCorrelation;
import com.acadiasoft.im.simm.model.param.equity.EquityCorrelation;
import com.acadiasoft.im.simm.model.param.fx.FXCorrelation;
import com.acadiasoft.im.simm.model.param.interestrate.InterestRateCorrelation;

import java.math.BigDecimal;

public interface SimmSensitivityCorrelation {

  public static BigDecimal get(RiskClass riskClass, SensitivityClass sensitivityClass,
                               WeightingClass r, WeightingClass s, String calculationCurrency) {
    if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      return new InterestRateCorrelation().getSensitivityCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.CREDIT_QUALIFYING)) {
      return new CreditQualifyingCorrelation().getSensitivityCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return new CreditNonQualifyingCorrelation().getSensitivityCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.EQUITY)) {
      return new EquityCorrelation().getSensitivityCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.COMMODITY)) {
      return new CommodityCorrelation().getSensitivityCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.FX)) {
      if (sensitivityClass.equals(SensitivityClass.DELTA)) {
        return new FXCorrelation().getSensitivityCorrelation(r, s, calculationCurrency);
      } else {
        return FXCorrelation.CORRELATION;
      }
    } else {
      throw new IllegalStateException("tried to get a threshold for unknown risk class: [" + riskClass + "]!");
    }
  }

  public BigDecimal getSensitivityCorrelation(WeightingClass r, WeightingClass s);

}
