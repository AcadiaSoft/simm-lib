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
public class EquityCorrelation implements SimmBucketCorrelation, SimmSensitivityCorrelation {

  public static final BigDecimal RESIDUAL = BigDecimal.ZERO;

  private static final BigDecimal[][] CORRELATIONS = {
      { // 1
          null, //
          new BigDecimal("0.17"), // 2
          new BigDecimal("0.18"), // 3
          new BigDecimal("0.19"), // 4
          new BigDecimal("0.12"), // 5
          new BigDecimal("0.14"), // 6
          new BigDecimal("0.15"), // 7
          new BigDecimal("0.15"), // 8
          new BigDecimal("0.15"), // 9
          new BigDecimal("0.12"), // 10
          new BigDecimal("0.18"), // 11
          new BigDecimal("0.18") // 12
      },
      { // 2
          new BigDecimal("0.17"), // 1
          null, //
          new BigDecimal("0.22"), // 3
          new BigDecimal("0.22"), // 4
          new BigDecimal("0.14"), // 5
          new BigDecimal("0.17"), // 6
          new BigDecimal("0.18"), // 7
          new BigDecimal("0.18"), // 8
          new BigDecimal("0.18"), // 9
          new BigDecimal("0.14"), // 10
          new BigDecimal("0.22"), // 11
          new BigDecimal("0.22") // 12
      },
      { // 3
          new BigDecimal("0.18"), // 1
          new BigDecimal("0.22"), // 2
          null, //
          new BigDecimal("0.24"), // 4
          new BigDecimal("0.14"), // 5
          new BigDecimal("0.20"), // 6
          new BigDecimal("0.23"), // 7
          new BigDecimal("0.20"), // 8
          new BigDecimal("0.19"), // 9
          new BigDecimal("0.16"), // 10
          new BigDecimal("0.25"), // 11
          new BigDecimal("0.25") // 12
      },
      { // 4
          new BigDecimal("0.19"), // 1
          new BigDecimal("0.22"), // 2
          new BigDecimal("0.24"), // 3
          null, //
          new BigDecimal("0.16"), // 5
          new BigDecimal("0.21"), // 6
          new BigDecimal("0.21"), // 7
          new BigDecimal("0.22"), // 8
          new BigDecimal("0.19"), // 9
          new BigDecimal("0.16"), // 10
          new BigDecimal("0.25"), // 11
          new BigDecimal("0.25") // 12
      },
      { // 5
          new BigDecimal("0.12"), // 1
          new BigDecimal("0.14"), // 2
          new BigDecimal("0.14"), // 3
          new BigDecimal("0.16"), // 4
          null, //
          new BigDecimal("0.23"), // 6
          new BigDecimal("0.21"), // 7
          new BigDecimal("0.24"), // 8
          new BigDecimal("0.13"), // 9
          new BigDecimal("0.17"), // 10
          new BigDecimal("0.26"), // 11
          new BigDecimal("0.26") // 12
      },
      { // 6
          new BigDecimal("0.14"), // 1
          new BigDecimal("0.17"), // 2
          new BigDecimal("0.20"), // 3
          new BigDecimal("0.21"), // 4
          new BigDecimal("0.23"), // 5
          null, //
          new BigDecimal("0.29"), // 7
          new BigDecimal("0.30"), // 8
          new BigDecimal("0.16"), // 9
          new BigDecimal("0.22"), // 10
          new BigDecimal("0.32"), // 11
          new BigDecimal("0.32") // 12
      },
      { // 7
          new BigDecimal("0.15"), // 1
          new BigDecimal("0.18"), // 2
          new BigDecimal("0.23"), // 3
          new BigDecimal("0.21"), // 4
          new BigDecimal("0.21"), // 5
          new BigDecimal("0.29"), // 6
          null, //
          new BigDecimal("0.29"), // 8
          new BigDecimal("0.16"), // 9
          new BigDecimal("0.22"), // 10
          new BigDecimal("0.33"), // 11
          new BigDecimal("0.33") // 12
      },
      { // 8
          new BigDecimal("0.15"), // 1
          new BigDecimal("0.18"), // 2
          new BigDecimal("0.20"), // 3
          new BigDecimal("0.22"), // 4
          new BigDecimal("0.24"), // 5
          new BigDecimal("0.30"), // 6
          new BigDecimal("0.29"), // 7
          null, //
          new BigDecimal("0.17"), // 9
          new BigDecimal("0.22"), // 10
          new BigDecimal("0.33"), // 11
          new BigDecimal("0.33") // 12
      },
      { // 9
          new BigDecimal("0.15"), // 1
          new BigDecimal("0.18"), // 2
          new BigDecimal("0.19"), // 3
          new BigDecimal("0.19"), // 4
          new BigDecimal("0.13"), // 5
          new BigDecimal("0.16"), // 6
          new BigDecimal("0.16"), // 7
          new BigDecimal("0.17"), // 8
          null, //
          new BigDecimal("0.13"), // 10
          new BigDecimal("0.20"), // 11
          new BigDecimal("0.20") // 12
      },
      { // 10
          new BigDecimal("0.12"), // 1
          new BigDecimal("0.14"), // 2
          new BigDecimal("0.16"), // 3
          new BigDecimal("0.16"), // 4
          new BigDecimal("0.17"), // 5
          new BigDecimal("0.22"), // 6
          new BigDecimal("0.22"), // 7
          new BigDecimal("0.22"), // 8
          new BigDecimal("0.13"), // 9
          null, //
          new BigDecimal("0.23"), // 11
          new BigDecimal("0.23") // 12
      },
      { // 11
          new BigDecimal("0.18"), // 1
          new BigDecimal("0.22"), // 2
          new BigDecimal("0.25"), // 3
          new BigDecimal("0.25"), // 4
          new BigDecimal("0.26"), // 5
          new BigDecimal("0.32"), // 6
          new BigDecimal("0.33"), // 7
          new BigDecimal("0.33"), // 8
          new BigDecimal("0.20"), // 9
          new BigDecimal("0.23"), // 10
          null, //
          new BigDecimal("0.40") // 12
      },
      { // 12
          new BigDecimal("0.18"), // 1
          new BigDecimal("0.22"), // 2
          new BigDecimal("0.25"), // 3
          new BigDecimal("0.25"), // 4
          new BigDecimal("0.26"), // 5
          new BigDecimal("0.32"), // 6
          new BigDecimal("0.33"), // 7
          new BigDecimal("0.33"), // 8
          new BigDecimal("0.20"), // 9
          new BigDecimal("0.23"), // 10
          new BigDecimal("0.40"), // 11
          null //
      }
  };

  private static final BigDecimal[] INTRA_BUCKET = {
      new BigDecimal("0.16"), // 1
      new BigDecimal("0.21"), // 2
      new BigDecimal("0.28"), // 3
      new BigDecimal("0.25"), // 4
      new BigDecimal("0.20"), // 5
      new BigDecimal("0.30"), // 6
      new BigDecimal("0.33"), // 7
      new BigDecimal("0.31"), // 8
      new BigDecimal("0.18"), // 9
      new BigDecimal("0.18"), // 10
      new BigDecimal("0.40"), // 11
      new BigDecimal("0.40"), // 12
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
