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

package com.acadiasoft.im.simm.model.param.fx;

import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmFxRiskWeight;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * As defined in Appendix 1 section I of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class FXRiskWeight implements SimmFxRiskWeight {

  private static final List<String> HIGH_VOLATILITY = Collections.singletonList("BRL");
  private static final BigDecimal REG_TO_REG = new BigDecimal("7.57");
  private static final BigDecimal ELSE = new BigDecimal("10.28");
  private static final BigDecimal VEGA = new BigDecimal("0.30");

  @Override
  public BigDecimal getDeltaRiskWeight(WeightingClass s, String calculationCurrency) {
    String ccy = s.getQualifier();
    if (!HIGH_VOLATILITY.contains(ccy) && !HIGH_VOLATILITY.contains(calculationCurrency)) {
      return REG_TO_REG;
    }  else {
      return ELSE;
    }
  }

  public BigDecimal getDeltaRiskWeight(String ccy1, String ccy2) {
    if (!HIGH_VOLATILITY.contains(ccy1) && !HIGH_VOLATILITY.contains(ccy2)) {
      return REG_TO_REG;
    }  else {
      return ELSE;
    }
  }

  @Override
  public BigDecimal getVegaRiskWeight(WeightingClass s, String calculationCurrency) {
    return VEGA;
  }

}
