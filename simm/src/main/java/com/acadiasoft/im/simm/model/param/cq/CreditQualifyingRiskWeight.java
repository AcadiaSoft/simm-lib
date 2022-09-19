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

package com.acadiasoft.im.simm.model.param.cq;

import com.acadiasoft.im.simm.model.SensitivityIdentifier;
import com.acadiasoft.im.simm.model.imtree.identifiers.BucketType;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author joe.peterson
 *
 */
public class CreditQualifyingRiskWeight implements SimmRiskWeight {

  private static final Map<BucketType, BigDecimal> WEIGHTS = new HashMap<>();

  static {
    WEIGHTS.put(BucketType.CRQ1, new BigDecimal("75"));
    WEIGHTS.put(BucketType.CRQ2, new BigDecimal("91"));
    WEIGHTS.put(BucketType.CRQ3, new BigDecimal("78"));
    WEIGHTS.put(BucketType.CRQ4, new BigDecimal("55"));
    WEIGHTS.put(BucketType.CRQ5, new BigDecimal("67"));
    WEIGHTS.put(BucketType.CRQ6, new BigDecimal("47"));
    WEIGHTS.put(BucketType.CRQ7, new BigDecimal("187"));
    WEIGHTS.put(BucketType.CRQ8, new BigDecimal("665"));
    WEIGHTS.put(BucketType.CRQ9, new BigDecimal("262"));
    WEIGHTS.put(BucketType.CRQ10, new BigDecimal("251"));
    WEIGHTS.put(BucketType.CRQ11, new BigDecimal("172"));
    WEIGHTS.put(BucketType.CRQ12, new BigDecimal("247"));
    WEIGHTS.put(BucketType.CRQRESIDUAL, new BigDecimal("665"));
  }

  private static final BigDecimal VEGA = new BigDecimal("0.74");

  @Override
  public BigDecimal getDeltaRiskWeight(SensitivityIdentifier s) {
    return WEIGHTS.get(s.getBucketIdentifier().getBucketType());
  }

  @Override
  public BigDecimal getVegaRiskWeight(SensitivityIdentifier s) {
    return VEGA;
  }

}
