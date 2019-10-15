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

package com.acadiasoft.im.simm.model.imtree.identifiers;

import com.acadiasoft.im.base.imtree.identifiers.MarginIdentifier;
import org.apache.commons.lang3.StringUtils;

public enum SensitivityClass implements MarginIdentifier {

  DELTA("Delta"),
  VEGA("Vega"),
  CURVATURE("Curvature"),
  BASECORR("BaseCorr"); // Base Correlation

  private final String label;
  public static final String VEGA_SUFFIX = "Vol";

  private SensitivityClass(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return label;
  }

  public static SensitivityClass determineByRiskType(String riskType) {
    if (StringUtils.containsIgnoreCase(riskType, VEGA_SUFFIX)) {
      return VEGA;
    } else if (StringUtils.equalsIgnoreCase(riskType, RiskClass.RISK_TYPE_BASE_CORR)) {
      return BASECORR;
    } else {
      return DELTA;
    }
  }

  public static SensitivityClass getByLabel(String label) {
    for (SensitivityClass s: values()) {
      if (label.equalsIgnoreCase(s.getLabel())) {
        return s;
      }
    }

    throw new IllegalStateException("tried to get sensitivity class label that doesn't exist: [" + label + "]!");
  }

}
