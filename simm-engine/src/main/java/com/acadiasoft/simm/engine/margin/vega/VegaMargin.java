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

package com.acadiasoft.simm.engine.margin.vega;

import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.engine.margin.IMargin;
import com.acadiasoft.simm.model.sensitivity.BucketWeightedAggregation;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;
import com.acadiasoft.simm.util.BucketWeightedAggregationUtils;
import com.acadiasoft.simm.util.WeightedSensitivityUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author joe.peterson
 */
public class VegaMargin implements IMargin {

  public static final String VEGA_SUFFIX = "Vol";

  /**
   * As defined in Appendix 1 section B.11 of doc/ISDA_SIMM_vR1.0_(PUBLIC).pdf
   */
  @Override
  public BigDecimal calculate(RiskClass riskClass, List<Sensitivity> allSensitivities) {
    List<Sensitivity> vegaSensitivities = VegaSensitivityUtils.filterForVegaSensitivitiesOnly(allSensitivities);
    List<WeightedSensitivity> volWeightSensitivities = VegaMarginWeightUtils.weightSensitivitiesVol(riskClass, vegaSensitivities);
    List<WeightedSensitivity> nettedSensitivities = WeightedSensitivityUtils.netSensitivitiesByRiskFactor(riskClass, volWeightSensitivities);
    List<WeightedSensitivity> riskWeightSensitivities = VegaMarginWeightUtils.weightSensitivitiesRisk(riskClass, nettedSensitivities);
    List<BucketWeightedAggregation> aggregateByBucket = VegaMarginBucketUtils.aggregateByBucket(riskClass, riskWeightSensitivities);
    BigDecimal crossBucket = VegaMarginAcrossBucketUtils.aggregateCrossBucket(riskClass, aggregateByBucket);
    BigDecimal totalVegaMargin = BucketWeightedAggregationUtils.addResidual(riskClass, aggregateByBucket, crossBucket);
    return totalVegaMargin;
  }
}
