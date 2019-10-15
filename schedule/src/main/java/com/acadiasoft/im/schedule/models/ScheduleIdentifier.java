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

import com.acadiasoft.im.schedule.models.imtree.identifiers.ScheduleProductClass;

import java.time.LocalDate;

public class ScheduleIdentifier {

  private final String tradeId;
  private final ScheduleProductClass productClass;
  private final LocalDate valuationDate;
  private final LocalDate endDate;

  public ScheduleIdentifier(String tradeId, ScheduleProductClass productClass, LocalDate valuationDate, LocalDate endDate) {
    this.tradeId = tradeId;
    this.productClass = productClass;
    this.valuationDate = valuationDate;
    this.endDate = endDate;
  }

  public ScheduleIdentifier(String tradeId, String productClass, String valuationDate, String endDate) {
    this.tradeId = tradeId;
    this.productClass = ScheduleProductClass.determineProductClass(productClass);
    this.valuationDate = LocalDate.parse(valuationDate);
    this.endDate = LocalDate.parse(endDate);
  }

  public String getTradeId() {
    return tradeId;
  }

  public ScheduleProductClass getProductClass(){
    return productClass;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public LocalDate getValuationDate() {
    return valuationDate;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ScheduleIdentifier)) return false;
    ScheduleIdentifier otherId = (ScheduleIdentifier) other;
    return tradeId.equalsIgnoreCase(otherId.tradeId);
  }

  @Override
  public int hashCode() {
    return tradeId.hashCode() * 11;
  }

}
