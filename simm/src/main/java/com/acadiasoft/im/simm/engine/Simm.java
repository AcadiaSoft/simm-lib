/*
 * Copyright (c) 2022 Acadia, Inc.
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

import com.acadiasoft.im.base.margin.ModelMargin;
import com.acadiasoft.im.base.margin.TotalMargin;
import com.acadiasoft.im.simm.config.HoldingPeriod;
import com.acadiasoft.im.simm.config.SimmCalculationType;
import com.acadiasoft.im.simm.config.SimmConfig;
import com.acadiasoft.im.simm.engine.margin.SimmMargin;
import com.acadiasoft.im.simm.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alec.stewart
 * @author joe.peterson
 *
 */
public class Simm {

  // --------------------- CONFIGURABLE CALCULATION ------------------------

  public static ModelMargin calculate(List<Sensitivity> inputSensitivities, SimmConfig config) {
    return SimmMargin.calculate(inputSensitivities, config);
  }

  // ------------------- LEGACY CALCULATION FUNCTIONS ----------------------

  public static BigDecimal calculateStandard(List<Sensitivity> inputSensitivities, String calculationCurrency) {
    SimmConfig config = SimmConfig.Builder() //
        .calculationCurrency(calculationCurrency) //
        .build();
    return calculate(inputSensitivities, config).getMargin();
  }

  public static BigDecimal calculateAdditional(List<Sensitivity> inputSensitivities, List<ProductMultiplier> multipliers, List<NotionalFactor> factors, List<Notional> notionals,
      List<FixedAmount> fixed, String calculationCurrency) {
    SimmConfig config = SimmConfig.Builder() //
        .calculationCurrency(calculationCurrency) //
        .simmCalculationType(SimmCalculationType.ADDITIONAL) //
        .build();
    List<Sensitivity> allInputs = new ArrayList<>(inputSensitivities);
    multipliers.stream().map(ProductMultiplier::of).forEach(allInputs::add);
    factors.stream().map(NotionalFactor::of).forEach(allInputs::add);
    notionals.stream().map(Notional::of).forEach(allInputs::add);
    fixed.stream().map(FixedAmount::of).forEach(allInputs::add);
    return calculate(allInputs, config).getMargin();
  }

  public static BigDecimal calculateTotal(List<Sensitivity> inputSensitivities, List<ProductMultiplier> multipliers, List<NotionalFactor> factors, List<Notional> notionals,
      List<FixedAmount> fixed, String calculationCurrency) {
    SimmConfig config = SimmConfig.Builder() //
        .calculationCurrency(calculationCurrency) //
        .simmCalculationType(SimmCalculationType.TOTAL) //
        .build();
    List<Sensitivity> allInputs = new ArrayList<>(inputSensitivities);
    multipliers.stream().map(ProductMultiplier::of).forEach(allInputs::add);
    factors.stream().map(NotionalFactor::of).forEach(allInputs::add);
    notionals.stream().map(Notional::of).forEach(allInputs::add);
    fixed.stream().map(FixedAmount::of).forEach(allInputs::add);
    return calculate(allInputs, config).getMargin();
  }

  public static TotalMargin calculateTreeStandard(List<Sensitivity> inputSensitivities, String calculationCurrency) {
    SimmConfig config = SimmConfig.Builder() //
        .calculationCurrency(calculationCurrency) //
        .build();
    return TotalMargin.build(calculate(inputSensitivities, config));
  }

  public static TotalMargin calculateTreeAdditional(List<Sensitivity> inputSensitivities, List<ProductMultiplier> multipliers, List<NotionalFactor> factors,
      List<Notional> notionals, List<FixedAmount> fixed, String calculationCurrency) {
    SimmConfig config = SimmConfig.Builder() //
        .calculationCurrency(calculationCurrency) //
        .simmCalculationType(SimmCalculationType.ADDITIONAL) //
        .build();
    List<Sensitivity> allInputs = new ArrayList<>(inputSensitivities);
    multipliers.stream().map(ProductMultiplier::of).forEach(allInputs::add);
    factors.stream().map(NotionalFactor::of).forEach(allInputs::add);
    notionals.stream().map(Notional::of).forEach(allInputs::add);
    fixed.stream().map(FixedAmount::of).forEach(allInputs::add);
    return TotalMargin.build(calculate(allInputs, config));
  }

  public static TotalMargin calculateTreeTotal(List<Sensitivity> inputSensitivities, List<ProductMultiplier> multipliers, List<NotionalFactor> factors, List<Notional> notionals,
      List<FixedAmount> fixed, String calculationCurrency) {
    SimmConfig config = SimmConfig.Builder() //
        .calculationCurrency(calculationCurrency) //
        .simmCalculationType(SimmCalculationType.TOTAL) //
        .build();
    List<Sensitivity> allInputs = new ArrayList<>(inputSensitivities);
    multipliers.stream().map(ProductMultiplier::of).forEach(allInputs::add);
    factors.stream().map(NotionalFactor::of).forEach(allInputs::add);
    notionals.stream().map(Notional::of).forEach(allInputs::add);
    fixed.stream().map(FixedAmount::of).forEach(allInputs::add);
    return TotalMargin.build(calculate(allInputs, config));
  }

