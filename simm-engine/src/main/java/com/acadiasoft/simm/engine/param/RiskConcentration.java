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

import com.acadiasoft.simm.engine.margin.vega.VegaMarginWeightUtils;
import com.acadiasoft.simm.model.cnq.CNRiskConcentration;
import com.acadiasoft.simm.model.cnq.CreditNonQualifyingConcentrationRiskV2_0;
import com.acadiasoft.simm.model.commodity.CMRiskConcentration;
import com.acadiasoft.simm.model.commodity.CommodityConcentrationRiskV2_0;
import com.acadiasoft.simm.model.cq.CQRiskConcentration;
import com.acadiasoft.simm.model.cq.CreditQualifyingConcentrationRiskV2_0;
import com.acadiasoft.simm.model.equity.EQRiskConcentration;
import com.acadiasoft.simm.model.equity.EquityConcentrationRiskV2_0;
import com.acadiasoft.simm.model.fx.FXConcentrationRiskV2_0;
import com.acadiasoft.simm.model.fx.FXRiskConcentration;
import com.acadiasoft.simm.model.interestrate.IRRiskConcentration;
import com.acadiasoft.simm.model.interestrate.InterestRateConcentrationRiskV2_0;
import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.risk.RiskType;
import com.acadiasoft.simm.model.sensitivity.BucketWeightedAggregation;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.model.sensitivity.WeightedSensitivity;
import com.acadiasoft.util.BigDecimalUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alec.stewart on 8/8/17.
 */
public class RiskConcentration {

  private static final IRRiskConcentration ir = new InterestRateConcentrationRiskV2_0();
  private static final FXRiskConcentration fx = new FXConcentrationRiskV2_0();
  private static final EQRiskConcentration eq = new EquityConcentrationRiskV2_0();
  private static final CQRiskConcentration cq = new CreditQualifyingConcentrationRiskV2_0();
  private static final CMRiskConcentration cm = new CommodityConcentrationRiskV2_0();
  private static final CNRiskConcentration cnq = new CreditNonQualifyingConcentrationRiskV2_0();

  public static BigDecimal getDeltaConcentrationRisk(RiskClass r, Sensitivity s, List<Sensitivity> all) {
    if (r.equals(RiskClass.INTEREST_RATE) && s.getRiskType().equals(RiskType.RISK_TYPE_XCCY_BASIS)) {
      // Xccy basis swaps are not multiplied by a concentration com.acadiasoft.simm.model.risk factor (i.e. CR = 1 for Xccy)
      return BigDecimal.ONE;
    } else if (r.equals(RiskClass.INTEREST_RATE)) {
      return ir.getDeltaConcentration(s.getQualifier(), all);
    } else if (r.equals(RiskClass.FX)) {
      return fx.getDeltaConcentration(s);
    } else if (r.equals(RiskClass.EQUITY)) {
      return eq.getDeltaConcentration(s);
    } else if (r.equals(RiskClass.COMMODITY)) {
      return cm.getDeltaConcentration(s);
    } else if (r.equals(RiskClass.CREDIT_QUALIFYING)) {
      return cq.getDeltaConcentration(s.getQualifier(), s.getBucket(), all);
    } else if (r.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return cnq.getDeltaConcentration(s.getQualifier(), s.getBucket(), all);
    } else {
      throw new RuntimeException("found unknown com.acadiasoft.simm.model.risk class: " + r);
    }
  }

  public static BigDecimal getVegaConcentrationRisk(RiskClass r, WeightedSensitivity ws, List<WeightedSensitivity> all) {
    // as per doc/ISDA-SIMM-v1.3.38, the concentration com.acadiasoft.simm.model.risk is summed over the VR_ik (vol weighted sensitivities)
    // values and not the original sensitivities themselves
    if (r.equals(RiskClass.INTEREST_RATE)) {
      return ir.getVegaConcentration(ws.getSensitivity().getQualifier(), all);
    } else if (r.equals(RiskClass.FX)) {
      return fx.getVegaConcentration(ws);
    } else if (r.equals(RiskClass.EQUITY)) {
      return eq.getVegaConcentration(ws);
    } else if (r.equals(RiskClass.COMMODITY)) {
      return cm.getVegaConcentration(ws);
    } else if (r.equals(RiskClass.CREDIT_QUALIFYING)) {
      return cq.getVegaConcentration(ws.getSensitivity().getQualifier(), all);
    } else if (r.equals(RiskClass.CREDIT_NON_QUALIFYING)) {
      return cnq.getVegaConcentration(ws.getSensitivity().getQualifier(), all);
    } else {
      throw new RuntimeException("found unknown com.acadiasoft.simm.model.risk class: " + r);
    }
  }

