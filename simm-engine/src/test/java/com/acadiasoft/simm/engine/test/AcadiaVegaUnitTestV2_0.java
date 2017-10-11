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

package com.acadiasoft.simm.engine.test;

import com.acadiasoft.simm.engine.SIMM;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alec.stewart on 8/23/17.
 */
public class AcadiaVegaUnitTestV2_0 extends AbstractAcadiaUnitTestV2_0 {

  private final SIMM simm = new SIMM();

  @Test // tested: vega weighting, Curvature > 0
  public void testIRV1() {
    Assert.assertEquals(new BigDecimal("276130050"), simm.calculateStandard(Arrays.asList(IRV1)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: vega weighting, Curvature < 0
  public void testIRV2() {
    Assert.assertEquals(new BigDecimal("63000000"), simm.calculateStandard(Arrays.asList(IRV2)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: No netting in IRVol
  public void testIRV3() {
    Assert.assertEquals(new BigDecimal("13863000000"), simm.calculateStandard(Arrays.asList(IR1, IRV2)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: vega weighting (inflation), Curvature > 0
  public void testIRV4() {
    Assert.assertEquals(new BigDecimal("224633128"), simm.calculateStandard(Arrays.asList(IRV7)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: netting for InflationVol
  public void testIRV5() {
    Assert.assertEquals(new BigDecimal("73500000"), simm.calculateStandard(Arrays.asList(IRV5, IRV6)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: vol weight in CR
  public void testIRV6() {
    Assert.assertEquals(new BigDecimal("30381250"), simm.calculateStandard(Arrays.asList(IRV3, IRV4)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket
  public void testIRV7() {
    Assert.assertEquals(new BigDecimal("410307997"), simm.calculateStandard(Arrays.asList(IRV1, IRV2, IRV7)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: multiple buckets
  public void testIRV8() {
    Assert.assertEquals(new BigDecimal("492798022"), simm.calculateStandard(Arrays.asList(IRV1, IRV2, IRV3, IRV4, IRV5, IRV6, IRV7)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: vega weighting, Curvature > 0
  public void testFXV1() {
    Assert.assertEquals(new BigDecimal("203596272"), simm.calculateStandard(Arrays.asList(FXV1)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: vega weighting, Curvature < 0
  public void testFXV2() {
    Assert.assertEquals(new BigDecimal("89089559"), simm.calculateStandard(Arrays.asList(FXV5)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: netting over tenors, order or currency pair doesn't matter, CR (vol weighted values in CR)
  public void testFXV3() {
    Assert.assertEquals(new BigDecimal("571387908"), simm.calculateStandard(Arrays.asList(FXV1, FXV2)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: netting over tenors, order or currency pair doesn't matter, CR (netting to be below threshold)
  public void testFXV4() {
    Assert.assertEquals(new BigDecimal("203579002"), simm.calculateStandard(Arrays.asList(FXV1, FXV2, FXV3)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // multiple, CR (no netting across risk factors)
  public void testFXV5() {
    Assert.assertEquals(new BigDecimal("742000935"), simm.calculateStandard(Arrays.asList(FXV1, FXV2, FXV3, FXV4, FXV5)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testEQV1() {
    Assert.assertEquals(new BigDecimal("227661155"), simm.calculateStandard(Arrays.asList(EQV1)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testEQV2() {
    Assert.assertEquals(new BigDecimal("962427404"), simm.calculateStandard(Arrays.asList(EQV4)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testEQV3() {
    Assert.assertEquals(new BigDecimal("269639130"), simm.calculateStandard(Arrays.asList(EQV6)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testEQV4() {
    Assert.assertEquals(new BigDecimal("219135293"), simm.calculateStandard(Arrays.asList(EQV7)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight residual
  public void testEQV5() {
    Assert.assertEquals(new BigDecimal("4585900234"), simm.calculateStandard(Arrays.asList(EQV10)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (netting)
  public void testEQV6() {
    Assert.assertEquals(new BigDecimal("19973269"), simm.calculateStandard(Arrays.asList(EQV1, EQV2)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (netting), (CR)
  public void testEQV7() {
    Assert.assertEquals(new BigDecimal("11916533908"), simm.calculateStandard(Arrays.asList(EQV1, EQV2, EQV3)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket
  public void testEQV8() {
    Assert.assertEquals(new BigDecimal("1109238963"), simm.calculateStandard(Arrays.asList(EQV4, EQV5)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // residual
  public void testEQV9() {
    Assert.assertEquals(new BigDecimal("4930984984"), simm.calculateStandard(Arrays.asList(EQV8, EQV9, EQV10)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // inter-bucket
  public void testEQV10() {
    Assert.assertEquals(new BigDecimal("1176841447"), simm.calculateStandard(Arrays.asList(EQV4, EQV5, EQV6, EQV7)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // inter-bucket (residual)
  public void testEQV11() {
    Assert.assertEquals(new BigDecimal("6107826430"), simm.calculateStandard(Arrays.asList(EQV4, EQV5, EQV6, EQV7, EQV8, EQV9, EQV10)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // inter-bucket, CR
  public void testEQV12() {
    Assert.assertEquals(new BigDecimal("17275352551"), simm.calculateStandard(Arrays.asList(EQV1, EQV2, EQV3, EQV4, EQV5, EQV6, EQV7, EQV8, EQV9, EQV10)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight (residual), negative
  public void testCNQV1() {
    Assert.assertEquals(new BigDecimal("6210000"), simm.calculateStandard(Arrays.asList(CNQV1)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testCNQV2() {
    Assert.assertEquals(new BigDecimal("6632694"), simm.calculateStandard(Arrays.asList(CNQV6)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testCNQV3() {
    Assert.assertEquals(new BigDecimal("9990000"), simm.calculateStandard(Arrays.asList(CNQV7)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual), negative (No Curvature)
  public void testCNQV4() {
    Assert.assertEquals(new BigDecimal("14170743"), simm.calculateStandard(Arrays.asList(CNQV3, CNQV4)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual)
  public void testCNQV5() {
    Assert.assertEquals(new BigDecimal("13658371"), simm.calculateStandard(Arrays.asList(CNQV1, CNQV3)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual)
  public void testCNQV6() {
    Assert.assertEquals(new BigDecimal("19629425"), simm.calculateStandard(Arrays.asList(CNQV2, CNQV4)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual)
  public void testCNQV7() {
    Assert.assertEquals(new BigDecimal("20898727"), simm.calculateStandard(Arrays.asList(CNQV1, CNQV2, CNQV3, CNQV4, CNQV5)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight (residual), negative
  public void testCQV1() {
    Assert.assertEquals(new BigDecimal("53811725"), simm.calculateStandard(Arrays.asList(CQV1)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testCQV2() {
    Assert.assertEquals(new BigDecimal("5908978"), simm.calculateStandard(Arrays.asList(CQV6)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight
  public void testCQV3() {
    Assert.assertEquals(new BigDecimal("13500000"), simm.calculateStandard(Arrays.asList(CQV7)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual), negative (No Curvature)
  public void testCQV4() {
    Assert.assertEquals(new BigDecimal("14287057"), simm.calculateStandard(Arrays.asList(CQV3, CQV4)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual)
  public void testCQV5() {
    Assert.assertEquals(new BigDecimal("54180306"), simm.calculateStandard(Arrays.asList(CQV1, CQV3)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual)
  public void testCQV6() {
    Assert.assertEquals(new BigDecimal("12354863"), simm.calculateStandard(Arrays.asList(CQV2, CQV4)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (residual)
  public void testCQV7() {
    Assert.assertEquals(new BigDecimal("57583035"), simm.calculateStandard(Arrays.asList(CQV1, CQV2, CQV3, CQV4, CQV5)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight, CR
  public void testCMV1() {
    Assert.assertEquals(new BigDecimal("5399472035"), simm.calculateStandard(Arrays.asList(CMV1)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight, CR
  public void testCMV2() {
    Assert.assertEquals(new BigDecimal("236630885"), simm.calculateStandard(Arrays.asList(CMV4)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // risk weight, negative
  public void testCMV3() {
    Assert.assertEquals(new BigDecimal("200171662"), simm.calculateStandard(Arrays.asList(CMV6)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (netting)
  public void testCMV4() {
    Assert.assertEquals(new BigDecimal("4846169490"), simm.calculateStandard(Arrays.asList(CMV1, CMV2)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (netting/only netting on same qualifier)
  public void testCMV5() {
    Assert.assertEquals(new BigDecimal("5105830360"), simm.calculateStandard(Arrays.asList(CMV1, CMV2, CMV3)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // intra-bucket (netting)
  public void testCMV6() {
    Assert.assertEquals(new BigDecimal("9789696526"), simm.calculateStandard(Arrays.asList(CMV4, CMV5)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // inter-bucket
  public void testCMV7() {
    Assert.assertEquals(new BigDecimal("11627349253"), simm.calculateStandard(Arrays.asList(CMV1, CMV2, CMV4, CMV5)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // inter-bucket
  public void testCMV8() {
    Assert.assertEquals(new BigDecimal("11662007098"), simm.calculateStandard(Arrays.asList(CMV1, CMV2, CMV3, CMV4, CMV5, CMV6)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // multiple product classes
  public void testRisk1() {
    List<Sensitivity> s = Arrays.asList(CMV1, CMV2, CMV3, CMV4, CMV5, CMV6, CQV1, CQV2, CQV3, CQV4, CQV5, CNQV1, CNQV2, CNQV3, CNQV4, CNQV5, EQV1, EQV2, EQV3, EQV4, EQV5, EQV6, EQV7, EQV8, EQV9, EQV10, FXV1, FXV2, FXV3, FXV4, FXV5, IRV1, IRV2, IRV3, IRV4, IRV5, IRV6, IRV7);
    Assert.assertEquals(new BigDecimal("29972996934"), simm.calculateStandard(s).setScale(0, RoundingMode.HALF_UP));
  }

}
