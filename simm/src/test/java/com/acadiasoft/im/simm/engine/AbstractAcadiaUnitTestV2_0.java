/*
 * Copyright (c) 2018 AcadiaSoft, Inc.
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

package com.acadiasoft.im.simm.engine;

import com.acadiasoft.im.simm.model.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by alec.stewart on 8/15/17.
 *
 * This test is designed to test the logic of a SIMM implementation using the values from ISDA-SIMM-v2.1;
 *
 */
public abstract class AbstractAcadiaUnitTestV2_0 {

  public static List<AddOnFixedAmount> ZERO_FIXED = new ArrayList<>();
  public static List<AddOnNotional> EMPTY_NOTIONALS = new ArrayList<>();
  public static List<AddOnNotionalFactor> EMPTY_FACTORS = new ArrayList<>();
  public static List<ProductMultiplier> EMPTY_MULT = new ArrayList<>();
  public static List<Sensitivity> EMPTY_LIST = new ArrayList<>();

  // DELTA

  // delta IR
  public static final Sensitivity IR1 = new Sensitivity("RatesFX", "Risk_IRCurve", "GBP", "1", "6m", "OIS", new BigDecimal("200000000"));
  public static final Sensitivity IR2 = new Sensitivity("RatesFX", "Risk_IRCurve", "GBP", "1", "2y", "OIS", new BigDecimal("300000000"));
  public static final Sensitivity IR3 = new Sensitivity("RatesFX", "Risk_IRCurve", "GBP", "1", "5y", "Libor6m", new BigDecimal("-50000000"));
  public static final Sensitivity IR4 = new Sensitivity("RatesFX", "Risk_Inflation", "GBP", "", "", "", new BigDecimal("-100000000"));
  public static final Sensitivity IR5 = new Sensitivity("RatesFX", "Risk_XCcyBasis", "GBP", "", "", "", new BigDecimal("-150000000"));
  public static final Sensitivity IR6 = new Sensitivity("RatesFX", "Risk_Inflation", "CAD", "", "", "", new BigDecimal("30000000"));
  public static final Sensitivity IR7 = new Sensitivity("RatesFX", "Risk_IRCurve", "JPY", "2", "10y", "Libor3m", new BigDecimal("90000000"));
  public static final Sensitivity IR8 = new Sensitivity("RatesFX", "Risk_IRCurve", "JPY", "2", "20y", "Libor3m", new BigDecimal("10000000"));
  public static final Sensitivity IR9 = new Sensitivity("RatesFX", "Risk_IRCurve", "INR", "3", "2w", "OIS", new BigDecimal("-20000000"));
  public static final ProductMultiplier IR10 = new ProductMultiplier("RatesFX", new BigDecimal("1.205"));

  // delta FX
  public static final Sensitivity FX1 = new Sensitivity("RatesFX", "Risk_FX", "EUR", "", "", "", new BigDecimal("100000000"));
  public static final Sensitivity FX2 = new Sensitivity("RatesFX", "Risk_FX", "EUR", "", "", "", new BigDecimal("-100000000"));
  public static final Sensitivity FX3 = new Sensitivity("RatesFX", "Risk_FX", "NOK", "", "", "", new BigDecimal("2000000000"));
  public static final Sensitivity FX4 = new Sensitivity("RatesFX", "Risk_FX", "MUD", "", "", "", new BigDecimal("600000000")); // MUD = Made Up Dollars -> Category 3

