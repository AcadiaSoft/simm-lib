/*
 * Copyright (c) 2017 AcadiaSoft, Inc.
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

package com.acadiasoft.simm.model.addon;

import java.math.BigDecimal;

public class AddOnNotional {

  private final String product;
  private final BigDecimal notional;
  private final String currency;
  private final BigDecimal notionalUSD;

  public AddOnNotional(String product, BigDecimal notional) {
    this.product = product;
    this.notional = notional;
    this.notionalUSD = notional;
    this.currency = "USD";
  }

  public AddOnNotional(String product, BigDecimal notional, String currency, BigDecimal notionalUSD) {
    this.product = product;
    this.notional = notional;
    this.notionalUSD = notionalUSD;
    this.currency = currency;
  }

  public String getProduct() {
    return product;
  }

  public BigDecimal getNotional() {
    return notional;
  }

  public BigDecimal getNotionalUSD() {
    return notionalUSD;
  }

  public String getCurrency() {
    return currency;
  }

}
