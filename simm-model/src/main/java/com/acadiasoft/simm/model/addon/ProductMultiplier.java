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

import com.acadiasoft.simm.model.product.ProductClass;

import java.math.BigDecimal;

public class ProductMultiplier {

  // FIXME: add which regulator this multiplier is associated with.

  private final String productClass;
  private final BigDecimal multiplier;

  public ProductMultiplier(String productClass, BigDecimal multiplier) {
    this.multiplier = multiplier;
    this.productClass = productClass;
  }

  public String getProductLabel() {
    return productClass;
  }

  public ProductClass getProductClass() {
    return ProductClass.getByLabel(productClass);
  }

  public BigDecimal getMultiplier() {
    return multiplier;
  }

}
