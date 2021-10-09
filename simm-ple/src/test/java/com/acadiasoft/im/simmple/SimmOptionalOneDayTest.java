/*
 * Copyright (c) 2021 AcadiaSoft, Inc.
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

package com.acadiasoft.im.simmple;

import com.acadiasoft.im.simm.config.HoldingPeriod;
import com.acadiasoft.im.simm.config.SimmCalculationType;
import com.acadiasoft.im.simmple.config.ImRole;
import com.acadiasoft.im.simmple.config.SimmpleConfig;
import com.acadiasoft.im.simmple.engine.Simmple;
import com.acadiasoft.im.simmple.model.Crif;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class SimmOptionalOneDayTest implements SimmOptionalCrifMixin {
  
  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight with each sensitivity having a unique applicable regulation
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testJ1() {
    List<Crif> sensitivities = Arrays.asList(JS_IR_47, JS_IR_48);
    SimmpleConfig config = SimmpleConfig.Builder()
      .calculationCurrency("USD")
      .holdingPeriod(HoldingPeriod.ONE_DAY)
      .imRole(ImRole.SECURED)
      .simmCalculationType(SimmCalculationType.TOTAL)
      .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("32000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight with one sensitivity having multiple applicable regulations
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testJ2() {
    List<Crif> sensitivities = Arrays.asList(JS_IR_49, JS_IR_50, JS_IR_51);
    SimmpleConfig config = SimmpleConfig.Builder()
      .calculationCurrency("USD")
      .holdingPeriod(HoldingPeriod.ONE_DAY)
      .imRole(ImRole.SECURED)
      .simmCalculationType(SimmCalculationType.TOTAL)
      .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("1892398"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight with one sensitivity having multiple applicable regulations
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testJ3() {
    List<Crif> sensitivities = Arrays.asList(JS_IR_49, JS_IR_50, JS_IR_52);
    SimmpleConfig config = SimmpleConfig.Builder()
      .calculationCurrency("USD")
      .holdingPeriod(HoldingPeriod.ONE_DAY)
      .imRole(ImRole.SECURED)
      .simmCalculationType(SimmCalculationType.TOTAL)
      .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("5100000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight with a product specific AddOn applicable under one regulation
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testJ4() {
    List<Crif> sensitivities = Arrays.asList(JS_IR_53, JS_IR_54, JS_AN_9, JS_AN_10);
    SimmpleConfig config = SimmpleConfig.Builder()
      .calculationCurrency("USD")
      .holdingPeriod(HoldingPeriod.ONE_DAY)
      .imRole(ImRole.SECURED)
      .simmCalculationType(SimmCalculationType.TOTAL)
      .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("30400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight with one sensitivity having no applicable regulation
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testJ5() {
    List<Crif> sensitivities = Arrays.asList(JS_IR_49, JS_IR_50, JS_IR_55);
    SimmpleConfig config = SimmpleConfig.Builder()
      .calculationCurrency("USD")
      .holdingPeriod(HoldingPeriod.ONE_DAY)
      .imRole(ImRole.SECURED)
      .simmCalculationType(SimmCalculationType.TOTAL)
      .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("2400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight with two applicable regulations and a product class multiplier applicable under one regulation
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testJ6() {
    List<Crif> sensitivities = Arrays.asList(JS_IR_53, JS_IR_56, JS_MUL_5);
    SimmpleConfig config = SimmpleConfig.Builder()
      .calculationCurrency("USD")
      .holdingPeriod(HoldingPeriod.ONE_DAY)
      .imRole(ImRole.SECURED)
      .simmCalculationType(SimmCalculationType.TOTAL)
      .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("25500000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight with three applicable regulations and two product class multipliers applicable under different regulations
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testJ7() {
    List<Crif> sensitivities = Arrays.asList(JS_IR_53, JS_IR_56, JS_IR_57, JS_MUL_5, JS_MUL_6);
    SimmpleConfig config = SimmpleConfig.Builder()
      .calculationCurrency("USD")
      .holdingPeriod(HoldingPeriod.ONE_DAY)
      .imRole(ImRole.SECURED)
      .simmCalculationType(SimmCalculationType.TOTAL)
      .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("25500000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: J6-J7
   * Element Tested: IR Risk Weight with three applicable regulations and two product class multipliers applicable under different regulations
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testJ8() {
    List<Crif> sensitivities = Arrays.asList(JS_IR_53, JS_IR_56, JS_IR_58, JS_MUL_5, JS_MUL_7);
    SimmpleConfig config = SimmpleConfig.Builder()
      .calculationCurrency("USD")
      .holdingPeriod(HoldingPeriod.ONE_DAY)
      .imRole(ImRole.SECURED)
      .simmCalculationType(SimmCalculationType.TOTAL)
      .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("27840000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight with two applicable regulations across product classes
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testJ9() {
    List<Crif> sensitivities = Arrays.asList(JS_IR_59, JS_IR_60, JS_IR_61);
    SimmpleConfig config = SimmpleConfig.Builder()
      .calculationCurrency("USD")
      .holdingPeriod(HoldingPeriod.ONE_DAY)
      .imRole(ImRole.SECURED)
      .simmCalculationType(SimmCalculationType.TOTAL)
      .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("56200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: J9
   * Element Tested: IR Risk Weight with two applicable regulations across product classes, with product class multipliers
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testJ10() {
    List<Crif> sensitivities = Arrays.asList(JS_IR_62, JS_IR_63, JS_MUL_8, JS_MUL_9);
    SimmpleConfig config = SimmpleConfig.Builder()
      .calculationCurrency("USD")
      .holdingPeriod(HoldingPeriod.ONE_DAY)
      .imRole(ImRole.SECURED)
      .simmCalculationType(SimmCalculationType.TOTAL)
      .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("99700000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight with sensitivity subject to SEC rules
   * Risk Measure: Delta
   * Group: Rates & Fx
   * Calculation Mode: Segregated
   */
  @Test
  public void testJS1_Segregated() {
    List<Crif> sensitivities = Arrays.asList(SS_IR_64_Seg, SS_IR_65_Seg, SS_IR_66_Seg);
    SimmpleConfig config = SimmpleConfig.Builder()
            .calculationCurrency("USD")
            .holdingPeriod(HoldingPeriod.ONE_DAY)
            .imRole(ImRole.SECURED)
            .simmCalculationType(SimmCalculationType.TOTAL)
            .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("29000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight with sensitivity subject to SEC rules
   * Risk Measure: Delta
   * Group: Rates & Fx
   * Calculation Mode: Unsegregated
   */
  @Test
  public void testJS1_Unsegregated() {
    List<Crif> sensitivities = Arrays.asList(SS_IR_64_Unseg, SS_IR_65_Unseg, SS_IR_66_Unseg);
    SimmpleConfig config = SimmpleConfig.Builder()
            .calculationCurrency("USD")
            .holdingPeriod(HoldingPeriod.ONE_DAY)
            .imRole(ImRole.SECURED)
            .simmCalculationType(SimmCalculationType.TOTAL)
            .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("72672773"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight with sensitivity subject to SEC rules
   * Risk Measure: Delta
   * Group: Rates & Fx
   * Calculation Mode: Total
   */
  @Test
  public void testJS1_Total() {
    List<Crif> sensitivities = Arrays.asList(SS_IR_64, SS_IR_65, SS_IR_66);
    SimmpleConfig config = SimmpleConfig.Builder()
            .calculationCurrency("USD")
            .holdingPeriod(HoldingPeriod.ONE_DAY)
            .imRole(ImRole.SECURED)
            .simmCalculationType(SimmCalculationType.TOTAL)
            .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("72672773"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight with sensitivity subject to SEC rules
   * Risk Measure: Delta
   * Group: Rates & Fx
   * Calculation Mode: Segregated
   */
  @Test
  public void testJS2_Segregated() {
    List<Crif> sensitivities = Arrays.asList(SS_IR_66_Seg, SS_IR_67_Seg, SS_IR_68);
    SimmpleConfig config = SimmpleConfig.Builder()
            .calculationCurrency("USD")
            .holdingPeriod(HoldingPeriod.ONE_DAY)
            .imRole(ImRole.SECURED)
            .simmCalculationType(SimmCalculationType.TOTAL)
            .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("61224302"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight with sensitivity subject to SEC rules
   * Risk Measure: Delta
   * Group: Rates & Fx
   * Calculation Mode: Unsegregated
   */
  @Test
  public void testJS2_Unsegregated() {
    List<Crif> sensitivities = Arrays.asList(SS_IR_66_Unseg, SS_IR_67_Unseg, SS_IR_68);
    SimmpleConfig config = SimmpleConfig.Builder()
            .calculationCurrency("USD")
            .holdingPeriod(HoldingPeriod.ONE_DAY)
            .imRole(ImRole.SECURED)
            .simmCalculationType(SimmCalculationType.TOTAL)
            .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("34141060"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight with sensitivity subject to SEC rules
   * Risk Measure: Delta
   * Group: Rates & Fx
   * Calculation Mode: Total
   */
  @Test
  public void testJS2_Total() {
    List<Crif> sensitivities = Arrays.asList(SS_IR_66, SS_IR_67, SS_IR_68);
    SimmpleConfig config = SimmpleConfig.Builder()
            .calculationCurrency("USD")
            .holdingPeriod(HoldingPeriod.ONE_DAY)
            .imRole(ImRole.SECURED)
            .simmCalculationType(SimmCalculationType.TOTAL)
            .build();
    BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();
    Assert.assertEquals(new BigDecimal("61224302"), amount.setScale(0, RoundingMode.HALF_UP));
  }

}
