/*
 * Copyright (c) 2020 AcadiaSoft, Inc.
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
          new BigDecimal("0.15"), // 3
          new BigDecimal("0.21"), // 4
          new BigDecimal("0.16"), // 5
          new BigDecimal("0.03"), // 6
          new BigDecimal("0.11"), // 7
          new BigDecimal("0.02"), // 8
          new BigDecimal("0.12"), // 9
          new BigDecimal("0.15"), // 10
          new BigDecimal("0.15"), // 11
          new BigDecimal("0.06"), // 12
          new BigDecimal("0.0"), // 13
          new BigDecimal("0.04"), // 14
          new BigDecimal("0.06"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.11") // 17
      },
      { // 2
          new BigDecimal("0.15"), // 1
          null, //
          new BigDecimal("0.74"), // 3
          new BigDecimal("0.92"), // 4
          new BigDecimal("0.89"), // 5
          new BigDecimal("0.34"), // 6
          new BigDecimal("0.23"), // 7
          new BigDecimal("0.16"), // 8
          new BigDecimal("0.22"), // 9
          new BigDecimal("0.26"), // 10
          new BigDecimal("0.31"), // 11
          new BigDecimal("0.32"), // 12
          new BigDecimal("0.22"), // 13
          new BigDecimal("0.25"), // 14
          new BigDecimal("0.19"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.57") // 17
      },
      { // 3
          new BigDecimal("0.15"), // 1
          new BigDecimal("0.74"), // 2
          null, //
          new BigDecimal("0.73"), // 4
          new BigDecimal("0.69"), // 5
          new BigDecimal("0.15"), // 6
          new BigDecimal("0.22"), // 7
          new BigDecimal("0.08"), // 8
          new BigDecimal("0.14"), // 9
          new BigDecimal("0.16"), // 10
          new BigDecimal("0.21"), // 11
          new BigDecimal("0.15"), // 12
          new BigDecimal("-0.03"), // 13
          new BigDecimal("0.16"), // 14
          new BigDecimal("0.14"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.42") // 17
      },
      { // 4
          new BigDecimal("0.21"), // 1
          new BigDecimal("0.92"), // 2
          new BigDecimal("0.73"), // 3
          null, //
          new BigDecimal("0.83"), // 5
          new BigDecimal("0.3"), // 6
          new BigDecimal("0.26"), // 7
          new BigDecimal("0.07"), // 8
          new BigDecimal("0.19"), // 9
          new BigDecimal("0.22"), // 10
          new BigDecimal("0.28"), // 11
          new BigDecimal("0.31"), // 12
          new BigDecimal("0.13"), // 13
          new BigDecimal("0.22"), // 14
          new BigDecimal("0.11"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.48") // 17
      },
      { // 5
          new BigDecimal("0.16"), // 1
          new BigDecimal("0.89"), // 2
          new BigDecimal("0.69"), // 3
          new BigDecimal("0.83"), // 4
          null, //
          new BigDecimal("0.12"), // 6
          new BigDecimal("0.14"), // 7
          new BigDecimal("0.0"), // 8
          new BigDecimal("0.06"), // 9
          new BigDecimal("0.1"), // 10
          new BigDecimal("0.24"), // 11
          new BigDecimal("0.2"), // 12
          new BigDecimal("0.06"), // 13
          new BigDecimal("0.2"), // 14
          new BigDecimal("0.09"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.49") // 17
      },
      { // 6
          new BigDecimal("0.03"), // 1
          new BigDecimal("0.34"), // 2
          new BigDecimal("0.15"), // 3
          new BigDecimal("0.3"), // 4
          new BigDecimal("0.12"), // 5
          null, //
          new BigDecimal("0.25"), // 7
          new BigDecimal("0.58"), // 8
          new BigDecimal("0.21"), // 9
          new BigDecimal("0.14"), // 10
          new BigDecimal("0.23"), // 11
          new BigDecimal("0.15"), // 12
          new BigDecimal("0.25"), // 13
          new BigDecimal("0.15"), // 14
          new BigDecimal("0.12"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.37") // 17
      },
      { // 7
          new BigDecimal("0.11"), // 1
          new BigDecimal("0.23"), // 2
          new BigDecimal("0.22"), // 3
          new BigDecimal("0.26"), // 4
          new BigDecimal("0.14"), // 5
          new BigDecimal("0.25"), // 6
          null, //
          new BigDecimal("0.19"), // 8
          new BigDecimal("0.64"), // 9
          new BigDecimal("0.19"), // 10
          new BigDecimal("0.03"), // 11
          new BigDecimal("-0.03"), // 12
          new BigDecimal("0.04"), // 13
          new BigDecimal("0.05"), // 14
          new BigDecimal("0.06"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.17") // 17
      },
      { // 8
          new BigDecimal("0.02"), // 1
          new BigDecimal("0.16"), // 2
          new BigDecimal("0.08"), // 3
          new BigDecimal("0.07"), // 4
          new BigDecimal("0.0"), // 5
          new BigDecimal("0.58"), // 6
          new BigDecimal("0.19"), // 7
          null, //
          new BigDecimal("0.17"), // 9
          new BigDecimal("-0.01"), // 10
          new BigDecimal("0.08"), // 11
          new BigDecimal("0.01"), // 12
          new BigDecimal("0.11"), // 13
          new BigDecimal("0.08"), // 14
          new BigDecimal("0.08"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.15") // 17
      },
      { // 9
          new BigDecimal("0.12"), // 1
          new BigDecimal("0.22"), // 2
          new BigDecimal("0.14"), // 3
          new BigDecimal("0.19"), // 4
          new BigDecimal("0.06"), // 5
          new BigDecimal("0.21"), // 6
          new BigDecimal("0.64"), // 7
          new BigDecimal("0.17"), // 8
          null, //
          new BigDecimal("0.1"), // 10
          new BigDecimal("0.05"), // 11
          new BigDecimal("-0.04"), // 12
          new BigDecimal("0.05"), // 13
          new BigDecimal("0.03"), // 14
          new BigDecimal("0.05"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.17") // 17
      },
      { // 10
          new BigDecimal("0.15"), // 1
          new BigDecimal("0.26"), // 2
          new BigDecimal("0.16"), // 3
          new BigDecimal("0.22"), // 4
          new BigDecimal("0.1"), // 5
          new BigDecimal("0.14"), // 6
          new BigDecimal("0.19"), // 7
          new BigDecimal("-0.01"), // 8
          new BigDecimal("0.1"), // 9
          null, //
          new BigDecimal("0.12"), // 11
          new BigDecimal("0.13"), // 12
          new BigDecimal("0.12"), // 13
          new BigDecimal("0.1"), // 14
          new BigDecimal("0.12"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.17") // 17
      },
      { // 11
          new BigDecimal("0.15"), // 1
          new BigDecimal("0.31"), // 2
          new BigDecimal("0.21"), // 3
          new BigDecimal("0.28"), // 4
          new BigDecimal("0.24"), // 5
          new BigDecimal("0.23"), // 6
          new BigDecimal("0.03"), // 7
          new BigDecimal("0.08"), // 8
          new BigDecimal("0.05"), // 9
          new BigDecimal("0.12"), // 10
          null, //
          new BigDecimal("0.34"), // 12
          new BigDecimal("0.23"), // 13
          new BigDecimal("0.17"), // 14
          new BigDecimal("0.14"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.3") // 17
      },
      { // 12
          new BigDecimal("0.06"), // 1
          new BigDecimal("0.32"), // 2
          new BigDecimal("0.15"), // 3
          new BigDecimal("0.31"), // 4
          new BigDecimal("0.2"), // 5
          new BigDecimal("0.15"), // 6
          new BigDecimal("-0.03"), // 7
          new BigDecimal("0.01"), // 8
          new BigDecimal("-0.04"), // 9
          new BigDecimal("0.13"), // 10
          new BigDecimal("0.34"), // 11
          null, //
          new BigDecimal("0.15"), // 13
          new BigDecimal("0.19"), // 14
          new BigDecimal("0.11"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.27") // 17
      },
      { // 13
          new BigDecimal("0.0"), // 1
          new BigDecimal("0.22"), // 2
          new BigDecimal("-0.03"), // 3
          new BigDecimal("0.13"), // 4
          new BigDecimal("0.06"), // 5
          new BigDecimal("0.25"), // 6
          new BigDecimal("0.04"), // 7
          new BigDecimal("0.11"), // 8
          new BigDecimal("0.05"), // 9
          new BigDecimal("0.12"), // 10
          new BigDecimal("0.23"), // 11
          new BigDecimal("0.15"), // 12
          null, //
          new BigDecimal("0.26"), // 14
          new BigDecimal("0.14"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.26") // 17
      },
      { // 14
          new BigDecimal("0.04"), // 1
          new BigDecimal("0.25"), // 2
          new BigDecimal("0.16"), // 3
          new BigDecimal("0.22"), // 4
          new BigDecimal("0.2"), // 5
          new BigDecimal("0.15"), // 6
          new BigDecimal("0.05"), // 7
          new BigDecimal("0.08"), // 8
          new BigDecimal("0.03"), // 9
          new BigDecimal("0.1"), // 10
          new BigDecimal("0.17"), // 11
          new BigDecimal("0.19"), // 12
          new BigDecimal("0.26"), // 13
          null, //
          new BigDecimal("0.1"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.22") // 17
      },
      { // 15
          new BigDecimal("0.06"), // 1
          new BigDecimal("0.19"), // 2
          new BigDecimal("0.14"), // 3
          new BigDecimal("0.11"), // 4
          new BigDecimal("0.09"), // 5
          new BigDecimal("0.12"), // 6
          new BigDecimal("0.06"), // 7
          new BigDecimal("0.08"), // 8
          new BigDecimal("0.05"), // 9
          new BigDecimal("0.12"), // 10
          new BigDecimal("0.14"), // 11
          new BigDecimal("0.11"), // 12
          new BigDecimal("0.14"), // 13
          new BigDecimal("0.1"), // 14
          null, //
          new BigDecimal("0"), // 16
          new BigDecimal("0.2") // 17
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
          new BigDecimal("0.11"), // 1
          new BigDecimal("0.57"), // 2
          new BigDecimal("0.42"), // 3
          new BigDecimal("0.48"), // 4
          new BigDecimal("0.49"), // 5
          new BigDecimal("0.37"), // 6
          new BigDecimal("0.17"), // 7
          new BigDecimal("0.15"), // 8
          new BigDecimal("0.17"), // 9
          new BigDecimal("0.17"), // 10
          new BigDecimal("0.3"), // 11
          new BigDecimal("0.27"), // 12
          new BigDecimal("0.26"), // 13
          new BigDecimal("0.22"), // 14
          new BigDecimal("0.2"), // 15
          new BigDecimal("0"), // 16
          null // 17
      }
  };

  private static final BigDecimal[] INTRA_BUCKET = {
      new BigDecimal("0.16"), // 1
      new BigDecimal("0.98"), // 2
      new BigDecimal("0.77"), // 3
      new BigDecimal("0.82"), // 4
      new BigDecimal("0.98"), // 5
      new BigDecimal("0.89"), // 6
      new BigDecimal("0.96"), // 7
      new BigDecimal("0.48"), // 8
      new BigDecimal("0.64"), // 9
      new BigDecimal("0.39"), // 10
      new BigDecimal("0.45"), // 11
      new BigDecimal("0.53"), // 12
      new BigDecimal("0.65"), // 13
      new BigDecimal("0.12"), // 14
      new BigDecimal("0.21"), // 15
      new BigDecimal("0"), // 16
      new BigDecimal("0.35") // 17
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
