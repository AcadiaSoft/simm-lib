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

import com.acadiasoft.simm.model.product.ProductClass;
import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.util.MapUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SensitivityUtils {

  public static Map<ProductClass, List<Sensitivity>> mapByProductClass(List<Sensitivity> sensitivities) {
    Map<ProductClass, List<Sensitivity>> map = new LinkedHashMap<>();
    if (CollectionUtils.isNotEmpty(sensitivities)) {
      for (Sensitivity sensitivity : sensitivities) {
        ProductClass productClass = ProductClass.getByLabel(sensitivity.getProductClass());
        MapUtils.safePut(map, productClass, sensitivity);
      }
    }
    return map;
  }

  public static Map<RiskClass, List<Sensitivity>> mapByRiskType(List<Sensitivity> sensitivities) {
    Map<RiskClass, List<Sensitivity>> map = new LinkedHashMap<>();
    if (CollectionUtils.isNotEmpty(sensitivities)) {
      for (Sensitivity sensitivity : sensitivities) {
        RiskClass riskClass = RiskClass.getByRiskType(sensitivity.getRiskType());
        MapUtils.safePut(map, riskClass, sensitivity);
      }
    }
    return map;
  }

  /**
   * As defined in Appendix 1 section B.8.a, B.9.a of doc/ISDA_SIMM_vR1.0_(PUBLIC).pdf
   */
  public static List<Sensitivity> netSensitivitiesByRiskFactor(RiskClass riskClass, List<Sensitivity> sensitivities) {
    List<Sensitivity> riskFactorList = new ArrayList<>();
    Map<String, BigDecimal> valuesMap = new LinkedHashMap<>();

    if (CollectionUtils.isNotEmpty(sensitivities)) {
      for (Sensitivity sensitivity : sensitivities) {
        String key = sensitivity.getProductClass() + "/" + sensitivity.getRiskType() + "/" + sensitivity.getQualifier() + "/" + sensitivity.getBucket()
          + "/" + sensitivity.getLabel1() + "/" + sensitivity.getLabel2();

        if (valuesMap.containsKey(key)) {
          BigDecimal value = valuesMap.get(key);
          valuesMap.put(key, value.add(sensitivity.getAmountUsd()));
        } else {
          valuesMap.put(key, sensitivity.getAmountUsd());
        }
      }
    }

    for (Entry<String, BigDecimal> valueEntry : valuesMap.entrySet()) {
      riskFactorList.add(new Sensitivity(valueEntry.getKey(), valueEntry.getValue()));
    }

    return riskFactorList;
  }
}
