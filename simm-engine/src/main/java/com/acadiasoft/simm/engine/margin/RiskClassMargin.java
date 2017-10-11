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

package com.acadiasoft.simm.engine.margin;

import com.acadiasoft.simm.engine.margin.basecorr.BaseCorrSensitivityUtil;
import com.acadiasoft.simm.engine.margin.delta.DeltaSensitivityUtils;
import com.acadiasoft.simm.engine.margin.vega.VegaMargin;
import com.acadiasoft.simm.engine.margin.vega.VegaSensitivityUtils;
import com.acadiasoft.simm.model.product.ProductClass;
import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.sensitivity.IMTree;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.engine.margin.basecorr.BaseCorrMargin;
import com.acadiasoft.simm.engine.margin.curvature.CurvatureMargin;
import com.acadiasoft.simm.engine.margin.delta.DeltaMargin;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author joe.peterson
 */
public class RiskClassMargin implements IMargin {

  private IMargin deltaMargin = new DeltaMargin();
  private IMargin vegaMargin = new VegaMargin();
  private IMargin curvatureMargin = new CurvatureMargin();
  private IMargin baseMargin = new BaseCorrMargin();

  public RiskClassMargin() {
  }

  public RiskClassMargin(IMargin deltaMargin, IMargin vegaMargin, IMargin curvatureMargin, IMargin baseMargin) {
    super();
    this.deltaMargin = deltaMargin;
    this.vegaMargin = vegaMargin;
    this.curvatureMargin = curvatureMargin;
    this.baseMargin = baseMargin;
  }

  /**
   * As defined in Appendix 1 section B.5 of doc/ISDA_SIMM_vR1.0_(PUBLIC).pdf
   */
  @Override
  public BigDecimal calculate(RiskClass riskClass, List<Sensitivity> allSensitivities) {
    BigDecimal delta = deltaMargin.calculate(riskClass, allSensitivities);
    BigDecimal vega = vegaMargin.calculate(riskClass, allSensitivities);
    BigDecimal curvature = curvatureMargin.calculate(riskClass, allSensitivities);

    // handle base corr margin when riskClass is Credit Qualifying
    if (riskClass.equals(RiskClass.CREDIT_QUALIFYING)) {
      BigDecimal base = baseMargin.calculate(riskClass, allSensitivities);
      return delta.add(vega).add(curvature).add(base);
    } else {
      return delta.add(vega).add(curvature);
    }
  }

  @Override
  public BigDecimal calculateIMTree(ProductClass productClass, RiskClass riskClass, List<Sensitivity> allSensitivities, List<IMTree> list) {
    BigDecimal delta = deltaMargin.calculateIMTree(productClass, riskClass, allSensitivities, list);
    if (!DeltaSensitivityUtils.filterForDeltaSensitivitiesOnly(allSensitivities).isEmpty()) {
      list.add(0, new IMTree("5.Sensitivity Type", "SIMM-P", productClass.getLabel(), riskClass.getLabel(), "Delta", "", delta));
    }

    BigDecimal vega = vegaMargin.calculateIMTree(productClass, riskClass, allSensitivities, list);
    if (!VegaSensitivityUtils.filterForVegaSensitivitiesOnly(allSensitivities).isEmpty()) {
      list.add(0, new IMTree("5.Sensitivity Type", "SIMM-P", productClass.getLabel(), riskClass.getLabel(), "Vega", "", vega));
    }

    BigDecimal curvature = curvatureMargin.calculateIMTree(productClass, riskClass, allSensitivities, list);
    if (!VegaSensitivityUtils.filterForVegaSensitivitiesOnly(allSensitivities).isEmpty()) {
      list.add(0, new IMTree("5.Sensitivity Type", "SIMM-P", productClass.getLabel(), riskClass.getLabel(), "Curvature", "", curvature));
    }

    // handle base corr margin when riskClass is Credit Qualifying
    if (riskClass.equals(RiskClass.CREDIT_QUALIFYING)) {
      BigDecimal base = baseMargin.calculateIMTree(productClass, riskClass, allSensitivities, list);
      if (!BaseCorrSensitivityUtil.filterForBaseCorrSensitivitiesOnly(allSensitivities).isEmpty() ) {
        list.add(0, new IMTree("5.Sensitivity Type", "SIMM-P", productClass.getLabel(), riskClass.getLabel(), "Base Correlation", "", base));
      }
      return delta.add(vega).add(curvature).add(base);
    } else {
      return delta.add(vega).add(curvature);
    }
  }

  public IMargin getDeltaMargin() {
    return deltaMargin;
  }

  public void setDeltaMargin(IMargin deltaMargin) {
    this.deltaMargin = deltaMargin;
  }
}
