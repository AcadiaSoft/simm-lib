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
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alec.stewart on 8/23/17.
 */
public class AcadiaVegaUnitTestV2_0 extends AbstractAcadiaUnitTestV2_0 {

  @Test // tested: vega weighting, Curvature > 0
  public void testIRV1() {
    Assert.assertEquals(new BigDecimal("296817050"), Simm.calculateStandard(Arrays.asList(IRV1), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: vega weighting, Curvature < 0
  public void testIRV2() {
    Assert.assertEquals(new BigDecimal("48000000"), Simm.calculateStandard(Arrays.asList(IRV2), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: No netting in IRVol
  public void testIRV3() {
    Assert.assertEquals(new BigDecimal("14248000000"), Simm.calculateStandard(Arrays.asList(IR1, IRV2), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: vega weighting (inflation), Curvature > 0
  public void testIRV4() {
    Assert.assertEquals(new BigDecimal("176551066"), Simm.calculateStandard(Arrays.asList(IRV7), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: netting for InflationVol
  public void testIRV5() {
    Assert.assertEquals(new BigDecimal("56000000"), Simm.calculateStandard(Arrays.asList(IRV5, IRV6), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: vol weight in CR
  public void testIRV6() {
    Assert.assertEquals(new BigDecimal("22028345"), Simm.calculateStandard(Arrays.asList(IRV3, IRV4), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket
  public void testIRV7() {
    Assert.assertEquals(new BigDecimal("387969168"), Simm.calculateStandard(Arrays.asList(IRV1, IRV2, IRV7), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: multiple buckets
  public void testIRV8() {
    Assert.assertEquals(new BigDecimal("483003521"), Simm.calculateStandard(Arrays.asList(IRV1, IRV2, IRV3, IRV4, IRV5, IRV6, IRV7), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: vega weighting, Curvature > 0
  public void testFXV1() {
    Assert.assertEquals(new BigDecimal("197113249"), Simm.calculateStandard(Arrays.asList(FXV1), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: vega weighting, Curvature < 0
  public void testFXV2() {
    Assert.assertEquals(new BigDecimal("84002960"), Simm.calculateStandard(Arrays.asList(FXV5), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: netting over tenors, order or currency pair doesn't matter, CR (vol weighted values in CR)
  public void testFXV3() {
    Assert.assertEquals(new BigDecimal("546819143"), Simm.calculateStandard(Arrays.asList(FXV1, FXV2), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: netting over tenors, order or currency pair doesn't matter, CR (netting to be below threshold)
  public void testFXV4() {
    Assert.assertEquals(new BigDecimal("199496275"), Simm.calculateStandard(Arrays.asList(FXV1, FXV2, FXV3), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // multiple, CR (no netting across risk factors)
  public void testFXV5() {
    Assert.assertEquals(new BigDecimal("466370454"), Simm.calculateStandard(Arrays.asList(FXV1, FXV2, FXV3, FXV4, FXV5), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // testing 0 value in FXV
  public void testFXV6() {
    Sensitivity zero = new Sensitivity("RatesFX", "Risk_FXVol", "USDJPY", "", "2w", "", BigDecimal.ZERO);
    Assert.assertEquals(BigDecimal.ZERO, Simm.calculateStandard(Arrays.asList(zero), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testEQV1() {
    Assert.assertEquals(new BigDecimal("319360046"), Simm.calculateStandard(Arrays.asList(EQV1), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testEQV2() {
    Assert.assertEquals(new BigDecimal("1345791692"), Simm.calculateStandard(Arrays.asList(EQV4), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testEQV3() {
    Assert.assertEquals(new BigDecimal("264329313"), Simm.calculateStandard(Arrays.asList(EQV6), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testEQV4() {
    Assert.assertEquals(new BigDecimal("208036959"), Simm.calculateStandard(Arrays.asList(EQV7), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight residual
  public void testEQV5() {
    Assert.assertEquals(new BigDecimal("5312157001"), Simm.calculateStandard(Arrays.asList(EQV10), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (netting)
  public void testEQV6() {
    Assert.assertEquals(new BigDecimal("17404399"), Simm.calculateStandard(Arrays.asList(EQV1, EQV2), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (netting), (CR)
  public void testEQV7() {
    Assert.assertEquals(new BigDecimal("12048394168"), Simm.calculateStandard(Arrays.asList(EQV1, EQV2, EQV3), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket
  public void testEQV8() {
    Assert.assertEquals(new BigDecimal("1545642629"), Simm.calculateStandard(Arrays.asList(EQV4, EQV5), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // residual
  public void testEQV9() {
    Assert.assertEquals(new BigDecimal("5678830191"), Simm.calculateStandard(Arrays.asList(EQV8, EQV9, EQV10), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // inter-bucket
  public void testEQV10() {
    Assert.assertEquals(new BigDecimal("1582952747"), Simm.calculateStandard(Arrays.asList(EQV4, EQV5, EQV6, EQV7), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // inter-bucket (residual)
  public void testEQV11() {
    Assert.assertEquals(new BigDecimal("7261782938"), Simm.calculateStandard(Arrays.asList(EQV4, EQV5, EQV6, EQV7, EQV8, EQV9, EQV10), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // inter-bucket, CR
  public void testEQV12() {
    Assert.assertEquals(new BigDecimal("18278596023"), Simm.calculateStandard(Arrays.asList(EQV1, EQV2, EQV3, EQV4, EQV5, EQV6, EQV7, EQV8, EQV9, EQV10), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight (residual), negative
  public void testCNQV1() {
    Assert.assertEquals(new BigDecimal("6210000"), Simm.calculateStandard(Arrays.asList(CNQV1), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testCNQV2() {
    Assert.assertEquals(new BigDecimal("6632694"), Simm.calculateStandard(Arrays.asList(CNQV6), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testCNQV3() {
    Assert.assertEquals(new BigDecimal("9990000"), Simm.calculateStandard(Arrays.asList(CNQV7), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual), negative (No Curvature)
  public void testCNQV4() {
    Assert.assertEquals(new BigDecimal("14170743"), Simm.calculateStandard(Arrays.asList(CNQV3, CNQV4), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual)
  public void testCNQV5() {
    Assert.assertEquals(new BigDecimal("13658371"), Simm.calculateStandard(Arrays.asList(CNQV1, CNQV3), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual)
  public void testCNQV6() {
    Assert.assertEquals(new BigDecimal("19629425"), Simm.calculateStandard(Arrays.asList(CNQV2, CNQV4), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual)
  public void testCNQV7() {
    Assert.assertEquals(new BigDecimal("20898727"), Simm.calculateStandard(Arrays.asList(CNQV1, CNQV2, CNQV3, CNQV4, CNQV5), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight (residual), negative
  public void testCQV1() {
    Assert.assertEquals(new BigDecimal("53811725"), Simm.calculateStandard(Arrays.asList(CQV1), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testCQV2() {
    Assert.assertEquals(new BigDecimal("5908978"), Simm.calculateStandard(Arrays.asList(CQV6), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testCQV3() {
    Assert.assertEquals(new BigDecimal("13500000"), Simm.calculateStandard(Arrays.asList(CQV7), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual), negative (No Curvature)
  public void testCQV4() {
    Assert.assertEquals(new BigDecimal("14287057"), Simm.calculateStandard(Arrays.asList(CQV3, CQV4), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual)
  public void testCQV5() {
    Assert.assertEquals(new BigDecimal("54180306"), Simm.calculateStandard(Arrays.asList(CQV1, CQV3), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual)
  public void testCQV6() {
    Assert.assertEquals(new BigDecimal("12354863"), Simm.calculateStandard(Arrays.asList(CQV2, CQV4), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual)
  public void testCQV7() {
    Assert.assertEquals(new BigDecimal("57583035"), Simm.calculateStandard(Arrays.asList(CQV1, CQV2, CQV3, CQV4, CQV5), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight, CR
  public void testCMV1() {
    Assert.assertEquals(new BigDecimal("5502933299"), Simm.calculateStandard(Arrays.asList(CMV1), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight, CR
  public void testCMV2() {
    Assert.assertEquals(new BigDecimal("193811031"), Simm.calculateStandard(Arrays.asList(CMV4), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight, negative
  public void testCMV3() {
    Assert.assertEquals(new BigDecimal("131560191"), Simm.calculateStandard(Arrays.asList(CMV6), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (netting)
  public void testCMV4() {
    Assert.assertEquals(new BigDecimal("5087508748"), Simm.calculateStandard(Arrays.asList(CMV1, CMV2), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (netting/only netting on same qualifier)
  public void testCMV5() {
    Assert.assertEquals(new BigDecimal("5296449605"), Simm.calculateStandard(Arrays.asList(CMV1, CMV2, CMV3), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (netting)
  public void testCMV6() {
    Assert.assertEquals(new BigDecimal("10067405222"), Simm.calculateStandard(Arrays.asList(CMV4, CMV5), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // inter-bucket
  public void testCMV7() {
    Assert.assertEquals(new BigDecimal("11968925376"), Simm.calculateStandard(Arrays.asList(CMV1, CMV2, CMV4, CMV5), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // inter-bucket
  public void testCMV8() {
    Assert.assertEquals(new BigDecimal("12012068652"), Simm.calculateStandard(Arrays.asList(CMV1, CMV2, CMV3, CMV4, CMV5, CMV6), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // multiple product classes
  public void testRisk1() {
    List<Sensitivity> s = Arrays.asList(CMV1, CMV2, CMV3, CMV4, CMV5, CMV6, CQV1, CQV2, CQV3, CQV4, CQV5, CNQV1, CNQV2, CNQV3, CNQV4, CNQV5, EQV1, EQV2, EQV3, EQV4, EQV5, EQV6, EQV7, EQV8, EQV9, EQV10, FXV1, FXV2, FXV3, FXV4, FXV5, IRV1, IRV2, IRV3, IRV4, IRV5, IRV6, IRV7);
    Assert.assertEquals(new BigDecimal("31103027174"), Simm.calculateStandard(s, FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test
  public void testInflationVolListInverted() {
    List<Sensitivity> sensitivities = inflationVolList.stream().map(s -> new Sensitivity(s.getProductClass(), s.getRiskType(), s.getQualifier(), s.getBucket(), s.getLabel1(), s.getLabel2(), s.getAmount().negate())).collect(Collectors.toList());
    Assert.assertEquals(new BigDecimal("2356664"), Simm.calculateStandard(sensitivities, FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

  @Test
  public void testInflationVolList() {
    Assert.assertEquals(new BigDecimal("114411.06"), Simm.calculateStandard(inflationVolList, FxRate.USD).setScale(2, RoundingMode.HALF_UP));
  }

}
