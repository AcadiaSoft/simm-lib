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

package com.acadiasoft.im.simm.model.imtree.identifiers;

import com.acadiasoft.im.base.model.imtree.identifiers.BatchClass;
import org.apache.commons.lang3.StringUtils;

public class SensitivityClass extends BatchClass {

  public static final SensitivityClass DELTA = new SensitivityClass("Delta");
  public static final SensitivityClass VEGA = new SensitivityClass("Vega");
  public static final SensitivityClass CURVATURE = new SensitivityClass("Curvature");
  public static final SensitivityClass BASECORR = new SensitivityClass("BaseCorr"); // Base Correlation

  public static final String VEGA_SUFFIX = "Vol";
  private static final String BAD_RISK_TYPE = "Unknown risk type specified: [%s]";

  private SensitivityClass(String label) {
    super(label);
  }

  public static SensitivityClass determineByRiskType(String riskType) {
    if (AddOnSubType.isAddOnSubType(riskType)) {
      return null; // add on sensitivities do not have a sensitivity type
    } else if (StringUtils.containsIgnoreCase(riskType, VEGA_SUFFIX)) {
      return VEGA;
    } else if (StringUtils.equalsIgnoreCase(riskType, RiskClass.RISK_TYPE_BASE_CORR)) {
      return BASECORR;
    } else if (RiskClass.isSimmRiskType(riskType)) {
      return DELTA;
    } else {
      throw new IllegalStateException(String.format(BAD_RISK_TYPE, riskType));
    }
  }

}
