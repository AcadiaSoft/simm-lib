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

package com.acadiasoft.im.simmple;

import com.acadiasoft.im.simmple.engine.Simmple;
import com.acadiasoft.im.simmple.model.Crif;
import com.acadiasoft.im.simmple.model.ImRole;
import com.acadiasoft.im.simmple.model.utils.SimmpleUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author alec.stewart
 */
public class ParsingTest extends SimmpleUtils {

  @Test
  public void testParsing() {
    String regString1 = "[CFTC,SEC]";
    String regString2 = "CFTC,SEC";
    String regString3 = "SEC";
    Assert.assertEquals(Arrays.asList(regString2.split(",")), Arrays.asList(regString1.substring(1, regString1.length() - 1).split(",")));
  }

  @Test
  public void testBlankRegulators() {
    List<Crif> crifs = Arrays.asList(
        new Crif("trade1", "2018-02-06", "", null, null,"SIMM-P", "Credit", "Risk_CreditQ", "XS0369461644", "3", "5y", "USD", "-90155", "USD", "-90155", "SEC", " "),
        new Crif("trade1", "2018-02-06", "",null, null, "SIMM-P", "Credit", "Risk_CreditQ", "XS0369461644", "3", "3y", "USD", "-2015", "USD", "-2015", "SEC", "   "),
        new Crif("trade1", "2018-02-06", "",null, null, "SIMM-P", "Credit", "Risk_CreditQ", "XS0369461644", "3", "1y", "USD", "123", "USD", "123", "SEC", "[ ]"),
        new Crif("trade1", "2018-02-06", "",null, null, "SIMM-P", "Credit", "Risk_FX", "GBP", "", "", "", "64000", "USD", "64000", "SEC", "[]"),
        new Crif("trade1", "2018-02-06", "",null, null,"SIMM-P", "Credit", "Risk_IRCurve", "EUR", "", "6m", "Libor6m", "3567", "USD", "3567", "SEC", ""),
        new Crif("trade2", "2018-02-06", "",null, null,"SIMM-P", "RatesFX", "Risk_FX", "GBP", "", "", "", "120000", "USD", "120000", "", ""),
        new Crif("trade2", "2018-02-06", "",null, null, "SIMM-P", "RatesFX", "Risk_FX", "USD", "", "", "", "-50000", "USD", "-50000", "", ""),
        new Crif("trade2", "2018-02-06", "",null, null, "SIMM-P", "RatesFX", "Risk_IRCurve", "GBP", "", "3m", "Libor3m", "10500", "USD", "10500", " ", ""),
        new Crif("trade2", "2018-02-06", "",null, null, "SIMM-P", "RatesFX", "Risk_IRCurve", "GBP", "", "6m", "Libor3m", "13540", "USD", "13540", "", ""),
        new Crif("trade2", "2018-02-06", "",null, null, "SIMM-P", "RatesFX", "Risk_IRCurve", "GBP", "", "1y", "Libor3m", "9500", "USD", "9500", "", "   "),
        new Crif("trade2", "2018-02-06", "",null, null, "SIMM-P", "RatesFX", "Risk_IRCurve", "GBP", "", "2y", "Libor3m", "843", "USD", "843", "", ""),
        new Crif("trade2", "2018-02-06", "",null, null, "SIMM-P", "RatesFX", "Risk_IRCurve", "GBP", "", "3y", "Libor3m", "28", "USD", "28", "[]", ""),
        new Crif("trade2", "2018-02-06", "",null, null,"SIMM-P", "RatesFX", "Risk_IRCurve", "GBP", "", "5y", "Libor3m", "-8000", "USD", "-8000", " ", ""),
        new Crif("trade2", "2018-02-06", "",null, null, "SIMM-P", "RatesFX", "Risk_IRCurve", "USD", "", "3m", "Libor3m", "-1500", "USD", "-1500", "", "   "),
        new Crif("trade2", "2018-02-06", "",null, null,"SIMM-P", "RatesFX", "Risk_IRCurve", "USD", "", "6m", "Libor3m", "-800", "USD", "-800", "   ", ""),
        new Crif("trade2", "2018-02-06", "",null, null,"SIMM-P", "RatesFX", "Risk_IRCurve", "USD", "", "1y", "Libor3m", "1230", "USD", "1230", "", ""),
        new Crif("trade2", "2018-02-06", "",null, null,"SIMM-P", "RatesFX", "Risk_IRCurve", "USD", "", "2y", "Libor3m", "4000", "USD", "4000", "   ", "   "),
        new Crif("trade2", "2018-02-06", "",null, null, "SIMM-P", "RatesFX", "Risk_IRCurve", "USD", "", "3y", "Libor3m", "4200", "USD", "4200", "", ""),
        new Crif("trade2", "2018-02-06", "",null, null, "SIMM-P", "RatesFX", "Risk_IRCurve", "USD", "", "5y", "Libor3m", "10230", "USD", "10230", "", "")
    );

    Set<String> set = new HashSet<>();
    Assert.assertEquals(set, SimmpleUtils.getAllowedRegulators(crifs, ImRole.SECURED));
    Set<String> set2 = new HashSet<>();
    set2.add("SEC");
    Assert.assertEquals(set2, SimmpleUtils.getAllowedRegulators(crifs, ImRole.PLEDGOR));
  }

}
