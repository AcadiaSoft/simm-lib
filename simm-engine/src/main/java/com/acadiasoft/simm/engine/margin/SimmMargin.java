package com.acadiasoft.simm.engine.margin;

import com.acadiasoft.simm.model.object.imtree.ImTree;
import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import com.acadiasoft.simm.model.object.imtree.identifiers.ImModelClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.ProductClass;
import com.acadiasoft.simm.model.object.AddOnFixedAmount;
import com.acadiasoft.simm.model.object.AddOnNotional;
import com.acadiasoft.simm.model.object.AddOnNotionalFactor;
import com.acadiasoft.simm.model.object.ProductMultiplier;
import com.acadiasoft.simm.model.object.Sensitivity;
import com.acadiasoft.simm.model.util.SensitivityUtils;
import com.acadiasoft.simm.model.util.BigDecimalUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimmMargin implements ImTree {

  private final static String LEVEL = "2.ImModel";
  private final BigDecimal margin;
  private final List<ImTree> children = new ArrayList<>();

  private SimmMargin(BigDecimal margin, List<ProductMargin> marginByBucket, AddOnMargin addOn) {
    this.margin = margin;
    this.children.addAll(marginByBucket);
    this.children.add(addOn);
  }

  private SimmMargin(BigDecimal margin, AddOnMargin addOn) {
    this.margin = margin;
    this.children.add(addOn);
  }

  private SimmMargin(BigDecimal margin, List<ProductMargin> marginByBucket) {
    this.margin = margin;
    this.children.addAll(marginByBucket);
  }

  public static SimmMargin calculateStandard(List<Sensitivity> inputSensitivities) {
    List<ProductMargin> marginByProductClass = getMarginByProductClass(inputSensitivities);
    BigDecimal productSum = BigDecimalUtils.sum(marginByProductClass, m -> m.getMargin());
    return new SimmMargin(productSum, marginByProductClass);
  }

  public static SimmMargin calculateAdditional(List<Sensitivity> inputSensitivities, Map<ProductClass, ProductMultiplier> multipliers, Map<String, AddOnNotionalFactor> factors, Map<String, List<AddOnNotional>> notionals, AddOnFixedAmount fixed) {
    List<ProductMargin> marginByProductClass = getMarginByProductClass(inputSensitivities);
    AddOnMargin addOn = AddOnMargin.calculate(marginByProductClass, multipliers, factors, notionals, fixed);
    return new SimmMargin(addOn.getMargin(), addOn);
  }

  public static SimmMargin calculateTotal(List<Sensitivity> inputSensitivities, Map<ProductClass, ProductMultiplier> multipliers, Map<String, AddOnNotionalFactor> factors, Map<String, List<AddOnNotional>> notionals, AddOnFixedAmount fixed) {
    List<ProductMargin> marginByProductClass = getMarginByProductClass(inputSensitivities);
    AddOnMargin addOn = AddOnMargin.calculate(marginByProductClass, multipliers, factors, notionals, fixed);
    BigDecimal productSum = BigDecimalUtils.sum(marginByProductClass, m -> m.getMargin());
    return new SimmMargin(productSum.add(addOn.getMargin()), marginByProductClass, addOn);
  }

  private static List<ProductMargin> getMarginByProductClass(List<Sensitivity> inputSensitivities) {
    // get all input sensitivities on the same "level"
    List<Sensitivity> allSensitivities = SensitivityUtils.handleInputSensitivities(inputSensitivities);

    // Now that we have gotten all of the input sensitivities on he same level and generate curvature sensitivities, we net
    List<Sensitivity> nettedSensitivities = SensitivityUtils.netSensitivitiesByRiskFactor(allSensitivities);

    // map sensitivities by product class, build the exposure of each product class
    return SensitivityUtils.listByMargin(
        e -> ProductMargin.calculate(e.getKey(), e.getValue()),
        SensitivityUtils.mapByIdentifier(s -> s.getProductIdentifier(), nettedSensitivities)
    );
  }

  @Override
  public MarginIdentifier getMarginIdentifier() {
    return ImModelClass.SIMM;
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
