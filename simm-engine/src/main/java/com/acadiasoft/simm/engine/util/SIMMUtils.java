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

package com.acadiasoft.simm.engine.util;

import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.risk.RiskClassCorrelationV2_0;
import com.acadiasoft.util.BigDecimalUtils;

import java.math.BigDecimal;
import java.util.Map;

public class SIMMUtils {

  public static BigDecimal sumSquaresByRiskClass(Map<RiskClass, BigDecimal> deltasByRiskClass) {
    BigDecimal sumSquared = BigDecimal.ZERO;
    for (RiskClass riskClassA : deltasByRiskClass.keySet()) {
      sumSquared = sumSquared.add(deltasByRiskClass.get(riskClassA).pow(2));
    }
    return sumSquared;
  }

  public static BigDecimal sumCorrelationsByRiskClass(Map<RiskClass, BigDecimal> deltasByRiskClass) {
    BigDecimal sumCorrelated = BigDecimal.ZERO;
    for (RiskClass riskClassR : deltasByRiskClass.keySet()) {
      for (RiskClass riskClassS : deltasByRiskClass.keySet()) {
        if (!riskClassR.equals(riskClassS)) {
          BigDecimal correlation = RiskClassCorrelationV2_0.get(riskClassR, riskClassS);
          BigDecimal product = correlation.multiply(deltasByRiskClass.get(riskClassR)).multiply(deltasByRiskClass.get(riskClassS));
          sumCorrelated = sumCorrelated.add(product);
        }
      }
    }
    return sumCorrelated;
  }

  public static void addToRiskClassMap(Map<RiskClass, BigDecimal> imByRiskClass, RiskClass key, BigDecimal riskClassIm) {
    if (!imByRiskClass.containsKey(key)) {
      imByRiskClass.put(key, riskClassIm);
    } else {
      imByRiskClass.put(key, imByRiskClass.get(key).add(riskClassIm));
    }
  }

  public static BigDecimal calculateProductMargin(Map<RiskClass, BigDecimal> marginByRiskClass) {
    BigDecimal sumSquared = sumSquaresByRiskClass(marginByRiskClass);
    BigDecimal sumCorrelated = sumCorrelationsByRiskClass(marginByRiskClass);
    BigDecimal sqrt = BigDecimalUtils.sqrt(sumSquared.add(sumCorrelated));
    return sqrt;
  }

}
