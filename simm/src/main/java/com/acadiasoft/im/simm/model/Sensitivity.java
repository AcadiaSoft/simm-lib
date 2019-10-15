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

package com.acadiasoft.im.simm.model;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.simm.model.imtree.identifiers.BucketClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.ProductClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;
import com.acadiasoft.im.simm.model.utils.SensitivityUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * As defined by Appendix 2, section 2.1 of Risk_Data_Standards_v1.25_(PUBLIC).pdf
 *
 * @author alec.stewart
 */
public class Sensitivity implements Serializable, SensitivityIdentifier {

  public static final String RESIDUAL = "residual";

  /**
   * A string identifier describing which product class the trade (or portfolio of trades) belongs to.
   * <p>
   * Allowed values are "RatesFX" (meaning Rates or FX), "Credit", "Equity", or "Commodity".
   * <p>
   * Note that if the trade is subject to the Schedule IM rather than SIMM, then the "RatesFX" value should not be used
   * and instead Rates/FX trades must be described as either "Rates" or "FX" since the Schedule IM calculation requires
   * distinguishing between the Rates and FX product classes, because they have different notional weightings. F
   * <p>
   * or SIMM the combined RatesFX product class is sufficient.
   */
  private final String productClass;

  /**
   * <ul>
   * <li>Interest rate : Risk_IRCurve, Risk_Inflation, Risk_IRVol</li>
   * <li>Credit Qualifying : Risk_CreditQ, Risk_CreditVol</li>
   * <li>Credit Non-Qualifying : Risk_CreditNonQ, Risk_CreditVolNonQ</li>
   * <li>Equity : Risk_Equity, Risk_EquityVol</li>
   * <li>Foreign exchange (FX) : Risk_FX, Risk_FXVol</li>
   * <li>Commodity : Risk_Commodity, Risk_CommodityVol</li>
   * <li>Schedule IM: Notional, PV (present value of the trade, including all cashflows strictly after the
   * ValuationDate)</li>
   * </ul>
   */
  private final String riskType;

  /**
   * <ul>
   * <li>All Interest Rate types: The ISO currency name, e.g., USD, EUR, SEK...</li>
   * <li>All Credit Qualifying types: ISIN. This is a representative ISIN for the issuer/seniority combination.</li>
   * <li>All Credit Non-Qualifying types: ISINs, except for Indices and asset underliers with no ISINs, which would use
   * a SIMM Crowdsourcing Utility-defined Dummy ISIN.</li>
   * <li>All Equity types: ISIN for all equities, except for Indexes, Funds and ETFs which have a user-defined string
   * description.</li>
   * <li>Risk_FX : Currency for delta, as an ISO Currency code, such as "EUR" or "CHF".</li>
   * <li>Risk_FXVol : currency pair for vega, eg "EURJPY" or "SEKCHF" for vega (two ISO currency codes).</li>
   * <li>Commodity: String description of the commodity (see Appendix 1)
   * </ul>
   */
  private final String qualifier;

  /**
   * <ul>
   * <li>Risk_IRCurve: Integer code. A value of 1 (meaning Bucket #1) corresponds to regular vol currencies, a value of
   * 2 corresponds to low-volatility currencies, and 3 corresponds to high-volatility currencies. If other categories of
   * currencies are introduced, they will be given subsequent integer codes.</li>
   * <li>Risk_Inflation, Risk_IRVol : unused</li>
   * <li>All Credit Qualifying types: Integer code from 1-12 or the string "Residual", corresponding to the SIMM buckets
   * for qualifying credit. Bucket values run from 1 (IG Sovereigns) to 12 (HY Parastatals) plus "Residual".</li>
   * <li>All Credit Non-Qualifying types: Integer code from 1-2 or the string "Residual", corresponding to the SIMM
   * buckets for non-qualifying credit. Bucket values run from 1 (IG RMBS/CMBS) to 2 (HY RMBS/CMBS) plus "Residual".
   * </li>
   * <li>All Equity types: Integer code from 1-11 or the string "Residual", corresponding to the SIMM buckets for
   * equity. Bucket values run from 1 (Large emerging-markets "Consumer, utilities") to 11 (Indexes, Funds, ETFs) plus
   * "Residual".</li>
   * <li>All Commodity types: Integer code from 1-16, corresponding to the SIMM buckets for commodity. Bucket values run
   * from 1 (Coal) to 16 (Other).</li>
   * </ul>
   */
  private final String bucket;

