/*
 * Copyright (c) 2019 AcadiaSoft, Inc.
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
import com.acadiasoft.im.simm.config.HoldingPeriod;
import com.acadiasoft.im.simm.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimmOneDayTest extends AbstractSimmTest {

  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular, 2w)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC1() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("72000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC2() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("33000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC3() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("26000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC4() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("39000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC5() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC6() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("28000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC7() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("70000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC8() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("160000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC9() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("400000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC10() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("560000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC11() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("32000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC12() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("33000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC13() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("28000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC14() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("64000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC15() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("160000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC16() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("128000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (inflation)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC17() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("94000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (xccy)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC18() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("159000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol, 2w)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC19() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3500000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC20() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5100000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC21() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2550000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC22() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC23() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC24() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC25() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("25500000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC26() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_26);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("132000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC27() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("365000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC28() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_28);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7100000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC29() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_29);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("15600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC30() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_30);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("25800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (inflation)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC31() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_31);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("141000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (xccy)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC32() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2650000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol, 2w)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC33() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("41000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC34() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_34);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("36000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC35() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_35);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8500000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC36() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_36);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC37() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_37);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("60000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC38() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_38);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("138000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC39() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_39);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC40() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_40);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("27000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC41() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_41);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("120000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC42() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_42);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("168000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC43() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_43);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("29000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC44() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_44);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("29000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (inflation)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC45() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_45);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("18800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (xccy)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC46() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_46);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5300000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C8,C9
   * Element Tested: Net Sensitivities (same tenor & subcurve, same sign)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC47() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_8, S_IR_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("560000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C4,C5
   * Element Tested: Net Sensitivities (same tenor & subcurve, diff sign)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC48() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_4, S_IR_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("26000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C8-C10,C47
   * Element Tested: Net Sensitivities (same tenor & subcurve, same sign)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC49() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_8, S_IR_9, S_IR_10, S_IR_8, S_IR_9, S_IR_10, S_IR_8, S_IR_9, S_IR_10, S_IR_8, S_IR_9, S_IR_10, S_IR_8, S_IR_9, S_IR_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5529556944"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C14-C16
   * Element Tested: Tenor Correlation (same subcurve)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC50() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_14, S_IR_15, S_IR_16, S_IR_14, S_IR_15, S_IR_16, S_IR_14, S_IR_15, S_IR_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("672822354"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C14-C18,C50
   * Element Tested: Tenor Correlation (same subcurve, w/inf & xccy)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC51() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_14, S_IR_15, S_IR_16, S_IR_14, S_IR_15, S_IR_16, S_IR_14, S_IR_15, S_IR_16, S_IR_17, S_IR_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("679286685"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C26-C28
   * Element Tested: Tenor Correlation (same subcurve)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC52() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_26, S_IR_27, S_IR_28, S_IR_26, S_IR_27, S_IR_28, S_IR_26, S_IR_27, S_IR_28);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1455657445"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C26-C28,C31,C32,C52
   * Element Tested: Tenor Correlation (same subcurve, w/inf & xccy)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC53() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_26, S_IR_27, S_IR_28, S_IR_26, S_IR_27, S_IR_28, S_IR_26, S_IR_27, S_IR_28, S_IR_31, S_IR_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1517093932"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C41-C44
   * Element Tested: Tenor & Subcurve Correlation
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC54() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_41, S_IR_42, S_IR_43, S_IR_44);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("231115303"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C41-C46,C54
   * Element Tested: Tenor & Subcurve Correlation (w/inf & xccy)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC55() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_41, S_IR_42, S_IR_43, S_IR_44, S_IR_45, S_IR_46);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("238381389"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C3,C4
   * Element Tested: Subcurve Correlation (same tenor, same sign)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC56() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_3, S_IR_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("64765577"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C6,C7
   * Element Tested: Subcurve Correlation (same tenor, diff sign)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC57() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_6, S_IR_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("42694262"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C2,C5
   * Element Tested: Tenor Correlation (diff subcurve)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC58() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_2, S_IR_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("42711089"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C11,C12
   * Element Tested: Tenor Correlation (same sign, same subcurve)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC59() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_11, S_IR_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("59040664"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C12,C13
   * Element Tested: Tenor Correlation (diff sign, same subcurve)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC60() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_12, S_IR_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("23290341"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C19-C30,C52
   * Element Tested: Tenor Correlation (all tenors and subcurves)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC61() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_19, S_IR_20, S_IR_21, S_IR_22, S_IR_23, S_IR_24, S_IR_25, S_IR_26, S_IR_27, S_IR_28, S_IR_29, S_IR_30);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("539867959"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C19-C32,C52,C53,C61
   * Element Tested: Tenor Correlation (all tenors and subcurves, w/inf & xccy)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC62() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_19, S_IR_20, S_IR_21, S_IR_22, S_IR_23, S_IR_24, S_IR_25, S_IR_26, S_IR_27, S_IR_28, S_IR_29, S_IR_30, S_IR_31, S_IR_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("610149873"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1,C22,C33
   * Element Tested: Inter bucket correlation (all pos)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC63() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_1, S_IR_22, S_IR_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("91225216"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1,C19,C33
   * Element Tested: Inter bucket correlation (one neg)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC64() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_1, S_IR_19, S_IR_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("89454514"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C2,C19,C35
   * Element Tested: Inter bucket correlation (all neg)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC65() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_2, S_IR_19, S_IR_35);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("36889429"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C3,C21,C37,C38
   * Element Tested: Inter bucket correlation (all pos)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC66() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_3, S_IR_21, S_IR_37, S_IR_38, S_IR_37, S_IR_38);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("396045933"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C66
   * Element Tested: All Inflation sensitivities
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC67() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
    addAnything(sensitivities, S_IR);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1855535167"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FX Risk Weight & correlation (net to zero)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC68() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_1, S_FX_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(BigDecimal.ZERO, amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FX Risk Weight & correlation (AmountCurrency qualifier)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC69() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_3, S_FX_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11100000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FX Risk Weight (RR) & correlation (RR)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC70() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_5, S_FX_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1674326656"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FX Risk Weight (RR) & correlation (RR)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC71() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_7, S_FX_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("379588264"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FX Risk Weight (RH) & correlation (RH)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC72() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_9, S_FX_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("868507722"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FX Risk Weight (RH) & correlation (HR)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC73() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_11, S_FX_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("119259116"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FX Risk Weight (RR) & correlation (RR)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC74() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_3, S_FX_6, S_FX_3, S_FX_6, S_FX_3, S_FX_6, S_FX_3, S_FX_6, S_FX_3, S_FX_6, S_FX_3, S_FX_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("76590000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FX Risk Weight (RR)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC75() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3885000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FX Risk Weight (RH)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC76() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_10, S_FX_10, S_FX_10, S_FX_10, S_FX_10, S_FX_10, S_FX_10, S_FX_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7296000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C69,C70,C74
   * Element Tested: FX Intercurrency Correlation (3 ccys)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC77() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_3, S_FX_4, S_FX_5, S_FX_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12012057266"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C70,C71,C75
   * Element Tested: FX Intercurrency Correlation (4 ccys)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC78() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_5, S_FX_6, S_FX_7, S_FX_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1716915621"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C70,C72,C76
   * Element Tested: FX Intercurrency Correlation (4 ccys)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC79() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_5, S_FX_6, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7141533022"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C68-C79
   * Element Tested: All FX sensitivities
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC80() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>(S_FX);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12398160554"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C80
   * Element Tested: All Rates & FX Sensitivities
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC81() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
    addAnything(sensitivities, S_IR, S_FX);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12888484511"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC82() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC83() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC84() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3780000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC85() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3780000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 3)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC86() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2700000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 3)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC87() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1500000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 4)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC88() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1980000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 4)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC89() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1100000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 5)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC90() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 5)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC91() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 6)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC92() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2160000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 7)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC93() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("22200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 8)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC94() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 9)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC95() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5580000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 10)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC96() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3300000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 11)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC97() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5220000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 12)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC98() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2700000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC99() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7560000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC100() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC101() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7560000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC102() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7560000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC103() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (base corr)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC104() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("750000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (base corr)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC105() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("300000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (base corr)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC106() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C83
   * Element Tested: CRQ Intra-bucket Correlation (same name, diff tenor)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC107() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_1, S_CRQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("21093316"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C85
   * Element Tested: CRQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC108() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_4, S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7560000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C93
   * Element Tested: CRQ Risk Weight (bkt 7)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC109() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_12, S_CRQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("44400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C95
   * Element Tested: CRQ Risk Weight (bkt 9)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC110() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_14, S_CRQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11160000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C83,C107
   * Element Tested: CRQ Intra-bucket Correlation (same name, diff tenor)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC111() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8375201"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C84,C85,C108
   * Element Tested: CRQ Intra-bucket Correlation (same name, diff ccy)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC112() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_3, S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1195341"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C86,C87
   * Element Tested: CRQ Intra-bucket Correlation (same name, diff tenor, diff ccy)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC113() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_5, S_CRQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1358308"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C88,C89
   * Element Tested: CRQ Intra-bucket Correlation (same name, same tenor, same ccy)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC114() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_7, S_CRQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("880000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C90,C91
   * Element Tested: CRQ Intra-bucket Correlation (diff name)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC115() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_9, S_CRQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1662528"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C99,C100
   * Element Tested: CRQ Intra-bucket Correlation (residual, same name, diff tenor)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC116() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_18, S_CRQ_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6560610"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C100,C101
   * Element Tested: CRQ Intra-bucket Correlation (residual, diff name)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC117() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_19, S_CRQ_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6560610"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C84,C86
   * Element Tested: CRQ Inter-bucket Correlation (same sign, pos)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC118() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_3, S_CRQ_3, S_CRQ_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9122644"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C84
   * Element Tested: CRQ Inter-bucket Correlation (same sign, pos)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC119() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("14823584"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C83,C85,C108
   * Element Tested: CRQ Inter-bucket Correlation (same sign, neg)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC120() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_2, S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7275455"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C85,C108
   * Element Tested: CRQ Inter-bucket Correlation (diff sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC121() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11684099"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C85,C99,C108,C121
   * Element Tested: CRQ Inter-bucket Correlation (diff sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC122() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_4, S_CRQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19244099"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C84,C86,C88,C90,C92,C118,C119
   * Element Tested: CRQ Inter-bucket Correlation (bkts 1-3, 4-6)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC123() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_7, S_CRQ_9, S_CRQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19640973"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C84,C86,C93-C95,C109,C110,C118,C119
   * Element Tested: CRQ Inter-bucket Correlation (bkts 1-3, 7-9)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC124() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_12, S_CRQ_13, S_CRQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("21490262"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C84,C86,C96-C98,C118,C119
   * Element Tested: CRQ Inter-bucket Correlation (bkts 1-3, 10-12)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC125() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_15, S_CRQ_16, S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16975459"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C88,C90,C92-C95,C109,C110
   * Element Tested: CRQ Inter-bucket Correlation (bkts 4-6, 7-9)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC126() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_7, S_CRQ_9, S_CRQ_11, S_CRQ_12, S_CRQ_13, S_CRQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("20983234"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C88,C90,C92,C96-C98
   * Element Tested: CRQ Inter-bucket Correlation (bkts 4-6, 10-12)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC127() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_7, S_CRQ_9, S_CRQ_11, S_CRQ_15, S_CRQ_16, S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7062252"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C93-C98,C109,C110
   * Element Tested: CRQ Inter-bucket Correlation (bkts 7-9, 10-12)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC128() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_12, S_CRQ_13, S_CRQ_14, S_CRQ_15, S_CRQ_16, S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("23090610"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C84,C86,C88,C90,C92-C98,C109,C110,C118,C119,C123-C128
   * Element Tested: CRQ Inter-bucket Correlation (all)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC129() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_7, S_CRQ_9, S_CRQ_11, S_CRQ_12, S_CRQ_13, S_CRQ_14, S_CRQ_15, S_CRQ_16, S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("23020699"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C84,C86,C88,C90,C92-C99,C109,C110,C118,C119,C123-C129
   * Element Tested: CRQ Inter-bucket Correlation (all + residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC130() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_7, S_CRQ_9, S_CRQ_11, S_CRQ_12, S_CRQ_13, S_CRQ_14, S_CRQ_15, S_CRQ_16, S_CRQ_17, S_CRQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("30580699"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C104,C105
   * Element Tested: CRQ Base Corr Netting
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC131() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_23, S_CRQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("450000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C104-C106,C131
   * Element Tested: CRQ Base Corr Correlation
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC132() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_23, S_CRQ_24, S_CRQ_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("798812"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82-C132
   * Element Tested: All Credit Qualifying (no multiplier)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC133() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>(S_CRQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("36383646"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC134() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("120000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC135() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("60000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC136() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("60000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC137() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("40000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC138() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("60000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC139() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("80000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC140() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("128000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC141() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("64000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC142() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("64000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC143() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("64000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC144() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("64000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC145() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("96000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC146() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("128000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC147() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("64000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC148() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("96000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC149() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("32000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C134,C135
   * Element Tested: CRNQ Intra-bucket correlation (same name, same sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC150() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_1, S_CRNQ_2, S_CRNQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("202938414"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C140,C143
   * Element Tested: CRNQ Intra-bucket correlation (diff name, opp sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC151() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_7, S_CRNQ_7, S_CRNQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("235672994"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C146,C148
   * Element Tested: CRNQ Intra-bucket correlation (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC152() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_13, S_CRNQ_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("194648401"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C134,C135,C150
   * Element Tested: CRNQ Intra-bucket correlation (same name, same sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC153() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_1, S_CRNQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("155537777"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C135,C136
   * Element Tested: CRNQ Intra-bucket correlation (same name, opp sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC154() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_2, S_CRNQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("64062470"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C136,C137
   * Element Tested: CRNQ Intra-bucket correlation (diff name, same sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC155() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_3, S_CRNQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("76941536"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C136,C139
   * Element Tested: CRNQ Intra-bucket correlation (diff name, opp sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC156() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_3, S_CRNQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("106957936"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C146,C147
   * Element Tested: CRNQ Intra-bucket correlation (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC157() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_13, S_CRNQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("110851252"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C134,C140
   * Element Tested: CRNQ Inter-bucket correlation (diff name, opp sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC158() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_1, S_CRNQ_1, S_CRNQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("252069832"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C134,C140,C158
   * Element Tested: CRNQ Inter-bucket correlation (same sign, pos)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC159() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_1, S_CRNQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("159879955"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C136,C141
   * Element Tested: CRNQ Inter-bucket correlation (same sign, neg)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC160() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_3, S_CRNQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("94876762"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C135,C141
   * Element Tested: CRNQ Inter-bucket correlation (diff sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC161() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_2, S_CRNQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("79939977"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C135,C141,C146,C161
   * Element Tested: CRNQ Inter-bucket correlation (w/residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC162() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_2, S_CRNQ_8, S_CRNQ_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("207939977"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C134-C162
   * Element Tested: All Credit Non Qualifying
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC163() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>(S_CRNQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("378053697"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82-C163
   * Element Tested: All Credit Qualifying and Non-Qualifying
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC164() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
    addAnything(sensitivities, S_CRQ, S_CRNQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("386620300"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC165() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("45600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC166() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC167() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC168() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 3)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC169() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 3)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC170() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9700000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 4)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC171() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 4)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC172() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 5)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC173() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("68000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 5)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC174() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 6)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC175() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("29600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 6)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC176() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("14800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 7)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC177() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("34800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 7)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC178() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 8)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC179() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("34800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 8)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC180() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 9)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC181() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3960000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 9)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC182() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("39600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 10)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC183() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 10)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC184() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 11)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC185() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7000000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 11)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC186() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("14000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 11)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC187() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC188() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("21000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC189() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("14000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC190() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_26);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC191() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13860000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC192() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_28);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2970000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165
   * Element Tested: EQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC193() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("91200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C173
   * Element Tested: EQ Risk Weight (bkt 5)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC194() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_9, S_EQ_9, S_EQ_9, S_EQ_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("272000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C182
   * Element Tested: EQ Risk Weight (bkt 9)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC195() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_18, S_EQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("79200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C183
   * Element Tested: EQ Risk Weight (bkt 10)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC196() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_19, S_EQ_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("38400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C185
   * Element Tested: EQ Risk Weight (bkt 11)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC197() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("70000000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C191
   * Element Tested: EQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC198() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_27, S_EQ_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("27720000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C166,C193
   * Element Tested: EQ Intra Bucket Correlation (Bkt 1)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC199() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("47413281"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C167,C168
   * Element Tested: EQ Intra Bucket Correlation (Bkt 2)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC200() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_3, S_EQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17132706"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C169,C170
   * Element Tested: EQ Intra Bucket Correlation (Bkt 3)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC201() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_5, S_EQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19106784"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C171,C172
   * Element Tested: EQ Intra Bucket Correlation (Bkt 4)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC202() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_7, S_EQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("20575714"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C173,C174,C194
   * Element Tested: EQ Intra Bucket Correlation (Bkt 5)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC203() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_9, S_EQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("71964436"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C175,C176
   * Element Tested: EQ Intra Bucket Correlation (Bkt 6)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC204() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_11, S_EQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("28850511"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C177,C178
   * Element Tested: EQ Intra Bucket Correlation (Bkt 7)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC205() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_13, S_EQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("33378987"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C179,C180
   * Element Tested: EQ Intra Bucket Correlation (Bkt 8)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC206() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_15, S_EQ_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("43465186"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C181,C182,C195
   * Element Tested: EQ Intra Bucket Correlation (Bkt 9)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC207() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_17, S_EQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("39081810"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C183,C184,C196
   * Element Tested: EQ Intra Bucket Correlation (Bkt 10)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC208() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_19, S_EQ_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19860634"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C186,C187
   * Element Tested: EQ Intra Bucket Correlation (Bkt 11)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC209() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_22, S_EQ_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12907362"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C189,C190
   * Element Tested: EQ Intra Bucket Correlation (Bkt 12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC210() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_25, S_EQ_26);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12907362"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C166,C193,C199
   * Element Tested: EQ Intra Bucket Correlation (Bkt 1)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC211() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_1, S_EQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("92720000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C168,C193
   * Element Tested: EQ Inter-bucket Correlation (same sign, pos)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC212() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("47750954"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C167,C170
   * Element Tested: EQ Inter-bucket Correlation (same sign, neg)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC213() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_3, S_EQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("21166776"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C167,C193
   * Element Tested: EQ Inter-bucket Correlation (diff sign)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC214() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("45838115"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C167,C191,C193,C198,C214
   * Element Tested: EQ Inter-bucket Correlation (w/residual)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC215() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_3, S_EQ_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("59698115"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C167,C169,C171,C173,C175,C193,C194,C214
   * Element Tested: EQ Inter-bucket Correlation (bks 1-3, 4-6)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC216() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_3, S_EQ_5, S_EQ_7, S_EQ_9, S_EQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("85930996"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C167,C169,C177,C179,C181,C193,C214
   * Element Tested: EQ Inter-bucket Correlation (bks 1-3, 7-9)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC217() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_3, S_EQ_5, S_EQ_13, S_EQ_15, S_EQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("66970767"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C167,C169,C183,C185,C188,C193,C196,C197,C214
   * Element Tested: EQ Inter-bucket Correlation (bks 1-3, 10-12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC218() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_3, S_EQ_5, S_EQ_19, S_EQ_21, S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7022447713"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C171,C173,C175,C177,C179,C181,C194
   * Element Tested: EQ Inter-bucket Correlation (bks 4-6, 7-9)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC219() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_7, S_EQ_9, S_EQ_11, S_EQ_13, S_EQ_15, S_EQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("79560903"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C171,C173,C175,C183,C185,C188,C194,C196,C197
   * Element Tested: EQ Inter-bucket Correlation (bks 4-6, 10-12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC220() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_7, S_EQ_9, S_EQ_11, S_EQ_19, S_EQ_21, S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7017228076"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C177,C179,C181,C183,C185,C188,C196,C197
   * Element Tested: EQ Inter-bucket Correlation (bks 7-9, 10-12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC221() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_13, S_EQ_15, S_EQ_17, S_EQ_19, S_EQ_21, S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7013793036"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C167,C169,C171,C173,C175,C177,C179,C181,C183,C185,C188,C193,C194,C196,C197,C214,C216-C221
   * Element Tested: EQ Inter-bucket Correlation (all)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC222() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_3, S_EQ_5, S_EQ_7, S_EQ_9, S_EQ_11, S_EQ_13, S_EQ_15, S_EQ_17, S_EQ_19, S_EQ_21, S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7027712679"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165-C222
   * Element Tested: All Equity Sensitivities
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC223() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>(S_EQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7035737748"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC224() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("840000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC225() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC226() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17220000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC227() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 3)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC228() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2088000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 3)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC229() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 4)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC230() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("64000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 4)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC231() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 5)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC232() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("100000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 5)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC233() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 6)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC234() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5915000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 6)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC235() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9100000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 7)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC236() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("80000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 8)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC237() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3690000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 8)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC238() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12300000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 9)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC239() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("69000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 9)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC240() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6900000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 10)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC241() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("632400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 10)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC242() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 11)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC243() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1920000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 11)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC244() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 12)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC245() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4560000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 12)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC246() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5700000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 13)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC247() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("100000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 13)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC248() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 14)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC249() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_26);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("48000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 14)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC250() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 15)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC251() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_28);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("39000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 15)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC252() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_29);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3900000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 16)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC253() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_30);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("310000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 16)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC254() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_31);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("24800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 17)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC255() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6110000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 17)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC256() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C224
   * Element Tested: CM Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC257() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8400000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C226
   * Element Tested: CM Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC258() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("172200000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C228
   * Element Tested: CM Risk Weight (bkt 3)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC259() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("20880000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C234
   * Element Tested: CM Risk Weight (bkt 6)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC260() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("59150000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C237
   * Element Tested: CM Risk Weight (bkt 8)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC261() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("36900000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C241
   * Element Tested: CM Risk Weight (bkt 10)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC262() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_18, S_CM_18, S_CM_18, S_CM_18, S_CM_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3162000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C243
   * Element Tested: CM Risk Weight (bkt 11)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC263() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19200000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C245
   * Element Tested: CM Risk Weight (bkt 12)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC264() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("45600000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C247
   * Element Tested: CM Risk Weight (bkt 13)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC265() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1000000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C253
   * Element Tested: CM Risk Weight (bkt 16)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC266() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3100000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C255
   * Element Tested: CM Risk Weight (bkt 17)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC267() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("61100000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C224,C225,C257
   * Element Tested: CM Intra Bucket Correlation (Bkt 1)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC268() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_1, S_CM_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("841585171"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C226,C227,C258
   * Element Tested: CM Intra Bucket Correlation (Bkt 2)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC269() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_3, S_CM_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17211964077"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C228,C229,C259
   * Element Tested: CM Intra Bucket Correlation (Bkt 3)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC270() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_5, S_CM_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2082665241"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C230,C231
   * Element Tested: CM Intra Bucket Correlation (Bkt 4)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC271() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_7, S_CM_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("70225238"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C232,C233
   * Element Tested: CM Intra Bucket Correlation (Bkt 5)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC272() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_9, S_CM_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("109909053"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C234,C235,C260
   * Element Tested: CM Intra Bucket Correlation (Bkt 6)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC273() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_11, S_CM_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5908269170"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C237,C238,C261
   * Element Tested: CM Intra Bucket Correlation (Bkt 8)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC274() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_14, S_CM_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3694322968"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C239,C240
   * Element Tested: CM Intra Bucket Correlation (Bkt 9)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC275() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_16, S_CM_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("73929886"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C241,C242,C262
   * Element Tested: CM Intra Bucket Correlation (Bkt 10)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC276() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_18, S_CM_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("630783503"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C243,C244,C263
   * Element Tested: CM Intra Bucket Correlation (Bkt 11)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC277() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_20, S_CM_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1916615684"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C245,C246,C264
   * Element Tested: CM Intra Bucket Correlation (Bkt 12)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC278() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_22, S_CM_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4563593147"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C247,C248,C265
   * Element Tested: CM Intra Bucket Correlation (Bkt 13)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC279() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_24, S_CM_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("103126136"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C249,C250
   * Element Tested: CM Intra Bucket Correlation (Bkt 14)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC280() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_26, S_CM_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("47371890"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C251,C252
   * Element Tested: CM Intra Bucket Correlation (Bkt 15)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC281() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_28, S_CM_29);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("38608030"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C253,C254,C266
   * Element Tested: CM Intra Bucket Correlation (Bkt 16)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC282() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_30, S_CM_31);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("310990418"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C255,C256,C267
   * Element Tested: CM Intra Bucket Correlation (Bkt 17)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC283() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_32, S_CM_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6119400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C237,C241,C261,C262
   * Element Tested: CM Inter Bucket Correlation (diff signs)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC284() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_18, S_CM_18, S_CM_18, S_CM_18, S_CM_18, S_CM_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4954570254"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C226,C229,C258
   * Element Tested: CM Inter Bucket Correlation (same sign, pos)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC285() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_3, S_CM_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17225394132"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C227,C228,C259
   * Element Tested: CM Inter Bucket Correlation (same sign, neg)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC286() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_4, S_CM_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2095628167"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C226,C228,C258,C259
   * Element Tested: CM Inter Bucket Correlation (diff signs)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC287() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_3, S_CM_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("15297423783"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C226,C228,C254,C258,C259,C287
   * Element Tested: CM Inter Bucket Correlation (w/residual)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC288() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_3, S_CM_5, S_CM_31);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("15297443886"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C224,C226,C228,C230,C232,C234,C236,C237,C257-C261,C287
   * Element Tested: CM Inter Bucket Correlation (bkts 1-4, 5-8)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC289() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_1, S_CM_3, S_CM_5, S_CM_7, S_CM_9, S_CM_11, S_CM_13, S_CM_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16738543139"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C224,C226,C228,C230,C239,C241,C243,C245,C257-C259,C262-C264,C287
   * Element Tested: CM Inter Bucket Correlation (bkts 1-4, 9-12)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC290() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_1, S_CM_3, S_CM_5, S_CM_7, S_CM_16, S_CM_18, S_CM_20, S_CM_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("14533600319"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C224,C226,C228,C230,C247,C249,C251,C253,C255,C257-C259,C265-C267,C287
   * Element Tested: CM Inter Bucket Correlation (bkts 1-4, 13-17)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC291() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_1, S_CM_3, S_CM_5, S_CM_7, S_CM_24, S_CM_26, S_CM_28, S_CM_30, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19853149758"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C232,C234,C236,C237,C239,C241,C243,C245,C260-C264,C284
   * Element Tested: CM Inter Bucket Correlation (bkts 5-8, 9-12)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC292() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_9, S_CM_11, S_CM_13, S_CM_14, S_CM_16, S_CM_18, S_CM_20, S_CM_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7194881016"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C232,C234,C236,C237,C247,C249,C251,C253,C255,C260,C261,C265-C267
   * Element Tested: CM Inter Bucket Correlation (bkts 5-8, 13-17)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC293() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_9, S_CM_11, S_CM_13, S_CM_14, S_CM_24, S_CM_26, S_CM_28, S_CM_30, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8388443752"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C239,C241,C243,C245,C247,C249,C251,C253,C255,C262-C267
   * Element Tested: CM Inter Bucket Correlation (bkts 9-12, 13-17)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC294() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_16, S_CM_18, S_CM_20, S_CM_22, S_CM_24, S_CM_26, S_CM_28, S_CM_30, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7223967970"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C224,C226,C228,C230,C232,C234,C236,C237,C239,C241,C243,C245,C247,C249,C251,C253,C255,C257-C267,C284,C287,C289-C294
   * Element Tested: CM Inter Bucket Correlation (all)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC295() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_1, S_CM_3, S_CM_5, S_CM_7, S_CM_9, S_CM_11, S_CM_13, S_CM_14, S_CM_16, S_CM_18, S_CM_20, S_CM_22, S_CM_24, S_CM_26, S_CM_28, S_CM_30, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("20180294798"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C224-C295
   * Element Tested: All Commodities
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC296() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>(S_CM);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("20189029220"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C296
   * Element Tested: All Delta Sensitivities (no multiplier)
   * Risk Measure: Delta
   * Group: Global
   */
  @Test
  public void testC297() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
    addAnything(sensitivities, S_IR, S_CRQ, S_CRNQ, S_CM, S_FX, S_EQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("40367397413"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C297
   * Element Tested: All Delta Sensitivities (with multiplier)
   * Risk Measure: Delta
   * Group: Global
   */
  @Test
  public void testC298() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = S_MUL;
    List<Sensitivity> sensitivities = new ArrayList<>();
    addAnything(sensitivities, S_IR, S_CRQ, S_CRNQ, S_CM, S_FX, S_EQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("43555093870"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC299() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("24731081"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC300() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8365540"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC301() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4243694"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC302() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8731081"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC303() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4257973"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC304() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2609234"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC305() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2913851"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC306() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7655403"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC307() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11310807"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC308() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("18621614"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC309() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("47864841"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC310() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("99301589"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC311() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC312() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC313() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC314() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3297477"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC315() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1673108"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC316() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("836554"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC317() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("436554"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC318() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_1, S_IRV_1, S_IRV_1, S_IRV_1, S_IRV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("123655403"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C301
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC319() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_3, S_IRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8487387"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C301,C316,C319
   * Element Tested: Intra-currency Correlation (Same sign, w/Inflation)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC320() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_3, S_IRV_3, S_IRV_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8843320"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C300
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC321() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("41827702"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C300,C315,C321
   * Element Tested: Intra-currency Correlation (Same sign, w/Inflation)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC322() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("42500077"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C303
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC323() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_5, S_IRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8515945"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C303,C323
   * Element Tested: Intra-currency Correlation (Same sign, w/Inflation)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC324() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_5, S_IRV_5, S_IRV_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8703293"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299,C307,C318
   * Element Tested: Intra-currency Correlation (Same Sign - Pos)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC325() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_1, S_IRV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("32994571"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C311,C312
   * Element Tested: Intra-currency Correlation (Same Sign - Neg)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC326() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_13, S_IRV_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7979975"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C300,C313,C321
   * Element Tested: Intra-currency Correlation (Opposite sign)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC327() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_2, S_IRV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4212757"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C300,C313,C315,C321,C322,C327
   * Element Tested: Intra-currency Correlation (Opposite sign, w/Inflation)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC328() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_2, S_IRV_15, S_IRV_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5086033"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299,C300,C318,C321
   * Element Tested: Inter-currency Correlation
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC329() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_1, S_IRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("27788939"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299,C303,C318,C323
   * Element Tested: Inter-currency Correlation (2 ccys)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC330() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_1, S_IRV_5, S_IRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("28143613"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299-C301,C318,C319,C321,C329
   * Element Tested: Inter-currency Correlation (3 ccys)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC331() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_1, S_IRV_2, S_IRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("29179347"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299-C331
   * Element Tested: All Interest Rate Vol Sensitivities
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC332() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>(S_IRV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("161045557"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC333() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("35395770"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC334() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("98466124"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (HR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC335() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("148379523"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC336() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("32850950"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC337() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12319106"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC338() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10508835"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC339() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9855285"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (RH) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC340() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("41292032"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C333
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC341() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("707915392"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C335
   * Element Tested: FXV Risk Weight (HR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC342() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2967590468"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C336
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC343() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("328509498"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C337
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC344() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("123191062"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C338
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC345() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("105088349"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C339
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC346() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("98552850"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C333,C334,C341
   * Element Tested: FXV Aggregate (swapped currencies)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC347() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_1, S_FXV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("133861894"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C333,C335,C341,C342
   * Element Tested: FXV Correlation (same sign, pos)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC348() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_1, S_FXV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("169780377"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C336,C337,C343,C344
   * Element Tested: FXV Correlation (same sign, neg)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC349() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_4, S_FXV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("40443042"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C335,C336,C342,C343
   * Element Tested: FXV Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC350() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_3, S_FXV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("139139083"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C335,C337,C342,C344
   * Element Tested: FXV Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC351() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_3, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("145525430"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C333-C351
   * Element Tested: All FX Vol Sensitivities
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC352() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>(S_FXV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("251247296"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC353() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11606935"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC354() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5803468"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC355() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2647245"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC356() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19344892"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC357() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3360000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC358() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("967245"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC359() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2596347"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC360() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353,C354
   * Element Tested: CRV Intra-bucket Correlation (same tenor, diff quanto, same sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC361() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_2, S_CRV_1, S_CRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("34397692"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C356,C357
   * Element Tested: CRV Intra-bucket Correlation (same name, diff tenor, diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC362() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_4, S_CRV_5, S_CRV_4, S_CRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("31924125"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C360
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC363() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_8, S_CRV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("25200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353,C354,C361
   * Element Tested: CRV Intra-bucket Correlation (same tenor, diff quanto, same sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC364() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17198846"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353,C355
   * Element Tested: CRV Intra-bucket Correlation (diff name)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC365() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12916984"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C358,C360,C363
   * Element Tested: CRV Intra-bucket Correlation (residual, same name)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC366() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_6, S_CRV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12334875"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C358,C359
   * Element Tested: CRV Intra-bucket Correlation (residual, diff name)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC367() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_6, S_CRV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3198582"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353,C355,C365
   * Element Tested: CRV Intra-bucket Correlation (diff name)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC368() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_1, S_CRV_1, S_CRV_1, S_CRV_1, S_CRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("59157423"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353,C356
   * Element Tested: CRV Inter-bucket (same sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC369() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("26342545"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353,C357
   * Element Tested: CRV Inter-bucket (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC370() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10618969"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353,C357,C358,C370
   * Element Tested: CRV Inter-bucket (w/residual)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC371() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_5, S_CRV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11586214"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353-C371
   * Element Tested: All Credit Qualifying Vol Sensitivities
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC372() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>(S_CRV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("40272940"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC373() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3868978"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC374() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2901734"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC375() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1680000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC376() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC377() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1730898"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC378() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4352601"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC379() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("865449"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC380() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2131811"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC381() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1450867"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C373
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC382() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_1, S_CNV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7737957"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C376,C377
   * Element Tested: CNV Inter-bucket Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC383() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_4, S_CNV_4, S_CNV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8387311"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C378,C380
   * Element Tested: CNV Intra-bucket Correlation (residual, diff tenor)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC384() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_6, S_CNV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5745889"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C374,C375
   * Element Tested: CNV Intra-bucket Correlation (same name)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC385() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_2, S_CNV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2712579"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C373,C374,C382
   * Element Tested: CNV Intra-bucket Correlation (diff name)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC386() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_1, S_CNV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5712750"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C379,C381
   * Element Tested: CNV Intra-bucket Correlation (residual)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC387() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_7, S_CNV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2032146"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C373-C375,C382,C385,C386
   * Element Tested: CNV Intra-bucket Correlation (diff name)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC388() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_1, S_CNV_1, S_CNV_2, S_CNV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8603966"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C373,C377,C382
   * Element Tested: CNV Inter-bucket Correlation (same sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC389() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_1, S_CNV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4523949"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C374,C376
   * Element Tested: CNV Inter-bucket Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC390() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_2, S_CNV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4907596"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C374,C375,C378,C385
   * Element Tested: CNV Inter-bucket Correlation (w/residual)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC391() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_2, S_CNV_3, S_CNV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7065180"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C373-C391
   * Element Tested: All Credit Non Qualifying Vol Sensitivities
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC392() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>(S_CNV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13712411"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC393() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11963259"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC394() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4599674"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC395() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5744460"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC396() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4232760"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC397() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2116380"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC398() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("28701698"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC399() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("997722"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC400() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5007010"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC401() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("721945976"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC402() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17636501"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC403() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("280580694"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC404() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1032696"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC405() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1247153"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C393
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC406() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("239265170"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C398
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC407() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("574033967"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C399
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC408() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_7, S_EQV_7, S_EQV_7, S_EQV_7, S_EQV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4988610"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C400
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC409() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_8, S_EQV_8, S_EQV_8, S_EQV_8, S_EQV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("25035050"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C401
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC410() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("14438919516"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C404
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC411() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_12, S_EQV_12, S_EQV_12, S_EQV_12, S_EQV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5163479"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C393,C394,C406
   * Element Tested: EQV Intra-bucket Correlation (same sign, pos)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC412() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_1, S_EQV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13654809"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C396,C397
   * Element Tested: EQV Intra-bucket Correlation (same sign, neg)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC413() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_4, S_EQV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5114464"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C393,C395,C406
   * Element Tested: EQV Intra-bucket Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC414() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_1, S_EQV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9084870"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C393,C399,C406,C408
   * Element Tested: EQV Inter-bucket Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC415() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_1, S_EQV_7, S_EQV_7, S_EQV_7, S_EQV_7, S_EQV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("14781291"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C395,C396
   * Element Tested: EQV Inter-bucket Correlation (same sign)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC416() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_3, S_EQV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7692994"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C394,C398,C407
   * Element Tested: EQV Inter-bucket Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC417() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_2, S_EQV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("30300850"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C394,C398,C404,C407,C411,C417
   * Element Tested: EQV Inter-bucket Correlation (w/residual)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC418() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_2, S_EQV_6, S_EQV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("31333545"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C393-C418
   * Element Tested: All Equity Vol Sensitivities
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC419() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>(S_EQV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("868686524"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC420() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("107156612"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC421() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("25045990"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC422() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7241168"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC423() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("113100152"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC424() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("35343797"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC425() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("22048385"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC426() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("125705882"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC427() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("38631816"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC428() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5454186"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC429() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19309782"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC430() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("35522821"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC431() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19007228"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC432() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("18481283"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC433() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4051606"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC434() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5563699"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC435() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5879139"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C420
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC436() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1071566116"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C423
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC437() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2262003032"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C425
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC438() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("440967692"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C426
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC439() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2514117649"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C427
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC440() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("772636315"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C428
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC441() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_9, S_CMV_9, S_CMV_9, S_CMV_9, S_CMV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("27270928"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C429
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC442() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("386195640"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C430
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC443() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("710456416"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C431
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC444() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("380144562"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C434
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC445() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("55636994"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C432
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC446() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("369625654"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C420,C421,C436
   * Element Tested: CMV Intra-bucket Correlation (same sign, pos)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC447() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_1, S_CMV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("115735819"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C423,C424,C437
   * Element Tested: CMV Intra-bucket Correlation (same sign, neg)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC448() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_4, S_CMV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("147904396"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C421,C422
   * Element Tested: CMV Intra-bucket Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC449() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_2, S_CMV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("26038263"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C420,C422,C436
   * Element Tested: CMV Intra-bucket Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC450() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1068410069"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C420,C425,C436,C438
   * Element Tested: CMV Inter-bucket Correlation (same sign)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC451() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_1, S_CMV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("118426973"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C421,C428,C441
   * Element Tested: CMV Inter-bucket Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC452() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_2, S_CMV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("26864524"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C421,C428,C434,C441,C445,C452
   * Element Tested: CMV Inter-bucket Correlation (w/residual)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC453() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_2, S_CMV_9, S_CMV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("28360043"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C420-C453
   * Element Tested: All Commodity Vol Sensitivities
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC454() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>(S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("263629653"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299-C454
   * Element Tested: All Vega Sensitivities (no multiplier)
   * Risk Measure: Vega & Curvature
   * Group: Global
   */
  @Test
  public void testC455() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
    addAnything(sensitivities, S_IRV, S_FXV, S_CRV, S_CNV, S_EQV, S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1494102555"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299-C455
   * Element Tested: All Vega Sensitivities (with multipliers)
   * Risk Measure: Vega & Curvature
   * Group: Global
   */
  @Test
  public void testC456() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = S_MUL;
    List<Sensitivity> sensitivities = new ArrayList<>();
    addAnything(sensitivities, S_IRV, S_FXV, S_CRV, S_CNV, S_EQV, S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1710892183"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: One Trade
   * Risk Measure: Notional
   * Group: AddOn
   */
  @Test
  public void testC457() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList(S_AN_1);
    List<Notional> notional = Arrays.asList(S_AN_3);
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList();
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: Multi Trades
   * Risk Measure: Notional
   * Group: AddOn
   */
  @Test
  public void testC458() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList(S_AN_2);
    List<Notional> notional = Arrays.asList(S_AN_4, S_AN_5);
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList();
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("40000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: Fixed Amount
   * Risk Measure: Notional
   * Group: AddOn
   */
  @Test
  public void testC459() {
    List<FixedAmount> fixed = Arrays.asList(S_AN_7, S_AN_8);
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList();
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("30000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C457-C459
   * Element Tested: All Notional
   * Risk Measure: Notional
   * Group: AddOn
   */
  @Test
  public void testC460() {
    List<FixedAmount> fixed = Arrays.asList(S_AN_7, S_AN_8);
    List<NotionalFactor> factors = Arrays.asList(S_AN_1, S_AN_2);
    List<Notional> notional = Arrays.asList(S_AN_3, S_AN_4, S_AN_5, S_AN_6);
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList();
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("80000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C41,C82,C134,C189,C256
   * Element Tested: Risk Class Correlations
   * Risk Measure: All
   * Group: Global
   */
  @Test
  public void testC461() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_41, S_FX_11, S_CRQ_1, S_CRNQ_1, S_EQ_25, S_CM_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("268197860"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C456,C461
   * Element Tested: Combination (All w/o Multipliers and Notionals)
   * Risk Measure: All
   * Group: Global
   */
  @Test
  public void testC462() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
    addAnything(sensitivities, S_IR, S_CRQ, S_CRNQ, S_CM, S_FX, S_EQ, S_IRV, S_FXV, S_CRV, S_CNV, S_EQV, S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("41820239523"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C456,C461,C462
   * Element Tested: Combination (All w/Multiplier)
   * Risk Measure: All
   * Group: Global
   */
  @Test
  public void testC463() {
    List<FixedAmount> fixed = Arrays.asList();
    List<NotionalFactor> factors = Arrays.asList();
    List<Notional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = S_MUL;
    List<Sensitivity> sensitivities = new ArrayList<>();
    addAnything(sensitivities, S_IR, S_CRQ, S_CRNQ, S_CM, S_FX, S_EQ, S_IRV, S_FXV, S_CRV, S_CNV, S_EQV, S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("45223054076"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C463
   * Element Tested: Combination (All w/Notionals
   * Risk Measure: All
   * Group: Global
   */
  @Test
  public void testC464() {
    List<FixedAmount> fixed = Arrays.asList(S_AN_7, S_AN_8);
    List<NotionalFactor> factors = Arrays.asList(S_AN_1, S_AN_2);
    List<Notional> notional = Arrays.asList(S_AN_3, S_AN_4, S_AN_5, S_AN_6);
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
    addAnything(sensitivities, S_IR, S_CRQ, S_CRNQ, S_CM, S_FX, S_EQ, S_IRV, S_FXV, S_CRV, S_CNV, S_EQV, S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("41900239523"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C464
   * Element Tested: Combination (All)
   * Risk Measure: All
   * Group: Global
   */
  @Test
  public void testC465() {
    List<FixedAmount> fixed = Arrays.asList(S_AN_7, S_AN_8);
    List<NotionalFactor> factors = Arrays.asList(S_AN_1, S_AN_2);
    List<Notional> notional = Arrays.asList(S_AN_3, S_AN_4, S_AN_5, S_AN_6);
    List<ProductMultiplier> multipliers = S_MUL;
    List<Sensitivity> sensitivities = new ArrayList<>();
    addAnything(sensitivities, S_IR, S_CRQ, S_CRNQ, S_CM, S_FX, S_EQ, S_IRV, S_FXV, S_CRV, S_CNV, S_EQV, S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("45303054076"), amount.setScale(0, RoundingMode.HALF_UP));
  }
}
