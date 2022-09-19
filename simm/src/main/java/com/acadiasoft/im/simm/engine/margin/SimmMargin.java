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

package com.acadiasoft.im.simm.engine.margin;

import com.acadiasoft.im.base.margin.ModelMargin;
import com.acadiasoft.im.base.margin.SiloMargin;
import com.acadiasoft.im.base.model.imtree.identifiers.ImModelClass;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.base.util.ListUtils;
import com.acadiasoft.im.simm.config.SimmCalculationType;
import com.acadiasoft.im.simm.config.SimmConfig;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.SensitivityIdentifier;
import com.acadiasoft.im.simm.model.imtree.identifiers.ProductClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;
import com.acadiasoft.im.simm.model.utils.CurvatureSensitivityUtils;
import com.acadiasoft.im.simm.model.utils.VolWeightUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class SimmMargin extends ModelMargin {

  private static final long serialVersionUID = 1L;

  private SimmMargin(BigDecimal margin, List<SiloMargin> children) {
    super(ImModelClass.SIMM, margin, children);
  }

  public static SimmMargin calculate(List<Sensitivity> sensitivities, SimmConfig config) {
    // separate the add on and regular sensitivity types
    List<Sensitivity> filterForStandard = sensitivities.stream() //
        .filter(SensitivityIdentifier::isSimmStandard) //
        .collect(Collectors.toList());

    // filter out any fx delta risk to the calculation currency
    List<Sensitivity> fxFiltered = filterDeltaFxRiskInCalcCurrency(filterForStandard, config.calculationCurrency());

    // build any curvature sensitivities from vegas, and then vol-weight the vega and curvature
    List<Sensitivity> weighted = addCurvaturesAndVolWeight(fxFiltered, config);

    // calculate the exposure for each product class present
    List<ProductMargin> marginByProductClass = getMarginByProductClass(weighted, config);
    BigDecimal productSum = BigDecimalUtils.sum(marginByProductClass, ProductMargin::getMargin);

    // now determine which mode we are in and calculate accordingly
    if (config.simmCalculationType().equals(SimmCalculationType.STANDARD)) {
      return new SimmMargin(productSum, new ArrayList<>(marginByProductClass));
    } else {
      // calculate the add on exposure
      List<Sensitivity> addOns = sensitivities.stream() //
          .filter(SensitivityIdentifier::isAddOn) //
          .collect(Collectors.toList());
      AddOnMargin addOnMargin = AddOnMargin.calculate(addOns, marginByProductClass, config);

      // now return the add on exposure based on the settings
      if (config.simmCalculationType().equals(SimmCalculationType.ADDITIONAL)) {
        return new SimmMargin(addOnMargin.getMargin(), Collections.singletonList(addOnMargin));
      } else if (addOnMargin.getMargin().setScale(0, RoundingMode.UP).equals(BigDecimal.ZERO)) {
        return new SimmMargin(productSum, new ArrayList<>(marginByProductClass));
      } else if (productSum.setScale(0, RoundingMode.UP).equals(BigDecimal.ZERO)) {
        return new SimmMargin(addOnMargin.getMargin(), Collections.singletonList(addOnMargin));
      } else {
        List<SiloMargin> simmSiloMargin = new ArrayList<>(marginByProductClass);
        simmSiloMargin.add(addOnMargin);
        return new SimmMargin(productSum.add(addOnMargin.getMargin()), simmSiloMargin);
      }
    }
  }

  private static List<ProductMargin> getMarginByProductClass(List<Sensitivity> sensitivities, SimmConfig config) {
    // map sensitivities by product class, build the exposure of each product class
    return ListUtils.groupBy(sensitivities, SensitivityIdentifier::getProductIdentifier).entrySet().stream().map(entry -> {
      ProductClass productClass = config.useSingleProductClass() ? ProductClass.SINGLE : entry.getKey();
      return ProductMargin.calculate(productClass, entry.getValue(), config);
    }).collect(Collectors.toList());
  }

  private static List<Sensitivity> filterDeltaFxRiskInCalcCurrency(List<Sensitivity> list, String calculationCurrency) {
    return list.stream()
        .filter(sensitivity -> !(sensitivity.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_FX) && sensitivity.getQualifier().equalsIgnoreCase(calculationCurrency)))
        .collect(Collectors.toList());
  }

  /**
   * First, we make the curvature sensitivities from the vega sensitivities and then scale them by SF(t) we get all the
   * sensitivities on the same "level" EQ, FX, and CM vega & curvature sensitivities have not been multiplied by
   * volatility factor, while IR, CRQ, and CRNQ sensitivities have been, so we do this multiplication now
   *
   * @param sensitivities
   *          the set of sensitivities
   * @return the set of sensitivities with curvatures added and scaled, and curvatures/vegas vol-weighted
   */
  private static List<Sensitivity> addCurvaturesAndVolWeight(List<Sensitivity> sensitivities, SimmConfig config) {
    Map<SensitivityClass, List<Sensitivity>> map = ListUtils.groupBy(sensitivities, SensitivityIdentifier::getSensitivityClass);
    if (map.containsKey(SensitivityClass.VEGA)) {
      // get the vegas and the scaled curvature sensitivities
      List<Sensitivity> baseVegas = map.get(SensitivityClass.VEGA);
      List<Sensitivity> scaledCurvatures = CurvatureSensitivityUtils.makeAndScaleCurvatures(baseVegas, config);

      // vol weight both sets of sensitivities
      List<Sensitivity> volWeightedVegas = VolWeightUtils.volWeightSensitivities(baseVegas, config);
      List<Sensitivity> volWeightedCurvatures = VolWeightUtils.volWeightSensitivities(scaledCurvatures, config);

      // add them back to the set of delta sensitivities
      List<Sensitivity> list = Optional.ofNullable(map.get(SensitivityClass.DELTA)).orElse(new ArrayList<>());
      list.addAll(Optional.ofNullable(map.get(SensitivityClass.BASECORR)).orElse(Collections.emptyList()));
      list.addAll(volWeightedVegas);
      list.addAll(volWeightedCurvatures);
      return list;
    } else {
      // there are no vega sensitivities so just return the original list as we don't have to do anything
      return sensitivities;
    }
  }

}
