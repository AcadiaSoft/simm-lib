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

package com.acadiasoft.im.simm.model.param.cq;

import com.acadiasoft.im.simm.model.utils.ConcentrationRiskGroup;
import com.acadiasoft.im.simm.model.param.SimmConcentrationThreshold;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alec.stewart on 8/9/17.
 */
public class CreditQualifyingConcentrationRisk implements SimmConcentrationThreshold {

  private static final List<String> SOVERIGN = Arrays.asList("1", "7");
  private static final List<String> CORPORATE = Arrays.asList("2", "3", "4", "5", "6", "8", "9", "10", "11", "12");
  private static final List<String> NOT_CLASSIFIED = Arrays.asList("Residual");

  private static final Map<List<String>, BigDecimal> DELTA_THRESHOLD = new HashMap<>();
//    private static final Map<List<String>, BigDecimal> VEGA_THRESHOLD = new HashMap<>();

  static {
    DELTA_THRESHOLD.put(SOVERIGN, new BigDecimal("0.94").multiply(ConcentrationRiskGroup.MM));
    DELTA_THRESHOLD.put(CORPORATE, new BigDecimal("0.18").multiply(ConcentrationRiskGroup.MM));
    DELTA_THRESHOLD.put(NOT_CLASSIFIED, new BigDecimal("0.18").multiply(ConcentrationRiskGroup.MM));

    // NOTE: there is only one concentration threshold for all Credit Qualifying Vol
  }

  @Override
  public BigDecimal getDeltaThreshold(String bucket) {
    return DELTA_THRESHOLD.get(determineGroup(bucket));
  }

  @Override
  public BigDecimal getVegaThreshold(String bucket) {
    return new BigDecimal("280").multiply(ConcentrationRiskGroup.MM);
  }

  private List<String> determineGroup(String bucket) {
    if (SOVERIGN.contains(bucket)) {
      return SOVERIGN;
    } else if (CORPORATE.contains(bucket)) {
      return CORPORATE;
    } else if (StringUtils.equalsIgnoreCase(bucket, "Residual")) {
      return NOT_CLASSIFIED;
    } else {
      throw new RuntimeException("found bucket not in groups: " + bucket);
    }
  }
}
