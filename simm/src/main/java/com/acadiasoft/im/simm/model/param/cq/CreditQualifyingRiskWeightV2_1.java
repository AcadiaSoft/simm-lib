/*
 * Copyright (c) 2018 AcadiaSoft, Inc.
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

package com.acadiasoft.im.simm.model.param.cq;

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketType;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * As defined in Appendix 1 of doc/ISDA-SIMM-2.0.pdf
 */
public class CreditQualifyingRiskWeightV2_1 implements SimmRiskWeight {

  private static final Map<BucketType, BigDecimal> WEIGHTS = new HashMap<>();

  static {
    WEIGHTS.put(BucketType.CRQ1, new BigDecimal("69"));
    WEIGHTS.put(BucketType.CRQ2, new BigDecimal("107"));
    WEIGHTS.put(BucketType.CRQ3, new BigDecimal("72"));
    WEIGHTS.put(BucketType.CRQ4, new BigDecimal("55"));
    WEIGHTS.put(BucketType.CRQ5, new BigDecimal("48"));
    WEIGHTS.put(BucketType.CRQ6, new BigDecimal("41"));
    WEIGHTS.put(BucketType.CRQ7, new BigDecimal("166"));
    WEIGHTS.put(BucketType.CRQ8, new BigDecimal("187"));
    WEIGHTS.put(BucketType.CRQ9, new BigDecimal("177"));
    WEIGHTS.put(BucketType.CRQ10, new BigDecimal("187"));
    WEIGHTS.put(BucketType.CRQ11, new BigDecimal("129"));
    WEIGHTS.put(BucketType.CRQ12, new BigDecimal("136"));
    WEIGHTS.put(BucketType.CRQRESIDUAL, new BigDecimal("187"));
  }

  private static final BigDecimal VEGA = new BigDecimal("0.27");

  @Override
  public BigDecimal getDeltaRiskWeight(WeightingClass s) {
    return WEIGHTS.get(s.getBucketIdentifier().getBucketType());
  }

  @Override
  public BigDecimal getVegaRiskWeight(WeightingClass s) {
    return VEGA;
  }

}
