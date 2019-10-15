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

package com.acadiasoft.im.simm.model.imtree.identifiers;

import com.acadiasoft.im.base.imtree.identifiers.MarginIdentifier;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum AddOnSubType implements MarginIdentifier {

  FIXED_AMOUNT("AddOnFixed"),
  NOTIONAL("AddOnNotional"),
  NOTIONAL_FACTOR("AddOnFactor"),
  PRODUCT_MULTIPLIER("AddOnMultiplier");

  // ADD ON PARAMETER'S RISK TYPES
  public static final String ADD_ON_FIXED_AMOUNT = "Param_AddOnFixedAmount";
  public static final String ADD_ON_NOTIONAL = "Notional";
  public static final String ADD_ON_NOTIONAL_FACTOR = "Param_AddOnNotionalFactor";
  public static final String ADD_ON_PRODUCT_MULTIPLIER = "Param_ProductClassMultiplier";
  public static final List<String> ADD_ON_TYPES_LIST = Collections.unmodifiableList(
      Arrays.asList(ADD_ON_FIXED_AMOUNT, ADD_ON_NOTIONAL, ADD_ON_NOTIONAL_FACTOR, ADD_ON_PRODUCT_MULTIPLIER)
  );

  private String label;

  private AddOnSubType(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return label;
  }

  public static boolean isAddOnSubType(String riskType) {
    return ADD_ON_TYPES_LIST.stream().anyMatch(riskType::equalsIgnoreCase);
  }

  public static AddOnSubType determineAddOnType(String riskType) {
    if (StringUtils.equalsIgnoreCase(ADD_ON_FIXED_AMOUNT, riskType)) {
      return FIXED_AMOUNT;
    } else if (StringUtils.equalsIgnoreCase(ADD_ON_NOTIONAL, riskType)) {
      return NOTIONAL;
    } else if (StringUtils.equalsIgnoreCase(ADD_ON_NOTIONAL_FACTOR, riskType)) {
      return NOTIONAL_FACTOR;
    } else if (StringUtils.equalsIgnoreCase(ADD_ON_PRODUCT_MULTIPLIER, riskType)) {
      return PRODUCT_MULTIPLIER;
    } else {
      throw new RuntimeException("Unknown Add On Risk Type: [" + riskType + "]!");
    }
  }
}
