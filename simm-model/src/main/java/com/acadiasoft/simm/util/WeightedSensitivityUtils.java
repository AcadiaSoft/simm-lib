/*
 * Copyright (c) 2017 AcadiaSoft, Inc.
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

package com.acadiasoft.simm.util;

import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.risk.RiskType;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;
import com.acadiasoft.util.BigDecimalUtils;
import com.acadiasoft.util.MapUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;

public class WeightedSensitivityUtils {

  public static BigDecimal sumWeightSensitivities(List<WeightedSensitivity> weightSensitivities) {
    return BigDecimalUtils.sum(weightSensitivities, WeightedSensitivity::getWeightedValue);
  }

  public static BigDecimal sumSquared(List<WeightedSensitivity> weightedSensitivities) {
    return BigDecimalUtils.sumSquared(weightedSensitivities, WeightedSensitivity::getWeightedValue);
  }

  public static BigDecimal sumAbsoluteValues(List<WeightedSensitivity> weightedSensitivities) {
    return weightedSensitivities.stream().map(WeightedSensitivity::getWeightedValue).map(BigDecimalUtils::abs).reduce(BigDecimalUtils::sum).get();
  }

  public static Map<String, List<WeightedSensitivity>> mapByBucket(RiskClass riskClass, List<WeightedSensitivity> weightSensitivities) {
    Map<String, List<WeightedSensitivity>> map = new LinkedHashMap<>();
    if (CollectionUtils.isNotEmpty(weightSensitivities)) {
      for (WeightedSensitivity weightedSensitivity : weightSensitivities) {
        Sensitivity sensitivity = weightedSensitivity.getSensitivity();
        if (RiskClass.INTEREST_RATE.equals(riskClass)) {
          MapUtils.safePut(map, sensitivity.getQualifier(), weightedSensitivity);
        } else {
          MapUtils.safePut(map, sensitivity.getBucket(), weightedSensitivity);
        }
      }
    }
    return map;
  }

  public static List<WeightedSensitivity> netSensitivitiesByRiskFactor(RiskClass riskClass, List<WeightedSensitivity> sensitivities) {
    Map<String, BigDecimal> valuesMap = new LinkedHashMap<>();
    Map<String, BigDecimal> weightedValuesMap = new LinkedHashMap<>();
    List<WeightedSensitivity> riskFactorList = new ArrayList<>();

    if (CollectionUtils.isNotEmpty(sensitivities)) {
      for (WeightedSensitivity weightedSensitivity : sensitivities) {
        Sensitivity sensitivity = weightedSensitivity.getSensitivity();

        String label1 = determineLabel1(riskClass, sensitivity);
        String qualifier = determineQualifier(riskClass, sensitivity);
        String key = sensitivity.getProductClass() + "/" + sensitivity.getRiskType() + "/" + qualifier
          + "/" + sensitivity.getBucket() + "/" + label1 + "/" + sensitivity.getLabel2();

        if (valuesMap.containsKey(key)) {
          BigDecimal wv = weightedValuesMap.get(key);
          BigDecimal v = valuesMap.get(key);
          weightedValuesMap.put(key, wv.add(weightedSensitivity.getWeightedValue()));
          valuesMap.put(key, v.add(sensitivity.getAmountUsd()));
        } else {
          weightedValuesMap.put(key, weightedSensitivity.getWeightedValue());
          valuesMap.put(key, sensitivity.getAmountUsd());
        }
      }
    }

    for (Entry<String, BigDecimal> valueEntry : valuesMap.entrySet()) {
      String key = valueEntry.getKey();
      riskFactorList.add(new WeightedSensitivity(new Sensitivity(key, valueEntry.getValue()), weightedValuesMap.get(key)));
    }

    return riskFactorList;
  }

  /**
   * Appendix 1 B.11.b
   *
   * @param riskClass
   * @param sensitivity
   * @return
   */
  public static String determineLabel1(RiskClass riskClass, Sensitivity sensitivity) {
    // NOTE: we sum over vol-tenors for EQ,FX,CM classes
    // FIXME: ISDA's UnitTest indicates that Inflation Vol is also netted; however I can't find mention of this in doc/v1.3.38
    if (RiskClass.EQUITY.equals(riskClass) || //
      RiskClass.FX.equals(riskClass) || //
      RiskClass.COMMODITY.equals(riskClass) ||
      (RiskClass.INTEREST_RATE.equals(riskClass) && sensitivity.getRiskType().equals(RiskType.RISK_TYPE_INFLATION_VOL))) {
      return StringUtils.EMPTY;
    } else {
      return sensitivity.getLabel1();
    }
  }

  public static String determineQualifier(RiskClass riskClass, Sensitivity sensitivity) {
    String qualifier = sensitivity.getQualifier();

    if (RiskClass.FX.equals(riskClass)) {
      String ccy1 = StringUtils.substring(qualifier, 0, 3);
      String ccy2 = StringUtils.substring(qualifier, 3, 6);
      qualifier = Arrays.asList(ccy1, ccy2).stream().sorted().reduce((s1, s2) -> {
        return s1 + s2;
      }).get();
    }
    return qualifier;
  }
}
