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

package com.acadiasoft.simm.model.equity;

import com.acadiasoft.simm.model.sensitivity.Sensitivity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * As defined in Appendix 1 of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class EquityRiskWeightV2_0 implements EQRiskWeight {

  private static final Map<EquityBucket, BigDecimal> WEIGHTS = new HashMap<>();

  static {
    WEIGHTS.put(EquityBucket._1, new BigDecimal("25"));
    WEIGHTS.put(EquityBucket._2, new BigDecimal("32"));
    WEIGHTS.put(EquityBucket._3, new BigDecimal("29"));
    WEIGHTS.put(EquityBucket._4, new BigDecimal("27"));
    WEIGHTS.put(EquityBucket._5, new BigDecimal("18"));
    WEIGHTS.put(EquityBucket._6, new BigDecimal("21"));
    WEIGHTS.put(EquityBucket._7, new BigDecimal("25"));
    WEIGHTS.put(EquityBucket._8, new BigDecimal("22"));
    WEIGHTS.put(EquityBucket._9, new BigDecimal("27"));
    WEIGHTS.put(EquityBucket._10, new BigDecimal("29"));
    WEIGHTS.put(EquityBucket._11, new BigDecimal("16"));
    WEIGHTS.put(EquityBucket._12, new BigDecimal("16"));
    WEIGHTS.put(EquityBucket.RESIDUAL, new BigDecimal("32"));
  }

  private static final BigDecimal VEGA = new BigDecimal("0.28");
  private static final BigDecimal VEGA12 = new BigDecimal("0.64");

  private static final BigDecimal HVR = new BigDecimal("0.65");

  @Override
  public BigDecimal getRiskWeight(Sensitivity s) {
    return WEIGHTS.get(EquityBucket.getBucket(s.getBucket()));
  }

  @Override
  public BigDecimal getVegaRiskWeight(Sensitivity s) {
    if (s.getBucket().equals("12")) {
      // bucket 12 has its own VRW as per doc/ISDA-SIMM-v1.3.38 paragraph 57
      return VEGA12;
    } else {
      return VEGA;
    }
  }

  @Override
  public BigDecimal getHVR() {
    return HVR;
  }
}
