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

import com.acadiasoft.im.simm.model.imtree.identifiers.*;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.stream.Stream;


public interface SensitivityIdentifier extends Serializable {

  String getTradeId();

  String getProductClass();

  String getRiskType();

  String getQualifier();

  String getBucket();

  String getLabel1();

  String getLabel2();

  SensitivityClass getSensitivityClass();

  RiskClass getRiskIdentifier();

  // ------------------- default methods ---------------------------------

  String BAD_RISK_TYPE = "The risk type was null or empty when it was required";
  String BAD_QUALIFIER = "The qualifier was null or empty when it was required";
  String BAD_PRODUCT = "The product class was null or empty when it was required";


  default void checkSensitivityIdentifier(String productClass, String riskType, String qualifier,
                                          String bucket, String label1, String label2) {
    if (riskType == null || riskType.isEmpty()) {
      throw new IllegalStateException(BAD_RISK_TYPE);
    } else if ((qualifier == null || qualifier.isEmpty()) && !riskType.equalsIgnoreCase(AddOnSubType.ADD_ON_FIXED_AMOUNT)) {
      throw new IllegalStateException(BAD_QUALIFIER);
    } else if (isSimmStandard() && (productClass == null || productClass.isEmpty())) {
      throw new IllegalStateException(BAD_PRODUCT);
    }
  }

  default boolean isAddOn() {
    return AddOnSubType.isAddOnSubType(this.getRiskType());
  }

  default boolean isSimmStandard() {
    return RiskClass.isSimmRiskType(this.getRiskType());
  }

  default String normalizeFxVegaQualifier(String qualifier) {
    String ccy1 = StringUtils.substring(qualifier, 0, 3);
    String ccy2 = StringUtils.substring(qualifier, 3, 6);
    return Stream.of(ccy1, ccy2).sorted().reduce("", String::concat);
  }

  default ProductClass getProductIdentifier() {
    return ProductClass.determineProductClass(this.getProductClass());
  }

  default BucketClass getBucketIdentifier() {
    return BucketClass.determineBucketClass(this.getRiskIdentifier(), this.getQualifier(), this.getBucket());
  }

  default SensitivityIdentifier getConcentrationRiskIdentifier() {
    RiskClass risk = this.getRiskIdentifier();
    if (risk.equals(RiskClass.CREDIT_NON_QUALIFYING) || risk.equals(RiskClass.CREDIT_QUALIFYING)) {
      // for credit risk, the concentration is summed over risk factors with the same issuer and seniority,
      // irrespective of tenor or payment currency. Issuer and seniority should be identified by the qualifier
      return new DefaultSensitivityIdentifier(null, this.getProductClass(), null, this.getQualifier(),
        null, null, null, this.getSensitivityClass(), risk);
    } else if (risk.equals(RiskClass.INTEREST_RATE)) {
      // concentration risk is summed over the currencies, which are exactly the buckets of IR and are indicated by
      // the qualifier
      return new DefaultSensitivityIdentifier(null, this.getProductClass(), null, this.getQualifier(),
        null, null, null, this.getSensitivityClass(), risk);
    } else if (risk.equals(RiskClass.FX)) {
      // fx is also over the currency (qualifier) but in this case there should be only one sensitivity per currency
      return new DefaultSensitivityIdentifier(null, this.getProductClass(), null, this.getQualifier(),
        null, null, null, this.getSensitivityClass(), risk);
    } else {
      // CM or EQ are over the individual sensitivities, so our string should be exact
      return new DefaultSensitivityIdentifier(null, this.getProductClass(), this.getRiskType(), this.getQualifier(),
        this.getBucket(), null, null, this.getSensitivityClass(), risk);
    }
  }

  default SensitivityIdentifier determineRiskFactor() {
    String label1 = this.getLabel1();
    String qualifier = this.getQualifier();
    RiskClass riskClass = this.getRiskIdentifier();

    if (this.getSensitivityClass().equals(SensitivityClass.VEGA) || this.getSensitivityClass().equals(SensitivityClass.CURVATURE)) {
      // we need to sum over all of the vol-tenors for certain risk types, thus we specify label1 which holds vega vol-tenor values
      if (RiskClass.EQUITY.equals(riskClass) ||
        RiskClass.FX.equals(riskClass) ||
        RiskClass.COMMODITY.equals(riskClass) ||
        (RiskClass.INTEREST_RATE.equals(riskClass) && this.getRiskType().equals(RiskClass.RISK_TYPE_INFLATION_VOL))) {
        label1 = null;
      }

      // for FX Vega risk, the order of the currency pair is irrelevant, so we order alphabetically
      if (RiskClass.FX.equals(riskClass)) {
        String ccy1 = StringUtils.substring(qualifier, 0, 3);
        String ccy2 = StringUtils.substring(qualifier, 3, 6);
        qualifier = Stream.of(ccy1, ccy2).sorted().reduce("", (s1, s2) -> s1 + s2);
      }
    }

    return new DefaultSensitivityIdentifier(null, this.getProductClass(), this.getRiskType(), qualifier,
      this.getBucket(), label1, this.getLabel2(), this.getSensitivityClass(), riskClass);
  }

}
