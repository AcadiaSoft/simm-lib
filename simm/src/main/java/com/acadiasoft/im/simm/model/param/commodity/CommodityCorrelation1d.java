/*
 * Copyright (c) 2021 AcadiaSoft, Inc.
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
public class CommodityCorrelation1d implements SimmBucketCorrelation, SimmSensitivityCorrelation {

  private static final BigDecimal[][] CORRELATIONS = { // Correlations between two buckets
      { // 1
          null, //
          new BigDecimal("0.36"), // 2
          new BigDecimal("0.23"), // 3
          new BigDecimal("0.3"), // 4
          new BigDecimal("0.3"), // 5
          new BigDecimal("0.07"), // 6
          new BigDecimal("0.32"), // 7
          new BigDecimal("0.02"), // 8
          new BigDecimal("0.26"), // 9
          new BigDecimal("0.2"), // 10
          new BigDecimal("0.17"), // 11
          new BigDecimal("0.15"), // 12
          new BigDecimal("0.21"), // 13
          new BigDecimal("0.15"), // 14
          new BigDecimal("0.19"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.24"), // 17
      },
      { // 2
          new BigDecimal("0.36"), // 1
          null, //2
          new BigDecimal("0.93"), // 3
          new BigDecimal("0.94"), // 4
          new BigDecimal("0.88"), // 5
          new BigDecimal("0.16"), // 6
          new BigDecimal("0.21"), // 7
          new BigDecimal("0.09"), // 8
          new BigDecimal("0.21"), // 9
          new BigDecimal("0.2"), // 10
          new BigDecimal("0.4"), // 11
          new BigDecimal("0.3"), // 12
          new BigDecimal("0.24"), // 13
          new BigDecimal("0.29"), // 14
          new BigDecimal("0.23"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.56"), // 17
      },
      { // 3
          new BigDecimal("0.23"), // 1
          new BigDecimal("0.93"), // 2
          null, // 3
          new BigDecimal("0.91"), // 4
          new BigDecimal("0.85"), // 5
          new BigDecimal("0.06"), // 6
          new BigDecimal("0.21"), // 7
          new BigDecimal("0.04"), // 8
          new BigDecimal("0.21"), // 9
          new BigDecimal("0.19"), // 10
          new BigDecimal("0.33"), // 11
          new BigDecimal("0.23"), // 12
          new BigDecimal("0.14"), // 13
          new BigDecimal("0.23"), // 14
          new BigDecimal("0.25"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.5"), // 17
      },
      { // 4
          new BigDecimal("0.3"), // 1
          new BigDecimal("0.94"), // 2
          new BigDecimal("0.91"), // 3
          null, // 4
          new BigDecimal("0.83"), // 5
          new BigDecimal("0.06"), // 6
          new BigDecimal("0.24"), // 7
          new BigDecimal("0.04"), // 8
          new BigDecimal("0.21"), // 9
          new BigDecimal("0.17"), // 10
          new BigDecimal("0.36"), // 11
          new BigDecimal("0.25"), // 12
          new BigDecimal("0.14"), // 13
          new BigDecimal("0.25"), // 14
          new BigDecimal("0.2"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.53"), // 17
      },
      { // 5
          new BigDecimal("0.3"), // 1
          new BigDecimal("0.88"), // 2
          new BigDecimal("0.85"), // 3
          new BigDecimal("0.83"), // 4
          null, // 5
          new BigDecimal("0.1"), // 6
          new BigDecimal("0.17"), // 7
          new BigDecimal("0.04"), // 8
          new BigDecimal("0.16"), // 9
          new BigDecimal("0.17"), // 10
          new BigDecimal("0.4"), // 11
          new BigDecimal("0.33"), // 12
          new BigDecimal("0.25"), // 13
          new BigDecimal("0.3"), // 14
          new BigDecimal("0.19"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.53"), // 17
      },
      { // 6
          new BigDecimal("0.07"), // 1
          new BigDecimal("0.16"), // 2
          new BigDecimal("0.06"), // 3
          new BigDecimal("0.06"), // 4
          new BigDecimal("0.1"), // 5
          null, // 6
          new BigDecimal("0.27"), // 7
          new BigDecimal("0.5"), // 8
          new BigDecimal("0.2"), // 9
          new BigDecimal("0.04"), // 10
          new BigDecimal("0.17"), // 11
          new BigDecimal("0.08"), // 12
          new BigDecimal("0.12"), // 13
          new BigDecimal("0.08"), // 14
          new BigDecimal("0.14"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.25"), // 17
      },
      { // 7
          new BigDecimal("0.32"), // 1
          new BigDecimal("0.21"), // 2
          new BigDecimal("0.21"), // 3
          new BigDecimal("0.24"), // 4
          new BigDecimal("0.17"), // 5
          new BigDecimal("0.27"), // 6
          null, // 7 
          new BigDecimal("0.27"), // 8
          new BigDecimal("0.61"), // 9
          new BigDecimal("0.18"), // 10
          new BigDecimal("0.06"), // 11
          new BigDecimal("-0.11"), // 12
          new BigDecimal("0.12"), // 13
          new BigDecimal("0.08"), // 14
          new BigDecimal("0.08"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.22"), // 17
      },
      { // 8
          new BigDecimal("0.02"), // 1
          new BigDecimal("0.09"), // 2
          new BigDecimal("0.04"), // 3
          new BigDecimal("0.04"), // 4
          new BigDecimal("0.04"), // 5
          new BigDecimal("0.5"), // 6
          new BigDecimal("0.27"), // 7
          null, // 8 
          new BigDecimal("0.19"), // 9
          new BigDecimal("0"), // 10
          new BigDecimal("0.12"), // 11
          new BigDecimal("-0.03"), // 12
          new BigDecimal("0.09"), // 13
          new BigDecimal("0.05"), // 14
          new BigDecimal("0.07"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.14"), // 17
      },
      { // 9
          new BigDecimal("0.26"), // 1
          new BigDecimal("0.21"), // 2
          new BigDecimal("0.21"), // 3
          new BigDecimal("0.21"), // 4
          new BigDecimal("0.16"), // 5
          new BigDecimal("0.2"), // 6
          new BigDecimal("0.61"), // 7
          new BigDecimal("0.19"), // 8
          null, // 9 
          new BigDecimal("0.14"), // 10
          new BigDecimal("0.13"), // 11
          new BigDecimal("-0.07"), // 12
          new BigDecimal("0.07"), // 13
          new BigDecimal("0.06"), // 14
          new BigDecimal("0.12"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.19"), // 17
      },
      { // 10
          new BigDecimal("0.2"), // 1
          new BigDecimal("0.2"), // 2
          new BigDecimal("0.19"), // 3
          new BigDecimal("0.17"), // 4
          new BigDecimal("0.17"), // 5
          new BigDecimal("0.04"), // 6
          new BigDecimal("0.18"), // 7
          new BigDecimal("0"), // 8
          new BigDecimal("0.14"), // 9
          null, // 10 
          new BigDecimal("0.11"), // 11
          new BigDecimal("0.13"), // 12
          new BigDecimal("0.07"), // 13
          new BigDecimal("0.06"), // 14
          new BigDecimal("0.06"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.11"), // 17
      },
      { // 11
          new BigDecimal("0.17"), // 1
          new BigDecimal("0.4"), // 2
          new BigDecimal("0.33"), // 3
          new BigDecimal("0.36"), // 4
          new BigDecimal("0.4"), // 5
          new BigDecimal("0.17"), // 6
          new BigDecimal("0.06"), // 7
          new BigDecimal("0.12"), // 8
          new BigDecimal("0.13"), // 9
          new BigDecimal("0.11"), // 10
          null, // 11
          new BigDecimal("0.31"), // 12
          new BigDecimal("0.27"), // 13
          new BigDecimal("0.21"), // 14
          new BigDecimal("0.2"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.37"), // 17
      },
      { // 12
          new BigDecimal("0.15"), // 1
          new BigDecimal("0.3"), // 2
          new BigDecimal("0.23"), // 3
          new BigDecimal("0.25"), // 4
          new BigDecimal("0.33"), // 5
          new BigDecimal("0.08"), // 6
          new BigDecimal("-0.11"), // 7
          new BigDecimal("-0.03"), // 8
          new BigDecimal("-0.07"), // 9
          new BigDecimal("0.13"), // 10
          new BigDecimal("0.31"), // 11
          null, // 12
          new BigDecimal("0.15"), // 13
          new BigDecimal("0.19"), // 14
          new BigDecimal("0.1"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.23"), // 17
      },
      { // 13
          new BigDecimal("0.21"), // 1
          new BigDecimal("0.24"), // 2
          new BigDecimal("0.14"), // 3
          new BigDecimal("0.14"), // 4
          new BigDecimal("0.25"), // 5
          new BigDecimal("0.12"), // 6
          new BigDecimal("0.12"), // 7
          new BigDecimal("0.09"), // 8
          new BigDecimal("0.07"), // 9
          new BigDecimal("0.07"), // 10
          new BigDecimal("0.27"), // 11
          new BigDecimal("0.15"), // 12
          null, // 13
          new BigDecimal("0.28"), // 14
          new BigDecimal("0.2"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.27"), // 17
      },
      { // 14
          new BigDecimal("0.15"), // 1
          new BigDecimal("0.29"), // 2
          new BigDecimal("0.23"), // 3
          new BigDecimal("0.25"), // 4
          new BigDecimal("0.3"), // 5
          new BigDecimal("0.08"), // 6
          new BigDecimal("0.08"), // 7
          new BigDecimal("0.05"), // 8
          new BigDecimal("0.06"), // 9
          new BigDecimal("0.06"), // 10
          new BigDecimal("0.21"), // 11
          new BigDecimal("0.19"), // 12
          new BigDecimal("0.28"), // 13
          null, // 14
          new BigDecimal("0.15"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.25"), // 17
      },
      { // 15
          new BigDecimal("0.19"), // 1
          new BigDecimal("0.23"), // 2
          new BigDecimal("0.25"), // 3
          new BigDecimal("0.2"), // 4
          new BigDecimal("0.19"), // 5
          new BigDecimal("0.14"), // 6
          new BigDecimal("0.08"), // 7
          new BigDecimal("0.07"), // 8
          new BigDecimal("0.12"), // 9
          new BigDecimal("0.06"), // 10
          new BigDecimal("0.2"), // 11
          new BigDecimal("0.1"), // 12
          new BigDecimal("0.2"), // 13
          new BigDecimal("0.15"), // 14
          null, // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.23"), // 17
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
          null, // 16
          new BigDecimal("0"), // 17
      },
      { // 17
          new BigDecimal("0.24"), // 1
          new BigDecimal("0.56"), // 2
          new BigDecimal("0.5"), // 3
          new BigDecimal("0.53"), // 4
          new BigDecimal("0.53"), // 5
          new BigDecimal("0.25"), // 6
          new BigDecimal("0.22"), // 7
          new BigDecimal("0.14"), // 8
          new BigDecimal("0.19"), // 9
          new BigDecimal("0.11"), // 10
          new BigDecimal("0.37"), // 11
          new BigDecimal("0.23"), // 12
          new BigDecimal("0.27"), // 13
          new BigDecimal("0.25"), // 14
          new BigDecimal("0.23"), // 15
          new BigDecimal("0"), // 16
          null // 17
      } };

  private static final BigDecimal[] INTRA_BUCKET = {
      new BigDecimal("0.79"), // 1
      new BigDecimal("0.98"), // 2
      new BigDecimal("0.96"), // 3
      new BigDecimal("0.97"), // 4
      new BigDecimal("0.98"), // 5
      new BigDecimal("0.88"), // 6
      new BigDecimal("0.97"), // 7
      new BigDecimal("0.42"), // 8
      new BigDecimal("0.7"), // 9
      new BigDecimal("0.38"), // 10
      new BigDecimal("0.54"), // 11
      new BigDecimal("0.48"), // 12
      new BigDecimal("0.67"), // 13
      new BigDecimal("0.15"), // 14
      new BigDecimal("0.23"), // 15
      new BigDecimal("0"), // 16
      new BigDecimal("0.33"), // 17        
  };

  @Override
  public BigDecimal getSensitivityCorrelation(WeightingClass si, WeightingClass sk) {
    // NOTE: should both be in the same bucket -> intra bucket correlation
    int i = Integer.valueOf(si.getBucket());
    int k = Integer.valueOf(sk.getBucket());
    if (i == k)
      return INTRA_BUCKET[i - 1];
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
