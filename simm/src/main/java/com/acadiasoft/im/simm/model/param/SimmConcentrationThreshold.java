/*
 * Copyright (c) 2021 AcadiaSoft, Inc.
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

import com.acadiasoft.im.simm.model.SensitivityIdentifier;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;
import com.acadiasoft.im.simm.model.param.cnq.CreditNonQualifyingConcentrationRisk;
import com.acadiasoft.im.simm.model.param.commodity.CommodityConcentrationRisk;
import com.acadiasoft.im.simm.model.param.cq.CreditQualifyingConcentrationRisk;
import com.acadiasoft.im.simm.model.param.equity.EquityConcentrationRisk;
import com.acadiasoft.im.simm.model.param.fx.FXConcentrationRisk;
import com.acadiasoft.im.simm.model.param.interestrate.InterestRateConcentrationRisk;

import java.math.BigDecimal;

public interface SimmConcentrationThreshold {

  String BAD_CALL = "Called getThreshold from a non-concentration risk using sensitivity type: [%s]!";

  static BigDecimal getThreshold(SensitivityIdentifier identifier, String threshold) {
    RiskClass riskClass = identifier.getRiskIdentifier();
    SensitivityClass sensitivityClass = identifier.getSensitivityClass();
    if (sensitivityClass.equals(SensitivityClass.VEGA)) {
      return fromRiskClass(riskClass).getVegaThreshold(threshold);
    } else if (sensitivityClass.equals(SensitivityClass.DELTA)) {
      // NOTE: for FX sensitivities, the thresholds are at the sensitivity level, and identifier
      //  must be the currency (qualifier) of the sensitivity
      //  all other thresholds are at bucket level or risk class level
      return fromRiskClass(riskClass).getDeltaThreshold(threshold);
    } else {
      throw new IllegalStateException(String.format(BAD_CALL, identifier.getSensitivityClass()));
    }
  }

  String BAD_RISK_CLASS = "Tried to get a threshold for unknown risk class: [%s]!";

  static SimmConcentrationThreshold fromRiskClass(RiskClass riskClass) {
    if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      return new InterestRateConcentrationRisk();
    } else if (riskClass.equals(RiskClass.CREDIT_QUALIFYING)) {
      return new CreditQualifyingConcentrationRisk();
    } else if (riskClass.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return new CreditNonQualifyingConcentrationRisk();
    } else if (riskClass.equals(RiskClass.EQUITY)) {
      return new EquityConcentrationRisk();
    } else if (riskClass.equals(RiskClass.COMMODITY)) {
      return new CommodityConcentrationRisk();
    } else if (riskClass.equals(RiskClass.FX)) {
      return new FXConcentrationRisk();
    } else {
      throw new IllegalStateException(String.format(BAD_RISK_CLASS, riskClass));
    }
  }

  public BigDecimal getDeltaThreshold(String threshold);

  public BigDecimal getVegaThreshold(String threshold);

}
