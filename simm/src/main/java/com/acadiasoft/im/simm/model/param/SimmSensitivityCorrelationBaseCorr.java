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

package com.acadiasoft.im.simm.model.param;

import com.acadiasoft.im.simm.config.HoldingPeriod;
import com.acadiasoft.im.simm.config.SimmConfig;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.cq.BaseCorrRisk;
import com.acadiasoft.im.simm.model.param.cq.BaseCorrRisk1d;

import java.math.BigDecimal;

public interface SimmSensitivityCorrelationBaseCorr {

  public static BigDecimal get(RiskClass riskClass, WeightingClass r, WeightingClass s, SimmConfig config) {
    if (config.holdingPeriod().equals(HoldingPeriod.TEN_DAY)) {
      return new BaseCorrRisk().getSensitivityCorrelation(r, s);
    } else {
      return new BaseCorrRisk1d().getSensitivityCorrelation(r, s);
    }
  }

  public BigDecimal getSensitivityCorrelation(WeightingClass r, WeightingClass s);

}
