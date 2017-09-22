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

import com.acadiasoft.simm.engine.param.RiskConcentration;
import com.acadiasoft.simm.engine.param.RiskCorrelation;
import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.sensitivity.BucketWeightedAggregation;
import com.acadiasoft.simm.util.WeightedSensitivityUtils;
import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;
import com.acadiasoft.util.BigDecimalUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DeltaMarginBucketUtils {

  /**
   * As defined in Appendix 1 of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
   */
  static List<BucketWeightedAggregation> aggregateByBucket(RiskClass riskClass, List<WeightedSensitivity> weightSensitivities) {
    Map<String, List<WeightedSensitivity>> mapByBucket = WeightedSensitivityUtils.mapByBucket(riskClass, weightSensitivities);

    List<BucketWeightedAggregation> bucketWeightedAggregations = new ArrayList<>();

    for (Entry<String, List<WeightedSensitivity>> entry : mapByBucket.entrySet()) {
      String bucket = entry.getKey();
      List<WeightedSensitivity> ws = entry.getValue();
      BigDecimal aggregate = calculateAggregateOfBucket(riskClass, entry.getValue());
      BucketWeightedAggregation agg = new BucketWeightedAggregation(bucket, aggregate, ws);
      bucketWeightedAggregations.add(agg);
    }

    return bucketWeightedAggregations;
  }

  static BigDecimal calculateAggregateOfBucket(RiskClass riskClass, List<WeightedSensitivity> weightedSensitivities) {
    BigDecimal sumOfSquaredMargins = WeightedSensitivityUtils.sumSquared(weightedSensitivities);
    BigDecimal sumOfCorrelations = sumCorrelationsOfBucket(riskClass, weightedSensitivities);
    BigDecimal totalSum = sumOfSquaredMargins.add(sumOfCorrelations);
    return BigDecimalUtils.sqrt(totalSum);
  }

  static BigDecimal sumCorrelationsOfBucket(RiskClass riskClass, List<WeightedSensitivity> weightedSensitivities) {
    BigDecimal sum = BigDecimal.ZERO;

    for (WeightedSensitivity weightedSensitivityK : weightedSensitivities) {
      for (WeightedSensitivity weightedSensitivityI : weightedSensitivities) {
        if (!weightedSensitivityI.equals(weightedSensitivityK)) {
          BigDecimal concentrationRisk = RiskConcentration.getDeltaIntraBucketCorrelation(riskClass, weightedSensitivityI, weightedSensitivityK, weightedSensitivities);
          BigDecimal correlation = RiskCorrelation.getSensitivityCorrelation(riskClass, weightedSensitivityI.getSensitivity(), weightedSensitivityK.getSensitivity());
          BigDecimal value = concentrationRisk.multiply(correlation).multiply(weightedSensitivityI.getWeightedValue()).multiply(weightedSensitivityK.getWeightedValue());
          sum = sum.add(value);
        }
      }
    }

    return sum;
  }
}
