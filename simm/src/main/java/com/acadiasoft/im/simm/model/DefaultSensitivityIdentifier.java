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

package com.acadiasoft.im.simm.model;

import com.acadiasoft.im.base.model.imtree.identifiers.SingleClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnSubType;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.SensitivityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class DefaultSensitivityIdentifier extends SingleClass implements SensitivityIdentifier {

  private static final String CALLED_SENSI_CLASS_FOR_ADD_ON = "Called for sensitivity class identifier when the sensitivity was an add on type: [%s]";
  private static final String CALLED_RISK_TYPE_FOR_ADD_ON = "Called for risk class identifier when the sensitivity was an add on type: [%s]";

  private final String tradeId;

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
  protected final String productClass;

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
  protected final String riskType;

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
  protected final String qualifier;

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
  protected final String bucket;

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
  protected final String label1;

  /**
   * <ul>
   * <li>Risk_IRCurve: The subcurve name. Can be "OIS", "Libor1m", "Libor3m", "Libor6m", "Libor12m", or (for USD only)
   * "Prime".</li>
   * <li>Risk_CreditQ: the string "Sec" if the risk arises from a qualifying securitisation.</li>
   * <li>Also useful for future expansion, such as vega becoming a fully two-dimensional risk</li>
   * </ul>
   */
  protected final String label2;

  /**
   * The sensitivity class
   *
   * We store this as a separate value as opposed to making a function call for use with CURVATURE type
   */
  protected final SensitivityClass sensitivityClass;

  /**
   * The risk class
   *
   * We store this separately so that we can get the risk class for concentration risk groups
   */
  protected final RiskClass riskClass;

  public DefaultSensitivityIdentifier(SensitivityIdentifier id) {
    super(id.getQualifier());
    this.tradeId = id.getTradeId();
    this.productClass = id.getProductClass();
    this.riskType = id.getRiskType();
    this.qualifier = id.getQualifier();
    this.bucket = id.getBucket();
    this.label1 = id.getLabel1();
    this.label2 = id.getLabel2();
    this.sensitivityClass = id.getSensitivityClass();
    this.riskClass = id.getRiskIdentifier();
  }

  public DefaultSensitivityIdentifier(String tradeId, String productClass, String riskType, String qualifier, String bucket,
                                      String label1, String label2, SensitivityClass sensitivityClass, RiskClass riskClass) {
    super(qualifier);
    this.tradeId = tradeId;
    this.productClass = productClass;
    this.riskType = riskType;
    this.qualifier = qualifier;
    this.bucket = bucket;
    this.label1 = label1;
    this.label2 = label2;
    this.sensitivityClass = sensitivityClass;
    this.riskClass = riskClass;
  }

  @Override
  public String getTradeId() {
    return tradeId;
  }

  @Override
  public String getProductClass() {
    return productClass;
  }

  @Override
  public String getRiskType() {
    return riskType;
  }

  @Override
  public String getQualifier() {
    if (isSimmStandard() && riskClass.equals(RiskClass.FX)
      && (sensitivityClass.equals(SensitivityClass.VEGA) || sensitivityClass.equals(SensitivityClass.CURVATURE))) {
      return normalizeFxVegaQualifier(qualifier);
    } else {
      return qualifier;
    }
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

  @Override
  public SensitivityClass getSensitivityClass() {
    if (AddOnSubType.isAddOnSubType(riskType)) {
      throw new IllegalStateException(String.format(CALLED_SENSI_CLASS_FOR_ADD_ON, riskType));
    } else {
      return sensitivityClass;
    }
  }

  @Override
  public RiskClass getRiskIdentifier() {
    if (AddOnSubType.isAddOnSubType(riskType)) {
      throw new IllegalStateException(String.format(CALLED_RISK_TYPE_FOR_ADD_ON, riskType));
    } else {
      return riskClass;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof SensitivityIdentifier)) {
      return false;
    } else {
      SensitivityIdentifier other = (SensitivityIdentifier) obj;
      return StringUtils.equalsIgnoreCase(tradeId, other.getTradeId())
        && StringUtils.equalsIgnoreCase(productClass, other.getProductClass())
        && StringUtils.equalsIgnoreCase(riskType, other.getRiskType())
        && StringUtils.equalsIgnoreCase(qualifier, other.getQualifier())
        && StringUtils.equalsIgnoreCase(bucket, other.getBucket())
        && StringUtils.equalsIgnoreCase(label1, other.getLabel1())
        && StringUtils.equalsIgnoreCase(label2, other.getLabel2())
        && Objects.equals(sensitivityClass, other.getSensitivityClass())
        && Objects.equals(riskClass, other.getRiskIdentifier());
    }
  }

  @Override
  public int hashCode() {
    int prime = 7;
    int result = Objects.hashCode(productClass) + Objects.hashCode(riskType) + Objects.hashCode(qualifier);
    result = prime * result + Objects.hashCode(bucket) + Objects.hashCode(label1) + Objects.hashCode(label2);
    return prime * result + Objects.hashCode(sensitivityClass) + Objects.hashCode(riskClass);
  }

  private static final String TO_STRING = "(%s, %s, %s, %s, %s, %s, %s, %s, %s)";

  @Override
  public String toString() {
    return String.format(TO_STRING, tradeId, productClass, riskClass, riskType,
      qualifier, bucket, label1, label2, sensitivityClass);
  }
}
