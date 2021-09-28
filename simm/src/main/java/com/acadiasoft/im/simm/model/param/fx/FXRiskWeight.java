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

package com.acadiasoft.im.simm.model.param.fx;

import static com.acadiasoft.im.simm.model.param.fx.FXCurrencyVolatility.HIGH_VOLATILITY;
import static com.acadiasoft.im.simm.model.param.fx.FXCurrencyVolatility.REGULAR_VOLATILITY;

import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmFxRiskWeight;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * As defined in Appendix 1 section I of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class FXRiskWeight implements SimmFxRiskWeight {

  private static final BigDecimal VEGA = new BigDecimal("0.47");

  private static final Map<FXCurrencyVolatility, Map<FXCurrencyVolatility, BigDecimal>> WEIGHTS = new HashMap<>();
  private static final Map<FXCurrencyVolatility, BigDecimal> REGULAR = new HashMap<>();
  private static final Map<FXCurrencyVolatility, BigDecimal> HIGH = new HashMap<>();

  static {
    REGULAR.put(REGULAR_VOLATILITY, new BigDecimal("7.3"));
    REGULAR.put(HIGH_VOLATILITY, new BigDecimal("13"));
    WEIGHTS.put(REGULAR_VOLATILITY, REGULAR);

    HIGH.put(REGULAR_VOLATILITY, new BigDecimal("13"));
    HIGH.put(HIGH_VOLATILITY, new BigDecimal("10.2"));
    WEIGHTS.put(HIGH_VOLATILITY, HIGH);
  }

  @Override
  public BigDecimal getDeltaRiskWeight(WeightingClass s, String calculationCurrency) {
    FXCurrencyVolatility calcCurrencyVolatility = FXCurrencyVolatility.get(calculationCurrency);
    FXCurrencyVolatility fxCurrencyVolatility = FXCurrencyVolatility.get(s.getQualifier());
    return WEIGHTS.get(fxCurrencyVolatility).get(calcCurrencyVolatility);
  }

  public BigDecimal getDeltaRiskWeight(String ccy1, String ccy2) {
    FXCurrencyVolatility ccy1Volatility = FXCurrencyVolatility.get(ccy1);
    FXCurrencyVolatility ccy2Volatility = FXCurrencyVolatility.get(ccy2);
    return WEIGHTS.get(ccy1Volatility).get(ccy2Volatility);
  }

  @Override
  public BigDecimal getVegaRiskWeight(WeightingClass s, String calculationCurrency) {
    return VEGA;
  }

}
