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

package com.acadiasoft.im.simm.model.param.interestrate;

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmBucketCorrelation;
import com.acadiasoft.im.simm.model.param.SimmSensitivityCorrelation;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * As defined in Appendix 1 section D.2 of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class InterestRateCorrelation implements SimmBucketCorrelation, SimmSensitivityCorrelation {

  public static final BigDecimal INFLATION = new BigDecimal("0.42");
  public static final BigDecimal XCCY = new BigDecimal("0.04");
  public static final BigDecimal SUB_CURVE_SAME_CCY = new BigDecimal("0.986");
  public static final BigDecimal AGGREGATE_DIFF_CURRENCIES = new BigDecimal("0.2");

  private static final BigDecimal[][] CORRELATIONS = {
    { // tenor 2w
      new BigDecimal("1"), // tenor 2w
      new BigDecimal("0.73"), // tenor 1m
      new BigDecimal("0.64"), // tenor 3m
      new BigDecimal("0.57"), // tenor 6m
      new BigDecimal("0.44"), // tenor 1y
      new BigDecimal("0.34"), // tenor 2y
      new BigDecimal("0.29"), // tenor 3y
      new BigDecimal("0.24"), // tenor 5y
      new BigDecimal("0.18"), // tenor 10y
      new BigDecimal("0.13"), // tenor 15y
      new BigDecimal("0.11"), // tenor 20y
      new BigDecimal("0.09")}, // tenor 30y
    { // tenor 1m
      new BigDecimal("0.73"), // tenor 2w
      new BigDecimal("1"), // tenor 1m
      new BigDecimal("0.78"), // tenor 3m
      new BigDecimal("0.67"), // tenor 6m
      new BigDecimal("0.5"), // tenor 1y
      new BigDecimal("0.37"), // tenor 2y
      new BigDecimal("0.3"), // tenor 3y
      new BigDecimal("0.24"), // tenor 5y
      new BigDecimal("0.18"), // tenor 10y
      new BigDecimal("0.13"), // tenor 15y
      new BigDecimal("0.11"), // tenor 20y
      new BigDecimal("0.1")}, // tenor 20y
    { // tenor 3m
      new BigDecimal("0.64"), // tenor 2w
      new BigDecimal("0.78"), // tenor 1m
      new BigDecimal("1"), // tenor 3m
      new BigDecimal("0.85"), // tenor6m
      new BigDecimal("0.66"), // tenor 1y
      new BigDecimal("0.52"), // tenor 2y
      new BigDecimal("0.43"), // tenor 3y
      new BigDecimal("0.35"), // tenor 5y
      new BigDecimal("0.27"), // tenor 10y
      new BigDecimal("0.2"), // tenor 15y
      new BigDecimal("0.17"), // tenor 20y
      new BigDecimal("0.17")}, // tenor 30y
    { // tenor 6m
      new BigDecimal("0.57"), // tenor 2w
      new BigDecimal("0.67"), // tenor 1m
      new BigDecimal("0.85"), // tenor 3m
      new BigDecimal("1"), // tenor 6m
      new BigDecimal("0.81"), // tenor 1y
      new BigDecimal("0.68"), // tenor 2y
      new BigDecimal("0.59"), // tenor 3y
      new BigDecimal("0.5"), // tenor 5y
      new BigDecimal("0.41"), // tenor 10y
      new BigDecimal("0.35"), // tenor 15y
      new BigDecimal("0.33"), // tenor 20y
      new BigDecimal("0.31")}, // tenor 30y
    { // tenor 1y
      new BigDecimal("0.44"), // tenor 2w
      new BigDecimal("0.5"), // tenor 1m
      new BigDecimal("0.66"), // tenor 3m
      new BigDecimal("0.81"), // tenor 6m
      new BigDecimal("1"), // tenor 1y
      new BigDecimal("0.94"), // tenor 2y
      new BigDecimal("0.85"), // tenor 3y
      new BigDecimal("0.76"), // tenor 5y
      new BigDecimal("0.65"), // tenor 10y
      new BigDecimal("0.59"), // tenor 15y
      new BigDecimal("0.56"), // tenor 20y
      new BigDecimal("0.54")}, // tenor 30y
    { // tenor 2y
      new BigDecimal("0.34"), // tenor 2w
      new BigDecimal("0.37"), // tenor 1m
      new BigDecimal("0.52"), // tenor 3m
      new BigDecimal("0.68"), // tenor 6m
      new BigDecimal("0.94"), // tenor 1y
      new BigDecimal("1"), // tenor 2y
      new BigDecimal("0.95"), // tenor 3y
      new BigDecimal("0.89"), // tenor 5y
      new BigDecimal("0.79"), // tenor 10y
      new BigDecimal("0.75"), // tenor 15y
      new BigDecimal("0.72"), // tenor 20y
      new BigDecimal("0.7")}, // tenor 30y
    { // tenor 3y
      new BigDecimal("0.29"), // tenor 2w
      new BigDecimal("0.3"), // tenor 1m
      new BigDecimal("0.43"), // tenor 3m
      new BigDecimal("0.59"), // tenor 6m
      new BigDecimal("0.85"), // tenor 1y
      new BigDecimal("0.95"), // tenor 2y
      new BigDecimal("1"), // tenor 3y
      new BigDecimal("0.96"), // tenor 5y
      new BigDecimal("0.88"), // tenor 10y
      new BigDecimal("0.83"), // tenor 15y
      new BigDecimal("0.8"), // tenor 20y
      new BigDecimal("0.78")}, // tenor 30y
    { // tenor 5y
      new BigDecimal("0.24"), // tenor 2w
      new BigDecimal("0.24"), // tenor 1m
      new BigDecimal("0.35"), // tenor 3m
      new BigDecimal("0.5"), // tenor 6m
      new BigDecimal("0.76"), // tenor 1y
      new BigDecimal("0.89"), // tenor 2y
      new BigDecimal("0.96"), // tenor 3y
      new BigDecimal("1"), // tenor 5y
      new BigDecimal("0.95"), // tenor 10y
      new BigDecimal("0.91"), // tenor 15y
      new BigDecimal("0.88"), // tenor 20y
      new BigDecimal("0.87")}, // tenor 30y
    { // tenor 10y
      new BigDecimal("0.18"), // tenor 2w
      new BigDecimal("0.18"), // tenor 1m
      new BigDecimal("0.27"), // tenor 3m
      new BigDecimal("0.41"), // tenor 6m
      new BigDecimal("0.65"), // tenor 1y
      new BigDecimal("0.79"), // tenor 2y
      new BigDecimal("0.88"), // tenor 3y
      new BigDecimal("0.95"), // tenor 5y
      new BigDecimal("1"), // tenor 10y
      new BigDecimal("0.97"), // tenor 15y
      new BigDecimal("0.95"), // tenor 20y
      new BigDecimal("0.95")}, // tenor 30y
    { // tenor 15y
      new BigDecimal("0.13"), // tenor 2w
      new BigDecimal("0.13"), // tenor 1m
      new BigDecimal("0.2"), // tenor 3m
      new BigDecimal("0.35"), // tenor 6m
      new BigDecimal("0.59"), // tenor 1y
      new BigDecimal("0.75"), // tenor 2y
      new BigDecimal("0.83"), // tenor 3y
      new BigDecimal("0.91"), // tenor 5y
      new BigDecimal("0.97"), // tenor 10y
      new BigDecimal("1"), // tenor 15y
      new BigDecimal("0.98"), // tenor 20y
      new BigDecimal("0.98")}, // tenor 30y
    { // tenor 20y
      new BigDecimal("0.11"), // tenor 2w
      new BigDecimal("0.11"), // tenor 1m
      new BigDecimal("0.17"), // tenor 3m
      new BigDecimal("0.33"), // tenor 6m
      new BigDecimal("0.56"), // tenor 1y
      new BigDecimal("0.72"), // tenor 2y
      new BigDecimal("0.8"), // tenor 3y
      new BigDecimal("0.88"), // tenor 5y
      new BigDecimal("0.95"), // tenor 10y
      new BigDecimal("0.98"), // tenor 15y
      new BigDecimal("1"), // tenor 20y
      new BigDecimal("0.99")}, // tenor 30y
    { // tenor 30y
      new BigDecimal("0.09"), // tenor 2w
      new BigDecimal("0.1"), // tenor 1m
      new BigDecimal("0.17"), // tenor 3m
      new BigDecimal("0.31"), // tenor 6m
      new BigDecimal("0.54"), // tenor 1y
      new BigDecimal("0.7"), // tenor 2y
      new BigDecimal("0.78"), // tenor 3y
      new BigDecimal("0.87"), // tenor 5y
      new BigDecimal("0.95"), // tenor 10y
      new BigDecimal("0.98"), // tenor 15y
      new BigDecimal("0.99"), // tenor 20y
      new BigDecimal("1")}}; // tenor 30y

  @Override
  public BigDecimal getSensitivityCorrelation(WeightingClass si, WeightingClass sk) {
    int indexOf = InterestRateTenor.indexOf(si.getLabel1());
    int indexOf2 = InterestRateTenor.indexOf(sk.getLabel1());
    // NOTE: when we see a XCcy to Inflation correlation, we should use the XCcy correlation parameter, as such we put the XCcy option first
    //	so that it has precedence over Inflation (might need more complex logic in the future)
    if (si.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_XCCY_BASIS) || sk.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_XCCY_BASIS)) {
      return XCCY;
    } else if (si.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_INFLATION) || sk.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_INFLATION) ||
      si.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_INFLATION_VOL) || sk.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_INFLATION_VOL)) {
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