  // delta EQ
  // NOTE: ISIN given for sensitivities do not follow correct format
  public static final Sensitivity EQ1 = new Sensitivity("Equity", "Risk_Equity", "ISIN:21", "2", "", "", new BigDecimal("2000000"));
  public static final Sensitivity EQ2 = new Sensitivity("Equity", "Risk_Equity", "ISIN:22", "2", "", "", new BigDecimal("5000000"));
  public static final Sensitivity EQ3 = new Sensitivity("Equity", "Risk_Equity", "ISIN:51", "5", "", "", new BigDecimal("-10000000"));
  public static final Sensitivity EQ4 = new Sensitivity("Equity", "Risk_Equity", "ISIN:52", "5", "", "", new BigDecimal("33000000"));
  public static final Sensitivity EQ5 = new Sensitivity("Equity", "Risk_Equity", "ISIN:53", "5", "", "", new BigDecimal("5000000"));
  public static final Sensitivity EQ6 = new Sensitivity("Equity", "Risk_Equity", "ISIN:91", "9", "", "", new BigDecimal("1000000"));
  public static final Sensitivity EQ7 = new Sensitivity("Equity", "Risk_Equity", "ISIN:101", "10", "", "", new BigDecimal("500000"));
  public static final Sensitivity EQ8 = new Sensitivity("Equity", "Risk_Equity", "ISIN:102", "10", "", "", new BigDecimal("-1500000"));
  public static final Sensitivity EQ9 = new Sensitivity("Equity", "Risk_Equity", "LEX", "11", "", "", new BigDecimal("6000000"));
  public static final Sensitivity EQ10 = new Sensitivity("Equity", "Risk_Equity", "ISIN:R1", "Residual", "", "", new BigDecimal("-750000"));
  public static final Sensitivity EQ11 = new Sensitivity("Equity", "Risk_Equity", "ISIN:R2", "Residual", "", "", new BigDecimal("560000"));
  public static final ProductMultiplier EQ12 = new ProductMultiplier("Equity", new BigDecimal("1.015"));

  // delta CQ
  // NOTE: ISIN given for sensitivities do not follow correct format
  public static final Sensitivity CQ1 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:11", "1", "2y", "", new BigDecimal("1000000"));
  public static final Sensitivity CQ2 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:11", "1", "5y", "EUR", new BigDecimal("-15000000"));
  public static final Sensitivity CQ3 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:11", "1", "3y", "", new BigDecimal("14500000"));
  public static final Sensitivity CQ4 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:12", "1", "10y", "", new BigDecimal("4000000"));
  public static final Sensitivity CQ5 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:41", "4", "1y", "Sec,NOK", new BigDecimal("-6500000"));
  public static final Sensitivity CQ6 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:42", "4", "1y", "", new BigDecimal("2000000"));
  public static final Sensitivity CQ7 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:71", "7", "2y", "", new BigDecimal("-1000000"));
  public static final Sensitivity CQ8 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:71", "7", "3y", "", new BigDecimal("1500000"));
  public static final Sensitivity CQ9 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:72", "7", "1y", "", new BigDecimal("-1200000"));
  public static final Sensitivity CQ10 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:73", "7", "2y", "", new BigDecimal("3300000"));
  public static final Sensitivity CQ11 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:111", "11", "2y", "USD", new BigDecimal("10000000"));
  public static final Sensitivity CQ12 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:111", "11", "10y", "", new BigDecimal("-4750000"));
  public static final Sensitivity CQ13 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:111", "11", "3y", "", new BigDecimal("-5000000"));
  public static final Sensitivity CQ14 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:R1", "Residual", "2y", "", new BigDecimal("4000000"));
  public static final Sensitivity CQ15 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:R2", "Residual", "10y", "", new BigDecimal("-3000000"));
  public static final ProductMultiplier CQ16 = new ProductMultiplier("Credit", new BigDecimal("1.110"));

  // base Corr
  public static final Sensitivity BC1 = new Sensitivity("Credit", "Risk_BaseCorr", "CDX HY", "", "", "", new BigDecimal("2000000"));
  public static final Sensitivity BC2 = new Sensitivity("Credit", "Risk_BaseCorr", "CDX HY", "", "", "", new BigDecimal("-3000000"));
  public static final Sensitivity BC3 = new Sensitivity("Credit", "Risk_BaseCorr", "iTraxx XO", "", "", "", new BigDecimal("4500000"));
  public static final Sensitivity BC4 = new Sensitivity("Credit", "Risk_BaseCorr", "CDX IG", "", "", "", new BigDecimal("1000000"));

  // delta CNQ
  // NOTE: ISIN given for sensitivities do not follow correct format
  public static final Sensitivity CNQ1 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:11", "1", "3y", "", new BigDecimal("3000000"));
  public static final Sensitivity CNQ2 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:11", "1", "5y", "", new BigDecimal("7000000"));
  public static final Sensitivity CNQ3 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:12", "1", "2y", "", new BigDecimal("-5000000"));
  public static final Sensitivity CNQ4 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:21", "2", "1y", "", new BigDecimal("-2200000"));
  public static final Sensitivity CNQ5 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:21", "2", "10y", "", new BigDecimal("2000000"));
  public static final Sensitivity CNQ6 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:22", "2", "2y", "", new BigDecimal("8000000"));
  public static final Sensitivity CNQ7 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:R1", "Residual", "5y", "", new BigDecimal("3000000"));
  public static final Sensitivity CNQ8 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:R2", "Residual", "3y", "", new BigDecimal("-2700000"));

