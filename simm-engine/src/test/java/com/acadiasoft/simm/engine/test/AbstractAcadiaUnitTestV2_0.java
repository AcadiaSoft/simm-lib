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

package com.acadiasoft.simm.engine.test;

import com.acadiasoft.simm.model.addon.AddOnFixedAmount;
import com.acadiasoft.simm.model.addon.AddOnNotional;
import com.acadiasoft.simm.model.addon.AddOnNotionalFactor;
import com.acadiasoft.simm.model.product.ProductClass;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import com.acadiasoft.simm.model.addon.ProductMultiplier;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alec.stewart on 8/15/17.
 * <p>
 * This test is designed to test the logic of a SIMM implementation using the values from ISDA-SIMM-v1.3.38;
 * as such, the tests do not provide full coverage of the parameter values.
 */
public abstract class AbstractAcadiaUnitTestV2_0 {

  public static AddOnFixedAmount ZERO_FIXED = new AddOnFixedAmount(BigDecimal.ZERO);
  public static Map<String, AddOnNotionalFactor> EMPTY_FACTORS = new HashMap<>();
  public static Map<String, List<AddOnNotional>> EMPTY_NOTIONALS = new HashMap<>();
  public static Map<ProductClass, ProductMultiplier> EMPTY_MULT = new HashMap<>();
  public static List<Sensitivity> EMPTY_LIST = Arrays.asList();

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
  public static final Sensitivity FX1 = new Sensitivity("RatesFX", "Risk_FX", "USD", "", "", "", new BigDecimal("100000000"));
  public static final Sensitivity FX2 = new Sensitivity("RatesFX", "Risk_FX", "USD", "", "", "", new BigDecimal("-100000000"));
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

}
