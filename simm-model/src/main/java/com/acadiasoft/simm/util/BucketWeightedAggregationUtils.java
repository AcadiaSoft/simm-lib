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

package com.acadiasoft.simm.util;

import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.model.sensitivity.BucketWeightedAggregation;
import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;
import com.acadiasoft.util.BigDecimalUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BucketWeightedAggregationUtils {

  public static BigDecimal sumSquared(List<BucketWeightedAggregation> aggregateByCurrency) {
    return BigDecimalUtils.sumSquared(aggregateByCurrency, BucketWeightedAggregation::getAggregate);
  }

  public static List<BucketWeightedAggregation> filterOutResiduals(List<BucketWeightedAggregation> aggregateByBucket) {
    return aggregateByBucket.stream().filter((agg) -> !StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, agg.getBucket())).collect(Collectors.toList());
  }

  public static List<BucketWeightedAggregation> filterOutNonResiduals(List<BucketWeightedAggregation> aggregateByBucket) {
    return aggregateByBucket.stream().filter((agg) -> StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, agg.getBucket())).collect(Collectors.toList());
  }

  public static BigDecimal addResidual(RiskClass riskClass, List<BucketWeightedAggregation> aggregateByBucket, BigDecimal crossBucket) {
    BigDecimal totalDeltaMargin = crossBucket;
    if (!RiskClass.INTEREST_RATE.equals(riskClass)) {
      BigDecimal residual = aggregateByBucket.stream()//
        .filter((agg) -> StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, agg.getBucket()))//
        .map(BucketWeightedAggregation::getAggregate) //
        .reduce(BigDecimalUtils::sum) //
        .orElse(BigDecimal.ZERO);
      totalDeltaMargin = totalDeltaMargin.add(residual);
    }
    return totalDeltaMargin;
  }

  public static BigDecimal sumWeightedSensitivities(List<BucketWeightedAggregation> nonResiduals) {
    return nonResiduals.stream().map(BucketWeightedAggregation::getWeightedSensitivities).flatMap(Collection::stream).map(WeightedSensitivity::getWeightedValue)
      .reduce(BigDecimalUtils::sum).get();
  }

}
