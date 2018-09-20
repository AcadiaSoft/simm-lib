/*
 * Copyright (c) 2018 AcadiaSoft, Inc.
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

import com.acadiasoft.im.base.imtree.ImTree;
import com.acadiasoft.im.base.imtree.TotalMargin;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.schedule.engine.margin.ScheduleMargin;
import com.acadiasoft.im.schedule.models.ScheduleIdentifier;
import com.acadiasoft.im.schedule.models.ScheduleNotional;
import com.acadiasoft.im.schedule.models.SchedulePv;
import com.acadiasoft.im.schedule.models.utils.ScheduleCalculationType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author alec.stewart
 */
public class Schedule {

  /**
   *
   * @param notionals notional values of the trades
   * @param netGrossRate the net replacement cost divided by the gross replacement cost
   * @return Schedule IM exposure amount
   */
  public static BigDecimal calculate(List<ScheduleNotional> notionals, BigDecimal netGrossRate) {
    return calculate(notionals, new ArrayList<>(), ScheduleCalculationType.WITHOUT_PVS, Optional.ofNullable(netGrossRate)).getMargin();
  }

  /**
   *  NGR can be calculated from the PVs
   *
   * @param notionals the notional amounts
   * @return Schedule IM exposure amount
   */
  public static BigDecimal calculate(List<ScheduleNotional> notionals, List<SchedulePv> pvs) {
    return calculate(notionals, pvs, ScheduleCalculationType.WITH_PVS, Optional.empty()).getMargin();
  }

  public static ImTree calculateTree(List<ScheduleNotional> notionals, BigDecimal netGrossRate) {
    return TotalMargin.build(calculate(notionals, new ArrayList<>(), ScheduleCalculationType.WITHOUT_PVS, Optional.ofNullable(netGrossRate)));
  }

  public static ImTree calculateTree(List<ScheduleNotional> notionals, List<SchedulePv> pvs) {
    return TotalMargin.build(calculate(notionals, pvs, ScheduleCalculationType.WITH_PVS, Optional.empty()));
  }

  public static ImTree calculate(List<ScheduleNotional> notionals, List<SchedulePv> pvs, ScheduleCalculationType type, Optional<BigDecimal> netGrossRate) {
    // map an net by trade id, etc. for the notionals
    Map<ScheduleIdentifier, List<ScheduleNotional>> mappedNotionals = notionals.stream()
        .collect(Collectors.groupingBy(n -> n.getIdentifier(), Collectors.toList()));
    // NOTE: we only care about the absolute notional after netting, so we take the absolute value of the sum
    List<ScheduleNotional> nettedNotionals = mappedNotionals.entrySet().stream()
        .map(e -> ScheduleNotional.make(e.getKey(), BigDecimalUtils.sum(e.getValue(), n -> n.getAmountUSD()).abs()))
        .collect(Collectors.toList());
    if (type.equals(ScheduleCalculationType.WITHOUT_PVS)) return ScheduleMargin.calculate(nettedNotionals, netGrossRate.orElse(BigDecimal.ONE));
    // this is a WITH call so map pvs too
    Map<ScheduleIdentifier, List<SchedulePv>> mappedPvs = pvs.stream()
        .collect(Collectors.groupingBy(p -> p.getIdentifier(), Collectors.toList()));
    List<SchedulePv> nettedPvs = mappedPvs.entrySet().stream()
        .map(e -> SchedulePv.make(e.getKey(), BigDecimalUtils.sum(e.getValue(), p -> p.getAmountUSD())))
        .collect(Collectors.toList());
    return ScheduleMargin.calculate(nettedNotionals, nettedPvs);
  }

}