  // delta CM
  public static final Sensitivity CM1 = new Sensitivity("Commodity", "Risk_Commodity", "Coal Americas", "1", "", "", new BigDecimal("30000000"));
  public static final Sensitivity CM2 = new Sensitivity("Commodity", "Risk_Commodity", "Coal Europe", "1", "", "", new BigDecimal("-50000000"));
  public static final Sensitivity CM3 = new Sensitivity("Commodity", "Risk_Commodity", "Middle Distillates America", "3", "", "", new BigDecimal("150000000"));
  public static final Sensitivity CM4 = new Sensitivity("Commodity", "Risk_Commodity", "Middle Distillates Europe", "3", "", "", new BigDecimal("-200000000"));
  public static final Sensitivity CM5 = new Sensitivity("Commodity", "Risk_Commodity", "Middle Distillates Asia", "3", "", "", new BigDecimal("320000000"));
  public static final Sensitivity CM6 = new Sensitivity("Commodity", "Risk_Commodity", "NA Natural Gas Gulf Coast", "6", "", "", new BigDecimal("65000000"));
  public static final Sensitivity CM7 = new Sensitivity("Commodity", "Risk_Commodity", "NA Natural Gas West", "6", "", "", new BigDecimal("40000000"));
  public static final Sensitivity CM8 = new Sensitivity("Commodity", "Risk_Commodity", "Freight Wet", "10", "", "", new BigDecimal("350000000"));
  public static final Sensitivity CM9 = new Sensitivity("Commodity", "Risk_Commodity", "Freight Dry", "10", "", "", new BigDecimal("-100000000"));
  public static final Sensitivity CM10 = new Sensitivity("Commodity", "Risk_Commodity", "Softs Coffee", "14", "", "", new BigDecimal("25000000"));
  public static final Sensitivity CM11 = new Sensitivity("Commodity", "Risk_Commodity", "Livestock Feeder Cattle", "15", "", "", new BigDecimal("-12000000"));
  public static final ProductMultiplier CM12 = new ProductMultiplier("Commodity", new BigDecimal("1.075"));

  // VEGA
  // NOTE: vega sensitivities use the same correlation parameters as delta sensitivities, so we mostly test vega netting, weighting, CR, and Curvature

