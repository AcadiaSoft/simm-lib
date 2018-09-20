/*
 * Copyright (c) 2018 AcadiaSoft, Inc.
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

package com.acadiasoft.im.simm.model.param.commodity;

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmBucketCorrelation;
import com.acadiasoft.im.simm.model.param.SimmSensitivityCorrelation;

import java.math.BigDecimal;

/**
 * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class CommodityCorrelationV2_1 implements SimmBucketCorrelation, SimmSensitivityCorrelation {

  private static final BigDecimal[][] CORRELATIONS = { // Correlations between two buckets
      { // 1
          null, //
          new BigDecimal("0.16"), // 2
          new BigDecimal("0.11"), // 3
          new BigDecimal("0.19"), // 4
          new BigDecimal("0.22"), // 5
          new BigDecimal("0.12"), // 6
          new BigDecimal("0.22"), // 7
          new BigDecimal("0.02"), // 8
          new BigDecimal("0.27"), // 9
          new BigDecimal("0.08"), // 10
          new BigDecimal("0.11"), // 11
          new BigDecimal("0.05"), // 12
          new BigDecimal("0.04"), // 13
          new BigDecimal("0.06"), // 14
          new BigDecimal("0.01"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.1") // 17
      },
      { // 2
          new BigDecimal("0.16"), // 1
          null, //
          new BigDecimal("0.89"), // 3
          new BigDecimal("0.94"), // 4
          new BigDecimal("0.93"), // 5
          new BigDecimal("0.32"), // 6
          new BigDecimal("0.24"), // 7
          new BigDecimal("0.19"), // 8
          new BigDecimal("0.21"), // 9
          new BigDecimal("0.06"), // 10
          new BigDecimal("0.39"), // 11
          new BigDecimal("0.23"), // 12
          new BigDecimal("0.39"), // 13
          new BigDecimal("0.29"), // 14
          new BigDecimal("0.13"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.66") // 17
      },
      { // 3
          new BigDecimal("0.11"), // 1
          new BigDecimal("0.89"), // 2
          null, //
          new BigDecimal("0.87"), // 4
          new BigDecimal("0.88"), // 5
          new BigDecimal("0.17"), // 6
          new BigDecimal("0.17"), // 7
          new BigDecimal("0.13"), // 8
          new BigDecimal("0.12"), // 9
          new BigDecimal("0.03"), // 10
          new BigDecimal("0.24"), // 11
          new BigDecimal("0.04"), // 12
          new BigDecimal("0.27"), // 13
          new BigDecimal("0.19"), // 14
          new BigDecimal("0.08"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.61") // 17
      },
      { // 4
          new BigDecimal("0.19"), // 1
          new BigDecimal("0.94"), // 2
          new BigDecimal("0.87"), // 3
          null, //
          new BigDecimal("0.92"), // 5
          new BigDecimal("0.37"), // 6
          new BigDecimal("0.27"), // 7
          new BigDecimal("0.21"), // 8
          new BigDecimal("0.21"), // 9
          new BigDecimal("0.03"), // 10
          new BigDecimal("0.36"), // 11
          new BigDecimal("0.16"), // 12
          new BigDecimal("0.27"), // 13
          new BigDecimal("0.28"), // 14
          new BigDecimal("0.09"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.64") // 17
      },
      { // 5
          new BigDecimal("0.22"), // 1
          new BigDecimal("0.93"), // 2
          new BigDecimal("0.88"), // 3
          new BigDecimal("0.92"), // 4
          null, //
          new BigDecimal("0.29"), // 6
          new BigDecimal("0.26"), // 7
          new BigDecimal("0.19"), // 8
          new BigDecimal("0.23"), // 9
          new BigDecimal("0.1"), // 10
          new BigDecimal("0.4"), // 11
          new BigDecimal("0.27"), // 12
          new BigDecimal("0.38"), // 13
          new BigDecimal("0.3"), // 14
          new BigDecimal("0.15"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.64") // 17
      },
      { // 6
          new BigDecimal("0.12"), // 1
          new BigDecimal("0.32"), // 2
          new BigDecimal("0.17"), // 3
          new BigDecimal("0.37"), // 4
          new BigDecimal("0.29"), // 5
          null, //
          new BigDecimal("0.19"), // 7
          new BigDecimal("0.6"), // 8
          new BigDecimal("0.18"), // 9
          new BigDecimal("0.09"), // 10
          new BigDecimal("0.22"), // 11
          new BigDecimal("0.09"), // 12
          new BigDecimal("0.14"), // 13
          new BigDecimal("0.16"), // 14
          new BigDecimal("0.1"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.37") // 17
      },
      { // 7
          new BigDecimal("0.22"), // 1
          new BigDecimal("0.24"), // 2
          new BigDecimal("0.17"), // 3
          new BigDecimal("0.27"), // 4
          new BigDecimal("0.26"), // 5
          new BigDecimal("0.19"), // 6
          null, //
          new BigDecimal("0.06"), // 8
          new BigDecimal("0.68"), // 9
          new BigDecimal("0.16"), // 10
          new BigDecimal("0.21"), // 11
          new BigDecimal("0.1"), // 12
          new BigDecimal("0.24"), // 13
          new BigDecimal("0.25"), // 14
          new BigDecimal("-0.01"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.27") // 17
      },
      { // 8
          new BigDecimal("0.02"), // 1
          new BigDecimal("0.19"), // 2
          new BigDecimal("0.13"), // 3
          new BigDecimal("0.21"), // 4
          new BigDecimal("0.19"), // 5
          new BigDecimal("0.6"), // 6
          new BigDecimal("0.06"), // 7
          null, //
          new BigDecimal("0.12"), // 9
          new BigDecimal("0.01"), // 10
          new BigDecimal("0.1"), // 11
          new BigDecimal("0.03"), // 12
          new BigDecimal("0.02"), // 13
          new BigDecimal("0.07"), // 14
          new BigDecimal("0.1"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.21") // 17
      },
      { // 9
          new BigDecimal("0.27"), // 1
          new BigDecimal("0.21"), // 2
          new BigDecimal("0.12"), // 3
          new BigDecimal("0.21"), // 4
          new BigDecimal("0.23"), // 5
          new BigDecimal("0.18"), // 6
          new BigDecimal("0.68"), // 7
          new BigDecimal("0.12"), // 8
          null, //
          new BigDecimal("0.05"), // 10
          new BigDecimal("0.16"), // 11
          new BigDecimal("0.03"), // 12
          new BigDecimal("0.19"), // 13
          new BigDecimal("0.16"), // 14
          new BigDecimal("-0.01"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.19") // 17
      },
      { // 10
          new BigDecimal("0.08"), // 1
          new BigDecimal("0.06"), // 2
          new BigDecimal("0.03"), // 3
          new BigDecimal("0.03"), // 4
          new BigDecimal("0.1"), // 5
          new BigDecimal("0.09"), // 6
          new BigDecimal("0.16"), // 7
          new BigDecimal("0.01"), // 8
          new BigDecimal("0.05"), // 9
          null, //
          new BigDecimal("0.08"), // 11
          new BigDecimal("0.04"), // 12
          new BigDecimal("0.05"), // 13
          new BigDecimal("0.11"), // 14
          new BigDecimal("0.02"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0") // 17
      },
      { // 11
          new BigDecimal("0.11"), // 1
          new BigDecimal("0.39"), // 2
          new BigDecimal("0.24"), // 3
          new BigDecimal("0.36"), // 4
          new BigDecimal("0.4"), // 5
          new BigDecimal("0.22"), // 6
          new BigDecimal("0.21"), // 7
          new BigDecimal("0.1"), // 8
          new BigDecimal("0.16"), // 9
          new BigDecimal("0.08"), // 10
          null, //
          new BigDecimal("0.34"), // 12
          new BigDecimal("0.19"), // 13
          new BigDecimal("0.22"), // 14
          new BigDecimal("0.15"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.34") // 17
      },
      { // 12
          new BigDecimal("0.05"), // 1
          new BigDecimal("0.23"), // 2
          new BigDecimal("0.04"), // 3
          new BigDecimal("0.16"), // 4
          new BigDecimal("0.27"), // 5
          new BigDecimal("0.09"), // 6
          new BigDecimal("0.1"), // 7
          new BigDecimal("0.03"), // 8
          new BigDecimal("0.03"), // 9
          new BigDecimal("0.04"), // 10
          new BigDecimal("0.34"), // 11
          null, //
          new BigDecimal("0.14"), // 13
          new BigDecimal("0.26"), // 14
          new BigDecimal("0.09"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.2") // 17
      },
      { // 13
          new BigDecimal("0.04"), // 1
          new BigDecimal("0.39"), // 2
          new BigDecimal("0.27"), // 3
          new BigDecimal("0.27"), // 4
          new BigDecimal("0.38"), // 5
          new BigDecimal("0.14"), // 6
          new BigDecimal("0.24"), // 7
          new BigDecimal("0.02"), // 8
          new BigDecimal("0.19"), // 9
          new BigDecimal("0.05"), // 10
          new BigDecimal("0.19"), // 11
          new BigDecimal("0.14"), // 12
          null, //
          new BigDecimal("0.3"), // 14
          new BigDecimal("0.16"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.4") // 17
      },
      { // 14
          new BigDecimal("0.06"), // 1
          new BigDecimal("0.29"), // 2
          new BigDecimal("0.19"), // 3
          new BigDecimal("0.28"), // 4
          new BigDecimal("0.3"), // 5
          new BigDecimal("0.16"), // 6
          new BigDecimal("0.25"), // 7
          new BigDecimal("0.07"), // 8
          new BigDecimal("0.16"), // 9
          new BigDecimal("0.11"), // 10
          new BigDecimal("0.22"), // 11
          new BigDecimal("0.26"), // 12
          new BigDecimal("0.3"), // 13
          null, //
          new BigDecimal("0.09"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.3") // 17
      },
      { // 15
          new BigDecimal("0.01"), // 1
          new BigDecimal("0.13"), // 2
          new BigDecimal("0.08"), // 3
          new BigDecimal("0.09"), // 4
          new BigDecimal("0.15"), // 5
          new BigDecimal("0.1"), // 6
          new BigDecimal("-0.01"), // 7
          new BigDecimal("0.1"), // 8
          new BigDecimal("-0.01"), // 9
          new BigDecimal("0.02"), // 10
          new BigDecimal("0.15"), // 11
          new BigDecimal("0.09"), // 12
          new BigDecimal("0.16"), // 13
          new BigDecimal("0.09"), // 14
          null, //
          new BigDecimal("0"), // 16
          new BigDecimal("0.16") // 17
      },
      { // 16
          new BigDecimal("0"), // 1
          new BigDecimal("0"), // 2
          new BigDecimal("0"), // 3
          new BigDecimal("0"), // 4
          new BigDecimal("0"), // 5
          new BigDecimal("0"), // 6
          new BigDecimal("0"), // 7
          new BigDecimal("0"), // 8
          new BigDecimal("0"), // 9
          new BigDecimal("0"), // 10
          new BigDecimal("0"), // 11
          new BigDecimal("0"), // 12
          new BigDecimal("0"), // 13
          new BigDecimal("0"), // 14
          new BigDecimal("0"), // 15
          null, //
          new BigDecimal("0") // 17
      },
      { // 17
          new BigDecimal("0.1"), // 1
          new BigDecimal("0.66"), // 2
          new BigDecimal("0.61"), // 3
          new BigDecimal("0.64"), // 4
          new BigDecimal("0.64"), // 5
          new BigDecimal("0.37"), // 6
          new BigDecimal("0.27"), // 7
          new BigDecimal("0.21"), // 8
          new BigDecimal("0.19"), // 9
          new BigDecimal("0"), // 10
          new BigDecimal("0.34"), // 11
          new BigDecimal("0.2"), // 12
          new BigDecimal("0.4"), // 13
          new BigDecimal("0.3"), // 14
          new BigDecimal("0.16"), // 15
          new BigDecimal("0"), // 16
          null // 17
      }
  };

  private static final BigDecimal[] INTRA_BUCKET = {
      new BigDecimal("0.27"), // 1
      new BigDecimal("0.97"), // 2
      new BigDecimal("0.92"), // 3
      new BigDecimal("0.97"), // 4
      new BigDecimal("0.99"), // 5
      new BigDecimal("1"), // 6
      new BigDecimal("1"), // 7
      new BigDecimal("0.4"), // 8
      new BigDecimal("0.73"), // 9
      new BigDecimal("0.13"), // 10
      new BigDecimal("0.53"), // 11
      new BigDecimal("0.64"), // 12
      new BigDecimal("0.63"), // 13
      new BigDecimal("0.26"), // 14
      new BigDecimal("0.26"), // 15
      new BigDecimal("0"), // 16
      new BigDecimal("0.38") // 17
  };

  @Override
  public BigDecimal getSensitivityCorrelation(WeightingClass si, WeightingClass sk) {
    // NOTE: should both be in the same bucket -> intra bucket correlation
    int i = Integer.valueOf(si.getBucket());
    int k = Integer.valueOf(sk.getBucket());
    if (i == k) return INTRA_BUCKET[i - 1];
    throw new RuntimeException("Called for a sensitivity correlation with two sensitivities from different buckets: [" + i + " and " + k + "]");
  }

  @Override
  public BigDecimal getBucketCorrelation(BucketClass bi, BucketClass bk) {
    // NOTE: no residual bucket for commoditities
    int i = bi.getBucketType().getBucketNumber();
    int k = bk.getBucketType().getBucketNumber();
    return CORRELATIONS[i - 1][k - 1];
  }
}
