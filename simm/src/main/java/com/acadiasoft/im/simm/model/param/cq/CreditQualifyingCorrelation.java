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
 * @author joe.peterson
 *
 */
public class CreditQualifyingCorrelation implements SimmBucketCorrelation, SimmSensitivityCorrelation {

  public static final BigDecimal AGGREGATE_SAME = new BigDecimal("0.93");
  public static final BigDecimal AGGREGATE_DIFF = new BigDecimal("0.42");
  public static final BigDecimal RESIDUAL = new BigDecimal("0.5");

  private static final BigDecimal[][] CORRELATIONS = {
      { // 1
          null, // 1
          new BigDecimal("0.36"), // 2
          new BigDecimal("0.38"), // 3
          new BigDecimal("0.35"), // 4
          new BigDecimal("0.37"), // 5
          new BigDecimal("0.33"), // 6
          new BigDecimal("0.36"), // 7
          new BigDecimal("0.31"), // 8
          new BigDecimal("0.32"), // 9
          new BigDecimal("0.33"), // 10
          new BigDecimal("0.32"), // 11
          new BigDecimal("0.3"), // 12
      },
      { // 2
          new BigDecimal("0.36"), // 1
          null, // 2
          new BigDecimal("0.46"), // 3
          new BigDecimal("0.44"), // 4
          new BigDecimal("0.45"), // 5
          new BigDecimal("0.43"), // 6
          new BigDecimal("0.33"), // 7
          new BigDecimal("0.36"), // 8
          new BigDecimal("0.38"), // 9
          new BigDecimal("0.39"), // 10
          new BigDecimal("0.4"), // 11
          new BigDecimal("0.36"), // 12
      },
      { // 3
          new BigDecimal("0.38"), // 1
          new BigDecimal("0.46"), // 2
          null, // 3
          new BigDecimal("0.49"), // 4
          new BigDecimal("0.49"), // 5
          new BigDecimal("0.47"), // 6
          new BigDecimal("0.34"), // 7
          new BigDecimal("0.36"), // 8
          new BigDecimal("0.41"), // 9
          new BigDecimal("0.42"), // 10
          new BigDecimal("0.43"), // 11
          new BigDecimal("0.39"), // 12
      },
      { // 4
          new BigDecimal("0.35"), // 1
          new BigDecimal("0.44"), // 2
          new BigDecimal("0.49"), // 3
          null, // 4
          new BigDecimal("0.48"), // 5
          new BigDecimal("0.48"), // 6
          new BigDecimal("0.31"), // 7
          new BigDecimal("0.34"), // 8
          new BigDecimal("0.38"), // 9
          new BigDecimal("0.42"), // 10
          new BigDecimal("0.41"), // 11
          new BigDecimal("0.37"), // 12
      },
      { // 5
          new BigDecimal("0.37"), // 1
          new BigDecimal("0.45"), // 2
          new BigDecimal("0.49"), // 3
          new BigDecimal("0.48"), // 4
          null, // 5
          new BigDecimal("0.48"), // 6
          new BigDecimal("0.33"), // 7
          new BigDecimal("0.35"), // 8
          new BigDecimal("0.39"), // 9
          new BigDecimal("0.42"), // 10
          new BigDecimal("0.43"), // 11
          new BigDecimal("0.38"), // 12
      },
      { // 6
          new BigDecimal("0.33"), // 1
          new BigDecimal("0.43"), // 2
          new BigDecimal("0.47"), // 3
          new BigDecimal("0.48"), // 4
          new BigDecimal("0.48"), // 5
          null, // 6
          new BigDecimal("0.29"), // 7
          new BigDecimal("0.32"), // 8
          new BigDecimal("0.36"), // 9
          new BigDecimal("0.39"), // 10
          new BigDecimal("0.4"), // 11
          new BigDecimal("0.35"), // 12
      },
      { // 7
          new BigDecimal("0.36"), // 1
          new BigDecimal("0.33"), // 2
          new BigDecimal("0.34"), // 3
          new BigDecimal("0.31"), // 4
          new BigDecimal("0.33"), // 5
          new BigDecimal("0.29"), // 6
          null, // 7
          new BigDecimal("0.28"), // 8
          new BigDecimal("0.32"), // 9
          new BigDecimal("0.31"), // 10
          new BigDecimal("0.3"), // 11
          new BigDecimal("0.28"), // 12
      },
      { // 8
          new BigDecimal("0.31"), // 1
          new BigDecimal("0.36"), // 2
          new BigDecimal("0.36"), // 3
          new BigDecimal("0.34"), // 4
          new BigDecimal("0.35"), // 5
          new BigDecimal("0.32"), // 6
          new BigDecimal("0.28"), // 7
          null, // 8
          new BigDecimal("0.33"), // 9
          new BigDecimal("0.34"), // 10
          new BigDecimal("0.33"), // 11
          new BigDecimal("0.3"), // 12
      },
      { // 9
          new BigDecimal("0.32"), // 1
          new BigDecimal("0.38"), // 2
          new BigDecimal("0.41"), // 3
          new BigDecimal("0.38"), // 4
          new BigDecimal("0.39"), // 5
          new BigDecimal("0.36"), // 6
          new BigDecimal("0.32"), // 7
          new BigDecimal("0.33"), // 8
          null, // 9
          new BigDecimal("0.38"), // 10
          new BigDecimal("0.36"), // 11
          new BigDecimal("0.34"), // 12
      },
      { // 10
          new BigDecimal("0.33"), // 1
          new BigDecimal("0.39"), // 2
          new BigDecimal("0.42"), // 3
          new BigDecimal("0.42"), // 4
          new BigDecimal("0.42"), // 5
          new BigDecimal("0.39"), // 6
          new BigDecimal("0.31"), // 7
          new BigDecimal("0.34"), // 8
          new BigDecimal("0.38"), // 9
          null, // 10
          new BigDecimal("0.38"), // 11
          new BigDecimal("0.36"), // 12
      },
      { // 11
          new BigDecimal("0.32"), // 1
          new BigDecimal("0.4"), // 2
          new BigDecimal("0.43"), // 3
          new BigDecimal("0.41"), // 4
          new BigDecimal("0.43"), // 5
          new BigDecimal("0.4"), // 6
          new BigDecimal("0.3"), // 7
          new BigDecimal("0.33"), // 8
          new BigDecimal("0.36"), // 9
          new BigDecimal("0.38"), // 10
          null, // 11
          new BigDecimal("0.35"), // 12
      },
      { // 12
          new BigDecimal("0.3"), // 1
          new BigDecimal("0.36"), // 2
          new BigDecimal("0.39"), // 3
          new BigDecimal("0.37"), // 4
          new BigDecimal("0.38"), // 5
          new BigDecimal("0.35"), // 6
          new BigDecimal("0.28"), // 7
          new BigDecimal("0.3"), // 8
          new BigDecimal("0.34"), // 9
          new BigDecimal("0.36"), // 10
          new BigDecimal("0.35"), // 11
          null, // 12
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
