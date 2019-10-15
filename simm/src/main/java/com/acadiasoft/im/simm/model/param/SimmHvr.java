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

package com.acadiasoft.im.simm.model.param;

import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;

import java.math.BigDecimal;

public interface SimmHvr {

  BigDecimal CM_HVR = new BigDecimal("0.78");
  BigDecimal EQ_HVR = new BigDecimal("0.61");
  BigDecimal FX_HVR = new BigDecimal("0.65");
  BigDecimal IR_HVR = new BigDecimal("0.53");

  public static BigDecimal get(RiskClass riskClass) {
    if (riskClass.equals(RiskClass.COMMODITY)) {
      return CM_HVR;
    } else if (riskClass.equals(RiskClass.EQUITY)) {
      return EQ_HVR;
    } else if (riskClass.equals(RiskClass.FX)) {
      return FX_HVR;
    } else if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      return IR_HVR;
    } else {
      throw new RuntimeException("tried to get HVR for non-HVR risk class: [" + riskClass + "]!");
    }
  }

}
