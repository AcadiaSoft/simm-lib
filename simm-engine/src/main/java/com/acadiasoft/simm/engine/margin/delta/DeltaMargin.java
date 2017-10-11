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

package com.acadiasoft.simm.engine.margin.delta;

import com.acadiasoft.simm.engine.margin.IMargin;
import com.acadiasoft.simm.model.product.ProductClass;
import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.sensitivity.BucketWeightedAggregation;
import com.acadiasoft.simm.model.sensitivity.IMTree;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;
import com.acadiasoft.simm.util.BucketWeightedAggregationUtils;
import com.acadiasoft.simm.util.SensitivityUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author joe.peterson
 */
public class DeltaMargin implements IMargin {

  /**
   * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
   */
  @Override
  public BigDecimal calculate(RiskClass riskClass, List<Sensitivity> allSensitivities) {
    List<Sensitivity> deltaSensitivities = DeltaSensitivityUtils.filterForDeltaSensitivitiesOnly(allSensitivities);
    List<Sensitivity> nettedSensitivities = SensitivityUtils.netSensitivitiesByRiskFactor(riskClass, deltaSensitivities);
    List<WeightedSensitivity> weightSensitivities = DeltaMarginWeightUtils.weightSensitivities(riskClass, nettedSensitivities);
    List<BucketWeightedAggregation> aggregateByBucket = DeltaMarginBucketUtils.aggregateByBucket(riskClass, weightSensitivities);
    BigDecimal crossBucket = DeltaMarginAcrossBucketUtils.aggregateCrossBucket(riskClass, aggregateByBucket);
    BigDecimal totalDeltaMargin = BucketWeightedAggregationUtils.addResidual(riskClass, aggregateByBucket, crossBucket);
    return totalDeltaMargin;
  }

  @Override
  public BigDecimal calculateIMTree(ProductClass productClass, RiskClass riskClass, List<Sensitivity> allSensitivities, List<IMTree> list) {
    List<Sensitivity> deltaSensitivities = DeltaSensitivityUtils.filterForDeltaSensitivitiesOnly(allSensitivities);
    List<Sensitivity> nettedSensitivities = SensitivityUtils.netSensitivitiesByRiskFactor(riskClass, deltaSensitivities);
    List<WeightedSensitivity> weightSensitivities = DeltaMarginWeightUtils.weightSensitivities(riskClass, nettedSensitivities);
    List<BucketWeightedAggregation> aggregateByBucket = DeltaMarginBucketUtils.aggregateByBucket(riskClass, weightSensitivities);

    // NOTE: All buckets (including residual are in the weighted aggregation list)
    for (BucketWeightedAggregation bwa : aggregateByBucket) {
      list.add(0, new IMTree("6.Bucket", "SIMM-P", productClass.getLabel(), riskClass.getLabel(), "Delta", bwa.getBucket(), bwa.getAggregate()));
    }

    BigDecimal crossBucket = DeltaMarginAcrossBucketUtils.aggregateCrossBucket(riskClass, aggregateByBucket);
    BigDecimal totalDeltaMargin = BucketWeightedAggregationUtils.addResidual(riskClass, aggregateByBucket, crossBucket);
    return totalDeltaMargin;
  }
}
