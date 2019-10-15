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

package com.acadiasoft.im.base.imtree.identifiers;

import org.apache.commons.lang3.StringUtils;

public enum ImModelClass implements MarginIdentifier {

  SIMM("SIMM-P"),
  SCHEDULE("Schedule");

  private final static String SIMM1 = "SIMM-P";
  private final static String SIMM2 = "SIMM";
  private final static String SCHEDULE1 = "Schedule";

  private final String name;

  private ImModelClass(String name) {
    this.name = name;
  }

  @Override
  public String getLabel() {
    return name;
  }

  public static ImModelClass determineModelClass(String model) {
    if (StringUtils.equalsIgnoreCase(model, SIMM1) || StringUtils.equalsIgnoreCase(model, SIMM2)) {
      return SIMM;
    } else if (StringUtils.equalsIgnoreCase(SCHEDULE1, model)) {
      return SCHEDULE;
    }

    throw new IllegalStateException("Found unknown model string: [" + model + "]!");
  }

}