  public static BigDecimal calculateStandard(List<Sensitivity> inputSensitivities, String calculationCurrency, HoldingPeriod period) {
    SimmConfig config = SimmConfig.Builder() //
        .calculationCurrency(calculationCurrency) //
        .holdingPeriod(period).build();
    return calculate(inputSensitivities, config).getMargin();
  }

  public static BigDecimal calculateAdditional(List<Sensitivity> inputSensitivities, List<ProductMultiplier> multipliers, List<NotionalFactor> factors, List<Notional> notionals,
      List<FixedAmount> fixed, String calculationCurrency, HoldingPeriod period) {
    SimmConfig config = SimmConfig.Builder() //
        .calculationCurrency(calculationCurrency) //
        .simmCalculationType(SimmCalculationType.ADDITIONAL) //
        .holdingPeriod(period).build();
    List<Sensitivity> allInputs = new ArrayList<>(inputSensitivities);
    multipliers.stream().map(ProductMultiplier::of).forEach(allInputs::add);
    factors.stream().map(NotionalFactor::of).forEach(allInputs::add);
    notionals.stream().map(Notional::of).forEach(allInputs::add);
    fixed.stream().map(FixedAmount::of).forEach(allInputs::add);
    return calculate(allInputs, config).getMargin();
  }

  public static BigDecimal calculateTotal(List<Sensitivity> inputSensitivities, List<ProductMultiplier> multipliers, List<NotionalFactor> factors, List<Notional> notionals,
      List<FixedAmount> fixed, String calculationCurrency, HoldingPeriod period) {
    SimmConfig config = SimmConfig.Builder() //
        .calculationCurrency(calculationCurrency) //
        .simmCalculationType(SimmCalculationType.TOTAL) //
        .holdingPeriod(period) //
        .build();
    List<Sensitivity> allInputs = new ArrayList<>(inputSensitivities);
    multipliers.stream().map(ProductMultiplier::of).forEach(allInputs::add);
    factors.stream().map(NotionalFactor::of).forEach(allInputs::add);
    notionals.stream().map(Notional::of).forEach(allInputs::add);
    fixed.stream().map(FixedAmount::of).forEach(allInputs::add);
    return calculate(allInputs, config).getMargin();
  }

  public static TotalMargin calculateTreeStandard(List<Sensitivity> inputSensitivities, String calculationCurrency, HoldingPeriod period) {
    SimmConfig config = SimmConfig.Builder() //
        .calculationCurrency(calculationCurrency) //
        .holdingPeriod(period) //
        .build();
    return TotalMargin.build(calculate(inputSensitivities, config));
  }

  public static TotalMargin calculateTreeAdditional(List<Sensitivity> inputSensitivities, List<ProductMultiplier> multipliers, List<NotionalFactor> factors,
      List<Notional> notionals, List<FixedAmount> fixed, String calculationCurrency, HoldingPeriod period) {
    SimmConfig config = SimmConfig.Builder() //
        .calculationCurrency(calculationCurrency) //
        .simmCalculationType(SimmCalculationType.ADDITIONAL) //
        .holdingPeriod(period) //
        .build();
    List<Sensitivity> allInputs = new ArrayList<>(inputSensitivities);
    multipliers.stream().map(ProductMultiplier::of).forEach(allInputs::add);
    factors.stream().map(NotionalFactor::of).forEach(allInputs::add);
    notionals.stream().map(Notional::of).forEach(allInputs::add);
    fixed.stream().map(FixedAmount::of).forEach(allInputs::add);
    return TotalMargin.build(calculate(allInputs, config));
  }

  public static TotalMargin calculateTreeTotal(List<Sensitivity> inputSensitivities, List<ProductMultiplier> multipliers, List<NotionalFactor> factors, List<Notional> notionals,
      List<FixedAmount> fixed, String calculationCurrency, HoldingPeriod period) {
    SimmConfig config = SimmConfig.Builder() //
        .calculationCurrency(calculationCurrency) //
        .simmCalculationType(SimmCalculationType.TOTAL) //
        .holdingPeriod(period) //
        .build();
    List<Sensitivity> allInputs = new ArrayList<>(inputSensitivities);
    multipliers.stream().map(ProductMultiplier::of).forEach(allInputs::add);
    factors.stream().map(NotionalFactor::of).forEach(allInputs::add);
    notionals.stream().map(Notional::of).forEach(allInputs::add);
    fixed.stream().map(FixedAmount::of).forEach(allInputs::add);
    return TotalMargin.build(calculate(allInputs, config));
  }
}
