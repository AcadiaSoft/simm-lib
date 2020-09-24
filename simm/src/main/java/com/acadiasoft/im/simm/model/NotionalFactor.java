/*
 * Copyright (c) 2020 AcadiaSoft, Inc.
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
import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnSubType;

import java.io.Serializable;
import java.math.BigDecimal;

public interface NotionalFactor extends Serializable, ValueAmount {

  String BAD_CALL = "Risk type was not 'Param_AddOnNotionalFactor' as it was expected to be: [%s]";

  String getRiskType();

  String getQualifier();

  String getNotionalProduct();

  public static Sensitivity of(String productClass, String amount) {
    return new DefaultSensitivity(null, AddOnSubType.ADD_ON_NOTIONAL_FACTOR, productClass,
      null, null, null, amount, null, null);
  }

  public static Sensitivity of(NotionalFactor factor) {
    return new DefaultSensitivity(null, AddOnSubType.ADD_ON_NOTIONAL_FACTOR, factor.getNotionalProduct(),
      null, null, null, factor.getAmountAsString(), null, null);
  }

  default BigDecimal getPercentFactor() {
    if (this.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_NOTIONAL_FACTOR)) {
      // factor is number input from CRIF which needs to be converted to percent
      return BigDecimalUtils.divideByOneHundred(this.getAmount());
    } else {
      throw new IllegalStateException(String.format(BAD_CALL, this.getRiskType()));
    }
  }

}
