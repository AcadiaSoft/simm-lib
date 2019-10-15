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

import com.acadiasoft.im.base.util.BigDecimalUtils;

import java.io.Serializable;
import java.math.BigDecimal;

public class AddOnNotionalFactor implements Serializable {

  private final String product;
  private final BigDecimal factor;

  public AddOnNotionalFactor(String product, BigDecimal factor) {
    this.product = product;
    this.factor = factor.stripTrailingZeros();
  }

  public AddOnNotionalFactor(String product, String factor) {
    this.product = product;
    this.factor = new BigDecimal(factor).stripTrailingZeros();
  }

  public String getProduct() {
    return product;
  }

  public BigDecimal getFactor() {
    return factor;
  }

  public BigDecimal getPercentFactor() {
    // factor is number input from CRIF which needs to be converted to percent
    return BigDecimalUtils.divideWithPrecision(factor, new BigDecimal("100")).stripTrailingZeros();
  }

}
