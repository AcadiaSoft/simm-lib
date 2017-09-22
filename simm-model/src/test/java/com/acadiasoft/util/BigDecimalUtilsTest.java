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

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BigDecimalUtilsTest {

  @Test
  public void sqrt() {
    Assert.assertEquals(new BigDecimal("2"), BigDecimalUtils.sqrt(new BigDecimal("4")));
    Assert.assertEquals(new BigDecimal("3"), BigDecimalUtils.sqrt(new BigDecimal("9")));
    Assert.assertEquals(new BigDecimal("4"), BigDecimalUtils.sqrt(new BigDecimal("16")));
    Assert.assertEquals(new BigDecimal("5"), BigDecimalUtils.sqrt(new BigDecimal("25")));
  }

  @Test
  public void sum() {
    Assert.assertEquals(new BigDecimal("4"), BigDecimalUtils.sum(new BigDecimal("1"), new BigDecimal("3")));
  }

  @Test
  public void sumInStream() {
    List<BigDecimal> list = Arrays.asList(new BigDecimal("1"), new BigDecimal("3"));
    Assert.assertEquals(new BigDecimal("4"), list.stream().reduce(BigDecimalUtils::sum).get());

    List<BigDecimal> list2 = Arrays.asList(new BigDecimal("1"), new BigDecimal("3"), new BigDecimal("5"));
    Assert.assertEquals(new BigDecimal("9"), list2.parallelStream().reduce(BigDecimalUtils::sum).get());
  }

  @Test
  public void square() {
    Assert.assertEquals(new BigDecimal("4"), BigDecimalUtils.square(new BigDecimal("2")));
    Assert.assertEquals(new BigDecimal("9"), BigDecimalUtils.square(new BigDecimal("3")));
    Assert.assertEquals(new BigDecimal("16"), BigDecimalUtils.square(new BigDecimal("4")));
    Assert.assertEquals(new BigDecimal("25"), BigDecimalUtils.square(new BigDecimal("5")));
  }

  @Test
  public void squareInStream() {
    List<BigDecimal> list = Arrays.asList(new BigDecimal("2"), new BigDecimal("3"));
    Assert.assertEquals(Arrays.asList(new BigDecimal("4"), new BigDecimal("9")), list.stream().map(BigDecimalUtils::square).collect(Collectors.toList()));
  }
}
