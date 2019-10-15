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

package com.acadiasoft.im.schedule.models;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.schedule.models.imtree.identifiers.ScheduleProductClass;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author alec.stewart
 */
public class SchedulePv extends ScheduleIdentifier implements Serializable {

  private final BigDecimal amount;
  private final String amountCurrency;
  private final BigDecimal amountUSD;

  /**
   *
   * @param productClass product class: Rates, FX, Credit, Commodity, Equit, Other
   * @param valuationDate date formatted by ISO8601: yyyy-mm-dd
   * @param endDate date formatted by ISO8601: yyyy-mm-dd
   * @param amount notional amount
   * @param amountCurrency currency of the trade (uses ISO currency code)
   */
  public SchedulePv(String tradeId, String productClass, String valuationDate, String endDate, String amount, String amountCurrency, String amountUSD) {
    super(tradeId, productClass, valuationDate, endDate);
    this.amount = new BigDecimal(amount).stripTrailingZeros();
    this.amountCurrency = amountCurrency;
    this.amountUSD = new BigDecimal(amountUSD).stripTrailingZeros();
  }

  public SchedulePv(String tradeId, String productClass, String valuationDate, String endDate, String amount) {
    super(tradeId, productClass, valuationDate, endDate);
    this.amount = new BigDecimal(amount).stripTrailingZeros();
    this.amountCurrency = FxRate.USD;
    this.amountUSD = new BigDecimal(amount).stripTrailingZeros();
  }

  public SchedulePv(String tradeId, ScheduleProductClass productClass, LocalDate valuationDate, LocalDate endDate, BigDecimal amount, String amountCurrency, BigDecimal amountUSD) {
    super(tradeId, productClass, valuationDate, endDate);
    this.amount = amount.stripTrailingZeros();
    this.amountCurrency = amountCurrency;
    this.amountUSD = amountUSD.stripTrailingZeros();
  }

  public SchedulePv(String tradeId, ScheduleProductClass productClass, LocalDate valuationDate, LocalDate endDate, BigDecimal amount) {
    super(tradeId, productClass, valuationDate, endDate);
    this.amount = amount.stripTrailingZeros();
    this.amountCurrency = FxRate.USD;
    this.amountUSD = amount.stripTrailingZeros();
  }

  public static SchedulePv make(ScheduleIdentifier id, BigDecimal amountUSD) {
    return new SchedulePv(id.getTradeId(), id.getProductClass(), id.getValuationDate(), id.getEndDate(), amountUSD);
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public String getAmountCurrency() {
    return amountCurrency;
  }

  public BigDecimal getAmountUSD() {
    return amountUSD;
  }

  public ScheduleIdentifier getIdentifier() {
    return new ScheduleIdentifier(getTradeId(), getProductClass(), getValuationDate(), getEndDate());
  }

}
