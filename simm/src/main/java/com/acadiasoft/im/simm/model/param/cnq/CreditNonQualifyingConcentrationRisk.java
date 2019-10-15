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

package com.acadiasoft.im.simm.model.param.cnq;

import com.acadiasoft.im.simm.model.utils.ConcentrationRiskGroup;
import com.acadiasoft.im.simm.model.param.SimmConcentrationThreshold;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alec.stewart on 8/9/17.
 */
public class CreditNonQualifyingConcentrationRisk implements SimmConcentrationThreshold {

  private static final String IG = "1";
  private static final String HY = "2";
  private static final String NOT_CLASSIFIED = "Residual";

  private static final Map<String, BigDecimal> DELTA_THRESHOLD = new HashMap<>();
//    private static final Map<String, BigDecimal> VEGA_THRESHOLD = new HashMap<>();

  static {
    DELTA_THRESHOLD.put(IG, new BigDecimal("9.5").multiply(ConcentrationRiskGroup.MM));
    DELTA_THRESHOLD.put(HY, new BigDecimal("0.5").multiply(ConcentrationRiskGroup.MM));
    DELTA_THRESHOLD.put(NOT_CLASSIFIED, new BigDecimal("0.5").multiply(ConcentrationRiskGroup.MM));

    // NOTE: only one vega threshodl for all buckets
  }

  @Override
  public BigDecimal getDeltaThreshold(String bucket) {
    return DELTA_THRESHOLD.get(determineGroup(bucket));
  }

  @Override
  public BigDecimal getVegaThreshold(String bucket) {
    return new BigDecimal("59").multiply(ConcentrationRiskGroup.MM);
  }

  private String determineGroup(String bucket) {
    if (bucket.equals(IG)) {
      return IG;
    } else if (bucket.equals(HY)) {
      return HY;
    } else if (StringUtils.equalsIgnoreCase(bucket, "Residual")) {
      return NOT_CLASSIFIED;
    } else {
      throw new RuntimeException("found bucket not in groups: " + bucket);
    }
  }
}
