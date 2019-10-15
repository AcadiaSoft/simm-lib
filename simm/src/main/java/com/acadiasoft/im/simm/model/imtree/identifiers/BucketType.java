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

import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.param.equity.EquityRegion;
import com.acadiasoft.im.simm.model.param.equity.EquitySize;
import org.apache.commons.lang3.StringUtils;

public enum BucketType {

  FX(RiskClass.FX, 1, "The single FX bucket"),
  IRREG(RiskClass.INTEREST_RATE, 1, "Regular Volatility Currency"),
  IRLOW(RiskClass.INTEREST_RATE, 2, "Low Volatility Currency"),
  IRHIGH(RiskClass.INTEREST_RATE, 3, "High Volatility Currency"),
  CM1(RiskClass.COMMODITY, 1, "Coal"), // 
  CM2(RiskClass.COMMODITY, 2, "Crude"), //  
  CM3(RiskClass.COMMODITY, 3, "Light Ends"), //  
  CM4(RiskClass.COMMODITY, 4, "Middle Distillates"), //  
  CM5(RiskClass.COMMODITY, 5, "Heavy Distillates"), //  
  CM6(RiskClass.COMMODITY, 6, "North America Natural Gas"), //  
  CM7(RiskClass.COMMODITY, 7, "European Natural Gas"), //  
  CM8(RiskClass.COMMODITY, 8, "North American Power"), //  
  CM9(RiskClass.COMMODITY, 9, "European Power"), //  
  CM10(RiskClass.COMMODITY, 10, "Freight"), //  
  CM11(RiskClass.COMMODITY, 11, "Base Metals"), //  
  CM12(RiskClass.COMMODITY, 12, "Precious Metals"), //  
  CM13(RiskClass.COMMODITY, 13, "Grains"), //  
  CM14(RiskClass.COMMODITY, 14, "Softs"), //  
  CM15(RiskClass.COMMODITY, 15, "Livestock"), //  
  CM16(RiskClass.COMMODITY, 16, "Other"), //
  CM17(RiskClass.COMMODITY, 17, "Indexes"),
  CRNQ1(RiskClass.CREDIT_NON_QUALIFYING, 1, "Investment grade (IG) in RMBS/CMBS"), // 
  CRNQ2(RiskClass.CREDIT_NON_QUALIFYING, 2, "High yield (HY) & non-rated (NR) in RMBS/CMBS"), //
  CRNQRESIDUAL(RiskClass.CREDIT_NON_QUALIFYING, -1, "CRNQ Residual Bucket"),
  CRQ1(RiskClass.CREDIT_QUALIFYING, 1, "Investment grade (IG) in Sovereigns including central banks"), //
  CRQ2(RiskClass.CREDIT_QUALIFYING, 2, "Investment grade (IG) in Financials including government-backed financials"), //
  CRQ3(RiskClass.CREDIT_QUALIFYING, 3, "Investment grade (IG) in Basic materials, energy, industrials"), //
  CRQ4(RiskClass.CREDIT_QUALIFYING, 4, "Investment grade (IG) in Consumer"), //
  CRQ5(RiskClass.CREDIT_QUALIFYING, 5, "Investment grade (IG) in Technology, telecommunications"), //
  CRQ6(RiskClass.CREDIT_QUALIFYING, 6, "Investment grade (IG) in Health care, utilities, local government, government-backed corporates (non- financial)"), // 
  CRQ7(RiskClass.CREDIT_QUALIFYING, 7, "High yield (HY) & non-rated (NR) in Sovereigns including central banks"), //
  CRQ8(RiskClass.CREDIT_QUALIFYING, 8, "High yield (HY) & non-rated (NR) in Financials including government-backed financials"), //
  CRQ9(RiskClass.CREDIT_QUALIFYING, 9, "High yield (HY) & non-rated (NR) in Basic materials, energy, industrials"), //
  CRQ10(RiskClass.CREDIT_QUALIFYING, 10, "High yield (HY) & non-rated (NR) in Consumer"), //
  CRQ11(RiskClass.CREDIT_QUALIFYING, 11, "High yield (HY) & non-rated (NR) in Technology, telecommunications"), //
  CRQ12(RiskClass.CREDIT_QUALIFYING, 12, "High yield (HY) & non-rated (NR) in Health care, utilities, local government, government-backed corporates (non- financial)"), // 
  CRQRESIDUAL(RiskClass.CREDIT_QUALIFYING, -1, "CRQ Residual Bucket"),
  EQ1(RiskClass.EQUITY, 1, EquitySize.LARGE + " " + EquityRegion.EMERGING + " Consumer goods and services, transportation and storage, administrative and support service activities, utilities"), //
  EQ2(RiskClass.EQUITY, 2, EquitySize.LARGE + " " + EquityRegion.EMERGING + " Telecommunications, industrials"), //
  EQ3(RiskClass.EQUITY, 3, EquitySize.LARGE + " " + EquityRegion.EMERGING + " Basic materials, energy, agriculture, manufacturing, mining and quarrying "), //
  EQ4(RiskClass.EQUITY, 4, EquitySize.LARGE + " " + EquityRegion.EMERGING + " Financials including gov't-backed financials, real estate activities, technology"), //
  EQ5(RiskClass.EQUITY, 5, EquitySize.LARGE + " " + EquityRegion.DEVELOPED + " Consumer goods and services, transportation and storage, administrative and support service activities, utilities "), //
  EQ6(RiskClass.EQUITY, 6, EquitySize.LARGE + " " + EquityRegion.DEVELOPED + " Telecommunications, industrials"), //
  EQ7(RiskClass.EQUITY, 7, EquitySize.LARGE + " " + EquityRegion.DEVELOPED + " Basic materials, energy, agriculture, manufacturing, mining and quarrying "), //
  EQ8(RiskClass.EQUITY, 8, EquitySize.LARGE + " " + EquityRegion.DEVELOPED + " Financials including gov't-backed financials, real estate activities, technology "), //
  EQ9(RiskClass.EQUITY, 9, EquitySize.SMALL + " " + EquityRegion.EMERGING + " All sectors"), //
  EQ10(RiskClass.EQUITY, 10, EquitySize.SMALL + " " + EquityRegion.DEVELOPED + " All sectors"), //
  EQ11(RiskClass.EQUITY, 11, EquitySize.ALL + " " + EquityRegion.ALL + " Indexes, Funds, ETFs"),
  EQ12(RiskClass.EQUITY, 12, EquitySize.ALL + " " + EquityRegion.ALL + " Volatility Indexes"),
  EQRESIDUAL(RiskClass.EQUITY, -1, "EQ Residual Bucket");

