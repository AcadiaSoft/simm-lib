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

package com.acadiasoft.im.simm.model.imtree.identifiers;

import com.acadiasoft.im.base.model.imtree.identifiers.GroupClass;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * As defined in Appendix 1 section K of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class RiskClass extends GroupClass {

  public static final RiskClass INTEREST_RATE = new RiskClass("IR");
  public static final RiskClass CREDIT_QUALIFYING = new RiskClass("CreditQ");
  public static final RiskClass CREDIT_NON_QUALIFYING = new RiskClass("CreditNonQ");
  public static final RiskClass EQUITY = new RiskClass("Equity");
  public static final RiskClass COMMODITY = new RiskClass("Commodity");
  public static final RiskClass FX = new RiskClass("FX");

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
  public static final Supplier<Stream<String>> RISK_TYPE_LIST = () -> Stream.of(
      RISK_TYPE_COMMODITY_VOL, RISK_TYPE_COMMODITY, RISK_TYPE_FX_VOL, RISK_TYPE_FX,
      RISK_TYPE_EQUITY_VOL, RISK_TYPE_EQUITY, RISK_TYPE_CREDIT_VOL_NON_Q, RISK_TYPE_CREDIT_NON_Q,
      RISK_TYPE_CREDIT_VOL, RISK_TYPE_CREDIT_Q, RISK_TYPE_BASE_CORR, RISK_TYPE_IR_VOL, RISK_TYPE_INFLATION,
      RISK_TYPE_IR_CURVE, RISK_TYPE_INFLATION_VOL, RISK_TYPE_XCCY_BASIS
  );

  private static final String BAD_RISK_TYPE = "Unknown risk type specified: [%s]";

  private RiskClass(String label) {
    super(label);
  }

  public static boolean isSimmRiskType(String type) {
    if (type == null) { return false; }
    return RISK_TYPE_LIST.get().anyMatch(type::equalsIgnoreCase);
  }

  public static RiskClass determineByRiskType(String riskType) {
    if (StringUtils.equalsIgnoreCase(RISK_TYPE_IR_CURVE, riskType) ||
      StringUtils.equalsIgnoreCase(RISK_TYPE_INFLATION, riskType) ||
      StringUtils.equalsIgnoreCase(RISK_TYPE_IR_VOL, riskType) ||
      StringUtils.equalsIgnoreCase(RISK_TYPE_INFLATION_VOL, riskType) ||
      StringUtils.equalsIgnoreCase(RISK_TYPE_XCCY_BASIS, riskType)) {
      return INTEREST_RATE;
    } else if (StringUtils.equalsIgnoreCase(RISK_TYPE_CREDIT_Q, riskType) ||
      StringUtils.equalsIgnoreCase(RISK_TYPE_CREDIT_VOL, riskType) ||
      StringUtils.equalsIgnoreCase(RISK_TYPE_BASE_CORR, riskType)) {
      return CREDIT_QUALIFYING;
    } else if (StringUtils.equalsIgnoreCase(RISK_TYPE_CREDIT_NON_Q, riskType) ||
      StringUtils.equalsIgnoreCase(RISK_TYPE_CREDIT_VOL_NON_Q, riskType)) {
      return CREDIT_NON_QUALIFYING;
    } else if (StringUtils.equalsIgnoreCase(RISK_TYPE_EQUITY, riskType) ||
      StringUtils.equalsIgnoreCase(RISK_TYPE_EQUITY_VOL, riskType)) {
      return EQUITY;
    } else if (StringUtils.equalsIgnoreCase(RISK_TYPE_FX, riskType) ||
      StringUtils.equalsIgnoreCase(RISK_TYPE_FX_VOL, riskType)) {
      return FX;
    } else if (StringUtils.equalsIgnoreCase(RISK_TYPE_COMMODITY, riskType) ||
      StringUtils.equalsIgnoreCase(RISK_TYPE_COMMODITY_VOL, riskType)) {
      return COMMODITY;
    } else if (AddOnSubType.isAddOnSubType(riskType)) {
      return null; // this is to handle building the initial add on sensitivities which should never need
    } else {
      // Schedule IM: Notional, PV (present value of the trade, including all cashflows strictly after the ValuationDate)
      throw new IllegalStateException(String.format(BAD_RISK_TYPE, riskType));
    }
  }
}
