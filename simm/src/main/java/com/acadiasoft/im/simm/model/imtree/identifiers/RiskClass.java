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

import com.acadiasoft.im.base.imtree.identifiers.MarginIdentifier;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * As defined in Appendix 1 section K of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public enum RiskClass implements MarginIdentifier {

  INTEREST_RATE("IR"), //
  CREDIT_QUALIFYING("CreditQ"), //
  CREDIT_NON_QUALIFYING("CreditNonQ"), //
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
  public static final List<String> RISK_TYPE_LIST = Collections.unmodifiableList(
      Arrays.asList(RISK_TYPE_COMMODITY_VOL, RISK_TYPE_COMMODITY, RISK_TYPE_FX_VOL, RISK_TYPE_FX,
          RISK_TYPE_EQUITY_VOL, RISK_TYPE_EQUITY, RISK_TYPE_CREDIT_VOL_NON_Q, RISK_TYPE_CREDIT_NON_Q,
          RISK_TYPE_CREDIT_VOL, RISK_TYPE_CREDIT_Q, RISK_TYPE_BASE_CORR, RISK_TYPE_IR_VOL, RISK_TYPE_INFLATION,
          RISK_TYPE_IR_CURVE, RISK_TYPE_INFLATION_VOL, RISK_TYPE_XCCY_BASIS)
  );

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

  public static boolean isSimmRiskType(String type) {
    return RISK_TYPE_LIST.stream().anyMatch(type::equalsIgnoreCase);
  }

  /**
   * Risk_Data_Standards_v1.25_(PUBLIC).pdf
   *
   * @param riskType
   * @return
   */
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
    } else {
      // Schedule IM: Notional, PV (present value of the trade, including all cashflows strictly after the ValuationDate)
      throw new IllegalStateException("Unknown risk type specified:[" + riskType + "]!");
    }
  }

  public static RiskClass getByLabel(String label) {
    for (RiskClass r: ALL) {
      if (label.equalsIgnoreCase(r.getLabel())) {
        return r;
      }
    }

    throw new IllegalStateException("tried to get risk class label that doesn't exist: [" + label + "]!");
  }
}