  public static BigDecimal getDeltaIntraBucketCorrelation(RiskClass r, WeightedSensitivity k, WeightedSensitivity i, List<WeightedSensitivity> sensitivities) {
    // Method is called at the bucket level, so all sensitivities have been fully weighted.
    // We need to calc CR again since we don't store this value after initial calc, thus we convert back to original com.acadiasoft.simm.model.sensitivity values
    if (r.equals(RiskClass.INTEREST_RATE)) {
      return BigDecimal.ONE;
    } else {
      List<Sensitivity> all = sensitivities.stream().map((ws) -> ws.getSensitivity()).collect(Collectors.toList());
      BigDecimal crk = getDeltaConcentrationRisk(r, k.getSensitivity(), all);
      BigDecimal cri = getDeltaConcentrationRisk(r, i.getSensitivity(), all);
      return BigDecimalUtils.divideWithPrecision(crk.min(cri), crk.max(cri));
    }
  }

  public static BigDecimal getVegaIntraBucketConcentration(RiskClass r, WeightedSensitivity k, WeightedSensitivity i, List<WeightedSensitivity> sensitivities) {
    // Method is called at the bucket level, so all sensitivities have been fully weighted.
    // We need to calc CR again since we don't store this value after initial calc, thus we convert back to original vol weighted com.acadiasoft.simm.model.sensitivity values
    if (r.equals(RiskClass.INTEREST_RATE)) {
      return BigDecimal.ONE;
    } else {
      // we get original sensitvities and then vol weight them
      List<WeightedSensitivity> all = VegaMarginWeightUtils.weightSensitivitiesVol(r, sensitivities.stream().map((ws) -> ws.getSensitivity()).collect(Collectors.toList()));
      WeightedSensitivity volK = VegaMarginWeightUtils.weightSensitivityVol(r, k.getSensitivity());
      WeightedSensitivity volI = VegaMarginWeightUtils.weightSensitivityVol(r, i.getSensitivity());
      BigDecimal crk = getVegaConcentrationRisk(r, volK, all);
      BigDecimal cri = getVegaConcentrationRisk(r, volI, all);
      return BigDecimalUtils.divideWithPrecision(crk.min(cri), crk.max(cri));
    }
  }

  public static BigDecimal getDeltaCrossBucketConcentration(RiskClass r, BucketWeightedAggregation currencyAggregateB, BucketWeightedAggregation currencyAggregateC) {
    if (r.equals(RiskClass.INTEREST_RATE)) {
      // convert back from weighted sensitivities to the original values to calc CR again
      List<Sensitivity> b = currencyAggregateB.getWeightedSensitivities().stream().map((ws) -> ws.getSensitivity()).collect(Collectors.toList());
      List<Sensitivity> c = currencyAggregateC.getWeightedSensitivities().stream().map((ws) -> ws.getSensitivity()).collect(Collectors.toList());
      // for IR the bucket designations are exactly the qualifiers
      BigDecimal crb = ir.getDeltaConcentration(currencyAggregateB.getBucket(), b);
      BigDecimal crc = ir.getDeltaConcentration(currencyAggregateC.getBucket(), c);
      return BigDecimalUtils.divideWithPrecision(crb.min(crc), crb.max(crc));
    } else {
      return BigDecimal.ONE;
    }
  }

  public static BigDecimal getVegaCrossBucketConcentration(RiskClass r, BucketWeightedAggregation currencyAggregateB, BucketWeightedAggregation currencyAggregateC) {
    if (r.equals(RiskClass.INTEREST_RATE)) {
      // convert back from weighted sensitvities to the original values to calc CR again, unlike with intra bucket calc the vol weighted value of an
      // IR vega com.acadiasoft.simm.model.sensitivity is exactly equivalent to the orignal com.acadiasoft.simm.model.sensitivity value since HVR = 1 and IR vega com.acadiasoft.simm.model.sensitivity values are given as vol * vega
      // (as stated in doc/Risk-Data-Standards_v1.44)
      List<Sensitivity> b = currencyAggregateB.getWeightedSensitivities().stream().map((ws) -> ws.getSensitivity()).collect(Collectors.toList());
      List<Sensitivity> c = currencyAggregateC.getWeightedSensitivities().stream().map((ws) -> ws.getSensitivity()).collect(Collectors.toList());
      // despite it being equivalent to multiplying by ONE we vol weight the above lists to get WeightedSensitivity lists
      List<WeightedSensitivity> volB = VegaMarginWeightUtils.weightSensitivitiesVol(r, b);
      List<WeightedSensitivity> volC = VegaMarginWeightUtils.weightSensitivitiesVol(r, c);
      // for IR the bucket designations are exactly the qualifiers
      BigDecimal crb = ir.getVegaConcentration(currencyAggregateB.getBucket(), volB);
      BigDecimal crc = ir.getVegaConcentration(currencyAggregateC.getBucket(), volC);
      return BigDecimalUtils.divideWithPrecision(crb.min(crc), crb.max(crc));
    } else {
      return BigDecimal.ONE;
    }
  }

}
