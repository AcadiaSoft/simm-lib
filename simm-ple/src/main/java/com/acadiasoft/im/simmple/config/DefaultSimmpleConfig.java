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

package com.acadiasoft.im.simmple.config;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.schedule.config.ScheduleCalculationType;
import com.acadiasoft.im.simm.config.HoldingPeriod;
import com.acadiasoft.im.simm.config.SimmCalculationType;

import java.math.BigDecimal;

public class DefaultSimmpleConfig implements SimmpleConfig {

  private final FxRate fx;
  private final HoldingPeriod holdingPeriod;
  private final SimmCalculationType simmCalculationType;
  private final String calculationCurrency;
  private final boolean useSingleProductClass;
  private final boolean countTradesPerLevel;
  private final ScheduleCalculationType scheduleCalculationType;
  private final BigDecimal netGrossRate;
  private final String resultCurrency;
  private final ImRole imRole;
  private final SimmpleCalculationType simmpleCalculationType;
  private final boolean enableConcentrationThreshold;

  public DefaultSimmpleConfig(SimmpleConfigBuilder builder) {
    this.holdingPeriod = builder.holdingPeriod();
    this.simmCalculationType = builder.simmCalculationType();
    this.calculationCurrency = builder.calculationCurrency();
    this.useSingleProductClass = builder.useSingleProductClass();
    this.countTradesPerLevel = builder.countTradesPerLevel();
    this.scheduleCalculationType = builder.scheduleCalculationType();
    this.simmpleCalculationType = builder.simmpleCalculationType();
    this.resultCurrency = builder.resultCurrency();
    this.netGrossRate = builder.netGrossRate();
    this.enableConcentrationThreshold = builder.enableConcentrationThreshold();
    this.imRole = builder.imRole();
    this.fx = builder.fxRate();
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
  public ScheduleCalculationType scheduleCalculationType() {
    return scheduleCalculationType;
  }

  @Override
  public BigDecimal netGrossRate() {
    return netGrossRate;
  }

  @Override
  public String resultCurrency() {
    return resultCurrency;
  }

  @Override
  public ImRole imRole() {
    return imRole;
  }

  @Override
  public SimmpleCalculationType simmpleCalculationType() {
    return simmpleCalculationType;
  }

  @Override
  public boolean enableConcentrationThreshold() {
    return enableConcentrationThreshold;
  }
}
