/*
 * Copyright (c) 2020 AcadiaSoft, Inc.
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
import com.acadiasoft.im.base.fx.NoConversionFxRate;

public class DefaultSimmConfigBuilder implements SimmConfigBuilder {

  // sets default values for each of the builder options
  private FxRate fx = new NoConversionFxRate();
  private HoldingPeriod holdingPeriod = HoldingPeriod.TEN_DAY;
  private SimmCalculationType simmCalculationType = SimmCalculationType.STANDARD;
  private String calculationCurrency = FxRate.USD;
  private boolean useSingleProductClass = false;
  private boolean countTradesPerLevel = false;
  private Boolean enableConcentrationThreshold;

  @Override
  public SimmConfig build() {
    return new DefaultSimmConfig(this);
  }

  @Override
  public SimmConfigBuilder fxRate(FxRate fx) {
    if (fx != null) { this.fx = fx; }
    return this;
  }

  @Override
  public SimmConfigBuilder holdingPeriod(HoldingPeriod period) {
    if (period != null) { this.holdingPeriod = period; }
    return this;
  }

  @Override
  public SimmConfigBuilder simmCalculationType(SimmCalculationType type) {
    if (type != null) { this.simmCalculationType = type; }
    return this;
  }

  @Override
  public SimmConfigBuilder calculationCurrency(String calculationCurrency) {
    if (calculationCurrency != null) { this.calculationCurrency = calculationCurrency; }
    return this;
  }

  @Override
  public SimmConfigBuilder useSingleProductClass(boolean useSingleProductClass) {
    this.useSingleProductClass = useSingleProductClass;
    return this;
  }

  @Override
  public SimmConfigBuilder countTradesPerLevel(boolean countTradesPerLevel) {
    this.countTradesPerLevel = countTradesPerLevel;
    return this;
  }

  @Override
  public SimmConfigBuilder enableConcentrationThreshold(boolean enableConcentrationThreshold) {
    this.enableConcentrationThreshold = enableConcentrationThreshold;
    return this;
  }

  @Override
  public FxRate fxRate() {
    return fx;
  }

  @Override
  public HoldingPeriod holdingPeriod() {
    return holdingPeriod;
  }

  @Override
  public SimmCalculationType simmCalculationType() {
    return simmCalculationType;
  }

  @Override
  public String calculationCurrency() {
    return calculationCurrency;
  }

  @Override
  public boolean useSingleProductClass() {
    return useSingleProductClass;
  }

  @Override
  public boolean countTradesPerLevel() {
    return countTradesPerLevel;
  }

  @Override
  public boolean enableConcentrationThreshold() {
    if (this.enableConcentrationThreshold == null) {
      return holdingPeriod.equals(HoldingPeriod.TEN_DAY);
    } else {
      return enableConcentrationThreshold;
    }
  }

}
