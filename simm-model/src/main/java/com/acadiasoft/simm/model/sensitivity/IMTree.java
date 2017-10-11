package com.acadiasoft.simm.model.sensitivity;

import java.math.BigDecimal;

public class IMTree {

  private final String calculationLevel;
  private final String imModel;
  private final String silo;
  private final String riskClass;
  private final String sensitivityType;
  private final String bucket;
  private final BigDecimal imExposure;
  private final String exposureCurrency;

  public IMTree(String cl, String il, String si, String rc, String st, String bu, BigDecimal im) {
    calculationLevel = cl;
    imModel = il;
    silo = si;
    riskClass = rc;
    sensitivityType = st;
    bucket = bu;
    imExposure = im;
    exposureCurrency = "USD";
  }

  public BigDecimal getImExposure() {
    return imExposure;
  }

  public String getBucket() {
    return bucket;
  }

  public String getCalculationLevel() {
    return calculationLevel;
  }

  public String getExposureCurrency() {
    return exposureCurrency;
  }

  public String getImModel() {
    return imModel;
  }

  public String getRiskClass() {
    return riskClass;
  }

  public String getSensitivityType() {
    return sensitivityType;
  }

  public String getSilo() {
    return silo;
  }

  @Override
  public String toString() {
    return "[" + calculationLevel + ", " + imModel + ", " + silo + ", " + riskClass + ", " + sensitivityType + ", "
        + bucket + ", " + imExposure + ", " + exposureCurrency + "]\n";
  }

}
