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

package com.acadiasoft.im.schedule.engine;

import com.acadiasoft.im.base.margin.ModelMargin;
import com.acadiasoft.im.base.margin.TotalMargin;
import com.acadiasoft.im.base.model.imtree.ImTree;
import com.acadiasoft.im.schedule.config.ScheduleCalculationType;
import com.acadiasoft.im.schedule.config.ScheduleConfig;
import com.acadiasoft.im.schedule.engine.margin.ScheduleMargin;
import com.acadiasoft.im.schedule.models.ScheduleNotional;
import com.acadiasoft.im.schedule.models.SchedulePv;
import com.acadiasoft.im.schedule.models.ScheduleSensitivity;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author alec.stewart
 * @author joe.peterson
 *
 */
public class Schedule {

  // --------------------------- calculation functions -----------------------------

  public static ModelMargin calculate(List<ScheduleSensitivity> sensitivities, ScheduleConfig config) {
    return ScheduleMargin.calculate(sensitivities, config);
  }

  // --------------------------- legacy functions -----------------------------

  public static BigDecimal calculate(List<ScheduleNotional> notionals, BigDecimal netGrossRate) {
    return calculateWithoutPvs(notionals, netGrossRate).getMargin();
  }

  public static BigDecimal calculate(List<ScheduleNotional> notionals, List<SchedulePv> pvs) {
    return calculateWithPvs(notionals, pvs).getMargin();
  }

  @SuppressWarnings("rawtypes")
  public static ImTree calculateTree(List<ScheduleNotional> notionals, BigDecimal netGrossRate) {
    return TotalMargin.build(calculateWithoutPvs(notionals, netGrossRate));
  }

  @SuppressWarnings("rawtypes")
  public static ImTree calculateTree(List<ScheduleNotional> notionals, List<SchedulePv> pvs) {
    return TotalMargin.build(calculateWithPvs(notionals, pvs));
  }

  public static ModelMargin calculateWithPvs(List<ScheduleNotional> notionals, List<SchedulePv> pvs) {
    ScheduleConfig config = ScheduleConfig.Builder().build();
    List<ScheduleSensitivity> sensitivities = notionals.stream().map(ScheduleNotional::of).collect(Collectors.toList());
    sensitivities.addAll(pvs.stream().map(SchedulePv::of).collect(Collectors.toList()));
    return ScheduleMargin.calculate(sensitivities, config);
  }

  public static ModelMargin calculateWithoutPvs(List<ScheduleNotional> notionals, BigDecimal netGrossRate) {
    ScheduleConfig config = ScheduleConfig.Builder() //
        .netGrossRate(netGrossRate) //
        .scheduleCalculationType(ScheduleCalculationType.WITHOUT_PVS) //
        .build();
    List<ScheduleSensitivity> sensitivities = notionals.stream().map(ScheduleNotional::of).collect(Collectors.toList());
    return ScheduleMargin.calculate(sensitivities, config);
  }

}
