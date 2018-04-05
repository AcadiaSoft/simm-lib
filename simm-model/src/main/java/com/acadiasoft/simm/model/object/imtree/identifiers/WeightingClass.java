package com.acadiasoft.simm.model.object.imtree.identifiers;

import com.acadiasoft.simm.model.object.SensitivityIdentifier;
import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;

import static com.acadiasoft.simm.model.util.SensitivityUtils.DELIMITER;

public class WeightingClass implements MarginIdentifier, SensitivityIdentifier {

  private final String productClass;
  private final String riskType;
  private final String qualifier;
  private final String bucket;
  private final String label1;
  private final String label2;

  private WeightingClass(String riskFactorKey) {
    String[] values = riskFactorKey.split(DELIMITER, 6);
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
    if (productClass.equals(other.getProductClass()) &&
        riskType.equals(other.getRiskType()) &&
        qualifier.equals(other.getQualifier()) &&
        bucket.equals(other.getBucket()) &&
        label1.equals(other.getLabel1()) &&
        label2.equals(other.getLabel2())) {
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
