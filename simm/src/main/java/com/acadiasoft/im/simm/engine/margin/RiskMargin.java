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
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.simm.model.utils.SensitivityUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alec.stewart
 */
public class RiskMargin implements ImTree {

  private static final String LEVEL = "4.Risk Class";
  private final RiskClass riskClass;
  private final BigDecimal margin;
  private final List<SensitivityMargin> children = new ArrayList<>();

  private RiskMargin(RiskClass riskClass, BigDecimal margin, List<SensitivityMargin> marginBySensitivityClass) {
    this.riskClass = riskClass;
    this.margin = margin;
    this.children.addAll(marginBySensitivityClass);
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

  @Override
  public MarginIdentifier getMarginIdentifier() {
    return riskClass;
  }

  public RiskClass getRiskClass() {
    return riskClass;
  }

  public static RiskMargin calculate(RiskClass riskClass, List<Sensitivity> sensitivities, String calculationCurrency) {
    List<SensitivityMargin> marginBySensitivityClass = SensitivityUtils.listByMargin(
        e -> SensitivityMargin.calculate(riskClass, e.getKey(), e.getValue(), calculationCurrency),
        SensitivityUtils.mapByIdentifier(s -> s.getSensitivityIdentifier(), sensitivities)
    );
    // we sum across the sensitivity margins in the Risk Class to get the total IM for that Risk Class
    // NOTE: since each Risk Class Margin only has the sensitivities associated with its own risk class, we can do a straight
    //    sum because all of the base corr sensitivities are in only the Credit Qualifying Risk Class by definition
    BigDecimal sum = BigDecimalUtils.sum(marginBySensitivityClass, m -> m.getMargin());
    return new RiskMargin(riskClass, sum, marginBySensitivityClass);
  }

}
