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

package com.acadiasoft.im.simm.model.param.equity;

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.BucketType;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.param.SimmBucketCorrelation;
import com.acadiasoft.im.simm.model.param.SimmSensitivityCorrelation;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * As defined in Appendix 1 of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class EquityCorrelationV2_1 implements SimmBucketCorrelation, SimmSensitivityCorrelation {

  public static final BigDecimal RESIDUAL = BigDecimal.ZERO;

  private static final BigDecimal[][] CORRELATIONS = {
      { // 1
          null, //
          new BigDecimal("0.16"), // 2
          new BigDecimal("0.16"), // 3
          new BigDecimal("0.17"), // 4
          new BigDecimal("0.13"), // 5
          new BigDecimal("0.15"), // 6
          new BigDecimal("0.15"), // 7
          new BigDecimal("0.15"), // 8
          new BigDecimal("0.13"), // 9
          new BigDecimal("0.11"), // 10
          new BigDecimal("0.19"), // 11
          new BigDecimal("0.19") // 12
      },
      { // 2
          new BigDecimal("0.16"), // 1
          null, //
          new BigDecimal("0.2"), // 3
          new BigDecimal("0.2"), // 4
          new BigDecimal("0.14"), // 5
          new BigDecimal("0.16"), // 6
          new BigDecimal("0.16"), // 7
          new BigDecimal("0.16"), // 8
          new BigDecimal("0.15"), // 9
          new BigDecimal("0.13"), // 10
          new BigDecimal("0.2"), // 11
          new BigDecimal("0.2") // 12
      },
      { // 3
          new BigDecimal("0.16"), // 1
          new BigDecimal("0.2"), // 2
          null, //
          new BigDecimal("0.22"), // 4
          new BigDecimal("0.15"), // 5
          new BigDecimal("0.19"), // 6
          new BigDecimal("0.22"), // 7
          new BigDecimal("0.19"), // 8
          new BigDecimal("0.16"), // 9
          new BigDecimal("0.15"), // 10
          new BigDecimal("0.25"), // 11
          new BigDecimal("0.25") // 12
      },
      { // 4
          new BigDecimal("0.17"), // 1
          new BigDecimal("0.2"), // 2
          new BigDecimal("0.22"), // 3
          null, //
          new BigDecimal("0.17"), // 5
          new BigDecimal("0.21"), // 6
          new BigDecimal("0.21"), // 7
          new BigDecimal("0.21"), // 8
          new BigDecimal("0.17"), // 9
          new BigDecimal("0.15"), // 10
          new BigDecimal("0.27"), // 11
          new BigDecimal("0.27") // 12
      },
      { // 5
          new BigDecimal("0.13"), // 1
          new BigDecimal("0.14"), // 2
          new BigDecimal("0.15"), // 3
          new BigDecimal("0.17"), // 4
          null, //
          new BigDecimal("0.25"), // 6
          new BigDecimal("0.23"), // 7
          new BigDecimal("0.26"), // 8
          new BigDecimal("0.14"), // 9
          new BigDecimal("0.17"), // 10
          new BigDecimal("0.32"), // 11
          new BigDecimal("0.32") // 12
      },
      { // 6
          new BigDecimal("0.15"), // 1
          new BigDecimal("0.16"), // 2
          new BigDecimal("0.19"), // 3
          new BigDecimal("0.21"), // 4
          new BigDecimal("0.25"), // 5
          null, //
          new BigDecimal("0.3"), // 7
          new BigDecimal("0.31"), // 8
          new BigDecimal("0.16"), // 9
          new BigDecimal("0.21"), // 10
          new BigDecimal("0.38"), // 11
          new BigDecimal("0.38") // 12
      },
      { // 7
          new BigDecimal("0.15"), // 1
          new BigDecimal("0.16"), // 2
          new BigDecimal("0.22"), // 3
          new BigDecimal("0.21"), // 4
          new BigDecimal("0.23"), // 5
          new BigDecimal("0.3"), // 6
          null, //
          new BigDecimal("0.29"), // 8
          new BigDecimal("0.16"), // 9
          new BigDecimal("0.21"), // 10
          new BigDecimal("0.38"), // 11
          new BigDecimal("0.38") // 12
      },
      { // 8
          new BigDecimal("0.15"), // 1
          new BigDecimal("0.16"), // 2
          new BigDecimal("0.19"), // 3
          new BigDecimal("0.21"), // 4
          new BigDecimal("0.26"), // 5
          new BigDecimal("0.31"), // 6
          new BigDecimal("0.29"), // 7
          null, //
          new BigDecimal("0.17"), // 9
          new BigDecimal("0.21"), // 10
          new BigDecimal("0.39"), // 11
          new BigDecimal("0.39") // 12
      },
      { // 9
          new BigDecimal("0.13"), // 1
          new BigDecimal("0.15"), // 2
          new BigDecimal("0.16"), // 3
          new BigDecimal("0.17"), // 4
          new BigDecimal("0.14"), // 5
          new BigDecimal("0.16"), // 6
          new BigDecimal("0.16"), // 7
          new BigDecimal("0.17"), // 8
          null, //
          new BigDecimal("0.13"), // 10
          new BigDecimal("0.21"), // 11
          new BigDecimal("0.21") // 12
      },
      { // 10
          new BigDecimal("0.11"), // 1
          new BigDecimal("0.13"), // 2
          new BigDecimal("0.15"), // 3
          new BigDecimal("0.15"), // 4
          new BigDecimal("0.17"), // 5
          new BigDecimal("0.21"), // 6
          new BigDecimal("0.21"), // 7
          new BigDecimal("0.21"), // 8
          new BigDecimal("0.13"), // 9
          null, //
          new BigDecimal("0.25"), // 11
          new BigDecimal("0.25") // 12
      },
      { // 11
          new BigDecimal("0.19"), // 1
          new BigDecimal("0.2"), // 2
          new BigDecimal("0.25"), // 3
          new BigDecimal("0.27"), // 4
          new BigDecimal("0.32"), // 5
          new BigDecimal("0.38"), // 6
          new BigDecimal("0.38"), // 7
          new BigDecimal("0.39"), // 8
          new BigDecimal("0.21"), // 9
          new BigDecimal("0.25"), // 10
          null, //
          new BigDecimal("0.51") // 12
      },
      { // 12
          new BigDecimal("0.19"), // 1
          new BigDecimal("0.2"), // 2
          new BigDecimal("0.25"), // 3
          new BigDecimal("0.27"), // 4
          new BigDecimal("0.32"), // 5
          new BigDecimal("0.38"), // 6
          new BigDecimal("0.38"), // 7
          new BigDecimal("0.39"), // 8
          new BigDecimal("0.21"), // 9
          new BigDecimal("0.25"), // 10
          new BigDecimal("0.51"), // 11
          null //
      }
  };

  private static final BigDecimal[] INTRA_BUCKET = {
      new BigDecimal("0.14"), // 1
      new BigDecimal("0.2"), // 2
      new BigDecimal("0.25"), // 3
      new BigDecimal("0.23"), // 4
      new BigDecimal("0.23"), // 5
      new BigDecimal("0.32"), // 6
      new BigDecimal("0.35"), // 7
      new BigDecimal("0.32"), // 8
      new BigDecimal("0.17"), // 9
      new BigDecimal("0.16"), // 10
      new BigDecimal("0.51"), // 11
      new BigDecimal("0.51"), // 12
  };

  @Override
  public BigDecimal getSensitivityCorrelation(WeightingClass si, WeightingClass sk) {
    if (StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, si.getBucket()) || StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, sk.getBucket())) {
      return RESIDUAL;
    } else {
      // NOTE: both sensitivities should be in the same bucket, so bi and bk should be equal
      int i = Integer.valueOf(si.getBucket());
      int k = Integer.valueOf(sk.getBucket());
      if (i == k) return INTRA_BUCKET[i - 1];
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
