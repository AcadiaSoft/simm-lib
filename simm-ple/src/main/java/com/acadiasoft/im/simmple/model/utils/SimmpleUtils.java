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

package com.acadiasoft.im.simmple.model.utils;

import com.acadiasoft.im.base.imtree.identifiers.ImModelClass;
import com.acadiasoft.im.schedule.models.utils.ScheduleRiskType;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnSubType;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simmple.model.Crif;
import com.acadiasoft.im.simmple.model.ImRole;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * Utils class for Simmple functions
 *
 * @author alec.stewart
 *
 */
public class SimmpleUtils {

  private static final String[] BLANK_REGUALTOR_REGEXS = { "\\s*", "\\[\\s?\\]" };
  private static final String BRACKET_REGEX = "\\[.*\\]";
  private static final String REGULATOR_DELIMITER = ",";

  public static final String INCLUDED = "included";
  public static final String ALL_REGULATORS_STRING = "SIMMPLE_ALL_REGS_WILDCARD";
  public static final String BLANK_REGULATOR_STRING = StringUtils.EMPTY;

  // add on type predicates
  public static final Predicate<Crif> isAddOnType = crif -> AddOnSubType.isAddOnSubType(crif.getRiskType());
  public static final Predicate<Crif> isSensitivityType = crif -> RiskClass.isSimmRiskType(crif.getRiskType());

  // im model class predicates
  public static final Predicate<Crif> isSimm = c -> determineModelClass(c.getImModel(), c.getRiskType()).equals(ImModelClass.SIMM);
  public static final Predicate<Crif> isSchedule = c -> determineModelClass(c.getImModel(), c.getRiskType()).equals(ImModelClass.SCHEDULE);

  /**
   *  It is allowed/or at least very common for 'param' risk types to not have the
   *  model string filled in for their line of CRIF, however, we still want to correctly
   *  map these lines of CRIF to SIMM. This method handles that conversion.
   *
   * @param model the model string whose class we are trying to determine
   * @param riskType the risk type of the CRIF whose model string we are determining
   * @return the model class of the model string
   */
  private static ImModelClass determineModelClass(String model, String riskType) {
    if (model.equals(StringUtils.EMPTY)) {
      // TODO: if the notional string is ever change to differentiate between schedule and simm then we need to update this
      if (riskType.equalsIgnoreCase("Notional")) {
        throw new RuntimeException("Tried to determine model from risk type since the model field was omitted" +
            "but the risk type was notional which could be either SIMM or SCHEDULE");
      } else if (AddOnSubType.isAddOnSubType(riskType)) {
        return ImModelClass.SIMM;
      } else if (RiskClass.isSimmRiskType(riskType)) {
        return ImModelClass.SIMM;
      } else if (ScheduleRiskType.isScheduleRiskType(riskType)) {
        return ImModelClass.SCHEDULE;
      } else {
        throw new RuntimeException("Unknown risk type found while trying to identify omitted model: [" + riskType + "]!");
      }
    } else {
      return ImModelClass.determineModelClass(model);
    }
  }

  /**
   *
   * @param role the role that the im is being calculated from
   * @return a function which returns regulators associated with that role for a given line of CRIF
   */
  private static String getRegulatorByRole(ImRole role, Crif crif) {
    if (role.equals(ImRole.SECURED)) return crif.getCollectRegulation();
    return crif.getPostRegulation();
  }

  public static boolean containsRegulator(ImRole role, Crif crif, String regulator) {
    if (regulator.equalsIgnoreCase(INCLUDED)) {
      return getRegulatorByRole(ImRole.PLEDGOR, crif).equalsIgnoreCase(regulator) || getRegulatorByRole(ImRole.SECURED, crif).equalsIgnoreCase(regulator);
    } else if (getRegulatorByRole(role, crif).equalsIgnoreCase(ALL_REGULATORS_STRING)) {
      return true;
    } else {
      return StringUtils.containsIgnoreCase(getRegulatorByRole(role, crif), regulator);
    }
  }

  // predicates for specific add on types
  public static final Predicate<Crif> isProductMultiplier = crif -> crif.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_PRODUCT_MULTIPLIER);
  public static final Predicate<Crif> isSimmNotional = crif -> crif.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_NOTIONAL);
  public static final Predicate<Crif> isNotionalFactor = crif -> crif.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_NOTIONAL_FACTOR);
  public static final Predicate<Crif> isFixedAmount = crif -> crif.getRiskType().equalsIgnoreCase(AddOnSubType.ADD_ON_FIXED_AMOUNT);

  // predicates for schedule types
  public static final Predicate<Crif> isScheduleNotional = crif -> crif.getRiskType().equalsIgnoreCase(ScheduleRiskType.SCHEDULE_NOTIONAL);
  public static final Predicate<Crif> isSchedulePv = crif -> crif.getRiskType().equalsIgnoreCase(ScheduleRiskType.SCHEDULE_PV);

  /**
   *
   * @param crifs the crifs whose regulators we are pulling
   * @param role the role that we are calculating IM for
   * @return a set of all regulators for that role
   */
  public static Set<String> getAllowedRegulators(List<Crif> crifs, ImRole role) {
    // check which mode of calc we are in: all blank, 'included', or standard regs.
    // we check both post and collect regs at first because having all post regs blank but all collect regs filled
    //  would not fall under the 'all blank' mode of calculation.
    Set<String> check = crifs.stream()
        .map(c -> {
          List<String> list = new ArrayList<>();
          list.addAll(parseRegulatorString(SimmpleUtils.getRegulatorByRole(ImRole.PLEDGOR, c)));
          list.addAll(parseRegulatorString(SimmpleUtils.getRegulatorByRole(ImRole.SECURED, c)));
          return list;
        })
        .flatMap(Collection::stream)
        .collect(Collectors.collectingAndThen(Collectors.toSet(), SimmpleUtils::convertAllBlankRegulators));

    // remove all regs string if it is there
    check.remove(ALL_REGULATORS_STRING);

    if (check.size() == 1 && check.contains(BLANK_REGULATOR_STRING)) {
      return check; // all blank mode, return ""
    } else if (check.size() == 2 && check.contains(INCLUDED)) {
      // note that in usual execution, there is validation to ensure the input only contains "" and "included"
      //  this validation isn't included in the library but users should stick to this manually.
      check.remove(BLANK_REGULATOR_STRING);
      return check; // include mode, returned "included"
    } else {
      Set<String> regulators = crifs.stream()
          .map(c -> parseRegulatorString(SimmpleUtils.getRegulatorByRole(role, c)))
          .flatMap(Collection::stream)
          .collect(Collectors.collectingAndThen(Collectors.toSet(), SimmpleUtils::convertAllBlankRegulators));

      regulators.remove(ALL_REGULATORS_STRING);
      regulators.remove(BLANK_REGULATOR_STRING);
      return regulators; // regular regulators mode
    }
  }

  private static List<String> parseRegulatorString(String regString) {
    if (regString.matches(BRACKET_REGEX)) regString = regString.substring(1, regString.length() - 1);
    return Arrays.asList(regString.split(REGULATOR_DELIMITER));
  }

  private static Set<String> convertAllBlankRegulators(Set<String> regulators) {
    Set<String> set = new HashSet<>();
    for (String regulator: regulators) {
      if (regulator.matches(BLANK_REGUALTOR_REGEXS[0]) || regulator.matches(BLANK_REGUALTOR_REGEXS[1])) {
        set.add(BLANK_REGULATOR_STRING);
      } else {
        set.add(regulator);
      }
    }

    return set;
  }

}
