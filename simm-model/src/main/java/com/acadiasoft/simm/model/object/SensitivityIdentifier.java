package com.acadiasoft.simm.model.object;

import com.acadiasoft.simm.model.object.imtree.identifiers.BucketClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.ProductClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.RiskClass;

import static com.acadiasoft.simm.model.util.SensitivityUtils.DELIMITER;

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
    return s.getProductClass() + DELIMITER + s.getRiskType() + DELIMITER + s.getQualifier() + DELIMITER
        + s.getBucket() + DELIMITER + s.getLabel1() + DELIMITER + s.getLabel2();
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
      return identifier.getProductClass() + DELIMITER + identifier.getRiskType()
          + DELIMITER + identifier.getQualifier() + DELIMITER + identifier.getBucket();
    }
  }

  public String getProductClass();

  public String getRiskType();

  public String getQualifier();

  public String getBucket();

  public String getLabel1();

  public String getLabel2();

}
