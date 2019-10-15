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

package com.acadiasoft.im.simm.model;

import com.acadiasoft.im.base.fx.FxRate;

import java.io.Serializable;
import java.math.BigDecimal;

public class AddOnFixedAmount implements Serializable {

  private final BigDecimal amount;
  private final String currency;
  private final BigDecimal amountUSD;

  public AddOnFixedAmount(BigDecimal amount, String currency, BigDecimal amountUSD) {
    this.amount = amount.stripTrailingZeros();
    this.currency = currency;
    this.amountUSD = amountUSD.stripTrailingZeros();
  }

  public AddOnFixedAmount(BigDecimal amount) {
    this.amount = amount;
    this.currency = FxRate.USD;
    this.amountUSD = amount;
  }

  public AddOnFixedAmount(String amount, String currency, String amountUSD) {
    this.amount = new BigDecimal(amount).stripTrailingZeros();
    this.currency = currency;
    this.amountUSD = new BigDecimal(amountUSD).stripTrailingZeros();
  }

  public AddOnFixedAmount(String amount) {
    this.amount = new BigDecimal(amount).stripTrailingZeros();
    this.currency = FxRate.USD;
    this.amountUSD = new BigDecimal(amount).stripTrailingZeros();
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public String getCurrency() {
    return currency;
  }

  public BigDecimal getAmountUsd() {
    return amountUSD;
  }

}
