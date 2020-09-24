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

import java.math.BigDecimal;

public class DefaultScheduleSensitivity extends DefaultScheduleIdentifier implements ScheduleSensitivity {

  private final String tradeNotional;
  private final String tradeCurrency;
  private final String amount;
  private final String amountCurrency;
  private final String amountUsd;

  public DefaultScheduleSensitivity(ScheduleIdentifier identifier, BigDecimal amountUsd) {
    super(identifier, identifier.getRiskType());
    this.amount = amountUsd.toPlainString();
    this.amountCurrency = FxRate.USD;
    this.amountUsd = amountUsd.toPlainString();
    this.tradeNotional = null;
    this.tradeCurrency = null;
  }

  public DefaultScheduleSensitivity(ScheduleIdentifier identifier, String tradeNotional, String tradeCurrency, BigDecimal amountUsd) {
    super(identifier, identifier.getRiskType());
    this.amount = amountUsd.toPlainString();
    this.amountCurrency = FxRate.USD;
    this.amountUsd = amountUsd.toPlainString();
    this.tradeNotional = tradeNotional;
    this.tradeCurrency = tradeCurrency;
  }

  public DefaultScheduleSensitivity(String tradeId, String productClass, String riskType, String valuationDate, String endDate,
                                    String amount, String amountCurrency, String amountUsd) {
    // set up the identifier and check to make sure values are valid
    super(tradeId, productClass, riskType, valuationDate, endDate);
    checkScheduleIdentifier(tradeId, productClass, riskType, valuationDate, endDate);

    // set the currency amount
    checkCurrencyAmount(amount, amountCurrency);
    this.amount = amount;
    this.amountCurrency = amountCurrency;
    this.amountUsd = amountUsd;
    this.tradeNotional = null;
    this.tradeCurrency = null;
  }

  public DefaultScheduleSensitivity(String tradeId, String tradeNotional, String tradeCurrency, String productClass, String riskType,
                                    String valuationDate, String endDate, String amount, String amountCurrency, String amountUsd) {
    // set up the identifier and check to make sure values are valid
    super(tradeId, productClass, riskType, valuationDate, endDate);
    checkScheduleIdentifier(tradeId, productClass, riskType, valuationDate, endDate);

    // set the currency amount
    checkCurrencyAmount(amount, amountCurrency);
    this.amount = amount;
    this.amountCurrency = amountCurrency;
    this.amountUsd = amountUsd;
    this.tradeNotional = tradeNotional;
    this.tradeCurrency = tradeCurrency;
  }

  @Override
  public String getTradeNotionalAsString() {
    return tradeNotional;
  }

  @Override
  public String getTradeCurrency() {
    return tradeCurrency;
  }

  @Override
  public String getAmountAsString() {
    return amount;
  }

  @Override
  public String getAmountCurrency() {
    return amountCurrency;
  }

  @Override
  public String getAmountUsdAsString() {
    return amountUsd;
  }

}
