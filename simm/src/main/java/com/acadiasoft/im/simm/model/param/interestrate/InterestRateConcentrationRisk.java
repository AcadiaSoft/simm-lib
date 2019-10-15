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

package com.acadiasoft.im.simm.model.param.interestrate;

import com.acadiasoft.im.simm.model.utils.ConcentrationRiskGroup;
import com.acadiasoft.im.simm.model.param.SimmConcentrationThreshold;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alec.stewart on 8/8/17.
 */
public class InterestRateConcentrationRisk implements SimmConcentrationThreshold {

  private static final Map<List<String>, BigDecimal> DELTA_THRESHOLD = new HashMap<>();
  private static final Map<List<String>, BigDecimal> VEGA_THRESHOLD = new HashMap<>();
  private static final List<String> HIGH_VOL = null; // high volatlity currencies are all currencies not in other catagories
  private static final List<String> REGULAR_VOL_WELL_TRADED = Arrays.asList("USD", "EUR", "GBP");
  private static final List<String> REGULAR_VOL_LESS_TRADED = Arrays.asList("AUD", "CAD", "CHF", "DKK", "HKD", "KRW", "NOK", "NZD", "SEK", "SGD", "TWD");
  private static final List<String> LOW_VOL = Arrays.asList("JPY");

  static {
    DELTA_THRESHOLD.put(HIGH_VOL, new BigDecimal("6.9").multiply(ConcentrationRiskGroup.MM));
    DELTA_THRESHOLD.put(REGULAR_VOL_LESS_TRADED, new BigDecimal("30").multiply(ConcentrationRiskGroup.MM));
    DELTA_THRESHOLD.put(REGULAR_VOL_WELL_TRADED, new BigDecimal("230").multiply(ConcentrationRiskGroup.MM));
    DELTA_THRESHOLD.put(LOW_VOL, new BigDecimal("150").multiply(ConcentrationRiskGroup.MM));

    VEGA_THRESHOLD.put(HIGH_VOL, new BigDecimal("170").multiply(ConcentrationRiskGroup.MM));
    VEGA_THRESHOLD.put(REGULAR_VOL_LESS_TRADED, new BigDecimal("190").multiply(ConcentrationRiskGroup.MM));
    VEGA_THRESHOLD.put(REGULAR_VOL_WELL_TRADED, new BigDecimal("2300").multiply(ConcentrationRiskGroup.MM));
    VEGA_THRESHOLD.put(LOW_VOL, new BigDecimal("770").multiply(ConcentrationRiskGroup.MM));
  }

  @Override
  public BigDecimal getDeltaThreshold(String currency) {
    InterestRateCurrencyVolatility vol = InterestRateCurrencyVolatility.get(currency);
    if (vol.equals(InterestRateCurrencyVolatility.HIGH_VOLATILITY)) {
      return DELTA_THRESHOLD.get(HIGH_VOL);
    } else if (vol.equals(InterestRateCurrencyVolatility.REGULAR) && determineWellTraded(currency)) {
      return DELTA_THRESHOLD.get(REGULAR_VOL_WELL_TRADED);
    } else if (vol.equals(InterestRateCurrencyVolatility.REGULAR) && !determineWellTraded(currency)) {
      return DELTA_THRESHOLD.get(REGULAR_VOL_LESS_TRADED);
    } else if (vol.equals(InterestRateCurrencyVolatility.LOW_VOLATILITY)) {
      return DELTA_THRESHOLD.get(LOW_VOL);
    } else {
      throw new RuntimeException("found currency not in volatility designations: " + currency);
    }
  }

  @Override
  public BigDecimal getVegaThreshold(String currency) {
    InterestRateCurrencyVolatility vol = InterestRateCurrencyVolatility.get(currency);
    if (vol.equals(InterestRateCurrencyVolatility.HIGH_VOLATILITY)) {
      return VEGA_THRESHOLD.get(HIGH_VOL);
    } else if (vol.equals(InterestRateCurrencyVolatility.REGULAR) && determineWellTraded(currency)) {
      return VEGA_THRESHOLD.get(REGULAR_VOL_WELL_TRADED);
    } else if (vol.equals(InterestRateCurrencyVolatility.REGULAR) && !determineWellTraded(currency)) {
      return VEGA_THRESHOLD.get(REGULAR_VOL_LESS_TRADED);
    } else if (vol.equals(InterestRateCurrencyVolatility.LOW_VOLATILITY)) {
      return VEGA_THRESHOLD.get(LOW_VOL);
    } else {
      throw new RuntimeException("found currency not in volatility designations: " + currency);
    }
  }

  private boolean determineWellTraded(String currency) {
    if (REGULAR_VOL_WELL_TRADED.contains(currency)) {
      return true;
    } else if (REGULAR_VOL_LESS_TRADED.contains(currency)) {
      return false;
    } else {
      throw new RuntimeException("tried to determine if well traded on non-regular volatility currency: " + currency);
    }
  }
}
