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

package com.acadiasoft.im.simm.model.utils;

import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.param.SimmHvr;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.special.Erf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SensitivityUtils {

  // Curvature scaling suffixes
  private static final String TENOR_SUFFIX_WEEKS = "w";
  private static final String TENOR_SUFFIX_MONTHS = "m";
  private static final String TENOR_SUFFIX_YEARS = "y";

  // Curvature scaling constants
  private static final BigDecimal FOURTEEN = new BigDecimal("14.0");
  private static final BigDecimal ONE_HALF = new BigDecimal("0.5");

  // Curvature scaling day-in counts
  private static final BigDecimal NUM_OF_MONTHS = new BigDecimal("12");
  private static final BigDecimal DAYS_IN_WEEK = new BigDecimal("7");
  private static final BigDecimal DAYS_IN_YEAR = new BigDecimal("365");
  private static final BigDecimal DAYS_PER_MONTH = BigDecimalUtils.divideWithPrecision(DAYS_IN_YEAR, NUM_OF_MONTHS);

  public static final String DELIMITER = ":ACADIA_DELIMITER:";

  /**
   * Φ^−1(x) = √2 * erfinv(2x−1)
   */
  private static final BigDecimal VOL_ALPHA = BigDecimal.valueOf(Math.sqrt(2.0) * Erf.erfInv(2 * .99 - 1));
  private static final BigDecimal VOL_CONST = BigDecimal.valueOf(Math.sqrt(365.0 / 14.0));

  public static List<Sensitivity> filterDeltaFxRiskInCalcCurrency(List<Sensitivity> list, String calculationCurrency) {
    return list.stream()
        .filter(sensitivity -> !(sensitivity.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_FX) && sensitivity.getQualifier().equalsIgnoreCase(calculationCurrency)))
        .collect(Collectors.toList());
  }

  public static <T> Map<T, List<Sensitivity>> mapByIdentifier(Function<Sensitivity, T> convert, List<Sensitivity> sensitivities) {
    return groupBy(sensitivities, convert);
  }

  public static <T, U> Map<T, List<U>> groupBy(List<U> list, Function<U, T> convert) {
    return list.stream().collect(Collectors.groupingBy(convert, Collectors.toList()));
  }

  public static <T, U> Map<T, U> groupByThenTakeFirst(List<U> list, Function<U, T> convert) {
    return list.stream().collect(Collectors.groupingBy(convert, Collectors.collectingAndThen(Collectors.toList(), l -> l.get(0))));
  }

  public static <T, K> List<T> listByMargin(Function<Map.Entry<K, List<Sensitivity>>, T> convert, Map<K, List<Sensitivity>> mapByIdentifier) {
    return mapByIdentifier.entrySet().stream()
        .map(convert)
        .collect(Collectors.toList());
  }

  /**
   * As defined in Appendix 1 section B.8.a, B.9.a of doc/ISDA_SIMM_vR1.0_(PUBLIC).pdf
   */
  public static List<Sensitivity> netSensitivitiesByRiskFactor(List<Sensitivity> sensitivities) {
    Map<String, BigDecimal> valuesMap = sensitivities.stream()
        .collect(Collectors.groupingBy(s -> s.getRiskFactorKey(),
            Collectors.collectingAndThen(
                Collectors.mapping(s -> s.getAmountUsd(), Collectors.toList()),
                list -> list.stream().reduce(BigDecimal.ZERO, BigDecimal::add)
            )
        ));

    return valuesMap.entrySet().stream()
        .map(e -> Sensitivity.fromRiskFactorKey(e.getKey(), e.getValue()))
        .collect(Collectors.toList());
  }

  /**
   *
   * @param sensitivities input sensitivities
   * @return list of sensitivities which contains vol weighted and scaled curvature sensitivities as well as vol weighted vega sensitivities
   */
  public static List<Sensitivity> handleInputSensitivities(List<Sensitivity> sensitivities, String calculationCurrency) {
    Map<SensitivityClass, List<Sensitivity>> map = mapByIdentifier(s -> s.getSensitivityIdentifier(), sensitivities);
    // First, we make the curvature sensitivities from the vega sensitivities and then scale them by SF(t)
    // we get all the sensitivities on the same "level"
    // EQ, FX, and CM vega & curvature sensitivities have not been multiplied by volatility factor,
    // while IR, CRQ, and CRNQ sensitivities have been, so we do this multiplication now
    List<Sensitivity> volWeightedVegas;
    List<Sensitivity> volWeightedCurvatures;
    if (map.containsKey(SensitivityClass.VEGA)) {
      List<Sensitivity> scaledCurvatures = SensitivityUtils.makeAndScaleCurvatureSensitivities(map.get(SensitivityClass.VEGA));
      volWeightedVegas = SensitivityUtils.volWeightSensitivities(map.get(SensitivityClass.VEGA), calculationCurrency);
      volWeightedCurvatures = SensitivityUtils.volWeightSensitivities(scaledCurvatures, calculationCurrency);
    } else {
      volWeightedVegas = new ArrayList<>();
      volWeightedCurvatures = new ArrayList<>();
    }

    // we need to unify all of the sensitivities at the same "level" together
    // filter delta and base corr out of original input
    List<Sensitivity> allSensitivities = map.entrySet().stream()
        .filter(e -> !e.getKey().equals(SensitivityClass.VEGA))
        .map(Map.Entry::getValue)
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
    allSensitivities.addAll(volWeightedCurvatures);
    allSensitivities.addAll(volWeightedVegas);
    return allSensitivities;
  }

  private static List<Sensitivity> volWeightSensitivities(List<Sensitivity> sensitivities, String calculationCurrency) {
    // method is only called on vega and curvature sensitivites
    return sensitivities.stream()
        .map(s -> Sensitivity.fromRiskFactorKey(s.getRiskFactorKey(),
          s.getAmountUsd().multiply(getVolatilityWeight(s, calculationCurrency))))
        .collect(Collectors.toList());
  }

  /**
   *
   * @param s the sensitivity that we are vol-weighting
   * @return the volatility weight which the input sensitivity amount needs to be multiplied by to get the vega x vol amount
   */
  private static BigDecimal getVolatilityWeight(Sensitivity s, String calculationCurrency) {
    RiskClass riskClass = s.getRiskIdentifier();
    if (riskClass.equals(RiskClass.COMMODITY) || riskClass.equals(RiskClass.EQUITY) || riskClass.equals(RiskClass.FX)) {
      // we need to multiply by RW, HVR, and volFactor to get weighting
      BigDecimal volFactor = getVolatilityFactor();
      // curvature doesn't have HVR value so we set it to one
      BigDecimal hvr = BigDecimal.ONE;
      if (s.getSensitivityIdentifier().equals(SensitivityClass.VEGA)) hvr = SimmHvr.get(riskClass);
      // need to get delta risk weight
      BigDecimal riskWeight = SimmRiskWeight.getForVolWeight(
        WeightingClass.determineWeightingClass(s.getWeightingClassIdentifier()), calculationCurrency);
      return hvr.multiply(volFactor).multiply(riskWeight);
    } else {
      // Credit, IR should already be vol-weighted so weighting is one
      return BigDecimal.ONE;
    }
  }

  private static BigDecimal getVolatilityFactor() {
    return BigDecimalUtils.divideWithPrecision(VOL_CONST, VOL_ALPHA);
  }

  private static List<Sensitivity> makeAndScaleCurvatureSensitivities(List<Sensitivity> sensitivities) {
    return sensitivities.stream()
        // the curvature margin of EQV bucket 12 is take to be zero so filter out any EQV-12 sensitivities
        .filter(s -> !(s.getRiskIdentifier().equals(RiskClass.EQUITY) && s.getBucket().equals("12")))
        .map(s -> Sensitivity.fromVegaToCurvature(s))
        .map(s -> Sensitivity.fromRiskFactorKey(s.getRiskFactorKey(), getScalingFunction(s.getLabel1()).multiply(s.getAmountUsd())))
        .collect(Collectors.toList());
  }

  private static BigDecimal getNumberOfDays(String expiry) {
    if (StringUtils.endsWithIgnoreCase(expiry, TENOR_SUFFIX_YEARS)) {
      return DAYS_IN_YEAR.multiply(new BigDecimal(StringUtils.replaceIgnoreCase(expiry, TENOR_SUFFIX_YEARS, StringUtils.EMPTY)));
    } else if (StringUtils.endsWithIgnoreCase(expiry, TENOR_SUFFIX_MONTHS)) {
      return DAYS_PER_MONTH.multiply(new BigDecimal(StringUtils.replaceIgnoreCase(expiry, TENOR_SUFFIX_MONTHS, StringUtils.EMPTY)));
    } else {
      return DAYS_IN_WEEK.multiply(new BigDecimal(StringUtils.replaceIgnoreCase(expiry, TENOR_SUFFIX_WEEKS, StringUtils.EMPTY)));
    }
  }

  private static BigDecimal getScalingFunction(String expiry) {
    BigDecimal days = getNumberOfDays(expiry);
    BigDecimal divide = BigDecimalUtils.divideWithPrecision(FOURTEEN, days);
    BigDecimal min = BigDecimal.ONE.min(divide);
    return ONE_HALF.multiply(min);
  }
}
