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

package com.acadiasoft.im.schedule.models.imtree.identifiers;

import com.acadiasoft.im.base.model.imtree.identifiers.SiloClass;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class ScheduleProductClass extends SiloClass {

  public static final ScheduleProductClass FX = new ScheduleProductClass("FX");
  public static final ScheduleProductClass RATES = new ScheduleProductClass("Rates");
  public static final ScheduleProductClass CREDIT = new ScheduleProductClass("Credit");
  public static final ScheduleProductClass COMMODITY = new ScheduleProductClass("Commodity");
  public static final ScheduleProductClass EQUITY = new ScheduleProductClass("Equity");
  public static final ScheduleProductClass OTHER = new ScheduleProductClass("Other");

  private static final String UNKNOWN = "Tried to get a product for an unknown label: [%s]";
  private static final Supplier<Stream<ScheduleProductClass>> ALL = () -> Stream.of(
    FX, RATES, CREDIT, COMMODITY, EQUITY, OTHER
  );

  private ScheduleProductClass(String label) {
    super(label);
  }

  public static ScheduleProductClass determineProductClass(String productClass) {
    return ALL.get().filter(product -> product.label.equalsIgnoreCase(productClass)).findAny()
      .orElseThrow(() -> new IllegalStateException(String.format(UNKNOWN, productClass)));
  }

}
