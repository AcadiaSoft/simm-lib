/*
 * Copyright (c) 2021 AcadiaSoft, Inc.
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
import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.simm.config.SimmConfig;
import com.acadiasoft.im.simm.model.Notional;
import com.acadiasoft.im.simm.model.NotionalFactor;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnSubClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnSubType;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddOnNotionalMargin extends GroupMargin {

  private static final String LEVEL = "4.AddOnNotional";

  private AddOnNotionalMargin(AddOnSubClass addOnSubClass, BigDecimal margin) {
    super(LEVEL, addOnSubClass, margin, Collections.emptyList());
  }

  public static AddOnNotionalMargin calculate(List<Sensitivity> notionalAddOns, SimmConfig config) {
    AddOnSubClass subClass = AddOnSubClass.determineAddOnSubClass(AddOnSubType.NOTIONAL, AddOnSubType.NOTIONAL.getMarginIdentifier());
    Map<String, NotionalFactor> factors = notionalAddOns.stream()
      .filter(sensitivity -> sensitivity.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_NOTIONAL_FACTOR))
      .collect(Collectors.toMap(NotionalFactor::getNotionalProduct, Function.identity()));
    Map<String, List<Notional>> notionals = notionalAddOns.stream()
      .filter(sensitivity -> sensitivity.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_NOTIONAL))
      .collect(Collectors.groupingBy(Notional::getNotionalProduct, Collectors.toList()));
    BigDecimal notionalMargin = factors.keySet().stream()
        .filter(notionals::containsKey)
        .map(product -> {
          BigDecimal factor = factors.get(product).getPercentFactor();
          BigDecimal productNotional = BigDecimalUtils.sum(notionals.get(product), n -> n.getAmountUsd(config.fxRate()).abs());
          return factor.multiply(productNotional);
        })
        .reduce(BigDecimal.ZERO, BigDecimal::add);

    return new AddOnNotionalMargin(subClass, notionalMargin);
  }

}
