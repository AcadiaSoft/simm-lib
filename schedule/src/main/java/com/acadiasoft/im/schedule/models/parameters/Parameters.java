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

package com.acadiasoft.im.schedule.models.parameters;

import com.acadiasoft.im.schedule.models.imtree.identifiers.ScheduleProductClass;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author alec.stewart
 */
public class Parameters implements ScheduleParameters {

  private static final long TWO_YEARS = 2;
  private static final long FIVE_YEARS = 5;
  private static final BigDecimal CREDIT_UNDER_2_YEARS = new BigDecimal(".02");
  private static final BigDecimal CREDIT_2_TO_5_YEARS = new BigDecimal(".05");
  private static final BigDecimal CREDIT_OVER_5_YEARS = new BigDecimal(".10");
  private static final BigDecimal COMMODITY = new BigDecimal(".15");
  private static final BigDecimal EQUITY = new BigDecimal(".15");
  private static final BigDecimal FX = new BigDecimal(".06");
  private static final BigDecimal RATES_UNDER_2_YEARS = new BigDecimal(".01");
  private static final BigDecimal RATES_2_TO_5_YEARS = new BigDecimal(".02");
  private static final BigDecimal RATES_OVER_5_YEARS = new BigDecimal(".04");
  private static final BigDecimal OTHER = new BigDecimal(".15");

  @Override
  public BigDecimal getParameter(ScheduleProductClass productClass, LocalDate val, LocalDate end) {
    if (productClass.equals(ScheduleProductClass.RATES)) {
      if (end.minusYears(TWO_YEARS).isBefore(val) || end.minusYears(TWO_YEARS).isEqual(val)) {
        return RATES_UNDER_2_YEARS;
      } else if (end.minusYears(FIVE_YEARS).isBefore(val) || end.minusYears(FIVE_YEARS).isEqual(val)) {
        return RATES_2_TO_5_YEARS;
      } else {
        return RATES_OVER_5_YEARS;
      }
    } else if (productClass.equals(ScheduleProductClass.CREDIT)) {
      if (end.minusYears(TWO_YEARS).isBefore(val) || end.minusYears(TWO_YEARS).isEqual(val)) {
        return CREDIT_UNDER_2_YEARS;
      } else if (end.minusYears(FIVE_YEARS).isBefore(val) || end.minusYears(FIVE_YEARS).isEqual(val)) {
        return CREDIT_2_TO_5_YEARS;
      } else {
        return CREDIT_OVER_5_YEARS;
      }
    } else if (productClass.equals(ScheduleProductClass.FX)) {
      return FX;
    } else if (productClass.equals(ScheduleProductClass.EQUITY)) {
      return EQUITY;
    } else if (productClass.equals(ScheduleProductClass.COMMODITY)) {
      return COMMODITY;
    } else if (productClass.equals(ScheduleProductClass.OTHER)) {
      return OTHER;
    } else {
      // Should never get here
      return null;
    }
  }

}
