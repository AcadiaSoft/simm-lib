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
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * As defined in Appendix 1 of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class EquityCorrelationV2_0 implements EQRiskCorrelation {

  public static final BigDecimal RESIDUAL = BigDecimal.ZERO;

  private static final BigDecimal[][] CORRELATIONS = {
    { // Bucket 1
      new BigDecimal("0.14"), // Bucket 1
      new BigDecimal("0.15"), // Bucket 2
      new BigDecimal("0.14"), // Bucket 3
      new BigDecimal("0.16"), // Bucket 4
      new BigDecimal("0.10"), // Bucket 5
      new BigDecimal("0.12"), // Bucket 6
      new BigDecimal("0.10"), // Bucket 7
      new BigDecimal("0.11"), // Bucket 8
      new BigDecimal("0.13"), // Bucket 9
      new BigDecimal("0.09"), // Bucket 10
      new BigDecimal("0.17"), // Bucket 11
      new BigDecimal("0.17")}, // Bucket 12
    { // Bucket 2
      new BigDecimal("0.15"), // Bucket 1
      new BigDecimal("0.20"), // Bucket 2
      new BigDecimal("0.16"), // Bucket 3
      new BigDecimal("0.17"), // Bucket 4
      new BigDecimal("0.10"), // Bucket 5
      new BigDecimal("0.11"), // Bucket 6
      new BigDecimal("0.10"), // Bucket 7
      new BigDecimal("0.11"), // Bucket 8
      new BigDecimal("0.14"), // Bucket 9
      new BigDecimal("0.09"), // Bucket 10
      new BigDecimal("0.17"), // Bucket 11
      new BigDecimal("0.17")}, // Bucket 12
    { // Bucket 3
      new BigDecimal("0.14"), // Bucket 1
      new BigDecimal("0.16"), // Bucket 2
      new BigDecimal("0.19"), // Bucket 3
      new BigDecimal("0.19"), // Bucket 4
      new BigDecimal("0.14"), // Bucket 5
      new BigDecimal("0.17"), // Bucket 6
      new BigDecimal("0.18"), // Bucket 7
      new BigDecimal("0.17"), // Bucket 8
      new BigDecimal("0.16"), // Bucket 9
      new BigDecimal("0.14"), // Bucket 10
      new BigDecimal("0.25"), // Bucket 11
      new BigDecimal("0.25")}, // Bucket 12
    { // Bucket 4
      new BigDecimal("0.16"), // Bucket 1
      new BigDecimal("0.17"), // Bucket 2
      new BigDecimal("0.19"), // Bucket 3
      new BigDecimal("0.21"), // Bucket 4
      new BigDecimal("0.15"), // Bucket 5
      new BigDecimal("0.18"), // Bucket 6
      new BigDecimal("0.18"), // Bucket 7
      new BigDecimal("0.18"), // Bucket 8
      new BigDecimal("0.18"), // Bucket 9
      new BigDecimal("0.14"), // Bucket 10
      new BigDecimal("0.28"), // Bucket 11
      new BigDecimal("0.28")}, // Bucket 12
    { // Bucket 5
      new BigDecimal("0.10"), // Bucket 1
      new BigDecimal("0.10"), // Bucket 2
      new BigDecimal("0.14"), // Bucket 3
      new BigDecimal("0.15"), // Bucket 4
      new BigDecimal("0.24"), // Bucket 5
      new BigDecimal("0.28"), // Bucket 6
      new BigDecimal("0.23"), // Bucket 7
      new BigDecimal("0.27"), // Bucket 8
      new BigDecimal("0.13"), // Bucket 9
      new BigDecimal("0.21"), // Bucket 10
      new BigDecimal("0.35"), // Bucket 11
      new BigDecimal("0.35")}, // Bucket 12
    { // Bucket 6
      new BigDecimal("0.12"), // Bucket 1
      new BigDecimal("0.11"), // Bucket 2
      new BigDecimal("0.17"), // Bucket 3
      new BigDecimal("0.18"), // Bucket 4
      new BigDecimal("0.28"), // Bucket 5
      new BigDecimal("0.35"), // Bucket 6
      new BigDecimal("0.30"), // Bucket 7
      new BigDecimal("0.34"), // Bucket 8
      new BigDecimal("0.16"), // Bucket 9
      new BigDecimal("0.26"), // Bucket 10
      new BigDecimal("0.45"), // Bucket 11
      new BigDecimal("0.45")}, // Bucket 12
    { // Bucket 7
      new BigDecimal("0.10"), // Bucket 1
      new BigDecimal("0.10"), // Bucket 2
      new BigDecimal("0.18"), // Bucket 3
      new BigDecimal("0.18"), // Bucket 4
      new BigDecimal("0.23"), // Bucket 5
      new BigDecimal("0.30"), // Bucket 6
      new BigDecimal("0.34"), // Bucket 7
      new BigDecimal("0.29"), // Bucket 8
      new BigDecimal("0.15"), // Bucket 9
      new BigDecimal("0.24"), // Bucket 10
      new BigDecimal("0.41"), // Bucket 11
      new BigDecimal("0.41")}, // Bucket 12
    { // Bucket 8
      new BigDecimal("0.11"), // Bucket 1
      new BigDecimal("0.11"), // Bucket 2
      new BigDecimal("0.17"), // Bucket 3
      new BigDecimal("0.18"), // Bucket 4
      new BigDecimal("0.27"), // Bucket 5
      new BigDecimal("0.34"), // Bucket 6
      new BigDecimal("0.29"), // Bucket 7
      new BigDecimal("0.34"), // Bucket 8
      new BigDecimal("0.16"), // Bucket 9
      new BigDecimal("0.26"), // Bucket 10
      new BigDecimal("0.44"), // Bucket 11
      new BigDecimal("0.44")}, // Bucket 12
    { // Bucket 9
      new BigDecimal("0.13"), // Bucket 1
      new BigDecimal("0.14"), // Bucket 2
      new BigDecimal("0.16"), // Bucket 3
      new BigDecimal("0.18"), // Bucket 4
      new BigDecimal("0.13"), // Bucket 5
      new BigDecimal("0.16"), // Bucket 6
      new BigDecimal("0.15"), // Bucket 7
      new BigDecimal("0.16"), // Bucket 8
      new BigDecimal("0.20"), // Bucket 9
      new BigDecimal("0.13"), // Bucket 10
      new BigDecimal("0.24"), // Bucket 11
      new BigDecimal("0.24")}, // Bucket 12
    { // Bucket 10
      new BigDecimal("0.09"), // Bucket 1
      new BigDecimal("0.09"), // Bucket 2
      new BigDecimal("0.14"), // Bucket 3
      new BigDecimal("0.14"), // Bucket 4
      new BigDecimal("0.21"), // Bucket 5
      new BigDecimal("0.26"), // Bucket 6
      new BigDecimal("0.24"), // Bucket 7
      new BigDecimal("0.26"), // Bucket 8
      new BigDecimal("0.13"), // Bucket 9
      new BigDecimal("0.24"), // Bucket 10
      new BigDecimal("0.33"), // Bucket 11
      new BigDecimal("0.33")}, // Bucket 12
    { // Bucket 11
      new BigDecimal("0.17"), // Bucket 1
      new BigDecimal("0.17"), // Bucket 2
      new BigDecimal("0.25"), // Bucket 3
      new BigDecimal("0.28"), // Bucket 4
      new BigDecimal("0.35"), // Bucket 5
      new BigDecimal("0.45"), // Bucket 6
      new BigDecimal("0.41"), // Bucket 7
      new BigDecimal("0.44"), // Bucket 8
      new BigDecimal("0.24"), // Bucket 9
      new BigDecimal("0.33"), // Bucket 10
      new BigDecimal("0.62"), // Bucket 11
      new BigDecimal("0.62")}, // Bucket 12
    { // Bucket 12
      new BigDecimal("0.17"), // Bucket 1
      new BigDecimal("0.17"), // Bucket 2
      new BigDecimal("0.25"), // Bucket 3
      new BigDecimal("0.28"), // Bucket 4
      new BigDecimal("0.35"), // Bucket 5
      new BigDecimal("0.45"), // Bucket 6
      new BigDecimal("0.41"), // Bucket 7
      new BigDecimal("0.44"), // Bucket 8
      new BigDecimal("0.24"), // Bucket 9
      new BigDecimal("0.33"), // Bucket 10
      new BigDecimal("0.62"), // Bucket 11
      new BigDecimal("0.62")} // Bucket12
  };

  @Override
  public BigDecimal getSensitivityCorrelation(Sensitivity si, Sensitivity sk) {
    if (StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, si.getBucket()) || StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, sk.getBucket())) {
      return RESIDUAL;
    } else {
      // NOTE: both sensitivities should be in the same bucket, so bi and bk should
      //    be equal
      int i = Integer.valueOf(si.getBucket());
      int k = Integer.valueOf(sk.getBucket());
      return CORRELATIONS[i - 1][k - 1];
    }
  }

  @Override
  public BigDecimal getBucketCorrelation(String bi, String bk) {
    if (StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, bi) || StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, bk)) {
      // NOTE: Residual bucket isn't correlated with any other bucket, and so we should never get here
      throw new RuntimeException("Called bucket correlation for Residual bucket: " + bi + ", " + bk);
    } else {
      int i = Integer.valueOf(bi);
      int k = Integer.valueOf(bk);
      return CORRELATIONS[i - 1][k - 1];
    }
  }
}
