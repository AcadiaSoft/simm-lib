package com.acadiasoft.simm.model.object.imtree.identifiers;

import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import org.apache.commons.lang3.StringUtils;

public enum ImModelClass implements MarginIdentifier {

  SIMM("SIMM-P"),
  SCHEDULE("Schedule");

  private final static String SIMM1 = "SIMM-P";
  private final static String SIMM2 = "SIMM";
  private final static String SCHEDULE1 = "Schedule";

  private final String name;

  private ImModelClass(String name) {
    this.name = name;
  }

  @Override
  public String getLabel() {
    return name;
  }

  public static ImModelClass determineModelClass(String name) {
    if (StringUtils.equalsIgnoreCase(SIMM1, name) ||
        StringUtils.equalsIgnoreCase(SIMM2, name)) {
      return SIMM;
    } else if (StringUtils.equalsIgnoreCase(SCHEDULE1, name)) {
      return SCHEDULE;
    }

    throw new IllegalStateException("Found unknown model string: [" + name + "]!");
  }

}
