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

import com.acadiasoft.simm.model.sensitivity.BucketWeightedAggregation;
import com.acadiasoft.simm.util.BucketWeightedAggregationUtils;
import com.acadiasoft.simm.util.WeightedSensitivityUtils;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.ZERO;

public class CurvatureMarginResidualUtils {

  /**
   * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
   */
  static BigDecimal calculateCurvatureMarginResidual(List<BucketWeightedAggregation> aggregateByBucket) {
    List<BucketWeightedAggregation> residuals = BucketWeightedAggregationUtils.filterOutNonResiduals(aggregateByBucket);
    BigDecimal sum = ZERO;
    for (BucketWeightedAggregation bucketWeightedAggregation : residuals) {
      BigDecimal weightedSensitivitiesSum = WeightedSensitivityUtils.sumWeightSensitivities(bucketWeightedAggregation.getWeightedSensitivities());
      BigDecimal calculateLambda = CurvatureMarginLambdaUtils.calculateLambda(bucketWeightedAggregation.getWeightedSensitivities());
      BigDecimal product = calculateLambda.multiply(bucketWeightedAggregation.getAggregate());
      BigDecimal riskFactorTotal = weightedSensitivitiesSum.add(product);
      sum = sum.add(riskFactorTotal);
    }
    return sum.max(ZERO);
  }

}
