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

package com.acadiasoft.im.simm.model.param.cq;

import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmRiskWeightBaseCorr;
import com.acadiasoft.im.simm.model.param.SimmSensitivityCorrelationBaseCorr;

import java.math.BigDecimal;

public class BaseCorrRisk implements SimmRiskWeightBaseCorr, SimmSensitivityCorrelationBaseCorr {

  @Override
  public BigDecimal getRiskWeight(WeightingClass w) {
    // currently only one org.acadiasoft.simm.model.risk weight for base corr but the method is here
    // to handle a more complex weighting system if necessary
    return new BigDecimal("7");
  }

  @Override
  public BigDecimal getSensitivityCorrelation(WeightingClass r, WeightingClass s) {
    // currently only one value for correlation but method is here if
    // base corr gets updated to org.acadiasoft.simm.model.sensitivity dependent correlations
    return new BigDecimal("0.14");
  }

}
