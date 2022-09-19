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

package com.acadiasoft.im.simm.model.param.equity;

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
public class EquityRiskWeight1d implements SimmRiskWeight {

  private static final Map<BucketType, BigDecimal> WEIGHTS = new HashMap<>();
  private static final Map<BucketType, BigDecimal> VEGA_WEIGHTS = new HashMap<>();

  static {
    WEIGHTS.put(BucketType.EQ1, new BigDecimal("9.3"));
    WEIGHTS.put(BucketType.EQ2, new BigDecimal("9.7"));
    WEIGHTS.put(BucketType.EQ3, new BigDecimal("10.0"));
    WEIGHTS.put(BucketType.EQ4, new BigDecimal("9.2"));
    WEIGHTS.put(BucketType.EQ5, new BigDecimal("7.7"));
    WEIGHTS.put(BucketType.EQ6, new BigDecimal("8.5"));
    WEIGHTS.put(BucketType.EQ7, new BigDecimal("9.5"));
    WEIGHTS.put(BucketType.EQ8, new BigDecimal("9.6"));
    WEIGHTS.put(BucketType.EQ9, new BigDecimal("10.0"));
    WEIGHTS.put(BucketType.EQ10, new BigDecimal("10"));
    WEIGHTS.put(BucketType.EQ11, new BigDecimal("5.9"));
    WEIGHTS.put(BucketType.EQ12, new BigDecimal("5.9"));
    WEIGHTS.put(BucketType.EQRESIDUAL, new BigDecimal("10.0"));

    VEGA_WEIGHTS.put(BucketType.EQ1, new BigDecimal("0.093"));
    VEGA_WEIGHTS.put(BucketType.EQ2, new BigDecimal("0.093"));
    VEGA_WEIGHTS.put(BucketType.EQ3, new BigDecimal("0.093"));
    VEGA_WEIGHTS.put(BucketType.EQ4, new BigDecimal("0.093"));
    VEGA_WEIGHTS.put(BucketType.EQ5, new BigDecimal("0.093"));
    VEGA_WEIGHTS.put(BucketType.EQ6, new BigDecimal("0.093"));
    VEGA_WEIGHTS.put(BucketType.EQ7, new BigDecimal("0.093"));
    VEGA_WEIGHTS.put(BucketType.EQ8, new BigDecimal("0.093"));
    VEGA_WEIGHTS.put(BucketType.EQ9, new BigDecimal("0.093"));
    VEGA_WEIGHTS.put(BucketType.EQ10, new BigDecimal("0.093"));
    VEGA_WEIGHTS.put(BucketType.EQ11, new BigDecimal("0.093"));
    VEGA_WEIGHTS.put(BucketType.EQ12, new BigDecimal("0.25"));
    VEGA_WEIGHTS.put(BucketType.EQRESIDUAL, new BigDecimal("0.093"));
  }

  @Override
  public BigDecimal getDeltaRiskWeight(SensitivityIdentifier s) {
    return WEIGHTS.get(s.getBucketIdentifier().getBucketType());
  }

  @Override
  public BigDecimal getVegaRiskWeight(SensitivityIdentifier s) {
    return VEGA_WEIGHTS.get(s.getBucketIdentifier().getBucketType());
  }

}
