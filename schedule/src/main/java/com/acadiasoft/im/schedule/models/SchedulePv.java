/*
 * Copyright (c) 2020 AcadiaSoft, Inc.
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

package com.acadiasoft.im.schedule.models;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.base.model.amount.CurrencyAmount;
import com.acadiasoft.im.schedule.models.utils.ScheduleRiskType;

import java.math.BigDecimal;

public interface SchedulePv extends ScheduleIdentifier, CurrencyAmount {

  static ScheduleSensitivity of(SchedulePv pv) {
    return new DefaultScheduleSensitivity(pv.getTradeId(), pv.getProductClass(),
      ScheduleRiskType.SCHEDULE_PV, pv.getValuationDateAsString(), pv.getEndDateAsString(),
      pv.getAmountAsString(), pv.getAmountCurrency(), pv.getAmountUsdAsString());
  }

  String BAD_CALL = "Risk type was not 'PV' as it was expected to be: [%s]";

  default boolean isSchedulePv() {
    return ScheduleRiskType.SCHEDULE_PV.equalsIgnoreCase(getRiskType());
  }

  default BigDecimal getPresentValue() {
    if (getScheduleRiskIdentifier().equals(ScheduleRiskType.PV)) {
      return getAmount();
    } else {
      throw new IllegalStateException(String.format(BAD_CALL, getRiskType()));
    }
  }

  default String getPresentValueCurrency() {
    if (getScheduleRiskIdentifier().equals(ScheduleRiskType.PV)) {
      return getAmountCurrency();
    } else {
      throw new IllegalStateException(String.format(BAD_CALL, getRiskType()));
    }
  }

  default BigDecimal getPresentValueInUsd(FxRate fx) {
    if (getScheduleRiskIdentifier().equals(ScheduleRiskType.PV)) {
      return getAmountUsd(fx);
    } else {
      throw new IllegalStateException(String.format(BAD_CALL, getRiskType()));
    }
  }
}
