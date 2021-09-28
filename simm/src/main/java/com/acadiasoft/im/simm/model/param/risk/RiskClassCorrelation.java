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

package com.acadiasoft.im.simm.model.param.risk;

import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.param.SimmRiskClassCorrelation;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * As defined in Appendix 1 section K of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class RiskClassCorrelation implements SimmRiskClassCorrelation {
  
  private static final Map<RiskClass, Map<RiskClass, BigDecimal>> CORRELATIONS = new HashMap<>();
  
  static {
    Map<RiskClass, BigDecimal> IR = new HashMap<>();
    IR.put(RiskClass.INTEREST_RATE, new BigDecimal("1"));
    IR.put(RiskClass.FX, new BigDecimal("0.28"));
    IR.put(RiskClass.EQUITY, new BigDecimal("0.33"));
    IR.put(RiskClass.CREDIT_QUALIFYING, new BigDecimal("0.32"));
    IR.put(RiskClass.CREDIT_NON_QUALIFYING, new BigDecimal("0.19"));
    IR.put(RiskClass.COMMODITY, new BigDecimal("0.41"));
    CORRELATIONS.put(RiskClass.INTEREST_RATE, IR);

    Map<RiskClass, BigDecimal> FX = new HashMap<>();
    FX.put(RiskClass.INTEREST_RATE, new BigDecimal("0.28"));
    FX.put(RiskClass.FX, new BigDecimal("1"));
    FX.put(RiskClass.EQUITY, new BigDecimal("0.34"));
    FX.put(RiskClass.CREDIT_QUALIFYING, new BigDecimal("0.42"));
    FX.put(RiskClass.CREDIT_NON_QUALIFYING, new BigDecimal("0.14"));
    FX.put(RiskClass.COMMODITY, new BigDecimal("0.38"));
    CORRELATIONS.put(RiskClass.FX, FX);

    Map<RiskClass, BigDecimal> EQ = new HashMap<>();
    EQ.put(RiskClass.INTEREST_RATE, new BigDecimal("0.33"));
    EQ.put(RiskClass.FX, new BigDecimal("0.34"));
    EQ.put(RiskClass.EQUITY, new BigDecimal("1"));
    EQ.put(RiskClass.CREDIT_QUALIFYING, new BigDecimal("0.69"));
    EQ.put(RiskClass.CREDIT_NON_QUALIFYING, new BigDecimal("0.48"));
    EQ.put(RiskClass.COMMODITY, new BigDecimal("0.52"));
    CORRELATIONS.put(RiskClass.EQUITY, EQ);

    Map<RiskClass, BigDecimal> CQ = new HashMap<>();
    CQ.put(RiskClass.INTEREST_RATE, new BigDecimal("0.32"));
    CQ.put(RiskClass.FX, new BigDecimal("0.42"));
    CQ.put(RiskClass.EQUITY, new BigDecimal("0.69"));
    CQ.put(RiskClass.CREDIT_QUALIFYING, new BigDecimal("1"));
    CQ.put(RiskClass.CREDIT_NON_QUALIFYING, new BigDecimal("0.45"));
    CQ.put(RiskClass.COMMODITY, new BigDecimal("0.52"));
    CORRELATIONS.put(RiskClass.CREDIT_QUALIFYING, CQ);
    
    Map<RiskClass, BigDecimal> CN = new HashMap<>();
    CN.put(RiskClass.INTEREST_RATE, new BigDecimal("0.19"));
    CN.put(RiskClass.FX, new BigDecimal("0.14"));
    CN.put(RiskClass.EQUITY, new BigDecimal("0.48"));
    CN.put(RiskClass.CREDIT_QUALIFYING, new BigDecimal("0.45"));
    CN.put(RiskClass.CREDIT_NON_QUALIFYING, new BigDecimal("1"));
    CN.put(RiskClass.COMMODITY, new BigDecimal("0.40"));
    CORRELATIONS.put(RiskClass.CREDIT_NON_QUALIFYING, CN);

    Map<RiskClass, BigDecimal> CM = new HashMap<>();
    CM.put(RiskClass.INTEREST_RATE, new BigDecimal("0.41"));
    CM.put(RiskClass.FX, new BigDecimal("0.38"));
    CM.put(RiskClass.EQUITY, new BigDecimal("0.52"));
    CM.put(RiskClass.CREDIT_QUALIFYING, new BigDecimal("0.52"));
    CM.put(RiskClass.CREDIT_NON_QUALIFYING, new BigDecimal("0.4"));
    CM.put(RiskClass.COMMODITY, new BigDecimal("1"));
    CORRELATIONS.put(RiskClass.COMMODITY, CM);
  }

  @Override
  public BigDecimal getRiskClassCorrelation(RiskClass riskClass, RiskClass riskClass2) {
    return CORRELATIONS.get(riskClass).get(riskClass2);
  }
}
