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

package com.acadiasoft.simm.engine.margin.vega;

import com.acadiasoft.simm.engine.param.RiskConcentration;
import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.engine.param.RiskWeight;
import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;
import org.apache.commons.math3.special.Erf;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class VegaMarginWeightUtils {

  /**
   * Φ^−1(x) = √2 * erfinv(2x−1)
   */
  public static final BigDecimal ALPHA = new BigDecimal(Math.sqrt(2.0) * Erf.erfInv(2 * .99 - 1));
  public static final BigDecimal CONST = new BigDecimal(Math.sqrt(365.0 / 14.0));

  /**
   * As defined in Appendix 1 section B.11.b of doc/ISDA_SIMM_vR1.0_(PUBLIC).pdf
   */
  public static List<WeightedSensitivity> weightSensitivitiesVol(RiskClass riskClass, List<Sensitivity> sensitivities) {
    return sensitivities.stream().map((s) -> weightSensitivityVol(riskClass, s)).collect(Collectors.toList());
  }

  public static List<WeightedSensitivity> weightSensitivitiesRisk(RiskClass riskClass, List<WeightedSensitivity> sensitivities) {
    return sensitivities.stream().map((s) -> weightSensitivityRisk(riskClass, s, RiskConcentration.getVegaConcentrationRisk(riskClass, s, sensitivities))).collect(Collectors.toList());
  }

  public static WeightedSensitivity weightSensitivityVol(RiskClass riskClass, Sensitivity sensitivity) {
    // Only FX, CM, and EQ sensitivities are vol weighted because in CRIF IR, CQ, and CNQ vega sensitivities are given as vega * volatility
    // as is described in doc/Risk-Data-Standards_v1.44 section 2.8 and doc/ISDA-SIMM-v1.3.38 paragraph 10(a)
    if (riskClass.equals(RiskClass.COMMODITY) || riskClass.equals(RiskClass.EQUITY) || riskClass.equals(RiskClass.FX)) {
      BigDecimal volFactor = getVolatilityFactor(riskClass);
      BigDecimal hvr = RiskWeight.getHVR(riskClass, sensitivity);
      BigDecimal riskWeight = getConditionalRiskWeight(riskClass, sensitivity);
      BigDecimal weightedValue = hvr.multiply(volFactor).multiply(riskWeight).multiply(sensitivity.getAmountUsd());
      return new WeightedSensitivity(sensitivity, weightedValue);
    } else {
      return new WeightedSensitivity(sensitivity, sensitivity.getAmountUsd());
    }
  }

  public static WeightedSensitivity weightSensitivityRisk(RiskClass riskClass, WeightedSensitivity ws, BigDecimal concentrationRisk) {
    BigDecimal vegaRiskWeight = RiskWeight.getVegaRiskWeight(riskClass, ws.getSensitivity());
    BigDecimal weightedValue = vegaRiskWeight.multiply(concentrationRisk).multiply(ws.getWeightedValue());
    return new WeightedSensitivity(ws.getSensitivity(), weightedValue);
  }

  public static BigDecimal getVolatilityFactor(RiskClass riskClass) {
    if (riskClass.equals(RiskClass.EQUITY) || riskClass.equals(RiskClass.FX) || riskClass.equals(RiskClass.COMMODITY)) {
      return CONST.divide(ALPHA, RoundingMode.HALF_UP);
    } else {
      return BigDecimal.ONE;
    }
  }

  public static BigDecimal getConditionalRiskWeight(RiskClass riskClass, Sensitivity sensitivity) {
    if (riskClass.equals(RiskClass.EQUITY) || riskClass.equals(RiskClass.FX) || riskClass.equals(RiskClass.COMMODITY)) {
      return RiskWeight.getRiskWeight(riskClass, sensitivity);
    } else if (riskClass.equals(RiskClass.INTEREST_RATE) || riskClass.equals(RiskClass.CREDIT_QUALIFYING) || riskClass.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return BigDecimal.ONE;
    } else {
      throw new RuntimeException("Unsupported com.acadiasoft.simm.model.risk class detected:" + riskClass);
    }
  }

}
