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

package com.acadiasoft.im.simmple.model;

import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 *
 * @author alec.stewart
 */
public class DefaultCrif implements Crif, Serializable {

  private final String tradeId;
  private final String imModel;
  private final String productClass;
  private final String riskType;
  private final String qualifier;
  private final String bucket;
  private final String label1;
  private final String label2;
  private final String amount;
  private final String amountCurrency;
  private final String amountUSD;
  private final String postRegulation;
  private final String collectRegulation;
  private final String valuationDate;
  private final String endDate;
  private final String notional;
  private final String notionalCurrency;

  /**
   *  Builds a line of CRIF data with all fields
   *
   * @param tradeId the id of the trade that the CRIF line belongs to
   * @param valuationDate the valuation date of the trade
   * @param endDate the end date of the trade
   * @param notional the notional amount of the trade
   * @param notionalCurrency the currency of the trade notional
   * @param imModel the model that im will be calculated with for the trade
   * @param productClass the product class of the trade
   *                     (either SIMM: [RatesFX, Credit, Commdity, Equity] or Schedule: [Rates, FX, Credit, Commodity, Equity]
   * @param riskType the risk type of the CRIF line as defined by the Common Risk Interchange Format
   * @param qualifier the qualifier " . . . "
   * @param bucket the bucket " . . . "
   * @param label1 the label1 " . . . "
   * @param label2 the label2 " . . . "
   * @param amount the amount " . . . "
   * @param amountCurrency the currency of the amount
   * @param amountUSD the amount in USD
   * @param postRegulation the regulator of the posting party (usually this is yourself)
   * @param collectRegulation the regulator of the collecting party (usually this is a counter-party)
   */
  @JsonCreator
  public DefaultCrif(@JsonProperty("trade_id") String tradeId, @JsonProperty("valuation_date") String valuationDate,
                     @JsonProperty("end_date") String endDate, @JsonProperty("notional") String notional,
                     @JsonProperty("trade_currency") String notionalCurrency, @JsonProperty("im_model") String imModel,
                     @JsonProperty("product_class") String productClass, @JsonProperty("risk_type") String riskType,
                     @JsonProperty("qualifier") String qualifier, @JsonProperty("bucket") String bucket,
                     @JsonProperty("label1") String label1, @JsonProperty("label2") String label2,
                     @JsonProperty("amount") String amount, @JsonProperty("amount_currency") String amountCurrency,
                     @JsonProperty("amount_usd") String amountUSD, @JsonProperty("post_regulation") String postRegulation,
                     @JsonProperty("collect_regulation") String collectRegulation) {
    this.valuationDate = valuationDate;
    this.endDate = endDate;
    this.tradeId = tradeId;
    this.imModel = imModel;
    this.productClass = productClass;
    this.riskType = riskType;
    this.qualifier = qualifier;
    this.bucket = bucket;
    this.label1 = label1;
    this.label2 = label2;
    this.amount = amount;
    this.amountCurrency = amountCurrency;
    this.amountUSD = amountUSD;
    this.postRegulation = postRegulation;
    this.collectRegulation = collectRegulation;
    this.notional = notional;
    this.notionalCurrency = notionalCurrency;
  }

  @Override
  @JsonGetter("valuation_date")
  public String getValuationDateAsString() {
    return valuationDate;
  }

  @Override
  @JsonGetter("end_date")
  public String getEndDateAsString() {
    return endDate;
  }

  @Override
  @JsonGetter("trade_id")
  public String getTradeId() {
    return tradeId;
  }

  @Override
  @JsonGetter("notional")
  public String getTradeNotionalAsString() {
    return notional;
  }

  @Override
  @JsonGetter("trade_currency")
  public String getTradeCurrency() {
    return notionalCurrency;
  }

  @Override
  @JsonGetter("im_model")
  public String getImModel() {
    return imModel;
  }

  @Override
  @JsonGetter("product_class")
  public String getProductClass() {
    return productClass;
  }

  @Override
  @JsonGetter("risk_type")
  public String getRiskType() {
    return riskType;
  }

  @Override
  @JsonGetter("qualifier")
  public String getQualifier() {
    return qualifier;
  }

  @Override
  @JsonGetter("bucket")
  public String getBucket() {
    return bucket;
  }

  @Override
  @JsonGetter("label1")
  public String getLabel1() {
    return label1;
  }

  @Override
  @JsonGetter("label2")
  public String getLabel2() {
    return label2;
  }

  @Override
  @JsonIgnore
  public SensitivityClass getSensitivityClass() {
    return SensitivityClass.determineByRiskType(riskType);
  }

  @Override
  @JsonIgnore
  public RiskClass getRiskIdentifier() {
    return RiskClass.determineByRiskType(riskType);
  }

  @Override
  @JsonGetter("amount")
  public String getAmountAsString() {
    return amount;
  }

  @Override
  @JsonGetter("amount_currency")
  public String getAmountCurrency() {
    return amountCurrency;
  }

  @Override
  @JsonGetter("amount_usd")
  public String getAmountUsdAsString() {
    return amountUSD;
  }

  @Override
  @JsonGetter("post_regulation")
  public String getPostRegulation() {
    return postRegulation;
  }

  @Override
  @JsonGetter("collect_regulation")
  public String getCollectRegulation() {
    return collectRegulation;
  }

}
