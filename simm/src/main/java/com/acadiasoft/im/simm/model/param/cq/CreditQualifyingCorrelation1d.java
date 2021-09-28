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

package com.acadiasoft.im.simm.model.param.cq;

import com.acadiasoft.im.simm.model.DefaultSensitivity;
import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.BucketType;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmBucketCorrelation;
import com.acadiasoft.im.simm.model.param.SimmSensitivityCorrelation;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class CreditQualifyingCorrelation1d implements SimmBucketCorrelation, SimmSensitivityCorrelation {

  public static final BigDecimal AGGREGATE_SAME = new BigDecimal("0.92");
  public static final BigDecimal AGGREGATE_DIFF = new BigDecimal("0.41");
  public static final BigDecimal RESIDUAL = new BigDecimal("0.5");

  private static final BigDecimal[][] CORRELATIONS = {
      { // 1
          null, // 1
          new BigDecimal("0.35"), // 2
          new BigDecimal("0.37"), // 3
          new BigDecimal("0.35"), // 4
          new BigDecimal("0.37"), // 5
          new BigDecimal("0.34"), // 6
          new BigDecimal("0.38"), // 7
          new BigDecimal("0.31"), // 8
          new BigDecimal("0.34"), // 9
          new BigDecimal("0.33"), // 10
          new BigDecimal("0.3"), // 11
          new BigDecimal("0.31"), // 12
      },
      { // 2
          new BigDecimal("0.35"), // 1
          null, // 2
          new BigDecimal("0.44"), // 3
          new BigDecimal("0.43"), // 4
          new BigDecimal("0.45"), // 5
          new BigDecimal("0.42"), // 6
          new BigDecimal("0.32"), // 7
          new BigDecimal("0.34"), // 8
          new BigDecimal("0.38"), // 9
          new BigDecimal("0.38"), // 10
          new BigDecimal("0.35"), // 11
          new BigDecimal("0.35"), // 12
      },
      { // 3
          new BigDecimal("0.37"), // 1
          new BigDecimal("0.44"), // 2
          null, // 3
          new BigDecimal("0.48"), // 4
          new BigDecimal("0.49"), // 5
          new BigDecimal("0.47"), // 6
          new BigDecimal("0.34"), // 7
          new BigDecimal("0.35"), // 8
          new BigDecimal("0.42"), // 9
          new BigDecimal("0.42"), // 10
          new BigDecimal("0.4"), // 11
          new BigDecimal("0.39"), // 12
      },
      { // 4
          new BigDecimal("0.35"), // 1
          new BigDecimal("0.43"), // 2
          new BigDecimal("0.48"), // 3
          null, // 4
          new BigDecimal("0.48"), // 5
          new BigDecimal("0.48"), // 6
          new BigDecimal("0.32"), // 7
          new BigDecimal("0.34"), // 8
          new BigDecimal("0.4"), // 9
          new BigDecimal("0.41"), // 10
          new BigDecimal("0.39"), // 11
          new BigDecimal("0.37"), // 12                 
      },
      { // 5
          new BigDecimal("0.37"), // 1
          new BigDecimal("0.45"), // 2
          new BigDecimal("0.49"), // 3
          new BigDecimal("0.48"), // 4
          null, // 5
          new BigDecimal("0.48"), // 6
          new BigDecimal("0.34"), // 7
          new BigDecimal("0.35"), // 8
          new BigDecimal("0.41"), // 9
          new BigDecimal("0.41"), // 10
          new BigDecimal("0.4"), // 11
          new BigDecimal("0.39"), // 12
      },
      { // 6
          new BigDecimal("0.34"), // 1
          new BigDecimal("0.42"), // 2
          new BigDecimal("0.47"), // 3
          new BigDecimal("0.48"), // 4
          new BigDecimal("0.48"), // 5
          null, // 6
          new BigDecimal("0.31"), // 7
          new BigDecimal("0.33"), // 8
          new BigDecimal("0.37"), // 9
          new BigDecimal("0.38"), // 10
          new BigDecimal("0.38"), // 11
          new BigDecimal("0.36"), // 12
      },
      { // 7
          new BigDecimal("0.38"), // 1
          new BigDecimal("0.32"), // 2
          new BigDecimal("0.34"), // 3
          new BigDecimal("0.32"), // 4
          new BigDecimal("0.34"), // 5
          new BigDecimal("0.31"), // 6
          null, // 7
          new BigDecimal("0.28"), // 8
          new BigDecimal("0.32"), // 9
          new BigDecimal("0.3"), // 10
          new BigDecimal("0.27"), // 11
          new BigDecimal("0.28"), // 12
      },
      { // 8
          new BigDecimal("0.31"), // 1
          new BigDecimal("0.34"), // 2
          new BigDecimal("0.35"), // 3
          new BigDecimal("0.34"), // 4
          new BigDecimal("0.35"), // 5
          new BigDecimal("0.33"), // 6
          new BigDecimal("0.28"), // 7
          null, // 8
          new BigDecimal("0.32"), // 9
          new BigDecimal("0.32"), // 10
          new BigDecimal("0.29"), // 11
          new BigDecimal("0.29"), // 12
      },
      { // 9
          new BigDecimal("0.34"), // 1
          new BigDecimal("0.38"), // 2
          new BigDecimal("0.42"), // 3
          new BigDecimal("0.4"), // 4
          new BigDecimal("0.41"), // 5
          new BigDecimal("0.37"), // 6
          new BigDecimal("0.32"), // 7
          new BigDecimal("0.32"), // 8
          null, // 9
          new BigDecimal("0.38"), // 10
          new BigDecimal("0.35"), // 11
          new BigDecimal("0.35"), // 12
      },
      { // 10
          new BigDecimal("0.33"), // 1
          new BigDecimal("0.38"), // 2
          new BigDecimal("0.42"), // 3
          new BigDecimal("0.41"), // 4
          new BigDecimal("0.41"), // 5
          new BigDecimal("0.38"), // 6
          new BigDecimal("0.3"), // 7
          new BigDecimal("0.32"), // 8
          new BigDecimal("0.38"), // 9
          null, // 10
          new BigDecimal("0.35"), // 11
          new BigDecimal("0.34"), // 12
      },
      { // 11
          new BigDecimal("0.3"), // 1
          new BigDecimal("0.35"), // 2
          new BigDecimal("0.4"), // 3
          new BigDecimal("0.39"), // 4
          new BigDecimal("0.4"), // 5
          new BigDecimal("0.38"), // 6
          new BigDecimal("0.27"), // 7
          new BigDecimal("0.29"), // 8
          new BigDecimal("0.35"), // 9
          new BigDecimal("0.35"), // 10
          null, // 11
          new BigDecimal("0.33"), // 12
      },
      { // 12
          new BigDecimal("0.31"), // 1
          new BigDecimal("0.35"), // 2
          new BigDecimal("0.39"), // 3
          new BigDecimal("0.37"), // 4
          new BigDecimal("0.39"), // 5
          new BigDecimal("0.36"), // 6
          new BigDecimal("0.28"), // 7
          new BigDecimal("0.29"), // 8
          new BigDecimal("0.35"), // 9
          new BigDecimal("0.34"), // 10
          new BigDecimal("0.33"), // 11
          null // 12
      } };

  @Override
  public BigDecimal getSensitivityCorrelation(WeightingClass si, WeightingClass sk) {
    if (StringUtils.equalsIgnoreCase(DefaultSensitivity.RESIDUAL, si.getBucket()) || StringUtils.equalsIgnoreCase(DefaultSensitivity.RESIDUAL, sk.getBucket())) {
      return RESIDUAL;
    } else if (StringUtils.equals(si.getQualifier(), sk.getQualifier())) {
      return AGGREGATE_SAME;
    } else {
      return AGGREGATE_DIFF;
    }
  }

  @Override
  public BigDecimal getBucketCorrelation(BucketClass bi, BucketClass bk) {
    if (BucketType.isResidualBucket(bi.getBucketType()) || BucketType.isResidualBucket(bk.getBucketType())) {
      throw new RuntimeException("called bucket correlation for a residual bucket: " + bi + ", " + bk);
    } else {
      int i = bi.getBucketType().getBucketNumber();
      int k = bk.getBucketType().getBucketNumber();
      return CORRELATIONS[i - 1][k - 1];
    }
  }
}
