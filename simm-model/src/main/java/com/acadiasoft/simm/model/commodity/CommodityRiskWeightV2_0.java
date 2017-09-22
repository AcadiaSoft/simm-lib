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

package com.acadiasoft.simm.model.commodity;

import com.acadiasoft.simm.model.sensitivity.Sensitivity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class CommodityRiskWeightV2_0 implements CMRiskWeight {

  private static final Map<CommodityBucket, BigDecimal> WEIGHTS = new HashMap<>();

  static {
    WEIGHTS.put(CommodityBucket._1, new BigDecimal("19"));
    WEIGHTS.put(CommodityBucket._2, new BigDecimal("20"));
    WEIGHTS.put(CommodityBucket._3, new BigDecimal("17"));
    WEIGHTS.put(CommodityBucket._4, new BigDecimal("18"));
    WEIGHTS.put(CommodityBucket._5, new BigDecimal("24"));
    WEIGHTS.put(CommodityBucket._6, new BigDecimal("20"));
    WEIGHTS.put(CommodityBucket._7, new BigDecimal("24"));
    WEIGHTS.put(CommodityBucket._8, new BigDecimal("41"));
    WEIGHTS.put(CommodityBucket._9, new BigDecimal("25"));
    WEIGHTS.put(CommodityBucket._10, new BigDecimal("91"));
    WEIGHTS.put(CommodityBucket._11, new BigDecimal("20"));
    WEIGHTS.put(CommodityBucket._12, new BigDecimal("19"));
    WEIGHTS.put(CommodityBucket._13, new BigDecimal("16"));
    WEIGHTS.put(CommodityBucket._14, new BigDecimal("15"));
    WEIGHTS.put(CommodityBucket._15, new BigDecimal("10"));
    WEIGHTS.put(CommodityBucket._16, new BigDecimal("91"));
    WEIGHTS.put(CommodityBucket._17, new BigDecimal("17"));
  }

  private static final BigDecimal VEGA = new BigDecimal("0.38");
  private static final BigDecimal HVR = new BigDecimal("0.80");

  @Override
  public BigDecimal getRiskWeight(Sensitivity s) {
    return WEIGHTS.get(CommodityBucket.getBucket(s.getBucket()));
  }

  @Override
  public BigDecimal getVegaRiskWeight(Sensitivity s) {
    return VEGA;
  }

  @Override
  public BigDecimal getHVR() {
    return HVR;
  }
}
