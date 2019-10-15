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
import com.acadiasoft.im.base.imtree.ImTree;
import com.acadiasoft.im.base.imtree.TotalMargin;
import com.acadiasoft.im.simm.model.utils.SimmCalculationType;
import com.acadiasoft.im.simmple.model.imtree.BlankImTree;
import com.acadiasoft.im.simmple.model.Crif;
import com.acadiasoft.im.simmple.model.ImRole;
import com.acadiasoft.im.simmple.model.result.ImTreeResult;
import com.acadiasoft.im.simmple.model.utils.SimmpleUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.acadiasoft.im.simmple.model.utils.SimmpleUtils.BLANK_REGULATOR_STRING;

/**
 *
 * Main functions of the library
 *
 * @author alec.stewart
 *
 */
public class Simmple extends SimmpleForRegulator {

  // NOTE: post regulator applies to the pledgor, collect regulator applies to the secured

  public static ImTreeResult calculateWorstOf(List<Crif> crifs, String calculationCurrency, FxRate fx, String resultCurrency, ImRole role, SimmCalculationType simmType, BigDecimal netGrossRate) {
    Function<String, ImTreeResult> convert= reg -> {
      // These methods both return trees at the model level, we need to have them in the same function so we calculate
      //  the total margin of SIMM plus Schedule for the same regulator.
      // If we move these into two separate calls a different regulator could be worse for either individual model
      //  which would result in an incorrect overall worst of amount when everything is summed
      ImTree schedule = calculateScheduleForRegulatorWithoutPvs(crifs, fx, resultCurrency, role, reg, netGrossRate).getImTree();
      ImTree simm = calculateSimmForRegulator(crifs, calculationCurrency, fx, resultCurrency, role, reg, simmType).getImTree();

      boolean scheduleIsZero = schedule.getMargin().setScale(0, RoundingMode.UP).equals(BigDecimal.ZERO);
      boolean simmIsZero = simm.getMargin().setScale(0, RoundingMode.UP).equals(BigDecimal.ZERO);
      if (scheduleIsZero && simmIsZero) return new ImTreeResult(new BlankImTree(), reg, resultCurrency);
      else if (scheduleIsZero) return new ImTreeResult(TotalMargin.build(simm), reg, resultCurrency);
      else if (simmIsZero) return new ImTreeResult(TotalMargin.build(schedule), reg, resultCurrency);
      else return new ImTreeResult(TotalMargin.build(simm, schedule), reg, resultCurrency);
    };

    // since we output Total level trees from the above function, we can simply return the output result
    return worstOf(crifs, role, convert, resultCurrency);
  }

  public static ImTreeResult calculateWorstOf(List<Crif> crifs, String calculationCurrency, FxRate fx, String resultCurrency, ImRole role, SimmCalculationType simmType) {
    Function<String, ImTreeResult> convert= reg -> {
      // These methods both return trees at the model level, we need to have them in the same function so we calculate
      //  the total margin of SIMM plus Schedule for the same regulator.
      // If we move these into two separate calls a different regulator could be worse for either individual model
      //  which would result in an incorrect overall worst of amount when everything is summed
      ImTree schedule = calculateScheduleForRegulatorWithPvs(crifs, fx, resultCurrency, role, reg).getImTree();
      ImTree simm = calculateSimmForRegulator(crifs, calculationCurrency, fx, resultCurrency, role, reg, simmType).getImTree();

      boolean scheduleIsZero = schedule.getMargin().setScale(0, RoundingMode.UP).equals(BigDecimal.ZERO);
      boolean simmIsZero = simm.getMargin().setScale(0, RoundingMode.UP).equals(BigDecimal.ZERO);
      if (scheduleIsZero && simmIsZero) return new ImTreeResult(new BlankImTree(), reg, resultCurrency);
      else if (scheduleIsZero) return new ImTreeResult(TotalMargin.build(simm), reg, resultCurrency);
      else if (simmIsZero) return new ImTreeResult(TotalMargin.build(schedule), reg, resultCurrency);
      else return new ImTreeResult(TotalMargin.build(simm, schedule), reg, resultCurrency);
    };

    // since we output Total level trees from the above function, we can simply return the output result
    return worstOf(crifs, role, convert, resultCurrency);
  }

  public static ImTreeResult calculateScheduleWorstOf(List<Crif> crifs, FxRate fx, String resultCurrency, ImRole role, BigDecimal netGrossRate) {
    ImTreeResult treeResult = worstOf(crifs, role, reg -> calculateScheduleForRegulatorWithoutPvs(crifs, fx, resultCurrency, role, reg, netGrossRate), resultCurrency);
    return new ImTreeResult(TotalMargin.build(treeResult.getImTree()), treeResult.getRegulator(), treeResult.getCurrency());
  }

  public static ImTreeResult calculateScheduleWorstOf(List<Crif> crifs, FxRate fx, String resultCurrency, ImRole role) {
    ImTreeResult treeResult = worstOf(crifs, role, reg -> calculateScheduleForRegulatorWithPvs(crifs, fx, resultCurrency, role, reg), resultCurrency);
    return new ImTreeResult(TotalMargin.build(treeResult.getImTree()), treeResult.getRegulator(), treeResult.getCurrency());
  }

  public static ImTreeResult calculateSimmWorstOf(List<Crif> crifs, String calculationCurrency, FxRate fx, String resultCurrency, ImRole role, SimmCalculationType simmType) {
    ImTreeResult treeResult = worstOf(crifs, role, reg -> calculateSimmForRegulator(crifs, calculationCurrency, fx, resultCurrency, role, reg, simmType), resultCurrency);
    return new ImTreeResult(TotalMargin.build(treeResult.getImTree()), treeResult.getRegulator(), treeResult.getCurrency());
  }

  private static ImTreeResult worstOf(List<Crif> crifs, ImRole role, Function<String, ImTreeResult> convert, String resultCurrency) {
    // NOTE: every result will be in the same currency so we can just do a straight BigDecimal comparison
    List<ImTreeResult> results = SimmpleUtils.getAllowedRegulators(crifs, role).stream().map(convert).collect(Collectors.toList());
    if (results.isEmpty()) return new ImTreeResult(new BlankImTree(), BLANK_REGULATOR_STRING, resultCurrency);
    results.sort(Comparator.comparing(ImTreeResult::getRegulator)); // sort in alphabetical order
    return Collections.max(results, Comparator.comparing(result -> result.getImTree().getMargin().abs()));
  }

}
