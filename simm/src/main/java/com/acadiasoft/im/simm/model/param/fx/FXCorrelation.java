/*
 * Copyright (c) 2019 AcadiaSoft, Inc.
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

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmBucketCorrelation;
import com.acadiasoft.im.simm.model.param.SimmFxSensitivityCorrelation;
import com.acadiasoft.im.simm.model.param.SimmSensitivityCorrelation;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * As defined in Appendix 1 section I of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class FXCorrelation implements SimmBucketCorrelation, SimmFxSensitivityCorrelation {

  public static final BigDecimal CORRELATION = new BigDecimal("0.5");

  private static final List<String> HIGH_VOLATILITY = Collections.singletonList("BRL");
  private static final BigDecimal ONE = new BigDecimal("0.729");
  private static final BigDecimal TWO = new BigDecimal("0.368");


  @Override
  public BigDecimal getSensitivityCorrelation(WeightingClass si, WeightingClass sk, String calculationCurrency) {
    String ccy1 = si.getQualifier();
    String ccy2 = sk.getQualifier();
    if (HIGH_VOLATILITY.contains(calculationCurrency)) {
      if (!HIGH_VOLATILITY.contains(ccy1) && !HIGH_VOLATILITY.contains(ccy2)) {
        return ONE;
      } else {
        return CORRELATION;
      }
    } else {
      if ((HIGH_VOLATILITY.contains(ccy1) && HIGH_VOLATILITY.contains(ccy2))
        || (!HIGH_VOLATILITY.contains(ccy1) && !HIGH_VOLATILITY.contains(ccy2))) {
        return CORRELATION;
      } else {
        return TWO;
      }
    }
  }

  @Override
  public BigDecimal getBucketCorrelation(BucketClass bi, BucketClass bk) {
    // all FX in the same bucket, so we should actually never call this method
    return BigDecimal.ONE;
  }

}
