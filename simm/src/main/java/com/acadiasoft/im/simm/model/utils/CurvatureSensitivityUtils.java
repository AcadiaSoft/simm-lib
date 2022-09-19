/*
 * Copyright (c) 2022 Acadia, Inc.
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

package com.acadiasoft.im.simm.model.utils;

import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.simm.config.HoldingPeriod;
import com.acadiasoft.im.simm.config.SimmConfig;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.imtree.identifiers.BucketType;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CurvatureSensitivityUtils {

  // Curvature scaling suffixes
  private static final String TENOR_SUFFIX_WEEKS = "w";

  private static final String TENOR_SUFFIX_MONTHS = "m";
  private static final String TENOR_SUFFIX_YEARS = "y";

  // Curvature scaling constants
  private static final BigDecimal ONE_POINT_FOUR = BigDecimal.valueOf(1.40);
  private static final BigDecimal FOURTEEN = BigDecimal.valueOf(14.0);
  private static final BigDecimal ONE_HALF = BigDecimal.valueOf(0.5);

  // Curvature scaling day-in counts
  private static final BigDecimal NUM_OF_MONTHS = BigDecimal.valueOf(12);
  private static final BigDecimal DAYS_IN_WEEK = BigDecimal.valueOf(7);
  private static final BigDecimal DAYS_IN_YEAR = BigDecimal.valueOf(365);
  private static final BigDecimal DAYS_PER_MONTH = BigDecimalUtils.divideWithPrecision(DAYS_IN_YEAR, NUM_OF_MONTHS);

  // the curvature margin of EQV bucket 12 is taken to be zero so filter out any EQV-12 sensitivities
  private static Predicate<Sensitivity> FILTER_EQUITY_VOL_BUCKET_12 = sensitivity -> {
    BucketType bucketType = sensitivity.getBucketIdentifier().getBucketType();
    return sensitivity.getSensitivityClass().equals(SensitivityClass.VEGA) && !bucketType.equals(BucketType.EQ12);
  };

  public static List<Sensitivity> makeAndScaleCurvatures(List<Sensitivity> sensitivities, SimmConfig config) {
    return sensitivities.stream() //
        .filter(FILTER_EQUITY_VOL_BUCKET_12) //
        .map(sensitivity -> Sensitivity.curvatureFromVega(sensitivity, config)) //
        .map(sensitivity -> { //
          BigDecimal scalingFactor = getScalingFunction(sensitivity.getLabel1(), config);
          BigDecimal scaledAmountUsd = sensitivity.getAmountUsd(config.fxRate()).multiply(scalingFactor);
          return Sensitivity.fromIdentifier(sensitivity, scaledAmountUsd);
        }).collect(Collectors.toList());
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

  private static BigDecimal getScalingFunction(String expiry, SimmConfig config) {
    BigDecimal days = getNumberOfDays(expiry);
    BigDecimal divide = (config.holdingPeriod().equals(HoldingPeriod.ONE_DAY)) ? ONE_POINT_FOUR : FOURTEEN;
    BigDecimal fraction = BigDecimalUtils.divideWithPrecision(divide, days);
    BigDecimal min = BigDecimal.ONE.min(fraction);
    return ONE_HALF.multiply(min);
  }
}
