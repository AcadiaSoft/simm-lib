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

package com.acadiasoft.simm.engine.margin.curvature;

import com.acadiasoft.simm.engine.margin.IMargin;
import com.acadiasoft.simm.engine.margin.vega.VegaSensitivityUtils;
import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.sensitivity.BucketWeightedAggregation;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.util.WeightedSensitivityUtils;
import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author joe.peterson
 */
public class CurvatureMargin implements IMargin {

  private static final BigDecimal INTEREST_RATE_SCALE_FACTOR = new BigDecimal("2.3");

  /**
   * As defined in Appendix 1 section B.12 of doc/ISDA_SIMM_vR1.0_(PUBLIC).pdf
   */
  @Override
  public BigDecimal calculate(RiskClass riskClass, List<Sensitivity> allSensitivities) {
    List<Sensitivity> vegaSensitivities = VegaSensitivityUtils.filterForVegaSensitivitiesOnly(allSensitivities);
    List<WeightedSensitivity> weightSensitivities = CurvatureMarginWeightUtils.weightSensitivities(riskClass, vegaSensitivities);
    List<WeightedSensitivity> nettedSensitivities = WeightedSensitivityUtils.netSensitivitiesByRiskFactor(riskClass, weightSensitivities);
    List<BucketWeightedAggregation> aggregateByBucket = CurvatureMarginBucketUtils.aggregateByBucket(riskClass, nettedSensitivities);
    BigDecimal crossBucket = CurvatureMarginAcrossBucketUtils.aggregateCrossBucket(riskClass, aggregateByBucket);
    BigDecimal curvatureMarginResidual = CurvatureMarginResidualUtils.calculateCurvatureMarginResidual(aggregateByBucket);
    BigDecimal totalCurvatureMargin = crossBucket.add(curvatureMarginResidual);
    if (RiskClass.INTEREST_RATE.equals(riskClass)) {
      totalCurvatureMargin = totalCurvatureMargin.multiply(INTEREST_RATE_SCALE_FACTOR);
    }
    return totalCurvatureMargin;
  }
}