  private final RiskClass riskClass;
  private final int bucketNumber;
  private final String description;

  private BucketType(RiskClass riskClass, int bucket, String description) {
    this.riskClass = riskClass;
    this.bucketNumber = bucket;
    this.description = description;
  }

  public int getBucketNumber() {
    return bucketNumber;
  }

  public RiskClass getBucketRiskClass() {
    return riskClass;
  }

  public String getBucketDescription() {
    return description;
  }

  public static BucketType determineBucketType(RiskClass riskClass, String bucketNumber) {
    if (StringUtils.equalsIgnoreCase(bucketNumber, Sensitivity.RESIDUAL)) {
      return getResidualBucket(riskClass);
    } else {
      for (BucketType b : values()) {
        if (b.getBucketRiskClass().equals(riskClass) && (Integer.toString(b.getBucketNumber()).equals(bucketNumber))) {
          return b;
        }
      }

      throw new IllegalStateException("tried to determine bucket for non-legal risk class: [" + riskClass + "]!");
    }
  }

  public static boolean isResidualBucket(BucketType bucketType) {
    RiskClass r = bucketType.getBucketRiskClass();
    if (r.equals(RiskClass.INTEREST_RATE) || r.equals(RiskClass.FX) || r.equals(RiskClass.COMMODITY)) {
      return false;
    } else if (bucketType.equals(getResidualBucket(bucketType.getBucketRiskClass()))) {
      return true;
    } else {
      return false;
    }
  }

  private static BucketType getResidualBucket(RiskClass riskClass) {
    switch (riskClass) {
      case EQUITY:
        return EQRESIDUAL;
      case CREDIT_QUALIFYING:
        return CRQRESIDUAL;
      case CREDIT_NON_QUALIFYING:
        return CRNQRESIDUAL;
      case INTEREST_RATE:
      case COMMODITY:
      case FX:
        throw new IllegalStateException("tried to get Residual bucket for risk class without one: [" + riskClass + "]!");
      default:
        throw new IllegalStateException("tried to determine bucket for non-legal risk class: [" + riskClass +"]!");
    }
  }

}
