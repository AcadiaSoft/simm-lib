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

package com.acadiasoft.im.simm.engine;

import com.acadiasoft.im.base.imtree.ImTree;
import com.acadiasoft.im.base.imtree.TotalMargin;
import com.acadiasoft.im.simm.engine.margin.SimmMargin;
import com.acadiasoft.im.simm.model.*;
import com.acadiasoft.im.simm.model.imtree.identifiers.ProductClass;
import com.acadiasoft.im.simm.model.utils.SensitivityUtils;
import com.acadiasoft.im.simm.model.utils.SimmCalculationType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author alec.stewart
 */
public class Simm {

  public static BigDecimal calculateStandard(List<Sensitivity> inputSensitivities, String calculationCurrency) {
    return calculate(inputSensitivities, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), calculationCurrency, SimmCalculationType.STANDARD).getMargin();
  }

  public static BigDecimal calculateAdditional(List<Sensitivity> inputSensitivities, List<ProductMultiplier> multipliers, List<AddOnNotionalFactor> factors, List<AddOnNotional> notionals, List<AddOnFixedAmount> fixed, String calculationCurrency) {
    return calculate(inputSensitivities, multipliers, factors, notionals, fixed, calculationCurrency, SimmCalculationType.ADDITIONAL).getMargin();
  }

  public static BigDecimal calculateTotal(List<Sensitivity> inputSensitivities, List<ProductMultiplier> multipliers, List<AddOnNotionalFactor> factors, List<AddOnNotional> notionals, List<AddOnFixedAmount> fixed, String calculationCurrency) {
    return calculate(inputSensitivities, multipliers, factors, notionals, fixed, calculationCurrency, SimmCalculationType.TOTAL).getMargin();
  }

  public static ImTree calculateTreeStandard(List<Sensitivity> inputSensitivities, String calculationCurrency) {
    return TotalMargin.build(calculate(inputSensitivities, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), calculationCurrency, SimmCalculationType.STANDARD));
  }

  public static ImTree calculateTreeAdditional(List<Sensitivity> inputSensitivities, List<ProductMultiplier> multipliers, List<AddOnNotionalFactor> factors, List<AddOnNotional> notionals, List<AddOnFixedAmount> fixed, String calculationCurrency) {
    return TotalMargin.build(calculate(inputSensitivities, multipliers, factors, notionals, fixed, calculationCurrency, SimmCalculationType.ADDITIONAL));
  }

  public static ImTree calculateTreeTotal(List<Sensitivity> inputSensitivities, List<ProductMultiplier> multipliers, List<AddOnNotionalFactor> factors, List<AddOnNotional> notionals, List<AddOnFixedAmount> fixed, String calculationCurrency) {
    return TotalMargin.build(calculate(inputSensitivities, multipliers, factors, notionals, fixed, calculationCurrency, SimmCalculationType.TOTAL));
  }

  public static ImTree calculate(List<Sensitivity> inputSensitivities, List<ProductMultiplier> multipliers, List<AddOnNotionalFactor> factors, List<AddOnNotional> notionals, List<AddOnFixedAmount> fixed, String calculationCurrency, SimmCalculationType type) {
    List<Sensitivity> filtered = SensitivityUtils.filterDeltaFxRiskInCalcCurrency(inputSensitivities, calculationCurrency);
    if (type.equals(SimmCalculationType.STANDARD)) return SimmMargin.calculateStandard(filtered, calculationCurrency);
    Map<ProductClass, ProductMultiplier> multiplierMap = SensitivityUtils.groupByThenTakeFirst(multipliers, ProductMultiplier::getProductClass);
    Map<String, AddOnNotionalFactor> factorMap = SensitivityUtils.groupByThenTakeFirst(factors, AddOnNotionalFactor::getProduct);
    Map<String, List<AddOnNotional>> notionalMap = SensitivityUtils.groupBy(notionals, AddOnNotional::getProduct);
    if (type.equals(SimmCalculationType.ADDITIONAL)) {
      return SimmMargin.calculateAdditional(filtered, multiplierMap, factorMap, notionalMap, fixed, calculationCurrency);
    } else if (type.equals(SimmCalculationType.TOTAL)) {
      return SimmMargin.calculateTotal(filtered, multiplierMap, factorMap, notionalMap, fixed, calculationCurrency);
    } else {
      throw new RuntimeException("Called a SIMM calculation with unknown type: [" + type + "]");
    }
  }
}

