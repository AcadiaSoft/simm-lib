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

package com.acadiasoft.simm.model.cnq;

import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;
import com.acadiasoft.simm.util.RiskConcentrationUtil;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.acadiasoft.simm.util.RiskConcentrationUtil.MM;

/**
 * Created by alec.stewart on 8/9/17.
 */
public class CreditNonQualifyingConcentrationRiskV2_0 implements CNRiskConcentration {

  private static final String IG = "1";
  private static final String HY = "2";
  private static final String NOT_CLASSIFIED = "Residual";

  private static final Map<String, BigDecimal> DELTA_THRESHOLD = new HashMap<>();
//    private static final Map<String, BigDecimal> VEGA_THRESHOLD = new HashMap<>();

  static {
    DELTA_THRESHOLD.put(IG, new BigDecimal("9.5").multiply(MM));
    DELTA_THRESHOLD.put(HY, new BigDecimal("0.5").multiply(MM));
    DELTA_THRESHOLD.put(NOT_CLASSIFIED, new BigDecimal("0.5").multiply(MM));

    // NOTE: only one vega threshodl for all buckets
  }

  @Override
  public BigDecimal getDeltaConcentration(String qualifier, String bucket, List<Sensitivity> all) {
    // we need to some over all org.acadiasoft.simm.model.risk factors with the same issuer and seniority, this is denoted by the qualifier,
    // thus we filter on the qualifier
    Predicate<Sensitivity> filter = (s) -> s.getQualifier().equals(qualifier);
    Function<Sensitivity, BigDecimal> convert = (s) -> s.getAmountUsd();
    BigDecimal sum = RiskConcentrationUtil.calcSum(filter, convert, all);
    BigDecimal threshold = getDeltaThreshold(bucket);
    return RiskConcentrationUtil.divideSqrtMax(sum, threshold);
  }

  @Override
  public BigDecimal getVegaConcentration(String qualifier, List<WeightedSensitivity> all) {
    Predicate<WeightedSensitivity> filter = (ws) -> ws.getSensitivity().getQualifier().equals(qualifier);
    Function<WeightedSensitivity, BigDecimal> convert = (ws) -> ws.getWeightedValue();
    BigDecimal sum = RiskConcentrationUtil.calcSum(filter, convert, all);
    BigDecimal threshold = getVegaThreshold();
    return RiskConcentrationUtil.divideSqrtMax(sum, threshold);
  }

  private BigDecimal getDeltaThreshold(String bucket) {
    return DELTA_THRESHOLD.get(determineGroup(bucket));
  }

  private BigDecimal getVegaThreshold() {
    return new BigDecimal("65").multiply(MM);
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
