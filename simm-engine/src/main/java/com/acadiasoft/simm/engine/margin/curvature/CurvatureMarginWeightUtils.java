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

import com.acadiasoft.simm.engine.margin.vega.VegaMarginWeightUtils;
import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;
import com.acadiasoft.util.BigDecimalUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * As defined in Appendix 1 of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class CurvatureMarginWeightUtils {

  private static final String TENOR_SUFFIX_WEEKS = "w";
  private static final String TENOR_SUFFIX_MONTHS = "m";
  private static final String TENOR_SUFFIX_YEARS = "y";
  private static final BigDecimal FOURTEEN = new BigDecimal("14.0");
  private static final BigDecimal NUM_OF_MONTHS = new BigDecimal("12");
  private static final BigDecimal CONST = new BigDecimal("0.5");
  private static final BigDecimal DAYS_IN_WEEK = new BigDecimal("7");
  private static final BigDecimal DAYS_IN_YEAR = new BigDecimal("365");
  private static final BigDecimal DAYS_PER_MONTH = BigDecimalUtils.divideWithPrecision(DAYS_IN_YEAR, NUM_OF_MONTHS);

  /**
   * As defined in Appendix 1 section B.12.a of doc/ISDA_SIMM_vR1.0_(PUBLIC).pdf
   */
  public static List<WeightedSensitivity> weightSensitivities(RiskClass riskClass, List<Sensitivity> sensitivities) {
    return sensitivities.stream().map((s) -> weightSensitivity(riskClass, s)).collect(Collectors.toList());
  }

  static WeightedSensitivity weightSensitivity(RiskClass riskClass, Sensitivity sensitivity) {
    BigDecimal volFactor = VegaMarginWeightUtils.getVolatilityFactor(riskClass);
    BigDecimal riskWeight = VegaMarginWeightUtils.getConditionalRiskWeight(riskClass, sensitivity);
    BigDecimal scalingFunction = getScalingFunction(sensitivity.getLabel1());
    BigDecimal weightedValue = scalingFunction.multiply(volFactor).multiply(riskWeight).multiply(sensitivity.getAmountUsd());
    return new WeightedSensitivity(sensitivity, weightedValue);
  }

  private static BigDecimal getScalingFunction(String expiry) {
    BigDecimal days = getNumberOfDays(expiry);
    BigDecimal divide = BigDecimalUtils.divideWithPrecision(FOURTEEN, days);
    BigDecimal min = BigDecimal.ONE.min(divide);
    return CONST.multiply(min);
  }

  private static BigDecimal getNumberOfDays(String expiry) {
    if (StringUtils.endsWithIgnoreCase(expiry, TENOR_SUFFIX_YEARS)) {
      return DAYS_IN_YEAR.multiply(new BigDecimal(StringUtils.replaceIgnoreCase(expiry, TENOR_SUFFIX_YEARS, StringUtils.EMPTY)));
    } else if (StringUtils.endsWithIgnoreCase(expiry, TENOR_SUFFIX_MONTHS)) {
      return DAYS_PER_MONTH.multiply(new BigDecimal(StringUtils.replaceIgnoreCase(expiry, TENOR_SUFFIX_MONTHS, StringUtils.EMPTY)));
    } else {
      return DAYS_IN_WEEK.multiply(new BigDecimal(StringUtils.replaceIgnoreCase(expiry, TENOR_SUFFIX_WEEKS, StringUtils.EMPTY)));
    }
  }
}
