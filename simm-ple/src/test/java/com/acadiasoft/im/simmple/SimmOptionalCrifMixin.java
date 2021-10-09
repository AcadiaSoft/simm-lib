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

package com.acadiasoft.im.simmple;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.simm.model.imtree.identifiers.AddOnSubType;
import com.acadiasoft.im.simmple.model.Crif;
import com.acadiasoft.im.simmple.model.DefaultCrif;

public interface SimmOptionalCrifMixin {

  Crif JS_IR_47 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "USD", "1", "1y", "Prime", "-1000000", FxRate.USD, "-1000000", "", "USPR");
  Crif JS_IR_48 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "EUR", "1", "3y", "Libor3m", "-2000000", FxRate.USD, "-2000000", "", "ESA");
  Crif JS_IR_49 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "2w", "Libor1m", "-1000000", FxRate.USD, "-1000000", "", "USPR");
  Crif JS_IR_50 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "3m", "Libor1m", "-1500000", FxRate.USD, "-1500000", "", "ESA");
  Crif JS_IR_51 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "3m", "Libor3m", "1500000", FxRate.USD, "1500000", "", "USPR,ESA");
  Crif JS_IR_52 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "1m", "Libor3m", "1500000", FxRate.USD, "1500000", "", "USPR,JFSA");
  Crif JS_IR_53 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "3y", "Libor6m", "3000000", FxRate.USD, "3000000", "", "USPR");
  Crif JS_IR_54 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "5y", "Libor6m", "3000000", FxRate.USD, "3000000", "", "JFSA");
  Crif JS_IR_55 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "3m", "Libor3m", "1500000", FxRate.USD, "1500000", "", "");
  Crif JS_IR_56 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "5y", "Libor6m", "2500000", FxRate.USD, "2500000", "", "ESA");
  Crif JS_IR_57 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "3y", "Libor6m", "2500000", FxRate.USD, "2500000", "", "JFSA");
  Crif JS_IR_58 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "3y", "Libor6m", "4000000", FxRate.USD, "4000000", "", "JFSA");
  Crif JS_IR_59 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "3y", "Libor6m", "5000000", FxRate.USD, "5000000", "", "USPR");
  Crif JS_IR_60 = new DefaultCrif("", "", "", "", "","SIMM","Credit", "Risk_IRCurve", "JPY", "2", "5y", "Libor6m", "4000000", FxRate.USD, "4000000", "", "USPR");
  Crif JS_IR_61 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "2w", "Libor6m", "6000000", FxRate.USD, "6000000", "", "JFSA");
  Crif JS_IR_62 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "3y", "Libor6m", "5000000", FxRate.USD, "5000000", "", "USPR,JFSA");
  Crif JS_IR_63 = new DefaultCrif("", "", "", "", "","SIMM","Credit", "Risk_IRCurve", "JPY", "2", "5y", "Libor6m", "4000000", FxRate.USD, "4000000", "", "USPR,JFSA");

  Crif JS_AN_9 = new DefaultCrif("", "", "", "", "", "SIMM", "", AddOnSubType.ADD_ON_NOTIONAL, "Product Alpha", "", "", "", "80000000", FxRate.USD, "80000000", "", "JFSA");
  Crif JS_AN_10 = new DefaultCrif("", "", "", "", "", "", "", AddOnSubType.ADD_ON_NOTIONAL_FACTOR, "Product Alpha", "", "", "", "12.5", "", "", "", "JFSA");

  Crif JS_MUL_5 = new DefaultCrif("", "", "", "", "","", "", AddOnSubType.ADD_ON_PRODUCT_MULTIPLIER, "RatesFX", "", "", "", "1.5", "", "", "", "ESA");
  Crif JS_MUL_6 = new DefaultCrif("", "", "", "", "","", "", AddOnSubType.ADD_ON_PRODUCT_MULTIPLIER, "RatesFX", "", "", "", "1.6", "", "", "", "JFSA");
  Crif JS_MUL_7 = new DefaultCrif("", "", "", "", "","", "", AddOnSubType.ADD_ON_PRODUCT_MULTIPLIER, "RatesFX", "", "", "", "1.2", "", "", "", "USPR,JFSA");
  Crif JS_MUL_8 = new DefaultCrif("", "", "", "", "","", "", AddOnSubType.ADD_ON_PRODUCT_MULTIPLIER, "Credit", "", "", "", "1.5", "", "", "", "USPR");
  Crif JS_MUL_9 = new DefaultCrif("", "", "", "", "","", "", AddOnSubType.ADD_ON_PRODUCT_MULTIPLIER, "RatesFX", "", "", "", "2.5", "", "", "", "JFSA");

  Crif SS_IR_64 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "3y", "Libor6m", "5000000", FxRate.USD, "5000000", "", "SEC-unseg,USPR");
  Crif SS_IR_64_Seg = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "3y", "Libor6m", "5000000", FxRate.USD, "5000000", "", "USPR");
  Crif SS_IR_64_Unseg = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "3y", "Libor6m", "5000000", FxRate.USD, "5000000", "", "SEC-unseg");
  Crif SS_IR_65 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "5y", "Libor6m", "4000000", FxRate.USD, "4000000", "", "SEC-unseg,JFSA");
  Crif SS_IR_65_Seg = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "5y", "Libor6m", "4000000", FxRate.USD, "4000000", "", "JFSA");
  Crif SS_IR_65_Unseg = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "5y", "Libor6m", "4000000", FxRate.USD, "4000000", "", "SEC-unseg");
  Crif SS_IR_66 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "5y", "Libor6m", "2500000", FxRate.USD, "2500000", "", "SEC-unseg,ESA");
  Crif SS_IR_66_Seg = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "5y", "Libor6m", "2500000", FxRate.USD, "2500000", "", "ESA");
  Crif SS_IR_66_Unseg = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "5y", "Libor6m", "2500000", FxRate.USD, "2500000", "", "SEC-unseg");
  Crif SS_IR_67 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "3y", "Libor6m", "3000000", FxRate.USD, "3000000", "", "SEC-unseg,ESA");
  Crif SS_IR_67_Seg = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "3y", "Libor6m", "3000000", FxRate.USD, "3000000", "", "ESA");
  Crif SS_IR_67_Unseg = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "3y", "Libor6m", "3000000", FxRate.USD, "3000000", "", "SEC-unseg");
  Crif SS_IR_68 = new DefaultCrif("", "", "", "", "","SIMM","RatesFX", "Risk_IRCurve", "JPY", "2", "5y", "Libor6m", "4000000", FxRate.USD, "4000000", "", "ESA");
}
