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

package com.acadiasoft.im.simm.model.param.risk;

import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.param.SimmRiskClassCorrelation;

import java.math.BigDecimal;

/**
 * As defined in Appendix 1 section K of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class RiskClassCorrelation implements SimmRiskClassCorrelation {

  /**
   * Ordering of risk classes in RiskClass:
   *  - IR
   *  - CreditQ
   *  - CreditNonQ
   *  - Equity
   *  - Commodity
   *  - FX
   */
  private static final BigDecimal[][] CORRELATIONS =
    {
        { // IR
            new BigDecimal("1"), // IR
            new BigDecimal("0.27"), // CreditQ
            new BigDecimal("0.26"), // CreditNonQ
            new BigDecimal("0.29"), // Equity
            new BigDecimal("0.31"), // Commodity
            new BigDecimal("0.14"), // FX
        },
        { // CreditQ
            new BigDecimal("0.27"), // IR
            new BigDecimal("1"), // CreditQ
            new BigDecimal("0.19"), // CreditNonQ
            new BigDecimal("0.63"), // Equity
            new BigDecimal("0.42"), // Commodity
            new BigDecimal("0.25"), // FX
        },
        { // CreditNonQ
            new BigDecimal("0.26"), // IR
            new BigDecimal("0.19"), // CreditQ
            new BigDecimal("1"), // CreditNonQ
            new BigDecimal("0.19"), // Equity
            new BigDecimal("0.20"), // Commodity
            new BigDecimal("0.14") // FX
        },
        { // Equity
            new BigDecimal("0.29"), // IR
            new BigDecimal("0.63"), // CreditQ
            new BigDecimal("0.19"), // CreditNonQ
            new BigDecimal("1"), // Equity
            new BigDecimal("0.43"), // Commodity
            new BigDecimal("0.25") // FX
        },
        { // Commodity
            new BigDecimal("0.31"), // IR
            new BigDecimal("0.42"), // CreditQ
            new BigDecimal("0.20"), // CreditNonQ
            new BigDecimal("0.43"), // Equity
            new BigDecimal("1"), // Commodity
            new BigDecimal("0.30") // FX
        },
        { // FX
            new BigDecimal("0.14"), // IR
            new BigDecimal("0.25"), // CreditQ
            new BigDecimal("0.14"), // CreditNonQ
            new BigDecimal("0.25"), // Equity
            new BigDecimal("0.30"), // Commodity
            new BigDecimal("1"), // FX
        }
    };

  @Override
  public BigDecimal getRiskClassCorrelation(RiskClass riskClass, RiskClass riskClass2) {
    return CORRELATIONS[RiskClass.indexOf(riskClass)][RiskClass.indexOf(riskClass2)];
  }
}
