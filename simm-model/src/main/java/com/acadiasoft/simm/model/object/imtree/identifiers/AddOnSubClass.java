package com.acadiasoft.simm.model.object.imtree.identifiers;

import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;

public class AddOnSubClass implements MarginIdentifier {

  private final AddOnSubType type;
  private final String name;

  private AddOnSubClass(AddOnSubType type, String name) {
    this.type = type;
    this.name = name;
  }

  @Override
  public String getLabel() {
    return name;
  }

  public AddOnSubType getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public static AddOnSubClass determineAddOnSubClass(AddOnSubType type, String name) {
    return new AddOnSubClass(type, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof AddOnSubClass)) return false;
    AddOnSubClass other = (AddOnSubClass) obj;
    return type.equals(other.getType()) && name.equals(other.getName());
  }

  @Override
  public int hashCode() {
    return type.hashCode() + 7 * name.hashCode();
  }

}
