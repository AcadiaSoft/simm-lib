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
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.utils.ConcentrationRiskGroup;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WeightingMargin implements ImTree {

  private final String LEVEL = "7.Weighted Sensitivity";
  private final WeightingClass weightingClass;
  private final BigDecimal margin;
  private final ConcentrationRiskGroup concentrationRiskClass;

  private WeightingMargin(WeightingClass weightingClass, BigDecimal margin, ConcentrationRiskGroup concentrationRiskClass) {
    this.weightingClass = weightingClass;
    this.margin = margin;
    this.concentrationRiskClass = concentrationRiskClass;
  }

  public static WeightingMargin calculate(Sensitivity sensitivity, ConcentrationRiskGroup concentrationRiskClass, String calculationCurrency) {
    WeightingClass weightingClass = WeightingClass.determineWeightingClass(sensitivity.getWeightingClassIdentifier());
    BigDecimal riskWeight = SimmRiskWeight.get(sensitivity.getSensitivityIdentifier(), weightingClass, calculationCurrency);
    BigDecimal amountUsd = sensitivity.getAmountUsd();
    BigDecimal concentrationRisk = concentrationRiskClass.getConcentrationRisk();
    return new WeightingMargin(weightingClass, riskWeight.multiply(amountUsd).multiply(concentrationRisk), concentrationRiskClass);
  }

  @Override
  public MarginIdentifier getMarginIdentifier() {
    return weightingClass;
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

  public WeightingClass getWeightingClass() {
    return weightingClass;
  }

  public ConcentrationRiskGroup getConcentrationRiskClass() {
    return concentrationRiskClass;
  }
}
