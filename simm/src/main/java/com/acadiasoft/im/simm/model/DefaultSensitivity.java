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
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * As defined by Appendix 2, section 2.1 of Risk_Data_Standards_v1.25_(PUBLIC).pdf
 *
 * @author alec.stewart
 */
public class DefaultSensitivity extends DefaultSensitivityIdentifier implements Serializable, Sensitivity {

  public static final String RESIDUAL = "residual";

  /**
   * Amount of the risk, in units of a given currency
   */
  private final String amount;

  /**
   * Currency of the "Amount" field. Should be a standard three-letter ISO currency code
   */
  private final String amountCurrency;

  /**
   * Amount of the risk, expressed in USD
   */
  private final String amountUsd;

  public DefaultSensitivity(SensitivityIdentifier identifier, BigDecimal amountUsd) {
    // copy the identifier values to this sensitivity
    super(identifier);
    this.amount = amountUsd.toPlainString();
    this.amountCurrency = FxRate.USD;
    this.amountUsd = amountUsd.toPlainString();
  }

  public DefaultSensitivity(String productClass, String riskType, String qualifier, String bucket, String label1, String label2,
                            String amount, String amountCurrency, String amountUsd) {
    this(null, productClass, riskType, qualifier, bucket, label1, label2, amount, amountCurrency, amountUsd,
      SensitivityClass.determineByRiskType(riskType));
  }

  public DefaultSensitivity(String productClass, String riskType, String qualifier, String bucket, String label1, String label2,
                             String amount, String amountCurrency, String amountUsd, SensitivityClass sensitivityClass) {
    this(null, productClass, riskType, qualifier, bucket, label1, label2, amount, amountCurrency, amountUsd, sensitivityClass);
  }

  public DefaultSensitivity(String tradeId, String productClass, String riskType, String qualifier, String bucket, String label1, String label2,
                            String amount, String amountCurrency, String amountUsd, SensitivityClass sensitivityClass) {
    // set up the identifier values
    super(tradeId, productClass, riskType, qualifier, bucket, label1, label2,
      sensitivityClass, RiskClass.determineByRiskType(riskType));
    checkSensitivityIdentifier(productClass, riskType, qualifier, bucket, label1, label2);

    // check and set the amounts - product multipliers and factors are value amounts
    checkAmountBasedOnRiskType(amount, amountCurrency);
    this.amount = amount;
    this.amountCurrency = amountCurrency;
    this.amountUsd = amountUsd;
  }

  @Override
  public String getAmountAsString() {
    return amount;
  }

  @Override
  public String getAmountCurrency() {
    return amountCurrency;
  }

  @Override
  public String getAmountUsdAsString() {
    return amountUsd;
  }

}
