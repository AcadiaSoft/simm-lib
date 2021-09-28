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

import java.math.BigDecimal;

public interface ScheduleSensitivity extends ScheduleNotional, SchedulePv {

  static ScheduleSensitivity of(String tradeId, String notional, String notionalCurrency, String productClass, String riskType,
                                String valuationDate, String endDate, String amount, String amountCurrency, String amountUsd) {
    return new DefaultScheduleSensitivity(tradeId, notional, notionalCurrency, productClass, riskType,
      valuationDate, endDate, amount, amountCurrency, amountUsd);
  }

  static ScheduleSensitivity of(String tradeId, String productClass, String riskType, String valuationDate, String endDate,
                                 String amount, String amountCurrency, String amountUsd) {
    return new DefaultScheduleSensitivity(tradeId, productClass, riskType, valuationDate, endDate, amount, amountCurrency, amountUsd);
  }

  static ScheduleSensitivity of(ScheduleIdentifier identifier, BigDecimal amountUsd) {
    return new DefaultScheduleSensitivity(identifier, amountUsd);
  }

  String getTradeNotionalAsString();

  String getTradeCurrency();

  String TRADE_NOTIONAL_NOT_PRESENT = "The 'tradeNotional' is missing when it was expected to be present";
  String TRADE_CURRENCY_NOT_PRESENT = "The 'tradeCurrency' is missing when it was expected to be present";

  default BigDecimal getTradeNotional() {
    String notional = getTradeNotionalAsString();
    if (notional == null || notional.isEmpty()) {
      throw new IllegalStateException(TRADE_NOTIONAL_NOT_PRESENT);
    } else {
      return new BigDecimal(notional).stripTrailingZeros();
    }
  }

  default BigDecimal getTradeNotionalInUsd(FxRate fx) {
    String currency = getTradeCurrency();
    if (currency == null || currency.length() != 3) {
      throw new IllegalStateException(TRADE_CURRENCY_NOT_PRESENT);
    } else {
      return fx.convert(getTradeNotional(), currency, FxRate.USD);
    }
  }

  default boolean tradeNotionalIsSet() {
    String notional = getTradeNotionalAsString();
    if (notional == null || notional.isEmpty()) {
      return false;
    } else {
      String currency = getTradeCurrency();
      return currency != null && currency.length() == 3;
    }
  }

}
