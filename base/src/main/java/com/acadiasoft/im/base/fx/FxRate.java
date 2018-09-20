/*
 * Copyright (c) 2018 AcadiaSoft, Inc.
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

package com.acadiasoft.im.base.fx;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 *
 * @author alec.stewart
 */
public interface FxRate {

  String USD = "USD";

  /**
   *
   * @param from currency of amount
   * @param to currency to be change to
   * @return amount in to currency
   */
  BigDecimal getRate(String from, String to);

  /**
   *
   * @param from currency of amount
   * @param to currency to be change to
   * @param date the date that we are pulling fx rates from (yyyy-mm-dd)
   * @return amount in to currency
   */
  BigDecimal getRate(String from, String to, LocalDate date);

  /**
   *
   * @param from currency of amount
   * @param to currency to be change to
   * @param timestamp the time and date of the fx rate we are pulling (yyyy-MM-dd T hh:mm:ss)
   * @return amount in to currency
   */
  BigDecimal getRate(String from, String to, ZonedDateTime timestamp);

}
