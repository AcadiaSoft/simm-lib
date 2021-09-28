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

package com.acadiasoft.im.simm.model;

import com.acadiasoft.im.base.model.amount.CurrencyAmount;
import com.acadiasoft.im.simm.config.SimmConfig;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnSubType;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;

import java.math.BigDecimal;

public interface Sensitivity
  extends SensitivityIdentifier, CurrencyAmount, ProductMultiplier, Notional, NotionalFactor, FixedAmount {

  // ------------------- static creation methods ---------------------------------

  static Sensitivity of(String productClass, String riskType, String qualifier, String bucket, String label1, String label2,
                        String amount, String amountCurrency, String amountUsd) {
    return new DefaultSensitivity(productClass, riskType, qualifier, bucket, label1, label2, amount, amountCurrency, amountUsd);
  }

  static Sensitivity fromIdentifier(SensitivityIdentifier id, BigDecimal amountUsd) {
    return new DefaultSensitivity(id, amountUsd);
  }

  static Sensitivity curvatureFromVega(Sensitivity vega, SimmConfig config) {
    BigDecimal amount = vega.getAmount();
    BigDecimal amountUsd = vega.getAmountUsd(config.fxRate());
    return new DefaultSensitivity(vega.getProductClass(), vega.getRiskType(), vega.getQualifier(), vega.getBucket(), vega.getLabel1(),
      vega.getLabel2(), amount.toPlainString(), vega.getAmountCurrency(), amountUsd.toPlainString(), SensitivityClass.CURVATURE);
  }

  // ------------------- mapping default methods ---------------------------------

  String BAD_CALL = "Risk type was not 'Param_AddOnNotionalFactor' or 'Notional' as it was expected to be: [%s]";

  default BigDecimal getAmount() {
    return new BigDecimal(getAmountAsString()).stripTrailingZeros();
  }

  default String getNotionalProduct() {
    if (this.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_NOTIONAL_FACTOR)
      || this.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_NOTIONAL)) {
      // the qualifier is exactly the product name that this add on notional factor is associated with
      return this.getQualifier();
    } else {
      throw new IllegalStateException(String.format(BAD_CALL, this.getRiskType()));
    }
  }

  default void checkAmountBasedOnRiskType(String amount, String amountCurrency) {
    if (this.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_PRODUCT_MULTIPLIER)
      || this.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_NOTIONAL_FACTOR)) {
      checkValueAmount(amount);
    } else {
      checkCurrencyAmount(amount, amountCurrency);
    }
  }
}
