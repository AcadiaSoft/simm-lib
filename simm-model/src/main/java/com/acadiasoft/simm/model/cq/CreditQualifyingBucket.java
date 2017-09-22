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

package com.acadiasoft.simm.model.cq;

import org.apache.commons.lang3.StringUtils;

/**
 * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public enum CreditQualifyingBucket {

  _1(1, "Investment grade (IG)", "Sovereigns including central banks"), //
  _2(2, "Investment grade (IG)", "Financials including government-backed financials"), //
  _3(3, "Investment grade (IG)", "Basic materials, energy, industrials"), //
  _4(4, "Investment grade (IG)", "Consumer"), //
  _5(5, "Investment grade (IG)", "Technology, telecommunications"), //
  _6(6, "Investment grade (IG)", "Health care, utilities, local government, government-backed corporates (non- financial)"), // 
  _7(7, "High yield (HY) & non-rated (NR)", "Sovereigns including central banks"), //
  _8(8, "High yield (HY) & non-rated (NR)", "Financials including government-backed financials"), //
  _9(9, "High yield (HY) & non-rated (NR)", "Basic materials, energy, industrials"), //
  _10(10, "High yield (HY) & non-rated (NR)", "Consumer"), //
  _11(11, "High yield (HY) & non-rated (NR)", "Technology, telecommunications"), //
  _12(12, "High yield (HY) & non-rated (NR)", "Health care, utilities, local government, government-backed corporates (non- financial)"), // 
  RESIDUAL(-1, null, null);

  private final int bucket;
  private final String creditQuality;
  private final String sector;

  private CreditQualifyingBucket(int bucket, String creditQuality, String label) {
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

  public static CreditQualifyingBucket getBucket(String b) {
    if (StringUtils.equalsIgnoreCase(b, "Residual")) {
      return RESIDUAL;
    } else {
      for (CreditQualifyingBucket cqb : values()) {
        if (Integer.valueOf(b) == cqb.getBucket()) {
          return cqb;
        }
      }

      throw new RuntimeException("found bucket that doesn't exist: " + b);
    }
  }

}
