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

package com.acadiasoft.simm.engine.param;

import com.acadiasoft.simm.model.interestrate.IRRiskCorrelation;
import com.acadiasoft.simm.model.cnq.CNRiskCorrelation;
import com.acadiasoft.simm.model.cnq.CreditNonQualifyingCorrelationV2_0;
import com.acadiasoft.simm.model.commodity.CMRiskCorrelation;
import com.acadiasoft.simm.model.commodity.CommodityCorrelationV2_0;
import com.acadiasoft.simm.model.cq.BCRisk;
import com.acadiasoft.simm.model.cq.BaseCorrRiskV2_0;
import com.acadiasoft.simm.model.cq.CQRiskCorrelation;
import com.acadiasoft.simm.model.cq.CreditQualifyingCorrelationV2_0;
import com.acadiasoft.simm.model.equity.EQRiskCorrelation;
import com.acadiasoft.simm.model.equity.EquityCorrelationV2_0;
import com.acadiasoft.simm.model.fx.FXCorrelationV2_0;
import com.acadiasoft.simm.model.fx.FXRiskCorrelation;
import com.acadiasoft.simm.model.interestrate.InterestRateCorrelationV2_0;
import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.risk.RiskType;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * Created by alec.stewart on 8/2/17.
 */
public class RiskCorrelation {

  private static final IRRiskCorrelation ir = new InterestRateCorrelationV2_0();
  private static final FXRiskCorrelation fx = new FXCorrelationV2_0();
  private static final EQRiskCorrelation eq = new EquityCorrelationV2_0();
  private static final CQRiskCorrelation cq = new CreditQualifyingCorrelationV2_0();
  private static final CMRiskCorrelation cm = new CommodityCorrelationV2_0();
  private static final CNRiskCorrelation cnq = new CreditNonQualifyingCorrelationV2_0();
  private static final BCRisk bc = new BaseCorrRiskV2_0();

  public static BigDecimal getSensitivityCorrelation(RiskClass r, Sensitivity si, Sensitivity sk) {
    if (r.equals(RiskClass.COMMODITY)) {
      return cm.getSensitivityCorrelation(si, sk);
    } else if (r.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return cnq.getSensitivityCorrelation(si, sk);
    } else if (r.equals(RiskClass.CREDIT_QUALIFYING)
      && StringUtils.equalsIgnoreCase(si.getRiskType(), RiskType.RISK_TYPE_BASE_CORR)
      && StringUtils.equalsIgnoreCase(sk.getRiskType(), RiskType.RISK_TYPE_BASE_CORR)) {
      throw new RuntimeException("called com.acadiasoft.simm.model.risk correlation for base corr sensitvity: " + si + ", " + sk);
    } else if (r.equals(RiskClass.CREDIT_QUALIFYING)) {
      return cq.getSensitivityCorrelation(si, sk);
    } else if (r.equals(RiskClass.EQUITY)) {
      return eq.getSensitivityCorrelation(si, sk);
    } else if (r.equals(RiskClass.FX)) {
      return fx.getSensitivityCorrelation(si, sk);
    } else if (r.equals(RiskClass.INTEREST_RATE)) {
      return ir.getSensitivityCorrelation(si, sk);
    } else {
      throw new RuntimeException("found bad com.acadiasoft.simm.model.risk class: " + r);
    }
  }

  public static BigDecimal getBaseCorrSensitvityCorrelation(RiskClass r, Sensitivity si, Sensitivity sk) {
    if (r.equals(RiskClass.CREDIT_QUALIFYING)
      && StringUtils.equalsIgnoreCase(si.getRiskType(), RiskType.RISK_TYPE_BASE_CORR)
      && StringUtils.equalsIgnoreCase(sk.getRiskType(), RiskType.RISK_TYPE_BASE_CORR)) {
      return bc.getRiskCorrelation(si, sk);
    } else {
      throw new RuntimeException("called base corr correlation with other com.acadiasoft.simm.model.sensitivity type: " + si + ", " + sk);
    }
  }

  public static BigDecimal getBucketCorrelation(RiskClass r, String bi, String bk) {
    // NOTE: No cross bucket correlation for Base Correlation
    if (r.equals(RiskClass.COMMODITY)) {
      return cm.getBucketCorrelation(bi, bk);
    } else if (r.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return cnq.getBucketCorrelation(bi, bk);
    } else if (r.equals(RiskClass.CREDIT_QUALIFYING)) {
      return cq.getBucketCorrelation(bi, bk);
    } else if (r.equals(RiskClass.EQUITY)) {
      return eq.getBucketCorrelation(bi, bk);
    } else if (r.equals(RiskClass.FX)) {
      throw new RuntimeException("called cross bucket correlation for FX com.acadiasoft.simm.model.risk class (All FX should be in same bucket): " + bi + ", " + bk);
    } else if (r.equals(RiskClass.INTEREST_RATE)) {
      return ir.getBucketCorrelation(bi, bk);
    } else {
      throw new RuntimeException("found bad com.acadiasoft.simm.model.risk class: " + r);
    }
  }

}
