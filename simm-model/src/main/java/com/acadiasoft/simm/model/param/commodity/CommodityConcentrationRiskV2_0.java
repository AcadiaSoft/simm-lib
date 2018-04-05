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

package com.acadiasoft.simm.model.param.commodity;

import com.acadiasoft.simm.model.param.SimmConcentrationThreshold;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.acadiasoft.simm.model.object.ConcentrationRiskGroup.MM;;

/**
 * Created by alec.stewart on 8/8/17.
 */
public class CommodityConcentrationRiskV2_0 implements SimmConcentrationThreshold {

  private static final List<String> COAL = Arrays.asList("1");
  private static final List<String> CRUDE_OIL = Arrays.asList("2");
  private static final List<String> OIL_FRACTIONS = Arrays.asList("3", "4", "5");
  private static final List<String> NATURAL_GAS = Arrays.asList("6", "7");
  private static final List<String> POWER = Arrays.asList("8", "9");
  private static final List<String> FREIGHT = Arrays.asList("10");
  private static final List<String> BASE_METALS = Arrays.asList("11");
  private static final List<String> PRECIOUS_METALS = Arrays.asList("12");
  private static final List<String> AGRICULTURE = Arrays.asList("13", "14", "15");
  private static final List<String> OTHER = Arrays.asList("16");
  private static final List<String> INDEXES = Arrays.asList("17");

  private static final Map<List<String>, BigDecimal> DELTA_THRESHOLD = new HashMap<>();
  private static final Map<List<String>, BigDecimal> VEGA_THRESHOLD = new HashMap<>();

  static {
    DELTA_THRESHOLD.put(COAL, new BigDecimal("1400").multiply(MM));
    DELTA_THRESHOLD.put(CRUDE_OIL, new BigDecimal("20000").multiply(MM));
    DELTA_THRESHOLD.put(OIL_FRACTIONS, new BigDecimal("3500").multiply(MM));
    DELTA_THRESHOLD.put(NATURAL_GAS, new BigDecimal("6400").multiply(MM));
    DELTA_THRESHOLD.put(POWER, new BigDecimal("2500").multiply(MM));
    DELTA_THRESHOLD.put(FREIGHT, new BigDecimal("300").multiply(MM));
    DELTA_THRESHOLD.put(BASE_METALS, new BigDecimal("2900").multiply(MM));
    DELTA_THRESHOLD.put(PRECIOUS_METALS, new BigDecimal("7600").multiply(MM));
    DELTA_THRESHOLD.put(AGRICULTURE, new BigDecimal("3900").multiply(MM));
    DELTA_THRESHOLD.put(OTHER, new BigDecimal("300").multiply(MM));
    DELTA_THRESHOLD.put(INDEXES, new BigDecimal("12000").multiply(MM));

    VEGA_THRESHOLD.put(COAL, new BigDecimal("250").multiply(MM));
    VEGA_THRESHOLD.put(CRUDE_OIL, new BigDecimal("2000").multiply(MM));
    VEGA_THRESHOLD.put(OIL_FRACTIONS, new BigDecimal("510").multiply(MM));
    VEGA_THRESHOLD.put(NATURAL_GAS, new BigDecimal("1900").multiply(MM));
    VEGA_THRESHOLD.put(POWER, new BigDecimal("870").multiply(MM));
    VEGA_THRESHOLD.put(FREIGHT, new BigDecimal("220").multiply(MM));
    VEGA_THRESHOLD.put(BASE_METALS, new BigDecimal("450").multiply(MM));
    VEGA_THRESHOLD.put(PRECIOUS_METALS, new BigDecimal("740").multiply(MM));
    VEGA_THRESHOLD.put(AGRICULTURE, new BigDecimal("370").multiply(MM));
    VEGA_THRESHOLD.put(OTHER, new BigDecimal("220").multiply(MM));
    VEGA_THRESHOLD.put(INDEXES, new BigDecimal("430").multiply(MM));
  }

  @Override
  public BigDecimal getDeltaThreshold(String bucket) {
    return DELTA_THRESHOLD.get(determineGroup(bucket));
  }

  @Override
  public BigDecimal getVegaThreshold(String bucket) {
    return VEGA_THRESHOLD.get(determineGroup(bucket));
  }

  private List<String> determineGroup(String bucket) {
    if (bucket.equals("1")) {
      return COAL;
    } else if (bucket.equals("2")) {
      return CRUDE_OIL;
    } else if (OIL_FRACTIONS.contains(bucket)) {
      return OIL_FRACTIONS;
    } else if (NATURAL_GAS.contains(bucket)) {
      return NATURAL_GAS;
    } else if (POWER.contains(bucket)) {
      return POWER;
    } else if (bucket.equals("10")) {
      return FREIGHT;
    } else if (bucket.equals("11")) {
      return BASE_METALS;
    } else if (bucket.equals("12")) {
      return PRECIOUS_METALS;
    } else if (AGRICULTURE.contains(bucket)) {
      return AGRICULTURE;
    } else if (bucket.equals("16")) {
      return OTHER;
    } else if (bucket.equals("17")) {
      return INDEXES;
    } else {
      throw new RuntimeException("found bucket not in groups: " + bucket);
    }
  }

}
