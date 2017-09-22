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
import com.acadiasoft.simm.model.addon.ProductMultiplier;
import com.acadiasoft.simm.model.product.ProductClass;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alec.stewart on 8/15/17.
 */
public class AcadiaDeltaUnitTestV2_0 extends AbstractAcadiaUnitTestV2_0 {

  private final SIMM simm = new SIMM();

  @Test // tested: regular vol
  public void testIR1() {
    Assert.assertEquals(new BigDecimal("13800000000"), simm.calculateStandard(Arrays.asList(IR1)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: regular vol, CR (well traded)
  public void testIR2() {
    Assert.assertEquals(new BigDecimal("17816455510"), simm.calculateStandard(Arrays.asList(IR2)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: regular vol, CR (less traded, inflation)
  public void testIR3() {
    Assert.assertEquals(new BigDecimal("1428435708"), simm.calculateStandard(Arrays.asList(IR6)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: low vol
  public void testIR4() {
    Assert.assertEquals(new BigDecimal("230000000"), simm.calculateStandard(Arrays.asList(IR8)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: high vol, CR
  public void testIR5() {
    Assert.assertEquals(new BigDecimal("2940918224"), simm.calculateStandard(Arrays.asList(IR9)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (different sub-curve)
  public void testIR6() {
    Assert.assertEquals(new BigDecimal("12499951360"), simm.calculateStandard(Arrays.asList(IR1, IR3)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (same sub-curve)
  public void testIR7() {
    Assert.assertEquals(new BigDecimal("2133397611"), simm.calculateStandard(Arrays.asList(IR7, IR8)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (XCcy to Inflation), CR (XCcy not in sum)
  public void testIR8() {
    Assert.assertEquals(new BigDecimal("5973273809"), simm.calculateStandard(Arrays.asList(IR4, IR5)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (multiple), CR (XCcy not scaled)
  public void testIR9() {
    Assert.assertEquals(new BigDecimal("29975342697"), simm.calculateStandard(Arrays.asList(IR1, IR2, IR3, IR4, IR5)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket
  public void testIR10() {
    Assert.assertEquals(new BigDecimal("30233106304"), simm.calculateStandard(Arrays.asList(IR1, IR2, IR3, IR4, IR5, IR6)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket (multiple)
  public void testIR11() {
    Assert.assertEquals(new BigDecimal("30347135467"), simm.calculateStandard(Arrays.asList(IR1, IR2, IR3, IR4, IR5, IR6, IR7, IR8, IR9)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: product multiplier
  public void testIR12() {
    Map<ProductClass, ProductMultiplier> multipliers = new HashMap<>();
    multipliers.put(IR10.getProductClass(), IR10);
    Assert.assertEquals(new BigDecimal("36568298237"), simm.calculateTotal(Arrays.asList(IR1, IR2, IR3, IR4, IR5, IR6, IR7, IR8, IR9), multipliers, EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: netting on same risk factor
  public void testFX1() {
    Assert.assertEquals(BigDecimal.ZERO, simm.calculateStandard(Arrays.asList(FX1, FX2)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight, CR (Cat 2)
  public void testFX2() {
    Assert.assertEquals(new BigDecimal("16826044974"), simm.calculateStandard(Arrays.asList(FX3)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: FX corr param, CR (Cat 2 & 3)
  public void testFX3() {
    Assert.assertEquals(new BigDecimal("19849079447"), simm.calculateStandard(Arrays.asList(FX3, FX4)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: no offsetting corr
  public void testFX4() {
    Assert.assertEquals(new BigDecimal("20301250082"), simm.calculateStandard(Arrays.asList(FX1, FX3, FX4)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: product multiplier, offsetting correlation
  public void testFX5() {
    Map<ProductClass, ProductMultiplier> multipliers = new HashMap<>();
    multipliers.put(IR10.getProductClass(), IR10);
    Assert.assertEquals(new BigDecimal("23402327147"), simm.calculateTotal(Arrays.asList(FX2, FX3, FX4), multipliers, EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: product multiplier, Risk Corr (FX to IR)
  public void testRisk1() {
    Map<ProductClass, ProductMultiplier> multipliers = new HashMap<>();
    multipliers.put(IR10.getProductClass(), IR10);
    Assert.assertEquals(new BigDecimal("47897411221"), simm.calculateTotal(Arrays.asList(IR1, IR2, IR3, IR4, IR5, IR6, IR7, IR8, IR9, FX1, FX2, FX3, FX4), multipliers, EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testEQ1() {
    Assert.assertEquals(new BigDecimal("64000000"), simm.calculateStandard(Arrays.asList(EQ1)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight, CR
  public void testEQ2() {
    Assert.assertEquals(new BigDecimal("196946386"), simm.calculateStandard(Arrays.asList(EQ2)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testEQ3() {
    Assert.assertEquals(new BigDecimal("180000000"), simm.calculateStandard(Arrays.asList(EQ3)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight, CR
  public void testEQ4() {
    Assert.assertEquals(new BigDecimal("622992456"), simm.calculateStandard(Arrays.asList(EQ4)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight (Residual)
  public void testEQ5() {
    Assert.assertEquals(new BigDecimal("17920000"), simm.calculateStandard(Arrays.asList(EQ11)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (no offsets)
  public void testEQ6() {
    Assert.assertEquals(new BigDecimal("216748423"), simm.calculateStandard(Arrays.asList(EQ1, EQ2)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (offsetting)
  public void testEQ7() {
    Assert.assertEquals(new BigDecimal("180897761"), simm.calculateStandard(Arrays.asList(EQ3, EQ5)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (offsetting, CR corr)
  public void testEQ8() {
    Assert.assertEquals(new BigDecimal("628635666"), simm.calculateStandard(Arrays.asList(EQ3, EQ4, EQ5)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (Residual)
  public void testEQ9() {
    Assert.assertEquals(new BigDecimal("32266490"), simm.calculateStandard(Arrays.asList(EQ10, EQ11)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket (offsetting)
  public void testEQ10() {
    Assert.assertEquals(new BigDecimal("183305128"), simm.calculateStandard(Arrays.asList(EQ1, EQ3, EQ7, EQ9)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket (offsetting, CR corr)
  public void testEQ11() {
    Assert.assertEquals(new BigDecimal("702970788"), simm.calculateStandard(Arrays.asList(EQ1, EQ2, EQ4, EQ5, EQ6, EQ8)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: multiple
  public void testEQ12() {
    Assert.assertEquals(new BigDecimal("752834838"), simm.calculateStandard(Arrays.asList(EQ1, EQ2, EQ3, EQ4, EQ5, EQ6, EQ7, EQ8, EQ9, EQ10, EQ11)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: product multiplier
  public void testEQ13() {
    Map<ProductClass, ProductMultiplier> multipliers = new HashMap<>();
    multipliers.put(EQ12.getProductClass(), EQ12);
    Assert.assertEquals(new BigDecimal("764127361"), simm.calculateTotal(Arrays.asList(EQ1, EQ2, EQ3, EQ4, EQ5, EQ6, EQ7, EQ8, EQ9, EQ10, EQ11), multipliers, EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCQ1() {
    Assert.assertEquals(new BigDecimal("87208160"), simm.calculateStandard(Arrays.asList(CQ1)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCQ2() {
    Assert.assertEquals(new BigDecimal("1507881164"), simm.calculateStandard(Arrays.asList(CQ5)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCQ3() {
    Assert.assertEquals(new BigDecimal("165182515"), simm.calculateStandard(Arrays.asList(CQ7)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCQ4() {
    Assert.assertEquals(new BigDecimal("8279805095"), simm.calculateStandard(Arrays.asList(CQ11)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCQ5() {
    Assert.assertEquals(new BigDecimal("2296465050"), simm.calculateStandard(Arrays.asList(CQ15)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: same issuer/seniority (intra-bucket)
  public void testCQ6() {
    Assert.assertEquals(new BigDecimal("310337316"), simm.calculateStandard(Arrays.asList(CQ1, CQ2, CQ3)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: same issuer/seniority, CR (intra-bucket)
  public void testCQ7() {
    Assert.assertEquals(new BigDecimal("5312108091"), simm.calculateStandard(Arrays.asList(CQ1, CQ3)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: different & same issuer/seniority (intra-bucket)
  public void testCQ8() {
    Assert.assertEquals(new BigDecimal("772043452"), simm.calculateStandard(Arrays.asList(CQ1, CQ2, CQ3, CQ4)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: different issuer/seniority (same tenor) (intra-bucket)
  public void testCQ9() {
    Assert.assertEquals(new BigDecimal("1464992909"), simm.calculateStandard(Arrays.asList(CQ5, CQ6)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: multiple different issuer/seniority (intra-bucket)
  public void testCQ10() {
    Assert.assertEquals(new BigDecimal("1064135708"), simm.calculateStandard(Arrays.asList(CQ8, CQ9, CQ10)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: CR (netting to be under threshold)
  public void testCQ11() {
    Assert.assertEquals(new BigDecimal("298690454"), simm.calculateStandard(Arrays.asList(CQ11, CQ12, CQ13)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: CR (netting to be over threshold)
  public void testCQ12() {
    Assert.assertEquals(new BigDecimal("3308459528"), simm.calculateStandard(Arrays.asList(CQ11, CQ12)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket
  public void testCQ13() {
    Assert.assertEquals(new BigDecimal("1425891746"), simm.calculateStandard(Arrays.asList(CQ1, CQ2, CQ3, CQ4, CQ7, CQ8, CQ9, CQ10)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket (multiple)
  public void testCQ14() {
    Assert.assertEquals(new BigDecimal("1678377529"), simm.calculateStandard(Arrays.asList(CQ1, CQ2, CQ3, CQ4, CQ5, CQ6, CQ7, CQ8, CQ9, CQ10)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (Residual)
  public void testCQ15() {
    Assert.assertEquals(new BigDecimal("3277625297"), simm.calculateStandard(Arrays.asList(CQ14, CQ15)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket (multiple w/ residual)
  public void testCQ16() {
    Assert.assertEquals(new BigDecimal("4983246791"), simm.calculateStandard(Arrays.asList(CQ1, CQ2, CQ3, CQ4, CQ5, CQ6, CQ7, CQ8, CQ9, CQ10, CQ11, CQ12, CQ13, CQ14, CQ15)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: product multiplier
  public void testCQ17() {
    Map<ProductClass, ProductMultiplier> multipliers = new HashMap<>();
    multipliers.put(CQ16.getProductClass(), CQ16);
    Assert.assertEquals(new BigDecimal("5531403938"), simm.calculateTotal(Arrays.asList(CQ1, CQ2, CQ3, CQ4, CQ5, CQ6, CQ7, CQ8, CQ9, CQ10, CQ11, CQ12, CQ13, CQ14, CQ15), multipliers, EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testBC1() {
    Assert.assertEquals(new BigDecimal("40000000"), simm.calculateStandard(Arrays.asList(BC1)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: netting
  public void testBC2() {
    Assert.assertEquals(new BigDecimal("20000000"), simm.calculateStandard(Arrays.asList(BC1, BC2)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket
  public void testBC3() {
    Assert.assertEquals(new BigDecimal("90221949"), simm.calculateStandard(Arrays.asList(BC1, BC2, BC3)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (multiple)
  public void testBC4() {
    Assert.assertEquals(new BigDecimal("93914855"), simm.calculateStandard(Arrays.asList(BC1, BC2, BC3, BC4)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: Base Corr only in Credit Qualifying Risk Class
  public void testRisk2() {
    Map<ProductClass, ProductMultiplier> multipliers = new HashMap<>();
    multipliers.put(CQ16.getProductClass(), CQ16);
    List<Sensitivity> s = Arrays.asList(CQ1, CQ2, CQ3, CQ4, CQ5, CQ6, CQ7, CQ8, CQ9, CQ10, CQ11, CQ12, CQ13, CQ14, CQ15, BC1, BC2, BC3, BC4);
    Assert.assertEquals(new BigDecimal("5635649427"), simm.calculateTotal(s, multipliers, EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCNQ1() {
    Assert.assertEquals(new BigDecimal("420000000"), simm.calculateStandard(Arrays.asList(CNQ1)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCNQ2() {
    Assert.assertEquals(new BigDecimal("9229517864"), simm.calculateStandard(Arrays.asList(CNQ4)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCNQ3() {
    Assert.assertEquals(new BigDecimal("14696938457"), simm.calculateStandard(Arrays.asList(CNQ7)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (same issuer/seniority), CR (netting to be over threshold)
  public void testCNQ4() {
    Assert.assertEquals(new BigDecimal("1300212128"), simm.calculateStandard(Arrays.asList(CNQ1, CNQ2)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (same issuer/seniority), CR (netting to be under threshold)
  public void testCNQ5() {
    Assert.assertEquals(new BigDecimal("3911010100"), simm.calculateStandard(Arrays.asList(CNQ4, CNQ5)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (different issuer/seniority)
  public void testCNQ6() {
    Assert.assertEquals(new BigDecimal("712488596"), simm.calculateStandard(Arrays.asList(CNQ1, CNQ3)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (same & different issuer/seniorty)
  public void testCNQ7() {
    Assert.assertEquals(new BigDecimal("64092433251"), simm.calculateStandard(Arrays.asList(CNQ4, CNQ5, CNQ6)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (residual)
  public void testCNQ8() {
    Assert.assertEquals(new BigDecimal("14089144758"), simm.calculateStandard(Arrays.asList(CNQ7, CNQ8)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket
  public void testCNQ9() {
    Assert.assertEquals(new BigDecimal("64258550083"), simm.calculateStandard(Arrays.asList(CNQ1, CNQ2, CNQ3, CNQ4, CNQ5, CNQ6)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket (w/ residual)
  public void testCNQ10() {
    Assert.assertEquals(new BigDecimal("78347694841"), simm.calculateStandard(Arrays.asList(CNQ1, CNQ2, CNQ3, CNQ4, CNQ5, CNQ6, CNQ7, CNQ8)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: product multiplier
  public void testCNQ11() {
    Map<ProductClass, ProductMultiplier> multipliers = new HashMap<>();
    multipliers.put(CQ16.getProductClass(), CQ16);
    Assert.assertEquals(new BigDecimal("86965941273"), simm.calculateTotal(Arrays.asList(CNQ1, CNQ2, CNQ3, CNQ4, CNQ5, CNQ6, CNQ7, CNQ8), multipliers, EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: Risk Corr (CQ to CNQ)
  public void testRisk3() {
    Map<ProductClass, ProductMultiplier> multipliers = new HashMap<>();
    multipliers.put(CQ16.getProductClass(), CQ16);
    List<Sensitivity> s = Arrays.asList(CQ1, CQ2, CQ3, CQ4, CQ5, CQ6, CQ7, CQ8, CQ9, CQ10, CQ11, CQ12, CQ13, CQ14, CQ15, BC1, BC2, BC3, BC4, CNQ1, CNQ2, CNQ3, CNQ4, CNQ5, CNQ6, CNQ7, CNQ8);
    Assert.assertEquals(new BigDecimal("88819486715"), simm.calculateTotal(s, multipliers, EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCM1() {
    Assert.assertEquals(new BigDecimal("570000000"), simm.calculateStandard(Arrays.asList(CM1)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCM2() {
    Assert.assertEquals(new BigDecimal("2550000000"), simm.calculateStandard(Arrays.asList(CM3)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCM3() {
    Assert.assertEquals(new BigDecimal("1300000000"), simm.calculateStandard(Arrays.asList(CM6)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight, CR (above threshold)
  public void testCM4() {
    Assert.assertEquals(new BigDecimal("34401931874"), simm.calculateStandard(Arrays.asList(CM8)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCM5() {
    Assert.assertEquals(new BigDecimal("375000000"), simm.calculateStandard(Arrays.asList(CM10)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: risk weight
  public void testCM6() {
    Assert.assertEquals(new BigDecimal("120000000"), simm.calculateStandard(Arrays.asList(CM11)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (negtive correlation)
  public void testCM7() {
    Assert.assertEquals(new BigDecimal("950000000"), simm.calculateStandard(Arrays.asList(CM1, CM2)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (positive correlation)
  public void testCM8() {
    Assert.assertEquals(new BigDecimal("2060000000"), simm.calculateStandard(Arrays.asList(CM6, CM7)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket (multiple)
  public void testCM9() {
    Assert.assertEquals(new BigDecimal("4788450689"), simm.calculateStandard(Arrays.asList(CM3, CM4, CM5)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: intra-bucket, CR (no netting for CM)
  public void testCM10() {
    Assert.assertEquals(new BigDecimal("34761126516"), simm.calculateStandard(Arrays.asList(CM8, CM9)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket
  public void testCM11() {
    Assert.assertEquals(new BigDecimal("386813909"), simm.calculateStandard(Arrays.asList(CM10, CM11)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: inter-bucket (multiple)
  public void testCM12() {
    Assert.assertEquals(new BigDecimal("35790316987"), simm.calculateStandard(Arrays.asList(CM1, CM2, CM3, CM4, CM5, CM6, CM7, CM8, CM9, CM10, CM11)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: product multiplier
  public void testCM13() {
    Map<ProductClass, ProductMultiplier> multipliers = new HashMap<>();
    multipliers.put(CM12.getProductClass(), CM12);
    Assert.assertEquals(new BigDecimal("38474590761"), simm.calculateTotal(Arrays.asList(CM1, CM2, CM3, CM4, CM5, CM6, CM7, CM8, CM9, CM10, CM11), multipliers, EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED).setScale(0, RoundingMode.HALF_UP));
  }

  @Test // tested: All delta
  public void testRisk4() {
    Map<ProductClass, ProductMultiplier> multipliers = new HashMap<>();
    multipliers.put(CM12.getProductClass(), CM12);
    multipliers.put(IR10.getProductClass(), IR10);
    multipliers.put(EQ12.getProductClass(), EQ12);
    multipliers.put(CQ16.getProductClass(), CQ16);
    List<Sensitivity> s = Arrays.asList(CM1, CM2, CM3, CM4, CM5, CM6, CM7, CM8, CM9, CM10, CM11, CQ1, CQ2, CQ3, CQ4, CQ5, CQ6, CQ7, CQ8, CQ9, CQ10, CQ11, CQ12, CQ13, CQ14, CQ15, BC1, BC2, BC3, BC4, CNQ1, CNQ2, CNQ3, CNQ4, CNQ5, CNQ6, CNQ7, CNQ8, EQ1, EQ2, EQ3, EQ4, EQ5, EQ6, EQ7, EQ8, EQ9, EQ10, EQ11, IR1, IR2, IR3, IR4, IR5, IR6, IR7, IR8, IR9, FX1, FX2, FX3, FX4);
    Assert.assertEquals(new BigDecimal("175955616059"), simm.calculateTotal(s, multipliers, EMPTY_FACTORS, EMPTY_NOTIONALS, ZERO_FIXED).setScale(0, RoundingMode.HALF_UP));
  }

}
