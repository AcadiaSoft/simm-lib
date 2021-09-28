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

package com.acadiasoft.im.schedule.config;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.base.fx.NoConversionFxRate;

import java.math.BigDecimal;

public class DefaultScheduleConfigBuilder implements ScheduleConfigBuilder {

  private FxRate fxRate = new NoConversionFxRate();
  private ScheduleCalculationType calculationType = ScheduleCalculationType.WITH_PVS;
  private BigDecimal ngr = BigDecimal.ONE;

  @Override
  public ScheduleConfig build() {
    return new DefaultScheduleConfig(this);
  }

  @Override
  public ScheduleConfigBuilder fxRate(FxRate fx) {
    if (fx != null) { this.fxRate = fx; }
    return this;
  }

  @Override
  public ScheduleConfigBuilder scheduleCalculationType(ScheduleCalculationType type) {
    if (type != null) { this.calculationType = type; }
    return this;
  }

  @Override
  public ScheduleConfigBuilder netGrossRate(BigDecimal ngr) {
    if (ngr != null) { this.ngr = ngr; }
    return this;
  }

  @Override
  public FxRate fxRate() {
    return fxRate;
  }

  @Override
  public ScheduleCalculationType scheduleCalculationType() {
    return calculationType;
  }

  @Override
  public BigDecimal netGrossRate() {
    return ngr;
  }
}
