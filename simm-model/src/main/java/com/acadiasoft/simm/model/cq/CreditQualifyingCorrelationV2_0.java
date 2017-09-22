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

package com.acadiasoft.simm.model.cq;

import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class CreditQualifyingCorrelationV2_0 implements CQRiskCorrelation {

  public static final BigDecimal AGGREGATE_SAME = new BigDecimal("0.97");
  public static final BigDecimal AGGREGATE_DIFF = new BigDecimal("0.45");
  public static final BigDecimal RESIDUAL = new BigDecimal("0.50");

  private static final BigDecimal[][] CORRELATIONS = {
    { // Bucket 1
      null, // Bucket 1
      new BigDecimal("0.42"), // Bucket 2
      new BigDecimal("0.39"), // Bucket 3
      new BigDecimal("0.39"), // Bucket 4
      new BigDecimal("0.40"), // Bucket 5
      new BigDecimal("0.38"), // Bucket 6
      new BigDecimal("0.39"), // Bucket 7
      new BigDecimal("0.34"), // Bucket 8
      new BigDecimal("0.37"), // Bucket 9
      new BigDecimal("0.39"), // Bucket 10
      new BigDecimal("0.37"), // Bucket 11
      new BigDecimal("0.31")}, // Bucket 12
    { // Bucket 2
      new BigDecimal("0.42"), // Bucket 1
      null, // Bucket 2
      new BigDecimal("0.44"), // Bucket 3
      new BigDecimal("0.45"), // Bucket 4
      new BigDecimal("0.47"), // Bucket 5
      new BigDecimal("0.45"), // Bucket 6
      new BigDecimal("0.33"), // Bucket 7
      new BigDecimal("0.40"), // Bucket 8
      new BigDecimal("0.41"), // Bucket 9
      new BigDecimal("0.44"), // Bucket 10
      new BigDecimal("0.43"), // Bucket 11
      new BigDecimal("0.37")}, // Bucket 12
    { // Bucket 3
      new BigDecimal("0.39"), // Bucket 1
      new BigDecimal("0.44"), // Bucket 2
      null, // Bucket 3
      new BigDecimal("0.43"), // Bucket 4
      new BigDecimal("0.45"), // Bucket 5
      new BigDecimal("0.43"), // Bucket 6
      new BigDecimal("0.32"), // Bucket 7
      new BigDecimal("0.35"), // Bucket 8
      new BigDecimal("0.41"), // Bucket 9
      new BigDecimal("0.42"), // Bucket 10
      new BigDecimal("0.40"), // Bucket 11
      new BigDecimal("0.36")}, // Bucket 12
    { // Bucket 4
      new BigDecimal("0.39"), // Bucket 1
      new BigDecimal("0.45"), // Bucket 2
      new BigDecimal("0.43"), // Bucket 3
      null, // Bucket 4
      new BigDecimal("0.47"), // Bucket 5
      new BigDecimal("0.44"), // Bucket 6
      new BigDecimal("0.30"), // Bucket 7
      new BigDecimal("0.34"), // Bucket 8
      new BigDecimal("0.39"), // Bucket 9
      new BigDecimal("0.43"), // Bucket 10
      new BigDecimal("0.39"), // Bucket 11
      new BigDecimal("0.36")}, // Bucket 12
    { // Bucket 5
      new BigDecimal("0.40"), // Bucket 1
      new BigDecimal("0.47"), // Bucket 2
      new BigDecimal("0.45"), // Bucket 3
      new BigDecimal("0.47"), // Bucket 4
      null, // Bucket 5
      new BigDecimal("0.47"), // Bucket 6
      new BigDecimal("0.31"), // Bucket 7
      new BigDecimal("0.35"), // Bucket 8
      new BigDecimal("0.40"), // Bucket 9
      new BigDecimal("0.44"), // Bucket 10
      new BigDecimal("0.42"), // Bucket 11
      new BigDecimal("0.37")}, // Bucket 12
    { // Bucket 6
      new BigDecimal("0.38"), // Bucket 1
      new BigDecimal("0.45"), // Bucket 2
      new BigDecimal("0.43"), // Bucket 3
      new BigDecimal("0.44"), // Bucket 4
      new BigDecimal("0.47"), // Bucket 5
      null, // Bucket 6
      new BigDecimal("0.30"), // Bucket 7
      new BigDecimal("0.34"), // Bucket 8
      new BigDecimal("0.38"), // Bucket 9
      new BigDecimal("0.40"), // Bucket 10
      new BigDecimal("0.39"), // Bucket 11
      new BigDecimal("0.38")}, // Bucket 12
    { // Bucket 7
      new BigDecimal("0.39"), // Bucket 1
      new BigDecimal("0.33"), // Bucket 2
      new BigDecimal("0.32"), // Bucket 3
      new BigDecimal("0.30"), // Bucket 4
      new BigDecimal("0.31"), // Bucket 5
      new BigDecimal("0.30"), // Bucket 6
      null, // Bucket 7
      new BigDecimal("0.28"), // Bucket 8
      new BigDecimal("0.31"), // Bucket 9
      new BigDecimal("0.31"), // Bucket 10
      new BigDecimal("0.30"), // Bucket 11
      new BigDecimal("0.26")}, // Bucket 12
    { // Bucket 8
      new BigDecimal("0.34"), // Bucket 1
      new BigDecimal("0.40"), // Bucket 2
      new BigDecimal("0.35"), // Bucket 3
      new BigDecimal("0.34"), // Bucket 4
      new BigDecimal("0.35"), // Bucket 5
      new BigDecimal("0.34"), // Bucket 6
      new BigDecimal("0.28"), // Bucket 7
      null, // Bucket 8
      new BigDecimal("0.34"), // Bucket 9
      new BigDecimal("0.35"), // Bucket 10
      new BigDecimal("0.33"), // Bucket 11
      new BigDecimal("0.30")}, // Bucket 12
    { // Bucket 9
      new BigDecimal("0.37"), // Bucket 1
      new BigDecimal("0.41"), // Bucket 2
      new BigDecimal("0.41"), // Bucket 3
      new BigDecimal("0.39"), // Bucket 4
      new BigDecimal("0.40"), // Bucket 5
      new BigDecimal("0.38"), // Bucket 6
      new BigDecimal("0.31"), // Bucket 7
      new BigDecimal("0.34"), // Bucket 8
      null, // Bucket 9
      new BigDecimal("0.40"), // Bucket 10
      new BigDecimal("0.37"), // Bucket 11
      new BigDecimal("0.32")}, // Bucket 12
    { // Bucket 10
      new BigDecimal("0.39"), // Bucket 1
      new BigDecimal("0.44"), // Bucket 2
      new BigDecimal("0.42"), // Bucket 3
      new BigDecimal("0.43"), // Bucket 4
      new BigDecimal("0.44"), // Bucket 5
      new BigDecimal("0.40"), // Bucket 6
      new BigDecimal("0.31"), // Bucket 7
      new BigDecimal("0.35"), // Bucket 8
      new BigDecimal("0.40"), // Bucket 9
      null, // Bucket 10
      new BigDecimal("0.40"), // Bucket 11
      new BigDecimal("0.35")}, // Bucket 12
    { // Bucket 11
      new BigDecimal("0.37"), // Bucket 1
      new BigDecimal("0.43"), // Bucket 2
      new BigDecimal("0.40"), // Bucket 3
      new BigDecimal("0.39"), // Bucket 4
      new BigDecimal("0.42"), // Bucket 5
      new BigDecimal("0.39"), // Bucket 6
      new BigDecimal("0.30"), // Bucket 7
      new BigDecimal("0.33"), // Bucket 8
      new BigDecimal("0.37"), // Bucket 9
      new BigDecimal("0.40"), // Bucket 10
      null, // Bucket 11
      new BigDecimal("0.34")}, // Bucket 12
    { // Bucket 12
      new BigDecimal("0.31"), // Bucket 1
      new BigDecimal("0.37"), // Bucket 2
      new BigDecimal("0.36"), // Bucket 3
      new BigDecimal("0.36"), // Bucket 4
      new BigDecimal("0.37"), // Bucket 5
      new BigDecimal("0.38"), // Bucket 6
      new BigDecimal("0.26"), // Bucket 7
      new BigDecimal("0.30"), // Bucket 8
      new BigDecimal("0.32"), // Bucket 9
      new BigDecimal("0.35"), // Bucket 10
      new BigDecimal("0.34"), // Bucket 11
      null}}; // Bucket 12

  @Override
  public BigDecimal getSensitivityCorrelation(Sensitivity si, Sensitivity sk) {
    if (StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, si.getBucket()) || StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, sk.getBucket())) {
      return RESIDUAL;
    } else if (StringUtils.equals(si.getQualifier(), sk.getQualifier())) {
      return AGGREGATE_SAME;
    } else {
      return AGGREGATE_DIFF;
    }
  }

  @Override
  public BigDecimal getBucketCorrelation(String bi, String bk) {
    if (StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, bi) || StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, bk)) {
      throw new RuntimeException("called bucket correlation for a residual bucket: " + bi + ", " + bk);
    } else {
      int i = Integer.valueOf(bi);
      int k = Integer.valueOf(bk);
      return CORRELATIONS[i - 1][k - 1];
    }
  }
}
