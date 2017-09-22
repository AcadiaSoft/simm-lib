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

package com.acadiasoft.simm.util;

import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.sensitivity.BucketWeightedAggregation;
import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BucketWeightedAggregationUtilsTest {

  @Test
  public void testSumSquared() {
    List<BucketWeightedAggregation> list =
      Arrays.asList(new BucketWeightedAggregation(null, new BigDecimal("2"), null), new BucketWeightedAggregation(null, new BigDecimal("3"), null));
    Assert.assertEquals(new BigDecimal("13"), BucketWeightedAggregationUtils.sumSquared(list));
  }

  @Test
  public void testFilterOutResiduals() {
    List<BucketWeightedAggregation> list = Arrays.asList(//
      new BucketWeightedAggregation("1", new BigDecimal("2"), null), //
      new BucketWeightedAggregation("2", new BigDecimal("3"), null), //
      new BucketWeightedAggregation("Residual", new BigDecimal("3"), null));
    Assert.assertEquals(2, BucketWeightedAggregationUtils.filterOutResiduals(list).size());
  }

  @Test
  public void testFilterOutNonResiduals() {
    List<BucketWeightedAggregation> list = Arrays.asList(//
      new BucketWeightedAggregation("1", new BigDecimal("2"), null), //
      new BucketWeightedAggregation("2", new BigDecimal("3"), null), //
      new BucketWeightedAggregation("Residual", new BigDecimal("3"), null));
    Assert.assertEquals(1, BucketWeightedAggregationUtils.filterOutNonResiduals(list).size());
  }

  @Test
  public void testAddResiduals() {
    List<BucketWeightedAggregation> list = Arrays.asList(//
      new BucketWeightedAggregation("1", new BigDecimal("2"), null), //
      new BucketWeightedAggregation("2", new BigDecimal("3"), null), //
      new BucketWeightedAggregation("Residual", new BigDecimal("3"), null), //
      new BucketWeightedAggregation("Residual", new BigDecimal("5"), null));
    Assert.assertEquals(new BigDecimal("8"), BucketWeightedAggregationUtils.addResidual(RiskClass.CREDIT_QUALIFYING, list, BigDecimal.ZERO));
    Assert.assertEquals(new BigDecimal("8"), BucketWeightedAggregationUtils.addResidual(RiskClass.CREDIT_NON_QUALIFYING, list, BigDecimal.ZERO));
    Assert.assertEquals(new BigDecimal("8"), BucketWeightedAggregationUtils.addResidual(RiskClass.EQUITY, list, BigDecimal.ZERO));
    Assert.assertEquals(new BigDecimal("8"), BucketWeightedAggregationUtils.addResidual(RiskClass.COMMODITY, list, BigDecimal.ZERO));
    Assert.assertEquals(new BigDecimal("8"), BucketWeightedAggregationUtils.addResidual(RiskClass.FX, list, BigDecimal.ZERO));
    Assert.assertEquals(BigDecimal.ZERO, BucketWeightedAggregationUtils.addResidual(RiskClass.INTEREST_RATE, list, BigDecimal.ZERO));
  }

  @Test
  public void testSumWeightedAggregations() {
    List<BucketWeightedAggregation> list = Arrays.asList(//
      new BucketWeightedAggregation("1", new BigDecimal("2"), Arrays.asList(new WeightedSensitivity(null, new BigDecimal("11")))), //
      new BucketWeightedAggregation("2", new BigDecimal("3"), Arrays.asList(new WeightedSensitivity(null, new BigDecimal("13")))), //
      new BucketWeightedAggregation("3", new BigDecimal("7"),
        Arrays.asList(new WeightedSensitivity(null, new BigDecimal("17")), new WeightedSensitivity(null, new BigDecimal("19")))));
    Assert.assertEquals(new BigDecimal("60"), BucketWeightedAggregationUtils.sumWeightedSensitivities(list));
  }
}
