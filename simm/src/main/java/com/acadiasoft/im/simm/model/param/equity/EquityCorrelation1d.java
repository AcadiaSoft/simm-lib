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

package com.acadiasoft.im.simm.model.param.equity;

import com.acadiasoft.im.simm.model.DefaultSensitivity;
import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.BucketType;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmBucketCorrelation;
import com.acadiasoft.im.simm.model.param.SimmSensitivityCorrelation;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @author joe.peterson
 *
 */
public class EquityCorrelation1d implements SimmBucketCorrelation, SimmSensitivityCorrelation {

  public static final BigDecimal RESIDUAL = new BigDecimal("0");

  private static final BigDecimal[][] CORRELATIONS = {
      { // 1
          null, // 1
          new BigDecimal("0.2"), // 2
          new BigDecimal("0.2"), // 3
          new BigDecimal("0.2"), // 4
          new BigDecimal("0.13"), // 5
          new BigDecimal("0.16"), // 6
          new BigDecimal("0.16"), // 7
          new BigDecimal("0.16"), // 8
          new BigDecimal("0.17"), // 9
          new BigDecimal("0.12"), // 10
          new BigDecimal("0.18"), // 11
          new BigDecimal("0.18"), // 12
      },
      { // 2
          new BigDecimal("0.2"), // 1
          null, // 2
          new BigDecimal("0.25"), // 3
          new BigDecimal("0.23"), // 4
          new BigDecimal("0.14"), // 5
          new BigDecimal("0.17"), // 6
          new BigDecimal("0.18"), // 7
          new BigDecimal("0.17"), // 8
          new BigDecimal("0.19"), // 9
          new BigDecimal("0.13"), // 10
          new BigDecimal("0.19"), // 11
          new BigDecimal("0.19"), // 12
      },
      { // 3
          new BigDecimal("0.2"), // 1
          new BigDecimal("0.25"), // 2
          null, // 3
          new BigDecimal("0.24"), // 4
          new BigDecimal("0.13"), // 5
          new BigDecimal("0.17"), // 6
          new BigDecimal("0.18"), // 7
          new BigDecimal("0.16"), // 8
          new BigDecimal("0.2"), // 9
          new BigDecimal("0.13"), // 10
          new BigDecimal("0.18"), // 11
          new BigDecimal("0.18"), // 12
      },
      { // 4
          new BigDecimal("0.2"), // 1
          new BigDecimal("0.23"), // 2
          new BigDecimal("0.24"), // 3
          null, // 4
          new BigDecimal("0.17"), // 5
          new BigDecimal("0.22"), // 6
          new BigDecimal("0.22"), // 7
          new BigDecimal("0.22"), // 8
          new BigDecimal("0.21"), // 9
          new BigDecimal("0.16"), // 10
          new BigDecimal("0.24"), // 11
          new BigDecimal("0.24"), // 12
      },
      { // 5
          new BigDecimal("0.13"), // 1
          new BigDecimal("0.14"), // 2
          new BigDecimal("0.13"), // 3
          new BigDecimal("0.17"), // 4
          null, // 5
          new BigDecimal("0.27"), // 6
          new BigDecimal("0.26"), // 7
          new BigDecimal("0.27"), // 8
          new BigDecimal("0.15"), // 9
          new BigDecimal("0.2"), // 10
          new BigDecimal("0.3"), // 11
          new BigDecimal("0.3"), // 12
      },
      { // 6
          new BigDecimal("0.16"), // 1
          new BigDecimal("0.17"), // 2
          new BigDecimal("0.17"), // 3
          new BigDecimal("0.22"), // 4
          new BigDecimal("0.27"), // 5
          null, // 6
          new BigDecimal("0.34"), // 7
          new BigDecimal("0.33"), // 8
          new BigDecimal("0.18"), // 9
          new BigDecimal("0.24"), // 10
          new BigDecimal("0.38"), // 11
          new BigDecimal("0.38"), // 12
      },
      { // 7
          new BigDecimal("0.16"), // 1
          new BigDecimal("0.18"), // 2
          new BigDecimal("0.18"), // 3
          new BigDecimal("0.22"), // 4
          new BigDecimal("0.26"), // 5
          new BigDecimal("0.34"), // 6
          null, // 7
          new BigDecimal("0.32"), // 8
          new BigDecimal("0.18"), // 9
          new BigDecimal("0.24"), // 10
          new BigDecimal("0.37"), // 11
          new BigDecimal("0.37"), // 12
      },
      { // 8
          new BigDecimal("0.16"), // 1
          new BigDecimal("0.17"), // 2
          new BigDecimal("0.16"), // 3
          new BigDecimal("0.22"), // 4
          new BigDecimal("0.27"), // 5
          new BigDecimal("0.33"), // 6
          new BigDecimal("0.32"), // 7
          null, // 8
          new BigDecimal("0.18"), // 9
          new BigDecimal("0.23"), // 10
          new BigDecimal("0.37"), // 11
          new BigDecimal("0.37"), // 12
      },
      { // 9
          new BigDecimal("0.17"), // 1
          new BigDecimal("0.19"), // 2
          new BigDecimal("0.2"), // 3
          new BigDecimal("0.21"), // 4
          new BigDecimal("0.15"), // 5
          new BigDecimal("0.18"), // 6
          new BigDecimal("0.18"), // 7
          new BigDecimal("0.18"), // 8
          null, // 9
          new BigDecimal("0.14"), // 10
          new BigDecimal("0.2"), // 11
          new BigDecimal("0.2"), // 12
      },
      { // 10
          new BigDecimal("0.12"), // 1
          new BigDecimal("0.13"), // 2
          new BigDecimal("0.13"), // 3
          new BigDecimal("0.16"), // 4
          new BigDecimal("0.2"), // 5
          new BigDecimal("0.24"), // 6
          new BigDecimal("0.24"), // 7
          new BigDecimal("0.23"), // 8
          new BigDecimal("0.14"), // 9
          null, // 10
          new BigDecimal("0.25"), // 11
          new BigDecimal("0.25"), // 12
      },
      { // 11
          new BigDecimal("0.18"), // 1
          new BigDecimal("0.19"), // 2
          new BigDecimal("0.18"), // 3
          new BigDecimal("0.24"), // 4
          new BigDecimal("0.3"), // 5
          new BigDecimal("0.38"), // 6
          new BigDecimal("0.37"), // 7
          new BigDecimal("0.37"), // 8
          new BigDecimal("0.2"), // 9
          new BigDecimal("0.25"), // 10
          null, // 11
          new BigDecimal("0.45"), // 12
      },
      { // 12
          new BigDecimal("0.18"), // 1
          new BigDecimal("0.19"), // 2
          new BigDecimal("0.18"), // 3
          new BigDecimal("0.24"), // 4
          new BigDecimal("0.3"), // 5
          new BigDecimal("0.38"), // 6
          new BigDecimal("0.37"), // 7
          new BigDecimal("0.37"), // 8
          new BigDecimal("0.2"), // 9
          new BigDecimal("0.25"), // 10
          new BigDecimal("0.45"), // 11
          null, // 12
      } };

