package com.acadiasoft.simm.engine.margin;

import com.acadiasoft.simm.model.object.imtree.ImTree;
import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import com.acadiasoft.simm.model.object.imtree.identifiers.AddOnClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.ImModelClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.ProductClass;
import com.acadiasoft.simm.model.object.AddOnFixedAmount;
import com.acadiasoft.simm.model.object.AddOnNotional;
import com.acadiasoft.simm.model.object.AddOnNotionalFactor;
import com.acadiasoft.simm.model.object.ProductMultiplier;
import com.acadiasoft.simm.model.util.BigDecimalUtils;
import com.acadiasoft.simm.model.util.SensitivityUtils;
import org.apache.commons.collections.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddOnMargin implements ImTree {

  private final static String LEVEL = "3.AddOn";
  private final BigDecimal margin;
  private final List<ImTree> children = new ArrayList<>();

  private AddOnMargin(BigDecimal margin, List<ImTree> children) {
    this.margin = margin;
    this.children.addAll(children);
  }

  public static AddOnMargin calculate(List<ProductMargin> marginByProduct, Map<ProductClass, ProductMultiplier> multipliers, Map<String, AddOnNotionalFactor> factors, Map<String, List<AddOnNotional>> notionals, AddOnFixedAmount fixed) {
    List<ImTree> subAddOn = new ArrayList<>();
    if (!CollectionUtils.isEmpty(multipliers.entrySet())) {
      List<ProductMultiplierMargin> multiplierMargins = marginByProduct.stream()
          .filter(m -> multipliers.containsKey(m.getProductClass()))
          .map(m -> ProductMultiplierMargin.calculate(m, multipliers.get(m.getProductClass()).getMultiplier().subtract(BigDecimal.ONE)))
          .collect(Collectors.toList());
      subAddOn.addAll(multiplierMargins);
    }

    if (!CollectionUtils.isEmpty(factors.entrySet())) {
      AddOnNotionalMargin notionalMargin = AddOnNotionalMargin.calculate(factors, notionals);
      subAddOn.add(notionalMargin);
    }

    if (!fixed.getAmountUsd().equals(BigDecimal.ZERO)) {
      AddOnFixedMargin fixedMargin = AddOnFixedMargin.calculate(fixed);
      subAddOn.add(fixedMargin);
    }

    BigDecimal total = BigDecimalUtils.sum(subAddOn, m -> m.getMargin());
    return new AddOnMargin(total, subAddOn);
  }

  @Override
  public MarginIdentifier getMarginIdentifier() {
    return AddOnClass.ADDON;
  }

  @Override
  public BigDecimal getMargin() {
    return margin;
  }

  @Override
  public List<ImTree> getChildren() {
    List<ImTree> list = new ArrayList<>();
    list.addAll(children);
    return list;
  }

  @Override
  public String getTreeLevel() {
    return LEVEL;
  }

}
