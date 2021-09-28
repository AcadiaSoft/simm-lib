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

import com.acadiasoft.im.schedule.models.imtree.identifiers.ScheduleProductClass;
import com.acadiasoft.im.schedule.models.utils.ScheduleRiskType;

import java.time.LocalDate;

public interface ScheduleIdentifier {

  // -------------------- interface methods -----------------------

  String getTradeId();

  String getProductClass();

  String getRiskType();

  String getValuationDateAsString();

  String getEndDateAsString();

  // -------------------- default util methods --------------------

  default LocalDate getValuationDate() {
    return LocalDate.parse(getValuationDateAsString());
  }

  default LocalDate getEndDate() {
    return LocalDate.parse(getEndDateAsString());
  }

  default ScheduleProductClass getScheduleProductClass() {
    return ScheduleProductClass.determineProductClass(getProductClass());
  }

  default ScheduleRiskType getScheduleRiskIdentifier() {
    return ScheduleRiskType.determineByRiskType(getRiskType());
  }

  default ScheduleIdentifier getScheduleTradeIdentifier() {
    return new DefaultScheduleIdentifier(this.getTradeId(), this.getProductClass(), this.getRiskType(),
      this.getValuationDateAsString(), this.getEndDateAsString());
  }

  // --------------------- default check methods -------------------

  String MISSING_FORMAT = "The %s for this schedule sensitivity was missing (i.e. null or empty)";
  String TRADE_ID_MISSING = String.format(MISSING_FORMAT, "tradeId");
  String PRODUCT_MISSING = String.format(MISSING_FORMAT, "productClass");
  String VAL_DATE_MISSING = String.format(MISSING_FORMAT, "valuationDate");
  String END_DATE_MISSING = String.format(MISSING_FORMAT, "endDate");

  default void checkScheduleIdentifier(String tradeId, String productClass, String riskType, String valuationDate, String endDate) {
    if (tradeId == null || tradeId.isEmpty()) {
      throw new IllegalStateException(TRADE_ID_MISSING);
    } else if (productClass == null || productClass.isEmpty()) {
      throw new IllegalStateException(PRODUCT_MISSING);
    } else if (valuationDate == null || valuationDate.isEmpty()) {
      throw new IllegalStateException(VAL_DATE_MISSING);
    } else if (endDate == null || endDate.isEmpty()) {
      throw new IllegalStateException(END_DATE_MISSING);
    }
  }

}
