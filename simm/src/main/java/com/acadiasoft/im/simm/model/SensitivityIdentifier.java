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

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.ProductClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.utils.SensitivityUtils;


public interface SensitivityIdentifier {

  public static ProductClass getProductIdentifier(SensitivityIdentifier s) {
    return ProductClass.determineProductClass(s.getProductClass());
  }

  public static RiskClass getRiskIdentifier(SensitivityIdentifier s) {
    return RiskClass.determineByRiskType(s.getRiskType());
  }

  public static BucketClass getBucketIdentifier(SensitivityIdentifier s) {
    return BucketClass.determineBucketClass(getRiskIdentifier(s), s.getQualifier(), s.getBucket());
  }

  public static String getWeightingClassIdentifier(SensitivityIdentifier s) {
    return s.getProductClass() + SensitivityUtils.DELIMITER + s.getRiskType() + SensitivityUtils.DELIMITER + s.getQualifier() + SensitivityUtils.DELIMITER
        + s.getBucket() + SensitivityUtils.DELIMITER + s.getLabel1() + SensitivityUtils.DELIMITER + s.getLabel2();
  }

  public static String getConcentrationRiskIdentifier(SensitivityIdentifier identifier) {
    RiskClass r = getRiskIdentifier(identifier);
    if (r.equals(RiskClass.CREDIT_NON_QUALIFYING) || r.equals(RiskClass.CREDIT_QUALIFYING)) {
      // for credit risk, the concentration is summed over risk factors with the same issuer and seniority,
      // irrespective of tenor or payment currency. Issuer and seniority should be identified by the qualifier
      return identifier.getQualifier();
    } else if (r.equals(RiskClass.INTEREST_RATE)) {
      // concentration risk is summed over the currencies, which are exactly the buckets of IR and are indicated by
      // the qualifier
      return identifier.getQualifier();
    } else if (r.equals(RiskClass.FX)) {
      // fx is also over the currency (qualifier) but in this case there should be only one sensitivity per currency
      return identifier.getQualifier();
    } else {
      // CM or EQ are over the individual sensitivities, so our string should be exact
      return identifier.getProductClass() + SensitivityUtils.DELIMITER + identifier.getRiskType()
          + SensitivityUtils.DELIMITER + identifier.getQualifier() + SensitivityUtils.DELIMITER + identifier.getBucket();
    }
  }

  public String getProductClass();

  public String getRiskType();

  public String getQualifier();

  public String getBucket();

  public String getLabel1();

  public String getLabel2();

}
