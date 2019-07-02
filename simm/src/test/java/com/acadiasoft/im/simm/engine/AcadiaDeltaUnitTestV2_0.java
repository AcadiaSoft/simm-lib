/*
 * Copyright (c) 2018 AcadiaSoft, Inc.
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

package com.acadiasoft.im.simm.engine;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.param.HoldingPeriod;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alec.stewart on 8/15/17.
 */
public class AcadiaDeltaUnitTestV2_0 extends AbstractAcadiaUnitTestV2_0 {

  @Test // tested: regular vol
  public void testIR1() {
    Assert.assertEquals(new BigDecimal("14200000000"), Simm.calculateStandard(Arrays.asList(IR1), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: regular vol, CR (well traded)
  public void testIR2() {
    Assert.assertEquals(new BigDecimal("18645566306"), Simm.calculateStandard(Arrays.asList(IR2), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: regular vol, CR (less traded, inflation)
  public void testIR3() {
    Assert.assertEquals(new BigDecimal("1517893277"), Simm.calculateStandard(Arrays.asList(IR6), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: low vol
  public void testIR4() {
    Assert.assertEquals(new BigDecimal("230000000"), Simm.calculateStandard(Arrays.asList(IR8), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: high vol, CR
  public void testIR5() {
    Assert.assertEquals(new BigDecimal("2349609897"), Simm.calculateStandard(Arrays.asList(IR9), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (different sub-curve)
  public void testIR6() {
    Assert.assertEquals(new BigDecimal("12866994210"), Simm.calculateStandard(Arrays.asList(IR1, IR3), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (same sub-curve)
  public void testIR7() {
    Assert.assertEquals(new BigDecimal("2023872526"), Simm.calculateStandard(Arrays.asList(IR7, IR8), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (XCcy to Inflation), CR (XCcy not in sum)
  public void testIR8() {
    Assert.assertEquals(new BigDecimal("6221583400"), Simm.calculateStandard(Arrays.asList(IR4, IR5), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (multiple), CR (XCcy not scaled)
  public void testIR9() {
    Assert.assertEquals(new BigDecimal("31531158315"), Simm.calculateStandard(Arrays.asList(IR1, IR2, IR3, IR4, IR5), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket
  public void testIR10() {
    Assert.assertEquals(new BigDecimal("31779941448"), Simm.calculateStandard(Arrays.asList(IR1, IR2, IR3, IR4, IR5, IR6), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket (multiple)
  public void testIR11() {
    Assert.assertEquals(new BigDecimal("31773442304"), Simm.calculateStandard(Arrays.asList(IR1, IR2, IR3, IR4, IR5, IR6, IR7, IR8, IR9), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: product multiplier
  public void testIR12() {
    Assert.assertEquals(new BigDecimal("38286997977"), Simm.calculateTotal(Arrays.asList(IR1, IR2, IR3, IR4, IR5, IR6, IR7, IR8, IR9), Arrays.asList(IR10), EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED, FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: netting on same risk factor
  public void testFX1() {
    Assert.assertEquals(BigDecimal.ZERO, Simm.calculateStandard(Arrays.asList(FX1, FX2), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight, CR (Cat 2)
  public void testFX2() {
    Assert.assertEquals(new BigDecimal("16200000000"), Simm.calculateStandard(Arrays.asList(FX3), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: FX corr param, CR (Cat 2 & 3)
  public void testFX3() {
    Assert.assertEquals(new BigDecimal("19304527966"), Simm.calculateStandard(Arrays.asList(FX3, FX4), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: no offsetting corr
  public void testFX4() {
    Assert.assertEquals(new BigDecimal("19758023687"), Simm.calculateStandard(Arrays.asList(FX1, FX3, FX4), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: product multiplier, offsetting correlation
  public void testFX5() {
    Assert.assertEquals(new BigDecimal("22744268864"), Simm.calculateTotal(Arrays.asList(FX2, FX3, FX4), Arrays.asList(IR10), EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED, FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: product multiplier, Risk Corr (FX to IR)
  public void testRisk1() {
    Assert.assertEquals(new BigDecimal("49700509702"), Simm.calculateTotal(Arrays.asList(IR1, IR2, IR3, IR4, IR5, IR6, IR7, IR8, IR9, FX1, FX2, FX3, FX4), Arrays.asList(IR10), EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED, FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testEQ1() {
    Assert.assertEquals(new BigDecimal("60000000"), Simm.calculateStandard(Arrays.asList(EQ1), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight, CR
  public void testEQ2() {
    Assert.assertEquals(new BigDecimal("150000000"), Simm.calculateStandard(Arrays.asList(EQ2), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testEQ3() {
    Assert.assertEquals(new BigDecimal("210000000"), Simm.calculateStandard(Arrays.asList(EQ3), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight, CR
  public void testEQ4() {
    Assert.assertEquals(new BigDecimal("780734787"), Simm.calculateStandard(Arrays.asList(EQ4), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight (Residual)
  public void testEQ5() {
    Assert.assertEquals(new BigDecimal("19040000"), Simm.calculateStandard(Arrays.asList(EQ11), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (no offsets)
  public void testEQ6() {
    Assert.assertEquals(new BigDecimal("172336879"), Simm.calculateStandard(Arrays.asList(EQ1, EQ2), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (offsetting)
  public void testEQ7() {
    Assert.assertEquals(new BigDecimal("212089604"), Simm.calculateStandard(Arrays.asList(EQ3, EQ5), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (offsetting, CR corr)
  public void testEQ8() {
    Assert.assertEquals(new BigDecimal("788071639"), Simm.calculateStandard(Arrays.asList(EQ3, EQ4, EQ5), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (Residual)
  public void testEQ9() {
    Assert.assertEquals(new BigDecimal("31824073"), Simm.calculateStandard(Arrays.asList(EQ10, EQ11), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket (offsetting)
  public void testEQ10() {
    Assert.assertEquals(new BigDecimal("208620708"), Simm.calculateStandard(Arrays.asList(EQ1, EQ3, EQ7, EQ9), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket (offsetting, CR corr)
  public void testEQ11() {
    Assert.assertEquals(new BigDecimal("847874443"), Simm.calculateStandard(Arrays.asList(EQ1, EQ2, EQ4, EQ5, EQ6, EQ8), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: multiple
  public void testEQ12() {
    Assert.assertEquals(new BigDecimal("895893444"), Simm.calculateStandard(Arrays.asList(EQ1, EQ2, EQ3, EQ4, EQ5, EQ6, EQ7, EQ8, EQ9, EQ10, EQ11), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: product multiplier
  public void testEQ13() {
    Assert.assertEquals(new BigDecimal("909331846"), Simm.calculateTotal(Arrays.asList(EQ1, EQ2, EQ3, EQ4, EQ5, EQ6, EQ7, EQ8, EQ9, EQ10, EQ11), Arrays.asList(EQ12), EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED, FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCQ1() {
    Assert.assertEquals(new BigDecimal("69000000"), Simm.calculateStandard(Arrays.asList(CQ1), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCQ2() {
    Assert.assertEquals(new BigDecimal("1860488987"), Simm.calculateStandard(Arrays.asList(CQ5), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCQ3() {
    Assert.assertEquals(new BigDecimal("166000000"), Simm.calculateStandard(Arrays.asList(CQ7), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCQ4() {
    Assert.assertEquals(new BigDecimal("8326914194"), Simm.calculateStandard(Arrays.asList(CQ11), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCQ5() {
    Assert.assertEquals(new BigDecimal("1983434521"), Simm.calculateStandard(Arrays.asList(CQ15), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: same issuer/seniority (intra-bucket)
  public void testCQ6() {
    Assert.assertEquals(new BigDecimal("290210424"), Simm.calculateStandard(Arrays.asList(CQ1, CQ2, CQ3), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: same issuer/seniority, CR (intra-bucket)
  public void testCQ7() {
    Assert.assertEquals(new BigDecimal("4200448321"), Simm.calculateStandard(Arrays.asList(CQ1, CQ3), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: different & same issuer/seniority (intra-bucket)
  public void testCQ8() {
    Assert.assertEquals(new BigDecimal("629565922"), Simm.calculateStandard(Arrays.asList(CQ1, CQ2, CQ3, CQ4), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: different issuer/seniority (same tenor) (intra-bucket)
  public void testCQ9() {
    Assert.assertEquals(new BigDecimal("1818416923"), Simm.calculateStandard(Arrays.asList(CQ5, CQ6), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: multiple different issuer/seniority (intra-bucket)
  public void testCQ10() {
    Assert.assertEquals(new BigDecimal("1068608674"), Simm.calculateStandard(Arrays.asList(CQ8, CQ9, CQ10), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: CR (netting to be under threshold)
  public void testCQ11() {
    Assert.assertEquals(new BigDecimal("321490608"), Simm.calculateStandard(Arrays.asList(CQ11, CQ12, CQ13), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: CR (netting to be over threshold)
  public void testCQ12() {
    Assert.assertEquals(new BigDecimal("3378851292"), Simm.calculateStandard(Arrays.asList(CQ11, CQ12), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket
  public void testCQ13() {
    Assert.assertEquals(new BigDecimal("1306838776"), Simm.calculateStandard(Arrays.asList(CQ1, CQ2, CQ3, CQ4, CQ7, CQ8, CQ9, CQ10), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket (multiple)
  public void testCQ14() {
    Assert.assertEquals(new BigDecimal("1902604112"), Simm.calculateStandard(Arrays.asList(CQ1, CQ2, CQ3, CQ4, CQ5, CQ6, CQ7, CQ8, CQ9, CQ10), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (Residual)
  public void testCQ15() {
    Assert.assertEquals(new BigDecimal("2830853081"), Simm.calculateStandard(Arrays.asList(CQ14, CQ15), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket (multiple w/ residual)
  public void testCQ16() {
    Assert.assertEquals(new BigDecimal("4757786546"), Simm.calculateStandard(Arrays.asList(CQ1, CQ2, CQ3, CQ4, CQ5, CQ6, CQ7, CQ8, CQ9, CQ10, CQ11, CQ12, CQ13, CQ14, CQ15), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: product multiplier
  public void testCQ17() {
    Assert.assertEquals(new BigDecimal("5281143066"), Simm.calculateTotal(Arrays.asList(CQ1, CQ2, CQ3, CQ4, CQ5, CQ6, CQ7, CQ8, CQ9, CQ10, CQ11, CQ12, CQ13, CQ14, CQ15), Arrays.asList(CQ16), EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED, FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testBC1() {
    Assert.assertEquals(new BigDecimal("38000000"), Simm.calculateStandard(Arrays.asList(BC1), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: netting
  public void testBC2() {
    Assert.assertEquals(new BigDecimal("19000000"), Simm.calculateStandard(Arrays.asList(BC1, BC2), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket
  public void testBC3() {
    Assert.assertEquals(new BigDecimal("86653332"), Simm.calculateStandard(Arrays.asList(BC1, BC2, BC3), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (multiple)
  public void testBC4() {
    Assert.assertEquals(new BigDecimal("89421194"), Simm.calculateStandard(Arrays.asList(BC1, BC2, BC3, BC4), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: Base Corr only in Credit Qualifying Risk Class
  public void testRisk2() {
    List<Sensitivity> s = Arrays.asList(CQ1, CQ2, CQ3, CQ4, CQ5, CQ6, CQ7, CQ8, CQ9, CQ10, CQ11, CQ12, CQ13, CQ14, CQ15, BC1, BC2, BC3, BC4);
    Assert.assertEquals(new BigDecimal("5380400592"), Simm.calculateTotal(s, Arrays.asList(CQ16), EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED, FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCNQ1() {
    Assert.assertEquals(new BigDecimal("450000000"), Simm.calculateStandard(Arrays.asList(CNQ1), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCNQ2() {
    Assert.assertEquals(new BigDecimal("5537710718"), Simm.calculateStandard(Arrays.asList(CNQ4), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCNQ3() {
    Assert.assertEquals(new BigDecimal("8818163074"), Simm.calculateStandard(Arrays.asList(CNQ7), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (same issuer/seniority), CR (netting to be over threshold)
  public void testCNQ4() {
    Assert.assertEquals(new BigDecimal("1393084423"), Simm.calculateStandard(Arrays.asList(CNQ1, CNQ2), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (same issuer/seniority), CR (netting to be under threshold)
  public void testCNQ5() {
    Assert.assertEquals(new BigDecimal("2346606060"), Simm.calculateStandard(Arrays.asList(CNQ4, CNQ5), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (different issuer/seniority)
  public void testCNQ6() {
    Assert.assertEquals(new BigDecimal("793725393"), Simm.calculateStandard(Arrays.asList(CNQ1, CNQ3), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (same & different issuer/seniorty)
  public void testCNQ7() {
    Assert.assertEquals(new BigDecimal("38459653665"), Simm.calculateStandard(Arrays.asList(CNQ4, CNQ5, CNQ6), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (residual)
  public void testCNQ8() {
    Assert.assertEquals(new BigDecimal("8453486855"), Simm.calculateStandard(Arrays.asList(CNQ7, CNQ8), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket
  public void testCNQ9() {
    Assert.assertEquals(new BigDecimal("38611298664"), Simm.calculateStandard(Arrays.asList(CNQ1, CNQ2, CNQ3, CNQ4, CNQ5, CNQ6), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket (w/ residual)
  public void testCNQ10() {
    Assert.assertEquals(new BigDecimal("47064785518"), Simm.calculateStandard(Arrays.asList(CNQ1, CNQ2, CNQ3, CNQ4, CNQ5, CNQ6, CNQ7, CNQ8), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: product multiplier
  public void testCNQ11() {
    Assert.assertEquals(new BigDecimal("52241911925"), Simm.calculateTotal(Arrays.asList(CNQ1, CNQ2, CNQ3, CNQ4, CNQ5, CNQ6, CNQ7, CNQ8), Arrays.asList(CQ16), EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED, FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: Risk Corr (CQ to CNQ)
  public void testRisk3() {
    List<Sensitivity> s = Arrays.asList(CQ1, CQ2, CQ3, CQ4, CQ5, CQ6, CQ7, CQ8, CQ9, CQ10, CQ11, CQ12, CQ13, CQ14, CQ15, BC1, BC2, BC3, BC4, CNQ1, CNQ2, CNQ3, CNQ4, CNQ5, CNQ6, CNQ7, CNQ8);
    Assert.assertEquals(new BigDecimal("53891826164"), Simm.calculateTotal(s, Arrays.asList(CQ16), EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED, FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCM1() {
    Assert.assertEquals(new BigDecimal("570000000"), Simm.calculateStandard(Arrays.asList(CM1), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCM2() {
    Assert.assertEquals(new BigDecimal("2550000000"), Simm.calculateStandard(Arrays.asList(CM3), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCM3() {
    Assert.assertEquals(new BigDecimal("1430000000"), Simm.calculateStandard(Arrays.asList(CM6), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight, CR (above threshold)
  public void testCM4() {
    Assert.assertEquals(new BigDecimal("49033642297"), Simm.calculateStandard(Arrays.asList(CM8), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCM5() {
    Assert.assertEquals(new BigDecimal("350000000"), Simm.calculateStandard(Arrays.asList(CM10), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCM6() {
    Assert.assertEquals(new BigDecimal("120000000"), Simm.calculateStandard(Arrays.asList(CM11), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (negtive correlation)
  public void testCM7() {
    Assert.assertEquals(new BigDecimal("966948809"), Simm.calculateStandard(Arrays.asList(CM1, CM2), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (positive correlation)
  public void testCM8() {
    Assert.assertEquals(new BigDecimal("2310000000"), Simm.calculateStandard(Arrays.asList(CM6, CM7), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (multiple)
  public void testCM9() {
    Assert.assertEquals(new BigDecimal("4816133304"), Simm.calculateStandard(Arrays.asList(CM3, CM4, CM5), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket, CR (no netting for CM)
  public void testCM10() {
    Assert.assertEquals(new BigDecimal("49085079199"), Simm.calculateStandard(Arrays.asList(CM8, CM9), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket
  public void testCM11() {
    Assert.assertEquals(new BigDecimal("359638708"), Simm.calculateStandard(Arrays.asList(CM10, CM11), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket (multiple)
  public void testCM12() {
    Assert.assertEquals(new BigDecimal("49717717006"), Simm.calculateStandard(Arrays.asList(CM1, CM2, CM3, CM4, CM5, CM6, CM7, CM8, CM9, CM10, CM11), FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: product multiplier
  public void testCM13() {
    Assert.assertEquals(new BigDecimal("53446545781"), Simm.calculateTotal(Arrays.asList(CM1, CM2, CM3, CM4, CM5, CM6, CM7, CM8, CM9, CM10, CM11), Arrays.asList(CM12), EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED, FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: All delta
  public void testRisk4() {
    List<Sensitivity> s = Arrays.asList(CM1, CM2, CM3, CM4, CM5, CM6, CM7, CM8, CM9, CM10, CM11, CQ1, CQ2, CQ3, CQ4, CQ5, CQ6, CQ7, CQ8, CQ9, CQ10, CQ11, CQ12, CQ13, CQ14, CQ15, BC1, BC2, BC3, BC4, CNQ1, CNQ2, CNQ3, CNQ4, CNQ5, CNQ6, CNQ7, CNQ8, EQ1, EQ2, EQ3, EQ4, EQ5, EQ6, EQ7, EQ8, EQ9, EQ10, EQ11, IR1, IR2, IR3, IR4, IR5, IR6, IR7, IR8, IR9, FX1, FX2, FX3, FX4);
    Assert.assertEquals(new BigDecimal("157948213493"), Simm.calculateTotal(s, Arrays.asList(CM12, IR10, EQ12, CQ16), EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED, FxRate.USD, HoldingPeriod.TenDay).setScale(0, RoundingMode.HALF_UP));
  }

}
