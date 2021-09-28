/*
 * Copyright (c) 2021 AcadiaSoft, Inc.
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

package com.acadiasoft.im.simm.model.param.fx;

import static com.acadiasoft.im.simm.model.param.fx.FXCurrencyVolatility.REGULAR_VOLATILITY;

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmBucketCorrelation;
import com.acadiasoft.im.simm.model.param.SimmFxSensitivityCorrelation;

import java.math.BigDecimal;

/**
 * As defined in Appendix 1 section I of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class FXCorrelation implements SimmBucketCorrelation, SimmFxSensitivityCorrelation {

  public static final BigDecimal CORRELATION = new BigDecimal("0.5");

  private static final BigDecimal[][] HIGH_CALC_CURRENCY_CORRELATIONS = {
      { // High
          new BigDecimal("0.5"), // High
          new BigDecimal("0.39"), // Regular
      },
      { // Regular
          new BigDecimal("0.39"), // High
          new BigDecimal("0.85"), // Regular
      } };

  private static final BigDecimal[][] REGULAR_CALC_CURRENCY_CORRELATIONS = {
      { // High
          new BigDecimal("0.69"), // High
          new BigDecimal("0.28"), // Regular
      },
      { // Regular
          new BigDecimal("0.28"), // High
          new BigDecimal("0.5"), // Regular
      } };

  @Override
  public BigDecimal getSensitivityCorrelation(WeightingClass si, WeightingClass sk, String calculationCurrency) {
    FXCurrencyVolatility siCurrencyVolatility = FXCurrencyVolatility.get(si.getQualifier());
    FXCurrencyVolatility skCurrencyVolatility = FXCurrencyVolatility.get(si.getQualifier());
    int siBucket = Integer.valueOf(siCurrencyVolatility.getVolatilityType());
    int skBucket = Integer.valueOf(skCurrencyVolatility.getVolatilityType());
    return getBucketCorrelation(calculationCurrency, siBucket, skBucket);
  }

  public BigDecimal getBucketCorrelation(String calculationCurrency, int siBucket, int skBucket) {
    FXCurrencyVolatility calcCurrencyVolatility = FXCurrencyVolatility.get(calculationCurrency);
    if (REGULAR_VOLATILITY.equals(calcCurrencyVolatility)) {
      return REGULAR_CALC_CURRENCY_CORRELATIONS[siBucket - 1][skBucket - 1];
    } else {
      return HIGH_CALC_CURRENCY_CORRELATIONS[siBucket - 1][skBucket - 1];
    }
  }

  public BigDecimal getBucketCorrelation(String calculationCurrency, BucketClass bi, BucketClass bk) {
    return getBucketCorrelation(calculationCurrency, bi.getBucketType().getBucketNumber(), bk.getBucketType().getBucketNumber());
  }

  @Override
  @Deprecated
  public BigDecimal getBucketCorrelation(BucketClass bi, BucketClass bk) {
    throw new UnsupportedOperationException();
  }
}
