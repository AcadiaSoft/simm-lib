/*
 * Copyright (c) 2022 Acadia, Inc.
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
 * @author joe.peterson
 *
 */
public class CommodityCorrelation implements SimmBucketCorrelation, SimmSensitivityCorrelation {

  private static final BigDecimal[][] CORRELATIONS = {
      { // 1
          null, // 1
          new BigDecimal("0.33"), // 2
          new BigDecimal("0.21"), // 3
          new BigDecimal("0.27"), // 4
          new BigDecimal("0.29"), // 5
          new BigDecimal("0.21"), // 6
          new BigDecimal("0.48"), // 7
          new BigDecimal("0.16"), // 8
          new BigDecimal("0.41"), // 9
          new BigDecimal("0.23"), // 10
          new BigDecimal("0.18"), // 11
          new BigDecimal("0.02"), // 12
          new BigDecimal("0.21"), // 13
          new BigDecimal("0.19"), // 14
          new BigDecimal("0.15"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.24"), // 17
      },
      { // 2
          new BigDecimal("0.33"), // 1
          null, // 2
          new BigDecimal("0.94"), // 3
          new BigDecimal("0.94"), // 4
          new BigDecimal("0.89"), // 5
          new BigDecimal("0.21"), // 6
          new BigDecimal("0.19"), // 7
          new BigDecimal("0.13"), // 8
          new BigDecimal("0.21"), // 9
          new BigDecimal("0.21"), // 10
          new BigDecimal("0.41"), // 11
          new BigDecimal("0.27"), // 12
          new BigDecimal("0.31"), // 13
          new BigDecimal("0.29"), // 14
          new BigDecimal("0.21"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.6"), // 17
      },
      { // 3
          new BigDecimal("0.21"), // 1
          new BigDecimal("0.94"), // 2
          null, // 3
          new BigDecimal("0.91"), // 4
          new BigDecimal("0.85"), // 5
          new BigDecimal("0.12"), // 6
          new BigDecimal("0.2"), // 7
          new BigDecimal("0.09"), // 8
          new BigDecimal("0.19"), // 9
          new BigDecimal("0.2"), // 10
          new BigDecimal("0.36"), // 11
          new BigDecimal("0.18"), // 12
          new BigDecimal("0.22"), // 13
          new BigDecimal("0.23"), // 14
          new BigDecimal("0.23"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.54"), // 17
      },
      { // 4
          new BigDecimal("0.27"), // 1
          new BigDecimal("0.94"), // 2
          new BigDecimal("0.91"), // 3
          null, // 4
          new BigDecimal("0.84"), // 5
          new BigDecimal("0.14"), // 6
          new BigDecimal("0.24"), // 7
          new BigDecimal("0.13"), // 8
          new BigDecimal("0.21"), // 9
          new BigDecimal("0.19"), // 10
          new BigDecimal("0.39"), // 11
          new BigDecimal("0.25"), // 12
          new BigDecimal("0.23"), // 13
          new BigDecimal("0.27"), // 14
          new BigDecimal("0.18"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.59"), // 17
      },
      { // 5
          new BigDecimal("0.29"), // 1
          new BigDecimal("0.89"), // 2
          new BigDecimal("0.85"), // 3
          new BigDecimal("0.84"), // 4
          null, // 5
          new BigDecimal("0.15"), // 6
          new BigDecimal("0.17"), // 7
          new BigDecimal("0.09"), // 8
          new BigDecimal("0.16"), // 9
          new BigDecimal("0.21"), // 10
          new BigDecimal("0.38"), // 11
          new BigDecimal("0.28"), // 12
          new BigDecimal("0.28"), // 13
          new BigDecimal("0.27"), // 14
          new BigDecimal("0.18"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.55"), // 17
      },
      { // 6
          new BigDecimal("0.21"), // 1
          new BigDecimal("0.21"), // 2
          new BigDecimal("0.12"), // 3
          new BigDecimal("0.14"), // 4
          new BigDecimal("0.15"), // 5
          null, // 6
          new BigDecimal("0.33"), // 7
          new BigDecimal("0.53"), // 8
          new BigDecimal("0.26"), // 9
          new BigDecimal("0.09"), // 10
          new BigDecimal("0.21"), // 11
          new BigDecimal("0.04"), // 12
          new BigDecimal("0.11"), // 13
          new BigDecimal("0.1"), // 14
          new BigDecimal("0.09"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.24"), // 17
      },
      { // 7
          new BigDecimal("0.48"), // 1
          new BigDecimal("0.19"), // 2
          new BigDecimal("0.2"), // 3
          new BigDecimal("0.24"), // 4
          new BigDecimal("0.17"), // 5
          new BigDecimal("0.33"), // 6
          null, // 7
          new BigDecimal("0.31"), // 8
          new BigDecimal("0.72"), // 9
          new BigDecimal("0.24"), // 10
          new BigDecimal("0.14"), // 11
          new BigDecimal("-0.12"), // 12
          new BigDecimal("0.19"), // 13
          new BigDecimal("0.14"), // 14
          new BigDecimal("0.08"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.24"), // 17
      },
      { // 8
          new BigDecimal("0.16"), // 1
          new BigDecimal("0.13"), // 2
          new BigDecimal("0.09"), // 3
          new BigDecimal("0.13"), // 4
          new BigDecimal("0.09"), // 5
          new BigDecimal("0.53"), // 6
          new BigDecimal("0.31"), // 7
          null, // 8
          new BigDecimal("0.24"), // 9
          new BigDecimal("0.04"), // 10
          new BigDecimal("0.13"), // 11
          new BigDecimal("-0.07"), // 12
          new BigDecimal("0.04"), // 13
          new BigDecimal("0.06"), // 14
          new BigDecimal("0.01"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.16"), // 17
      },
      { // 9
          new BigDecimal("0.41"), // 1
          new BigDecimal("0.21"), // 2
          new BigDecimal("0.19"), // 3
          new BigDecimal("0.21"), // 4
          new BigDecimal("0.16"), // 5
          new BigDecimal("0.26"), // 6
          new BigDecimal("0.72"), // 7
          new BigDecimal("0.24"), // 8
          null, // 9
          new BigDecimal("0.21"), // 10
          new BigDecimal("0.18"), // 11
          new BigDecimal("-0.07"), // 12
          new BigDecimal("0.12"), // 13
          new BigDecimal("0.12"), // 14
          new BigDecimal("0.1"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.21"), // 17
      },
      { // 10
          new BigDecimal("0.23"), // 1
          new BigDecimal("0.21"), // 2
          new BigDecimal("0.2"), // 3
          new BigDecimal("0.19"), // 4
          new BigDecimal("0.21"), // 5
          new BigDecimal("0.09"), // 6
          new BigDecimal("0.24"), // 7
          new BigDecimal("0.04"), // 8
          new BigDecimal("0.21"), // 9
          null, // 10
          new BigDecimal("0.14"), // 11
          new BigDecimal("0.11"), // 12
          new BigDecimal("0.11"), // 13
          new BigDecimal("0.1"), // 14
          new BigDecimal("0.07"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.14"), // 17
      },
      { // 11
          new BigDecimal("0.18"), // 1
          new BigDecimal("0.41"), // 2
          new BigDecimal("0.36"), // 3
          new BigDecimal("0.39"), // 4
          new BigDecimal("0.38"), // 5
          new BigDecimal("0.21"), // 6
          new BigDecimal("0.14"), // 7
          new BigDecimal("0.13"), // 8
          new BigDecimal("0.18"), // 9
          new BigDecimal("0.14"), // 10
          null, // 11
          new BigDecimal("0.28"), // 12
          new BigDecimal("0.3"), // 13
          new BigDecimal("0.25"), // 14
          new BigDecimal("0.18"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.38"), // 17
      },
      { // 12
          new BigDecimal("0.02"), // 1
          new BigDecimal("0.27"), // 2
          new BigDecimal("0.18"), // 3
          new BigDecimal("0.25"), // 4
          new BigDecimal("0.28"), // 5
          new BigDecimal("0.04"), // 6
          new BigDecimal("-0.12"), // 7
          new BigDecimal("-0.07"), // 8
          new BigDecimal("-0.07"), // 9
          new BigDecimal("0.11"), // 10
          new BigDecimal("0.28"), // 11
          null, // 12
          new BigDecimal("0.18"), // 13
          new BigDecimal("0.18"), // 14
          new BigDecimal("0.08"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.21"), // 17
      },
      { // 13
          new BigDecimal("0.21"), // 1
          new BigDecimal("0.31"), // 2
          new BigDecimal("0.22"), // 3
          new BigDecimal("0.23"), // 4
          new BigDecimal("0.28"), // 5
          new BigDecimal("0.11"), // 6
          new BigDecimal("0.19"), // 7
          new BigDecimal("0.04"), // 8
          new BigDecimal("0.12"), // 9
          new BigDecimal("0.11"), // 10
          new BigDecimal("0.3"), // 11
          new BigDecimal("0.18"), // 12
          null, // 13
          new BigDecimal("0.34"), // 14
          new BigDecimal("0.16"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.34"), // 17
      },
      { // 14
          new BigDecimal("0.19"), // 1
          new BigDecimal("0.29"), // 2
          new BigDecimal("0.23"), // 3
          new BigDecimal("0.27"), // 4
          new BigDecimal("0.27"), // 5
          new BigDecimal("0.1"), // 6
          new BigDecimal("0.14"), // 7
          new BigDecimal("0.06"), // 8
          new BigDecimal("0.12"), // 9
          new BigDecimal("0.1"), // 10
          new BigDecimal("0.25"), // 11
          new BigDecimal("0.18"), // 12
          new BigDecimal("0.34"), // 13
          null, // 14
          new BigDecimal("0.13"), // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.26"), // 17
      },
      { // 15
          new BigDecimal("0.15"), // 1
          new BigDecimal("0.21"), // 2
          new BigDecimal("0.23"), // 3
          new BigDecimal("0.18"), // 4
          new BigDecimal("0.18"), // 5
          new BigDecimal("0.09"), // 6
          new BigDecimal("0.08"), // 7
          new BigDecimal("0.01"), // 8
          new BigDecimal("0.1"), // 9
          new BigDecimal("0.07"), // 10
          new BigDecimal("0.18"), // 11
          new BigDecimal("0.08"), // 12
          new BigDecimal("0.16"), // 13
          new BigDecimal("0.13"), // 14
          null, // 15
          new BigDecimal("0"), // 16
          new BigDecimal("0.21"), // 17
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
          new BigDecimal("0.6"), // 2
          new BigDecimal("0.54"), // 3
          new BigDecimal("0.59"), // 4
          new BigDecimal("0.55"), // 5
          new BigDecimal("0.24"), // 6
          new BigDecimal("0.24"), // 7
          new BigDecimal("0.16"), // 8
          new BigDecimal("0.21"), // 9
          new BigDecimal("0.14"), // 10
          new BigDecimal("0.38"), // 11
          new BigDecimal("0.21"), // 12
          new BigDecimal("0.34"), // 13
          new BigDecimal("0.26"), // 14
          new BigDecimal("0.21"), // 15
          new BigDecimal("0"), // 16
          null, // 17
      } };

  private static final BigDecimal[] INTRA_BUCKET = {
      new BigDecimal("0.84"), // 1
      new BigDecimal("0.98"), // 2
      new BigDecimal("0.96"), // 3
      new BigDecimal("0.97"), // 4
      new BigDecimal("0.98"), // 5
      new BigDecimal("0.88"), // 6
      new BigDecimal("0.98"), // 7
      new BigDecimal("0.49"), // 8
      new BigDecimal("0.8"), // 9
      new BigDecimal("0.46"), // 10
      new BigDecimal("0.55"), // 11
      new BigDecimal("0.46"), // 12
      new BigDecimal("0.66"), // 13
      new BigDecimal("0.18"), // 14
      new BigDecimal("0.21"), // 15
      new BigDecimal("0"), // 16
      new BigDecimal("0.36"), // 17
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
