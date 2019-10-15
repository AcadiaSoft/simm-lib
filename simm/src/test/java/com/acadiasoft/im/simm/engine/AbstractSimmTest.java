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

package com.acadiasoft.im.simm.engine;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.simm.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class AbstractSimmTest {

  @SuppressWarnings("unchecked")
  static <T> List<T> addAnything(List<T> list, Object... objects) {
    Stream.of(objects).forEach(obj -> {
      if (obj instanceof Collection) {
        list.addAll((Collection<T>) obj);
      } else {
        list.add((T) obj);
      }
    });
    return list;
  }

  @Test
  public void testAddAnythingWorks() {
    List<Sensitivity> list = new ArrayList<>();
    addAnything(list, S_IR_1, Arrays.asList(S_IR_2, S_IR_3), S_IR_4);
    Assert.assertEquals(4, list.size());
  }

  static final Sensitivity S_IR_1 = new Sensitivity("RatesFX", "Risk_IRCurve", "USD", "1", "2w", "OIS", "4000000", FxRate.USD, "4000000");
  static final Sensitivity S_IR_2 = new Sensitivity("RatesFX", "Risk_IRCurve", "USD", "1", "3m", "Municipal", "-3000000", FxRate.USD, "-3000000");
  static final Sensitivity S_IR_3 = new Sensitivity("RatesFX", "Risk_IRCurve", "USD", "1", "1y", "Municipal", "2000000", FxRate.USD, "2000000");
  static final Sensitivity S_IR_4 = new Sensitivity("RatesFX", "Risk_IRCurve", "USD", "1", "1y", "Prime", "3000000", FxRate.USD, "3000000");
  static final Sensitivity S_IR_5 = new Sensitivity("RatesFX", "Risk_IRCurve", "USD", "1", "1y", "Prime", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_IR_6 = new Sensitivity("RatesFX", "Risk_IRCurve", "EUR", "1", "3y", "Libor3m", "-2000000", FxRate.USD, "-2000000");
  static final Sensitivity S_IR_7 = new Sensitivity("RatesFX", "Risk_IRCurve", "EUR", "1", "3y", "Libor6m", "5000000", FxRate.USD, "5000000");
  static final Sensitivity S_IR_8 = new Sensitivity("RatesFX", "Risk_IRCurve", "EUR", "1", "5y", "Libor12m", "10000000", FxRate.USD, "10000000");
  static final Sensitivity S_IR_9 = new Sensitivity("RatesFX", "Risk_IRCurve", "EUR", "1", "5y", "Libor12m", "25000000", FxRate.USD, "25000000");
  static final Sensitivity S_IR_10 = new Sensitivity("RatesFX", "Risk_IRCurve", "EUR", "1", "10y", "Libor12m", "35000000", FxRate.USD, "35000000");
  static final Sensitivity S_IR_11 = new Sensitivity("RatesFX", "Risk_IRCurve", "AUD", "1", "1m", "Libor3m", "2000000", FxRate.USD, "2000000");
  static final Sensitivity S_IR_12 = new Sensitivity("RatesFX", "Risk_IRCurve", "AUD", "1", "6m", "Libor3m", "3000000", FxRate.USD, "3000000");
  static final Sensitivity S_IR_13 = new Sensitivity("RatesFX", "Risk_IRCurve", "AUD", "1", "2y", "Libor3m", "-2000000", FxRate.USD, "-2000000");
  static final Sensitivity S_IR_14 = new Sensitivity("RatesFX", "Risk_IRCurve", "CHF", "1", "15y", "Libor6m", "-4000000", FxRate.USD, "-4000000");
  static final Sensitivity S_IR_15 = new Sensitivity("RatesFX", "Risk_IRCurve", "CHF", "1", "20y", "Libor6m", "10000000", FxRate.USD, "10000000");
  static final Sensitivity S_IR_16 = new Sensitivity("RatesFX", "Risk_IRCurve", "CHF", "1", "30y", "Libor6m", "8000000", FxRate.USD, "8000000");
  static final Sensitivity S_IR_17 = new Sensitivity("RatesFX", "Risk_Inflation", "CHF", "", "", "", "-10000000", FxRate.USD, "-10000000");
  static final Sensitivity S_IR_18 = new Sensitivity("RatesFX", "Risk_XCcyBasis", "CHF", "", "", "", "30000000", FxRate.USD, "30000000");
  static final Sensitivity S_IR_19 = new Sensitivity("RatesFX", "Risk_IRCurve", "JPY", "2", "2w", "Libor1m", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_IR_20 = new Sensitivity("RatesFX", "Risk_IRCurve", "JPY", "2", "1m", "Libor1m", "-1500000", FxRate.USD, "-1500000");
  static final Sensitivity S_IR_21 = new Sensitivity("RatesFX", "Risk_IRCurve", "JPY", "2", "3m", "Libor3m", "1500000", FxRate.USD, "1500000");
  static final Sensitivity S_IR_22 = new Sensitivity("RatesFX", "Risk_IRCurve", "JPY", "2", "6m", "Libor3m", "2000000", FxRate.USD, "2000000");
  static final Sensitivity S_IR_23 = new Sensitivity("RatesFX", "Risk_IRCurve", "JPY", "2", "1y", "Libor6m", "3000000", FxRate.USD, "3000000");
  static final Sensitivity S_IR_24 = new Sensitivity("RatesFX", "Risk_IRCurve", "JPY", "2", "2y", "Libor6m", "4000000", FxRate.USD, "4000000");
  static final Sensitivity S_IR_25 = new Sensitivity("RatesFX", "Risk_IRCurve", "JPY", "2", "3y", "Libor6m", "5000000", FxRate.USD, "5000000");
  static final Sensitivity S_IR_26 = new Sensitivity("RatesFX", "Risk_IRCurve", "JPY", "2", "5y", "Libor12m", "20000000", FxRate.USD, "20000000");
  static final Sensitivity S_IR_27 = new Sensitivity("RatesFX", "Risk_IRCurve", "JPY", "2", "10y", "Libor12m", "50000000", FxRate.USD, "50000000");
  static final Sensitivity S_IR_28 = new Sensitivity("RatesFX", "Risk_IRCurve", "JPY", "2", "15y", "Libor12m", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_IR_29 = new Sensitivity("RatesFX", "Risk_IRCurve", "JPY", "2", "20y", "Libor12m", "-2000000", FxRate.USD, "-2000000");
  static final Sensitivity S_IR_30 = new Sensitivity("RatesFX", "Risk_IRCurve", "JPY", "2", "30y", "Libor12m", "3000000", FxRate.USD, "3000000");
  static final Sensitivity S_IR_31 = new Sensitivity("RatesFX", "Risk_Inflation", "JPY", "", "", "", "15000000", FxRate.USD, "15000000");
  static final Sensitivity S_IR_32 = new Sensitivity("RatesFX", "Risk_XCcyBasis", "JPY", "", "", "", "500000", FxRate.USD, "500000");
  static final Sensitivity S_IR_33 = new Sensitivity("RatesFX", "Risk_IRCurve", "CNY", "3", "2w", "OIS", "1000000", FxRate.USD, "1000000");
  static final Sensitivity S_IR_34 = new Sensitivity("RatesFX", "Risk_IRCurve", "CNY", "3", "1m", "OIS", "1500000", FxRate.USD, "1500000");
  static final Sensitivity S_IR_35 = new Sensitivity("RatesFX", "Risk_IRCurve", "CNY", "3", "3m", "Libor1m", "-500000", FxRate.USD, "-500000");
  static final Sensitivity S_IR_36 = new Sensitivity("RatesFX", "Risk_IRCurve", "CNY", "3", "6m", "Libor3m", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_IR_37 = new Sensitivity("RatesFX", "Risk_IRCurve", "MXN", "3", "1y", "Libor6m", "3000000", FxRate.USD, "3000000");
  static final Sensitivity S_IR_38 = new Sensitivity("RatesFX", "Risk_IRCurve", "MXN", "3", "2y", "Libor12m", "6000000", FxRate.USD, "6000000");
  static final Sensitivity S_IR_39 = new Sensitivity("RatesFX", "Risk_IRCurve", "MXN", "3", "3y", "OIS", "-500000", FxRate.USD, "-500000");
  static final Sensitivity S_IR_40 = new Sensitivity("RatesFX", "Risk_IRCurve", "MXN", "3", "5y", "OIS", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_IR_41 = new Sensitivity("Credit", "Risk_IRCurve", "BRL", "3", "10y", "Libor6m", "4000000", FxRate.USD, "4000000");
  static final Sensitivity S_IR_42 = new Sensitivity("Credit", "Risk_IRCurve", "BRL", "3", "15y", "Libor6m", "6000000", FxRate.USD, "6000000");
  static final Sensitivity S_IR_43 = new Sensitivity("Credit", "Risk_IRCurve", "BRL", "3", "20y", "Libor12m", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_IR_44 = new Sensitivity("Credit", "Risk_IRCurve", "BRL", "3", "30y", "Libor12m", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_IR_45 = new Sensitivity("Credit", "Risk_Inflation", "BRL", "", "", "", "2000000", FxRate.USD, "2000000");
  static final Sensitivity S_IR_46 = new Sensitivity("Credit", "Risk_XCcyBasis", "BRL", "", "", "", "-1000000", FxRate.USD, "-1000000");
  static final List<Sensitivity> S_IR = Arrays.asList(
    S_IR_1, S_IR_2, S_IR_3, S_IR_4, S_IR_5, S_IR_6, S_IR_7, S_IR_8, S_IR_9, S_IR_10, S_IR_11, S_IR_12, S_IR_13, S_IR_14, S_IR_15, S_IR_16,
    S_IR_17, S_IR_18, S_IR_19, S_IR_20, S_IR_21, S_IR_22, S_IR_23, S_IR_24, S_IR_25, S_IR_26, S_IR_27, S_IR_28, S_IR_29, S_IR_30, S_IR_31,
    S_IR_32, S_IR_33, S_IR_34, S_IR_35, S_IR_36, S_IR_37, S_IR_38, S_IR_39, S_IR_40, S_IR_41, S_IR_42, S_IR_43, S_IR_44, S_IR_45, S_IR_46
  );

  static final Sensitivity S_FX_1 = new Sensitivity("RatesFX", "Risk_FX", "EUR", "", "", "", "50000000", FxRate.USD, "50000000");
  static final Sensitivity S_FX_2 = new Sensitivity("RatesFX", "Risk_FX", "EUR", "", "", "", "-50000000", FxRate.USD, "-50000000");
  static final Sensitivity S_FX_3 = new Sensitivity("RatesFX", "Risk_FX", "EUR", "", "", "", "-6000000000", FxRate.USD, "-6000000000");
  static final Sensitivity S_FX_4 = new Sensitivity("RatesFX", "Risk_FX", "USD", "", "", "", "610000000", FxRate.USD, "610000000");
  static final Sensitivity S_FX_5 = new Sensitivity("RatesFX", "Risk_FX", "GBP", "", "", "", "910000000", FxRate.USD, "910000000");
  static final Sensitivity S_FX_6 = new Sensitivity("RatesFX", "Risk_FX", "EUR", "", "", "", "-900000000", FxRate.USD, "-900000000");
  static final Sensitivity S_FX_7 = new Sensitivity("RatesFX", "Risk_FX", "CNY", "", "", "", "-200000000", FxRate.USD, "-200000000");
  static final Sensitivity S_FX_8 = new Sensitivity("RatesFX", "Risk_FX", "KRW", "", "", "", "210000000", FxRate.USD, "210000000");
  static final Sensitivity S_FX_9 = new Sensitivity("RatesFX", "Risk_FX", "TRY", "", "", "", "80000000", FxRate.USD, "80000000");
  static final Sensitivity S_FX_10 = new Sensitivity("RatesFX", "Risk_FX", "BRL", "", "", "", "-300000000", FxRate.USD, "-300000000");
  static final Sensitivity S_FX_11 = new Sensitivity("Credit", "Risk_FX", "BRL", "", "", "", "41000000", FxRate.USD, "41000000");
  static final Sensitivity S_FX_12 = new Sensitivity("Credit", "Risk_FX", "QAR", "", "", "", "-40000000", FxRate.USD, "-40000000");
  static final List<Sensitivity> S_FX = Arrays.asList(
    S_FX_1, S_FX_2, S_FX_3, S_FX_4, S_FX_5, S_FX_6, S_FX_7, S_FX_8, S_FX_9, S_FX_10, S_FX_11, S_FX_12
  );

  static final Sensitivity S_CRQ_1 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:BE0934259525", "1", "1y", "USD", "800000", FxRate.USD, "800000");
  static final Sensitivity S_CRQ_2 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:BE0934259525", "1", "2y", "USD", "-300000", FxRate.USD, "-300000");
  static final Sensitivity S_CRQ_3 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CA112585AG91", "2", "2y", "USD", "180000", FxRate.USD, "180000");
  static final Sensitivity S_CRQ_4 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CA112585AG91", "2", "2y", "EUR", "-180000", FxRate.USD, "-180000");
  static final Sensitivity S_CRQ_5 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CA82028KAP62", "3", "3y", "GBP", "180000", FxRate.USD, "180000");
  static final Sensitivity S_CRQ_6 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CA82028KAP62", "3", "5y", "JPY", "-100000", FxRate.USD, "-100000");
  static final Sensitivity S_CRQ_7 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:FR0000108359", "4", "5y", "USD", "180000", FxRate.USD, "180000");
  static final Sensitivity S_CRQ_8 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:FR0000108359", "4", "5y", "USD", "-100000", FxRate.USD, "-100000");
  static final Sensitivity S_CRQ_9 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CH0010519475", "5", "10y", "USD", "180000", FxRate.USD, "180000");
  static final Sensitivity S_CRQ_10 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CH9823105801", "5", "1y", "USD", "-100000", FxRate.USD, "-100000");
  static final Sensitivity S_CRQ_11 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:DE4830528795", "6", "2y", "EUR", "180000", FxRate.USD, "180000");
  static final Sensitivity S_CRQ_12 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:GB0862147969", "7", "3y", "GBP", "-600000", FxRate.USD, "-600000");
  static final Sensitivity S_CRQ_13 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CA6515779866", "8", "5y", "USD", "-100000", FxRate.USD, "-100000");
  static final Sensitivity S_CRQ_14 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:FR0003335977", "9", "10y", "USD", "180000", FxRate.USD, "180000");
  static final Sensitivity S_CRQ_15 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CA2201568701", "10", "1y", "USD", "-100000", FxRate.USD, "-100000");
  static final Sensitivity S_CRQ_16 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:CA6130123456", "11", "2y", "USD", "180000", FxRate.USD, "180000");
  static final Sensitivity S_CRQ_17 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:FR0002226543", "12", "3y", "USD", "-100000", FxRate.USD, "-100000");
  static final Sensitivity S_CRQ_18 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:UNKNOWN1", "Residual", "1y", "USD", "180000", FxRate.USD, "180000");
  static final Sensitivity S_CRQ_19 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:UNKNOWN1", "Residual", "3y", "USD", "-100000", FxRate.USD, "-100000");
  static final Sensitivity S_CRQ_20 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:UNKNOWN2", "Residual", "3y", "EUR", "180000", FxRate.USD, "180000");
  static final Sensitivity S_CRQ_21 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:UNKNOWN3", "Residual", "5y", "USD", "180000", FxRate.USD, "180000");
  static final Sensitivity S_CRQ_22 = new Sensitivity("Credit", "Risk_CreditQ", "ISIN:UNKNOWN3", "Residual", "10y", "GBP", "-100000", FxRate.USD, "-100000");
  static final Sensitivity S_CRQ_23 = new Sensitivity("Credit", "Risk_BaseCorr", "CDX IG", "", "", "", "500000", FxRate.USD, "500000");
  static final Sensitivity S_CRQ_24 = new Sensitivity("Credit", "Risk_BaseCorr", "CDX IG", "", "", "", "-200000", FxRate.USD, "-200000");
  static final Sensitivity S_CRQ_25 = new Sensitivity("Credit", "Risk_BaseCorr", "iTraxx Main", "", "", "", "400000", FxRate.USD, "400000");
  static final List<Sensitivity> S_CRQ = Arrays.asList(
    S_CRQ_1, S_CRQ_2, S_CRQ_3, S_CRQ_4, S_CRQ_5, S_CRQ_6, S_CRQ_7, S_CRQ_8, S_CRQ_9, S_CRQ_10, S_CRQ_11, S_CRQ_12,
    S_CRQ_13, S_CRQ_14, S_CRQ_15, S_CRQ_16, S_CRQ_17, S_CRQ_18, S_CRQ_19, S_CRQ_20, S_CRQ_21, S_CRQ_22, S_CRQ_23, S_CRQ_24, S_CRQ_25
  );

  static final Sensitivity S_CRNQ_1 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:AU3005621011", "1", "1y", "CMBX", "6000000", FxRate.USD, "6000000");
  static final Sensitivity S_CRNQ_2 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:AU3005621011", "1", "2y", "CMBX", "3000000", FxRate.USD, "3000000");
  static final Sensitivity S_CRNQ_3 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:AU3005621011", "1", "3y", "CMBX", "-3000000", FxRate.USD, "-3000000");
  static final Sensitivity S_CRNQ_4 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:DE0314227036", "1", "2y", "ABX", "-2000000", FxRate.USD, "-2000000");
  static final Sensitivity S_CRNQ_5 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:DE0314227036", "1", "3y", "ABX", "3000000", FxRate.USD, "3000000");
  static final Sensitivity S_CRNQ_6 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:DE0314227036", "1", "5y", "ABX", "-4000000", FxRate.USD, "-4000000");
  static final Sensitivity S_CRNQ_7 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:ES0338093059", "2", "3y", "CMBX", "-400000", FxRate.USD, "-400000");
  static final Sensitivity S_CRNQ_8 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:ES0338093059", "2", "5y", "CMBX", "-200000", FxRate.USD, "-200000");
  static final Sensitivity S_CRNQ_9 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:ES0338093059", "2", "10y", "CMBX", "200000", FxRate.USD, "200000");
  static final Sensitivity S_CRNQ_10 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:CA0359093012", "2", "1y", "CMBX", "200000", FxRate.USD, "200000");
  static final Sensitivity S_CRNQ_11 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:CA0359093012", "2", "3y", "CMBX", "200000", FxRate.USD, "200000");
  static final Sensitivity S_CRNQ_12 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:CA0359093012", "2", "5y", "CMBX", "-300000", FxRate.USD, "-300000");
  static final Sensitivity S_CRNQ_13 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:UNKNOWN1", "Residual", "1y", "MBX", "400000", FxRate.USD, "400000");
  static final Sensitivity S_CRNQ_14 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:UNKNOWN2", "Residual", "2y", "CMBX", "-200000", FxRate.USD, "-200000");
  static final Sensitivity S_CRNQ_15 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:UNKNOWN1", "Residual", "5y", "MBX", "300000", FxRate.USD, "300000");
  static final Sensitivity S_CRNQ_16 = new Sensitivity("Credit", "Risk_CreditNonQ", "ISIN:UNKNOWN2", "Residual", "10y", "CMBX", "-100000", FxRate.USD, "-100000");
  static final List<Sensitivity> S_CRNQ = Arrays.asList(
    S_CRNQ_1, S_CRNQ_2, S_CRNQ_3, S_CRNQ_4, S_CRNQ_5, S_CRNQ_6, S_CRNQ_7, S_CRNQ_8, S_CRNQ_9, S_CRNQ_10, S_CRNQ_11, S_CRNQ_12,
    S_CRNQ_13, S_CRNQ_14, S_CRNQ_15, S_CRNQ_16
  );

  static final Sensitivity S_EQ_1 = new Sensitivity("Equity", "Risk_Equity", "ISIN:INE044A01036", "1", "", "", "6000000", FxRate.USD, "6000000");
  static final Sensitivity S_EQ_2 = new Sensitivity("Equity", "Risk_Equity", "ISIN:INE406A01037", "1", "", "", "1000000", FxRate.USD, "1000000");
  static final Sensitivity S_EQ_3 = new Sensitivity("Equity", "Risk_Equity", "ISIN:CNE000000J28", "2", "", "", "-2000000", FxRate.USD, "-2000000");
  static final Sensitivity S_EQ_4 = new Sensitivity("Equity", "Risk_Equity", "ISIN:CNE000000L16", "2", "", "", "1000000", FxRate.USD, "1000000");
  static final Sensitivity S_EQ_5 = new Sensitivity("Equity", "Risk_Equity", "ISIN:RU0009024277", "3", "", "", "2000000", FxRate.USD, "2000000");
  static final Sensitivity S_EQ_6 = new Sensitivity("Equity", "Risk_Equity", "ISIN:RU0009091573", "3", "", "", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_EQ_7 = new Sensitivity("Equity", "Risk_Equity", "ISIN:INE160A01022", "4", "", "", "-2000000", FxRate.USD, "-2000000");
  static final Sensitivity S_EQ_8 = new Sensitivity("Equity", "Risk_Equity", "ISIN:INE467B01029", "4", "", "", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_EQ_9 = new Sensitivity("Equity", "Risk_Equity", "ISIN:US1266501006", "5", "", "", "10000000", FxRate.USD, "10000000");
  static final Sensitivity S_EQ_10 = new Sensitivity("Equity", "Risk_Equity", "ISIN:US28176E1082", "5", "", "", "2000000", FxRate.USD, "2000000");
  static final Sensitivity S_EQ_11 = new Sensitivity("Equity", "Risk_Equity", "ISIN:CA7751092007", "6", "", "", "-4000000", FxRate.USD, "-4000000");
  static final Sensitivity S_EQ_12 = new Sensitivity("Equity", "Risk_Equity", "ISIN:CA85472N1096", "6", "", "", "2000000", FxRate.USD, "2000000");
  static final Sensitivity S_EQ_13 = new Sensitivity("Equity", "Risk_Equity", "ISIN:DE000BASF111", "7", "", "", "4000000", FxRate.USD, "4000000");
  static final Sensitivity S_EQ_14 = new Sensitivity("Equity", "Risk_Equity", "ISIN:DE000A1DAHH0", "7", "", "", "-2000000", FxRate.USD, "-2000000");
  static final Sensitivity S_EQ_15 = new Sensitivity("Equity", "Risk_Equity", "ISIN:US67066G1040", "8", "", "", "-4000000", FxRate.USD, "-4000000");
  static final Sensitivity S_EQ_16 = new Sensitivity("Equity", "Risk_Equity", "ISIN:US8574771031", "8", "", "", "-2000000", FxRate.USD, "-2000000");
  static final Sensitivity S_EQ_17 = new Sensitivity("Equity", "Risk_Equity", "ISIN:BRCESPACNPB4", "9", "", "", "400000", FxRate.USD, "400000");
  static final Sensitivity S_EQ_18 = new Sensitivity("Equity", "Risk_Equity", "ISIN:BRENBRACNOR2", "9", "", "", "-4000000", FxRate.USD, "-4000000");
  static final Sensitivity S_EQ_19 = new Sensitivity("Equity", "Risk_Equity", "ISIN:AU000000API4", "10", "", "", "2000000", FxRate.USD, "2000000");
  static final Sensitivity S_EQ_20 = new Sensitivity("Equity", "Risk_Equity", "ISIN:AU000000CTD3", "10", "", "", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_EQ_21 = new Sensitivity("Equity", "Risk_Equity", "SPX", "11", "", "", "1000000000", FxRate.USD, "1000000000");
  static final Sensitivity S_EQ_22 = new Sensitivity("Equity", "Risk_Equity", "VPL", "11", "", "", "2000000", FxRate.USD, "2000000");
  static final Sensitivity S_EQ_23 = new Sensitivity("Equity", "Risk_Equity", "EEM", "11", "", "", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_EQ_24 = new Sensitivity("Equity", "Risk_Equity", "VIX", "12", "", "", "3000000", FxRate.USD, "3000000");
  static final Sensitivity S_EQ_25 = new Sensitivity("Equity", "Risk_Equity", "JINV", "12", "", "", "2000000", FxRate.USD, "2000000");
  static final Sensitivity S_EQ_26 = new Sensitivity("Equity", "Risk_Equity", "VSTOXX", "12", "", "", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_EQ_27 = new Sensitivity("Equity", "Risk_Equity", "ISIN:UNKNOWN1", "Residual", "", "", "1400000", FxRate.USD, "1400000");
  static final Sensitivity S_EQ_28 = new Sensitivity("Credit", "Risk_Equity", "ISIN:UNKNOWN3", "Residual", "", "", "-300000", FxRate.USD, "-300000");
  static final List<Sensitivity> S_EQ = Arrays.asList(
    S_EQ_1, S_EQ_2, S_EQ_3, S_EQ_4, S_EQ_5, S_EQ_6, S_EQ_7, S_EQ_8, S_EQ_9, S_EQ_10, S_EQ_11, S_EQ_12, S_EQ_13, S_EQ_14,
    S_EQ_15, S_EQ_16, S_EQ_17, S_EQ_18, S_EQ_19, S_EQ_20, S_EQ_21, S_EQ_22, S_EQ_23, S_EQ_24, S_EQ_25, S_EQ_26, S_EQ_27, S_EQ_28
  );
  
  static final Sensitivity S_CM_1 = new Sensitivity("Commodity", "Risk_Commodity", "Coal Americas", "1", "", "", "150000000", FxRate.USD, "150000000");
  static final Sensitivity S_CM_2 = new Sensitivity("Commodity", "Risk_Commodity", "Coal Europe", "1", "", "", "1000000", FxRate.USD, "1000000");
  static final Sensitivity S_CM_3 = new Sensitivity("Commodity", "Risk_Commodity", "Crude oil Americas", "2", "", "", "2100000000", FxRate.USD, "2100000000");
  static final Sensitivity S_CM_4 = new Sensitivity("Commodity", "Risk_Commodity", "Crude oil Asia/Middle East", "2", "", "", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_CM_5 = new Sensitivity("Commodity", "Risk_Commodity", "Light Ends Europe", "3", "", "", "-360000000", FxRate.USD, "-360000000");
  static final Sensitivity S_CM_6 = new Sensitivity("Commodity", "Risk_Commodity", "Light Ends Asia", "3", "", "", "1000000", FxRate.USD, "1000000");
  static final Sensitivity S_CM_7 = new Sensitivity("Commodity", "Risk_Commodity", "Middle Distillates Asia", "4", "", "", "-10000000", FxRate.USD, "-10000000");
  static final Sensitivity S_CM_8 = new Sensitivity("Commodity", "Risk_Commodity", "Middle Distillates Europe", "4", "", "", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_CM_9 = new Sensitivity("Commodity", "Risk_Commodity", "Heavy Distillates Americas", "5", "", "", "10000000", FxRate.USD, "10000000");
  static final Sensitivity S_CM_10 = new Sensitivity("Commodity", "Risk_Commodity", "Heavy Distillates Europe", "5", "", "", "1000000", FxRate.USD, "1000000");
  static final Sensitivity S_CM_11 = new Sensitivity("Commodity", "Risk_Commodity", "NA Natural Gas Gulf Coast", "6", "", "", "650000000", FxRate.USD, "650000000");
  static final Sensitivity S_CM_12 = new Sensitivity("Commodity", "Risk_Commodity", "NA Natural Gas West", "6", "", "", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_CM_13 = new Sensitivity("Commodity", "Risk_Commodity", "EU Natural Gas Europe", "7", "", "", "-10000000", FxRate.USD, "-10000000");
  static final Sensitivity S_CM_14 = new Sensitivity("Commodity", "Risk_Commodity", "NA Power Eastern Interconnect", "8", "", "", "-300000000", FxRate.USD, "-300000000");
  static final Sensitivity S_CM_15 = new Sensitivity("Commodity", "Risk_Commodity", "NA Power ERCOT", "8", "", "", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_CM_16 = new Sensitivity("Commodity", "Risk_Commodity", "EU Power Germany", "9", "", "", "10000000", FxRate.USD, "10000000");
  static final Sensitivity S_CM_17 = new Sensitivity("Commodity", "Risk_Commodity", "EU Power UK", "9", "", "", "1000000", FxRate.USD, "1000000");
  static final Sensitivity S_CM_18 = new Sensitivity("Commodity", "Risk_Commodity", "Freight Wet", "10", "", "", "51000000", FxRate.USD, "51000000");
  static final Sensitivity S_CM_19 = new Sensitivity("Commodity", "Risk_Commodity", "Freight Dry", "10", "", "", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_CM_20 = new Sensitivity("Commodity", "Risk_Commodity", "Base Metals Copper", "11", "", "", "-300000000", FxRate.USD, "-300000000");
  static final Sensitivity S_CM_21 = new Sensitivity("Commodity", "Risk_Commodity", "Base Metals Lead", "11", "", "", "1000000", FxRate.USD, "1000000");
  static final Sensitivity S_CM_22 = new Sensitivity("Commodity", "Risk_Commodity", "Precious Metals Gold", "12", "", "", "-800000000", FxRate.USD, "-800000000");
  static final Sensitivity S_CM_23 = new Sensitivity("Commodity", "Risk_Commodity", "Precious Metals Silver", "12", "", "", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_CM_24 = new Sensitivity("Commodity", "Risk_Commodity", "Grains Corn", "13", "", "", "20000000", FxRate.USD, "20000000");
  static final Sensitivity S_CM_25 = new Sensitivity("Commodity", "Risk_Commodity", "Grains Wheat", "13", "", "", "1000000", FxRate.USD, "1000000");
  static final Sensitivity S_CM_26 = new Sensitivity("Commodity", "Risk_Commodity", "Softs Cocoa", "14", "", "", "10000000", FxRate.USD, "10000000");
  static final Sensitivity S_CM_27 = new Sensitivity("Commodity", "Risk_Commodity", "Softs Cotton", "14", "", "", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_CM_28 = new Sensitivity("Commodity", "Risk_Commodity", "Livestock Live Cattle", "15", "", "", "-10000000", FxRate.USD, "-10000000");
  static final Sensitivity S_CM_29 = new Sensitivity("Commodity", "Risk_Commodity", "Livestock Lean Hogs", "15", "", "", "1000000", FxRate.USD, "1000000");
  static final Sensitivity S_CM_30 = new Sensitivity("Commodity", "Risk_Commodity", "Ethanol", "16", "", "", "-25000000", FxRate.USD, "-25000000");
  static final Sensitivity S_CM_31 = new Sensitivity("Commodity", "Risk_Commodity", "Random Length Lumber", "16", "", "", "-2000000", FxRate.USD, "-2000000");
  static final Sensitivity S_CM_32 = new Sensitivity("Commodity", "Risk_Commodity", "Agriculture Index", "17", "", "", "1300000000", FxRate.USD, "1300000000");
  static final Sensitivity S_CM_33 = new Sensitivity("Credit", "Risk_Commodity", "Natural Gas Index", "17", "", "", "2000000", FxRate.USD, "2000000");
  static final List<Sensitivity> S_CM = Arrays.asList(
    S_CM_1, S_CM_2, S_CM_3, S_CM_4, S_CM_5, S_CM_6, S_CM_7, S_CM_8, S_CM_9, S_CM_10, S_CM_11, S_CM_12, S_CM_13, S_CM_14, S_CM_15,
    S_CM_16, S_CM_17, S_CM_18, S_CM_19, S_CM_20, S_CM_21, S_CM_22, S_CM_23, S_CM_24, S_CM_25, S_CM_26, S_CM_27, S_CM_28, S_CM_29,
    S_CM_30, S_CM_31, S_CM_32, S_CM_33
  );

  static final Sensitivity S_IRV_1 = new Sensitivity("RatesFX", "Risk_IRVol", "USD", "", "30y", "", "600000000", FxRate.USD, "600000000");
  static final Sensitivity S_IRV_2 = new Sensitivity("RatesFX", "Risk_IRVol", "JPY", "", "20y", "", "200000000", FxRate.USD, "200000000");
  static final Sensitivity S_IRV_3 = new Sensitivity("RatesFX", "Risk_IRVol", "CAD", "", "15y", "", "100000000", FxRate.USD, "100000000");
  static final Sensitivity S_IRV_4 = new Sensitivity("RatesFX", "Risk_IRVol", "JPY", "", "10y", "", "200000000", FxRate.USD, "200000000");
  static final Sensitivity S_IRV_5 = new Sensitivity("RatesFX", "Risk_IRVol", "INR", "", "5y", "", "90000000", FxRate.USD, "90000000");
  static final Sensitivity S_IRV_6 = new Sensitivity("RatesFX", "Risk_IRVol", "EUR", "", "3y", "", "50000000", FxRate.USD, "50000000");
  static final Sensitivity S_IRV_7 = new Sensitivity("RatesFX", "Risk_IRVol", "CNY", "", "2y", "", "50000000", FxRate.USD, "50000000");
  static final Sensitivity S_IRV_8 = new Sensitivity("RatesFX", "Risk_IRVol", "RUB", "", "1y", "", "100000000", FxRate.USD, "100000000");
  static final Sensitivity S_IRV_9 = new Sensitivity("RatesFX", "Risk_IRVol", "USD", "", "6m", "", "100000000", FxRate.USD, "100000000");
  static final Sensitivity S_IRV_10 = new Sensitivity("RatesFX", "Risk_IRVol", "JPY", "", "3m", "", "100000000", FxRate.USD, "100000000");
  static final Sensitivity S_IRV_11 = new Sensitivity("RatesFX", "Risk_IRVol", "CAD", "", "1m", "", "100000000", FxRate.USD, "100000000");
  static final Sensitivity S_IRV_12 = new Sensitivity("RatesFX", "Risk_IRVol", "JPY", "", "2w", "", "100000000", FxRate.USD, "100000000");
  static final Sensitivity S_IRV_13 = new Sensitivity("RatesFX", "Risk_IRVol", "EUR", "", "30y", "", "-100000000", FxRate.USD, "-100000000");
  static final Sensitivity S_IRV_14 = new Sensitivity("RatesFX", "Risk_IRVol", "EUR", "", "20y", "", "-100000000", FxRate.USD, "-100000000");
  static final Sensitivity S_IRV_15 = new Sensitivity("RatesFX", "Risk_IRVol", "JPY", "", "15y", "", "-100000000", FxRate.USD, "-100000000");
  static final Sensitivity S_IRV_16 = new Sensitivity("RatesFX", "Risk_InflationVol", "USD", "", "30y", "", "80000000", FxRate.USD, "80000000");
  static final Sensitivity S_IRV_17 = new Sensitivity("RatesFX", "Risk_InflationVol", "JPY", "", "20y", "", "40000000", FxRate.USD, "40000000");
  static final Sensitivity S_IRV_18 = new Sensitivity("RatesFX", "Risk_InflationVol", "CAD", "", "20y", "", "20000000", FxRate.USD, "20000000");
  static final Sensitivity S_IRV_19 = new Sensitivity("RatesFX", "Risk_InflationVol", "CAD", "", "10y", "", "10000000", FxRate.USD, "10000000");
  static final Sensitivity S_IRV_20 = new Sensitivity("RatesFX", "Risk_InflationVol", "INR", "", "5y", "", "10000000", FxRate.USD, "10000000");
  static final List<Sensitivity> S_IRV = Arrays.asList(
    S_IRV_1, S_IRV_2, S_IRV_3, S_IRV_4, S_IRV_5, S_IRV_6, S_IRV_7, S_IRV_8, S_IRV_9, S_IRV_10, S_IRV_11, S_IRV_12, S_IRV_13,
    S_IRV_14, S_IRV_15, S_IRV_16, S_IRV_17, S_IRV_18, S_IRV_19, S_IRV_20
  );

  static final Sensitivity S_CRV_1 = new Sensitivity("Credit", "Risk_CreditVol", "ISIN:US1850531850", "1", "1y", "USD", "120000000", FxRate.USD, "120000000");
  static final Sensitivity S_CRV_2 = new Sensitivity("Credit", "Risk_CreditVol", "ISIN:US1850531850", "1", "1y", "GBP", "60000000", FxRate.USD, "60000000");
  static final Sensitivity S_CRV_3 = new Sensitivity("Credit", "Risk_CreditVol", "ISIN:US9800555990", "1", "3y", "USD", "30000000", FxRate.USD, "30000000");
  static final Sensitivity S_CRV_4 = new Sensitivity("Credit", "Risk_CreditVol", "ISIN:CN0068511222", "2", "1y", "CNY", "200000000", FxRate.USD, "200000000");
  static final Sensitivity S_CRV_5 = new Sensitivity("Credit", "Risk_CreditVol", "ISIN:CN0068511222", "2", "2y", "CNY", "-40000000", FxRate.USD, "-40000000");
  static final Sensitivity S_CRV_6 = new Sensitivity("Credit", "Risk_CreditVol", "ISIN:CA2108230001", "Residual", "1y", "USD", "10000000", FxRate.USD, "10000000");
  static final Sensitivity S_CRV_7 = new Sensitivity("Credit", "Risk_CreditVol", "ISIN:GB1086652888", "Residual", "5y", "EUR", "30000000", FxRate.USD, "30000000");
  static final Sensitivity S_CRV_8 = new Sensitivity("Credit", "Risk_CreditVol", "ISIN:CA2108230001", "Residual", "10y", "USD", "-150000000", FxRate.USD, "-150000000");
  static final List<Sensitivity> S_CRV = Arrays.asList(
    S_CRV_1, S_CRV_2, S_CRV_3, S_CRV_4, S_CRV_5, S_CRV_6, S_CRV_7, S_CRV_8
  );

  static final Sensitivity S_CNV_1 = new Sensitivity("Credit", "Risk_CreditVolNonQ", "EU.IG", "1", "1y", "CMBX", "40000000", FxRate.USD, "40000000");
  static final Sensitivity S_CNV_2 = new Sensitivity("Credit", "Risk_CreditVolNonQ", "US.IG", "1", "1y", "CMBX", "30000000", FxRate.USD, "30000000");
  static final Sensitivity S_CNV_3 = new Sensitivity("Credit", "Risk_CreditVolNonQ", "US.IG", "1", "2y", "CMBX", "-20000000", FxRate.USD, "-20000000");
  static final Sensitivity S_CNV_4 = new Sensitivity("Credit", "Risk_CreditVolNonQ", "CN.HY", "2", "3y", "CMBX", "-50000000", FxRate.USD, "-50000000");
  static final Sensitivity S_CNV_5 = new Sensitivity("Credit", "Risk_CreditVolNonQ", "JP.HY", "2", "5y", "ABX", "20000000", FxRate.USD, "20000000");
  static final Sensitivity S_CNV_6 = new Sensitivity("Credit", "Risk_CreditVolNonQ", "BR.HY", "Residual", "1y", "CMBX", "45000000", FxRate.USD, "45000000");
  static final Sensitivity S_CNV_7 = new Sensitivity("Credit", "Risk_CreditVolNonQ", "RU.HY", "Residual", "5y", "ABX", "10000000", FxRate.USD, "10000000");
  static final Sensitivity S_CNV_8 = new Sensitivity("Credit", "Risk_CreditVolNonQ", "BR.HY", "Residual", "10y", "CMBX", "25000000", FxRate.USD, "25000000");
  static final Sensitivity S_CNV_9 = new Sensitivity("Credit", "Risk_CreditVolNonQ", "RU.HY", "Residual", "1y", "ABX", "15000000", FxRate.USD, "15000000");
  static final List<Sensitivity> S_CNV = Arrays.asList(
    S_CNV_1, S_CNV_2, S_CNV_3, S_CNV_4, S_CNV_5, S_CNV_6, S_CNV_7, S_CNV_8, S_CNV_9
  );

  static final Sensitivity S_EQV_1 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:AT000089755122", "1", "1m", "", "1200000", FxRate.USD, "1200000");
  static final Sensitivity S_EQV_2 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:AT016188495495", "1", "3m", "", "1000000", FxRate.USD, "1000000");
  static final Sensitivity S_EQV_3 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:AT000089755122", "1", "6m", "", "-3000000", FxRate.USD, "-3000000");
  static final Sensitivity S_EQV_4 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:AU001159751155", "2", "1y", "", "-2000000", FxRate.USD, "-2000000");
  static final Sensitivity S_EQV_5 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:AU003186678890", "2", "2y", "", "-1000000", FxRate.USD, "-1000000");
  static final Sensitivity S_EQV_6 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:AU002189533177", "5", "3y", "", "15000000", FxRate.USD, "15000000");
  static final Sensitivity S_EQV_7 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:CA842256904411", "9", "5y", "", "-400000", FxRate.USD, "-400000");
  static final Sensitivity S_EQV_8 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:BR484898123123", "10", "10y", "", "2000000", FxRate.USD, "2000000");
  static final Sensitivity S_EQV_9 = new Sensitivity("Equity", "Risk_EquityVol", "SPX", "11", "15y", "", "400000000", FxRate.USD, "400000000");
  static final Sensitivity S_EQV_10 = new Sensitivity("Equity", "Risk_EquityVol", "SPX", "11", "20y", "", "-10000000", FxRate.USD, "-10000000");
  static final Sensitivity S_EQV_11 = new Sensitivity("Equity", "Risk_EquityVol", "VIX", "12", "30y", "", "50000000", FxRate.USD, "50000000");
  static final Sensitivity S_EQV_12 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:GB770459100599", "Residual", "10y", "", "400000", FxRate.USD, "400000");
  static final Sensitivity S_EQV_13 = new Sensitivity("Equity", "Risk_EquityVol", "ISIN:CY180666897555", "Residual", "30y", "", "-500000", FxRate.USD, "-500000");
  static final List<Sensitivity> S_EQV = Arrays.asList(
    S_EQV_1, S_EQV_2, S_EQV_3, S_EQV_4, S_EQV_5, S_EQV_6, S_EQV_7, S_EQV_8, S_EQV_9, S_EQV_10, S_EQV_11, S_EQV_12, S_EQV_13
  );

  static final Sensitivity S_FXV_1 = new Sensitivity("RatesFX", "Risk_FXVol", "USDGBP", "", "3m", "", "24000000", FxRate.USD, "24000000");
  static final Sensitivity S_FXV_2 = new Sensitivity("RatesFX", "Risk_FXVol", "GBPUSD", "", "1y", "", "100000000", FxRate.USD, "100000000");
  static final Sensitivity S_FXV_3 = new Sensitivity("RatesFX", "Risk_FXVol", "BRLUSD", "", "2y", "", "100000000", FxRate.USD, "100000000");
  static final Sensitivity S_FXV_4 = new Sensitivity("RatesFX", "Risk_FXVol", "EURQAR", "", "1m", "", "-40000000", FxRate.USD, "-40000000");
  static final Sensitivity S_FXV_5 = new Sensitivity("RatesFX", "Risk_FXVol", "HKDKRW", "", "6m", "", "-15000000", FxRate.USD, "-15000000");
  static final Sensitivity S_FXV_6 = new Sensitivity("RatesFX", "Risk_FXVol", "CNYSGD", "", "3y", "", "12000000", FxRate.USD, "12000000");
  static final Sensitivity S_FXV_7 = new Sensitivity("RatesFX", "Risk_FXVol", "RUBTRY", "", "5y", "", "-12000000", FxRate.USD, "-12000000");
  static final Sensitivity S_FXV_8 = new Sensitivity("RatesFX", "Risk_FXVol", "KRWBRL", "", "10y", "", "30000000", FxRate.USD, "30000000");
  static final List<Sensitivity> S_FXV = Arrays.asList(
    S_FXV_1, S_FXV_2, S_FXV_3, S_FXV_4, S_FXV_5, S_FXV_6, S_FXV_7, S_FXV_8
  );

  static final Sensitivity S_CMV_1 = new Sensitivity("Commodity", "Risk_CommodityVol", "Coal Europe", "1", "2w", "", "7000000", FxRate.USD, "7000000");
  static final Sensitivity S_CMV_2 = new Sensitivity("Commodity", "Risk_CommodityVol", "Coal Americas", "1", "1m", "", "3000000", FxRate.USD, "3000000");
  static final Sensitivity S_CMV_3 = new Sensitivity("Commodity", "Risk_CommodityVol", "Coal Australia", "1", "3m", "", "-3000000", FxRate.USD, "-3000000");
  static final Sensitivity S_CMV_4 = new Sensitivity("Commodity", "Risk_CommodityVol", "Crude oil Americas", "2", "6m", "", "-32000000", FxRate.USD, "-32000000");
  static final Sensitivity S_CMV_5 = new Sensitivity("Commodity", "Risk_CommodityVol", "Crude oil Asia/Middle East", "2", "1y", "", "-10000000", FxRate.USD, "-10000000");
  static final Sensitivity S_CMV_6 = new Sensitivity("Commodity", "Risk_CommodityVol", "Light Ends Americas", "3", "2y", "", "8000000", FxRate.USD, "8000000");
  static final Sensitivity S_CMV_7 = new Sensitivity("Commodity", "Risk_CommodityVol", "NA Natural Gas Gulf Coast", "6", "3y", "", "30000000", FxRate.USD, "30000000");
  static final Sensitivity S_CMV_8 = new Sensitivity("Commodity", "Risk_CommodityVol", "NA Power ERCOT", "8", "5y", "", "7000000", FxRate.USD, "7000000");
  static final Sensitivity S_CMV_9 = new Sensitivity("Commodity", "Risk_CommodityVol", "Freight Dry", "10", "10y", "", "1000000", FxRate.USD, "1000000");
  static final Sensitivity S_CMV_10 = new Sensitivity("Commodity", "Risk_CommodityVol", "Base Metals Copper", "11", "6m", "", "-7000000", FxRate.USD, "-7000000");
  static final Sensitivity S_CMV_11 = new Sensitivity("Commodity", "Risk_CommodityVol", "Precious Metals Gold", "12", "1y", "", "12000000", FxRate.USD, "12000000");
  static final Sensitivity S_CMV_12 = new Sensitivity("Commodity", "Risk_CommodityVol", "Grains Wheat", "13", "2y", "", "8000000", FxRate.USD, "8000000");
  static final Sensitivity S_CMV_13 = new Sensitivity("Commodity", "Risk_CommodityVol", "Agriculture Index", "17", "15y", "", "9000000", FxRate.USD, "9000000");
  static final Sensitivity S_CMV_14 = new Sensitivity("Commodity", "Risk_CommodityVol", "Natural Gas Index", "17", "20y", "", "-2000000", FxRate.USD, "-2000000");
  static final Sensitivity S_CMV_15 = new Sensitivity("Commodity", "Risk_CommodityVol", "Ethanol", "16", "5y", "", "1000000", FxRate.USD, "1000000");
  static final Sensitivity S_CMV_16 = new Sensitivity("Commodity", "Risk_CommodityVol", "Random Length Lumber", "16", "30y", "", "-1100000", FxRate.USD, "-1100000");
  static final List<Sensitivity> S_CMV = Arrays.asList(
    S_CMV_1, S_CMV_2, S_CMV_3, S_CMV_4, S_CMV_5, S_CMV_6, S_CMV_7, S_CMV_8, S_CMV_9, S_CMV_10, S_CMV_11,
    S_CMV_12, S_CMV_13, S_CMV_14, S_CMV_15, S_CMV_16
  );

  static final AddOnNotionalFactor S_AN_1 = new AddOnNotionalFactor("Product Alpha", "12.5");
  static final AddOnNotionalFactor S_AN_2 = new AddOnNotionalFactor("Product Bravo", "25.0");
  static final AddOnNotional S_AN_3 = new AddOnNotional("Product Alpha", "80000000", FxRate.USD, "80000000");
  static final AddOnNotional S_AN_4 = new AddOnNotional("Product Bravo", "60000000", FxRate.USD, "60000000");
  static final AddOnNotional S_AN_5 = new AddOnNotional("Product Bravo", "100000000", FxRate.USD, "100000000");
  static final AddOnNotional S_AN_6 = new AddOnNotional("Product Charlie", "40000000", FxRate.USD, "40000000");
  static final AddOnFixedAmount S_AN_7 = new AddOnFixedAmount("10000000", FxRate.USD, "10000000");
  static final AddOnFixedAmount S_AN_8 = new AddOnFixedAmount("20000000", FxRate.USD, "20000000");

  static final ProductMultiplier S_MUL_1 = new ProductMultiplier("RatesFX", "1.045");
  static final ProductMultiplier S_MUL_2 = new ProductMultiplier("Credit", "1.034");
  static final ProductMultiplier S_MUL_3 = new ProductMultiplier("Equity", "1.215");
  static final ProductMultiplier S_MUL_4 = new ProductMultiplier("Commodity", "1.054");
  static final List<ProductMultiplier> S_MUL = Arrays.asList(S_MUL_1, S_MUL_2, S_MUL_3, S_MUL_4);
}
