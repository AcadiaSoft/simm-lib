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

package com.acadiasoft.im.simm.model.param.equity;

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketType;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * As defined in Appendix 1 of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class EquityRiskWeight implements SimmRiskWeight {

  private static final Map<BucketType, BigDecimal> WEIGHTS = new HashMap<>();

  static {
    WEIGHTS.put(BucketType.EQ1, new BigDecimal("22"));
    WEIGHTS.put(BucketType.EQ2, new BigDecimal("26"));
    WEIGHTS.put(BucketType.EQ3, new BigDecimal("29"));
    WEIGHTS.put(BucketType.EQ4, new BigDecimal("26"));
    WEIGHTS.put(BucketType.EQ5, new BigDecimal("19"));
    WEIGHTS.put(BucketType.EQ6, new BigDecimal("21"));
    WEIGHTS.put(BucketType.EQ7, new BigDecimal("25"));
    WEIGHTS.put(BucketType.EQ8, new BigDecimal("24"));
    WEIGHTS.put(BucketType.EQ9, new BigDecimal("30"));
    WEIGHTS.put(BucketType.EQ10, new BigDecimal("29"));
    WEIGHTS.put(BucketType.EQ11, new BigDecimal("17"));
    WEIGHTS.put(BucketType.EQ12, new BigDecimal("17"));
    WEIGHTS.put(BucketType.EQRESIDUAL, new BigDecimal("30"));
  }

  private static final BigDecimal VEGA = new BigDecimal("0.26");
  private static final BigDecimal VEGA12 = new BigDecimal("0.62");

  @Override
  public BigDecimal getDeltaRiskWeight(WeightingClass s) {
    return WEIGHTS.get(s.getBucketIdentifier().getBucketType());
  }

  @Override
  public BigDecimal getVegaRiskWeight(WeightingClass s) {
    if (s.getBucket().equals("12")) {
      // bucket 12 has its own VRW as per doc/ISDA-SIMM-v1.3.38 paragraph 57
      return VEGA12;
    } else {
      return VEGA;
    }
  }

}
