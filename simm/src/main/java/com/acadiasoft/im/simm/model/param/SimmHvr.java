/*
 * Copyright (c) 2018 AcadiaSoft, Inc.
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

import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;

import java.math.BigDecimal;

public interface SimmHvr {

  BigDecimal CM_HVR = new BigDecimal("0.74");
  BigDecimal EQ_HVR = new BigDecimal("0.59");
  BigDecimal FX_HVR = new BigDecimal("0.63");
  BigDecimal IR_HVR = new BigDecimal("0.62");

  BigDecimal CM_HVR_1D = new BigDecimal("0.71");
  BigDecimal EQ_HVR_1D = new BigDecimal("0.54");
  BigDecimal FX_HVR_1D = new BigDecimal("0.81");
  BigDecimal IR_HVR_1D = new BigDecimal("0.67");

  public static BigDecimal get(RiskClass riskClass, HoldingPeriod holdingPeriod) {
    if (riskClass.equals(RiskClass.COMMODITY)) {
      return holdingPeriod == HoldingPeriod.TenDay ? CM_HVR : CM_HVR_1D;
    } else if (riskClass.equals(RiskClass.EQUITY)) {
      return holdingPeriod == HoldingPeriod.TenDay ? EQ_HVR : EQ_HVR_1D;
    } else if (riskClass.equals(RiskClass.FX)) {
      return holdingPeriod == HoldingPeriod.TenDay ? FX_HVR : FX_HVR_1D;
    } else if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      return holdingPeriod == HoldingPeriod.TenDay ? IR_HVR : IR_HVR_1D;
    } else {
      throw new RuntimeException("tried to get HVR for non-HVR risk class: [" + riskClass + "]!");
    }
  }

}
