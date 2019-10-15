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

package com.acadiasoft.im.simmple.model.result;

import com.acadiasoft.im.base.fx.FxRate;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author alec.stewart
 */
public class ImResult implements Serializable {

  private final String regulator;
  private final String currency;
  private final BigDecimal amount;

  public ImResult(String regulator, BigDecimal amount, String currency) {
    this.amount = amount;
    this.regulator = regulator;
    this.currency = currency;
  }

  public ImResult(String regulator, BigDecimal amount) {
    this.amount = amount;
    this.regulator = regulator;
    this.currency = FxRate.USD;
  }

  public String getCurrency() {
    return currency;
  }

  public String getRegulator() {
    return regulator;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ImResult)) return false;
    ImResult r = (ImResult) o;
    if (r.getAmount().equals(amount) && r.getCurrency().equalsIgnoreCase(currency) && r.getRegulator().equalsIgnoreCase(regulator)) return true;
    return false;
  }

  @Override
  public int hashCode() {
    return 3 * currency.hashCode() + 2 * regulator.hashCode() + amount.hashCode();
  }

  @Override
  public String toString() {
    return regulator + ", " + amount + ", " + currency;
  }

}
