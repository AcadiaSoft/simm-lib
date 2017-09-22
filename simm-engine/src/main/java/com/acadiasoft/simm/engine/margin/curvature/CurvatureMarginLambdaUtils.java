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

import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;
import com.acadiasoft.simm.util.WeightedSensitivityUtils;
import com.acadiasoft.util.BigDecimalUtils;
import org.apache.commons.math3.special.Erf;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.ONE;

public class CurvatureMarginLambdaUtils {
  /**
   * Φ^−1(x) = √2 * erfinv(2x−1)
   */
  public static final BigDecimal PHI_INV = new BigDecimal(Math.sqrt(2.0) * Erf.erfInv(2 * .995 - 1));

  public static BigDecimal calculateLambda(List<WeightedSensitivity> weightedSensitivies) {
    BigDecimal theta = CurvatureMarginLambdaUtils.calculateTheta(weightedSensitivies);
    return CurvatureMarginLambdaUtils.PHI_INV.pow(2).subtract(ONE).multiply(ONE.add(theta)).subtract(theta);
  }

  public static BigDecimal calculateTheta(List<WeightedSensitivity> weightedSensitivies) {
    BigDecimal sumOfRiskExposures = WeightedSensitivityUtils.sumWeightSensitivities(weightedSensitivies);
    BigDecimal sumOfAbsRiskExposures = WeightedSensitivityUtils.sumAbsoluteValues(weightedSensitivies);
    BigDecimal quotient = BigDecimalUtils.divideWithPrecision(sumOfRiskExposures, sumOfAbsRiskExposures);
    return quotient.min(BigDecimal.ZERO);
  }

}
