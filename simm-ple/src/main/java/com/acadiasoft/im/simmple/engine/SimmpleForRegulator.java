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

package com.acadiasoft.im.simmple.engine;

import com.acadiasoft.im.base.fx.FxConverter;
import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.schedule.engine.Schedule;
import com.acadiasoft.im.schedule.models.ScheduleIdentifier;
import com.acadiasoft.im.schedule.models.ScheduleNotional;
import com.acadiasoft.im.schedule.models.SchedulePv;
import com.acadiasoft.im.schedule.models.utils.ScheduleCalculationType;
import com.acadiasoft.im.simm.engine.Simm;
import com.acadiasoft.im.simm.model.*;
import com.acadiasoft.im.simm.model.utils.SimmCalculationType;
import com.acadiasoft.im.simmple.model.Crif;
import com.acadiasoft.im.simmple.model.ImRole;
import com.acadiasoft.im.simmple.model.imtree.ConversionImTree;
import com.acadiasoft.im.simmple.model.result.ImTreeResult;
import com.acadiasoft.im.simmple.model.utils.SimmpleConversions;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.acadiasoft.im.simmple.model.utils.SimmpleUtils.*;

public class SimmpleForRegulator {

  /**
   *
   * @param crifs the input lines of CRIF formatted data
   * @param calculationCurrency the currency the calculation is run in
   * @param fx an fx conversion implementation
   * @param resultCurrency the currency the resulting trees margins are in
   * @param role the role that calculation is being run for
   * @param regulator the regulator we are calculating for
   * @param type the type of SIMM calculation being run
   * @return an ImTree at the model level with the model set to SIMM
   */
  public static ImTreeResult calculateSimmForRegulator(List<Crif> crifs, String calculationCurrency, FxConverter fx, String resultCurrency, ImRole role, String regulator, SimmCalculationType type) {
    // get all of the crif which are in the SIMM model class with the applied regualtor
    List<Crif> filteredForSimmAndRegulator = crifs.stream().filter(isSimm).filter(c -> containsRegulator(role, c, regulator)).collect(Collectors.toList());
    // get all of the add on type crif records and convert them to their SIMM equivalent
    List<Crif> filteredForAddOnType = filteredForSimmAndRegulator.stream().filter(isAddOnType).collect(Collectors.toList());
    List<ProductMultiplier> multipliers = filteredForAddOnType.stream().filter(isProductMultiplier).map(SimmpleConversions::convertToMultiplier).collect(Collectors.toList());
    List<AddOnNotionalFactor> factors = filteredForAddOnType.stream().filter(isNotionalFactor).map(SimmpleConversions::convertToFactor).collect(Collectors.toList());
    List<AddOnNotional> notionals = filteredForAddOnType.stream().filter(isSimmNotional).map(c -> SimmpleConversions.convertToSimmNotional(c, fx)).collect(Collectors.toList());
    List<AddOnFixedAmount> fixed = filteredForAddOnType.stream().filter(isFixedAmount).map(c -> SimmpleConversions.convertToFixed(c, fx)).collect(Collectors.toList());
    // get all of the regular sensitivities from crif and convert them
    List<Crif> filteredForSensitivity = filteredForSimmAndRegulator.stream().filter(isSensitivityType).collect(Collectors.toList());
    List<Sensitivity> sensitivities = filteredForSensitivity.stream().map(c -> SimmpleConversions.convertToSensitivity(c, fx, role)).collect(Collectors.toList());
    // recalculate tree in the result currency and set the sign so that pledgor negative
    return new ImTreeResult(ConversionImTree.convert(role, Simm.calculate(sensitivities, multipliers, factors, notionals, fixed, calculationCurrency, type), fx, FxRate.USD, resultCurrency), regulator, resultCurrency);
  }

  /**
   *
   * @param crifs the input lines of CRIF formatted data
   * @param fx an fx conversion implementation
   * @param resultCurrency the currency the resulting trees margins are in
   * @param role the role that the calculation is being run for
   * @param regulator the regulator that the calculation is being run for
   * @param netGrossRate an optional containing the NGR of the Schedule Calc if it is given
   * @return an ImTree at the model level with the model set to Schedule
   */
  public static ImTreeResult calculateScheduleForRegulator(List<Crif> crifs, FxConverter fx, String resultCurrency, ImRole role, String regulator, ScheduleCalculationType type, Optional<BigDecimal> netGrossRate) {
    // get all of the crif which are in the SCHEDLE model and have the applied regulator
    List<Crif> filteredForSimmAndRegulator = crifs.stream().filter(isSchedule).filter(c -> containsRegulator(role, c, regulator)).collect(Collectors.toList());
    // convert the CRIF objects to the schedule module's types
    List<ScheduleNotional> notionals = filteredForSimmAndRegulator.stream().filter(isScheduleNotional).map(c -> SimmpleConversions.convertToScheduleNotional(c, fx)).collect(Collectors.toList());
    // we save the list of filtered CRIF lines because we might need it later (see later comments)
    List<Crif> filteredForPvs = filteredForSimmAndRegulator.stream().filter(isSchedulePv).collect(Collectors.toList());
    List<SchedulePv> pvs = filteredForPvs.stream().map(c -> SimmpleConversions.convertToPv(c, fx, role)).collect(Collectors.toList());
    // now we need to check if there are any PV lines with notional field filled in without a corresponding Notional line -> if so add a new Notional line
    Set<ScheduleIdentifier> notionalIdentifiers = notionals.stream().map(n -> n.getIdentifier()).collect(Collectors.toSet());
    Set<ScheduleIdentifier> pvIdentifiers = pvs.stream().map(p -> p.getIdentifier()).collect(Collectors.toSet());
    if (pvIdentifiers.size() > notionalIdentifiers.size()) { // we have pv rows that need to be checked for the notional field
      pvIdentifiers.removeAll(notionalIdentifiers); // remove all of the duplicates so that we can work with only the surplus
      pvIdentifiers.forEach(id -> {
        // get a schedule pv crif with a matching trade id because then we can pull 'notional' field off of it
        List<Crif> matches = filteredForPvs.stream().filter(c -> c.getTradeId().equalsIgnoreCase(id.getTradeId())).filter(c -> !c.getNotionalString().isEmpty()).collect(Collectors.toList());
        // if the notional field is not filled for any schedule pvs with a matching trade id then we throw an error because there should be a notional
        if (matches.isEmpty()) throw new RuntimeException("There are no notional sensitivities for trade: " + id.getTradeId() + " and the 'notional' field is not filled in for any PVs");
        notionals.add(ScheduleNotional.make(id, SimmpleConversions.getCrifNotionalAmountUsd(matches.stream().findFirst().get(), fx)));
      });
    }

    // now we can calculate schedule im as normal, convert the tree to result currency and make it negative if role = pledgor
    return new ImTreeResult(ConversionImTree.convert(role, Schedule.calculate(notionals, pvs, type, netGrossRate), fx, FxRate.USD, resultCurrency), regulator, resultCurrency);
  }

}
