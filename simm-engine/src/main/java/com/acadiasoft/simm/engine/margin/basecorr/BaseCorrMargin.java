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

package com.acadiasoft.simm.engine.margin.basecorr;

import com.acadiasoft.simm.engine.margin.IMargin;
import com.acadiasoft.simm.engine.param.RiskCorrelation;
import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;
import com.acadiasoft.simm.util.SensitivityUtils;
import com.acadiasoft.simm.util.WeightedSensitivityUtils;
import com.acadiasoft.util.BigDecimalUtils;

import java.math.BigDecimal;
import java.util.List;

public class BaseCorrMargin implements IMargin {

  @Override
  public BigDecimal calculate(RiskClass rc, List<Sensitivity> allSensitivities) {
    // NOTE: basecorr is only on the credit qualifying risk class, so we don't need riskClass as input
    List<Sensitivity> baseCorrSensitivities = BaseCorrSensitivityUtil.filterForBaseCorrSensitivitiesOnly(allSensitivities);
    List<Sensitivity> nettedSensitivities = SensitivityUtils.netSensitivitiesByRiskFactor(rc, baseCorrSensitivities);
    List<WeightedSensitivity> weightedSensitivities = BaseCorrWeightUtil.weightSensitivities(nettedSensitivities);

    BigDecimal sumSquared = WeightedSensitivityUtils.sumSquared(weightedSensitivities);
    BigDecimal crossCorrSum = calculateCrossCorr(weightedSensitivities);
    BigDecimal totalSum = sumSquared.add(crossCorrSum);
    return BigDecimalUtils.sqrt(totalSum);
  }

  private static BigDecimal calculateCrossCorr(List<WeightedSensitivity> weightedSensitivities) {
    BigDecimal sum = BigDecimal.ZERO;

    for (WeightedSensitivity k : weightedSensitivities) {
      for (WeightedSensitivity l : weightedSensitivities) {
        if (!k.equals(l)) {
          BigDecimal correlation = getCorrelation(k.getSensitivity(), l.getSensitivity());
          BigDecimal value = correlation.multiply(k.getWeightedValue()).multiply(l.getWeightedValue());
          sum = sum.add(value);
        }
      }
    }

    return sum;
  }

  private static BigDecimal getCorrelation(Sensitivity k, Sensitivity l) {
    return RiskCorrelation.getBaseCorrSensitvityCorrelation(RiskClass.CREDIT_QUALIFYING, k, l);
  }

}
