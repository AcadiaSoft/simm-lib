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
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnSubClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnSubType;
import com.acadiasoft.im.simm.model.AddOnNotional;
import com.acadiasoft.im.simm.model.AddOnNotionalFactor;
import com.acadiasoft.im.base.util.BigDecimalUtils;

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
