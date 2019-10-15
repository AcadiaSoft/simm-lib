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
import com.acadiasoft.im.simm.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimmTest extends AbstractSimmTest {

  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular, 2w)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC1() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("464000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC2() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("282000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC3() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("118000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC4() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("177000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC5() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("59000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC6() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("98000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC7() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("245000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC8() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("510000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC9() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1275000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC10() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1785000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC11() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("212000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC12() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("213000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC13() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("104000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC14() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("204000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC15() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("540000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (regular)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC16() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("496000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (inflation)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC17() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("470000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (xccy)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC18() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("600000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol, 2w)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC19() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("14000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC20() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("30000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC21() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("15000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC22() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("20000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC23() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("42000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC24() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("80000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC25() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("110000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC26() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_26);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("400000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC27() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1000000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC28() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_28);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("20000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC29() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_29);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("44000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC30() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_30);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("81000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (inflation)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC31() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_31);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("705000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (xccy)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC32() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("10000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol, 2w)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC33() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("85000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC34() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_34);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("120000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC35() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_35);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("39500000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC36() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_36);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("86000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC37() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_37);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("291000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC38() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_38);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("612000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC39() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_39);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("52000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC40() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_40);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("102000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC41() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_41);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("412000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC42() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_42);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("594000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC43() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_43);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("99000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC44() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_44);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("100000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (inflation)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC45() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_45);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("94000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IR Risk Weight (xccy)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC46() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_46);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("20000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C8,C9
   * Element Tested: Net Sensitivities (same tenor & subcurve, same sign)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC47() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_8, S_IR_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1785000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C4,C5
   * Element Tested: Net Sensitivities (same tenor & subcurve, diff sign)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC48() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_4, S_IR_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("118000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C8-C10,C47
   * Element Tested: Concentration (reg vol, well traded)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC49() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_8, S_IR_9, S_IR_10, S_IR_8, S_IR_9, S_IR_10, S_IR_8, S_IR_9, S_IR_10, S_IR_8, S_IR_9, S_IR_10, S_IR_8, S_IR_9, S_IR_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("21742557760"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C14-C16
   * Element Tested: Concentration (reg vol, less traded)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC50() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_14, S_IR_15, S_IR_16, S_IR_14, S_IR_15, S_IR_16, S_IR_14, S_IR_15, S_IR_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2955212983"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C14-C18,C50
   * Element Tested: Concentration (reg vol, w/inf & xccy)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC51() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_14, S_IR_15, S_IR_16, S_IR_14, S_IR_15, S_IR_16, S_IR_14, S_IR_15, S_IR_16, S_IR_17, S_IR_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2569035336"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C26-C28
   * Element Tested: Concentration (low vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC52() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_26, S_IR_27, S_IR_28, S_IR_26, S_IR_27, S_IR_28, S_IR_26, S_IR_27, S_IR_28);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("4814735881"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C26-C28,C31,C32,C52
   * Element Tested: Concentration (low vol, w/inf & xccy)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC53() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_26, S_IR_27, S_IR_28, S_IR_26, S_IR_27, S_IR_28, S_IR_26, S_IR_27, S_IR_28, S_IR_31, S_IR_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("5383482404"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C41-C44
   * Element Tested: Concentration (high vol)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC54() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_41, S_IR_42, S_IR_43, S_IR_44);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("872932960"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C41-C46,C54
   * Element Tested: Concentration (high vol, w/inf & xccy)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC55() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_41, S_IR_42, S_IR_43, S_IR_44, S_IR_45, S_IR_46);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1022659739"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C3,C4
   * Element Tested: Subcurve Correlation (same tenor, same sign)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC56() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_3, S_IR_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("293936081"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C6,C7
   * Element Tested: Subcurve Correlation (same tenor, diff sign)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC57() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_6, S_IR_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("149429917"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C2,C5
   * Element Tested: Tenor Correlation (diff subcurve)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC58() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_2, S_IR_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("323983790"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C11,C12
   * Element Tested: Tenor Correlation (same sign, same subcurve)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC59() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_11, S_IR_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("386025647"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C12,C13
   * Element Tested: Tenor Correlation (diff sign, same subcurve)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC60() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_12, S_IR_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("155840046"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C19-C30,C52
   * Element Tested: Tenor Correlation (all tenors and subcurves)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC61() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_19, S_IR_20, S_IR_21, S_IR_22, S_IR_23, S_IR_24, S_IR_25, S_IR_26, S_IR_27, S_IR_28, S_IR_29, S_IR_30);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1604953835"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C19-C32,C52,C53,C61
   * Element Tested: Tenor Correlation (all tenors and subcurves, w/inf & xccy)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC62() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_19, S_IR_20, S_IR_21, S_IR_22, S_IR_23, S_IR_24, S_IR_25, S_IR_26, S_IR_27, S_IR_28, S_IR_29, S_IR_30, S_IR_31, S_IR_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1995228010"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1,C22,C33
   * Element Tested: Inter bucket correlation (all pos)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC63() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_1, S_IR_22, S_IR_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("495081609"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1,C19,C33
   * Element Tested: Inter bucket correlation (one neg)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC64() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_1, S_IR_19, S_IR_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("486506691"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C2,C19,C35
   * Element Tested: Inter bucket correlation (all neg)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC65() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_2, S_IR_19, S_IR_35);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("296920612"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C3,C21,C37,C38
   * Element Tested: Inter bucket correlation (exceeds concentration threshold)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC66() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_3, S_IR_21, S_IR_37, S_IR_38, S_IR_37, S_IR_38);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2883618816"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C66
   * Element Tested: All Inflation sensitivities
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC67() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("6483191078"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FX Risk Weight & correlation (net to zero)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC68() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FX_1, S_FX_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
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
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FX_3, S_FX_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("45420000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FX Risk Weight (RR) & correlation (RR)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC70() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FX_5, S_FX_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("6851163667"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FX Risk Weight (RR) & correlation (RR)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC71() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FX_7, S_FX_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1553234139"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FX Risk Weight (RH) & correlation (RH)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC72() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FX_9, S_FX_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2916025025"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FX Risk Weight (RH) & correlation (HR)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC73() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FX_11, S_FX_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("418810053"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: Concentration (significantly trading)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC74() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FX_3, S_FX_6, S_FX_3, S_FX_6, S_FX_3, S_FX_6, S_FX_3, S_FX_6, S_FX_3, S_FX_6, S_FX_3, S_FX_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("668460416207"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: Concentration (frequently traded)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC75() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("18212301456"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: Concentration (others)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC76() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FX_10, S_FX_10, S_FX_10, S_FX_10, S_FX_10, S_FX_10, S_FX_10, S_FX_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("30216905467"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C69,C70,C74
   * Element Tested: FX Intercurrency Correlation (3 ccys)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC77() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FX_3, S_FX_4, S_FX_5, S_FX_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("49152039730"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C70,C71,C75
   * Element Tested: FX Intercurrency Correlation (4 ccys)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC78() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FX_5, S_FX_6, S_FX_7, S_FX_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("7025433109"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C70,C72,C76
   * Element Tested: FX Intercurrency Correlation (exceeds concentration threshold)
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC79() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FX_5, S_FX_6, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("29908014077"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C68-C79
   * Element Tested: All FX sensitivities
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC80() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FX);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("50406241222"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C80
   * Element Tested: All Rates & FX Sensitivities
   * Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC81() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR, S_FX);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("52197176001"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC82() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("57600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC83() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("21600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC84() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("17460000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC85() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("17460000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 3)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC86() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("13500000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 3)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC87() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("7500000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 4)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC88() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("9540000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 4)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC89() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("5300000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 5)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC90() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("8100000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 5)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC91() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("4500000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 6)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC92() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("9540000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 7)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC93() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("99000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 8)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC94() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("25000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 9)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC95() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("34380000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 10)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC96() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("17900000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 11)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC97() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("23760000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (bkt 12)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC98() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("12900000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC99() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("45000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC100() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("25000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC101() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("45000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC102() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("45000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC103() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("25000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (base corr)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC104() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("3500000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (base corr)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC105() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRQ Risk Weight (base corr)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC106() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C83
   * Element Tested: CRQ Concentration (bkt 1) (diff tenors)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC107() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_1, S_CRQ_1, S_CRQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("111625941"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C85
   * Element Tested: CRQ Concentration (bkt 2-6) (same sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC108() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_4, S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("49384338"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C93
   * Element Tested: CRQ Concentration (bkt 7) (all neg)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC109() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_12, S_CRQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("223713342"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C95
   * Element Tested: CRQ Concentration (bkt 8-12)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC110() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_14, S_CRQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("97241325"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C83,C107
   * Element Tested: CRQ Intra-bucket Correlation (same name, diff tenor)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC111() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_1, S_CRQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("37688407"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C84,C85,C108
   * Element Tested: CRQ Intra-bucket Correlation (same name, diff ccy)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC112() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_3, S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("5521337"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C86,C87
   * Element Tested: CRQ Intra-bucket Correlation (same name, diff tenor, diff ccy)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC113() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_5, S_CRQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("6791539"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C88,C89
   * Element Tested: CRQ Intra-bucket Correlation (same name, same tenor, same ccy)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC114() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_7, S_CRQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("4240000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C90,C91
   * Element Tested: CRQ Intra-bucket Correlation (diff name)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC115() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_9, S_CRQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("7481377"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C99,C100
   * Element Tested: CRQ Intra-bucket Correlation (residual, same name, diff tenor)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC116() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_18, S_CRQ_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("39051248"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C100,C101
   * Element Tested: CRQ Intra-bucket Correlation (residual, diff name)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC117() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_19, S_CRQ_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("39051248"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C84,C86
   * Element Tested: CRQ Inter-bucket Correlation (exceeds concentration threshold)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC118() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_3, S_CRQ_3, S_CRQ_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("56871929"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C84
   * Element Tested: CRQ Inter-bucket Correlation (same sign, pos)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC119() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_1, S_CRQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("66988881"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C83,C85,C108
   * Element Tested: CRQ Inter-bucket Correlation (same sign, neg)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC120() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_2, S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("33102093"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C85,C108
   * Element Tested: CRQ Inter-bucket Correlation (diff sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC121() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_1, S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("52513932"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C85,C99,C108,C121
   * Element Tested: CRQ Inter-bucket Correlation (diff sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC122() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_1, S_CRQ_4, S_CRQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("97513932"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C84,C86,C88,C90,C92,C118,C119
   * Element Tested: CRQ Inter-bucket Correlation (bkts 1-3, 4-6)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC123() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_7, S_CRQ_9, S_CRQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("89840541"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C84,C86,C93-C95,C109,C110,C118,C119
   * Element Tested: CRQ Inter-bucket Correlation (bkts 1-3, 7-9)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC124() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_12, S_CRQ_13, S_CRQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("99178969"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C84,C86,C96-C98,C118,C119
   * Element Tested: CRQ Inter-bucket Correlation (bkts 1-3, 10-12)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC125() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_15, S_CRQ_16, S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("76515743"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C88,C90,C92-C95,C109,C110
   * Element Tested: CRQ Inter-bucket Correlation (bkts 4-6, 7-9)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC126() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_7, S_CRQ_9, S_CRQ_11, S_CRQ_12, S_CRQ_13, S_CRQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("95529128"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C88,C90,C92,C96-C98
   * Element Tested: CRQ Inter-bucket Correlation (bkts 4-6, 10-12)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC127() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_7, S_CRQ_9, S_CRQ_11, S_CRQ_15, S_CRQ_16, S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("32261417"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C93-C98,C109,C110
   * Element Tested: CRQ Inter-bucket Correlation (bkts 7-9, 10-12)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC128() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_12, S_CRQ_13, S_CRQ_14, S_CRQ_15, S_CRQ_16, S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("105735169"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C84,C86,C88,C90,C92-C98,C109,C110,C118,C119,C123-C128
   * Element Tested: CRQ Inter-bucket Correlation (all)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC129() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_7, S_CRQ_9, S_CRQ_11, S_CRQ_12, S_CRQ_13, S_CRQ_14, S_CRQ_15, S_CRQ_16, S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("106379570"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82,C84,C86,C88,C90,C92-C99,C109,C110,C118,C119,C123-C129
   * Element Tested: CRQ Inter-bucket Correlation (all + residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC130() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_7, S_CRQ_9, S_CRQ_11, S_CRQ_12, S_CRQ_13, S_CRQ_14, S_CRQ_15, S_CRQ_16, S_CRQ_17, S_CRQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("151379570"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C104,C105
   * Element Tested: CRQ Base Corr Netting
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC131() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_23, S_CRQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2100000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C104-C106,C131
   * Element Tested: CRQ Base Corr Correlation
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC132() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ_23, S_CRQ_24, S_CRQ_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("3727788"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82-C132
   * Element Tested: All Credit Qualifying (no multiplier)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC133() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("186870273"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC134() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("600000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC135() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("300000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC136() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("300000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC137() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("200000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC138() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("300000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC139() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("400000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC140() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("640000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC141() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("320000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC142() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("320000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC143() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("320000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC144() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("320000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC145() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("480000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC146() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("640000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC147() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("320000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC148() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("480000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC149() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("160000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C134,C135
   * Element Tested: CRNQ Concentration (bkt 1)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC150() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_1, S_CRNQ_2, S_CRNQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1140415437"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C140,C143
   * Element Tested: CRNQ Concentration (bkt 2)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC151() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_7, S_CRNQ_7, S_CRNQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1539994805"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C146,C148
   * Element Tested: CRNQ Concentration (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC152() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_13, S_CRNQ_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1151555470"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C134,C135,C150
   * Element Tested: CRNQ Intra-bucket correlation (same name, same sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC153() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_1, S_CRNQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("777688884"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C135,C136
   * Element Tested: CRNQ Intra-bucket correlation (same name, opp sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC154() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_2, S_CRNQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("320312348"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C136,C137
   * Element Tested: CRNQ Intra-bucket correlation (diff name, same sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC155() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_3, S_CRNQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("384707681"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C136,C139
   * Element Tested: CRNQ Intra-bucket correlation (diff name, opp sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC156() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_3, S_CRNQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("534789678"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C146,C147
   * Element Tested: CRNQ Intra-bucket correlation (residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC157() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_13, S_CRNQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("554256258"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C134,C140
   * Element Tested: CRNQ Intra-bucket correlation (exceeds concentration threshold)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC158() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_1, S_CRNQ_1, S_CRNQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1391069310"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C134,C140,C158
   * Element Tested: CRNQ Inter-bucket correlation (same sign, pos)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC159() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_1, S_CRNQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("799399775"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C136,C141
   * Element Tested: CRNQ Inter-bucket correlation (same sign, neg)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC160() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_3, S_CRNQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("474383811"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C135,C141
   * Element Tested: CRNQ Inter-bucket correlation (diff sign)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC161() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_2, S_CRNQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("399699887"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C135,C141,C146,C161
   * Element Tested: CRNQ Inter-bucket correlation (w/residual)
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC162() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ_2, S_CRNQ_8, S_CRNQ_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1039699887"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C134-C162
   * Element Tested: All Credit Non Qualifying
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC163() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRNQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2106642712"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C82-C163
   * Element Tested: All Credit Qualifying and Non-Qualifying
   * Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC164() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRQ, S_CRNQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2149990279"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC165() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("132000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC166() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("22000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC167() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("52000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC168() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("26000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 3)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC169() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("58000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 3)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC170() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("29000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 4)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC171() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("52000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 4)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC172() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("26000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 5)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC173() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("190000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 5)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC174() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("38000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 6)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC175() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("84000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 6)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC176() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("42000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 7)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC177() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("100000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 7)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC178() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("50000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 8)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC179() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("96000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 8)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC180() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("48000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 9)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC181() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("12000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 9)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC182() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("120000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 10)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC183() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("58000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 10)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC184() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("29000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 11)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC185() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("17000000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 11)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC186() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("34000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 11)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC187() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("17000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC188() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("51000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC189() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("34000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (bkt 12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC190() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_26);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("17000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC191() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("42000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQ Risk Weight (residual)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC192() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_28);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("9000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165
   * Element Tested: EQ Concentration (bkt 1-4)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC193() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_1, S_EQ_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("275739007"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C173
   * Element Tested: EQ Concentration (bkt 5-8)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC194() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_9, S_EQ_9, S_EQ_9, S_EQ_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("790210372"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C182
   * Element Tested: EQ Concentration (bkt 9)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC195() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_18, S_EQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("300587660"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C183
   * Element Tested: EQ Concentration (bkt 10)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC196() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_19, S_EQ_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("149755356"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C185
   * Element Tested: EQ Concentration (bkt 11-12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC197() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("400693842672"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C191
   * Element Tested: EQ Concentration (residual)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC198() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_27, S_EQ_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("90730370"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C166,C193
   * Element Tested: EQ Intra Bucket Correlation (Bkt 1)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC199() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_1, S_EQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("137248971"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C167,C168
   * Element Tested: EQ Intra Bucket Correlation (Bkt 2)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC200() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_3, S_EQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("53029803"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C169,C170
   * Element Tested: EQ Intra Bucket Correlation (Bkt 3)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC201() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_5, S_EQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("57123375"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C171,C172
   * Element Tested: EQ Intra Bucket Correlation (Bkt 4)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC202() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_7, S_EQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("63686733"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C173,C174,C194
   * Element Tested: EQ Intra Bucket Correlation (Bkt 5)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC203() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_9, S_EQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("201077100"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C175,C176
   * Element Tested: EQ Intra Bucket Correlation (Bkt 6)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC204() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_11, S_EQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("81873072"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C177,C178
   * Element Tested: EQ Intra Bucket Correlation (Bkt 7)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC205() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_13, S_EQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("95916630"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C179,C180
   * Element Tested: EQ Intra Bucket Correlation (Bkt 8)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC206() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_15, S_EQ_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("119903962"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C181,C182,C195
   * Element Tested: EQ Intra Bucket Correlation (Bkt 9)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC207() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_17, S_EQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("118429726"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C183,C184,C196
   * Element Tested: EQ Intra Bucket Correlation (Bkt 10)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC208() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_19, S_EQ_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("59995667"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C186,C187
   * Element Tested: EQ Intra Bucket Correlation (Bkt 11)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC209() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_22, S_EQ_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("31346451"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C189,C190
   * Element Tested: EQ Intra Bucket Correlation (Bkt 12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC210() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_25, S_EQ_26);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("31346451"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C166,C193,C199
   * Element Tested: EQ Intra Bucket Correlation (exceeds concentration threshold)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC211() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_1, S_EQ_1, S_EQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("279954568"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C168,C193
   * Element Tested: EQ Inter-bucket Correlation (same sign, pos)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC212() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_1, S_EQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("138805187"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C167,C170
   * Element Tested: EQ Inter-bucket Correlation (same sign, neg)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC213() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_3, S_EQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("64873107"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C167,C193
   * Element Tested: EQ Inter-bucket Correlation (diff sign)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC214() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_1, S_EQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("133395052"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C167,C191,C193,C198,C214
   * Element Tested: EQ Inter-bucket Correlation (w/residual)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC215() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_1, S_EQ_3, S_EQ_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("175395052"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C167,C169,C171,C173,C175,C193,C194,C214
   * Element Tested: EQ Inter-bucket Correlation (bks 1-3, 4-6)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC216() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_1, S_EQ_3, S_EQ_5, S_EQ_7, S_EQ_9, S_EQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("244300143"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C167,C169,C177,C179,C181,C193,C214
   * Element Tested: EQ Inter-bucket Correlation (bks 1-3, 7-9)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC217() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_1, S_EQ_3, S_EQ_5, S_EQ_13, S_EQ_15, S_EQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("193419337"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C167,C169,C183,C185,C188,C193,C196,C197,C214
   * Element Tested: EQ Inter-bucket Correlation (bks 1-3, 10-12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC218() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_1, S_EQ_3, S_EQ_5, S_EQ_19, S_EQ_21, S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("17061469987"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C171,C173,C175,C177,C179,C181,C194
   * Element Tested: EQ Inter-bucket Correlation (bks 4-6, 7-9)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC219() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_7, S_EQ_9, S_EQ_11, S_EQ_13, S_EQ_15, S_EQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("224081414"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C171,C173,C175,C183,C185,C188,C194,C196,C197
   * Element Tested: EQ Inter-bucket Correlation (bks 4-6, 10-12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC220() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_7, S_EQ_9, S_EQ_11, S_EQ_19, S_EQ_21, S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("17044558254"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C177,C179,C181,C183,C185,C188,C196,C197
   * Element Tested: EQ Inter-bucket Correlation (bks 7-9, 10-12)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC221() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_13, S_EQ_15, S_EQ_17, S_EQ_19, S_EQ_21, S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("17038057767"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165,C167,C169,C171,C173,C175,C177,C179,C181,C183,C185,C188,C193,C194,C196,C197,C214,C216-C221
   * Element Tested: EQ Inter-bucket Correlation (all)
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC222() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ_1, S_EQ_3, S_EQ_5, S_EQ_7, S_EQ_9, S_EQ_11, S_EQ_13, S_EQ_15, S_EQ_17, S_EQ_19, S_EQ_21, S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("17076221635"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C165-C222
   * Element Tested: All Equity Sensitivities
   * Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC223() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("17098162127"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC224() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2850000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 1)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC225() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("19000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC226() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("42000000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 2)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC227() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("20000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 3)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC228() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("5760000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 3)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC229() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("16000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 4)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC230() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("190000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 4)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC231() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("19000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 5)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC232() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("240000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 5)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC233() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("24000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 6)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC234() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("15600000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 6)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC235() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("24000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 7)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC236() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("280000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 8)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC237() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("12600000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 8)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC238() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("42000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 9)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC239() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("280000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 9)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC240() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("28000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 10)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC241() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2703000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 10)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC242() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("53000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 11)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC243() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("6000000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 11)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC244() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("20000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 12)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC245() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("15200000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 12)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC246() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("19000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 13)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC247() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("300000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 13)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC248() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("15000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 14)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC249() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_26);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("160000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 14)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC250() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("16000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 15)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC251() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_28);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("110000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 15)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC252() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_29);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("11000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 16)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC253() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_30);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1325000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 16)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC254() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_31);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("106000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 17)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC255() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("20800000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CM Risk Weight (bkt 17)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC256() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("32000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C224
   * Element Tested: CM Concentration (bkt 1)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC257() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("69810457669"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C226
   * Element Tested: CM Concentration (bkt 2)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC258() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1269097591067"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C228
   * Element Tested: CM Concentration (bkt 3-5)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC259() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("86400000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C234
   * Element Tested: CM Concentration (bkt 6-7)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC260() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("268145143871"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C237
   * Element Tested: CM Concentration (bkt 8-9)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC261() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("147136300447"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C241
   * Element Tested: CM Concentration (bkt 10)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC262() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_18, S_CM_18, S_CM_18, S_CM_18, S_CM_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("30220458716"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C243
   * Element Tested: CM Concentration (bkt 11)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC263() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("170848439235"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C245
   * Element Tested: CM Concentration (bkt 12)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC264() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("460923610496"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C247
   * Element Tested: CM Concentration (bkt 13-15)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC265() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("8164965809"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C253
   * Element Tested: CM Concentration (bkt 16)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC266() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("40318466039"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C255
   * Element Tested: CM Concentration (bkt 17)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC267() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("370376209529"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C224,C225,C257
   * Element Tested: CM Intra Bucket Correlation (Bkt 1)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC268() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_1, S_CM_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2855378259"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C226,C227,C258
   * Element Tested: CM Intra Bucket Correlation (Bkt 2)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC269() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_3, S_CM_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("41980400189"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C228,C229,C259
   * Element Tested: CM Intra Bucket Correlation (Bkt 3)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC270() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_5, S_CM_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("5745283422"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C230,C231
   * Element Tested: CM Intra Bucket Correlation (Bkt 4)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC271() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_7, S_CM_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("208481174"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C232,C233
   * Element Tested: CM Intra Bucket Correlation (Bkt 5)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC272() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_9, S_CM_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("263781728"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C234,C235,C260
   * Element Tested: CM Intra Bucket Correlation (Bkt 6)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC273() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_11, S_CM_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("15582248362"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C237,C238,C261
   * Element Tested: CM Intra Bucket Correlation (Bkt 8)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC274() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_14, S_CM_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("12614761353"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C239,C240
   * Element Tested: CM Intra Bucket Correlation (Bkt 9)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC275() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_16, S_CM_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("300005333"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C241,C242,C262
   * Element Tested: CM Intra Bucket Correlation (Bkt 10)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC276() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_18, S_CM_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2696090777"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C243,C244,C263
   * Element Tested: CM Intra Bucket Correlation (Bkt 11)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC277() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_20, S_CM_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("5989424012"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C245,C246,C264
   * Element Tested: CM Intra Bucket Correlation (Bkt 12)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC278() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_22, S_CM_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("15211977156"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C247,C248,C265
   * Element Tested: CM Intra Bucket Correlation (Bkt 13)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC279() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_24, S_CM_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("309378409"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C249,C250
   * Element Tested: CM Intra Bucket Correlation (Bkt 14)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC280() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_26, S_CM_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("157906301"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C251,C252
   * Element Tested: CM Intra Bucket Correlation (Bkt 15)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC281() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_28, S_CM_29);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("108894444"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C253,C254,C266
   * Element Tested: CM Intra Bucket Correlation (Bkt 16)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC282() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_30, S_CM_31);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1329233238"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C255,C256,C267
   * Element Tested: CM Intra Bucket Correlation (Bkt 17)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC283() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_32, S_CM_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("20832000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C237,C241,C261,C262
   * Element Tested: CM Intra Bucket Correlation (exceeds concentration threshold)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC284() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_18, S_CM_18, S_CM_18, S_CM_18, S_CM_18, S_CM_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("33203890546"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C226,C229,C258
   * Element Tested: CM Inter Bucket Correlation (same sign, pos)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC285() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_3, S_CM_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("42014880412"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C227,C228,C259
   * Element Tested: CM Inter Bucket Correlation (same sign, neg)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC286() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_4, S_CM_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("5778604676"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C226,C228,C258,C259
   * Element Tested: CM Inter Bucket Correlation (diff signs)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC287() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_3, S_CM_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("36704310374"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C226,C228,C254,C258,C259,C287
   * Element Tested: CM Inter Bucket Correlation (w/residual)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC288() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_3, S_CM_5, S_CM_31);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("36704463434"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C224,C226,C228,C230,C232,C234,C236,C237,C257-C261,C287
   * Element Tested: CM Inter Bucket Correlation (bkts 1-4, 5-8)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC289() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_1, S_CM_3, S_CM_5, S_CM_7, S_CM_9, S_CM_11, S_CM_13, S_CM_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("40302083941"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C224,C226,C228,C230,C239,C241,C243,C245,C257-C259,C262-C264,C287
   * Element Tested: CM Inter Bucket Correlation (bkts 1-4, 9-12)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC290() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_1, S_CM_3, S_CM_5, S_CM_7, S_CM_16, S_CM_18, S_CM_20, S_CM_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("35556969944"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C224,C226,C228,C230,C247,C249,C251,C253,C255,C257-C259,C265-C267,C287
   * Element Tested: CM Inter Bucket Correlation (bkts 1-4, 13-17)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC291() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_1, S_CM_3, S_CM_5, S_CM_7, S_CM_24, S_CM_26, S_CM_28, S_CM_30, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("52825730634"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C232,C234,C236,C237,C239,C241,C243,C245,C260-C264,C284
   * Element Tested: CM Inter Bucket Correlation (bkts 5-8, 9-12)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC292() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_9, S_CM_11, S_CM_13, S_CM_14, S_CM_16, S_CM_18, S_CM_20, S_CM_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("22228596056"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C232,C234,C236,C237,C247,C249,C251,C253,C255,C260,C261,C265-C267
   * Element Tested: CM Inter Bucket Correlation (bkts 5-8, 13-17)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC293() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_9, S_CM_11, S_CM_13, S_CM_14, S_CM_24, S_CM_26, S_CM_28, S_CM_30, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("25885664005"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C239,C241,C243,C245,C247,C249,C251,C253,C255,C262-C267
   * Element Tested: CM Inter Bucket Correlation (bkts 9-12, 13-17)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC294() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_16, S_CM_18, S_CM_20, S_CM_22, S_CM_24, S_CM_26, S_CM_28, S_CM_30, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("24342464818"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C224,C226,C228,C230,C232,C234,C236,C237,C239,C241,C243,C245,C247,C249,C251,C253,C255,C257-C267,C284,C287,C289-C294
   * Element Tested: CM Inter Bucket Correlation (all)
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC295() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM_1, S_CM_3, S_CM_5, S_CM_7, S_CM_9, S_CM_11, S_CM_13, S_CM_14, S_CM_16, S_CM_18, S_CM_20, S_CM_22, S_CM_24, S_CM_26, S_CM_28, S_CM_30, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("53271770517"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C224-C295
   * Element Tested: All Commodities
   * Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC296() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CM);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("53302818278"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C296
   * Element Tested: All Delta Sensitivities (no multiplier)
   * Risk Measure: Delta
   * Group: Global
   */
  @Test
  public void testC297() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR, S_CRQ, S_CRNQ, S_CM, S_FX, S_EQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("124147067841"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C297
   * Element Tested: All Delta Sensitivities (with multiplier)
   * Risk Measure: Delta
   * Group: Global
   */
  @Test
  public void testC298() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = S_MUL;
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR, S_CRQ, S_CRNQ, S_CM, S_FX, S_EQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("133088052868"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC299() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("105059779"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC300() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("36529889"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC301() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("19019926"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC302() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("41059779"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC303() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("22553801"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC304() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("15549816"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC305() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("19324723"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC306() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("61298894"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC307() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("106597787"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC308() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("197195575"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC309() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("559586724"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC310() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1197006871"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC311() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("16000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC312() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("16000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC313() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("16000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC314() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("14007970"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC315() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("7305978"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC316() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("3652989"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: IRV Risk Weight & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC317() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2052989"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299
   * Element Tested: Concentration (reg vol, well traded)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC318() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_1, S_IRV_1, S_IRV_1, S_IRV_1, S_IRV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("593497525"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C301
   * Element Tested: Concentration (reg vol, less traded)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC319() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_3, S_IRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("38871160"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C301,C316,C319
   * Element Tested: Concentration (reg vol, w/inf
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC320() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_3, S_IRV_3, S_IRV_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("42097467"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C300
   * Element Tested: Concentration (low vol)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC321() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("204986369"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C300,C315,C321
   * Element Tested: Concentration (low vol, w/inf)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC322() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("211890807"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C303
   * Element Tested: Concentration (high vol)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC323() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_5, S_IRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("45942557"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C303,C323
   * Element Tested: Concentration (high vol, w/inf)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC324() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_5, S_IRV_5, S_IRV_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("47727546"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299,C307,C318
   * Element Tested: Intra-currency Correlation (Same Sign - Pos)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC325() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_1, S_IRV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("194982034"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C311,C312
   * Element Tested: Intra-currency Correlation (Same Sign - Neg)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC326() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_13, S_IRV_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("31919900"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C300,C313,C321
   * Element Tested: Intra-currency Correlation (Opposite sign)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC327() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_2, S_IRV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("17971753"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C300,C313,C315,C321,C322,C327
   * Element Tested: Intra-currency Correlation (Opposite sign, w/Inflation)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC328() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_2, S_IRV_15, S_IRV_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("21749820"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299,C300,C318,C321
   * Element Tested: Inter-currency Correlation
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC329() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_1, S_IRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("118480332"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299,C303,C318,C323
   * Element Tested: Inter-currency Correlation (exeeds concentration threshold)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC330() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_1, S_IRV_5, S_IRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("126341108"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299-C301,C318,C319,C321,C329
   * Element Tested: Inter-currency Correlation (3 ccys)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC331() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV_1, S_IRV_2, S_IRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("124704364"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299-C331
   * Element Tested: All Interest Rate Vol Sensitivities
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC332() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1672720924"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC333() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("280720541"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC334() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("535413446"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (HR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC335() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("583534898"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC336() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("129597982"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC337() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("48599243"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC338() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("47336134"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (RR) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC339() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("38879395"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: FXV Risk Weight (RH) & Scaling
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC340() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("140607913"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C333
   * Element Tested: FXV Concentration (sig:sig)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC341() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("5900039840"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C335
   * Element Tested: FXV Concentration (freq:sig)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC342() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("37445934927"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C336
   * Element Tested: FXV Concentration (sig:other)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC343() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("3367028119"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C337
   * Element Tested: FXV Concentration (freq:freq)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC344() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("819306130"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C338
   * Element Tested: FXV Concentration (freq:other)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC345() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("670815141"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C339
   * Element Tested: FXV Concentration (other:other)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC346() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("586247744"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C333,C334,C341
   * Element Tested: FXV Aggregate (swapped currencies)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC347() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_1, S_FXV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("816133988"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C333,C335,C341,C342
   * Element Tested: FXV Correlation (same sign, pos)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC348() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_1, S_FXV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("770497620"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C336,C337,C343,C344
   * Element Tested: FXV Correlation (same sign, neg)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC349() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_4, S_FXV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("159549012"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C335,C336,C342,C343
   * Element Tested: FXV Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC350() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_3, S_FXV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("580510287"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C335,C337,C342,C344
   * Element Tested: FXV Correlation (exceeds concentration threshold)
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC351() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV_3, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("983884928"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C333-C351
   * Element Tested: All FX Vol Sensitivities
   * Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC352() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_FXV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1270311488"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC353() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("62069351"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC354() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("31034676"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC355() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("12972446"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC356() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("103448918"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC357() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("15600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC358() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("5172446"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC359() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("12463468"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRV  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC360() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("58500000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353,C354
   * Element Tested: CRV Concentration (same tenor, diff quanto, same sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC361() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_1, S_CRV_2, S_CRV_1, S_CRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("202375624"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C356,C357
   * Element Tested: CRV Concentration (diff tenor, same quanto, diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC362() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_4, S_CRV_5, S_CRV_4, S_CRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("181758970"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C360
   * Element Tested: CRV Concentration (residual)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC363() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_8, S_CRV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("121106506"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353,C354,C361
   * Element Tested: CRV Intra-bucket Correlation (same tenor, diff quanto, same sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC364() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_1, S_CRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("91893518"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353,C355
   * Element Tested: CRV Intra-bucket Correlation (diff name)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC365() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_1, S_CRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("68374858"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C358,C360,C363
   * Element Tested: CRV Intra-bucket Correlation (residual, same name)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC366() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_6, S_CRV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("57982474"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C358,C359
   * Element Tested: CRV Intra-bucket Correlation (residual, diff name)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC367() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_6, S_CRV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("15760839"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353,C355,C365
   * Element Tested: CRV Intra-bucket Correlation (exceeds concentration threshold)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC368() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_1, S_CRV_1, S_CRV_1, S_CRV_1, S_CRV_1, S_CRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("422729170"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353,C356
   * Element Tested: CRV Inter-bucket (same sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC369() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_1, S_CRV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("140155020"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353,C357
   * Element Tested: CRV Inter-bucket (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC370() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_1, S_CRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("57158276"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353,C357,C358,C370
   * Element Tested: CRV Inter-bucket (w/residual)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC371() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV_1, S_CRV_5, S_CRV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("62330722"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C353-C371
   * Element Tested: All Credit Qualifying Vol Sensitivities
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC372() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CRV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("207782875"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC373() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("20689784"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC374() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("15517338"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC375() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("7800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC376() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("19500000"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC377() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("8308978"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC378() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("23276007"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC379() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("4154489"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC380() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("10068111"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CRNQ Vol  Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC381() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("7758669"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C373
   * Element Tested: CNV Concentration (same tenor)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC382() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_1, S_CNV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("46510252"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C376,C377
   * Element Tested: CNV Concentration (diff tenor)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC383() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_4, S_CNV_4, S_CNV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("51190572"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C378,C380
   * Element Tested: CNV Concentration (residual,  diff tenor)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC384() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_6, S_CNV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("31948764"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C374,C375
   * Element Tested: CNV Intra-bucket Correlation (same name)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC385() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_2, S_CNV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("14525793"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C373,C374,C382
   * Element Tested: CNV Intra-bucket Correlation (diff name)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC386() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_1, S_CNV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("30383715"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C379,C381
   * Element Tested: CNV Intra-bucket Correlation (residual)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC387() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_7, S_CNV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("10513933"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C373-C375,C382,C385,C386
   * Element Tested: CNV Intra-bucket Correlation (exceeds concentration threshold)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC388() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_1, S_CNV_1, S_CNV_2, S_CNV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("50802600"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C373,C377,C382
   * Element Tested: CNV Inter-bucket Correlation (same sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC389() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_1, S_CNV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("23790014"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C374,C376
   * Element Tested: CNV Inter-bucket Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC390() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_2, S_CNV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("24884534"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C374,C375,C378,C385
   * Element Tested: CNV Inter-bucket Correlation (w/residual)
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC391() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV_2, S_CNV_3, S_CNV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("37801799"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C373-C391
   * Element Tested: All Credit Non Qualifying Vol Sensitivities
   * Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC392() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CNV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("72754629"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC393() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("97667368"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC394() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("32235373"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC395() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("22974966"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC396() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("18101488"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC397() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("9050744"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC398() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("125742123"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC399() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("4177267"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC400() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("21809973"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC401() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2493726743"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC402() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("59177942"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC403() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("705583159"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC404() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("4512408"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: EQV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC405() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("5221583"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C393
   * Element Tested: EQV Concentration (bkts 1-4)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC406() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2168558752"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C398
   * Element Tested: EQV Concentration (bkts 5-8)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC407() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("5756956994"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C399
   * Element Tested: EQV Concentration (bkt 9)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC408() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_7, S_EQV_7, S_EQV_7, S_EQV_7, S_EQV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("29598971"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C400
   * Element Tested: EQV Concentration (bkt 10)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC409() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_8, S_EQV_8, S_EQV_8, S_EQV_8, S_EQV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("148756380"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C401
   * Element Tested: EQV Concentration (bkt 11-12)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC410() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("213149550165"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C404
   * Element Tested: EQV Concentration (residual)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC411() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_12, S_EQV_12, S_EQV_12, S_EQV_12, S_EQV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("31274679"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C393,C394,C406
   * Element Tested: EQV Intra-bucket Correlation (same sign, pos)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC412() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_1, S_EQV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("108409524"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C396,C397
   * Element Tested: EQV Intra-bucket Correlation (same sign, neg)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC413() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_4, S_EQV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("21872111"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C393,C395,C406
   * Element Tested: EQV Intra-bucket Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC414() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_1, S_EQV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("65396786"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C393,C399,C406,C408
   * Element Tested: EQV Intra-bucket Correlation (exceeds concentration threshold)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC415() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_1, S_EQV_7, S_EQV_7, S_EQV_7, S_EQV_7, S_EQV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("117609230"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C395,C396
   * Element Tested: EQV Inter-bucket Correlation (same sign)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC416() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_3, S_EQV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("31573921"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C394,C398,C407
   * Element Tested: EQV Inter-bucket Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC417() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_2, S_EQV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("139055245"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C394,C398,C404,C407,C411,C417
   * Element Tested: EQV Inter-bucket Correlation (w/residual)
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC418() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV_2, S_EQV_6, S_EQV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("143567654"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C393-C418
   * Element Tested: All Equity Vol Sensitivities
   * Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC419() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_EQV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("2858286431"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC420() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1048112921"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC421() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("225185001"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC422() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("34154290"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC423() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("383486763"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC424() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("119839613"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC425() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("94571571"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC426() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("498450928"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC427() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("192586170"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC428() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("33237706"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC429() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("83887729"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC430() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("200294063"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC431() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("88660848"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC432() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("88965654"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC433() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("19174338"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC434() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("34717915"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: CMV Risk Weight
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC435() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("34933247"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C420
   * Element Tested: CMV Concentration (bkt 1)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC436() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("11917253995"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C423
   * Element Tested: CMV Concentration (bkt 2)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC437() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("29315068119"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C425
   * Element Tested: CMV Concentration (bkt 3-5)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC438() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("7053517794"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C426
   * Element Tested: CMV Concentration (bkt 6-7)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC439() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("27909776729"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C427
   * Element Tested: CMV Concentration (bkt 8-9)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC440() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("12111722007"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C428
   * Element Tested: CMV Concentration (bkt 10)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC441() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_9, S_CMV_9, S_CMV_9, S_CMV_9, S_CMV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("345614119"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C429
   * Element Tested: CMV Concentration (bkt 11)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC442() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("5882017689"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C430
   * Element Tested: CMV Concentration (bkt 12)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC443() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("11129368476"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C431
   * Element Tested: CMV Concentration (bkt 13-15)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC444() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("3870097407"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C434
   * Element Tested: CMV Concentration (bkt 16)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC445() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("986215211"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C432
   * Element Tested: CMV Concentration (bkt 17)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC446() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("7428052227"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C420,C421,C436
   * Element Tested: CMV Intra-bucket Correlation (same sign, pos)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC447() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_1, S_CMV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1120536198"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C423,C424,C437
   * Element Tested: CMV Intra-bucket Correlation (same sign, neg)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC448() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_4, S_CMV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("501496924"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C421,C422
   * Element Tested: CMV Intra-bucket Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC449() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_2, S_CMV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("227123787"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C420,C422,C436
   * Element Tested: CMV Intra-bucket Correlation (exceeds concentration threshold)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC450() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("11900439724"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C420,C425,C436,C438
   * Element Tested: CMV Inter-bucket Correlation (same sign)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC451() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_1, S_CMV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1089080081"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C421,C428,C441
   * Element Tested: CMV Inter-bucket Correlation (diff sign)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC452() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_2, S_CMV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("238128272"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C421,C428,C434,C441,C445,C452
   * Element Tested: CMV Inter-bucket Correlation (w/residual)
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC453() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV_2, S_CMV_9, S_CMV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("248339715"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C420-C453
   * Element Tested: All Commodity Vol Sensitivities
   * Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC454() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1641442521"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299-C454
   * Element Tested: All Vega Sensitivities (no multiplier)
   * Risk Measure: Vega & Curvature
   * Group: Global
   */
  @Test
  public void testC455() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV, S_FXV, S_CRV, S_CNV, S_EQV, S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("6970117465"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C299-C455
   * Element Tested: All Vega Sensitivities (with multipliers)
   * Risk Measure: Vega & Curvature
   * Group: Global
   */
  @Test
  public void testC456() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = S_MUL;
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IRV, S_FXV, S_CRV, S_CNV, S_EQV, S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("7781893257"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: None
   * Element Tested: One Trade
   * Risk Measure: Notional
   * Group: AddOn
   */
  @Test
  public void testC457() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList(S_AN_1);
    List<AddOnNotional> notional = Arrays.asList(S_AN_3);
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList();
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
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
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList(S_AN_2);
    List<AddOnNotional> notional = Arrays.asList(S_AN_4, S_AN_5);
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList();
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
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
    List<AddOnFixedAmount> fixed = Arrays.asList(S_AN_7, S_AN_8);
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = Arrays.asList();
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
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
    List<AddOnFixedAmount> fixed = Arrays.asList(S_AN_7, S_AN_8);
    List<AddOnNotionalFactor> factors = Arrays.asList(S_AN_1, S_AN_2);
    List<AddOnNotional> notional = Arrays.asList(S_AN_3, S_AN_4, S_AN_5, S_AN_6);
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = new ArrayList<>();
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
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
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR_41, S_FX_11, S_CRQ_1, S_CRNQ_1, S_EQ_25, S_CM_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("1045576383"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C456,C461
   * Element Tested: Combination (All w/o Multipliers and Notionals)
   * Risk Measure: All
   * Group: Global
   */
  @Test
  public void testC462() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = Arrays.asList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR, S_CRQ, S_CRNQ, S_CM, S_FX, S_EQ, S_IRV, S_FXV, S_CRV, S_CNV, S_EQV, S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("130485395689"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C456,C461,C462
   * Element Tested: Combination (All w/Multiplier)
   * Risk Measure: All
   * Group: Global
   */
  @Test
  public void testC463() {
    List<AddOnFixedAmount> fixed = Arrays.asList();
    List<AddOnNotionalFactor> factors = Arrays.asList();
    List<AddOnNotional> notional = Arrays.asList();
    List<ProductMultiplier> multipliers = S_MUL;
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR, S_CRQ, S_CRNQ, S_CM, S_FX, S_EQ, S_IRV, S_FXV, S_CRV, S_CNV, S_EQV, S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("140210679674"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C463
   * Element Tested: Combination (All w/Notionals
   * Risk Measure: All
   * Group: Global
   */
  @Test
  public void testC464() {
    List<AddOnFixedAmount> fixed = Arrays.asList(S_AN_7, S_AN_8);
    List<AddOnNotionalFactor> factors = Arrays.asList(S_AN_1, S_AN_2);
    List<AddOnNotional> notional = Arrays.asList(S_AN_3, S_AN_4, S_AN_5, S_AN_6);
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = new ArrayList<>();
		addAnything(sensitivities, S_IR, S_CRQ, S_CRNQ, S_CM, S_FX, S_EQ, S_IRV, S_FXV, S_CRV, S_CNV, S_EQV, S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("130565395689"), amount.setScale(0, RoundingMode.HALF_UP));
  }


  /**
   * Required Passes: C1-C464
   * Element Tested: Combination (All)
   * Risk Measure: All
   * Group: Global
   */
  @Test
  public void testC465() {
    List<AddOnFixedAmount> fixed = Arrays.asList(S_AN_7, S_AN_8);
    List<AddOnNotionalFactor> factors = Arrays.asList(S_AN_1, S_AN_2);
    List<AddOnNotional> notional = Arrays.asList(S_AN_3, S_AN_4, S_AN_5, S_AN_6);
    List<ProductMultiplier> multipliers = S_MUL;
    List<Sensitivity> sensitivities = new ArrayList<>();
    addAnything(sensitivities, S_IR, S_CRQ, S_CRNQ, S_CM, S_FX, S_EQ, S_IRV, S_FXV, S_CRV, S_CNV, S_EQV, S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD);
    Assert.assertEquals(new BigDecimal("140290679674"), amount.setScale(0, RoundingMode.HALF_UP));
  }
}
