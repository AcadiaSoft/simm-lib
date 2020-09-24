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

package com.acadiasoft.im.schedule.engine.margin;

import com.acadiasoft.im.base.margin.SiloMargin;
import com.acadiasoft.im.base.util.ListUtils;
import com.acadiasoft.im.schedule.config.ScheduleConfig;
import com.acadiasoft.im.schedule.models.ScheduleIdentifier;
import com.acadiasoft.im.schedule.models.ScheduleNotional;
import com.acadiasoft.im.schedule.models.SchedulePv;
import com.acadiasoft.im.schedule.models.ScheduleSensitivity;
import com.acadiasoft.im.schedule.models.imtree.identifiers.ScheduleProductClass;
import com.acadiasoft.im.schedule.models.imtree.identifiers.ScheduleTradeClass;
import com.acadiasoft.im.schedule.models.utils.ScheduleCalculationUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleProductMargin extends SiloMargin {

  private static final String LEVEL = "3.Silo";
  private final List<ScheduleTradeMargin> nettedTrades;

  private ScheduleProductMargin(ScheduleProductClass identifier, BigDecimal margin, List<ScheduleTradeMargin> nettedTrades) {
    super(LEVEL, identifier, margin, Collections.emptyList());
    this.nettedTrades = nettedTrades;
  }

  public static ScheduleProductMargin calculate(ScheduleProductClass productClass, List<ScheduleSensitivity> sensitivities, ScheduleConfig config) {
    List<ScheduleTradeMargin> trades = ListUtils.groupBy(sensitivities, ScheduleIdentifier::getScheduleTradeIdentifier).entrySet().stream()
      .map(entry -> ScheduleTradeMargin.calculate(ScheduleTradeClass.determineWeightingClass(entry.getKey()), entry.getValue(), config))
      .collect(Collectors.toList());
    List<ScheduleNotional> notionals = trades.stream().map(ScheduleTradeMargin::getNettedNotional).collect(Collectors.toList());
    BigDecimal grossIm = ScheduleCalculationUtils.calculateGrossIm(notionals, config.fxRate());
    List<SchedulePv> pvs = trades.stream().map(ScheduleTradeMargin::getNettedPv).collect(Collectors.toList());
    BigDecimal ngr = (config.useConfiguredNgr()) ? config.netGrossRate() : ScheduleCalculationUtils.calculateNgr(pvs, config.fxRate());
    return new ScheduleProductMargin(productClass, ScheduleCalculationUtils.calculateMargin(grossIm, ngr), trades);
  }

  public List<ScheduleTradeMargin> getNettedTrades() {
    return new ArrayList<>(nettedTrades);
  }
}
