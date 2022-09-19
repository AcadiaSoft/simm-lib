/*
 * Copyright (c) 2022 Acadia, Inc.
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

import com.acadiasoft.im.base.model.amount.ValueAmount;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnSubType;
import com.acadiasoft.im.simm.model.imtree.identifiers.ProductClass;

import java.io.Serializable;
import java.math.BigDecimal;

public interface ProductMultiplier extends Serializable, ValueAmount {

  String BAD_CALL = "Risk type was not 'Param_ProductClassMultiplier' as it was expected to be: [%s]";

  String getRiskType();

  String getQualifier();

  public static Sensitivity of(String productClass, String amount) {
    return new DefaultSensitivity(null, AddOnSubType.ADD_ON_PRODUCT_MULTIPLIER, productClass, null, null, null, amount, null, null);
  }

  public static Sensitivity of(ProductMultiplier multiplier) {
    return new DefaultSensitivity(null, AddOnSubType.ADD_ON_PRODUCT_MULTIPLIER, multiplier.getQualifier(), null, null, null, multiplier.getAmountAsString(), null, null);
  }

  default ProductClass getMultiplierProduct() {
    if (this.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_PRODUCT_MULTIPLIER)) {
      // the qualifier of a product multiplier sensitivity is exactly the product class of that multiplier
      return ProductClass.determineProductClass(this.getQualifier());
    } else {
      throw new IllegalStateException(String.format(BAD_CALL, this.getRiskType()));
    }
  }

  default BigDecimal getMultiplier() {
    if (this.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_PRODUCT_MULTIPLIER)) {
      // the multipliers need to have one subtracted from them
      return this.getAmount().subtract(BigDecimal.ONE);
    } else {
      throw new IllegalStateException(String.format(BAD_CALL, this.getRiskType()));
    }
  }

}
