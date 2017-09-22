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

import com.acadiasoft.simm.model.cnq.CNRiskWeight;
import com.acadiasoft.simm.model.cnq.CreditNonQualifyingRiskWeightV2_0;
import com.acadiasoft.simm.model.commodity.CMRiskWeight;
import com.acadiasoft.simm.model.commodity.CommodityRiskWeightV2_0;
import com.acadiasoft.simm.model.cq.BCRisk;
import com.acadiasoft.simm.model.cq.BaseCorrRiskV2_0;
import com.acadiasoft.simm.model.cq.CQRiskWeight;
import com.acadiasoft.simm.model.cq.CreditQualifyingRiskWeightV2_0;
import com.acadiasoft.simm.model.equity.EQRiskWeight;
import com.acadiasoft.simm.model.equity.EquityRiskWeightV2_0;
import com.acadiasoft.simm.model.fx.FXRiskWeight;
import com.acadiasoft.simm.model.fx.FXRiskWeightV2_0;
import com.acadiasoft.simm.model.interestrate.IRRiskWeight;
import com.acadiasoft.simm.model.interestrate.InterestRateRiskWeightV2_0;
import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.risk.RiskType;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * Created by alec.stewart on 8/2/17.
 */
public class RiskWeight {

  private static final BCRisk bc = new BaseCorrRiskV2_0();
  private static final CMRiskWeight cm = new CommodityRiskWeightV2_0();
  private static final CNRiskWeight cnq = new CreditNonQualifyingRiskWeightV2_0();
  private static final CQRiskWeight cq = new CreditQualifyingRiskWeightV2_0();
  private static final EQRiskWeight eq = new EquityRiskWeightV2_0();
  private static final FXRiskWeight fx = new FXRiskWeightV2_0();
  private static final IRRiskWeight ir = new InterestRateRiskWeightV2_0();

  public static BigDecimal getRiskWeight(RiskClass r, Sensitivity s) {
    if (r.equals(RiskClass.COMMODITY)) {
      return cm.getRiskWeight(s);
    } else if (r.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return cnq.getRiskWeight(s);
    } else if (r.equals(RiskClass.CREDIT_QUALIFYING) && StringUtils.equalsIgnoreCase(s.getRiskType(), RiskType.RISK_TYPE_BASE_CORR)) {
      throw new RuntimeException("called com.acadiasoft.simm.model.risk weight for base corr sensitvity: " + s);
    } else if (r.equals(RiskClass.CREDIT_QUALIFYING)) {
      return cq.getRiskWeight(s);
    } else if (r.equals(RiskClass.EQUITY)) {
      return eq.getRiskWeight(s);
    } else if (r.equals(RiskClass.FX)) {
      return fx.getRiskWeight(s);
    } else if (r.equals(RiskClass.INTEREST_RATE)) {
      return ir.getRiskWeight(s);
    } else {
      throw new RuntimeException("found bad com.acadiasoft.simm.model.risk class: " + r);
    }
  }

  public static BigDecimal getVegaRiskWeight(RiskClass r, Sensitivity s) {
    if (r.equals(RiskClass.COMMODITY)) {
      return cm.getVegaRiskWeight(s);
    } else if (r.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return cnq.getVegaRiskWeight(s);
    } else if (r.equals(RiskClass.CREDIT_QUALIFYING) && StringUtils.equalsIgnoreCase(s.getRiskType(), RiskType.RISK_TYPE_BASE_CORR)) {
      throw new RuntimeException("called vega com.acadiasoft.simm.model.risk weight for base corr sensitvity: " + s);
    } else if (r.equals(RiskClass.CREDIT_QUALIFYING)) {
      return cq.getVegaRiskWeight(s);
    } else if (r.equals(RiskClass.EQUITY)) {
      return eq.getVegaRiskWeight(s);
    } else if (r.equals(RiskClass.FX)) {
      return fx.getVegaRiskWeight(s);
    } else if (r.equals(RiskClass.INTEREST_RATE)) {
      return ir.getVegaRiskWeight(s);
    } else {
      throw new RuntimeException("found bad com.acadiasoft.simm.model.risk class: " + r);
    }
  }

  public static BigDecimal getBaseCorrRiskWeight(RiskClass r, Sensitivity s) {
    if (r.equals(RiskClass.CREDIT_QUALIFYING) && StringUtils.equalsIgnoreCase(s.getRiskType(), RiskType.RISK_TYPE_BASE_CORR)) {
      return bc.getRiskWeight(s);
    } else {
      throw new RuntimeException("called base corr com.acadiasoft.simm.model.risk weight for other com.acadiasoft.simm.model.sensitivity type: " + s);
    }
  }

  public static BigDecimal getHVR(RiskClass r, Sensitivity s) {
    if (r.equals(RiskClass.COMMODITY)) {
      return cm.getHVR();
    } else if (r.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return cnq.getHVR();
    } else if (r.equals(RiskClass.CREDIT_QUALIFYING) && StringUtils.equalsIgnoreCase(s.getRiskType(), RiskType.RISK_TYPE_BASE_CORR)) {
      throw new RuntimeException("called HVR for base corr sensitvity: " + s);
    } else if (r.equals(RiskClass.CREDIT_QUALIFYING)) {
      return cq.getHVR();
    } else if (r.equals(RiskClass.EQUITY)) {
      return eq.getHVR();
    } else if (r.equals(RiskClass.FX)) {
      return fx.getHVR();
    } else if (r.equals(RiskClass.INTEREST_RATE)) {
      return ir.getHVR();
    } else {
      throw new RuntimeException("found bad com.acadiasoft.simm.model.risk class: " + r);
    }
  }

}