  // vega IR
  public static final Sensitivity IRV1 = new Sensitivity("RatesFX", "Risk_IRVol", "USD", "", "3m", "", new BigDecimal("200000000"));
  public static final Sensitivity IRV2 = new Sensitivity("RatesFX", "Risk_IRVol", "USD", "", "1y", "", new BigDecimal("-300000000"));
  public static final Sensitivity IRV3 = new Sensitivity("RatesFX", "Risk_IRVol", "AUD", "", "2w", "", new BigDecimal("-130000000"));
  public static final Sensitivity IRV4 = new Sensitivity("RatesFX", "Risk_IRVol", "AUD", "", "2y", "", new BigDecimal("-25000000"));
  public static final Sensitivity IRV5 = new Sensitivity("RatesFX", "Risk_InflationVol", "EUR", "", "5y", "", new BigDecimal("150000000"));
  public static final Sensitivity IRV6 = new Sensitivity("RatesFX", "Risk_InflationVol", "EUR", "", "15y", "", new BigDecimal("-500000000"));
  public static final Sensitivity IRV7 = new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "20y", "", new BigDecimal("1000000000"));

  // from testing
  public static final List<Sensitivity> inflationVolList = Arrays.asList(
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "5y", "", new BigDecimal("5687.251945")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "2w", "", new BigDecimal("410.67134")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "3y", "", new BigDecimal("-47258.09176")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "2y", "", new BigDecimal("-34260.68011")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "1y", "", new BigDecimal("-36256.27163")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "15y", "", new BigDecimal("-117775.0435")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "6m", "", new BigDecimal("110205.6657")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "3m", "", new BigDecimal("5102.794094")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "10y", "", new BigDecimal("5323.464042")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "20y", "", new BigDecimal("5056.374028")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "1m", "", new BigDecimal("-1487.937605")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "30y", "", new BigDecimal("-88375.06124")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "5y", "", new BigDecimal("-88375.06126")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "2w", "", new BigDecimal("85913.91739")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "3y", "", new BigDecimal("25501.60343")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "2y", "", new BigDecimal("25501.60343")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "1y", "", new BigDecimal("-24729.72539")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "15y", "", new BigDecimal("-129883.7768")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "6m", "", new BigDecimal("-113893.4975")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "3m", "", new BigDecimal("-243777.2743")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "10y", "", new BigDecimal("253045.7143")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "20y", "", new BigDecimal("21318.1755")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "1m", "", new BigDecimal("-92.355294")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "30y", "", new BigDecimal("21260.91507")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "5y", "", new BigDecimal("-22133.94701")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "2w", "", new BigDecimal("-307881.3501")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "3y", "", new BigDecimal("-307881.3501")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "2y", "", new BigDecimal("306107.5491")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "1y", "", new BigDecimal("-19727.94507")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "15y", "", new BigDecimal("-19727.94507")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "6m", "", new BigDecimal("18211.83161")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "3m", "", new BigDecimal("602.096682")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "10y", "", new BigDecimal("682.590887")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "20y", "", new BigDecimal("402.263058")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "1m", "", new BigDecimal("402.263058")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "30y", "", new BigDecimal("120.678917")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "5y", "", new BigDecimal("80.452612")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "2w", "", new BigDecimal("120.678917")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "3y", "", new BigDecimal("120.678917")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "2y", "", new BigDecimal("120.678917")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "1y", "", new BigDecimal("7.002699")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "15y", "", new BigDecimal("-224.859502")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "6m", "", new BigDecimal("12734.76742")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "3m", "", new BigDecimal("-1343.345449")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "10y", "", new BigDecimal("12015.63587")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "20y", "", new BigDecimal("-57.220803")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "1m", "", new BigDecimal("-1170.364712")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "30y", "", new BigDecimal("-4.646183")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "5y", "", new BigDecimal("2204.798143")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "2w", "", new BigDecimal("-27.047195")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "3y", "", new BigDecimal("-12886.92476")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "2y", "", new BigDecimal("-11948.89761")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "1y", "", new BigDecimal("43.530867")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "15y", "", new BigDecimal("-5.083303")),
    new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "6m", "", new BigDecimal("-2189.046155"))
  );

  // vega FX
  public static final Sensitivity FXV1 = new Sensitivity("RatesFX", "Risk_FXVol", "USDEUR", "", "6m", "", new BigDecimal("25000000"));
  public static final Sensitivity FXV2 = new Sensitivity("RatesFX", "Risk_FXVol", "EURUSD", "", "3y", "", new BigDecimal("85000000"));
  public static final Sensitivity FXV3 = new Sensitivity("RatesFX", "Risk_FXVol", "USDEUR", "", "20y", "", new BigDecimal("-100000000"));
  public static final Sensitivity FXV4 = new Sensitivity("RatesFX", "Risk_FXVol", "BRLCNY", "", "2y", "", new BigDecimal("65000000"));
  public static final Sensitivity FXV5 = new Sensitivity("RatesFX", "Risk_FXVol", "JPYSGD", "", "6m", "", new BigDecimal("-25000000"));

  // vega EQ
  // NOTE: ISIN given for sensitivities do not follow correct format
  public static final Sensitivity EQV1 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:11", "1", "5y", "", new BigDecimal("20000000"));
  public static final Sensitivity EQV2 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:11", "1", "2y", "", new BigDecimal("-18000000"));
  public static final Sensitivity EQV3 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:11", "1", "2w", "", new BigDecimal("60000000"));
  public static final Sensitivity EQV4 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:41", "4", "3y", "", new BigDecimal("50000000"));
  public static final Sensitivity EQV5 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:42", "4", "10y", "", new BigDecimal("-45000000"));
  public static final Sensitivity EQV6 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:71", "7", "20y", "", new BigDecimal("-27000000"));
  public static final Sensitivity EQV7 = new Sensitivity("Equity", "Risk_EquityVol", "VIX", "12", "15y", "", new BigDecimal("-15000000"));
  public static final Sensitivity EQV8 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:R1", "Residual", "6m", "", new BigDecimal("30000000"));
  public static final Sensitivity EQV9 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:R1", "Residual", "1m", "", new BigDecimal("-32000000"));
  public static final Sensitivity EQV10 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:R2", "Residual", "3m", "", new BigDecimal("44000000"));

  // vega CQ
  public static final Sensitivity CQV1 = new Sensitivity("Credit", "Risk_CreditVol", "EU.IG", "Residual", "2w", "", new BigDecimal("15000000"));
  public static final Sensitivity CQV2 = new Sensitivity("Credit", "Risk_CreditVol", "EU.IG", "Residual", "2y", "", new BigDecimal("30000000"));
  public static final Sensitivity CQV3 = new Sensitivity("Credit", "Risk_CreditVol", "EU.IG", "Residual", "2y", "", new BigDecimal("-20000000"));
  public static final Sensitivity CQV4 = new Sensitivity("Credit", "Risk_CreditVol", "EU.HY", "Residual", "3m", "", new BigDecimal("-40000000"));
  public static final Sensitivity CQV5 = new Sensitivity("Credit", "Risk_CreditVol", "US.HY", "Residual", "10y", "", new BigDecimal("35000000"));
  public static final Sensitivity CQV6 = new Sensitivity("Credit", "Risk_CreditVol", "US.XX", "1", "5y", "", new BigDecimal("20000000"));
  public static final Sensitivity CQV7 = new Sensitivity("Credit", "Risk_CreditVol", "CN.HY", "2", "6m", "", new BigDecimal("-50000000"));

  // vega CNQ
  public static final Sensitivity CNQV1 = new Sensitivity("Credit", "Risk_CreditVol", "EU.IG", "Residual", "2m", "", new BigDecimal("-23000000"));
  public static final Sensitivity CNQV2 = new Sensitivity("Credit", "Risk_CreditVol", "EU.IG", "Residual", "3y", "", new BigDecimal("40000000"));
  public static final Sensitivity CNQV3 = new Sensitivity("Credit", "Risk_CreditVol", "EU.IG", "Residual", "1y", "", new BigDecimal("-35000000"));
  public static final Sensitivity CNQV4 = new Sensitivity("Credit", "Risk_CreditVol", "EU.HY", "Residual", "3m", "", new BigDecimal("12000000"));
  public static final Sensitivity CNQV5 = new Sensitivity("Credit", "Risk_CreditVol", "US.HY", "Residual", "15y", "", new BigDecimal("-26000000"));
  public static final Sensitivity CNQV6 = new Sensitivity("Credit", "Risk_CreditVol", "US.XX", "1", "20y", "", new BigDecimal("24000000"));
  public static final Sensitivity CNQV7 = new Sensitivity("Credit", "Risk_CreditVol", "CN.HY", "2", "6m", "", new BigDecimal("-37000000"));

  // vega CM
  public static final Sensitivity CMV1 = new Sensitivity("Commodity", "Risk_CommodityVol", "Precious Metals Silver", "12", "2w", "", new BigDecimal("35000000"));
  public static final Sensitivity CMV2 = new Sensitivity("Commodity", "Risk_CommodityVol", "Precious Metals Silver", "12", "5y", "", new BigDecimal("-32000000"));
  public static final Sensitivity CMV3 = new Sensitivity("Commodity", "Risk_CommodityVol", "Precious Metals Gold", "12", "6m", "", new BigDecimal("15000000"));
  public static final Sensitivity CMV4 = new Sensitivity("Commodity", "Risk_CommodityVol", "EU Power Germany", "9", "1y", "", new BigDecimal("10000000"));
  public static final Sensitivity CMV5 = new Sensitivity("Commodity", "Risk_CommodityVol", "EU Power Germany", "9", "2w", "", new BigDecimal("45000000"));
  public static final Sensitivity CMV6 = new Sensitivity("Commodity", "Risk_CommodityVol", "Crude Oil Americas", "2", "15y", "", new BigDecimal("-15000000"));

  // addOn
  public static final AddOnNotionalFactor AN1 = new AddOnNotionalFactor("ProductOne", new BigDecimal("6.105"));
  public static final AddOnNotionalFactor AN2 = new AddOnNotionalFactor("ProductTwo", new BigDecimal("2.055"));
  public static final AddOnNotional AN3 = new AddOnNotional("ProductOne", new BigDecimal("10000000"));
  public static final AddOnNotional AN4 = new AddOnNotional("ProductOne", new BigDecimal("-20000000"));
  public static final AddOnNotional AN5 = new AddOnNotional("ProductOne", new BigDecimal("15000000"));
  public static final AddOnNotional AN6 = new AddOnNotional("ProductTwo", new BigDecimal("-8000000"));
  public static final AddOnNotional AN7 = new AddOnNotional("ProductTwo", new BigDecimal("-22000000"));
  public static final AddOnNotional AN8 = new AddOnNotional("ProductThree", new BigDecimal("6000000"));
  public static final AddOnNotional AN9 = new AddOnNotional("ProductFour", new BigDecimal("13000000"));
  public static final AddOnFixedAmount AN10 = new AddOnFixedAmount(new BigDecimal("16500000"));
  public static final AddOnFixedAmount AN11 = new AddOnFixedAmount(new BigDecimal("20000000"));

  // S_CRQ
  public static final Sensitivity S_CRQ_1 = new Sensitivity("Credit", "Risk_CreditQ",  "ISIN:BE0934259525", "1", "1y", "USD", new BigDecimal("800000"));
  public static final Sensitivity S_CRQ_1t = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:BE0934259525", "1", "2y", "USD", new BigDecimal("800000"));
  public static final Sensitivity S_CRQ_2 = new Sensitivity("Credit", "Risk_CreditQ",  "ISIN:BE0934259525", "1", "2y", "USD", new BigDecimal("-300000"));
  public static final Sensitivity S_CRQ_3 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CA112585AG91", "2", "2y", "USD", new BigDecimal("200000"));
  public static final Sensitivity S_CRQ_4 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CA112585AG91", "2", "2y", "EUR", new BigDecimal("-200000"));
  public static final Sensitivity S_CRQ_5 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CA82028KAP62", "3", "3y", "GBP", new BigDecimal("200000"));
  public static final Sensitivity S_CRQ_6 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CA82028KAP62", "3", "5y", "JPY", new BigDecimal("-100000"));
  public static final Sensitivity S_CRQ_7 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:FR0000108359", "4", "5y", "USD", new BigDecimal("200000"));
  public static final Sensitivity S_CRQ_8 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:FR0000108359", "4", "5y", "USD", new BigDecimal("-100000"));
  public static final Sensitivity S_CRQ_9 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CH0010519475", "5", "10y", "USD", new BigDecimal("200000"));
  public static final Sensitivity S_CRQ_10 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CH9823105801", "5", "1y", "USD", new BigDecimal("-100000"));
  public static final Sensitivity S_CRQ_11 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:DE4830528795", "6", "2y", "EUR", new BigDecimal("200000"));
  public static final Sensitivity S_CRQ_12 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:GB0862147969", "7", "3y", "GBP", new BigDecimal("-600000"));
  public static final Sensitivity S_CRQ_13 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CA6515779866", "8", "5y", "USD", new BigDecimal("-100000"));
  public static final Sensitivity S_CRQ_14 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:FR0003335977", "9", "10y", "USD", new BigDecimal("200000"));
  public static final Sensitivity S_CRQ_15 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CA2201568701", "10", "1y", "USD", new BigDecimal("-100000"));
  public static final Sensitivity S_CRQ_16 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CA6130123456", "11", "2y", "USD", new BigDecimal("200000"));
  public static final Sensitivity S_CRQ_17 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:FR0002226543", "12", "3y", "USD", new BigDecimal("-100000"));
  public static final Sensitivity S_CRQ_18 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:UNKNOWN1", "Residual", "1y", "USD", new BigDecimal("200000"));
  public static final Sensitivity S_CRQ_19 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:UNKNOWN1", "Residual", "3y", "USD", new BigDecimal("-100000"));
  public static final Sensitivity S_CRQ_20 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:UNKNOWN2", "Residual", "3y", "EUR", new BigDecimal("200000"));
  public static final Sensitivity S_CRQ_21 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:UNKNOWN3", "Residual", "5y", "USD", new BigDecimal("200000"));
  public static final Sensitivity S_CRQ_22 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:UNKNOWN3", "Residual", "10y", "GBP", new BigDecimal("-100000"));
  public static final Sensitivity S_CRQ_23 = new Sensitivity("Credit", "Risk_BaseCorr", "CDX IG", "", "", "", new BigDecimal("500000"));
  public static final Sensitivity S_CRQ_24 = new Sensitivity("Credit", "Risk_BaseCorr", "CDX IG", "", "", "", new BigDecimal("-200000"));
  public static final Sensitivity S_CRQ_25 = new Sensitivity("Credit", "Risk_BaseCorr", "iTraxx Main", "", "", "", new BigDecimal("400000"));

}
