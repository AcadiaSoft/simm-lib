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
import com.acadiasoft.im.simm.model.FixedAmount;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnSubClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnSubType;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class AddOnFixedMargin extends GroupMargin {

  private static final String LEVEL = "4.AddOnFixed";

  private AddOnFixedMargin(AddOnSubClass addOnSubClass, BigDecimal margin) {
    super(LEVEL, addOnSubClass, margin, Collections.emptyList());
  }

  public static AddOnFixedMargin calculate(List<FixedAmount> fixed, SimmConfig config) {
    AddOnSubClass subClass = AddOnSubClass.determineAddOnSubClass(AddOnSubType.FIXED_AMOUNT, AddOnSubType.FIXED_AMOUNT.getMarginIdentifier());
    BigDecimal fixedAmount = BigDecimalUtils.sum(fixed, f -> f.getAmountUsd(config.fxRate()));
    return new AddOnFixedMargin(subClass, fixedAmount);
  }

}
