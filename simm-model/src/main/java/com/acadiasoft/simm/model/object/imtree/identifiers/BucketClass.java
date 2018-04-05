package com.acadiasoft.simm.model.object.imtree.identifiers;

import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import com.acadiasoft.simm.model.param.interestrate.InterestRateCurrencyVolatility;

public class BucketClass implements MarginIdentifier {

  private final BucketType type;
  private final String bucketName;

  private BucketClass(BucketType type, String bucketName) {
    this.bucketName = bucketName;
    this.type = type;
  }

  @Override
  public String getLabel() {
    return bucketName;
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
      return new BucketClass(BucketType.FX, "FX");
    } else if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      String volatilityNumber = InterestRateCurrencyVolatility.get(qualifier).getVolatilityType();
      return new BucketClass(BucketType.determineBucketType(riskClass, volatilityNumber), qualifier);
    } else {
      return new BucketClass(BucketType.determineBucketType(riskClass, bucket), bucket);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof BucketClass)) return false;
    BucketClass other = (BucketClass) obj;
    if (type.equals(other.getBucketType()) && bucketName.equals(other.getBucketName())) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return type.hashCode() + 17 * bucketName.hashCode();
  }
}
