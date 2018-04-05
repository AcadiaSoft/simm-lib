/*
 * Copyright (c) 2017 AcadiaSoft, Inc.
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

package com.acadiasoft.simm.model.param.interestrate;

import com.acadiasoft.simm.model.object.Sensitivity;
import com.acadiasoft.simm.model.object.imtree.identifiers.BucketClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.RiskClass;

import com.acadiasoft.simm.model.object.imtree.identifiers.WeightingClass;
import com.acadiasoft.simm.model.param.SimmBucketCorrelation;
import com.acadiasoft.simm.model.param.SimmSensitivityCorrelation;
import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;

/**
 * As defined in Appendix 1 section D.2 of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class InterestRateCorrelationV2_0 implements SimmBucketCorrelation, SimmSensitivityCorrelation {

  public static final BigDecimal INFLATION = new BigDecimal("0.29");
  public static final BigDecimal XCCY = new BigDecimal("0.20");
  public static final BigDecimal SUB_CURVE_SAME_CCY = new BigDecimal("0.98");
  public static final BigDecimal AGGREGATE_DIFF = new BigDecimal("0.23");

  private static final BigDecimal[][] CORRELATIONS = {
    { // tenor 2w
      new BigDecimal("1"), // tenor 2w
      new BigDecimal("1"), // tenor 1m
      new BigDecimal("0.79"), // tenor 3m
      new BigDecimal("0.67"), // tenor 6m
      new BigDecimal("0.53"), // tenor 1y
      new BigDecimal("0.42"), // tenor 2y
      new BigDecimal("0.37"), // tenor 3y
      new BigDecimal("0.30"), // tenor 5y
      new BigDecimal("0.22"), // tenor 10y
      new BigDecimal("0.18"), // tenor 15y
      new BigDecimal("0.16"), // tenor 20y
      new BigDecimal("0.12")}, // tenor 30y
    { // tenor 1m
      new BigDecimal("1"), // tenor 2w
      new BigDecimal("1"), // tenor 1m
      new BigDecimal("0.79"), // tenor 3m
      new BigDecimal("0.67"), // tenor 6m
      new BigDecimal("0.53"), // tenor 1y
      new BigDecimal("0.42"), // tenor 2y
      new BigDecimal("0.37"), // tenor 3y
      new BigDecimal("0.30"), // tenor 5y
      new BigDecimal("0.22"), // tenor 10y
      new BigDecimal("0.18"), // tenor 15y
      new BigDecimal("0.16"), // tenor 20y
      new BigDecimal("0.12")}, // tenor 20y
    { // tenor 3m
      new BigDecimal("0.79"), // tenor 2w
      new BigDecimal("0.79"), // tenor 1m
      new BigDecimal("1"), // tenor 3m
      new BigDecimal("0.85"), // tenor6m
      new BigDecimal("0.69"), // tenor 1y
      new BigDecimal("0.57"), // tenor 2y
      new BigDecimal("0.50"), // tenor 3y
      new BigDecimal("0.42"), // tenor 5y
      new BigDecimal("0.32"), // tenor 10y
      new BigDecimal("0.25"), // tenor 15y
      new BigDecimal("0.23"), // tenor 20y
      new BigDecimal("0.20")}, // tenor 30y
    { // tenor 6m
      new BigDecimal("0.67"), // tenor 2w
      new BigDecimal("0.67"), // tenor 1m
      new BigDecimal("0.85"), // tenor 3m
      new BigDecimal("1"), // tenor 6m
      new BigDecimal("0.86"), // tenor 1y
      new BigDecimal("0.76"), // tenor 2y
      new BigDecimal("0.69"), // tenor 3y
      new BigDecimal("0.59"), // tenor 5y
      new BigDecimal("0.47"), // tenor 10y
      new BigDecimal("0.40"), // tenor 15y
      new BigDecimal("0.37"), // tenor 20y
      new BigDecimal("0.32")}, // tenor 30y
    { // tenor 1y
      new BigDecimal("0.53"), // tenor 2w
      new BigDecimal("0.53"), // tenor 1m
      new BigDecimal("0.69"), // tenor 3m
      new BigDecimal("0.86"), // tenor 6m
      new BigDecimal("1"), // tenor 1y
      new BigDecimal("0.93"), // tenor 2y
      new BigDecimal("0.87"), // tenor 3y
      new BigDecimal("0.77"), // tenor 5y
      new BigDecimal("0.63"), // tenor 10y
      new BigDecimal("0.57"), // tenor 15y
      new BigDecimal("0.54"), // tenor 20y
      new BigDecimal("0.50")}, // tenor 30y
    { // tenor 2y
      new BigDecimal("0.42"), // tenor 2w
      new BigDecimal("0.42"), // tenor 1m
      new BigDecimal("0.57"), // tenor 3m
      new BigDecimal("0.76"), // tenor 6m
      new BigDecimal("0.93"), // tenor 1y
      new BigDecimal("1"), // tenor 2y
      new BigDecimal("0.98"), // tenor 3y
      new BigDecimal("0.90"), // tenor 5y
      new BigDecimal("0.77"), // tenor 10y
      new BigDecimal("0.70"), // tenor 15y
      new BigDecimal("0.67"), // tenor 20y
      new BigDecimal("0.63")}, // tenor 30y
    { // tenor 3y
      new BigDecimal("0.37"), // tenor 2w
      new BigDecimal("0.37"), // tenor 1m
      new BigDecimal("0.50"), // tenor 3m
      new BigDecimal("0.69"), // tenor 6m
      new BigDecimal("0.87"), // tenor 1y
      new BigDecimal("0.98"), // tenor 2y
      new BigDecimal("1"), // tenor 3y
      new BigDecimal("0.96"), // tenor 5y
      new BigDecimal("0.84"), // tenor 10y
      new BigDecimal("0.78"), // tenor 15y
      new BigDecimal("0.75"), // tenor 20y
      new BigDecimal("0.71")}, // tenor 30y
    { // tenor 5y
      new BigDecimal("0.30"), // tenor 2w
      new BigDecimal("0.30"), // tenor 1m
      new BigDecimal("0.42"), // tenor 3m
      new BigDecimal("0.59"), // tenor 6m
      new BigDecimal("0.77"), // tenor 1y
      new BigDecimal("0.90"), // tenor 2y
      new BigDecimal("0.96"), // tenor 3y
      new BigDecimal("1"), // tenor 5y
      new BigDecimal("0.93"), // tenor 10y
      new BigDecimal("0.89"), // tenor 15y
      new BigDecimal("0.86"), // tenor 20y
      new BigDecimal("0.82")}, // tenor 30y
    { // tenor 10y
      new BigDecimal("0.22"), // tenor 2w
      new BigDecimal("0.22"), // tenor 1m
      new BigDecimal("0.32"), // tenor 3m
      new BigDecimal("0.47"), // tenor 6m
      new BigDecimal("0.63"), // tenor 1y
      new BigDecimal("0.77"), // tenor 2y
      new BigDecimal("0.84"), // tenor 3y
      new BigDecimal("0.93"), // tenor 5y
      new BigDecimal("1"), // tenor 10y
      new BigDecimal("0.98"), // tenor 15y
      new BigDecimal("0.96"), // tenor 20y
      new BigDecimal("0.94")}, // tenor 30y
    { // tenor 15y
      new BigDecimal("0.18"), // tenor 2w
      new BigDecimal("0.18"), // tenor 1m
      new BigDecimal("0.25"), // tenor 3m
      new BigDecimal("0.40"), // tenor 6m
      new BigDecimal("0.57"), // tenor 1y
      new BigDecimal("0.70"), // tenor 2y
      new BigDecimal("0.78"), // tenor 3y
      new BigDecimal("0.89"), // tenor 5y
      new BigDecimal("0.98"), // tenor 10y
      new BigDecimal("1"), // tenor 15y
      new BigDecimal("0.99"), // tenor 20y
      new BigDecimal("0.98")}, // tenor 30y
    { // tenor 20y
      new BigDecimal("0.16"), // tenor 2w
      new BigDecimal("0.16"), // tenor 1m
      new BigDecimal("0.23"), // tenor 3m
      new BigDecimal("0.37"), // tenor 6m
      new BigDecimal("0.54"), // tenor 1y
      new BigDecimal("0.67"), // tenor 2y
      new BigDecimal("0.75"), // tenor 3y
      new BigDecimal("0.86"), // tenor 5y
      new BigDecimal("0.96"), // tenor 10y
      new BigDecimal("0.99"), // tenor 15y
      new BigDecimal("1"), // tenor 20y
      new BigDecimal("0.99")}, // tenor 30y
    { // tenor 30y
      new BigDecimal("0.12"), // tenor 2w
      new BigDecimal("0.12"), // tenor 1m
      new BigDecimal("0.20"), // tenor 3m
      new BigDecimal("0.32"), // tenor 6m
      new BigDecimal("0.50"), // tenor 1y
      new BigDecimal("0.63"), // tenor 2y
      new BigDecimal("0.71"), // tenor 3y
      new BigDecimal("0.82"), // tenor 5y
      new BigDecimal("0.94"), // tenor 10y
      new BigDecimal("0.98"), // tenor 15y
      new BigDecimal("0.99"), // tenor 20y
      new BigDecimal("1")}}; // tenor 30y

  @Override
  public BigDecimal getSensitivityCorrelation(WeightingClass si, WeightingClass sk) {
    int indexOf = InterestRateTenor.indexOf(si.getLabel1());
    int indexOf2 = InterestRateTenor.indexOf(sk.getLabel1());
    // NOTE: when we see a XCcy to Inflation correlation, we should use the XCcy correlation parameter, as such we put the XCcy option first
    //	so that it has precedence over Inflation (might need more complex logic in the future)
    if (si.getRiskType().equals(RiskClass.RISK_TYPE_XCCY_BASIS) || sk.getRiskType().equals(RiskClass.RISK_TYPE_XCCY_BASIS)) {
      return XCCY;
    } else if (si.getRiskType().equals(RiskClass.RISK_TYPE_INFLATION) || sk.getRiskType().equals(RiskClass.RISK_TYPE_INFLATION) ||
      si.getRiskType().equals(RiskClass.RISK_TYPE_INFLATION_VOL) || sk.getRiskType().equals(RiskClass.RISK_TYPE_INFLATION_VOL)) {
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
    return AGGREGATE_DIFF;
  }

}
