package com.acadiasoft.simm.engine.margin;

import com.acadiasoft.simm.model.object.AddOnNotional;
import com.acadiasoft.simm.model.object.AddOnNotionalFactor;
import com.acadiasoft.simm.model.object.imtree.ImTree;
import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import com.acadiasoft.simm.model.object.imtree.identifiers.AddOnSubClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.AddOnSubType;
import com.acadiasoft.simm.model.util.BigDecimalUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddOnNotionalMargin implements ImTree {

  private static final String LEVEL = "4.AddOnNotional";
  private final AddOnSubClass addOnSubClass;
  private final BigDecimal margin;

  private AddOnNotionalMargin(AddOnSubClass addOnSubClass, BigDecimal margin) {
    this.addOnSubClass = addOnSubClass;
    this.margin = margin;
  }

  public static AddOnNotionalMargin calculate(Map<String, AddOnNotionalFactor> factors, Map<String, List<AddOnNotional>> notionals) {
    AddOnSubClass subClass = AddOnSubClass.determineAddOnSubClass(AddOnSubType.NOTIONAL, AddOnSubType.NOTIONAL.getLabel());
    BigDecimal notionalMargin = factors.entrySet().stream()
        .filter(e -> notionals.containsKey(e.getKey()))
        .map(e -> {
          BigDecimal factor = e.getValue().getPercentFactor();
          BigDecimal productNotional = BigDecimalUtils.sum(notionals.get(e.getKey()), n -> n.getNotionalUsd().abs());
          return factor.multiply(productNotional);
        })
        .reduce(BigDecimal.ZERO, BigDecimal::add);

    return new AddOnNotionalMargin(subClass, notionalMargin);
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
