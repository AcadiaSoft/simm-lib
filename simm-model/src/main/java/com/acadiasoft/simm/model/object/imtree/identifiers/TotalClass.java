package com.acadiasoft.simm.model.object.imtree.identifiers;

import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;

public enum TotalClass implements MarginIdentifier {

  TOTAL("Total");

  private final String label;

  private TotalClass(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return label;
  }

}
