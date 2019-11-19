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

package com.acadiasoft.im.simmple.engine;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.base.margin.ModelMargin;
import com.acadiasoft.im.base.margin.TotalMargin;
import com.acadiasoft.im.schedule.config.ScheduleCalculationType;
import com.acadiasoft.im.schedule.engine.Schedule;
import com.acadiasoft.im.schedule.models.ScheduleSensitivity;
import com.acadiasoft.im.simm.config.SimmCalculationType;
import com.acadiasoft.im.simm.engine.Simm;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simmple.config.ImRole;
import com.acadiasoft.im.simmple.config.SimmpleCalculationType;
import com.acadiasoft.im.simmple.config.SimmpleConfig;
import com.acadiasoft.im.simmple.model.Crif;
import com.acadiasoft.im.simmple.model.utils.SimmpleResult;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Main functions of the library
 *
 * @author alec.stewart
 *
 */
public class Simmple {

  // -------------------------- calculation functions ---------------------------
  // NOTE: post regulator applies to the pledgor, collect regulator applies to the secured

  public static SimmpleResult calculateWorstOf(List<Crif> crifs, SimmpleConfig config) {
    return Crif.getRegulators(crifs, config.imRole()).stream()
      .map(regulator -> {
        // get the list of crifs that contain this regulator
        List<Crif> containsRegulator = crifs.stream()
          .filter(crif -> crif.containsRegulator(config.imRole(), regulator))
          .collect(Collectors.toList());
        // calculate the simm exposure amount
        List<Sensitivity> sensitivities = containsRegulator.stream()
          .filter(SimmpleCalculationType.calculateSimm(config))
          .filter(Crif.isSimm)
          .map(crif -> crif.convertSensitivityAmountForRole(config))
          .collect(Collectors.toList());
        ModelMargin simm = Simm.calculate(sensitivities, config);
        // calculate the schedule exposure amount
        List<ScheduleSensitivity> scheduleSensitivities = containsRegulator.stream()
          .filter(SimmpleCalculationType.calculateSchedule(config))
          .filter(Crif.isSchedule)
          .map(crif -> crif.convertScheduleAmountForRole(config))
          .collect(Collectors.toList());
        ModelMargin schedule = Schedule.calculate(scheduleSensitivities, config);
        // return the total margin of these two models converted to the result currency
        TotalMargin total = TotalMargin.build(simm, schedule);
        return new SimmpleResult(total, regulator, config);
      })
      .sorted(Comparator.comparing(SimmpleResult::getRegulator))
      .max(Comparator.comparing(result -> result.getImTree().getMargin().abs()))
      .orElse(SimmpleResult.empty(config));
  }

  // --------------------- legacy calculation functions ------------------------

  public static SimmpleResult calculateWorstOf(List<Crif> crifs, String calculationCurrency, FxRate fx, String resultCurrency,
                                               ImRole role, SimmCalculationType simmType, BigDecimal netGrossRate) {
    SimmpleConfig config = SimmpleConfig.Builder().fxRate(fx).imRole(role)
      .resultCurrency(resultCurrency).calculationCurrency(calculationCurrency).simmCalculationType(simmType)
      .scheduleCalculationType(ScheduleCalculationType.WITHOUT_PVS).netGrossRate(netGrossRate)
      .simmpleCalculationType(SimmpleCalculationType.BOTH).build();
    return calculateWorstOf(crifs, config);
  }

  public static SimmpleResult calculateWorstOf(List<Crif> crifs, String calculationCurrency, FxRate fx, String resultCurrency,
                                               ImRole role, SimmCalculationType simmType) {
    SimmpleConfig config = SimmpleConfig.Builder().fxRate(fx).imRole(role)
      .resultCurrency(resultCurrency).calculationCurrency(calculationCurrency).simmCalculationType(simmType)
      .scheduleCalculationType(ScheduleCalculationType.WITH_PVS).simmpleCalculationType(SimmpleCalculationType.BOTH).build();
    return calculateWorstOf(crifs, config);
  }

  public static SimmpleResult calculateScheduleWorstOf(List<Crif> crifs, FxRate fx, String resultCurrency,
                                                       ImRole role, BigDecimal netGrossRate) {
    SimmpleConfig config = SimmpleConfig.Builder().fxRate(fx).imRole(role).resultCurrency(resultCurrency)
      .scheduleCalculationType(ScheduleCalculationType.WITHOUT_PVS).netGrossRate(netGrossRate)
      .simmpleCalculationType(SimmpleCalculationType.SCHEDULE).build();
    return calculateWorstOf(crifs, config);
  }

  public static SimmpleResult calculateScheduleWorstOf(List<Crif> crifs, FxRate fx, String resultCurrency, ImRole role) {
    SimmpleConfig config = SimmpleConfig.Builder().fxRate(fx).imRole(role).resultCurrency(resultCurrency)
      .scheduleCalculationType(ScheduleCalculationType.WITH_PVS).simmpleCalculationType(SimmpleCalculationType.SCHEDULE).build();
    return calculateWorstOf(crifs, config);
  }

  public static SimmpleResult calculateSimmWorstOf(List<Crif> crifs, String calculationCurrency, FxRate fx, String resultCurrency,
                                                   ImRole role, SimmCalculationType simmType) {
    SimmpleConfig config = SimmpleConfig.Builder().fxRate(fx).imRole(role)
      .resultCurrency(resultCurrency).calculationCurrency(calculationCurrency).simmCalculationType(simmType)
      .simmpleCalculationType(SimmpleCalculationType.SIMM).build();
    return calculateWorstOf(crifs, config);
  }

}