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

package com.acadiasoft.simm.model.equity;

import org.apache.commons.lang3.StringUtils;

import static com.acadiasoft.simm.model.equity.EquitySize.LARGE;
import static com.acadiasoft.simm.model.equity.EquitySize.SMALL;

/**
 * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public enum EquityBucket {

  _1(1, LARGE, EquityRegion.EMERGING, "Consumer goods and services, transportation and storage, administrative and support service activities, utilities"), //
  _2(2, LARGE, EquityRegion.EMERGING, "Telecommunications, industrials"), //
  _3(3, LARGE, EquityRegion.EMERGING, "Basic materials, energy, agriculture, manufacturing, mining and quarrying "), //
  _4(4, LARGE, EquityRegion.EMERGING, "Financials including gov't-backed financials, real estate activities, technology"), //
  _5(5, LARGE, EquityRegion.DEVELOPED, "Consumer goods and services, transportation and storage, administrative and support service activities, utilities "), //
  _6(6, LARGE, EquityRegion.DEVELOPED, "Telecommunications, industrials"), //
  _7(7, LARGE, EquityRegion.DEVELOPED, "Basic materials, energy, agriculture, manufacturing, mining and quarrying "), //
  _8(8, LARGE, EquityRegion.DEVELOPED, "Financials including gov't-backed financials, real estate activities, technology "), //
  _9(9, SMALL, EquityRegion.EMERGING, "All sectors"), //
  _10(10, SMALL, EquityRegion.DEVELOPED, "All sectors"), //
  _11(11, EquitySize.ALL, EquityRegion.ALL, "Indexes, Funds, ETFs"),
  _12(12, EquitySize.ALL, EquityRegion.ALL, "Volatility Indexes"),
  RESIDUAL(-1, null, null, null);

  private final int bucket;
  private final EquitySize size;
  private final EquityRegion region;
  private final String sector;

  private EquityBucket(int bucket, EquitySize size, EquityRegion region, String sector) {
    this.bucket = bucket;
    this.size = size;
    this.region = region;
    this.sector = sector;
  }

  public int getBucket() {
    return bucket;
  }

  public EquitySize getSize() {
    return size;
  }

  public EquityRegion getRegion() {
    return region;
  }

  public String getSector() {
    return sector;
  }

  public static EquityBucket getBucket(String b) {
    if (StringUtils.equalsIgnoreCase(b, "Residual")) {
      return RESIDUAL;
    } else {
      for (EquityBucket eqb : values()) {
        if (Integer.valueOf(b) == eqb.getBucket()) {
          return eqb;
        }
      }

      throw new RuntimeException("found bucket that doesn't exist: " + b);
    }
  }
}