  /**
   * <ul>
   * <li>Risk_IRCurve and Risk_IRVol: The risk tenor T, for T in ["2w", "1m", "3m", "6m", "1y", "2y", "3y", "5y", "10y",
   * "15y", "20y", "30y"]</li>
   * <li>All credit types: The risk tenor T, for T in [ "1y", "2y", "3y", "5y", "10y"]</li>
   * <li>Risk_Equity: Unused</li>
   * <li>Risk_FX: Unused</li>
   * <li>Risk_Commodity: Unused</li>
   * <li>Risk_EquityVol, Risk_FXVol, Risk_CommodityVol: The vol-tenor (option expiry) T, for T in ["2w", "1m", "3m",
   * "6m", "1y", "2y", "3y", "5y", "10y", "15y", "20y", "30y"</li>
   * </ul>
   */
  private final String label1;

  /**
   * <ul>
   * <li>Risk_IRCurve: The subcurve name. Can be "OIS", "Libor1m", "Libor3m", "Libor6m", "Libor12m", or (for USD only)
   * "Prime".</li>
   * <li>Risk_CreditQ: the string "Sec" if the risk arises from a qualifying securitisation.</li>
   * <li>Also useful for future expansion, such as vega becoming a fully two-dimensional risk</li>
   * </ul>
   */
  private final String label2;

  /**
   * Amount of the risk, in units of a given currency
   */
  private final BigDecimal amount;

  /**
   * Currency of the "Amount" field. Should be a standard three-letter ISO currency code
   */
  private final String amountCurrency;

  /**
   * Amount of the risk, expressed in USD
   */
  private final BigDecimal amountUsd;

  // We store this as a seperate value as opposed to making a function call for use with CURVATURE type
  private final SensitivityClass sensitivityClass;

  /**
   *
   * @param productClass
   * @param riskType
   * @param qualifier
   * @param bucket
   * @param label1
   * @param label2
   * @param amount
   * @param amountCurrency
   * @param amountUsd
   */
  public Sensitivity(String productClass, String riskType, String qualifier, String bucket, String label1, String label2, BigDecimal amount, String amountCurrency, BigDecimal amountUsd) {
    this.productClass = productClass;
    this.riskType = riskType;
    this.qualifier = qualifier;
    this.bucket = bucket;
    this.label1 = label1;
    this.label2 = label2;
    this.amount = amount.stripTrailingZeros();
    this.amountCurrency = amountCurrency;
    this.amountUsd = amountUsd.stripTrailingZeros();
    this.sensitivityClass = SensitivityClass.determineByRiskType(riskType);
  }

  /**
   *
   * @param productClass
   * @param riskType
   * @param qualifier
   * @param bucket
   * @param label1
   * @param label2
   * @param amount
   * @param amountCurrency
   * @param amountUsd
   */
  public Sensitivity(String productClass, String riskType, String qualifier, String bucket, String label1, String label2, String amount, String amountCurrency, String amountUsd) {
    this.productClass = productClass;
    this.riskType = riskType;
    this.qualifier = qualifier;
    this.bucket = bucket;
    this.label1 = label1;
    this.label2 = label2;
    this.amount = new BigDecimal(amount).stripTrailingZeros();
    this.amountCurrency = amountCurrency;
    this.amountUsd = new BigDecimal(amountUsd).stripTrailingZeros();
    this.sensitivityClass = SensitivityClass.determineByRiskType(riskType);
  }

  /**
   *
   * @param productClass
   * @param riskType
   * @param qualifier
   * @param bucket
   * @param label1
   * @param label2
   * @param amount the amount in USD
   */
  public Sensitivity(String productClass, String riskType, String qualifier, String bucket, String label1, String label2, BigDecimal amount) {
    this.productClass = productClass;
    this.riskType = riskType;
    this.qualifier = qualifier;
    this.bucket = bucket;
    this.label1 = label1;
    this.label2 = label2;
    this.amount = amount.stripTrailingZeros();
    this.amountCurrency = FxRate.USD;
    this.amountUsd = amount.stripTrailingZeros();
    this.sensitivityClass = SensitivityClass.determineByRiskType(riskType);
  }

  private Sensitivity(String productClass, String riskType, String qualifier, String bucket, String label1, String label2, BigDecimal amount, SensitivityClass sensitivityClass) {
    this.productClass = productClass;
    this.riskType = riskType;
    this.qualifier = qualifier;
    this.bucket = bucket;
    this.label1 = label1;
    this.label2 = label2;
    this.amount = amount.stripTrailingZeros();
    this.amountCurrency = FxRate.USD;
    this.amountUsd = amount.stripTrailingZeros();
    this.sensitivityClass = sensitivityClass;
  }

