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

import org.junit.Assert;
import org.junit.Test;

public class InterestRateCurrencyVolatilityTest {

  @Test
  public void testRegular() {
    Assert.assertEquals(InterestRateCurrencyVolatility.REGULAR, InterestRateCurrencyVolatility.get("USD"));
    Assert.assertEquals(InterestRateCurrencyVolatility.REGULAR, InterestRateCurrencyVolatility.get("EUR"));
    Assert.assertEquals(InterestRateCurrencyVolatility.REGULAR, InterestRateCurrencyVolatility.get("GBP"));
    Assert.assertEquals(InterestRateCurrencyVolatility.REGULAR, InterestRateCurrencyVolatility.get("CHF"));
    Assert.assertEquals(InterestRateCurrencyVolatility.REGULAR, InterestRateCurrencyVolatility.get("AUD"));
    Assert.assertEquals(InterestRateCurrencyVolatility.REGULAR, InterestRateCurrencyVolatility.get("NZD"));
    Assert.assertEquals(InterestRateCurrencyVolatility.REGULAR, InterestRateCurrencyVolatility.get("CAD"));
    Assert.assertEquals(InterestRateCurrencyVolatility.REGULAR, InterestRateCurrencyVolatility.get("SEK"));
    Assert.assertEquals(InterestRateCurrencyVolatility.REGULAR, InterestRateCurrencyVolatility.get("NOK"));
    Assert.assertEquals(InterestRateCurrencyVolatility.REGULAR, InterestRateCurrencyVolatility.get("DKK"));
    Assert.assertEquals(InterestRateCurrencyVolatility.REGULAR, InterestRateCurrencyVolatility.get("HKD"));
    Assert.assertEquals(InterestRateCurrencyVolatility.REGULAR, InterestRateCurrencyVolatility.get("KRW"));
    Assert.assertEquals(InterestRateCurrencyVolatility.REGULAR, InterestRateCurrencyVolatility.get("SGD"));
    Assert.assertEquals(InterestRateCurrencyVolatility.REGULAR, InterestRateCurrencyVolatility.get("TWD"));
  }

  @Test
  public void testLow() {
    Assert.assertEquals(InterestRateCurrencyVolatility.LOW_VOLATILITY, InterestRateCurrencyVolatility.get("JPY"));
  }

  @Test
  public void testHigh() {
    Assert.assertEquals(InterestRateCurrencyVolatility.HIGH_VOLATILITY, InterestRateCurrencyVolatility.get("abc"));
  }
}
