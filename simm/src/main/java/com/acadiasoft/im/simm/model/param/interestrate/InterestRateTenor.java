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

package com.acadiasoft.im.simm.model.param.interestrate;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author joe.peterson
 *
 */
public enum InterestRateTenor {

  _2W("2w"), //
  _1M("1m"), //
  _3M("3m"), //
  _6M("6m"), //
  _1Y("1y"), //
  _2Y("2y"), //
  _3Y("3y"), //
  _5Y("5y"), //
  _10Y("10y"), //
  _15Y("15y"), //
  _20Y("20y"), //
  _30Y("30y");

  private static final List<InterestRateTenor> ALL = Arrays.asList(values());

  private final String tenor;

  private InterestRateTenor(String label) {
    this.tenor = label;
  }

  public String getTenor() {
    return tenor;
  }

  public static int indexOf(InterestRateTenor r) {
    return ALL.indexOf(r);
  }

  public static int indexOf(String tenor) {
    return ALL.indexOf(getByTenor(tenor));
  }

  public static InterestRateTenor getByTenor(String tenor) {
    for (InterestRateTenor interestRateTenor : values()) {
      if (StringUtils.equalsIgnoreCase(interestRateTenor.getTenor(), tenor)) {
        return interestRateTenor;
      }
    }
    return null;
  }
}
