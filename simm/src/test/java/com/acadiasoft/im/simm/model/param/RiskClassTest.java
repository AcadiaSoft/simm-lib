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

package com.acadiasoft.im.simm.model.param;

import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
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
  public void testRiskType() {
    Assert.assertEquals(RiskClass.INTEREST_RATE, RiskClass.determineByRiskType("Risk_IRCurve"));
    Assert.assertEquals(RiskClass.INTEREST_RATE, RiskClass.determineByRiskType("Risk_Inflation"));
    Assert.assertEquals(RiskClass.INTEREST_RATE, RiskClass.determineByRiskType("Risk_IRVol"));
    Assert.assertEquals(RiskClass.CREDIT_QUALIFYING, RiskClass.determineByRiskType("Risk_CreditQ"));
    Assert.assertEquals(RiskClass.CREDIT_QUALIFYING, RiskClass.determineByRiskType("Risk_CreditVol"));
    Assert.assertEquals(RiskClass.CREDIT_NON_QUALIFYING, RiskClass.determineByRiskType("Risk_CreditNonQ"));
    Assert.assertEquals(RiskClass.CREDIT_NON_QUALIFYING, RiskClass.determineByRiskType("Risk_CreditVolNonQ"));
    Assert.assertEquals(RiskClass.EQUITY, RiskClass.determineByRiskType("Risk_Equity"));
    Assert.assertEquals(RiskClass.EQUITY, RiskClass.determineByRiskType("Risk_EquityVol"));
    Assert.assertEquals(RiskClass.FX, RiskClass.determineByRiskType("Risk_FX"));
    Assert.assertEquals(RiskClass.FX, RiskClass.determineByRiskType("Risk_FXVol"));
    Assert.assertEquals(RiskClass.COMMODITY, RiskClass.determineByRiskType("Risk_Commodity"));
    Assert.assertEquals(RiskClass.COMMODITY, RiskClass.determineByRiskType("Risk_CommodityVol"));
  }

  @Test(expected = RuntimeException.class)
  public void testGetByLabelUnknown() {
    RiskClass.determineByRiskType("???");
  }
}
