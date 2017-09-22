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

import com.acadiasoft.simm.engine.margin.IMargin;
import com.acadiasoft.simm.engine.margin.RiskClassMargin;
import com.acadiasoft.simm.model.addon.AddOnFixedAmount;
import com.acadiasoft.simm.model.addon.AddOnNotional;
import com.acadiasoft.simm.model.addon.AddOnNotionalFactor;
import com.acadiasoft.simm.model.product.ProductClass;
import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.util.SensitivityUtils;
import com.acadiasoft.simm.engine.util.SIMMUtils;
import com.acadiasoft.simm.model.addon.ProductMultiplier;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author joe.peterson
 */
public class SIMM {

  private IMargin margin = new RiskClassMargin();

  public SIMM() {
    super();
  }

  public SIMM(RiskClassMargin margin) {
    super();
    this.margin = margin;
  }

  /**
   * As defined in Appendix 1 section B.6 of doc/ISDA_SIMM_vR1.0_(PUBLIC).pdf
   */
  public BigDecimal calculateStandard(List<Sensitivity> allSensitivities) {
    BigDecimal sum = BigDecimal.ZERO;

    Map<ProductClass, List<Sensitivity>> mapByProductClass = SensitivityUtils.mapByProductClass(allSensitivities);
    for (Entry<ProductClass, List<Sensitivity>> productMapEntry : mapByProductClass.entrySet()) {
      Map<RiskClass, List<Sensitivity>> mapByRiskClass = SensitivityUtils.mapByRiskType(productMapEntry.getValue());
      Map<RiskClass, BigDecimal> marginByRiskClass = new LinkedHashMap<>();
      for (Entry<RiskClass, List<Sensitivity>> riskMapEntry : mapByRiskClass.entrySet()) {
        RiskClass key = riskMapEntry.getKey();
        BigDecimal riskClassMargin = margin.calculate(key, riskMapEntry.getValue());
        SIMMUtils.addToRiskClassMap(marginByRiskClass, key, riskClassMargin);
      }
      BigDecimal finalProductMargin = SIMMUtils.calculateProductMargin(marginByRiskClass);
      sum = sum.add(finalProductMargin);
    }
    return sum;
  }

  public BigDecimal calculateAdditional(List<Sensitivity> allSensitivities, Map<ProductClass, ProductMultiplier> multipliers, Map<String, AddOnNotionalFactor> factors, Map<String, List<AddOnNotional>> notionals, AddOnFixedAmount fixed) {
    BigDecimal sum = BigDecimal.ZERO;

    Map<ProductClass, List<Sensitivity>> mapByProductClass = SensitivityUtils.mapByProductClass(allSensitivities);
    for (Entry<ProductClass, List<Sensitivity>> productMapEntry : mapByProductClass.entrySet()) {
      Map<RiskClass, List<Sensitivity>> mapByRiskClass = SensitivityUtils.mapByRiskType(productMapEntry.getValue());
      Map<RiskClass, BigDecimal> marginByRiskClass = new LinkedHashMap<>();
      for (Entry<RiskClass, List<Sensitivity>> riskMapEntry : mapByRiskClass.entrySet()) {
        RiskClass key = riskMapEntry.getKey();
        BigDecimal riskClassMargin = margin.calculate(key, riskMapEntry.getValue());
        SIMMUtils.addToRiskClassMap(marginByRiskClass, key, riskClassMargin);
      }
      BigDecimal finalProductMargin = SIMMUtils.calculateProductMargin(marginByRiskClass);

      // as in Annex A of v1.3.38, we subtract multilier by ONE to get only additional; also the default multiplier is ONE
      BigDecimal multiplier = multipliers.containsKey(productMapEntry.getKey()) ?
        multipliers.get(productMapEntry.getKey()).getMultiplier().subtract(BigDecimal.ONE) :
        BigDecimal.ZERO;
      sum = sum.add(finalProductMargin.multiply(multiplier));
    }

    // calculate Additonal IM
    // NOTE: we run over the factors so that any notionals which don't have associated factor effectively get multiplied by ZERO
    for (Entry<String, AddOnNotionalFactor> factorEntry : factors.entrySet()) {
      BigDecimal notional = notionals.get(factorEntry.getKey()).stream().map((n) -> n.getNotionalUSD().abs()).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
      BigDecimal additional = notional.multiply(factorEntry.getValue().getPercentFactor());
      sum = sum.add(additional);
    }

    return sum.add(fixed.getAmountUSD());
  }

  public BigDecimal calculateTotal(List<Sensitivity> allSensitivities, Map<ProductClass, ProductMultiplier> multipliers, Map<String, AddOnNotionalFactor> factors, Map<String, List<AddOnNotional>> notionals, AddOnFixedAmount fixed) {
    BigDecimal sum = BigDecimal.ZERO;

    Map<ProductClass, List<Sensitivity>> mapByProductClass = SensitivityUtils.mapByProductClass(allSensitivities);
    for (Entry<ProductClass, List<Sensitivity>> productMapEntry : mapByProductClass.entrySet()) {
      Map<RiskClass, List<Sensitivity>> mapByRiskClass = SensitivityUtils.mapByRiskType(productMapEntry.getValue());
      Map<RiskClass, BigDecimal> marginByRiskClass = new LinkedHashMap<>();
      for (Entry<RiskClass, List<Sensitivity>> riskMapEntry : mapByRiskClass.entrySet()) {
        RiskClass key = riskMapEntry.getKey();
        BigDecimal riskClassMargin = margin.calculate(key, riskMapEntry.getValue());
        SIMMUtils.addToRiskClassMap(marginByRiskClass, key, riskClassMargin);
      }
      BigDecimal finalProductMargin = SIMMUtils.calculateProductMargin(marginByRiskClass);

      // the default multiplier is ONE
      BigDecimal multiplier = multipliers.containsKey(productMapEntry.getKey()) ?
        multipliers.get(productMapEntry.getKey()).getMultiplier() :
        BigDecimal.ONE;
      sum = sum.add(finalProductMargin.multiply(multiplier));
    }

    // calculate Additonal IM
    // NOTE: we run over the factors so that any notionals which don't have associated factor effectively get multiplied by ZERO
    for (Entry<String, AddOnNotionalFactor> factorEntry : factors.entrySet()) {
      BigDecimal notional = notionals.get(factorEntry.getKey()).stream().map((n) -> n.getNotionalUSD().abs()).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
      BigDecimal additional = notional.multiply(factorEntry.getValue().getPercentFactor());
      sum = sum.add(additional);
    }

    return sum.add(fixed.getAmountUSD());
  }
  
  /* TODO: add method to build a TriO like tree of calculation
   * public Tree calculateTree(... normal inputs ...) {
   * 	Tree tree = new Tree()
   *    ... as we run through levels of calc add to tree (will need tree calc functions at each level to fill tree) ...
   *    return tree
   */

}
