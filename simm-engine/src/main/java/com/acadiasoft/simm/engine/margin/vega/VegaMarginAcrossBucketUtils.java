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

import com.acadiasoft.simm.engine.param.RiskConcentration;
import com.acadiasoft.simm.engine.param.RiskCorrelation;
import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.sensitivity.BucketWeightedAggregation;
import com.acadiasoft.simm.util.BucketWeightedAggregationUtils;
import com.acadiasoft.simm.util.WeightedSensitivityUtils;
import com.acadiasoft.util.BigDecimalUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;

public class VegaMarginAcrossBucketUtils {

  /**
   * As defined in Appendix 1 ISDA_SIMM_2.0_(PUBLIC).pdf
   */
  static BigDecimal aggregateCrossBucket(RiskClass riskClass, List<BucketWeightedAggregation> aggregateByBucket) {
    List<BucketWeightedAggregation> nonResiduals = BucketWeightedAggregationUtils.filterOutResiduals(aggregateByBucket);
    if (CollectionUtils.isNotEmpty(nonResiduals)) {
      BigDecimal sumSquaresByBucket = BucketWeightedAggregationUtils.sumSquared(nonResiduals);
      BigDecimal sumCorrelationsAcrossBuckets = sumCorrelationsAcrossBuckets(riskClass, nonResiduals);
      BigDecimal crossSum = sumSquaresByBucket.add(sumCorrelationsAcrossBuckets);
      BigDecimal crossSqrt = BigDecimalUtils.sqrt(crossSum);
      return crossSqrt;
    } else {
      return BigDecimal.ZERO;
    }
  }

  static BigDecimal sumCorrelationsAcrossBuckets(RiskClass riskClass, List<BucketWeightedAggregation> aggregateByBucket) {
    BigDecimal sum = BigDecimal.ZERO;

    if (CollectionUtils.isNotEmpty(aggregateByBucket)) {
      for (BucketWeightedAggregation bucketAggregateB : aggregateByBucket) {
        for (BucketWeightedAggregation bucketAggregateC : aggregateByBucket) {
          if (!StringUtils.equals(bucketAggregateB.getBucket(), bucketAggregateC.getBucket())) {
            BigDecimal concentrationRiskFactor = RiskConcentration.getVegaCrossBucketConcentration(riskClass, bucketAggregateB, bucketAggregateC);
            BigDecimal correlation = RiskCorrelation.getBucketCorrelation(riskClass, bucketAggregateB.getBucket(), bucketAggregateC.getBucket());

            BigDecimal bucketBSum = WeightedSensitivityUtils.sumWeightSensitivities(bucketAggregateB.getWeightedSensitivities());
            BigDecimal bucketCSum = WeightedSensitivityUtils.sumWeightSensitivities(bucketAggregateC.getWeightedSensitivities());

            BigDecimal bucketBAggregate = bucketAggregateB.getAggregate();
            BigDecimal bucketCAggregate = bucketAggregateC.getAggregate();
            BigDecimal sb = bucketBSum.min(bucketBAggregate).max(bucketBAggregate.negate());
            BigDecimal sc = bucketCSum.min(bucketCAggregate).max(bucketCAggregate.negate());
            BigDecimal product = correlation.multiply(concentrationRiskFactor).multiply(sb).multiply(sc);
            sum = sum.add(product);
          }
        }
      }
    }
    return sum;
  }
}
