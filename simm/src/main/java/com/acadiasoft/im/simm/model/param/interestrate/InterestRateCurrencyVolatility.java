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

package com.acadiasoft.im.simm.model.param.interestrate;

import java.util.Arrays;
import java.util.List;

/**
 * As defined in Appendix 1 section d of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public enum InterestRateCurrencyVolatility {

  REGULAR(1, Arrays.asList("USD", "EUR", "GBP", "CHF", "AUD", "NZD", "CAD", "SEK", "NOK", "DKK", "HKD", "KRW", "SGD", "TWD")), //
  LOW_VOLATILITY(2, Arrays.asList("JPY")), //
  HIGH_VOLATILITY(3, null);

  private final int bucket;
  private final List<String> currencies;

  private InterestRateCurrencyVolatility(int bucket, List<String> currencies) {
    this.bucket = bucket;
    this.currencies = currencies;
  }

  public String getVolatilityType() {
    return Integer.toString(bucket);
  }

  public List<String> getCurrencies() {
    return currencies;
  }

  public static InterestRateCurrencyVolatility get(String currency) {
    if (REGULAR.getCurrencies().contains(currency)) {
      return InterestRateCurrencyVolatility.REGULAR;
    } else if (LOW_VOLATILITY.getCurrencies().contains(currency)) {
      return LOW_VOLATILITY;
    } else {
      return InterestRateCurrencyVolatility.HIGH_VOLATILITY;
    }
  }
}
