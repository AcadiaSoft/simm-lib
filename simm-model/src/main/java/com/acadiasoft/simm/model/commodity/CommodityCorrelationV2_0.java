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

package com.acadiasoft.simm.model.commodity;

import com.acadiasoft.simm.model.sensitivity.Sensitivity;

import java.math.BigDecimal;

/**
 * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class CommodityCorrelationV2_0 implements CMRiskCorrelation {

  private static final BigDecimal[][] CORRELATIONS = { // Correlations between two buckets
    { // Bucket 1
      new BigDecimal("0.30"), // Bucket 1
      new BigDecimal("0.18"), // Bucket 2
      new BigDecimal("0.15"), // Bucket 3
      new BigDecimal("0.20"), // Bucket 4
      new BigDecimal("0.25"), // Bucket 5
      new BigDecimal("0.08"), // Bucket 6
      new BigDecimal("0.19"), // Bucket 7
      new BigDecimal("0.01"), // Bucket 8
      new BigDecimal("0.27"), // Bucket 9
      new BigDecimal("0.00"), // Bucket 10
      new BigDecimal("0.15"), // Bucket 11
      new BigDecimal("0.02"), // Bucket 12
      new BigDecimal("0.06"), // Bucket 13
      new BigDecimal("0.07"), // Bucket 14
      new BigDecimal("-0.04"), // Bucket 15
      new BigDecimal("0.00"), // Bucket 16
      new BigDecimal("0.06")}, // Bucket 17
    { // Bucket 2
      new BigDecimal("0.18"), // Bucket 1
      new BigDecimal("0.97"), // Bucket 2
      new BigDecimal("0.89"), // Bucket 3
      new BigDecimal("0.94"), // Bucket 4
      new BigDecimal("0.93"), // Bucket 5
      new BigDecimal("0.32"), // Bucket 6
      new BigDecimal("0.22"), // Bucket 7
      new BigDecimal("0.27"), // Bucket 8
      new BigDecimal("0.24"), // Bucket 9
      new BigDecimal("0.09"), // Bucket 10
      new BigDecimal("0.45"), // Bucket 11
      new BigDecimal("0.21"), // Bucket 12
      new BigDecimal("0.32"), // Bucket 13
      new BigDecimal("0.28"), // Bucket 14
      new BigDecimal("0.17"), // Bucket 15
      new BigDecimal("0.00"), // Bucket 16
      new BigDecimal("0.37")}, // Bucket 17
    { // Bucket 3
      new BigDecimal("0.15"), // Bucket 1
      new BigDecimal("0.89"), // Bucket 2
      new BigDecimal("0.93"), // Bucket 3
      new BigDecimal("0.87"), // Bucket 4
      new BigDecimal("0.88"), // Bucket 5
      new BigDecimal("0.25"), // Bucket 6
      new BigDecimal("0.16"), // Bucket 7
      new BigDecimal("0.19"), // Bucket 8
      new BigDecimal("0.12"), // Bucket 9
      new BigDecimal("0.10"), // Bucket 10
      new BigDecimal("0.26"), // Bucket 11
      new BigDecimal("-0.01"), // Bucket 12
      new BigDecimal("0.19"), // Bucket 13
      new BigDecimal("0.17"), // Bucket 14
      new BigDecimal("0.10"), // Bucket 15
      new BigDecimal("0.00"), // Bucket 16
      new BigDecimal("0.27")}, // Bucket 17
    { // Bucket 4
      new BigDecimal("0.20"), // Bucket 1
      new BigDecimal("0.94"), // Bucket 2
      new BigDecimal("0.87"), // Bucket 3
      new BigDecimal("0.98"), // Bucket 4
      new BigDecimal("0.92"), // Bucket 5
      new BigDecimal("0.29"), // Bucket 6
      new BigDecimal("0.22"), // Bucket 7
      new BigDecimal("0.26"), // Bucket 8
      new BigDecimal("0.19"), // Bucket 9
      new BigDecimal("0.00"), // Bucket 10
      new BigDecimal("0.32"), // Bucket 11
      new BigDecimal("0.05"), // Bucket 12
      new BigDecimal("0.20"), // Bucket 13
      new BigDecimal("0.22"), // Bucket 14
      new BigDecimal("0.13"), // Bucket 15
      new BigDecimal("0.00"), // Bucket 16
      new BigDecimal("0.28")}, // Bucket 17
    { // Bucket 5
      new BigDecimal("0.25"), // Bucket 1
      new BigDecimal("0.93"), // Bucket 2
      new BigDecimal("0.88"), // Bucket 3
      new BigDecimal("0.92"), // Bucket 4
      new BigDecimal("0.99"), // Bucket 5
      new BigDecimal("0.30"), // Bucket 6
      new BigDecimal("0.26"), // Bucket 7
      new BigDecimal("0.22"), // Bucket 8
      new BigDecimal("0.28"), // Bucket 9
      new BigDecimal("0.12"), // Bucket 10
      new BigDecimal("0.42"), // Bucket 11
      new BigDecimal("0.23"), // Bucket 12
      new BigDecimal("0.28"), // Bucket 13
      new BigDecimal("0.29"), // Bucket 14
      new BigDecimal("0.17"), // Bucket 15
      new BigDecimal("0.00"), // Bucket 16
      new BigDecimal("0.34")}, // Bucket 17
    { // Bucket 6
      new BigDecimal("0.08"), // Bucket 1
      new BigDecimal("0.32"), // Bucket 2
      new BigDecimal("0.25"), // Bucket 3
      new BigDecimal("0.29"), // Bucket 4
      new BigDecimal("0.30"), // Bucket 5
      new BigDecimal("0.92"), // Bucket 6
      new BigDecimal("0.13"), // Bucket 7
      new BigDecimal("0.57"), // Bucket 8
      new BigDecimal("0.05"), // Bucket 9
      new BigDecimal("0.14"), // Bucket 10
      new BigDecimal("0.15"), // Bucket 11
      new BigDecimal("-0.02"), // Bucket 12
      new BigDecimal("0.13"), // Bucket 13
      new BigDecimal("0.17"), // Bucket 14
      new BigDecimal("0.01"), // Bucket 15
      new BigDecimal("0.00"), // Bucket 16
      new BigDecimal("0.26")}, // Bucket 17
    { // Bucket 7
      new BigDecimal("0.19"), // Bucket 1
      new BigDecimal("0.22"), // Bucket 2
      new BigDecimal("0.16"), // Bucket 3
      new BigDecimal("0.22"), // Bucket 4
      new BigDecimal("0.26"), // Bucket 5
      new BigDecimal("0.13"), // Bucket 6
      new BigDecimal("1"), // Bucket 7
      new BigDecimal("0.07"), // Bucket 8
      new BigDecimal("0.80"), // Bucket 9
      new BigDecimal("0.19"), // Bucket 10
      new BigDecimal("0.16"), // Bucket 11
      new BigDecimal("0.05"), // Bucket 12
      new BigDecimal("0.17"), // Bucket 13
      new BigDecimal("0.18"), // Bucket 14
      new BigDecimal("0.00"), // Bucket 15
      new BigDecimal("0.00"), // Bucket 16
      new BigDecimal("0.18")}, // Bucket 17
    { // Bucket 8
      new BigDecimal("0.01"),  //Bucket 1
      new BigDecimal("0.27"),  //Bucket 2
      new BigDecimal("0.19"),  //Bucket 3
      new BigDecimal("0.26"),  //Bucket 4
      new BigDecimal("0.22"),  //Bucket 5
      new BigDecimal("0.57"),  //Bucket 6
      new BigDecimal("0.07"),  //Bucket 7
      new BigDecimal("0.58"),  //Bucket 8
      new BigDecimal("0.13"),  //Bucket 9
      new BigDecimal("0.06"),  //Bucket 10
      new BigDecimal("0.16"),  //Bucket 11
      new BigDecimal("0.03"),  //Bucket 12
      new BigDecimal("0.10"),  //Bucket 13
      new BigDecimal("0.12"),  //Bucket 14
      new BigDecimal("0.06"),  //Bucket 15
      new BigDecimal("0.00"),  //Bucket 16
      new BigDecimal("0.23")},  //Bucket 17
    { // Bucket 9
      new BigDecimal("0.27"),  //Bucket 1
      new BigDecimal("0.24"),  //Bucket 2
      new BigDecimal("0.12"),  //Bucket 3
      new BigDecimal("0.19"),  //Bucket 4
      new BigDecimal("0.28"),  //Bucket 5
      new BigDecimal("0.05"),  //Bucket 6
      new BigDecimal("0.80"),  //Bucket 7
      new BigDecimal("0.13"),  //Bucket 8
      new BigDecimal("1"),  //Bucket 9
      new BigDecimal("0.15"),  //Bucket 10
      new BigDecimal("0.17"),  //Bucket 11
      new BigDecimal("0.05"),  //Bucket 12
      new BigDecimal("0.15"),  //Bucket 13
      new BigDecimal("0.13"),  //Bucket 14
      new BigDecimal("-0.03"),  //Bucket 15
      new BigDecimal("0.00"),  //Bucket 16
      new BigDecimal("0.13")},  //Bucket 17
    { // Bucket 10
      new BigDecimal("0.00"),  //Bucket 1
      new BigDecimal("0.09"),  //Bucket 2
      new BigDecimal("0.10"),  //Bucket 3
      new BigDecimal("0.00"),  //Bucket 4
      new BigDecimal("0.12"),  //Bucket 5
      new BigDecimal("0.14"),  //Bucket 6
      new BigDecimal("0.19"),  //Bucket 7
      new BigDecimal("0.06"),  //Bucket 8
      new BigDecimal("0.15"),  //Bucket 9
      new BigDecimal("0.10"),  //Bucket 10
      new BigDecimal("0.07"),  //Bucket 11
      new BigDecimal("0.07"),  //Bucket 12
      new BigDecimal("0.17"),  //Bucket 13
      new BigDecimal("0.10"),  //Bucket 14
      new BigDecimal("0.02"),  //Bucket 15
      new BigDecimal("0.00"),  //Bucket 16
      new BigDecimal("0.11")},  //Bucket 17
    { // Bucket 11
      new BigDecimal("0.15"),  //Bucket 1
      new BigDecimal("0.45"),  //Bucket 2
      new BigDecimal("0.26"),  //Bucket 3
      new BigDecimal("0.32"),  //Bucket 4
      new BigDecimal("0.42"),  //Bucket 5
      new BigDecimal("0.15"),  //Bucket 6
      new BigDecimal("0.16"),  //Bucket 7
      new BigDecimal("0.16"),  //Bucket 8
      new BigDecimal("0.17"),  //Bucket 9
      new BigDecimal("0.07"),  //Bucket 10
      new BigDecimal("0.55"),  //Bucket 11
      new BigDecimal("0.34"),  //Bucket 12
      new BigDecimal("0.20"),  //Bucket 13
      new BigDecimal("0.21"),  //Bucket 14
      new BigDecimal("0.16"),  //Bucket 15
      new BigDecimal("0.00"),  //Bucket 16
      new BigDecimal("0.27")},  //Bucket 17
    { // Bucket 12
      new BigDecimal("0.02"),  //Bucket 1
      new BigDecimal("0.21"),  //Bucket 2
      new BigDecimal("-0.01"),  //Bucket 3
      new BigDecimal("0.05"),  //Bucket 4
      new BigDecimal("0.23"),  //Bucket 5
      new BigDecimal("-0.02"),  //Bucket 6
      new BigDecimal("0.05"),  //Bucket 7
      new BigDecimal("0.03"),  //Bucket 8
      new BigDecimal("0.05"),  //Bucket 9
      new BigDecimal("0.07"),  //Bucket 10
      new BigDecimal("0.34"),  //Bucket 11
      new BigDecimal("0.64"),  //Bucket 12
      new BigDecimal("0.17"),  //Bucket 13
      new BigDecimal("0.26"),  //Bucket 14
      new BigDecimal("0.11"),  //Bucket 15
      new BigDecimal("0.00"),  //Bucket 16
      new BigDecimal("0.14")}, //Bucket 17
    { // Bucket 13
      new BigDecimal("0.06"),  //Bucket 1
      new BigDecimal("0.32"),  //Bucket 2
      new BigDecimal("0.19"),  //Bucket 3
      new BigDecimal("0.20"),  //Bucket 4
      new BigDecimal("0.28"),  //Bucket 5
      new BigDecimal("0.13"),  //Bucket 6
      new BigDecimal("0.17"),  //Bucket 7
      new BigDecimal("0.10"),  //Bucket 8
      new BigDecimal("0.15"),  //Bucket 9
      new BigDecimal("0.17"),  //Bucket 10
      new BigDecimal("0.20"),  //Bucket 11
      new BigDecimal("0.17"),  //Bucket 12
      new BigDecimal("0.71"),  //Bucket 13
      new BigDecimal("0.35"),  //Bucket 14
      new BigDecimal("0.09"),  //Bucket 15
      new BigDecimal("0.00"),  //Bucket 16
      new BigDecimal("0.22")}, //Bucket 17
    { // Bucket 14
      new BigDecimal("0.07"),  //Bucket 1
      new BigDecimal("0.28"),  //Bucket 2
      new BigDecimal("0.17"),  //Bucket 3
      new BigDecimal("0.22"),  //Bucket 4
      new BigDecimal("0.29"),  //Bucket 5
      new BigDecimal("0.17"),  //Bucket 6
      new BigDecimal("0.18"),  //Bucket 7
      new BigDecimal("0.12"),  //Bucket 8
      new BigDecimal("0.13"),  //Bucket 9
      new BigDecimal("0.10"),  //Bucket 10
      new BigDecimal("0.21"),  //Bucket 11
      new BigDecimal("0.26"),  //Bucket 12
      new BigDecimal("0.35"),  //Bucket 13
      new BigDecimal("0.22"),  //Bucket 14
      new BigDecimal("0.06"),  //Bucket 15
      new BigDecimal("0.00"),  //Bucket 16
      new BigDecimal("0.20")},  //Bucket 17
    { // Bucket 15
      new BigDecimal("-0.04"),  //Bucket 1
      new BigDecimal("0.17"),  //Bucket 2
      new BigDecimal("0.10"),  //Bucket 3
      new BigDecimal("0.13"),  //Bucket 4
      new BigDecimal("0.17"),  //Bucket 5
      new BigDecimal("0.01"),  //Bucket 6
      new BigDecimal("0.00"),  //Bucket 7
      new BigDecimal("0.06"),  //Bucket 8
      new BigDecimal("-0.03"),  //Bucket 9
      new BigDecimal("0.02"),  //Bucket 10
      new BigDecimal("0.16"),  //Bucket 11
      new BigDecimal("0.11"),  //Bucket 12
      new BigDecimal("0.09"),  //Bucket 13
      new BigDecimal("0.06"),  //Bucket 14
      new BigDecimal("0.29"),  //Bucket 15
      new BigDecimal("0.00"),  //Bucket 16
      new BigDecimal("0.16")},  //Bucket 17
    { // Bucket 16
      new BigDecimal("0.00"),  //Bucket 1
      new BigDecimal("0.00"),  //Bucket 2
      new BigDecimal("0.00"),  //Bucket 3
      new BigDecimal("0.00"),  //Bucket 4
      new BigDecimal("0.00"),  //Bucket 5
      new BigDecimal("0.00"),  //Bucket 6
      new BigDecimal("0.00"),  //Bucket 7
      new BigDecimal("0.00"),  //Bucket 8
      new BigDecimal("0.00"),  //Bucket 9
      new BigDecimal("0.00"),  //Bucket 10
      new BigDecimal("0.00"),  //Bucket 11
      new BigDecimal("0.00"),  //Bucket 12
      new BigDecimal("0.00"),  //Bucket 13
      new BigDecimal("0.00"),  //Bucket 14
      new BigDecimal("0.00"),  //Bucket 15
      new BigDecimal("0.00"),  //Bucket 16
      new BigDecimal("0.00")},  //Bucket 17
    { // Bucket 17
      new BigDecimal("0.06"),  //Bucket 1
      new BigDecimal("0.37"),  //Bucket 2
      new BigDecimal("0.27"),  //Bucket 3
      new BigDecimal("0.28"),  //Bucket 4
      new BigDecimal("0.34"),  //Bucket 5
      new BigDecimal("0.26"),  //Bucket 6
      new BigDecimal("0.18"),  //Bucket 7
      new BigDecimal("0.23"),  //Bucket 8
      new BigDecimal("0.13"),  //Bucket 9
      new BigDecimal("0.11"),  //Bucket 10
      new BigDecimal("0.27"),  //Bucket 11
      new BigDecimal("0.14"),  //Bucket 12
      new BigDecimal("0.22"),  //Bucket 13
      new BigDecimal("0.20"),  //Bucket 14
      new BigDecimal("0.16"),  //Bucket 15
      new BigDecimal("0.00"),  //Bucket 16
      new BigDecimal("0.21")} // Bucket 17
  };

  @Override
  public BigDecimal getSensitivityCorrelation(Sensitivity si, Sensitivity sk) {
    // NOTE: should both be in the same bucket -> intra bucket correlation
    int i = Integer.valueOf(si.getBucket());
    int k = Integer.valueOf(sk.getBucket());
    return CORRELATIONS[i - 1][k - 1];
  }

  @Override
  public BigDecimal getBucketCorrelation(String bi, String bk) {
    // NOTE: no residual bucket for commoditities
    int i = Integer.valueOf(bi);
    int k = Integer.valueOf(bk);
    return CORRELATIONS[i - 1][k - 1];
  }
}
