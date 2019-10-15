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
import com.acadiasoft.im.simm.model.imtree.identifiers.ProductClass;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.param.SimmRiskClassCorrelation;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.simm.model.utils.SensitivityUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductMargin implements ImTree {

  private static final String LEVEL = "3.Silo";
  private final ProductClass productClass;
  private final BigDecimal margin;
  private final List<RiskMargin> marginByRiskClass = new ArrayList<>();

  private ProductMargin(ProductClass productClass, BigDecimal margin, List<RiskMargin> marginByRiskClass) {
    this.productClass = productClass;
    this.margin = margin;
    this.marginByRiskClass.addAll(marginByRiskClass);
  }

  @Override
  public BigDecimal getMargin() {
    return margin;
  }

  @Override
  public MarginIdentifier getMarginIdentifier() {
    return productClass;
  }

  @Override
  public List<ImTree> getChildren() {
    List<ImTree> list = new ArrayList<>();
    list.addAll(marginByRiskClass);
    return list;
  }

  @Override
  public String getTreeLevel() {
    return LEVEL;
  }

  public static ProductMargin calculate(ProductClass product, List<Sensitivity> sensitivities, String calculationCurrency) {
    List<RiskMargin> marginByRiskClass = SensitivityUtils.listByMargin(
        e -> RiskMargin.calculate(e.getKey(), e.getValue(), calculationCurrency),
        SensitivityUtils.mapByIdentifier(s -> s.getRiskIdentifier(), sensitivities)
    );
    BigDecimal sumSquared = BigDecimalUtils.sumSquared(marginByRiskClass, m -> m.getMargin());
    BigDecimal sumCorrelated = BigDecimalUtils.sumCorrelated(
        marginByRiskClass,
        (m) -> m.getMargin(),
        (r, s) -> SimmRiskClassCorrelation.get(r.getRiskClass(), s.getRiskClass()),
        (r, s) -> !r.getRiskClass().equals(s.getRiskClass())
    );
    BigDecimal sqrt = BigDecimalUtils.sqrt(sumSquared.add(sumCorrelated));
    return new ProductMargin(product, sqrt, marginByRiskClass);
  }

  public ProductClass getProductClass() {
    return productClass;
  }
}
