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

package com.acadiasoft.im.simmple.config;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.schedule.config.ScheduleCalculationType;
import com.acadiasoft.im.schedule.config.ScheduleConfigBuilder;
import com.acadiasoft.im.simm.config.HoldingPeriod;
import com.acadiasoft.im.simm.config.SimmCalculationType;
import com.acadiasoft.im.simm.config.SimmConfigBuilder;

import java.math.BigDecimal;

public interface SimmpleConfigBuilder extends SimmConfigBuilder, ScheduleConfigBuilder {

  SimmpleConfig build();

  SimmpleConfigBuilder fxRate(final FxRate fx);

  SimmpleConfigBuilder holdingPeriod(final HoldingPeriod period);

  SimmpleConfigBuilder simmCalculationType(final SimmCalculationType type);

  SimmpleConfigBuilder calculationCurrency(final String calculationCurrency);

  SimmpleConfigBuilder useSingleProductClass(final boolean useSingleProductClass);

  SimmpleConfigBuilder countTradesPerLevel(final boolean useSingleProductClass);

  SimmpleConfigBuilder scheduleCalculationType(final ScheduleCalculationType type);

  SimmpleConfigBuilder netGrossRate(final BigDecimal ngr);

  SimmpleConfigBuilder resultCurrency(final String resultCurrency);

  SimmpleConfigBuilder imRole(final ImRole role);

  SimmpleConfigBuilder simmpleCalculationType(final SimmpleCalculationType simmpleCalculationType);

  SimmpleConfigBuilder enableConcentrationThreshold(final boolean enableConcentrationThreshold);

  String resultCurrency();

  ImRole imRole();

  SimmpleCalculationType simmpleCalculationType();

}
