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

package com.acadiasoft.simm.model.equity;

import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;
import com.acadiasoft.util.BigDecimalUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.acadiasoft.simm.util.RiskConcentrationUtil.MM;

/**
 * Created by alec.stewart on 8/8/17.
 */
public class EquityConcentrationRiskV2_0 implements EQRiskConcentration {

  private static final List<String> EMERGING_MARKETS_LARGE = Arrays.asList("1", "2", "3", "4");
  private static final List<String> DEVELOPED_MARKETS_LARGE = Arrays.asList("5", "6", "7", "8");
  private static final List<String> EMERGING_MARKETS_SMALL = Arrays.asList("9");
  private static final List<String> DEVELOPED_MARKETS_SMALL = Arrays.asList("10");
  private static final List<String> INDEXES_FUNDS_ETF_VOLINDEXES = Arrays.asList("11", "12");
  private static final List<String> NOT_CLASSIFIED = Arrays.asList("Residual");

  private static final Map<List<String>, BigDecimal> DELTA_THRESHOLD = new HashMap<>();
  private static final Map<List<String>, BigDecimal> VEGA_THRESHOLD = new HashMap<>();

  static {
    DELTA_THRESHOLD.put(EMERGING_MARKETS_LARGE, new BigDecimal("3.3").multiply(MM));
    DELTA_THRESHOLD.put(DEVELOPED_MARKETS_LARGE, new BigDecimal("30").multiply(MM));
    DELTA_THRESHOLD.put(EMERGING_MARKETS_SMALL, new BigDecimal("0.60").multiply(MM));
    DELTA_THRESHOLD.put(DEVELOPED_MARKETS_SMALL, new BigDecimal("2.3").multiply(MM));
    DELTA_THRESHOLD.put(INDEXES_FUNDS_ETF_VOLINDEXES, new BigDecimal("900").multiply(MM));
    DELTA_THRESHOLD.put(NOT_CLASSIFIED, new BigDecimal("0.60").multiply(MM));

    VEGA_THRESHOLD.put(EMERGING_MARKETS_LARGE, new BigDecimal("800").multiply(MM));
    VEGA_THRESHOLD.put(DEVELOPED_MARKETS_LARGE, new BigDecimal("7300").multiply(MM));
    VEGA_THRESHOLD.put(EMERGING_MARKETS_SMALL, new BigDecimal("70").multiply(MM));
    VEGA_THRESHOLD.put(DEVELOPED_MARKETS_SMALL, new BigDecimal("300").multiply(MM));
    VEGA_THRESHOLD.put(INDEXES_FUNDS_ETF_VOLINDEXES, new BigDecimal("21000").multiply(MM));
    VEGA_THRESHOLD.put(NOT_CLASSIFIED, new BigDecimal("70").multiply(MM));
  }

  @Override
  public BigDecimal getDeltaConcentration(Sensitivity s) {
    BigDecimal sum = s.getAmountUsd().abs();
    BigDecimal threshold = getDeltaThreshold(s.getBucket());
    BigDecimal risk = BigDecimalUtils.divideWithPrecision(sum, threshold);
    return BigDecimalUtils.sqrt(risk).max(BigDecimal.ONE);
  }

  @Override
  public BigDecimal getVegaConcentration(WeightedSensitivity ws) {
    BigDecimal sum = ws.getWeightedValue().abs();
    BigDecimal threshold = getVegaThreshold(ws.getSensitivity().getBucket());
    BigDecimal risk = BigDecimalUtils.divideWithPrecision(sum, threshold);
    return BigDecimalUtils.sqrt(risk).max(BigDecimal.ONE);
  }

  private BigDecimal getDeltaThreshold(String bucket) {
    return DELTA_THRESHOLD.get(determineDesignation(bucket));
  }

  private BigDecimal getVegaThreshold(String bucket) {
    return VEGA_THRESHOLD.get(determineDesignation(bucket));
  }

  private List<String> determineDesignation(String bucket) {
    if (EMERGING_MARKETS_LARGE.contains(bucket)) {
      return EMERGING_MARKETS_LARGE;
    } else if (EMERGING_MARKETS_SMALL.contains(bucket)) {
      return EMERGING_MARKETS_SMALL;
    } else if (DEVELOPED_MARKETS_LARGE.contains(bucket)) {
      return DEVELOPED_MARKETS_LARGE;
    } else if (DEVELOPED_MARKETS_SMALL.contains(bucket)) {
      return DEVELOPED_MARKETS_SMALL;
    } else if (INDEXES_FUNDS_ETF_VOLINDEXES.contains(bucket)) {
      return INDEXES_FUNDS_ETF_VOLINDEXES;
    } else if (StringUtils.equalsIgnoreCase(bucket, "Residual")) {
      return NOT_CLASSIFIED;
    } else {
      throw new RuntimeException("found org.acadiasoft.simm.model.params.equity bucket not in designations: " + bucket);
    }
  }

}
