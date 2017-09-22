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

package com.acadiasoft.simm.model.cnq;

import com.acadiasoft.simm.model.sensitivity.Sensitivity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class CreditNonQualifyingRiskWeightV2_0 implements CNRiskWeight {

  private static final Map<CreditNonQualifyingBucket, BigDecimal> WEIGHTS = new HashMap<>();

  static {
    WEIGHTS.put(CreditNonQualifyingBucket._1, new BigDecimal("140"));
    WEIGHTS.put(CreditNonQualifyingBucket._2, new BigDecimal("2000"));
    WEIGHTS.put(CreditNonQualifyingBucket.RESIDUAL, new BigDecimal("2000"));
  }

  private static final BigDecimal VEGA = new BigDecimal("0.27");

  @Override
  public BigDecimal getRiskWeight(Sensitivity s) {
    return WEIGHTS.get(CreditNonQualifyingBucket.getBucket(s.getBucket()));
  }

  @Override
  public BigDecimal getVegaRiskWeight(Sensitivity s) {
    return VEGA;
  }

  @Override
  public BigDecimal getHVR() {
    return BigDecimal.ONE;
  }
}
