/*
 * Copyright (c) 2022 Acadia, Inc.
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
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;

import java.math.BigDecimal;

public interface SimmHvr {

  BigDecimal CM_HVR_ONE_DAY = new BigDecimal("0.69");
  BigDecimal EQ_HVR_ONE_DAY = new BigDecimal("0.54");
  BigDecimal FX_HVR_ONE_DAY = new BigDecimal("0.7");
  BigDecimal IR_HVR_ONE_DAY = new BigDecimal("0.51");

  BigDecimal CM_HVR = new BigDecimal("0.69");
  BigDecimal EQ_HVR = new BigDecimal("0.58");
  BigDecimal FX_HVR = new BigDecimal("0.52");
  BigDecimal IR_HVR = new BigDecimal("0.44");

  String BAD_RISK_CLASS = "tried to get HVR for non-HVR risk class: [%s]!";

  public static BigDecimal get(RiskClass riskClass, HoldingPeriod period) {
    if (period.equals(HoldingPeriod.TEN_DAY)) {
      if (riskClass.equals(RiskClass.COMMODITY)) {
        return CM_HVR;
      } else if (riskClass.equals(RiskClass.EQUITY)) {
        return EQ_HVR;
      } else if (riskClass.equals(RiskClass.FX)) {
        return FX_HVR;
      } else if (riskClass.equals(RiskClass.INTEREST_RATE)) {
        return IR_HVR;
      } else {
        throw new IllegalStateException(String.format(BAD_RISK_CLASS, riskClass));
      }
    } else {
      if (riskClass.equals(RiskClass.COMMODITY)) {
        return CM_HVR_ONE_DAY;
      } else if (riskClass.equals(RiskClass.EQUITY)) {
        return EQ_HVR_ONE_DAY;
      } else if (riskClass.equals(RiskClass.FX)) {
        return FX_HVR_ONE_DAY;
      } else if (riskClass.equals(RiskClass.INTEREST_RATE)) {
        return IR_HVR_ONE_DAY;
      } else {
        throw new IllegalStateException(String.format(BAD_RISK_CLASS, riskClass));
      }
    }
  }

}
