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

package com.acadiasoft.im.simm.config;

import com.acadiasoft.im.base.fx.FxRate;

public class DefaultSimmConfig implements SimmConfig {

  private final FxRate fx;
  private final HoldingPeriod holdingPeriod;
  private final SimmCalculationType simmCalculationType;
  private final String calculationCurrency;
  private final boolean useSingleProductClass;
  private final boolean countTradesPerLevel;
  private final boolean enableConcentrationThreshold;

  public DefaultSimmConfig(SimmConfigBuilder builder) {
    this.holdingPeriod = builder.holdingPeriod();
    this.simmCalculationType = builder.simmCalculationType();
    this.calculationCurrency = builder.calculationCurrency();
    this.useSingleProductClass = builder.useSingleProductClass();
    this.countTradesPerLevel = builder.countTradesPerLevel();
    this.enableConcentrationThreshold = builder.enableConcentrationThreshold();
    this.fx = builder.fxRate();
  }

  @Override
  public FxRate fxRate() {
    return this.fx;
  }

  @Override
  public HoldingPeriod holdingPeriod() {
    return this.holdingPeriod;
  }

  @Override
  public SimmCalculationType simmCalculationType() {
    return this.simmCalculationType;
  }

  @Override
  public String calculationCurrency() {
    return this.calculationCurrency;
  }

  @Override
  public boolean useSingleProductClass() {
    return this.useSingleProductClass;
  }

  @Override
  public boolean countTradesPerLevel() {
    return this.countTradesPerLevel;
  }

  @Override
  public boolean enableConcentrationThreshold() {
    return this.enableConcentrationThreshold;
  }

}
