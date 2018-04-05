package com.acadiasoft.simm.model.object.imtree.identifiers;

import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import org.apache.commons.lang3.StringUtils;

public enum SensitivityClass implements MarginIdentifier {

  DELTA("Delta"),
  VEGA("Vega"),
  CURVATURE("Curvature"),
  BASECORR("Base Correlation");

  private final String label;
  public static final String VEGA_SUFFIX = "Vol";

  private SensitivityClass(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return label;
  }

  public static SensitivityClass determineByRiskType(String riskType) {
    if (StringUtils.containsIgnoreCase(riskType, VEGA_SUFFIX)) {
      return VEGA;
    } else if (StringUtils.equalsIgnoreCase(riskType, RiskClass.RISK_TYPE_BASE_CORR)) {
      return BASECORR;
    } else {
      return DELTA;
    }
  }

  public static SensitivityClass getByLabel(String label) {
    for (SensitivityClass s: values()) {
      if (label.equals(s.getLabel())) {
        return s;
      }
    }

    throw new IllegalStateException("tried to get sensitivity class label that doesn't exist: [" + label + "]!");
  }

}
