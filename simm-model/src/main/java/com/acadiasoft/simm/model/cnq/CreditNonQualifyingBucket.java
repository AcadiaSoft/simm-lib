/*
 * Copyright (c) 2017 AcadiaSoft, Inc.
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

package com.acadiasoft.simm.model.cnq;

import org.apache.commons.lang3.StringUtils;

/**
 * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public enum CreditNonQualifyingBucket {

  _1(1, "Investment grade (IG)", "RMBS/CMBS"), // 
  _2(2, "High yield (HY) & non-rated (NR)", "RMBS/CMBS"), //
  RESIDUAL(-1, null, null);

  private final int bucket;
  private final String creditQuality;
  private final String sector;

  private CreditNonQualifyingBucket(int bucket, String creditQuality, String label) {
    this.bucket = bucket;
    this.creditQuality = creditQuality;
    this.sector = label;
  }

  public int getBucket() {
    return bucket;
  }

  public String getCreditQuality() {
    return creditQuality;
  }

  public String getSector() {
    return sector;
  }

  public static CreditNonQualifyingBucket getBucket(String b) {
    if (StringUtils.equalsIgnoreCase(b, "Residual")) {
      return RESIDUAL;
    } else {
      for (CreditNonQualifyingBucket cnqb : values()) {
        if (Integer.valueOf(b) == cnqb.getBucket()) {
          return cnqb;
        }
      }

      throw new RuntimeException("found bucket that doesn't exist: " + b);
    }
  }

}
