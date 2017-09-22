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
import com.acadiasoft.simm.model.risk.RiskType;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class WeightedSensitivityUtilsTest {

  @Test
  public void testSumWeightSensitivities() {
    WeightedSensitivity w1 = new WeightedSensitivity(null, new BigDecimal("2"));
    WeightedSensitivity w2 = new WeightedSensitivity(null, new BigDecimal("3"));
    Assert.assertEquals(new BigDecimal("5"), WeightedSensitivityUtils.sumWeightSensitivities(Arrays.asList(w1, w2)));
  }

  @Test
  public void testSumAbsoluteValues() {
    WeightedSensitivity w1 = new WeightedSensitivity(null, new BigDecimal("2"));
    WeightedSensitivity w2 = new WeightedSensitivity(null, new BigDecimal("-3"));
    Assert.assertEquals(new BigDecimal("5"), WeightedSensitivityUtils.sumAbsoluteValues(Arrays.asList(w1, w2)));
  }

  @Test
  public void testSumSquared() {
    WeightedSensitivity w1 = new WeightedSensitivity(null, new BigDecimal("2"));
    WeightedSensitivity w2 = new WeightedSensitivity(null, new BigDecimal("3"));
    Assert.assertEquals(new BigDecimal("13"), WeightedSensitivityUtils.sumSquared(Arrays.asList(w1, w2)));
  }

  @Test
  public void testMapByBucket() {
    WeightedSensitivity w1 = new WeightedSensitivity(new Sensitivity("pc", "rt", "q", "1", "l1", "l2", null), new BigDecimal("2"));
    WeightedSensitivity w2 = new WeightedSensitivity(new Sensitivity("pc", "rt", "q", "1", "l1", "l2", null), new BigDecimal("3"));
    WeightedSensitivity w3 = new WeightedSensitivity(new Sensitivity("pc", "rt", "q", "3", "l1", "l2", null), new BigDecimal("3"));
    Assert.assertEquals(1, WeightedSensitivityUtils.mapByBucket(RiskClass.INTEREST_RATE, Arrays.asList(w1, w2, w3)).size());
    Assert.assertEquals(2, WeightedSensitivityUtils.mapByBucket(RiskClass.CREDIT_NON_QUALIFYING, Arrays.asList(w1, w2, w3)).size());
    Assert.assertEquals(2, WeightedSensitivityUtils.mapByBucket(RiskClass.CREDIT_QUALIFYING, Arrays.asList(w1, w2, w3)).size());
    Assert.assertEquals(2, WeightedSensitivityUtils.mapByBucket(RiskClass.FX, Arrays.asList(w1, w2, w3)).size());
    Assert.assertEquals(2, WeightedSensitivityUtils.mapByBucket(RiskClass.EQUITY, Arrays.asList(w1, w2, w3)).size());
    Assert.assertEquals(2, WeightedSensitivityUtils.mapByBucket(RiskClass.COMMODITY, Arrays.asList(w1, w2, w3)).size());
  }

  @Test
  public void testNetSensitivitiesByRiskFactor() {
    Sensitivity s1 = new Sensitivity("pc", RiskType.RISK_TYPE_COMMODITY, "q1", "1", "l1", "l2", new BigDecimal("3"));
    Sensitivity s1b = new Sensitivity("pc", RiskType.RISK_TYPE_COMMODITY, "q1", "1", "l2", "l2", new BigDecimal("5"));
    Sensitivity s1c = new Sensitivity("pc", RiskType.RISK_TYPE_COMMODITY, "USDGBP", "1", "l2", "l2", new BigDecimal("5"));
    Sensitivity s1d = new Sensitivity("pc", RiskType.RISK_TYPE_COMMODITY, "GBPUSD", "1", "l1", "l2", new BigDecimal("5"));

    WeightedSensitivity w1 = new WeightedSensitivity(s1, new BigDecimal("21"));
    WeightedSensitivity w1b = new WeightedSensitivity(s1b, new BigDecimal("23"));
    WeightedSensitivity w1c = new WeightedSensitivity(s1c, new BigDecimal("29"));
    WeightedSensitivity w1d = new WeightedSensitivity(s1d, new BigDecimal("31"));

    List<WeightedSensitivity> list = Arrays.asList(w1, w1b, w1c, w1d);

    List<WeightedSensitivity> fxNettedSensitivities = WeightedSensitivityUtils.netSensitivitiesByRiskFactor(RiskClass.FX, list);
    Assert.assertEquals(2, fxNettedSensitivities.size());
    Assert.assertEquals(new BigDecimal("44"), fxNettedSensitivities.get(0).getWeightedValue());
    Assert.assertEquals(new BigDecimal("60"), fxNettedSensitivities.get(1).getWeightedValue());

    List<WeightedSensitivity> nettedSensitivities = WeightedSensitivityUtils.netSensitivitiesByRiskFactor(RiskClass.COMMODITY, list);
    Assert.assertEquals(3, nettedSensitivities.size());
    Assert.assertEquals(new BigDecimal("44"), nettedSensitivities.get(0).getWeightedValue());
    Assert.assertEquals(new BigDecimal("29"), nettedSensitivities.get(1).getWeightedValue());
    Assert.assertEquals(new BigDecimal("31"), nettedSensitivities.get(2).getWeightedValue());

    List<WeightedSensitivity> equityNettedSensitivities = WeightedSensitivityUtils.netSensitivitiesByRiskFactor(RiskClass.EQUITY, list);
    Assert.assertEquals(3, equityNettedSensitivities.size());
    Assert.assertEquals(new BigDecimal("44"), nettedSensitivities.get(0).getWeightedValue());
    Assert.assertEquals(new BigDecimal("29"), nettedSensitivities.get(1).getWeightedValue());
    Assert.assertEquals(new BigDecimal("31"), nettedSensitivities.get(2).getWeightedValue());

    List<WeightedSensitivity> creditNonQualNettedSensitivities = WeightedSensitivityUtils.netSensitivitiesByRiskFactor(RiskClass.CREDIT_NON_QUALIFYING, list);
    Assert.assertEquals(4, creditNonQualNettedSensitivities.size());
    Assert.assertEquals(new BigDecimal("21"), creditNonQualNettedSensitivities.get(0).getWeightedValue());
    Assert.assertEquals(new BigDecimal("23"), creditNonQualNettedSensitivities.get(1).getWeightedValue());
    Assert.assertEquals(new BigDecimal("29"), creditNonQualNettedSensitivities.get(2).getWeightedValue());
    Assert.assertEquals(new BigDecimal("31"), creditNonQualNettedSensitivities.get(3).getWeightedValue());

    List<WeightedSensitivity> creditQualNettedSensitivities = WeightedSensitivityUtils.netSensitivitiesByRiskFactor(RiskClass.CREDIT_QUALIFYING, list);
    Assert.assertEquals(4, creditQualNettedSensitivities.size());
    Assert.assertEquals(new BigDecimal("21"), creditNonQualNettedSensitivities.get(0).getWeightedValue());
    Assert.assertEquals(new BigDecimal("23"), creditNonQualNettedSensitivities.get(1).getWeightedValue());
    Assert.assertEquals(new BigDecimal("29"), creditNonQualNettedSensitivities.get(2).getWeightedValue());
    Assert.assertEquals(new BigDecimal("31"), creditNonQualNettedSensitivities.get(3).getWeightedValue());

    List<WeightedSensitivity> irNettedSensitivities = WeightedSensitivityUtils.netSensitivitiesByRiskFactor(RiskClass.INTEREST_RATE, list);
    Assert.assertEquals(4, irNettedSensitivities.size());
    Assert.assertEquals(new BigDecimal("21"), creditNonQualNettedSensitivities.get(0).getWeightedValue());
    Assert.assertEquals(new BigDecimal("23"), creditNonQualNettedSensitivities.get(1).getWeightedValue());
    Assert.assertEquals(new BigDecimal("29"), creditNonQualNettedSensitivities.get(2).getWeightedValue());
    Assert.assertEquals(new BigDecimal("31"), creditNonQualNettedSensitivities.get(3).getWeightedValue());
  }

  @Test
  public void testDetermineLabel1() {
    Sensitivity s1 = new Sensitivity("pc", RiskType.RISK_TYPE_COMMODITY, "q1", "1", "l1", "l2", new BigDecimal("3"));
    Assert.assertEquals("", WeightedSensitivityUtils.determineLabel1(RiskClass.COMMODITY, s1));
    Assert.assertEquals("l1", WeightedSensitivityUtils.determineLabel1(RiskClass.CREDIT_NON_QUALIFYING, s1));
    Assert.assertEquals("l1", WeightedSensitivityUtils.determineLabel1(RiskClass.CREDIT_QUALIFYING, s1));
    Assert.assertEquals("", WeightedSensitivityUtils.determineLabel1(RiskClass.EQUITY, s1));
    Assert.assertEquals("", WeightedSensitivityUtils.determineLabel1(RiskClass.FX, s1));
    Assert.assertEquals("l1", WeightedSensitivityUtils.determineLabel1(RiskClass.INTEREST_RATE, s1));
  }

  @Test
  public void testDetermineQualifier() {
    Sensitivity s1 = new Sensitivity("pc", RiskType.RISK_TYPE_COMMODITY, "USDGBP", "1", "l1", "l2", new BigDecimal("3"));
    Assert.assertEquals("USDGBP", WeightedSensitivityUtils.determineQualifier(RiskClass.COMMODITY, s1));
    Assert.assertEquals("USDGBP", WeightedSensitivityUtils.determineQualifier(RiskClass.CREDIT_NON_QUALIFYING, s1));
    Assert.assertEquals("USDGBP", WeightedSensitivityUtils.determineQualifier(RiskClass.CREDIT_QUALIFYING, s1));
    Assert.assertEquals("USDGBP", WeightedSensitivityUtils.determineQualifier(RiskClass.EQUITY, s1));
    Assert.assertEquals("GBPUSD", WeightedSensitivityUtils.determineQualifier(RiskClass.FX, s1));
    Assert.assertEquals("USDGBP", WeightedSensitivityUtils.determineQualifier(RiskClass.INTEREST_RATE, s1));
  }
}
