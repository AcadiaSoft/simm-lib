/*
 * Copyright (c) 2018 AcadiaSoft, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.acadiasoft.im.simm.engine.margin;

import com.acadiasoft.im.base.imtree.identifiers.ImModelClass;
import com.acadiasoft.im.base.imtree.ImTree;
import com.acadiasoft.im.base.imtree.identifiers.MarginIdentifier;
import com.acadiasoft.im.simm.model.*;
import com.acadiasoft.im.simm.model.imtree.identifiers.ProductClass;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.simm.model.utils.SensitivityUtils;

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

  public static SimmMargin calculateAdditional(List<Sensitivity> inputSensitivities, Map<ProductClass, ProductMultiplier> multipliers, Map<String, AddOnNotionalFactor> factors, Map<String, List<AddOnNotional>> notionals, List<AddOnFixedAmount> fixed) {
    List<ProductMargin> marginByProductClass = getMarginByProductClass(inputSensitivities);
    AddOnMargin addOn = AddOnMargin.calculate(marginByProductClass, multipliers, factors, notionals, fixed);
    return new SimmMargin(addOn.getMargin(), addOn);
  }

  public static SimmMargin calculateTotal(List<Sensitivity> inputSensitivities, Map<ProductClass, ProductMultiplier> multipliers, Map<String, AddOnNotionalFactor> factors, Map<String, List<AddOnNotional>> notionals, List<AddOnFixedAmount> fixed) {
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
