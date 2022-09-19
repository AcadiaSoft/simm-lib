/*
 * Copyright (c) 2022 Acadia, Inc.
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

package com.acadiasoft.im.simm.model.param.interestrate;

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmBucketCorrelation;
import com.acadiasoft.im.simm.model.param.SimmSensitivityCorrelation;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @author joe.peterson
 *
 */
public class InterestRateCorrelation1d implements SimmBucketCorrelation, SimmSensitivityCorrelation {

  public static final BigDecimal INFLATION = new BigDecimal("0.37");
  public static final BigDecimal XCCY = new BigDecimal("0.01");
  public static final BigDecimal SUB_CURVE_SAME_CCY = new BigDecimal("0.99");
  public static final BigDecimal AGGREGATE_DIFF_CURRENCIES = new BigDecimal("0.24");

  private static final BigDecimal[][] CORRELATIONS = {
      { // tenor 2W
          new BigDecimal("1"), // tenor 2W
          new BigDecimal("0.74"), // tenor 1M
          new BigDecimal("0.63"), // tenor 3M
          new BigDecimal("0.55"), // tenor 6M
          new BigDecimal("0.45"), // tenor 1Y
          new BigDecimal("0.36"), // tenor 2Y
          new BigDecimal("0.32"), // tenor 3Y
          new BigDecimal("0.28"), // tenor 5Y
          new BigDecimal("0.23"), // tenor 10Y
          new BigDecimal("0.2"), // tenor 15Y
          new BigDecimal("0.18"), // tenor 20Y
          new BigDecimal("0.16"), // tenor 30Y
      },
      { // tenor 1M
          new BigDecimal("0.74"), // tenor 2W
          new BigDecimal("1"), // tenor 1M
          new BigDecimal("0.8"), // tenor 3M
          new BigDecimal("0.69"), // tenor 6M
          new BigDecimal("0.52"), // tenor 1Y
          new BigDecimal("0.41"), // tenor 2Y
          new BigDecimal("0.35"), // tenor 3Y
          new BigDecimal("0.29"), // tenor 5Y
          new BigDecimal("0.24"), // tenor 10Y
          new BigDecimal("0.18"), // tenor 15Y
          new BigDecimal("0.17"), // tenor 20Y
          new BigDecimal("0.16"), // tenor 30Y
      },
      { // tenor 3M
          new BigDecimal("0.63"), // tenor 2W
          new BigDecimal("0.8"), // tenor 1M
          new BigDecimal("1"), // tenor 3M
          new BigDecimal("0.85"), // tenor 6M
          new BigDecimal("0.67"), // tenor 1Y
          new BigDecimal("0.53"), // tenor 2Y
          new BigDecimal("0.45"), // tenor 3Y
          new BigDecimal("0.39"), // tenor 5Y
          new BigDecimal("0.32"), // tenor 10Y
          new BigDecimal("0.24"), // tenor 15Y
          new BigDecimal("0.22"), // tenor 20Y
          new BigDecimal("0.22"), // tenor 30Y
      },
      { // tenor 6M
          new BigDecimal("0.55"), // tenor 2W
          new BigDecimal("0.69"), // tenor 1M
          new BigDecimal("0.85"), // tenor 3M
          new BigDecimal("1"), // tenor 6M
          new BigDecimal("0.83"), // tenor 1Y
          new BigDecimal("0.71"), // tenor 2Y
          new BigDecimal("0.62"), // tenor 3Y
          new BigDecimal("0.54"), // tenor 5Y
          new BigDecimal("0.45"), // tenor 10Y
          new BigDecimal("0.36"), // tenor 15Y
          new BigDecimal("0.35"), // tenor 20Y
          new BigDecimal("0.33"), // tenor 30Y
      },
      { // tenor 1Y
          new BigDecimal("0.45"), // tenor 2W
          new BigDecimal("0.52"), // tenor 1M
          new BigDecimal("0.67"), // tenor 3M
          new BigDecimal("0.83"), // tenor 6M
          new BigDecimal("1"), // tenor 1Y
          new BigDecimal("0.94"), // tenor 2Y
          new BigDecimal("0.86"), // tenor 3Y
          new BigDecimal("0.78"), // tenor 5Y
          new BigDecimal("0.65"), // tenor 10Y
          new BigDecimal("0.58"), // tenor 15Y
          new BigDecimal("0.55"), // tenor 20Y
          new BigDecimal("0.53"), // tenor 30Y
      },
      { // tenor 2Y
          new BigDecimal("0.36"), // tenor 2W
          new BigDecimal("0.41"), // tenor 1M
          new BigDecimal("0.53"), // tenor 3M
          new BigDecimal("0.71"), // tenor 6M
          new BigDecimal("0.94"), // tenor 1Y
          new BigDecimal("1"), // tenor 2Y
          new BigDecimal("0.95"), // tenor 3Y
          new BigDecimal("0.89"), // tenor 5Y
          new BigDecimal("0.78"), // tenor 10Y
          new BigDecimal("0.72"), // tenor 15Y
          new BigDecimal("0.68"), // tenor 20Y
          new BigDecimal("0.67"), // tenor 30Y
      },
      { // tenor 3Y
          new BigDecimal("0.32"), // tenor 2W
          new BigDecimal("0.35"), // tenor 1M
          new BigDecimal("0.45"), // tenor 3M
          new BigDecimal("0.62"), // tenor 6M
          new BigDecimal("0.86"), // tenor 1Y
          new BigDecimal("0.95"), // tenor 2Y
          new BigDecimal("1"), // tenor 3Y
          new BigDecimal("0.96"), // tenor 5Y
          new BigDecimal("0.87"), // tenor 10Y
          new BigDecimal("0.8"), // tenor 15Y
          new BigDecimal("0.77"), // tenor 20Y
          new BigDecimal("0.74"), // tenor 30Y
      },
      { // tenor 5Y
          new BigDecimal("0.28"), // tenor 2W
          new BigDecimal("0.29"), // tenor 1M
          new BigDecimal("0.39"), // tenor 3M
          new BigDecimal("0.54"), // tenor 6M
          new BigDecimal("0.78"), // tenor 1Y
          new BigDecimal("0.89"), // tenor 2Y
          new BigDecimal("0.96"), // tenor 3Y
          new BigDecimal("1"), // tenor 5Y
          new BigDecimal("0.94"), // tenor 10Y
          new BigDecimal("0.89"), // tenor 15Y
          new BigDecimal("0.86"), // tenor 20Y
          new BigDecimal("0.84"), // tenor 30Y
      },
      { // tenor 10Y
          new BigDecimal("0.23"), // tenor 2W
          new BigDecimal("0.24"), // tenor 1M
          new BigDecimal("0.32"), // tenor 3M
          new BigDecimal("0.45"), // tenor 6M
          new BigDecimal("0.65"), // tenor 1Y
          new BigDecimal("0.78"), // tenor 2Y
          new BigDecimal("0.87"), // tenor 3Y
          new BigDecimal("0.94"), // tenor 5Y
          new BigDecimal("1"), // tenor 10Y
          new BigDecimal("0.97"), // tenor 15Y
          new BigDecimal("0.95"), // tenor 20Y
          new BigDecimal("0.94"), // tenor 30Y
      },
      { // tenor 15Y
          new BigDecimal("0.2"), // tenor 2W
          new BigDecimal("0.18"), // tenor 1M
          new BigDecimal("0.24"), // tenor 3M
          new BigDecimal("0.36"), // tenor 6M
          new BigDecimal("0.58"), // tenor 1Y
          new BigDecimal("0.72"), // tenor 2Y
          new BigDecimal("0.8"), // tenor 3Y
          new BigDecimal("0.89"), // tenor 5Y
          new BigDecimal("0.97"), // tenor 10Y
          new BigDecimal("1"), // tenor 15Y
          new BigDecimal("0.98"), // tenor 20Y
          new BigDecimal("0.98"), // tenor 30Y
      },
      { // tenor 20Y
          new BigDecimal("0.18"), // tenor 2W
          new BigDecimal("0.17"), // tenor 1M
          new BigDecimal("0.22"), // tenor 3M
          new BigDecimal("0.35"), // tenor 6M
          new BigDecimal("0.55"), // tenor 1Y
          new BigDecimal("0.68"), // tenor 2Y
          new BigDecimal("0.77"), // tenor 3Y
          new BigDecimal("0.86"), // tenor 5Y
          new BigDecimal("0.95"), // tenor 10Y
          new BigDecimal("0.98"), // tenor 15Y
          new BigDecimal("1"), // tenor 20Y
          new BigDecimal("0.99"), // tenor 30Y
      },
      { // tenor 30Y
          new BigDecimal("0.16"), // tenor 2W
          new BigDecimal("0.16"), // tenor 1M
          new BigDecimal("0.22"), // tenor 3M
          new BigDecimal("0.33"), // tenor 6M
          new BigDecimal("0.53"), // tenor 1Y
          new BigDecimal("0.67"), // tenor 2Y
          new BigDecimal("0.74"), // tenor 3Y
          new BigDecimal("0.84"), // tenor 5Y
          new BigDecimal("0.94"), // tenor 10Y
          new BigDecimal("0.98"), // tenor 15Y
          new BigDecimal("0.99"), // tenor 20Y
          new BigDecimal("1"), // tenor 30Y
      } }; // tenor 30y

  @Override
  public BigDecimal getSensitivityCorrelation(WeightingClass si, WeightingClass sk) {
    int indexOf = InterestRateTenor.indexOf(si.getLabel1());
    int indexOf2 = InterestRateTenor.indexOf(sk.getLabel1());
    // NOTE: when we see a XCcy to Inflation correlation, we should use the XCcy correlation parameter, as such we put the XCcy option first
    //	so that it has precedence over Inflation (might need more complex logic in the future)
    if (si.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_XCCY_BASIS) || sk.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_XCCY_BASIS)) {
      return XCCY;
    } else if (si.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_INFLATION) || sk.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_INFLATION)
        || si.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_INFLATION_VOL) || sk.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_INFLATION_VOL)) {
      return INFLATION;
    } else {
      BigDecimal correlation = CORRELATIONS[indexOf][indexOf2];
      if (!StringUtils.equalsIgnoreCase(si.getLabel2(), sk.getLabel2())) {
        return correlation.multiply(SUB_CURVE_SAME_CCY);
      } else {
        return correlation;
      }
    }
  }

  @Override
  public BigDecimal getBucketCorrelation(BucketClass bi, BucketClass bk) {
    return AGGREGATE_DIFF_CURRENCIES;
  }

}
