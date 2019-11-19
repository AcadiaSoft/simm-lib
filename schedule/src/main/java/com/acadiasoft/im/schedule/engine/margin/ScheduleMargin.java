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

package com.acadiasoft.im.schedule.engine.margin;

import com.acadiasoft.im.base.margin.ModelMargin;
import com.acadiasoft.im.base.margin.SiloMargin;
import com.acadiasoft.im.base.model.imtree.identifiers.ImModelClass;
import com.acadiasoft.im.base.util.ListUtils;
import com.acadiasoft.im.schedule.config.ScheduleConfig;
import com.acadiasoft.im.schedule.models.ScheduleIdentifier;
import com.acadiasoft.im.schedule.models.ScheduleNotional;
import com.acadiasoft.im.schedule.models.SchedulePv;
import com.acadiasoft.im.schedule.models.ScheduleSensitivity;
import com.acadiasoft.im.schedule.models.utils.ScheduleCalculationUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author alec.stewart
 */
public class ScheduleMargin extends ModelMargin {

  private ScheduleMargin(BigDecimal margin, List<SiloMargin> children) {
    super(ImModelClass.SCHEDULE, margin, children);
  }

  public static ScheduleMargin calculate(List<ScheduleSensitivity> sensitivities, ScheduleConfig config) {
    List<ScheduleProductMargin> products = ListUtils.groupBy(sensitivities, ScheduleIdentifier::getScheduleProductClass).entrySet().stream()
      .map(entry -> ScheduleProductMargin.calculate(entry.getKey(), entry.getValue(), config))
      .collect(Collectors.toList());
    List<ScheduleNotional> notionals = products.stream()
      .map(ScheduleProductMargin::getNettedTrades)
      .flatMap(Collection::stream)
      .map(ScheduleTradeMargin::getNettedNotional)
      .collect(Collectors.toList());
    BigDecimal grossIm = ScheduleCalculationUtils.calculateGrossIm(notionals, config.fxRate());
    List<SchedulePv> pvs = products.stream()
      .map(ScheduleProductMargin::getNettedTrades)
      .flatMap(Collection::stream)
      .map(ScheduleTradeMargin::getNettedPv)
      .collect(Collectors.toList());
    BigDecimal ngr = (config.useConfiguredNgr()) ? config.netGrossRate() : ScheduleCalculationUtils.calculateNgr(pvs, config.fxRate());
    return new ScheduleMargin(ScheduleCalculationUtils.calculateMargin(grossIm, ngr), new ArrayList<>(products));
  }

}
