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

package com.acadiasoft.simm.model.param;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static com.acadiasoft.simm.model.object.imtree.identifiers.RiskClass.*;

public class RiskClassCorrelationTest {

  @Test
  public void getCorrelationTest() {
    Assert.assertEquals(new BigDecimal("1"), SimmRiskClassCorrelation.get(INTEREST_RATE, INTEREST_RATE));
    Assert.assertEquals(new BigDecimal("0.28"), SimmRiskClassCorrelation.get(INTEREST_RATE, CREDIT_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.18"), SimmRiskClassCorrelation.get(INTEREST_RATE, CREDIT_NON_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.18"), SimmRiskClassCorrelation.get(INTEREST_RATE, EQUITY));
    Assert.assertEquals(new BigDecimal("0.30"), SimmRiskClassCorrelation.get(INTEREST_RATE, COMMODITY));
    Assert.assertEquals(new BigDecimal("0.22"), SimmRiskClassCorrelation.get(INTEREST_RATE, FX));
    Assert.assertEquals(new BigDecimal("0.28"), SimmRiskClassCorrelation.get(CREDIT_QUALIFYING, INTEREST_RATE));
    Assert.assertEquals(new BigDecimal("1"), SimmRiskClassCorrelation.get(CREDIT_QUALIFYING, CREDIT_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.30"), SimmRiskClassCorrelation.get(CREDIT_QUALIFYING, CREDIT_NON_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.66"), SimmRiskClassCorrelation.get(CREDIT_QUALIFYING, EQUITY));
    Assert.assertEquals(new BigDecimal("0.46"), SimmRiskClassCorrelation.get(CREDIT_QUALIFYING, COMMODITY));
    Assert.assertEquals(new BigDecimal("0.27"), SimmRiskClassCorrelation.get(CREDIT_QUALIFYING, FX));
    Assert.assertEquals(new BigDecimal("0.18"), SimmRiskClassCorrelation.get(CREDIT_NON_QUALIFYING, INTEREST_RATE));
    Assert.assertEquals(new BigDecimal("0.30"), SimmRiskClassCorrelation.get(CREDIT_NON_QUALIFYING, CREDIT_QUALIFYING));
    Assert.assertEquals(new BigDecimal("1"), SimmRiskClassCorrelation.get(CREDIT_NON_QUALIFYING, CREDIT_NON_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.23"), SimmRiskClassCorrelation.get(CREDIT_NON_QUALIFYING, EQUITY));
    Assert.assertEquals(new BigDecimal("0.25"), SimmRiskClassCorrelation.get(CREDIT_NON_QUALIFYING, COMMODITY));
    Assert.assertEquals(new BigDecimal("0.18"), SimmRiskClassCorrelation.get(CREDIT_NON_QUALIFYING, FX));
    Assert.assertEquals(new BigDecimal("0.18"), SimmRiskClassCorrelation.get(EQUITY, INTEREST_RATE));
    Assert.assertEquals(new BigDecimal("0.66"), SimmRiskClassCorrelation.get(EQUITY, CREDIT_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.23"), SimmRiskClassCorrelation.get(EQUITY, CREDIT_NON_QUALIFYING));
    Assert.assertEquals(new BigDecimal("1"), SimmRiskClassCorrelation.get(EQUITY, EQUITY));
    Assert.assertEquals(new BigDecimal("0.39"), SimmRiskClassCorrelation.get(EQUITY, COMMODITY));
    Assert.assertEquals(new BigDecimal("0.24"), SimmRiskClassCorrelation.get(EQUITY, FX));
    Assert.assertEquals(new BigDecimal("0.30"), SimmRiskClassCorrelation.get(COMMODITY, INTEREST_RATE));
    Assert.assertEquals(new BigDecimal("0.46"), SimmRiskClassCorrelation.get(COMMODITY, CREDIT_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.25"), SimmRiskClassCorrelation.get(COMMODITY, CREDIT_NON_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.39"), SimmRiskClassCorrelation.get(COMMODITY, EQUITY));
    Assert.assertEquals(new BigDecimal("1"), SimmRiskClassCorrelation.get(COMMODITY, COMMODITY));
    Assert.assertEquals(new BigDecimal("0.32"), SimmRiskClassCorrelation.get(COMMODITY, FX));
    Assert.assertEquals(new BigDecimal("0.22"), SimmRiskClassCorrelation.get(FX, INTEREST_RATE));
    Assert.assertEquals(new BigDecimal("0.27"), SimmRiskClassCorrelation.get(FX, CREDIT_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.18"), SimmRiskClassCorrelation.get(FX, CREDIT_NON_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.24"), SimmRiskClassCorrelation.get(FX, EQUITY));
    Assert.assertEquals(new BigDecimal("0.32"), SimmRiskClassCorrelation.get(FX, COMMODITY));
    Assert.assertEquals(new BigDecimal("1"), SimmRiskClassCorrelation.get(FX, FX));
  }
}
