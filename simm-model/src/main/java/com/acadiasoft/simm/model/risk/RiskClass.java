/*
 * Copyright (c) 2017 AcadiaSoft, Inc.
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

package com.acadiasoft.simm.model.risk;

import java.util.Arrays;
import java.util.List;

/**
 * As defined in Appendix 1 section K of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public enum RiskClass {

  INTEREST_RATE("Interest Rate"), //
  CREDIT_QUALIFYING("Credit Qualifying"), //
  CREDIT_NON_QUALIFYING("Credit Non-qualifying"), //
  EQUITY("Equity"), //
  COMMODITY("Commodity"), //
  FX("FX");

  private static final List<RiskClass> ALL = Arrays.asList(values());

  private final String label;

  private RiskClass(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  public static int indexOf(RiskClass r) {
    return ALL.indexOf(r);
  }

  /**
   * Risk_Data_Standards_v1.25_(PUBLIC).pdf
   *
   * @param riskType
   * @return
   */
  public static RiskClass getByRiskType(String riskType) {
    switch (riskType) {
      case RiskType.RISK_TYPE_IR_CURVE:
      case RiskType.RISK_TYPE_INFLATION:
      case RiskType.RISK_TYPE_IR_VOL:
      case RiskType.RISK_TYPE_INFLATION_VOL:
      case RiskType.RISK_TYPE_XCCY_BASIS:
        return RiskClass.INTEREST_RATE;
      case RiskType.RISK_TYPE_CREDIT_Q:
      case RiskType.RISK_TYPE_CREDIT_VOL:
      case RiskType.RISK_TYPE_BASE_CORR:
        return RiskClass.CREDIT_QUALIFYING;
      case RiskType.RISK_TYPE_CREDIT_NON_Q:
      case RiskType.RISK_TYPE_CREDIT_VOL_NON_Q:
        return RiskClass.CREDIT_NON_QUALIFYING;
      case RiskType.RISK_TYPE_EQUITY:
      case RiskType.RISK_TYPE_EQUITY_VOL:
        return RiskClass.EQUITY;
      case RiskType.RISK_TYPE_FX:
      case RiskType.RISK_TYPE_FX_VOL:
        return RiskClass.FX;
      case RiskType.RISK_TYPE_COMMODITY:
      case RiskType.RISK_TYPE_COMMODITY_VOL:
        return RiskClass.COMMODITY;
      //      Schedule IM: Notional, PV (present value of the trade, including all cashflows strictly after the ValuationDate)
      default:
        throw new RuntimeException("Unknown risk type specified:[" + riskType + "]!");
    }
  }
}
