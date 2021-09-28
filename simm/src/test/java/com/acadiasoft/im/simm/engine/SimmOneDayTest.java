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

public class SimmOneDayTest implements SimmCrifMixin {

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular, 2w) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC1() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("72000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC2() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("36000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC3() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("26000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC4() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("39000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC5() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC6() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("32000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC7() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("80000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC8() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("160000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC9() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("400000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC10() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("560000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC11() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("30000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC12() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("36000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC13() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("30000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC14() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("68000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC15() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("160000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (regular) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC16() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("306000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (inflation) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC17() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("150000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (xccy) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC18() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("168000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (low vol, 2w) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC19() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1700000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (low vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC20() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5100000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (low vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC21() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (low vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC22() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (low vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC23() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (low vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC24() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (low vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC25() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("29000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (low vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC26() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_26);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("136000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (low vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC27() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("325000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (low vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC28() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_28);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (low vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC29() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_29);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("15000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (low vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC30() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_30);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("24900000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (inflation) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC31() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_31);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("225000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (xccy) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC32() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (high vol, 2w) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC33() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("36000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (high vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC34() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_34);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("40500000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (high vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC35() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_35);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (high vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC36() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_36);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (high vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC37() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_37);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("207000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (high vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC38() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_38);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("230000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (high vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC39() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_39);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (high vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC40() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_40);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("31000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (high vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC41() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_41);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("448000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (high vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC42() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_42);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("600000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (high vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC43() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_43);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("25600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (high vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC44() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_44);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("21600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (inflation) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC45() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_45);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("30000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IR Risk Weight (xccy) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC46() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IR_46);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C8,C9 Element Tested: Net Sensitivities (same tenor & subcurve, same sign) Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC47() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_8, S_IR_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("560000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C4,C5 Element Tested: Net Sensitivities (same tenor & subcurve, diff sign) Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC48() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_4, S_IR_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("26000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C8-C10,C47 Element Tested: Concentration (reg vol, well traded) Risk Measure: Delta Group: Rates &
   * Fx
   */
  @Test
  public void testC49() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_8, S_IR_9, S_IR_10, S_IR_8, S_IR_9, S_IR_10, S_IR_8, S_IR_9, S_IR_10, S_IR_8, S_IR_9, S_IR_10, S_IR_8, S_IR_9, S_IR_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5529556944"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C14-C16 Element Tested: Concentration (reg vol, less traded) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC50() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_14, S_IR_15, S_IR_16, S_IR_14, S_IR_15, S_IR_16, S_IR_14, S_IR_15, S_IR_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1195086139"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C14-C18,C50 Element Tested: Concentration (reg vol, w/inf & xccy) Risk Measure: Delta Group: Rates
   * & Fx
   */
  @Test
  public void testC51() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_14, S_IR_15, S_IR_16, S_IR_14, S_IR_15, S_IR_16, S_IR_14, S_IR_15, S_IR_16, S_IR_17, S_IR_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1164752231"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C26-C28 Element Tested: Concentration (low vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC52() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_26, S_IR_27, S_IR_28, S_IR_26, S_IR_27, S_IR_28, S_IR_26, S_IR_27, S_IR_28);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1348345186"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C26-C28,C31,C32,C52 Element Tested: Concentration (low vol, w/inf & xccy) Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC53() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_26, S_IR_27, S_IR_28, S_IR_26, S_IR_27, S_IR_28, S_IR_26, S_IR_27, S_IR_28, S_IR_31, S_IR_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1456220685"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C41-C44 Element Tested: Concentration (high vol) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC54() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_41, S_IR_42, S_IR_43, S_IR_44);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("995011816"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C41-C46,C54 Element Tested: Concentration (high vol, w/inf & xccy) Risk Measure: Delta Group:
   * Rates & Fx
   */
  @Test
  public void testC55() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_41, S_IR_42, S_IR_43, S_IR_44, S_IR_45, S_IR_46);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1007368556"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C3,C4 Element Tested: Subcurve Correlation (same tenor, same sign) Risk Measure: Delta Group:
   * Rates & Fx
   */
  @Test
  public void testC56() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_3, S_IR_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("64781232"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C6,C7 Element Tested: Subcurve Correlation (same tenor, diff sign) Risk Measure: Delta Group:
   * Rates & Fx
   */
  @Test
  public void testC57() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_6, S_IR_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("48740948"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C2,C5 Element Tested: Tenor Correlation (diff subcurve) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC58() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_2, S_IR_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("45643623"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C11,C12 Element Tested: Tenor Correlation (same sign, same subcurve) Risk Measure: Delta Group:
   * Rates & Fx
   */
  @Test
  public void testC59() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_11, S_IR_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("60537592"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C12,C13 Element Tested: Tenor Correlation (diff sign, same subcurve) Risk Measure: Delta Group:
   * Rates & Fx
   */
  @Test
  public void testC60() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_12, S_IR_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("26153394"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C19-C30,C52 Element Tested: Tenor Correlation (all tenors and subcurves) Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC61() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_19, S_IR_20, S_IR_21, S_IR_22, S_IR_23, S_IR_24, S_IR_25, S_IR_26, S_IR_27, S_IR_28, S_IR_29, S_IR_30);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("508834881"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C19-C32,C52,C53,C61 Element Tested: Tenor Correlation (all tenors and subcurves, w/inf & xccy)
   * Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC62() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_19, S_IR_20, S_IR_21, S_IR_22, S_IR_23, S_IR_24, S_IR_25, S_IR_26, S_IR_27, S_IR_28, S_IR_29, S_IR_30, S_IR_31, S_IR_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("637108500"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C1,C22,C33 Element Tested: Inter bucket correlation (all pos) Risk Measure: Delta Group: Rates &
   * Fx
   */
  @Test
  public void testC63() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_1, S_IR_22, S_IR_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("88467847"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C1,C19,C33 Element Tested: Inter bucket correlation (one neg) Risk Measure: Delta Group: Rates &
   * Fx
   */
  @Test
  public void testC64() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_1, S_IR_19, S_IR_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("86848063"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C2,C19,C35 Element Tested: Inter bucket correlation (all neg) Risk Measure: Delta Group: Rates &
   * Fx
   */
  @Test
  public void testC65() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_2, S_IR_19, S_IR_35);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("39019508"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C3,C21,C37,C38 Element Tested: Inter bucket correlation (exceeds concentration threshold) Risk
   * Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC66() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_3, S_IR_21, S_IR_37, S_IR_38, S_IR_37, S_IR_38);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("864546406"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C1-C66 Element Tested: All jurisdiction independent IR sensitivities Risk Measure: Delta Group:
   * Rates & Fx
   */
  @Test
  public void testC67() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = S_IR;
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2816177830"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: FX Risk Weight & correlation (net to zero) Risk Measure: Delta Group: Rates &
   * Fx
   */
  @Test
  public void testC68() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_1, S_FX_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(BigDecimal.ZERO, amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: FX Risk Weight & correlation (AmountCurrency qualifier) Risk Measure: Delta
   * Group: Rates & Fx
   */
  @Test
  public void testC69() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_3, S_FX_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10800000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: FX Risk Weight (RR) & correlation (RR) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC70() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_5, S_FX_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1629074584"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: FX Risk Weight (RR) & correlation (RR) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC71() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_7, S_FX_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("369329122"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: FX Risk Weight (RH) & correlation (RH) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC72() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_9, S_FX_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("754665489"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: FX Risk Weight (RH) & correlation (HR) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC73() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_11, S_FX_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("123909806"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: Concentration (significantly trading) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC74() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_3, S_FX_6, S_FX_3, S_FX_6, S_FX_3, S_FX_6, S_FX_3, S_FX_6, S_FX_3, S_FX_6, S_FX_3, S_FX_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("74520000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: Concentration (frequently traded) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC75() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8, S_FX_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3780000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: Concentration (others) Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC76() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_10, S_FX_10, S_FX_10, S_FX_10, S_FX_10, S_FX_10, S_FX_10, S_FX_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7200000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C69,C70,C74 Element Tested: FX Intercurrency Correlation (3 ccys) Risk Measure: Delta Group: Rates
   * & Fx
   */
  @Test
  public void testC77() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_3, S_FX_4, S_FX_5, S_FX_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11687407069"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C70,C71,C75 Element Tested: FX Intercurrency Correlation (4 ccys) Risk Measure: Delta Group: Rates
   * & Fx
   */
  @Test
  public void testC78() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FX_5, S_FX_6, S_FX_7, S_FX_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1670512496"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C70,C72,C76 Element Tested: FX Intercurrency Correlation (exceeds concentration threshold) Risk
   * Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC79() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities =
        Arrays.asList(S_FX_5, S_FX_6, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10, S_FX_9, S_FX_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6248995247"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C68-C79 Element Tested: All FX sensitivities Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC80() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = S_FX;
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12001860235"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C1-C80 Element Tested: All Rates & FX Sensitivities Risk Measure: Delta Group: Rates & Fx
   */
  @Test
  public void testC81() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = new ArrayList<>();
    sensitivities.addAll(S_IR);
    sensitivities.addAll(S_FX);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13554392170"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 1) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC82() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 1) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC83() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6900000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 2) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC84() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4860000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 2) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC85() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4860000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 3) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC86() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3240000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 3) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC87() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 4) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC88() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2160000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 4) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC89() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 5) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC90() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2340000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 5) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC91() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1300000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 6) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC92() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2160000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 7) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC93() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("14700000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 8) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC94() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 9) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC95() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8640000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 10) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC96() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5900000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 11) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC97() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7380000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (bkt 12) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC98() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4100000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (residual) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC99() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16560000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (residual) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC100() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (residual) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC101() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16560000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (residual) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC102() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16560000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (residual) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC103() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (base corr) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC104() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1350000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (base corr) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC105() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("540000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRQ Risk Weight (base corr) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC106() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRQ_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1080000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C82,C83 Element Tested: CRQ Concentration (bkt 1) (diff tenors) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC107() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_1, S_CRQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12351664"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C85 Element Tested: CRQ Concentration (bkt 2-6) (same sign) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC108() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_4, S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9720000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C93 Element Tested: CRQ Concentration (bkt 7) (all neg) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC109() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_12, S_CRQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("29400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C95 Element Tested: CRQ Concentration (bkt 8-12) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC110() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_14, S_CRQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17280000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C82,C83,C107 Element Tested: CRQ Intra-bucket Correlation (same name, diff tenor) Risk Measure:
   * Delta Group: Credit
   */
  @Test
  public void testC111() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3930242"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C84,C85,C108 Element Tested: CRQ Intra-bucket Correlation (same name, diff ccy) Risk Measure:
   * Delta Group: Credit
   */
  @Test
  public void testC112() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_3, S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1944000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C86,C87 Element Tested: CRQ Intra-bucket Correlation (same name, diff tenor, diff ccy) Risk
   * Measure: Delta Group: Credit
   */
  @Test
  public void testC113() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_5, S_CRQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1733990"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C88,C89 Element Tested: CRQ Intra-bucket Correlation (same name, same tenor, same ccy) Risk
   * Measure: Delta Group: Credit
   */
  @Test
  public void testC114() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_7, S_CRQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("960000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C90,C91 Element Tested: CRQ Intra-bucket Correlation (diff name) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC115() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_9, S_CRQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2161287"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C99,C100 Element Tested: CRQ Intra-bucket Correlation (residual, same name, diff tenor) Risk
   * Measure: Delta Group: Credit
   */
  @Test
  public void testC116() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_18, S_CRQ_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("14370859"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C100,C101 Element Tested: CRQ Intra-bucket Correlation (residual, diff name) Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC117() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_19, S_CRQ_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("14370859"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C84,C86 Element Tested: CRQ Inter-bucket Correlation (exceeds concentration threshold) Risk
   * Measure: Delta Group: Credit
   */
  @Test
  public void testC118() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_3, S_CRQ_3, S_CRQ_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11519100"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C82,C84 Element Tested: CRQ Inter-bucket Correlation (same sign, pos) Risk Measure: Delta Group:
   * Credit
   */
  @Test
  public void testC119() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11813467"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C83,C85,C108 Element Tested: CRQ Inter-bucket Correlation (same sign, neg) Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC120() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_2, S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9731567"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C82,C85,C108 Element Tested: CRQ Inter-bucket Correlation (diff sign) Risk Measure: Delta Group:
   * Credit
   */
  @Test
  public void testC121() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8772753"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C82,C85,C99,C108,C121 Element Tested: CRQ Inter-bucket Correlation (diff sign) Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC122() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_4, S_CRQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("25332753"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C82,C84,C86,C88,C90,C92,C118,C119 Element Tested: CRQ Inter-bucket Correlation (bkts 1-3, 4-6)
   * Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC123() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_7, S_CRQ_9, S_CRQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17524916"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C82,C84,C86,C93-C95,C109,C110,C118,C119 Element Tested: CRQ Inter-bucket Correlation (bkts 1-3,
   * 7-9) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC124() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_12, S_CRQ_13, S_CRQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("18159493"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C82,C84,C86,C96-C98,C118,C119 Element Tested: CRQ Inter-bucket Correlation (bkts 1-3, 10-12) Risk
   * Measure: Delta Group: Credit
   */
  @Test
  public void testC125() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_15, S_CRQ_16, S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("14888149"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C88,C90,C92-C95,C109,C110 Element Tested: CRQ Inter-bucket Correlation (bkts 4-6, 7-9) Risk
   * Measure: Delta Group: Credit
   */
  @Test
  public void testC126() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_7, S_CRQ_9, S_CRQ_11, S_CRQ_12, S_CRQ_13, S_CRQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16975543"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C88,C90,C92,C96-C98 Element Tested: CRQ Inter-bucket Correlation (bkts 4-6, 10-12) Risk Measure:
   * Delta Group: Credit
   */
  @Test
  public void testC127() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_7, S_CRQ_9, S_CRQ_11, S_CRQ_15, S_CRQ_16, S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9357821"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C93-C98,C109,C110 Element Tested: CRQ Inter-bucket Correlation (bkts 7-9, 10-12) Risk Measure:
   * Delta Group: Credit
   */
  @Test
  public void testC128() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_12, S_CRQ_13, S_CRQ_14, S_CRQ_15, S_CRQ_16, S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("20410293"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C82,C84,C86,C88,C90,C92-C98,C109,C110,C118,C119,C123-C128 Element Tested: CRQ Inter-bucket
   * Correlation (all) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC129() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_7, S_CRQ_9, S_CRQ_11, S_CRQ_12, S_CRQ_13, S_CRQ_14, S_CRQ_15, S_CRQ_16, S_CRQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("20949049"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C82,C84,C86,C88,C90,C92-C99,C109,C110,C118,C119,C123-C129 Element Tested: CRQ Inter-bucket
   * Correlation (all + residual) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC130() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_1, S_CRQ_3, S_CRQ_5, S_CRQ_7, S_CRQ_9, S_CRQ_11, S_CRQ_12, S_CRQ_13, S_CRQ_14, S_CRQ_15, S_CRQ_16, S_CRQ_17, S_CRQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("37509049"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C104,C105 Element Tested: CRQ Base Corr Netting Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC131() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_23, S_CRQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("810000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C104-C106,C131 Element Tested: CRQ Base Corr Correlation Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC132() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRQ_23, S_CRQ_24, S_CRQ_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1503296"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C82-C132 Element Tested: All Credit Qualifying (no multiplier) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC133() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = S_CRQ;
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("52316822"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (bkt 1) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC134() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("444000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (bkt 1) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC135() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("222000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (bkt 1) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC136() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("222000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (bkt 1) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC137() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("148000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (bkt 1) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC138() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("222000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (bkt 1) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC139() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("296000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (bkt 2) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC140() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("96000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (bkt 2) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC141() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("48000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (bkt 2) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC142() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("48000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (bkt 2) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC143() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("48000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (bkt 2) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC144() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("48000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (bkt 2) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC145() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("72000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (residual) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC146() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("96000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (residual) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC147() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("48000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (residual) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC148() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("72000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Risk Weight (residual) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC149() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRNQ_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("24000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C134,C135 Element Tested: CRNQ Concentration (bkt 1) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC150() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_1, S_CRNQ_2, S_CRNQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("856356188"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C140,C143 Element Tested: CRNQ Concentration (bkt 2) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC151() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_7, S_CRNQ_7, S_CRNQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("152697348"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C146,C148 Element Tested: CRNQ Concentration (residual) Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC152() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_13, S_CRNQ_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("145986301"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C134,C135,C150 Element Tested: CRNQ Intra-bucket correlation (same name, same sign) Risk Measure:
   * Delta Group: Credit
   */
  @Test
  public void testC153() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_1, S_CRNQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("644947254"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C135,C136 Element Tested: CRNQ Intra-bucket correlation (same name, opp sign) Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC154() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_2, S_CRNQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("117471358"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C136,C137 Element Tested: CRNQ Intra-bucket correlation (diff name, same sign) Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC155() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_3, S_CRNQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("304750652"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C136,C139 Element Tested: CRNQ Intra-bucket correlation (diff name, opp sign) Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC156() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_3, S_CRNQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("424582053"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C146,C147 Element Tested: CRNQ Intra-bucket correlation (residual) Risk Measure: Delta Group:
   * Credit
   */
  @Test
  public void testC157() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_13, S_CRNQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("83138439"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C134,C140 Element Tested: CRNQ Intra-bucket correlation (exceeds concentration threshold) Risk
   * Measure: Delta Group: Credit
   */
  @Test
  public void testC158() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_1, S_CRNQ_1, S_CRNQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("858126704"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C134,C140,C158 Element Tested: CRNQ Inter-bucket correlation (same sign, pos) Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC159() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_1, S_CRNQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("419121367"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C136,C141 Element Tested: CRNQ Inter-bucket correlation (same sign, neg) Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC160() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_3, S_CRNQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("243434426"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C135,C141 Element Tested: CRNQ Inter-bucket correlation (diff sign) Risk Measure: Delta Group:
   * Credit
   */
  @Test
  public void testC161() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_2, S_CRNQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("209560683"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C135,C141,C146,C161 Element Tested: CRNQ Inter-bucket correlation (w/residual) Risk Measure: Delta
   * Group: Credit
   */
  @Test
  public void testC162() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRNQ_2, S_CRNQ_8, S_CRNQ_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("305560683"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C134-C162 Element Tested: All Credit Non Qualifying Risk Measure: Delta Group: Credit
   */
  @Test
  public void testC163() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = S_CRNQ;
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("569801441"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C82-C163 Element Tested: All Credit Qualifying and Non-Qualifying Risk Measure: Delta Group:
   * Credit
   */
  @Test
  public void testC164() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = new ArrayList<>();
    sensitivities.addAll(S_CRQ);
    sensitivities.addAll(S_CRNQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("595180571"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 1) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC165() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("49800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 1) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC166() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8300000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 2) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC167() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("18200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 2) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC168() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9100000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 3) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC169() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 3) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC170() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 4) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC171() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("18000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 4) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC172() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 5) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC173() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("77000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 5) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC174() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("15400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 6) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC175() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("33600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 6) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC176() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 7) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC177() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("37200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 7) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC178() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("18600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 8) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC179() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("37600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 8) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC180() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("18800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 9) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC181() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3960000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 9) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC182() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9900000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 10) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC183() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 10) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC184() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 11) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC185() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6000000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 11) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC186() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 11) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC187() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 12) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC188() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("18000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 12) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC189() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (bkt 12) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC190() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_26);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (residual) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC191() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7700000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQ Risk Weight (residual) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC192() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQ_28);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3300000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C165 Element Tested: EQ Concentration (bkt 1-4) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC193() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("99600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C173 Element Tested: EQ Concentration (bkt 5-8) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC194() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_9, S_EQ_9, S_EQ_9, S_EQ_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("308000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C182 Element Tested: EQ Concentration (bkt 9) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC195() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_18, S_EQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C183 Element Tested: EQ Concentration (bkt 10) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC196() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_19, S_EQ_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C185 Element Tested: EQ Concentration (bkt 11-12) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC197() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21, S_EQ_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("60000000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C191 Element Tested: EQ Concentration (residual) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC198() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_27, S_EQ_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("15400000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C165,C166,C193 Element Tested: EQ Intra Bucket Correlation (Bkt 1) Risk Measure: Delta Group:
   * Equities
   */
  @Test
  public void testC199() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("51939700"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C167,C168 Element Tested: EQ Intra Bucket Correlation (Bkt 2) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC200() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_3, S_EQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("18381099"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C169,C170 Element Tested: EQ Intra Bucket Correlation (Bkt 3) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC201() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_5, S_EQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19303761"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C171,C172 Element Tested: EQ Intra Bucket Correlation (Bkt 4) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC202() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_7, S_EQ_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("22191890"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C173,C174,C194 Element Tested: EQ Intra Bucket Correlation (Bkt 5) Risk Measure: Delta Group:
   * Equities
   */
  @Test
  public void testC203() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_9, S_EQ_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("81924526"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C175,C176 Element Tested: EQ Intra Bucket Correlation (Bkt 6) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC204() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_11, S_EQ_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("31698177"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C177,C178 Element Tested: EQ Intra Bucket Correlation (Bkt 7) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC205() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_13, S_EQ_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("34697850"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C179,C180 Element Tested: EQ Intra Bucket Correlation (Bkt 8) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC206() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_15, S_EQ_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("47560656"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C181,C182,C195 Element Tested: EQ Intra Bucket Correlation (Bkt 9) Risk Measure: Delta Group:
   * Equities
   */
  @Test
  public void testC207() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_17, S_EQ_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9860320"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C183,C184,C196 Element Tested: EQ Intra Bucket Correlation (Bkt 10) Risk Measure: Delta Group:
   * Equities
   */
  @Test
  public void testC208() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_19, S_EQ_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9887770"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C186,C187 Element Tested: EQ Intra Bucket Correlation (Bkt 11) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC209() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_22, S_EQ_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10111380"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C189,C190 Element Tested: EQ Intra Bucket Correlation (Bkt 12) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC210() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_25, S_EQ_26);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10111380"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C165,C166,C193,C199 Element Tested: EQ Intra Bucket Correlation (exceeds concentration threshold)
   * Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC211() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_1, S_EQ_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("101423147"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C165,C168,C193 Element Tested: EQ Inter-bucket Correlation (same sign, pos) Risk Measure: Delta
   * Group: Equities
   */
  @Test
  public void testC212() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("52384368"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C167,C170 Element Tested: EQ Inter-bucket Correlation (same sign, neg) Risk Measure: Delta Group:
   * Equities
   */
  @Test
  public void testC213() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_3, S_EQ_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("22725756"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C165,C167,C193 Element Tested: EQ Inter-bucket Correlation (diff sign) Risk Measure: Delta Group:
   * Equities
   */
  @Test
  public void testC214() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("49484705"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C165,C167,C191,C193,C198,C214 Element Tested: EQ Inter-bucket Correlation (w/residual) Risk
   * Measure: Delta Group: Equities
   */
  @Test
  public void testC215() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_3, S_EQ_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("57184705"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C165,C167,C169,C171,C173,C175,C193,C194,C214 Element Tested: EQ Inter-bucket Correlation (bks 1-3,
   * 4-6) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC216() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_3, S_EQ_5, S_EQ_7, S_EQ_9, S_EQ_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("94785522"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C165,C167,C169,C177,C179,C181,C193,C214 Element Tested: EQ Inter-bucket Correlation (bks 1-3, 7-9)
   * Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC217() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_3, S_EQ_5, S_EQ_13, S_EQ_15, S_EQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("70782049"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C165,C167,C169,C183,C185,C188,C193,C196,C197,C214 Element Tested: EQ Inter-bucket Correlation (bks
   * 1-3, 10-12) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC218() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_3, S_EQ_5, S_EQ_19, S_EQ_21, S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6025090442"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C171,C173,C175,C177,C179,C181,C194 Element Tested: EQ Inter-bucket Correlation (bks 4-6, 7-9) Risk
   * Measure: Delta Group: Equities
   */
  @Test
  public void testC219() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_7, S_EQ_9, S_EQ_11, S_EQ_13, S_EQ_15, S_EQ_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("87261543"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C171,C173,C175,C183,C185,C188,C194,C196,C197 Element Tested: EQ Inter-bucket Correlation (bks 4-6,
   * 10-12) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC220() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_7, S_EQ_9, S_EQ_11, S_EQ_19, S_EQ_21, S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6017736341"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C177,C179,C181,C183,C185,C188,C196,C197 Element Tested: EQ Inter-bucket Correlation (bks 7-9,
   * 10-12) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC221() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_13, S_EQ_15, S_EQ_17, S_EQ_19, S_EQ_21, S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6014067502"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C165,C167,C169,C171,C173,C175,C177,C179,C181,C183,C185,C188,C193,C194,C196,C197,C214,C216-C221
   * Element Tested: EQ Inter-bucket Correlation (all) Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC222() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQ_1, S_EQ_3, S_EQ_5, S_EQ_7, S_EQ_9, S_EQ_11, S_EQ_13, S_EQ_15, S_EQ_17, S_EQ_19, S_EQ_21, S_EQ_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6032293371"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C165-C222 Element Tested: All Equity Sensitivities Risk Measure: Delta Group: Equities
   */
  @Test
  public void testC223() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = S_EQ;
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6040543727"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 1) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC224() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("945000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 1) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC225() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6300000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 2) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC226() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13650000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 2) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC227() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9100000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 3) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC228() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2916000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 3) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC229() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8100000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 4) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC230() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("72000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 4) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC231() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 5) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC232() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("100000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 5) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC233() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 6) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC234() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5200000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 6) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC235() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 7) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC236() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("71000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 8) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC237() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3300000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 8) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC238() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 9) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC239() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("81000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 9) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC240() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8100000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 10) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC241() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("816000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 10) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC242() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 11) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC243() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1860000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 11) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC244() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 12) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC245() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4960000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 12) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC246() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 13) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC247() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("94000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 13) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC248() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4700000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 14) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC249() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_26);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("48000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 14) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC250() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 15) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC251() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_28);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("38000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 15) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC252() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_29);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3800000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 16) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC253() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_30);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("400000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 16) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC254() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_31);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("32000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 17) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC255() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6630000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CM Risk Weight (bkt 17) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC256() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CM_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C224 Element Tested: CM Concentration (bkt 1) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC257() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1, S_CM_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9450000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C226 Element Tested: CM Concentration (bkt 2) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC258() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3, S_CM_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("136500000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C228 Element Tested: CM Concentration (bkt 3-5) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC259() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5, S_CM_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("29160000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C234 Element Tested: CM Concentration (bkt 6-7) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC260() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11, S_CM_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("52000000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C237 Element Tested: CM Concentration (bkt 8-9) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC261() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14, S_CM_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("33000000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C241 Element Tested: CM Concentration (bkt 10) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC262() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_18, S_CM_18, S_CM_18, S_CM_18, S_CM_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4080000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C243 Element Tested: CM Concentration (bkt 11) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC263() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20, S_CM_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("18600000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C245 Element Tested: CM Concentration (bkt 12) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC264() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22, S_CM_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("49600000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C247 Element Tested: CM Concentration (bkt 13-15) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC265() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24, S_CM_24);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("940000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C253 Element Tested: CM Concentration (bkt 16) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC266() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30, S_CM_30);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4000000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C255 Element Tested: CM Concentration (bkt 17) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC267() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("66300000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C224,C225,C257 Element Tested: CM Intra Bucket Correlation (Bkt 1) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC268() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_1, S_CM_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("949984853"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C226,C227,C258 Element Tested: CM Intra Bucket Correlation (Bkt 2) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC269() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_3, S_CM_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13641082120"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C228,C229,C259 Element Tested: CM Intra Bucket Correlation (Bkt 3) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC270() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_5, S_CM_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2908224884"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C230,C231 Element Tested: CM Intra Bucket Correlation (Bkt 4) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC271() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_7, S_CM_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("79003392"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C232,C233 Element Tested: CM Intra Bucket Correlation (Bkt 5) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC272() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_9, S_CM_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("109818031"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C234,C235,C260 Element Tested: CM Intra Bucket Correlation (Bkt 6) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC273() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_11, S_CM_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5192961390"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C237,C238,C261 Element Tested: CM Intra Bucket Correlation (Bkt 8) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC274() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_14, S_CM_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3304635078"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C239,C240 Element Tested: CM Intra Bucket Correlation (Bkt 9) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC275() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_16, S_CM_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("86862823"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C241,C242,C262 Element Tested: CM Intra Bucket Correlation (Bkt 10) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC276() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_18, S_CM_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("810055208"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C243,C244,C263 Element Tested: CM Intra Bucket Correlation (Bkt 11) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC277() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_20, S_CM_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1856659333"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C245,C246,C264 Element Tested: CM Intra Bucket Correlation (Bkt 12) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC278() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_22, S_CM_23);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4962978980"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C247,C248,C265 Element Tested: CM Intra Bucket Correlation (Bkt 13) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC279() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_24, S_CM_25);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("97211635"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C249,C250 Element Tested: CM Intra Bucket Correlation (Bkt 14) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC280() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_26, S_CM_27);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("47517576"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C251,C252 Element Tested: CM Intra Bucket Correlation (Bkt 15) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC281() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_28, S_CM_29);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("37309731"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C253,C254,C266 Element Tested: CM Intra Bucket Correlation (Bkt 16) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC282() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_30, S_CM_31);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("401277959"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C255,C256,C267 Element Tested: CM Intra Bucket Correlation (Bkt 17) Risk Measure: Delta Group:
   * Commodities
   */
  @Test
  public void testC283() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_32, S_CM_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6640200000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C237,C241,C261,C262 Element Tested: CM Intra Bucket Correlation (exceeds concentration threshold)
   * Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC284() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_18, S_CM_18, S_CM_18, S_CM_18, S_CM_18, S_CM_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5247513697"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C226,C229,C258 Element Tested: CM Inter Bucket Correlation (same sign, pos) Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC285() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_3, S_CM_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13657533325"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C227,C228,C259 Element Tested: CM Inter Bucket Correlation (same sign, neg) Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC286() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_4, S_CM_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2924464913"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C226,C228,C258,C259 Element Tested: CM Inter Bucket Correlation (diff signs) Risk Measure: Delta
   * Group: Commodities
   */
  @Test
  public void testC287() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_3, S_CM_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10990506449"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C226,C228,C254,C258,C259,C287 Element Tested: CM Inter Bucket Correlation (w/residual) Risk
   * Measure: Delta Group: Commodities
   */
  @Test
  public void testC288() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_3, S_CM_5, S_CM_31);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10990553034"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C224,C226,C228,C230,C232,C234,C236,C237,C257-C261,C287 Element Tested: CM Inter Bucket Correlation
   * (bkts 1-4, 5-8) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC289() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_1, S_CM_3, S_CM_5, S_CM_7, S_CM_9, S_CM_11, S_CM_13, S_CM_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12832545130"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C224,C226,C228,C230,C239,C241,C243,C245,C257-C259,C262-C264,C287 Element Tested: CM Inter Bucket
   * Correlation (bkts 1-4, 9-12) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC290() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_1, S_CM_3, S_CM_5, S_CM_7, S_CM_16, S_CM_18, S_CM_20, S_CM_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10635712745"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C224,C226,C228,C230,C247,C249,C251,C253,C255,C257-C259,C265-C267,C287 Element Tested: CM Inter
   * Bucket Correlation (bkts 1-4, 13-17) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC291() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_1, S_CM_3, S_CM_5, S_CM_7, S_CM_24, S_CM_26, S_CM_28, S_CM_30, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16060721706"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C232,C234,C236,C237,C239,C241,C243,C245,C260-C264,C284 Element Tested: CM Inter Bucket Correlation
   * (bkts 5-8, 9-12) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC292() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_9, S_CM_11, S_CM_13, S_CM_14, S_CM_16, S_CM_18, S_CM_20, S_CM_22);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6843764147"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C232,C234,C236,C237,C247,C249,C251,C253,C255,C260,C261,C265-C267 Element Tested: CM Inter Bucket
   * Correlation (bkts 5-8, 13-17) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC293() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_9, S_CM_11, S_CM_13, S_CM_14, S_CM_24, S_CM_26, S_CM_28, S_CM_30, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8772510562"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C239,C241,C243,C245,C247,C249,C251,C253,C255,C262-C267 Element Tested: CM Inter Bucket Correlation
   * (bkts 9-12, 13-17) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC294() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CM_16, S_CM_18, S_CM_20, S_CM_22, S_CM_24, S_CM_26, S_CM_28, S_CM_30, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7380421801"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes:
   * C224,C226,C228,C230,C232,C234,C236,C237,C239,C241,C243,C245,C247,C249,C251,C253,C255,C257-C267,C284,C287,C289-C294
   * Element Tested: CM Inter Bucket Correlation (all) Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC295() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities =
        Arrays.asList(S_CM_1, S_CM_3, S_CM_5, S_CM_7, S_CM_9, S_CM_11, S_CM_13, S_CM_14, S_CM_16, S_CM_18, S_CM_20, S_CM_22, S_CM_24, S_CM_26, S_CM_28, S_CM_30, S_CM_32);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16149244941"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C224-C295 Element Tested: All Commodities Risk Measure: Delta Group: Commodities
   */
  @Test
  public void testC296() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = S_CM;
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16159607412"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C1-C296 Element Tested: All Delta Sensitivities (no multiplier) Risk Measure: Delta Group: Global
   */
  @Test
  public void testC297() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = new ArrayList<>();
    sensitivities.addAll(S_IR);
    sensitivities.addAll(S_CRQ);
    sensitivities.addAll(S_CRNQ);
    sensitivities.addAll(S_CM);
    sensitivities.addAll(S_FX);
    sensitivities.addAll(S_EQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("36015317247"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C1-C297 Element Tested: All Delta Sensitivities (with multiplier) Risk Measure: Delta Group:
   * Global
   */
  @Test
  public void testC298() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = S_MUL;
    List<Sensitivity> sensitivities = new ArrayList<>();
    sensitivities.addAll(S_IR);
    sensitivities.addAll(S_CRQ);
    sensitivities.addAll(S_CRNQ);
    sensitivities.addAll(S_CM);
    sensitivities.addAll(S_FX);
    sensitivities.addAll(S_EQ);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("38793128472"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC299() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("28617957"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC300() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9708978"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC301() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6915046"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC302() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10217957"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC303() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4494365"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC304() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3148297"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC305() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3572446"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC306() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1937957"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC307() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("14779567"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC308() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("24959135"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC309() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("65677404"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC310() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("137297932"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC311() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC312() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC313() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4600000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC314() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3815728"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC315() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1941796"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC316() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("970898"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: IRV Risk Weight & Scaling Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC317() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_IRV_19);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("510898"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C299 Element Tested: Concentration (reg vol, well traded) Risk Measure: Vega & Curvature Group:
   * Rates & Fx
   */
  @Test
  public void testC318() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_1, S_IRV_1, S_IRV_1, S_IRV_1, S_IRV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("143089784"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C301 Element Tested: Concentration (reg vol, less traded) Risk Measure: Vega & Curvature Group:
   * Rates & Fx
   */
  @Test
  public void testC319() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_3, S_IRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13830093"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C301,C316,C319 Element Tested: Concentration (reg vol, w/inf Risk Measure: Vega & Curvature Group:
   * Rates & Fx
   */
  @Test
  public void testC320() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_3, S_IRV_3, S_IRV_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("14249875"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C300 Element Tested: Concentration (low vol) Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC321() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("48544892"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C300,C315,C321 Element Tested: Concentration (low vol, w/inf) Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC322() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_2, S_IRV_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("49360946"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C303 Element Tested: Concentration (high vol) Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC323() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_5, S_IRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8988731"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C303,C323 Element Tested: Concentration (high vol, w/inf) Risk Measure: Vega & Curvature Group:
   * Rates & Fx
   */
  @Test
  public void testC324() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_5, S_IRV_5, S_IRV_20);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9221452"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C299,C307,C318 Element Tested: Intra-currency Correlation (Same Sign - Pos) Risk Measure: Vega &
   * Curvature Group: Rates & Fx
   */
  @Test
  public void testC325() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_1, S_IRV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("39909292"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C311,C312 Element Tested: Intra-currency Correlation (Same Sign - Neg) Risk Measure: Vega &
   * Curvature Group: Rates & Fx
   */
  @Test
  public void testC326() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_13, S_IRV_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9176971"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C300,C313,C321 Element Tested: Intra-currency Correlation (Opposite sign) Risk Measure: Vega &
   * Curvature Group: Rates & Fx
   */
  @Test
  public void testC327() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_2, S_IRV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4981038"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C300,C313,C315,C321,C322,C327 Element Tested: Intra-currency Correlation (Opposite sign,
   * w/Inflation) Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC328() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_2, S_IRV_15, S_IRV_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6006669"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C300,C313,C315,C321,C322,C327,C328 Element Tested: IRV Inflation Vol Aggregate same-currency
   * (Opposite sign) Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC329() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_16, S_IRV_21);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(BigDecimal.ZERO, amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C299,C300,C318,C321 Element Tested: Inter-currency Correlation Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC330() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_1, S_IRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("32168840"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C299,C303,C318,C323 Element Tested: Inter-currency Correlation (exceeds concentration threshold)
   * Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC331() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_1, S_IRV_5, S_IRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("32153566"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C299-C301,C318,C319,C321,C330 Element Tested: Inter-currency Correlation (3 ccys) Risk Measure:
   * Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC332() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IRV_1, S_IRV_2, S_IRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("34614401"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C299-C332 Element Tested: All Interest Rate Vol Sensitivities Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC333() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = S_IRV;
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("217733915"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: FXV Risk Weight (RR) & Scaling Risk Measure: Vega & Curvature Group: Rates &
   * Fx
   */
  @Test
  public void testC334() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_FXV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("36930809"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: FXV Risk Weight (RR) & Scaling Risk Measure: Vega & Curvature Group: Rates &
   * Fx
   */
  @Test
  public void testC335() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_FXV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("106186884"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: FXV Risk Weight (HR) & Scaling Risk Measure: Vega & Curvature Group: Rates &
   * Fx
   */
  @Test
  public void testC336() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_FXV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("130984404"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: FXV Risk Weight (RR) & Scaling Risk Measure: Vega & Curvature Group: Rates &
   * Fx
   */
  @Test
  public void testC337() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_FXV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("18057944"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: FXV Risk Weight (RR) & Scaling Risk Measure: Vega & Curvature Group: Rates &
   * Fx
   */
  @Test
  public void testC338() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_FXV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13543458"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: FXV Risk Weight (RR) & Scaling Risk Measure: Vega & Curvature Group: Rates &
   * Fx
   */
  @Test
  public void testC339() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_FXV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11470653"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: FXV Risk Weight (RR) & Scaling Risk Measure: Vega & Curvature Group: Rates &
   * Fx
   */
  @Test
  public void testC340() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_FXV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("18057944"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: FXV Risk Weight (RH) & Scaling Risk Measure: Vega & Curvature Group: Rates &
   * Fx
   */
  @Test
  public void testC341() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_FXV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("45939719"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C334 Element Tested: FXV Concentration (sig:sig) Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC342() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1,
        S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1, S_FXV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("738616173"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C336 Element Tested: FXV Concentration (freq:sig) Risk Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC343() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3,
        S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3, S_FXV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2619688079"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C337 Element Tested: FXV Concentration (sig:other) Risk Measure: Vega & Curvature Group: Rates &
   * Fx
   */
  @Test
  public void testC344() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4, S_FXV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("180579444"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C338 Element Tested: FXV Concentration (freq:freq) Risk Measure: Vega & Curvature Group: Rates &
   * Fx
   */
  @Test
  public void testC345() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("135434583"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C339 Element Tested: FXV Concentration (freq:other) Risk Measure: Vega & Curvature Group: Rates &
   * Fx
   */
  @Test
  public void testC346() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6, S_FXV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("114706531"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C340 Element Tested: FXV Concentration (other:other) Risk Measure: Vega & Curvature Group: Rates &
   * Fx
   */
  @Test
  public void testC347() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7, S_FXV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("180579444"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C334,C335,C342 Element Tested: FXV Aggregate (swapped currencies) Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC348() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_1, S_FXV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("143117693"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C334,C348 Element Tested: FXV Aggregate (diff ccys, opposite sign) Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC349() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_1, S_FXV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("45560973"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C334,C348 Element Tested: FXV Aggregate (same ccy, diff tenor) Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC350() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_4, S_FXV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("54173833"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C334,C348 Element Tested: FXV Aggregate (same ccy, diff tenor) Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC351() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_1, S_FXV_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11445957"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C334,C336,C342,C343 Element Tested: FXV Correlation (same sign, pos) Risk Measure: Vega &
   * Curvature Group: Rates & Fx
   */
  @Test
  public void testC352() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_1, S_FXV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("153984640"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C337,C338,C344,C345 Element Tested: FXV Correlation (same sign, neg) Risk Measure: Vega &
   * Curvature Group: Rates & Fx
   */
  @Test
  public void testC353() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_4, S_FXV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("27460547"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C336,C337,C343,C344 Element Tested: FXV Correlation (diff sign) Risk Measure: Vega & Curvature
   * Group: Rates & Fx
   */
  @Test
  public void testC354() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_3, S_FXV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("125091761"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C336,C338,C343,C345 Element Tested: FXV Correlation (exceeds concentration threshold) Risk
   * Measure: Vega & Curvature Group: Rates & Fx
   */
  @Test
  public void testC355() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_FXV_3, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5, S_FXV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("141679436"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C334-C355 Element Tested: All FX Vol Sensitivities Risk Measure: Vega & Curvature Group: Rates &
   * Fx
   */
  @Test
  public void testC356() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = S_FXV;
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("208775521"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRV Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC357() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13526935"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRV Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC358() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6763468"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRV Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC359() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3127245"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRV Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC360() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("22544892"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRV Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC361() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("4000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRV Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC362() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1127245"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRV Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC363() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3076347"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRV Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC364() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CRV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C357 Element Tested: CRV Aggregate (same tenor, diff bucket, opposite sign) Risk Measure: Vega &
   * Curvature Group: Credit
   */
  @Test
  public void testC365() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("21128211"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C357 Element Tested: CRV Aggregate (diff sign) Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC366() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5912393"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C357,C358 Element Tested: CRV Concentration (same tenor, diff quanto, same sign) Risk Measure:
   * Vega & Curvature Group: Credit
   */
  @Test
  public void testC367() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_2, S_CRV_1, S_CRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("39799874"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C360,C361 Element Tested: CRV Concentration (diff tenor, same quanto, diff sign) Risk Measure:
   * Vega & Curvature Group: Credit
   */
  @Test
  public void testC368() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_4, S_CRV_5, S_CRV_4, S_CRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("37444135"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C364 Element Tested: CRV Concentration (residual) Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC369() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_8, S_CRV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("32000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C357,C358,C367 Element Tested: CRV Intra-bucket Correlation (same tenor, diff quanto, same sign)
   * Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC370() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19899937"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C357,C359 Element Tested: CRV Intra-bucket Correlation (diff name) Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC371() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("15078583"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C362,C364,C369 Element Tested: CRV Intra-bucket Correlation (residual, same name) Risk Measure:
   * Vega & Curvature Group: Credit
   */
  @Test
  public void testC372() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_6, S_CRV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("15658123"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C362,C363 Element Tested: CRV Intra-bucket Correlation (residual, diff name) Risk Measure: Vega &
   * Curvature Group: Credit
   */
  @Test
  public void testC373() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_6, S_CRV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3775470"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C357,C359,C371 Element Tested: CRV Intra-bucket Correlation (exceeds concentration threshold) Risk
   * Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC374() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_1, S_CRV_1, S_CRV_1, S_CRV_1, S_CRV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("68964001"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C357,C360 Element Tested: CRV Inter-bucket (same sign) Risk Measure: Vega & Curvature Group:
   * Credit
   */
  @Test
  public void testC375() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("29950274"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C357,C361 Element Tested: CRV Inter-bucket (diff sign) Risk Measure: Vega & Curvature Group:
   * Credit
   */
  @Test
  public void testC376() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("12722861"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C357,C361,C362,C376 Element Tested: CRV Inter-bucket (w/residual) Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC377() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CRV_1, S_CRV_5, S_CRV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13850106"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C357-C377 Element Tested: All Credit Qualifying Vol Sensitivities Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC378() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = S_CRV;
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("24854975"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Vol Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC379() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CNV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5072601"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Vol Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC380() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CNV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3381734"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Vol Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC381() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CNV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Vol Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC382() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CNV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Vol Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC383() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CNV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2050898"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Vol Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC384() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CNV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6199845"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Vol Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC385() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CNV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1025449"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Vol Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC386() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CNV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3544536"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CRNQ Vol Risk Weight Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC387() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CNV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1690867"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C379 Element Tested: CNV Concentration (same tenor) Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC388() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_1, S_CNV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10145201"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C382,C383 Element Tested: CNV Concentration (diff tenor) Risk Measure: Vega & Curvature Group:
   * Credit
   */
  @Test
  public void testC389() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_4, S_CNV_4, S_CNV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9599316"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C384,C386 Element Tested: CNV Concentration (residual, diff tenor) Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC390() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_6, S_CNV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8575240"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C380,C381 Element Tested: CNV Intra-bucket Correlation (same name) Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC391() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_2, S_CNV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1930299"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C379,C380,C388 Element Tested: CNV Intra-bucket Correlation (diff name) Risk Measure: Vega &
   * Curvature Group: Credit
   */
  @Test
  public void testC392() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_1, S_CNV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8145609"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C385,C387 Element Tested: CNV Intra-bucket Correlation (residual) Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC393() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_7, S_CNV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2380857"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C379-C381,C388,C391,C392 Element Tested: CNV Intra-bucket Correlation (exceeds concentration
   * threshold) Risk Measure: Vega & Curvature Group: Credit
   */
  @Test
  public void testC394() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_1, S_CNV_1, S_CNV_2, S_CNV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11318588"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C379,C383,C388 Element Tested: CNV Inter-bucket Correlation (same sign) Risk Measure: Vega &
   * Curvature Group: Credit
   */
  @Test
  public void testC395() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_1, S_CNV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6131203"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C380,C382 Element Tested: CNV Inter-bucket Correlation (diff sign) Risk Measure: Vega & Curvature
   * Group: Credit
   */
  @Test
  public void testC396() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_2, S_CNV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5192080"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C380,C381,C384,C391 Element Tested: CNV Inter-bucket Correlation (w/residual) Risk Measure: Vega &
   * Curvature Group: Credit
   */
  @Test
  public void testC397() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CNV_2, S_CNV_3, S_CNV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8130144"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C379-C397 Element Tested: All Credit Non Qualifying Vol Sensitivities Risk Measure: Vega &
   * Curvature Group: Credit
   */
  @Test
  public void testC398() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = S_CNV;
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17452082"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQV Risk Weight Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC399() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13804829"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQV Risk Weight Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC400() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5639738"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQV Risk Weight Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC401() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("8122785"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQV Risk Weight Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC402() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5937136"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQV Risk Weight Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC403() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2968568"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQV Risk Weight Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC404() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("41078205"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQV Risk Weight Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC405() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1291816"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQV Risk Weight Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC406() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7371057"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQV Risk Weight Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC407() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("597787389"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQV Risk Weight Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC408() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQV_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("19572976"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQV Risk Weight Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC409() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQV_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("281101252"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQV Risk Weight Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC410() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1474211"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: EQV Risk Weight Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC411() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_EQV_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1794189"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C399 Element Tested: EQV Concentration (bkts 1-4) Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC412() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1,
        S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1, S_EQV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("276096590"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C404 Element Tested: EQV Concentration (bkts 5-8) Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC413() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6,
        S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6, S_EQV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("821564103"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C405 Element Tested: EQV Concentration (bkt 9) Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC414() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_7, S_EQV_7, S_EQV_7, S_EQV_7, S_EQV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6459082"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C406 Element Tested: EQV Concentration (bkt 10) Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC415() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_8, S_EQV_8, S_EQV_8, S_EQV_8, S_EQV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("36855283"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C407 Element Tested: EQV Concentration (bkt 11-12) Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC416() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9,
        S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9, S_EQV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11955747785"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C410 Element Tested: EQV Concentration (residual) Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC417() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_12, S_EQV_12, S_EQV_12, S_EQV_12, S_EQV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7371057"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C399,C400,C412 Element Tested: EQV Intra-bucket Correlation (same sign, pos) Risk Measure: Vega &
   * Curvature Group: Equity
   */
  @Test
  public void testC418() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_1, S_EQV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("16003052"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C402,C403 Element Tested: EQV Intra-bucket Correlation (same sign, neg) Risk Measure: Vega &
   * Curvature Group: Equity
   */
  @Test
  public void testC419() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_4, S_EQV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("7222838"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C399,C401,C412 Element Tested: EQV Intra-bucket Correlation (diff sign) Risk Measure: Vega &
   * Curvature Group: Equity
   */
  @Test
  public void testC420() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_1, S_EQV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11031172"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C399,C405,C412,C414 Element Tested: EQV Intra-bucket Correlation (exceeds concentration threshold)
   * Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC421() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_1, S_EQV_7, S_EQV_7, S_EQV_7, S_EQV_7, S_EQV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("17185707"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C401,C402 Element Tested: EQV Inter-bucket Correlation (same sign) Risk Measure: Vega & Curvature
   * Group: Equity
   */
  @Test
  public void testC422() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_3, S_EQV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10978144"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C400,C404,C413 Element Tested: EQV Inter-bucket Correlation (diff sign) Risk Measure: Vega &
   * Curvature Group: Equity
   */
  @Test
  public void testC423() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_2, S_EQV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("42987858"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C400,C404,C410,C413,C417,C423 Element Tested: EQV Inter-bucket Correlation (w/residual) Risk
   * Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC424() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_2, S_EQV_6, S_EQV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("44462070"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C399 Element Tested: EQV Aggregate (opposite sign) Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC425() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_1, S_EQV_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("13684460"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: Element Tested: EQV Aggregate (opposite sign) Risk Measure: Vega & Curvature Group: Equity
   */
  @Test
  public void testC426() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_EQV_14, S_EQV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1607380"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C399-C424 Element Tested: All Equity Vol Sensitivities Risk Measure: Vega & Curvature Group:
   * Equity
   */
  @Test
  public void testC427() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = S_EQV;
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("788094154"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC428() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("73259079"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC429() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("31456253"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC430() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("11425829"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC431() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("176042400"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC432() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("55013250"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC433() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("28899585"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC434() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("152155296"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC435() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("47909764"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC436() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("9813967"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC437() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("26237089"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC438() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("51548693"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC439() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("24391120"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC440() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("2801869"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC441() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_14);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6166320"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC442() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("5973165"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: CMV Risk Weight Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC443() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.singletonList(S_CMV_16);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("6770862"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C428 Element Tested: CMV Concentration (bkt 1) Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC444() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("732590793"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C431 Element Tested: CMV Concentration (bkt 2) Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC445() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4,
        S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4, S_CMV_4);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3520848010"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C433 Element Tested: CMV Concentration (bkt 3-5) Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC446() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6,
        S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6, S_CMV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("577991694"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C434 Element Tested: CMV Concentration (bkt 6-7) Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC447() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7,
        S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7, S_CMV_7);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("3043105916"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C435 Element Tested: CMV Concentration (bkt 8-9) Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC448() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8,
        S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8, S_CMV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("958195274"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C436 Element Tested: CMV Concentration (bkt 10) Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC449() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_9, S_CMV_9, S_CMV_9, S_CMV_9, S_CMV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("49069837"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C437 Element Tested: CMV Concentration (bkt 11) Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC450() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10,
        S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10, S_CMV_10);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("524741771"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C438 Element Tested: CMV Concentration (bkt 12) Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC451() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11,
        S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11, S_CMV_11);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1030973859"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C439 Element Tested: CMV Concentration (bkt 13-15) Risk Measure: Vega & Curvature Group:
   * Commodities
   */
  @Test
  public void testC452() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12,
        S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12, S_CMV_12);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("487822395"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C442 Element Tested: CMV Concentration (bkt 16) Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC453() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15, S_CMV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("59731653"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C440 Element Tested: CMV Concentration (bkt 17) Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC454() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13,
        S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13, S_CMV_13);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("56037387"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C431 Element Tested: CMV Aggregate (diff bucket, opposite sign) Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC455() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_4, S_CMV_8);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("180054047"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: Element Tested: CMV Aggregate (same qualifier) Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC456() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_4, S_CMV_17);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("433646600"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: Element Tested: CMV Aggregate (same qualifier) Risk Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC457() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_3, S_CMV_18);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("36841673"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C428,C429,C444 Element Tested: CMV Intra-bucket Correlation (same sign, pos) Risk Measure: Vega &
   * Curvature Group: Commodities
   */
  @Test
  public void testC458() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_1, S_CMV_2);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("98369525"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C431,C432,C445 Element Tested: CMV Intra-bucket Correlation (same sign, neg) Risk Measure: Vega &
   * Curvature Group: Commodities
   */
  @Test
  public void testC459() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_4, S_CMV_5);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("230215827"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C429,C430 Element Tested: CMV Intra-bucket Correlation (diff sign) Risk Measure: Vega & Curvature
   * Group: Commodities
   */
  @Test
  public void testC460() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_2, S_CMV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("23599768"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C428,C430,C444 Element Tested: CMV Intra-bucket Correlation (exceeds concentration threshold) Risk
   * Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC461() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_1, S_CMV_3);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("719210282"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C428,C433,C444,C446 Element Tested: CMV Inter-bucket Correlation (same sign) Risk Measure: Vega &
   * Curvature Group: Commodities
   */
  @Test
  public void testC462() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_1, S_CMV_6);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("92292918"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C429,C436,C449 Element Tested: CMV Inter-bucket Correlation (diff sign) Risk Measure: Vega &
   * Curvature Group: Commodities
   */
  @Test
  public void testC463() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_2, S_CMV_9);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("36437334"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C429,C436,C442,C449,C453,C463 Element Tested: CMV Inter-bucket Correlation (w/residual) Risk
   * Measure: Vega & Curvature Group: Commodities
   */
  @Test
  public void testC464() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_CMV_2, S_CMV_9, S_CMV_15);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("37461226"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C428-C464 Element Tested: All Commodity Vol Sensitivities Risk Measure: Vega & Curvature Group:
   * Commodities
   */
  @Test
  public void testC465() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = S_CMV;
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("586678811"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C299-C465 Element Tested: All Vega Sensitivities (no multiplier) Risk Measure: Vega & Curvature
   * Group: Global
   */
  @Test
  public void testC466() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = new ArrayList<>();
    sensitivities.addAll(S_IRV);
    sensitivities.addAll(S_FXV);
    sensitivities.addAll(S_CRV);
    sensitivities.addAll(S_CNV);
    sensitivities.addAll(S_EQV);
    sensitivities.addAll(S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1752254587"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C299-C466 Element Tested: All Vega Sensitivities (with multipliers) Risk Measure: Vega & Curvature
   * Group: Global
   */
  @Test
  public void testC467() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = S_MUL;
    List<Sensitivity> sensitivities = new ArrayList<>();
    sensitivities.addAll(S_IRV);
    sensitivities.addAll(S_FXV);
    sensitivities.addAll(S_CRV);
    sensitivities.addAll(S_CNV);
    sensitivities.addAll(S_EQV);
    sensitivities.addAll(S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("1969963609"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: One Trade Risk Measure: Notional Group: AddOn
   */
  @Test
  public void testC468() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Arrays.asList(S_AN_1);
    List<Notional> notional = Arrays.asList(S_AN_3);
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.emptyList();
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("10000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: Multi Trades Risk Measure: Notional Group: AddOn
   */
  @Test
  public void testC469() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Arrays.asList(S_AN_2);
    List<Notional> notional = Arrays.asList(S_AN_4, S_AN_5);
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.emptyList();
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("40000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: None Element Tested: Fixed Amount Risk Measure: Notional Group: AddOn
   */
  @Test
  public void testC470() {
    List<FixedAmount> fixed = Arrays.asList(S_AN_7, S_AN_8);
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.emptyList();
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("30000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C468-C470 Element Tested: All Notional Risk Measure: Notional Group: AddOn
   */
  @Test
  public void testC471() {
    List<FixedAmount> fixed = Arrays.asList(S_AN_7, S_AN_8);
    List<NotionalFactor> factors = Arrays.asList(S_AN_1, S_AN_2);
    List<Notional> notional = Arrays.asList(S_AN_3, S_AN_4, S_AN_5, S_AN_6);
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Collections.emptyList();
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("80000000"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C41,C82,C134,C189,C256 Element Tested: Risk Class Correlations Risk Measure: All Group: Global
   */
  @Test
  public void testC472() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = Arrays.asList(S_IR_41, S_FX_11, S_CRQ_1, S_CRNQ_1, S_EQ_25, S_CM_33);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("754010599"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C1-C467,C472 Element Tested: Combination (All w/o Multipliers and Notionals) Risk Measure: All
   * Group: Global
   */
  @Test
  public void testC473() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = new ArrayList<>();
    sensitivities.addAll(S_IR);
    sensitivities.addAll(S_CRQ);
    sensitivities.addAll(S_CRNQ);
    sensitivities.addAll(S_CM);
    sensitivities.addAll(S_FX);
    sensitivities.addAll(S_EQ);
    sensitivities.addAll(S_IRV);
    sensitivities.addAll(S_FXV);
    sensitivities.addAll(S_CRV);
    sensitivities.addAll(S_CNV);
    sensitivities.addAll(S_EQV);
    sensitivities.addAll(S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("37711274650"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C1-C467,C472,C473 Element Tested: Combination (All w/Multiplier) Risk Measure: All Group: Global
   */
  @Test
  public void testC474() {
    List<FixedAmount> fixed = Collections.emptyList();
    List<NotionalFactor> factors = Collections.emptyList();
    List<Notional> notional = Collections.emptyList();
    List<ProductMultiplier> multipliers = S_MUL;
    List<Sensitivity> sensitivities = new ArrayList<>();
    sensitivities.addAll(S_IR);
    sensitivities.addAll(S_CRQ);
    sensitivities.addAll(S_CRNQ);
    sensitivities.addAll(S_CM);
    sensitivities.addAll(S_FX);
    sensitivities.addAll(S_EQ);
    sensitivities.addAll(S_IRV);
    sensitivities.addAll(S_FXV);
    sensitivities.addAll(S_CRV);
    sensitivities.addAll(S_CNV);
    sensitivities.addAll(S_EQV);
    sensitivities.addAll(S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("40704397067"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C1-C474 Element Tested: Combination (All w/Notionals Risk Measure: All Group: Global
   */
  @Test
  public void testC475() {
    List<FixedAmount> fixed = Arrays.asList(S_AN_7, S_AN_8);
    List<NotionalFactor> factors = Arrays.asList(S_AN_1, S_AN_2);
    List<Notional> notional = Arrays.asList(S_AN_3, S_AN_4, S_AN_5, S_AN_6);
    List<ProductMultiplier> multipliers = Collections.emptyList();
    List<Sensitivity> sensitivities = new ArrayList<>();
    sensitivities.addAll(S_IR);
    sensitivities.addAll(S_CRQ);
    sensitivities.addAll(S_CRNQ);
    sensitivities.addAll(S_CM);
    sensitivities.addAll(S_FX);
    sensitivities.addAll(S_EQ);
    sensitivities.addAll(S_IRV);
    sensitivities.addAll(S_FXV);
    sensitivities.addAll(S_CRV);
    sensitivities.addAll(S_CNV);
    sensitivities.addAll(S_EQV);
    sensitivities.addAll(S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("37791274650"), amount.setScale(0, RoundingMode.HALF_UP));
  }

  /**
   * Required Passes: C1-C475 Element Tested: Combination (All) Risk Measure: All Group: Global
   */
  @Test
  public void testC476() {
    List<FixedAmount> fixed = Arrays.asList(S_AN_7, S_AN_8);
    List<NotionalFactor> factors = Arrays.asList(S_AN_1, S_AN_2);
    List<Notional> notional = Arrays.asList(S_AN_3, S_AN_4, S_AN_5, S_AN_6);
    List<ProductMultiplier> multipliers = S_MUL;
    List<Sensitivity> sensitivities = new ArrayList<>();
    sensitivities.addAll(S_IR);
    sensitivities.addAll(S_CRQ);
    sensitivities.addAll(S_CRNQ);
    sensitivities.addAll(S_CM);
    sensitivities.addAll(S_FX);
    sensitivities.addAll(S_EQ);
    sensitivities.addAll(S_IRV);
    sensitivities.addAll(S_FXV);
    sensitivities.addAll(S_CRV);
    sensitivities.addAll(S_CNV);
    sensitivities.addAll(S_EQV);
    sensitivities.addAll(S_CMV);
    BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod.ONE_DAY);
    Assert.assertEquals(new BigDecimal("40784397067"), amount.setScale(0, RoundingMode.HALF_UP));
  }


}
