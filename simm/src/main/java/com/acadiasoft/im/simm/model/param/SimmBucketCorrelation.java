/*
 * Copyright (c) 2018 AcadiaSoft, Inc.
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

package com.acadiasoft.im.simm.model.param;

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.param.cnq.CreditNonQualifyingCorrelationV2_1;
import com.acadiasoft.im.simm.model.param.commodity.CommodityCorrelationV2_1;
import com.acadiasoft.im.simm.model.param.cq.CreditQualifyingCorrelationV2_1;
import com.acadiasoft.im.simm.model.param.equity.EquityCorrelationV2_1;
import com.acadiasoft.im.simm.model.param.fx.FXCorrelationV2_1;
import com.acadiasoft.im.simm.model.param.interestrate.InterestRateCorrelationV2_1;

import java.math.BigDecimal;

public interface SimmBucketCorrelation {

  public static BigDecimal get(RiskClass riskClass, BucketClass r, BucketClass s) {
    if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      return new InterestRateCorrelationV2_1().getBucketCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.CREDIT_QUALIFYING)) {
      return new CreditQualifyingCorrelationV2_1().getBucketCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return new CreditNonQualifyingCorrelationV2_1().getBucketCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.EQUITY)) {
      return new EquityCorrelationV2_1().getBucketCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.COMMODITY)) {
      return new CommodityCorrelationV2_1().getBucketCorrelation(r, s);
    } else if (riskClass.equals(RiskClass.FX)) {
      return new FXCorrelationV2_1().getBucketCorrelation(r, s);
    } else {
      throw new IllegalStateException("tried to get a threshold for unknown risk class: [" + riskClass + "]!");
    }
  }

  public BigDecimal getBucketCorrelation(BucketClass r, BucketClass s);

}
