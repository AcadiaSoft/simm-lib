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

package com.acadiasoft.simm.model.object.imtree.identifiers;

import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;

import java.util.Arrays;
import java.util.List;

/**
 * As defined in Appendix 1 section K of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public enum RiskClass implements MarginIdentifier {

  INTEREST_RATE("Interest Rate"), //
  CREDIT_QUALIFYING("Credit Qualifying"), //
  CREDIT_NON_QUALIFYING("Credit Non-qualifying"), //
  EQUITY("Equity"), //
  COMMODITY("Commodity"), //
  FX("FX");

  public static final String RISK_TYPE_COMMODITY_VOL = "Risk_CommodityVol";
  public static final String RISK_TYPE_COMMODITY = "Risk_Commodity";
  public static final String RISK_TYPE_FX_VOL = "Risk_FXVol";
  public static final String RISK_TYPE_FX = "Risk_FX";
  public static final String RISK_TYPE_EQUITY_VOL = "Risk_EquityVol";
  public static final String RISK_TYPE_EQUITY = "Risk_Equity";
  public static final String RISK_TYPE_CREDIT_VOL_NON_Q = "Risk_CreditVolNonQ";
  public static final String RISK_TYPE_CREDIT_NON_Q = "Risk_CreditNonQ";
  public static final String RISK_TYPE_CREDIT_VOL = "Risk_CreditVol";
  public static final String RISK_TYPE_CREDIT_Q = "Risk_CreditQ";
  public static final String RISK_TYPE_BASE_CORR = "Risk_BaseCorr";
  public static final String RISK_TYPE_IR_VOL = "Risk_IRVol";
  public static final String RISK_TYPE_INFLATION = "Risk_Inflation";
  public static final String RISK_TYPE_IR_CURVE = "Risk_IRCurve";
  public static final String RISK_TYPE_INFLATION_VOL = "Risk_InflationVol";
  public static final String RISK_TYPE_XCCY_BASIS = "Risk_XCcyBasis";

  private static final List<RiskClass> ALL = Arrays.asList(values());

  private final String label;

  private RiskClass(String label) {
    this.label = label;
  }

  @Override
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
  public static RiskClass determineByRiskType(String riskType) {
    switch (riskType) {
      case RISK_TYPE_IR_CURVE:
      case RISK_TYPE_INFLATION:
      case RISK_TYPE_IR_VOL:
      case RISK_TYPE_INFLATION_VOL:
      case RISK_TYPE_XCCY_BASIS:
        return INTEREST_RATE;
      case RISK_TYPE_CREDIT_Q:
      case RISK_TYPE_CREDIT_VOL:
      case RISK_TYPE_BASE_CORR:
        return CREDIT_QUALIFYING;
      case RISK_TYPE_CREDIT_NON_Q:
      case RISK_TYPE_CREDIT_VOL_NON_Q:
        return CREDIT_NON_QUALIFYING;
      case RISK_TYPE_EQUITY:
      case RISK_TYPE_EQUITY_VOL:
        return EQUITY;
      case RISK_TYPE_FX:
      case RISK_TYPE_FX_VOL:
        return FX;
      case RISK_TYPE_COMMODITY:
      case RISK_TYPE_COMMODITY_VOL:
        return COMMODITY;
      //      Schedule IM: Notional, PV (present value of the trade, including all cashflows strictly after the ValuationDate)
      default:
        throw new RuntimeException("Unknown risk type specified:[" + riskType + "]!");
    }
  }

  public static RiskClass getByLabel(String label) {
    for (RiskClass r: ALL) {
      if (label.equals(r.getLabel())) {
        return r;
      }
    }

    throw new IllegalStateException("tried to get risk class label that doesn't exist: [" + label + "]!");
  }
}
