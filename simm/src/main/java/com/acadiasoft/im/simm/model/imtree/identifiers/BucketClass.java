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

package com.acadiasoft.im.simm.model.imtree.identifiers;

import com.acadiasoft.im.base.model.imtree.identifiers.BundleClass;
import com.acadiasoft.im.simm.model.param.fx.FXCurrencyVolatility;
import com.acadiasoft.im.simm.model.param.interestrate.InterestRateCurrencyVolatility;

public class BucketClass extends BundleClass {

  private final BucketType type;
  private final String bucketName;

  private BucketClass(BucketType type, String bucketName) {
    super(bucketName);
    this.bucketName = bucketName;
    this.type = type;
  }

  public BucketType getBucketType() {
    return type;
  }

  public String getBucketName() {
    // Name is a unique identifier
    return bucketName;
  }

  public static BucketClass determineBucketClass(RiskClass riskClass, String qualifier, String bucket) {
    if (riskClass.equals(RiskClass.FX)) {
      String volatilityNumber = FXCurrencyVolatility.get(qualifier).getVolatilityType();
      return new BucketClass(BucketType.determineBucketType(riskClass, volatilityNumber), qualifier);
    } else if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      String volatilityNumber = InterestRateCurrencyVolatility.get(qualifier).getVolatilityType();
      return new BucketClass(BucketType.determineBucketType(riskClass, volatilityNumber), qualifier);
    } else {
      return new BucketClass(BucketType.determineBucketType(riskClass, bucket), bucket);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof BucketClass)) {
      return false;
    } else {
      BucketClass other = (BucketClass) obj;
      return type.equals(other.getBucketType()) && bucketName.equalsIgnoreCase(other.getBucketName());
    }
  }

  @Override
  public int hashCode() {
    return type.hashCode() + 17 * bucketName.hashCode();
  }
}