  private Sensitivity(String riskFactorKey, BigDecimal amount) {
    String[] values = riskFactorKey.split(SensitivityUtils.DELIMITER, 7);
    this.productClass = values[0];
    this.riskType = values[1];
    this.qualifier = values[2];
    this.bucket = values[3];
    this.label1 = values[4];
    this.label2 = values[5];
    this.amount = amount.stripTrailingZeros();
    this.amountCurrency = FxRate.USD;
    this.amountUsd = amount.stripTrailingZeros();
    this.sensitivityClass = SensitivityClass.getByLabel(values[6]);
  }

  // PUBLIC BUILDERS

  public static Sensitivity fromRiskFactorKey(String riskFactorKey, BigDecimal amountUsd) {
    return new Sensitivity(riskFactorKey, amountUsd);
  }

  public static Sensitivity fromVegaToCurvature(Sensitivity s) {
    return new Sensitivity(s.getProductClass(), s.getRiskType(), s.getQualifier(), s.getBucket(), s.getLabel1(), s.getLabel2(), s.getAmountUsd(), SensitivityClass.CURVATURE);
  }

  // STRING METHODS

  @Override
  public String getRiskType() {
    return riskType;
  }

  @Override
  public String getQualifier() {
    return qualifier;
  }

  @Override
  public String getBucket() {
    return bucket;
  }

  @Override
  public String getLabel1() {
    return label1;
  }

  @Override
  public String getLabel2() {
    return label2;
  }

  public String getAmountString() {
    return amount.toPlainString();
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public String getAmountCurrency() {
    return amountCurrency;
  }

  public String getAmountUsdString() {
    return amountUsd.toPlainString();
  }

  public BigDecimal getAmountUsd() {
    return amountUsd;
  }

  @Override
  public String getProductClass() {
    return productClass;
  }

  // MAP TO CLASSES

  public SensitivityClass getSensitivityIdentifier() {
    return sensitivityClass;
  }

  public String getRiskFactorKey() {
    return determineRiskFactorKey(this);
  }

  public ProductClass getProductIdentifier() {
    return SensitivityIdentifier.getProductIdentifier(this);
  }

  public RiskClass getRiskIdentifier() {
    return SensitivityIdentifier.getRiskIdentifier(this);
  }

  public BucketClass getBucketIdentifier() {
    return SensitivityIdentifier.getBucketIdentifier(this);
  }

  public String getWeightingClassIdentifier() {
    return SensitivityIdentifier.getWeightingClassIdentifier(this);
  }

  public String getConcentrationRiskIdentifier() {
    return SensitivityIdentifier.getConcentrationRiskIdentifier(this);
  }

  /**
   *
   * @param sensitivity the sensitivity whose risk factor we want determine
   * @return a String which represents the risk factor of this sensitivity
   *    NOTE: all sensitivities with the same risk factor are netted
   */
  private static String determineRiskFactorKey(Sensitivity sensitivity) {
    String label1 = sensitivity.getLabel1();
    String qualifier = sensitivity.getQualifier();
    RiskClass riskClass = sensitivity.getRiskIdentifier();

    if (sensitivity.getSensitivityIdentifier().equals(SensitivityClass.VEGA) || sensitivity.getSensitivityIdentifier().equals(SensitivityClass.CURVATURE)) {
      // we need to sum over all of the vol-tenors for certain risk types, thus we specify label1 which holds vega vol-tenor values
      if (RiskClass.EQUITY.equals(riskClass) || //
          RiskClass.FX.equals(riskClass) || //
          RiskClass.COMMODITY.equals(riskClass) ||
          (RiskClass.INTEREST_RATE.equals(riskClass) && sensitivity.getRiskType().equals(RiskClass.RISK_TYPE_INFLATION_VOL))) {
        label1 = StringUtils.EMPTY;
      }

      // for FX Vega risk, the order of the currency pair is irrelevant, so we order alphabetically

      if (RiskClass.FX.equals(riskClass)) {
        String ccy1 = StringUtils.substring(qualifier, 0, 3);
        String ccy2 = StringUtils.substring(qualifier, 3, 6);
        qualifier = Arrays.asList(ccy1, ccy2).stream().sorted().reduce("", (s1, s2) -> s1 + s2);
      }
    }

    // Delta sensitivities have no special netting across tenors or ordering that needs to be worried about, so we just return the straight string
    return sensitivity.getProductClass() + SensitivityUtils.DELIMITER + sensitivity.getRiskType() + SensitivityUtils.DELIMITER + qualifier + SensitivityUtils.DELIMITER + sensitivity.getBucket()
        + SensitivityUtils.DELIMITER + label1 + SensitivityUtils.DELIMITER + sensitivity.getLabel2() + SensitivityUtils.DELIMITER + sensitivity.getSensitivityIdentifier().getLabel();
  }

}
