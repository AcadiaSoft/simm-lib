package com.acadiasoft.simm.engine.margin;

import com.acadiasoft.simm.model.object.AddOnFixedAmount;
import com.acadiasoft.simm.model.object.imtree.ImTree;
import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import com.acadiasoft.simm.model.object.imtree.identifiers.AddOnSubClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.AddOnSubType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AddOnFixedMargin implements ImTree {

  private static final String LEVEL = "4.AddOnFixed";
  private final AddOnSubClass addOnSubClass;
  private final BigDecimal margin;

  private AddOnFixedMargin(AddOnSubClass addOnSubClass, BigDecimal margin) {
    this.addOnSubClass = addOnSubClass;
    this.margin = margin;
  }

  public static AddOnFixedMargin calculate(AddOnFixedAmount fixed) {
    AddOnSubClass subClass = AddOnSubClass.determineAddOnSubClass(AddOnSubType.FIXED_AMOUNT, AddOnSubType.FIXED_AMOUNT.getLabel());
    return new AddOnFixedMargin(subClass, fixed.getAmountUsd());
  }

  @Override
  public MarginIdentifier getMarginIdentifier() {
    return addOnSubClass;
  }

  @Override
  public BigDecimal getMargin() {
    return margin;
  }

  @Override
  public List<ImTree> getChildren() {
    return new ArrayList<>();
  }

  @Override
  public String getTreeLevel() {
    return LEVEL;
  }

}
