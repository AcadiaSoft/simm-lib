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

package com.acadiasoft.im.simmple.model;

import com.acadiasoft.im.base.model.imtree.identifiers.ImModelClass;
import com.acadiasoft.im.schedule.models.DefaultScheduleSensitivity;
import com.acadiasoft.im.schedule.models.ScheduleSensitivity;
import com.acadiasoft.im.schedule.models.utils.ScheduleRiskType;
import com.acadiasoft.im.simm.model.DefaultSensitivity;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnSubType;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simmple.config.ImRole;
import com.acadiasoft.im.simmple.config.SimmpleConfig;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Crif extends Sensitivity, ScheduleSensitivity {

  String SPACE_REGEX = "\\s+";
  String BRACKET_REGEX = "\\[(.*)]";
  String QUOTE_REGEX = "\"([^,]*)\"";
  String FIRST_CAPTURE_GROUP = "$1";
  String REGULATOR_DELIMITER = ",";
  String INCLUDED = "included";
  String BLANK_REGULATOR_STRING = "";
  String ALL_REGULATORS_STRING = "SIMMPLE_ALL_REGS_WILDCARD";

  public String getImModel();

  public String getPostRegulation();

  public String getCollectRegulation();

  // ---------------------- amount mapping methods -------------------------

  default Sensitivity convertSensitivityAmountForRole(SimmpleConfig config) {
    if (ImRole.PLEDGOR.equals(config.imRole()) && this.isSimmStandard()) {
      return new DefaultSensitivity(this, getAmountUsd(config.fxRate()).negate());
    } else {
      return this;
    }
  }

  default ScheduleSensitivity convertScheduleAmountForRole(SimmpleConfig config) {
    if (ImRole.SECURED.equals(config.imRole()) && this.isSchedulePv()) {
      return new DefaultScheduleSensitivity(this, this.getTradeNotionalAsString(), this.getTradeCurrency(),
        getAmountUsd(config.fxRate()).negate());
    } else {
      return this;
    }
  }

  // -------------------- im model class predicates ------------------------

  Predicate<Crif> isSimm = crif -> crif.getImModelIdentifier().equals(ImModelClass.SIMM);
  Predicate<Crif> isSchedule = crif -> crif.getImModelIdentifier().equals(ImModelClass.SCHEDULE);

  // -------------------- im model class methods ---------------------------

  String MODEL_OMMITTED_FOR_NOTIONAL = "Tried to determine model from risk type since the model field was omitted" +
    "but the risk type was notional which could be either SIMM or SCHEDULE";
  String UNKNOWN_RISK_TYPE = "Unknown risk type found while trying to identify omitted model: [%s]!";

  default ImModelClass getImModelIdentifier() {
    String model = getImModel();
    String riskType = getRiskType();
    if (model == null || model.equals(StringUtils.EMPTY)) {
      // TODO: if the notional string is ever change to differentiate between schedule and simm then we need to update this
      if (riskType.equalsIgnoreCase(ScheduleRiskType.SCHEDULE_NOTIONAL)) {
        throw new IllegalStateException(MODEL_OMMITTED_FOR_NOTIONAL);
      } else if (AddOnSubType.isAddOnSubType(riskType)) {
        return ImModelClass.SIMM;
      } else if (RiskClass.isSimmRiskType(riskType)) {
        return ImModelClass.SIMM;
      } else if (ScheduleRiskType.isScheduleRiskType(riskType)) {
        return ImModelClass.SCHEDULE;
      } else {
        throw new IllegalStateException(String.format(UNKNOWN_RISK_TYPE, riskType));
      }
    } else {
      return ImModelClass.determineModelClass(model);
    }
  }

  // ------------------ methods for regulation --------------------------

  default String getRegulation(ImRole role) {
    String regulation = (ImRole.SECURED.equals(role)) ?
      this.getCollectRegulation() : this.getPostRegulation();
    regulation = regulation.replaceAll(BRACKET_REGEX, FIRST_CAPTURE_GROUP);
    regulation = regulation.replaceAll(QUOTE_REGEX, FIRST_CAPTURE_GROUP);
    return regulation.replaceAll(SPACE_REGEX, "");
  }

  default String[] getRegulatorArray(ImRole role) {
    return getRegulation(role).split(REGULATOR_DELIMITER);
  }

  default boolean containsRegulator(ImRole role, String toCheck) {
    String regulation = getRegulation(role);
    return (getRegulation(role).equalsIgnoreCase(ALL_REGULATORS_STRING))
      || (toCheck.equalsIgnoreCase(INCLUDED) && (getPostRegulation().equalsIgnoreCase(INCLUDED) || getCollectRegulation().equalsIgnoreCase(INCLUDED)))
      || (StringUtils.containsIgnoreCase(regulation, toCheck));
  }

  static Set<String> getRegulators(List<Crif> crifs, ImRole role) {
    // check which mode of calc we are in: all blank, 'included', or standard regs
    Set<String> regulators = crifs.stream()
      .map(crif -> crif.getRegulatorArray(role))
      .flatMap(Stream::of)
      .collect(Collectors.toSet());

    // we also need to check the  other roles regs because having all post regs blank but all collect regs filled
    // would not fall under the 'all blank' mode of calculation -- so add other role to the set we will check
    Set<String> modeCheck = new HashSet<>(regulators);
    crifs.stream()
      .map(crif -> crif.getRegulatorArray(role.swapRole()))
      .flatMap(Stream::of)
      .forEach(modeCheck::add);

    // remove the all regulators flag if it is present as it has no bearing on our mode check
    modeCheck.remove(ALL_REGULATORS_STRING);

    // now use the mode check to determine what the set of regulators is
    if (modeCheck.size() == 1 && modeCheck.contains(BLANK_REGULATOR_STRING)) {
      return Collections.singleton(""); // all blank mode, return ""
    } else if (modeCheck.size() == 2 && modeCheck.contains(INCLUDED)) {
      // note that in usual execution, there is validation to ensure the input only contains "" and "included"
      //  this validation isn't included in the library but users should stick to this manually.
      return Collections.singleton(INCLUDED); // include mode, returned "included"
    } else {
      // we are in the standard regulation mode
      regulators.remove(ALL_REGULATORS_STRING);
      regulators.remove(BLANK_REGULATOR_STRING);
      return regulators; // regular regulators mode
    }
  }

}
