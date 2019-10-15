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

package com.acadiasoft.im.schedule.models.imtree.identifiers;


import com.acadiasoft.im.base.imtree.identifiers.MarginIdentifier;

public enum ScheduleProductClass implements MarginIdentifier {

  FX("FX"),
  RATES("Rates"),
  CREDIT("Credit"),
  COMMODITY("Commodity"),
  EQUITY("Equity"),
  OTHER("Other");

  private final String productClass;

  ScheduleProductClass(String productClass) {
    this.productClass = productClass;
  }

  public static ScheduleProductClass determineProductClass(String productClass) {
    if (productClass.equalsIgnoreCase(FX.productClass)) {
      return FX;
    } else if (productClass.equalsIgnoreCase(RATES.productClass)) {
      return RATES;
    } else if (productClass.equalsIgnoreCase(COMMODITY.productClass)) {
      return COMMODITY;
    } else if (productClass.equalsIgnoreCase(CREDIT.productClass)) {
      return CREDIT;
    } else if (productClass.equalsIgnoreCase(EQUITY.productClass)) {
      return EQUITY;
    } else {
      return OTHER;
    }
  }

  @Override
  public String getLabel() {
    return productClass;
  }

}
