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

package com.acadiasoft.im.schedule.models.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author alec.stewart
 */
public enum ScheduleRiskType implements Serializable {

  NOTIONAL("Notional"),
  PV("PV");

  public static final String SCHEDULE_NOTIONAL = "Notional";
  public static final String SCHEDULE_PV = "PV";

  private final String riskType;

  private ScheduleRiskType(String riskType) {
    this.riskType = riskType;
  }

  public String getRiskType() {
    return riskType;
  }

  public static boolean isScheduleRiskType(String type) {
    return Arrays.stream(values()).anyMatch(v -> type.equalsIgnoreCase(v.riskType));
  }

  public static ScheduleRiskType determineByRiskType(String type) {
    if (StringUtils.equalsIgnoreCase(type, NOTIONAL.getRiskType())) {
      return NOTIONAL;
    } else if (StringUtils.equalsIgnoreCase(type, PV.getRiskType())) {
      return PV;
    }

    throw new RuntimeException("Unknown Schedule Risk Type: [" + type + "]!");
  }

}
