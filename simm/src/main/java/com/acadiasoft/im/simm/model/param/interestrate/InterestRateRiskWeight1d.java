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

package com.acadiasoft.im.simm.model.param.interestrate;

import com.acadiasoft.im.simm.model.SensitivityIdentifier;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author joe.peterson
 *
 */
public class InterestRateRiskWeight1d implements SimmRiskWeight {

  private static final BigDecimal INFLATION = new BigDecimal("15");
  private static final BigDecimal XCCY = new BigDecimal("5.9");
  private static final BigDecimal VEGA = new BigDecimal("0.047");

  private static final Map<InterestRateCurrencyVolatility, Map<InterestRateTenor, BigDecimal>> WEIGHTS = new HashMap<>();
  private static final Map<InterestRateTenor, BigDecimal> HIGH = new HashMap<>();
  private static final Map<InterestRateTenor, BigDecimal> LOW = new HashMap<>();
  private static final Map<InterestRateTenor, BigDecimal> REGULAR = new HashMap<>();

  static {
    REGULAR.put(InterestRateTenor._2W, new BigDecimal("19"));
    REGULAR.put(InterestRateTenor._1M, new BigDecimal("16"));
    REGULAR.put(InterestRateTenor._3M, new BigDecimal("12"));
    REGULAR.put(InterestRateTenor._6M, new BigDecimal("12"));
    REGULAR.put(InterestRateTenor._1Y, new BigDecimal("13"));
    REGULAR.put(InterestRateTenor._2Y, new BigDecimal("16"));
    REGULAR.put(InterestRateTenor._3Y, new BigDecimal("16"));
    REGULAR.put(InterestRateTenor._5Y, new BigDecimal("16"));
    REGULAR.put(InterestRateTenor._10Y, new BigDecimal("16"));
    REGULAR.put(InterestRateTenor._15Y, new BigDecimal("17"));
    REGULAR.put(InterestRateTenor._20Y, new BigDecimal("16"));
    REGULAR.put(InterestRateTenor._30Y, new BigDecimal("17"));
    WEIGHTS.put(InterestRateCurrencyVolatility.REGULAR, REGULAR);

    LOW.put(InterestRateTenor._2W, new BigDecimal("1.7"));
    LOW.put(InterestRateTenor._1M, new BigDecimal("3.4"));
    LOW.put(InterestRateTenor._3M, new BigDecimal("1.8"));
    LOW.put(InterestRateTenor._6M, new BigDecimal("2.0"));
    LOW.put(InterestRateTenor._1Y, new BigDecimal("3.3"));
    LOW.put(InterestRateTenor._2Y, new BigDecimal("4.8"));
    LOW.put(InterestRateTenor._3Y, new BigDecimal("5.8"));
    LOW.put(InterestRateTenor._5Y, new BigDecimal("6.8"));
    LOW.put(InterestRateTenor._10Y, new BigDecimal("6.5"));
    LOW.put(InterestRateTenor._15Y, new BigDecimal("7.0"));
    LOW.put(InterestRateTenor._20Y, new BigDecimal("7.5"));
    LOW.put(InterestRateTenor._30Y, new BigDecimal("8.3"));
    WEIGHTS.put(InterestRateCurrencyVolatility.LOW_VOLATILITY, LOW);

    HIGH.put(InterestRateTenor._2W, new BigDecimal("49"));
    HIGH.put(InterestRateTenor._1M, new BigDecimal("24"));
    HIGH.put(InterestRateTenor._3M, new BigDecimal("16"));
    HIGH.put(InterestRateTenor._6M, new BigDecimal("20"));
    HIGH.put(InterestRateTenor._1Y, new BigDecimal("23"));
    HIGH.put(InterestRateTenor._2Y, new BigDecimal("23"));
    HIGH.put(InterestRateTenor._3Y, new BigDecimal("33"));
    HIGH.put(InterestRateTenor._5Y, new BigDecimal("31"));
    HIGH.put(InterestRateTenor._10Y, new BigDecimal("34"));
    HIGH.put(InterestRateTenor._15Y, new BigDecimal("33"));
    HIGH.put(InterestRateTenor._20Y, new BigDecimal("33"));
    HIGH.put(InterestRateTenor._30Y, new BigDecimal("27"));
    WEIGHTS.put(InterestRateCurrencyVolatility.HIGH_VOLATILITY, HIGH);
  }

  @Override
  public BigDecimal getDeltaRiskWeight(SensitivityIdentifier s) {
    if (StringUtils.equalsIgnoreCase(s.getRiskType(), RiskClass.RISK_TYPE_INFLATION)) {
      return INFLATION;
    } else if (s.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_XCCY_BASIS)) {
      return XCCY;
    } else {
      InterestRateCurrencyVolatility vol = InterestRateCurrencyVolatility.get(s.getQualifier());
      InterestRateTenor tenor = InterestRateTenor.getByTenor(s.getLabel1());
      return WEIGHTS.get(vol).get(tenor);
    }
  }

  @Override
  public BigDecimal getVegaRiskWeight(SensitivityIdentifier s) {
    return VEGA;
  }

}