  private static final BigDecimal[] INTRA_BUCKET = {
      new BigDecimal("0.18"), // 1
      new BigDecimal("0.23"), // 2
      new BigDecimal("0.3"), // 3
      new BigDecimal("0.26"), // 4
      new BigDecimal("0.23"), // 5
      new BigDecimal("0.35"), // 6
      new BigDecimal("0.36"), // 7
      new BigDecimal("0.33"), // 8
      new BigDecimal("0.19"), // 9
      new BigDecimal("0.2"), // 10
      new BigDecimal("0.45"), // 11
      new BigDecimal("0.45"), // 12
  };

  @Override
  public BigDecimal getSensitivityCorrelation(WeightingClass si, WeightingClass sk) {
    if (StringUtils.equalsIgnoreCase(DefaultSensitivity.RESIDUAL, si.getBucket()) || StringUtils.equalsIgnoreCase(DefaultSensitivity.RESIDUAL, sk.getBucket())) {
      return RESIDUAL;
    } else {
      // NOTE: both sensitivities should be in the same bucket, so bi and bk should be equal
      int i = Integer.valueOf(si.getBucket());
      int k = Integer.valueOf(sk.getBucket());
      if (i == k)
        return INTRA_BUCKET[i - 1];
      throw new RuntimeException("Called for a sensitivity correlation with two sensitivities from different buckets: [" + i + " and " + k + "]");
    }
  }

  @Override
  public BigDecimal getBucketCorrelation(BucketClass bi, BucketClass bk) {
    if (BucketType.isResidualBucket(bi.getBucketType()) || BucketType.isResidualBucket(bk.getBucketType())) {
      // NOTE: Residual bucket isn't correlated with any other bucket, and so we should never get here
      throw new RuntimeException("Called bucket correlation for Residual bucket: " + bi + ", " + bk);
    } else {
      int i = bi.getBucketType().getBucketNumber();
      int k = bk.getBucketType().getBucketNumber();
      return CORRELATIONS[i - 1][k - 1];
    }
  }
}
