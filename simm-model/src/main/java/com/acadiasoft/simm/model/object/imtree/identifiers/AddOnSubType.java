package com.acadiasoft.simm.model.object.imtree.identifiers;

import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;

public enum AddOnSubType implements MarginIdentifier {

  FIXED_AMOUNT("AddOnFixed"),
  NOTIONAL("AddOnNotional"),
  NOTIONAL_FACTOR("AddOnFactor"),
  PRODUCT_MULTIPLIER("AddOnMultiplier");

  // ADD ON PARAMETER'S RISK TYPES
  public static final String ADD_ON_FIXED_AMOUNT = "Param_AddOnFixedAmount";
  public static final String ADD_ON_NOTIONAL = "Notional";
  public static final String ADD_ON_NOTIONAL_FACTOR = "Param_AddOnNotionalFactor";
  public static final String ADD_ON_PRODUCT_MULTIPLIER = "Param_ProductClassMultiplier";

  private String label;

  private AddOnSubType(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return label;
  }

  public static AddOnSubType determineAddOnType(String riskType) {
    switch (riskType) {
      case ADD_ON_FIXED_AMOUNT:
        return FIXED_AMOUNT;
      case ADD_ON_NOTIONAL:
        return NOTIONAL;
      case ADD_ON_NOTIONAL_FACTOR:
        return NOTIONAL_FACTOR;
      case ADD_ON_PRODUCT_MULTIPLIER:
        return PRODUCT_MULTIPLIER;
      default:
        throw new RuntimeException("Unknown Add On Risk Type: [" + riskType + "]!");

    }
  }

}
