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

package com.acadiasoft.im.schedule.models;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.base.model.amount.CurrencyAmount;
import com.acadiasoft.im.schedule.models.utils.ScheduleRiskType;

import java.math.BigDecimal;

public interface ScheduleNotional extends ScheduleIdentifier, CurrencyAmount {

  static ScheduleSensitivity of(ScheduleNotional notional) {
    return new DefaultScheduleSensitivity(notional.getTradeId(), notional.getProductClass(),
      ScheduleRiskType.SCHEDULE_NOTIONAL, notional.getValuationDateAsString(), notional.getEndDateAsString(),
      notional.getAmountAsString(), notional.getAmountCurrency(), notional.getAmountUsdAsString());
  }

  String BAD_CALL = "Risk type was not 'Notional' as it was expected to be: [%s]";

  default boolean isScheduleNotional() {
    return ScheduleRiskType.SCHEDULE_NOTIONAL.equalsIgnoreCase(getRiskType());
  }

  default BigDecimal getNotional() {
    if (getScheduleRiskIdentifier().equals(ScheduleRiskType.NOTIONAL)) {
      return getAmount();
    } else {
      throw new IllegalStateException(String.format(BAD_CALL, getRiskType()));
    }
  }

  default String getNotionalCurrency() {
    if (getScheduleRiskIdentifier().equals(ScheduleRiskType.NOTIONAL)) {
      return getAmountCurrency();
    } else {
      throw new IllegalStateException(String.format(BAD_CALL, getRiskType()));
    }
  }

  default BigDecimal getNotionalInUsd(FxRate fx) {
    if (getScheduleRiskIdentifier().equals(ScheduleRiskType.NOTIONAL)) {
      return getAmountUsd(fx);
    } else {
      throw new IllegalStateException(String.format(BAD_CALL, getRiskType()));
    }
  }
}
