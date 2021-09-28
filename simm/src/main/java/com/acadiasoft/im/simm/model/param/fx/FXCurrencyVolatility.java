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

import java.util.Arrays;
import java.util.List;

/**
 * As defined in Appendix 1 section d of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public enum FXCurrencyVolatility {

  HIGH_VOLATILITY("1", Arrays.asList("ARS", "BRL", "MXN", "TRY", "ZAR")), //
  REGULAR_VOLATILITY("2", null);

  private final String volatilityType;
  private final List<String> currencies;

  private FXCurrencyVolatility(String volatilityType, List<String> currencies) {
    this.volatilityType = volatilityType;
    this.currencies = currencies;
  }

  public String getVolatilityType() {
    return volatilityType;
  }

  public List<String> getCurrencies() {
    return currencies;
  }

  public static FXCurrencyVolatility get(String currency) {
    if (HIGH_VOLATILITY.getCurrencies().contains(currency)) {
      return FXCurrencyVolatility.HIGH_VOLATILITY;
    } else {
      return FXCurrencyVolatility.REGULAR_VOLATILITY;
    }
  }
}
