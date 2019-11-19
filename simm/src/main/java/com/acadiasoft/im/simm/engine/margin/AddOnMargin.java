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

import com.acadiasoft.im.base.margin.GroupMargin;
import com.acadiasoft.im.base.margin.SiloMargin;
import com.acadiasoft.im.base.model.imtree.ImTree;
import com.acadiasoft.im.base.model.imtree.MarginIdentifier;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.simm.config.SimmConfig;
import com.acadiasoft.im.simm.model.FixedAmount;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnSubType;
import com.acadiasoft.im.simm.model.imtree.identifiers.ProductClass;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddOnMargin extends SiloMargin {

  private final static String LEVEL = "3.AddOn";

  private AddOnMargin(BigDecimal margin, List<GroupMargin> children) {
    super(LEVEL, AddOnClass.ADDON, margin, children);
  }

  public static AddOnMargin calculate(List<Sensitivity> addOns, List<ProductMargin> marginByProduct, SimmConfig config) {
    List<GroupMargin> subAddOn = new ArrayList<>();

    Map<MarginIdentifier, ProductMargin> mappedMargins = marginByProduct.stream()
      .collect(Collectors.toMap(ProductMargin::getMarginIdentifier, Function.identity()));
    addOns.stream().filter(sensitivity -> sensitivity.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_PRODUCT_MULTIPLIER))
      .forEach(multiplier -> {
        ProductClass productClass = config.useSingleProductClass() ? ProductClass.SINGLE : multiplier.getMultiplierProduct();
        ProductMargin productMargin = mappedMargins.get(productClass);
        subAddOn.add(ProductMultiplierMargin.calculate(multiplier, productMargin));
      });

    List<Sensitivity> notionalAddOns = addOns.stream()
      .filter(sensitivity -> sensitivity.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_NOTIONAL)
        || sensitivity.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_NOTIONAL_FACTOR))
      .collect(Collectors.toList());
    if (!notionalAddOns.isEmpty()) {
      subAddOn.add(AddOnNotionalMargin.calculate(notionalAddOns, config));
    }

    List<FixedAmount> fixed = addOns.stream()
      .filter(sensitivity -> sensitivity.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_FIXED_AMOUNT))
      .collect(Collectors.toList());
    if (!fixed.isEmpty()) {
      subAddOn.add(AddOnFixedMargin.calculate(fixed, config));
    }

    return new AddOnMargin(BigDecimalUtils.sum(subAddOn, ImTree::getMargin), subAddOn);
  }

}
