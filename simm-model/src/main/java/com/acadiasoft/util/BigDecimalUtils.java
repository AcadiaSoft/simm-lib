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

package com.acadiasoft.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.function.Function;

public class BigDecimalUtils {

  private static final int DIVISION_SCALE = 64;

  public static BigDecimal divideWithPrecision(BigDecimal dividend, BigDecimal divisor) {
    return dividend.divide(divisor, DIVISION_SCALE, RoundingMode.HALF_UP);
  }

  public static <T> BigDecimal sumSquared(List<T> o, Function<T, BigDecimal> f) {
    return o.stream().map(f).map(BigDecimalUtils::square).reduce(BigDecimal.ZERO, BigDecimalUtils::sum);
  }

  public static <T> BigDecimal sum(List<T> o, Function<T, BigDecimal> f) {
    return o.stream().map(f).reduce(BigDecimalUtils::sum).get();
  }

  public static BigDecimal sqrt(BigDecimal bd) {
    return new BigDecimal(Math.sqrt(bd.doubleValue()));
  }

  public static BigDecimal square(BigDecimal b1) {
    return b1.pow(2);
  }

  public static BigDecimal abs(BigDecimal b1) {
    return b1.abs();
  }

  public static BigDecimal sum(BigDecimal b1, BigDecimal b2) {
    return b1.add(b2);
  }
}
