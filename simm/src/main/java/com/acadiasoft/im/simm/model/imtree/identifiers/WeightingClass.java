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

package com.acadiasoft.im.simm.model.imtree.identifiers;

import com.acadiasoft.im.base.imtree.identifiers.MarginIdentifier;
import com.acadiasoft.im.simm.model.SensitivityIdentifier;
import com.acadiasoft.im.simm.model.utils.SensitivityUtils;

public class WeightingClass implements MarginIdentifier, SensitivityIdentifier {

  private final String productClass;
  private final String riskType;
  private final String qualifier;
  private final String bucket;
  private final String label1;
  private final String label2;

  private WeightingClass(String riskFactorKey) {
    String[] values = riskFactorKey.split(SensitivityUtils.DELIMITER, 6);
    this.productClass = values[0];
    this.riskType = values[1];
    this.qualifier = values[2];
    this.bucket = values[3];
    this.label1 = values[4];
    this.label2 = values[5];
  }

  public static WeightingClass determineWeightingClass(String key) {
    return new WeightingClass(key);
  }

  @Override
  public String getLabel() {
    return qualifier;
  }

  @Override
  public String getProductClass() {
    return productClass;
  }

  @Override
  public String getRiskType() {
    return riskType;
  }

  @Override
  public String getQualifier() {
    return qualifier;
  }

  @Override
  public String getBucket() {
    return bucket;
  }

  @Override
  public String getLabel1() {
    return label1;
  }

  @Override
  public String getLabel2() {
    return label2;
  }

  public BucketClass getBucketIdentifier() {
    return SensitivityIdentifier.getBucketIdentifier(this);
  }

  public RiskClass getRiskClass() {
    return SensitivityIdentifier.getRiskIdentifier(this);
  }

  public String getConcentrationRiskIdentifier() {
    return SensitivityIdentifier.getConcentrationRiskIdentifier(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof WeightingClass)) return false;
    WeightingClass other = (WeightingClass) obj;
    if (productClass.equalsIgnoreCase(other.getProductClass()) &&
        riskType.equalsIgnoreCase(other.getRiskType()) &&
        qualifier.equalsIgnoreCase(other.getQualifier()) &&
        bucket.equalsIgnoreCase(other.getBucket()) &&
        label1.equalsIgnoreCase(other.getLabel1()) &&
        label2.equalsIgnoreCase(other.getLabel2())) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    int prime = 7;
    int result = productClass.hashCode() + riskType.hashCode() + qualifier.hashCode();
    result = prime * result + bucket.hashCode() + label1.hashCode() + label2.hashCode();
    return prime * result;
  }

}
