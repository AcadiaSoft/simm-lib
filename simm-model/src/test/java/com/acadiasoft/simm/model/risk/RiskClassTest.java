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

package com.acadiasoft.simm.model.risk;

import org.junit.Assert;
import org.junit.Test;

public class RiskClassTest {

  @Test
  public void assertIndexes() {
    Assert.assertEquals(RiskClass.INTEREST_RATE, RiskClass.values()[0]);
    Assert.assertEquals(RiskClass.CREDIT_QUALIFYING, RiskClass.values()[1]);
    Assert.assertEquals(RiskClass.CREDIT_NON_QUALIFYING, RiskClass.values()[2]);
    Assert.assertEquals(RiskClass.EQUITY, RiskClass.values()[3]);
    Assert.assertEquals(RiskClass.COMMODITY, RiskClass.values()[4]);
    Assert.assertEquals(RiskClass.FX, RiskClass.values()[5]);
  }

  @Test
  public void testIndexOf() {
    Assert.assertEquals(0, RiskClass.indexOf(RiskClass.INTEREST_RATE));
    Assert.assertEquals(1, RiskClass.indexOf(RiskClass.CREDIT_QUALIFYING));
    Assert.assertEquals(2, RiskClass.indexOf(RiskClass.CREDIT_NON_QUALIFYING));
    Assert.assertEquals(3, RiskClass.indexOf(RiskClass.EQUITY));
    Assert.assertEquals(4, RiskClass.indexOf(RiskClass.COMMODITY));
    Assert.assertEquals(5, RiskClass.indexOf(RiskClass.FX));
  }

  @Test
  public void testRiskType() {
    Assert.assertEquals(RiskClass.INTEREST_RATE, RiskClass.getByRiskType("Risk_IRCurve"));
    Assert.assertEquals(RiskClass.INTEREST_RATE, RiskClass.getByRiskType("Risk_Inflation"));
    Assert.assertEquals(RiskClass.INTEREST_RATE, RiskClass.getByRiskType("Risk_IRVol"));
    Assert.assertEquals(RiskClass.CREDIT_QUALIFYING, RiskClass.getByRiskType("Risk_CreditQ"));
    Assert.assertEquals(RiskClass.CREDIT_QUALIFYING, RiskClass.getByRiskType("Risk_CreditVol"));
    Assert.assertEquals(RiskClass.CREDIT_NON_QUALIFYING, RiskClass.getByRiskType("Risk_CreditNonQ"));
    Assert.assertEquals(RiskClass.CREDIT_NON_QUALIFYING, RiskClass.getByRiskType("Risk_CreditVolNonQ"));
    Assert.assertEquals(RiskClass.EQUITY, RiskClass.getByRiskType("Risk_Equity"));
    Assert.assertEquals(RiskClass.EQUITY, RiskClass.getByRiskType("Risk_EquityVol"));
    Assert.assertEquals(RiskClass.FX, RiskClass.getByRiskType("Risk_FX"));
    Assert.assertEquals(RiskClass.FX, RiskClass.getByRiskType("Risk_FXVol"));
    Assert.assertEquals(RiskClass.COMMODITY, RiskClass.getByRiskType("Risk_Commodity"));
    Assert.assertEquals(RiskClass.COMMODITY, RiskClass.getByRiskType("Risk_CommodityVol"));
  }

  @Test(expected = RuntimeException.class)
  public void testGetByLabelUnknown() {
    RiskClass.getByRiskType("???");
  }
}
