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

package com.acadiasoft.im.simm.model.param.commodity;

import com.acadiasoft.im.simm.model.SensitivityIdentifier;
import com.acadiasoft.im.simm.model.imtree.identifiers.BucketType;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class CommodityRiskWeight1d implements SimmRiskWeight {

  private static final Map<BucketType, BigDecimal> WEIGHTS = new HashMap<>();

  static {
    WEIGHTS.put(BucketType.CM1, new BigDecimal("5.6"));
    WEIGHTS.put(BucketType.CM2, new BigDecimal("8.2"));
    WEIGHTS.put(BucketType.CM3, new BigDecimal("5.8"));
    WEIGHTS.put(BucketType.CM4, new BigDecimal("6.4"));
    WEIGHTS.put(BucketType.CM5, new BigDecimal("10"));
    WEIGHTS.put(BucketType.CM6, new BigDecimal("9.1"));
    WEIGHTS.put(BucketType.CM7, new BigDecimal("8"));
    WEIGHTS.put(BucketType.CM8, new BigDecimal("12.3"));
    WEIGHTS.put(BucketType.CM9, new BigDecimal("6.9"));
    WEIGHTS.put(BucketType.CM10, new BigDecimal("12.4"));
    WEIGHTS.put(BucketType.CM11, new BigDecimal("6.4"));
    WEIGHTS.put(BucketType.CM12, new BigDecimal("5.7"));
    WEIGHTS.put(BucketType.CM13, new BigDecimal("5"));
    WEIGHTS.put(BucketType.CM14, new BigDecimal("4.8"));
    WEIGHTS.put(BucketType.CM15, new BigDecimal("3.9"));
    WEIGHTS.put(BucketType.CM16, new BigDecimal("12.4"));
    WEIGHTS.put(BucketType.CM17, new BigDecimal("4.7"));
  }

  private static final BigDecimal VEGA = new BigDecimal("0.09");

  @Override
  public BigDecimal getDeltaRiskWeight(SensitivityIdentifier s) {
    return WEIGHTS.get(s.getBucketIdentifier().getBucketType());
  }

  @Override
  public BigDecimal getVegaRiskWeight(SensitivityIdentifier s) {
    return VEGA;
  }
}
