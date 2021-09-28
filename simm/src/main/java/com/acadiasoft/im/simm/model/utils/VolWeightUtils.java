/*
 * Copyright (c) 2021 AcadiaSoft, Inc.
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
import com.acadiasoft.im.simm.config.HoldingPeriod;
import com.acadiasoft.im.simm.config.SimmConfig;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;
import com.acadiasoft.im.simm.model.param.SimmHvr;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;
import org.apache.commons.math3.special.Erf;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class VolWeightUtils {

  private static final BigDecimal FOURTEEN = BigDecimal.valueOf(14.0);
  private static final BigDecimal DAYS_IN_YEAR = BigDecimal.valueOf(365);

  /**
   * Φ^−1(x) = √2 * erfinv(2x−1)
   */
  private static final BigDecimal VOL_ALPHA = BigDecimal.valueOf(Math.sqrt(2.0) * Erf.erfInv(2 * .99 - 1));
  private static final BigDecimal VOL_CONST = BigDecimalUtils.sqrt(
    BigDecimalUtils.divideWithPrecision(DAYS_IN_YEAR, FOURTEEN)
  );
  private static final BigDecimal VOL_CONST_DIVIDED_BY_SQRT_10 = BigDecimalUtils.sqrt(
    BigDecimalUtils.divideWithPrecision(DAYS_IN_YEAR, BigDecimal.valueOf(1.4))
  );

  private static BigDecimal getVolFactor(HoldingPeriod period) {
    BigDecimal volConst = (period.equals(HoldingPeriod.TEN_DAY)) ? VOL_CONST : VOL_CONST_DIVIDED_BY_SQRT_10;
    return BigDecimalUtils.divideWithPrecision(volConst, VOL_ALPHA);
  }

  /**
   *
   * @param sensitivity the sensitivity that we are vol-weighting
   * @return the volatility weight which the input sensitivity amount needs to be multiplied by to get the vega x vol amount
   */
  private static BigDecimal getVolatilityWeight(Sensitivity sensitivity, SimmConfig config) {
    RiskClass riskClass = sensitivity.getRiskIdentifier();
    if (riskClass.equals(RiskClass.COMMODITY) || riskClass.equals(RiskClass.EQUITY) || riskClass.equals(RiskClass.FX)) {
      // curvature doesn't have HVR value so we set it to one
      BigDecimal hvr = BigDecimal.ONE;
      if (sensitivity.getSensitivityClass().equals(SensitivityClass.VEGA)) hvr = SimmHvr.get(riskClass, config.holdingPeriod());
      // need to get delta risk weight
      BigDecimal riskWeight = SimmRiskWeight.getForVolWeight(sensitivity, config);
      return hvr.multiply(riskWeight).multiply(getVolFactor(config.holdingPeriod()));
    } else {
      // Credit, IR should already be vol-weighted so weighting is one
      return BigDecimal.ONE;
    }
  }

  // method is only called on vega and curvature sensitivities
  public static List<Sensitivity> volWeightSensitivities(List<Sensitivity> sensitivities, SimmConfig config) {
    return sensitivities.stream()
      .map(sensitivity -> {
        BigDecimal volWeight = getVolatilityWeight(sensitivity, config);
        BigDecimal amountUsd = sensitivity.getAmountUsd(config.fxRate());
        return Sensitivity.fromIdentifier(sensitivity, volWeight.multiply(amountUsd));
      }).collect(Collectors.toList());
  }

}
