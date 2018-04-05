package com.acadiasoft.simm.engine.margin;

import com.acadiasoft.simm.model.object.imtree.ImTree;
import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import com.acadiasoft.simm.model.object.imtree.identifiers.AddOnSubClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.AddOnSubType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductMultiplierMargin implements ImTree {

  private static final String LEVEL = "4.ProductMultiplier";
  private final AddOnSubClass addOnSubClass;
  private final BigDecimal margin;

  private ProductMultiplierMargin(AddOnSubClass addOnSubClass, BigDecimal margin) {
    this.addOnSubClass = addOnSubClass;
    this.margin = margin;
  }

  public static ProductMultiplierMargin calculate(ProductMargin margin, BigDecimal multiplier) {
    AddOnSubClass subClass = AddOnSubClass.determineAddOnSubClass(AddOnSubType.PRODUCT_MULTIPLIER, margin.getProductClass().getLabel());
    return new ProductMultiplierMargin(subClass, margin.getMargin().multiply(multiplier));
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
