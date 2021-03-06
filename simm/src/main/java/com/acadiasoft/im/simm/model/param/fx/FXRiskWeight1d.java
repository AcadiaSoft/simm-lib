/*
 * Copyright (c) 2020 AcadiaSoft, Inc.
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

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * As defined in Appendix 1 section I of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class FXRiskWeight1d implements SimmFxRiskWeight {

  private static final List<String> HIGH_VOLATILITY = Collections.emptyList();
  private static final BigDecimal WEIGHT = new BigDecimal("1.8");
  private static final BigDecimal VEGA = new BigDecimal("0.077");

  @Override
  public BigDecimal getDeltaRiskWeight(WeightingClass s, String calculationCurrency) {
    return WEIGHT;
  }

  public BigDecimal getDeltaRiskWeight(String ccy1, String ccy2) {
    return WEIGHT;
  }

  @Override
  public BigDecimal getVegaRiskWeight(WeightingClass s, String calculationCurrency) {
    return VEGA;
  }

}
