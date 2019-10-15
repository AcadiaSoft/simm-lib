/*
 * Copyright (c) 2019 AcadiaSoft, Inc.
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

import com.acadiasoft.im.base.imtree.ImTree;
import com.acadiasoft.im.base.imtree.identifiers.MarginIdentifier;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.ProductClass;
import com.acadiasoft.im.simm.model.AddOnFixedAmount;
import com.acadiasoft.im.simm.model.AddOnNotional;
import com.acadiasoft.im.simm.model.AddOnNotionalFactor;
import com.acadiasoft.im.simm.model.ProductMultiplier;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import org.apache.commons.collections4.CollectionUtils;

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

  public static AddOnMargin calculate(List<ProductMargin> marginByProduct, Map<ProductClass, ProductMultiplier> multipliers, Map<String, AddOnNotionalFactor> factors, Map<String, List<AddOnNotional>> notionals, List<AddOnFixedAmount> fixed) {
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

    if (!CollectionUtils.isEmpty(fixed)) {
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
