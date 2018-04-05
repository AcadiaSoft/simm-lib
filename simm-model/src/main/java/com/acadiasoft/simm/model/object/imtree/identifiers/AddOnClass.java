package com.acadiasoft.simm.model.object.imtree.identifiers;

import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;

public enum AddOnClass implements MarginIdentifier {

  ADDON("Add On");

  private final String label;

  private AddOnClass(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return label;
  }

}
