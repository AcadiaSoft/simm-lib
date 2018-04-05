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

package com.acadiasoft.simm.model.param.interestrate;

import com.acadiasoft.simm.model.object.imtree.identifiers.RiskClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.WeightingClass;
import com.acadiasoft.simm.model.param.SimmRiskWeight;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * As defined in Appendix 1 section D of doc/ISDA-SIMM-2.0.pdf
 */
public class InterestRateRiskWeightV2_0 implements SimmRiskWeight {

  private static final BigDecimal VEGA = new BigDecimal("0.21");
  private static final BigDecimal INFLATION = new BigDecimal("46");
  private static final BigDecimal XCCY = new BigDecimal("20");

  private static final Map<InterestRateCurrencyVolatility, Map<InterestRateTenor, BigDecimal>> WEIGHTS = new HashMap<>();
  private static final Map<InterestRateTenor, BigDecimal> HIGH = new HashMap<>();
  private static final Map<InterestRateTenor, BigDecimal> LOW = new HashMap<>();
  private static final Map<InterestRateTenor, BigDecimal> REGULAR = new HashMap<>();

  static {
    REGULAR.put(InterestRateTenor._2W, new BigDecimal("113"));
    REGULAR.put(InterestRateTenor._1M, new BigDecimal("113"));
    REGULAR.put(InterestRateTenor._3M, new BigDecimal("98"));
    REGULAR.put(InterestRateTenor._6M, new BigDecimal("69"));
    REGULAR.put(InterestRateTenor._1YR, new BigDecimal("56"));
    REGULAR.put(InterestRateTenor._2YR, new BigDecimal("52"));
    REGULAR.put(InterestRateTenor._3YR, new BigDecimal("51"));
    REGULAR.put(InterestRateTenor._5YR, new BigDecimal("51"));
    REGULAR.put(InterestRateTenor._10YR, new BigDecimal("51"));
    REGULAR.put(InterestRateTenor._15YR, new BigDecimal("53"));
    REGULAR.put(InterestRateTenor._20YR, new BigDecimal("56"));
    REGULAR.put(InterestRateTenor._30YR, new BigDecimal("64"));
    WEIGHTS.put(InterestRateCurrencyVolatility.REGULAR, REGULAR);

    LOW.put(InterestRateTenor._2W, new BigDecimal("21"));
    LOW.put(InterestRateTenor._1M, new BigDecimal("21"));
    LOW.put(InterestRateTenor._3M, new BigDecimal("10"));
    LOW.put(InterestRateTenor._6M, new BigDecimal("11"));
    LOW.put(InterestRateTenor._1YR, new BigDecimal("15"));
    LOW.put(InterestRateTenor._2YR, new BigDecimal("20"));
    LOW.put(InterestRateTenor._3YR, new BigDecimal("22"));
    LOW.put(InterestRateTenor._5YR, new BigDecimal("21"));
    LOW.put(InterestRateTenor._10YR, new BigDecimal("19"));
    LOW.put(InterestRateTenor._15YR, new BigDecimal("20"));
    LOW.put(InterestRateTenor._20YR, new BigDecimal("23"));
    LOW.put(InterestRateTenor._30YR, new BigDecimal("27"));
    WEIGHTS.put(InterestRateCurrencyVolatility.LOW_VOLATILITY, LOW);

    HIGH.put(InterestRateTenor._2W, new BigDecimal("93"));
    HIGH.put(InterestRateTenor._1M, new BigDecimal("93"));
    HIGH.put(InterestRateTenor._3M, new BigDecimal("90"));
    HIGH.put(InterestRateTenor._6M, new BigDecimal("94"));
    HIGH.put(InterestRateTenor._1YR, new BigDecimal("97"));
    HIGH.put(InterestRateTenor._2YR, new BigDecimal("103"));
    HIGH.put(InterestRateTenor._3YR, new BigDecimal("101"));
    HIGH.put(InterestRateTenor._5YR, new BigDecimal("103"));
    HIGH.put(InterestRateTenor._10YR, new BigDecimal("102"));
    HIGH.put(InterestRateTenor._15YR, new BigDecimal("101"));
    HIGH.put(InterestRateTenor._20YR, new BigDecimal("102"));
    HIGH.put(InterestRateTenor._30YR, new BigDecimal("101"));
    WEIGHTS.put(InterestRateCurrencyVolatility.HIGH_VOLATILITY, HIGH);
  }

  @Override
  public BigDecimal getDeltaRiskWeight(WeightingClass s) {
    if (StringUtils.equalsIgnoreCase(s.getRiskType(), RiskClass.RISK_TYPE_INFLATION)) {
      return INFLATION;
    } else if (s.getRiskType().equals(RiskClass.RISK_TYPE_XCCY_BASIS)) {
      return XCCY;
    } else {
      InterestRateCurrencyVolatility vol = InterestRateCurrencyVolatility.get(s.getQualifier());
      InterestRateTenor tenor = InterestRateTenor.getByTenor(s.getLabel1());
      return WEIGHTS.get(vol).get(tenor);
    }
  }

  @Override
  public BigDecimal getVegaRiskWeight(WeightingClass s) {
    return VEGA;
  }

}
