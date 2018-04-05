/*
 * Copyright (c) 2017 AcadiaSoft, Inc.
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

package com.acadiasoft.simm.engine;


import com.acadiasoft.simm.engine.margin.SimmMargin;
import com.acadiasoft.simm.engine.margin.TotalMargin;
import com.acadiasoft.simm.model.object.AddOnFixedAmount;
import com.acadiasoft.simm.model.object.AddOnNotional;
import com.acadiasoft.simm.model.object.AddOnNotionalFactor;
import com.acadiasoft.simm.model.object.ProductMultiplier;
import com.acadiasoft.simm.model.object.imtree.ImTree;
import com.acadiasoft.simm.model.object.imtree.identifiers.ProductClass;
import com.acadiasoft.simm.model.object.Sensitivity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author alec.stewart
 */
public class Simm {

  public static BigDecimal calculateStandard(List<Sensitivity> inputSensitivities) {
    return SimmMargin.calculateStandard(inputSensitivities).getMargin();
  }

  public static BigDecimal calculateAdditional(List<Sensitivity> inputSensitivities, Map<ProductClass, ProductMultiplier> multipliers, Map<String, AddOnNotionalFactor> factors, Map<String, List<AddOnNotional>> notionals, AddOnFixedAmount fixed) {
    return SimmMargin.calculateAdditional(inputSensitivities, multipliers, factors, notionals, fixed).getMargin();
  }

  public static BigDecimal calculateTotal(List<Sensitivity> inputSensitivities, Map<ProductClass, ProductMultiplier> multipliers, Map<String, AddOnNotionalFactor> factors, Map<String, List<AddOnNotional>> notionals, AddOnFixedAmount fixed) {
    return SimmMargin.calculateTotal(inputSensitivities, multipliers, factors, notionals, fixed).getMargin();
  }

  public static ImTree calculateTreeStandard(List<Sensitivity> inputSensitivities) {
    ImTree simm = SimmMargin.calculateStandard(inputSensitivities);
    return TotalMargin.build(simm.getMargin(), simm);
  }

  public static ImTree calculateTreeAdditional(List<Sensitivity> inputSensitivities, Map<ProductClass, ProductMultiplier> multipliers, Map<String, AddOnNotionalFactor> factors, Map<String, List<AddOnNotional>> notionals, AddOnFixedAmount fixed) {
    ImTree simm = SimmMargin.calculateAdditional(inputSensitivities, multipliers, factors, notionals, fixed);
    return TotalMargin.build(simm.getMargin(), simm);
  }

  public static ImTree calculateTreeTotal(List<Sensitivity> inputSensitivities, Map<ProductClass, ProductMultiplier> multipliers, Map<String, AddOnNotionalFactor> factors, Map<String, List<AddOnNotional>> notionals, AddOnFixedAmount fixed) {
    ImTree simm = SimmMargin.calculateTotal(inputSensitivities, multipliers, factors, notionals, fixed);
    return TotalMargin.build(simm.getMargin(), simm);
  }

}

