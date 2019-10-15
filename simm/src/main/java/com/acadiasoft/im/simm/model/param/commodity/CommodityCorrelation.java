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

package com.acadiasoft.im.simm.model.param.commodity;

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmBucketCorrelation;
import com.acadiasoft.im.simm.model.param.SimmSensitivityCorrelation;

import java.math.BigDecimal;

/**
 * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class CommodityCorrelation implements SimmBucketCorrelation, SimmSensitivityCorrelation {

  private static final BigDecimal[][] CORRELATIONS = { // Correlations between two buckets
      { // 1
          null, //
          new BigDecimal("0.15"), // 2
          new BigDecimal("0.13"), // 3
          new BigDecimal("0.17"), // 4
          new BigDecimal("0.16"), // 5
          new BigDecimal("0.02"), // 6
          new BigDecimal("0.19"), // 7
          new BigDecimal("-0.02"), // 8
          new BigDecimal("0.19"), // 9
          new BigDecimal("0.01"), // 10
          new BigDecimal("0.12"), // 11
          new BigDecimal("0.12"), // 12
          new BigDecimal("-0.01"), // 13
          new BigDecimal("0.11"), // 14
          new BigDecimal("0.02"), // 15
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.09") // 17
      },
      { // 2
          new BigDecimal("0.15"), // 1
          null, //
          new BigDecimal("0.93"), // 3
          new BigDecimal("0.95"), // 4
          new BigDecimal("0.93"), // 5
          new BigDecimal("0.23"), // 6
          new BigDecimal("0.20"), // 7
          new BigDecimal("0.20"), // 8
          new BigDecimal("0.20"), // 9
          new BigDecimal("0.06"), // 10
          new BigDecimal("0.36"), // 11
          new BigDecimal("0.23"), // 12
          new BigDecimal("0.30"), // 13
          new BigDecimal("0.28"), // 14
          new BigDecimal("0.10"), // 15
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.63") // 17
      },
      { // 3
          new BigDecimal("0.13"), // 1
          new BigDecimal("0.93"), // 2
          null, //
          new BigDecimal("0.90"), // 4
          new BigDecimal("0.89"), // 5
          new BigDecimal("0.15"), // 6
          new BigDecimal("0.18"), // 7
          new BigDecimal("0.13"), // 8
          new BigDecimal("0.14"), // 9
          new BigDecimal("0.02"), // 10
          new BigDecimal("0.22"), // 11
          new BigDecimal("0.08"), // 12
          new BigDecimal("0.21"), // 13
          new BigDecimal("0.13"), // 14
          new BigDecimal("0.02"), // 15
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.58") // 17
      },
      { // 4
          new BigDecimal("0.17"), // 1
          new BigDecimal("0.95"), // 2
          new BigDecimal("0.90"), // 3
          null, //
          new BigDecimal("0.90"), // 5
          new BigDecimal("0.18"), // 6
          new BigDecimal("0.22"), // 7
          new BigDecimal("0.16"), // 8
          new BigDecimal("0.20"), // 9
          new BigDecimal("0.00"), // 10
          new BigDecimal("0.35"), // 11
          new BigDecimal("0.18"), // 12
          new BigDecimal("0.27"), // 13
          new BigDecimal("0.25"), // 14
          new BigDecimal("0.05"), // 15
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.60") // 17
      },
      { // 5
          new BigDecimal("0.16"), // 1
          new BigDecimal("0.93"), // 2
          new BigDecimal("0.89"), // 3
          new BigDecimal("0.90"), // 4
          null, //
          new BigDecimal("0.23"), // 6
          new BigDecimal("0.21"), // 7
          new BigDecimal("0.20"), // 8
          new BigDecimal("0.19"), // 9
          new BigDecimal("0.09"), // 10
          new BigDecimal("0.38"), // 11
          new BigDecimal("0.25"), // 12
          new BigDecimal("0.33"), // 13
          new BigDecimal("0.27"), // 14
          new BigDecimal("0.09"), // 15
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.62") // 17
      },
      { // 6
          new BigDecimal("0.02"), // 1
          new BigDecimal("0.23"), // 2
          new BigDecimal("0.15"), // 3
          new BigDecimal("0.18"), // 4
          new BigDecimal("0.23"), // 5
          null, //
          new BigDecimal("0.18"), // 7
          new BigDecimal("0.63"), // 8
          new BigDecimal("0.16"), // 9
          new BigDecimal("0.02"), // 10
          new BigDecimal("0.13"), // 11
          new BigDecimal("-0.02"), // 12
          new BigDecimal("0.18"), // 13
          new BigDecimal("0.10"), // 14
          new BigDecimal("-0.03"), // 15
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.27") // 17
      },
      { // 7
          new BigDecimal("0.19"), // 1
          new BigDecimal("0.20"), // 2
          new BigDecimal("0.18"), // 3
          new BigDecimal("0.22"), // 4
          new BigDecimal("0.21"), // 5
          new BigDecimal("0.18"), // 6
          null, //
          new BigDecimal("0.08"), // 8
          new BigDecimal("0.62"), // 9
          new BigDecimal("0.11"), // 10
          new BigDecimal("0.11"), // 11
          new BigDecimal("0.01"), // 12
          new BigDecimal("0.07"), // 13
          new BigDecimal("0.10"), // 14
          new BigDecimal("0.02"), // 15
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.15") // 17
      },
      { // 8
          new BigDecimal("-0.02"), // 1
          new BigDecimal("0.20"), // 2
          new BigDecimal("0.13"), // 3
          new BigDecimal("0.16"), // 4
          new BigDecimal("0.20"), // 5
          new BigDecimal("0.63"), // 6
          new BigDecimal("0.08"), // 7
          null, //
          new BigDecimal("0.16"), // 9
          new BigDecimal("-0.04"), // 10
          new BigDecimal("0.09"), // 11
          new BigDecimal("0.02"), // 12
          new BigDecimal("0.10"), // 13
          new BigDecimal("0.06"), // 14
          new BigDecimal("0.03"), // 15
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.20") // 17
      },
      { // 9
          new BigDecimal("0.19"), // 1
          new BigDecimal("0.20"), // 2
          new BigDecimal("0.14"), // 3
          new BigDecimal("0.20"), // 4
          new BigDecimal("0.19"), // 5
          new BigDecimal("0.16"), // 6
          new BigDecimal("0.62"), // 7
          new BigDecimal("0.16"), // 8
          null, //
          new BigDecimal("0.01"), // 10
          new BigDecimal("0.11"), // 11
          new BigDecimal("0.00"), // 12
          new BigDecimal("0.10"), // 13
          new BigDecimal("0.09"), // 14
          new BigDecimal("0.05"), // 15
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.13") // 17
      },
      { // 10
          new BigDecimal("0.01"), // 1
          new BigDecimal("0.06"), // 2
          new BigDecimal("0.02"), // 3
          new BigDecimal("0.00"), // 4
          new BigDecimal("0.09"), // 5
          new BigDecimal("0.02"), // 6
          new BigDecimal("0.11"), // 7
          new BigDecimal("-0.04"), // 8
          new BigDecimal("0.01"), // 9
          null, //
          new BigDecimal("0.07"), // 11
          new BigDecimal("0.05"), // 12
          new BigDecimal("0.07"), // 13
          new BigDecimal("0.07"), // 14
          new BigDecimal("0.01"), // 15
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.01") // 17
      },
      { // 11
          new BigDecimal("0.12"), // 1
          new BigDecimal("0.36"), // 2
          new BigDecimal("0.22"), // 3
          new BigDecimal("0.35"), // 4
          new BigDecimal("0.38"), // 5
          new BigDecimal("0.13"), // 6
          new BigDecimal("0.11"), // 7
          new BigDecimal("0.09"), // 8
          new BigDecimal("0.11"), // 9
          new BigDecimal("0.07"), // 10
          null, //
          new BigDecimal("0.35"), // 12
          new BigDecimal("0.21"), // 13
          new BigDecimal("0.20"), // 14
          new BigDecimal("0.10"), // 15
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.31") // 17
      },
      { // 12
          new BigDecimal("0.12"), // 1
          new BigDecimal("0.23"), // 2
          new BigDecimal("0.08"), // 3
          new BigDecimal("0.18"), // 4
          new BigDecimal("0.25"), // 5
          new BigDecimal("-0.02"), // 6
          new BigDecimal("0.01"), // 7
          new BigDecimal("0.02"), // 8
          new BigDecimal("0.00"), // 9
          new BigDecimal("0.05"), // 10
          new BigDecimal("0.35"), // 11
          null, //
          new BigDecimal("0.11"), // 13
          new BigDecimal("0.24"), // 14
          new BigDecimal("0.05"), // 15
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.16") // 17
      },
      { // 13
          new BigDecimal("-0.01"), // 1
          new BigDecimal("0.30"), // 2
          new BigDecimal("0.21"), // 3
          new BigDecimal("0.27"), // 4
          new BigDecimal("0.33"), // 5
          new BigDecimal("0.18"), // 6
          new BigDecimal("0.07"), // 7
          new BigDecimal("0.10"), // 8
          new BigDecimal("0.10"), // 9
          new BigDecimal("0.07"), // 10
          new BigDecimal("0.21"), // 11
          new BigDecimal("0.11"), // 12
          null, //
          new BigDecimal("0.27"), // 14
          new BigDecimal("0.13"), // 15
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.35") // 17
      },
      { // 14
          new BigDecimal("0.11"), // 1
          new BigDecimal("0.28"), // 2
          new BigDecimal("0.13"), // 3
          new BigDecimal("0.25"), // 4
          new BigDecimal("0.27"), // 5
          new BigDecimal("0.10"), // 6
          new BigDecimal("0.10"), // 7
          new BigDecimal("0.06"), // 8
          new BigDecimal("0.09"), // 9
          new BigDecimal("0.07"), // 10
          new BigDecimal("0.20"), // 11
          new BigDecimal("0.24"), // 12
          new BigDecimal("0.27"), // 13
          null, //
          new BigDecimal("0.08"), // 15
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.21") // 17
      },
      { // 15
          new BigDecimal("0.02"), // 1
          new BigDecimal("0.10"), // 2
          new BigDecimal("0.02"), // 3
          new BigDecimal("0.05"), // 4
          new BigDecimal("0.09"), // 5
          new BigDecimal("-0.03"), // 6
          new BigDecimal("0.02"), // 7
          new BigDecimal("0.03"), // 8
          new BigDecimal("0.05"), // 9
          new BigDecimal("0.01"), // 10
          new BigDecimal("0.10"), // 11
          new BigDecimal("0.05"), // 12
          new BigDecimal("0.13"), // 13
          new BigDecimal("0.08"), // 14
          null, //
          new BigDecimal("0.00"), // 16
          new BigDecimal("0.12") // 17
      },
      { // 16
          new BigDecimal("0.00"), // 1
          new BigDecimal("0.00"), // 2
          new BigDecimal("0.00"), // 3
          new BigDecimal("0.00"), // 4
          new BigDecimal("0.00"), // 5
          new BigDecimal("0.00"), // 6
          new BigDecimal("0.00"), // 7
          new BigDecimal("0.00"), // 8
          new BigDecimal("0.00"), // 9
          new BigDecimal("0.00"), // 10
          new BigDecimal("0.00"), // 11
          new BigDecimal("0.00"), // 12
          new BigDecimal("0.00"), // 13
          new BigDecimal("0.00"), // 14
          new BigDecimal("0.00"), // 15
          null, //
          new BigDecimal("0.00") // 17
      },
      { // 17
          new BigDecimal("0.09"), // 1
          new BigDecimal("0.63"), // 2
          new BigDecimal("0.58"), // 3
          new BigDecimal("0.60"), // 4
          new BigDecimal("0.62"), // 5
          new BigDecimal("0.27"), // 6
          new BigDecimal("0.15"), // 7
          new BigDecimal("0.20"), // 8
          new BigDecimal("0.13"), // 9
          new BigDecimal("0.01"), // 10
          new BigDecimal("0.31"), // 11
          new BigDecimal("0.16"), // 12
          new BigDecimal("0.35"), // 13
          new BigDecimal("0.21"), // 14
          new BigDecimal("0.12"), // 15
          new BigDecimal("0.00"), // 16
          null // 17
      }
  };

  private static final BigDecimal[] INTRA_BUCKET = {
      new BigDecimal("0.28"), // 1
      new BigDecimal("0.98"), // 2
      new BigDecimal("0.92"), // 3
      new BigDecimal("0.97"), // 4
      new BigDecimal("0.99"), // 5
      new BigDecimal("0.74"), // 6
      new BigDecimal("0.87"), // 7
      new BigDecimal("0.35"), // 8
      new BigDecimal("0.69"), // 9
      new BigDecimal("0.14"), // 10
      new BigDecimal("0.53"), // 11
      new BigDecimal("0.63"), // 12
      new BigDecimal("0.61"), // 13
      new BigDecimal("0.18"), // 14
      new BigDecimal("0.15"), // 15
      new BigDecimal("0.00"), // 16
      new BigDecimal("0.36") // 17
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
