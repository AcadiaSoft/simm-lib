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

package com.acadiasoft.im.simm.model.param.equity;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class EquityRiskFactorConfiguration {

  private static final String ENV_EQUITY_RISK_CONFIGURATION = "EQUITY_RISK_CONFIGURATION";

  /**
   * Standard approach defined as: the entire delta and can be put into the "Indexes, Funds, ETFs" Equity bucket
   */
  public static final String APPROACH_STANDARD = "standard";

  /**
   * Alternative approach defined as: if bilaterally agreed, the delta can be allocated back to individual equities
   */
  public static final String APPROACH_ALTERNATIVE = "alternative";
  private static final List<String> ALL_APPROACHES = Collections.unmodifiableList(Arrays.asList(APPROACH_STANDARD, APPROACH_ALTERNATIVE));

  public static final String APPROACH = getConfiguredApproach();

  private static String getConfiguredApproach() {
    String approach = System.getenv(ENV_EQUITY_RISK_CONFIGURATION);

    if (StringUtils.isBlank(approach)) {
      approach = System.getProperty(ENV_EQUITY_RISK_CONFIGURATION, APPROACH_STANDARD);
    }

    if (!ALL_APPROACHES.contains(approach)) {
      throw new RuntimeException("Cannot set approach to:[" + approach + "], must be one of:" + ALL_APPROACHES);
    }
    return approach;
  }

}
