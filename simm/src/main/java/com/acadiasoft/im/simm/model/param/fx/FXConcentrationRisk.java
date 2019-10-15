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

package com.acadiasoft.im.simm.model.param.fx;

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
public class FXConcentrationRisk implements SimmConcentrationThreshold {

  private static final List<String> CATEGORY_1 = Arrays.asList("USD", "EUR", "JPY", "GBP", "AUD", "CHF", "CAD");
  private static final List<String> CATEGORY_2 = Arrays.asList("BRL", "CNY", "HKD", "INR", "KRW", "MXN", "NOK", "NZD", "RUB", "SEK", "SGD", "TRY", "ZAR");
  private static final List<String> CATEGORY_3 = null; // all other currencies

  private static final Map<List<String>, BigDecimal> DELTA_THRESHOLD = new HashMap<>();
  private static final Map<List<String>, Map<List<String>, BigDecimal>> VEGA_THRESHOLD = new HashMap<>();
  private static final Map<List<String>, BigDecimal> CAT_1 = new HashMap<>();
  private static final Map<List<String>, BigDecimal> CAT_2 = new HashMap<>();
  private static final Map<List<String>, BigDecimal> CAT_3 = new HashMap<>();

  static {
    DELTA_THRESHOLD.put(CATEGORY_1, new BigDecimal("9100").multiply(ConcentrationRiskGroup.MM));
    DELTA_THRESHOLD.put(CATEGORY_2, new BigDecimal("1600").multiply(ConcentrationRiskGroup.MM));
    DELTA_THRESHOLD.put(CATEGORY_3, new BigDecimal("290").multiply(ConcentrationRiskGroup.MM));

    CAT_1.put(CATEGORY_1, new BigDecimal("3700").multiply(ConcentrationRiskGroup.MM));
    CAT_1.put(CATEGORY_2, new BigDecimal("1900").multiply(ConcentrationRiskGroup.MM));
    CAT_1.put(CATEGORY_3, new BigDecimal("640").multiply(ConcentrationRiskGroup.MM));
    VEGA_THRESHOLD.put(CATEGORY_1, CAT_1);

    CAT_2.put(CATEGORY_1, new BigDecimal("1900").multiply(ConcentrationRiskGroup.MM));
    CAT_2.put(CATEGORY_2, new BigDecimal("570").multiply(ConcentrationRiskGroup.MM));
    CAT_2.put(CATEGORY_3, new BigDecimal("390").multiply(ConcentrationRiskGroup.MM));
    VEGA_THRESHOLD.put(CATEGORY_2, CAT_2);

    CAT_3.put(CATEGORY_1, new BigDecimal("640").multiply(ConcentrationRiskGroup.MM));
    CAT_3.put(CATEGORY_2, new BigDecimal("390").multiply(ConcentrationRiskGroup.MM));
    CAT_3.put(CATEGORY_3, new BigDecimal("220").multiply(ConcentrationRiskGroup.MM));
    VEGA_THRESHOLD.put(CATEGORY_3, CAT_3);
  }

  @Override
  public BigDecimal getDeltaThreshold(String currency) {
    return DELTA_THRESHOLD.get(determineCategory(currency));
  }

  @Override
  public BigDecimal getVegaThreshold(String currencies) {
    String first = currencies.substring(0, 3);
    String second = currencies.substring(3, 6);
    return VEGA_THRESHOLD.get(determineCategory(first)).get(determineCategory(second));
  }

  private List<String> determineCategory(String currency) {
    if (CATEGORY_1.contains(currency)) {
      return CATEGORY_1;
    } else if (CATEGORY_2.contains(currency)) {
      return CATEGORY_2;
    } else {
      return CATEGORY_3;
    }
  }
}
