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

package com.acadiasoft.simm.util;

import com.acadiasoft.simm.model.product.ProductClass;
import com.acadiasoft.simm.model.risk.RiskClass;
import com.acadiasoft.simm.model.risk.RiskType;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SensitivityUtilsTest {

  @Test
  public void testMapByProductClass() {
    Sensitivity s1 = new Sensitivity(ProductClass.COMMODITY.getLabel(), "rt", "q", "l1", "l2", null, null);
    Sensitivity s1b = new Sensitivity(ProductClass.COMMODITY.getLabel(), "rt", "q", "l1", "l2", null, null);
    Sensitivity s2 = new Sensitivity(ProductClass.RATES_FX.getLabel(), "rt", "q", "l1", "l2", null, null);
    Map<ProductClass, List<Sensitivity>> mapByProductClass = SensitivityUtils.mapByProductClass(Arrays.asList(s1, s1b, s2));

    Assert.assertEquals(2, mapByProductClass.size());
    Assert.assertEquals(2, mapByProductClass.get(ProductClass.COMMODITY).size());
    Assert.assertEquals(1, mapByProductClass.get(ProductClass.RATES_FX).size());
  }

  @Test
  public void testMapByRiskClass() {
    Sensitivity s1 = new Sensitivity("pc", RiskType.RISK_TYPE_COMMODITY, "q", "l1", "l2", null, null);
    Sensitivity s1b = new Sensitivity("pc", RiskType.RISK_TYPE_COMMODITY, "q", "l1", "l2", null, null);
    Sensitivity s2 = new Sensitivity("pc", RiskType.RISK_TYPE_FX, "q", "l1", "l2", null, null);
    Map<RiskClass, List<Sensitivity>> mapByRiskType = SensitivityUtils.mapByRiskType(Arrays.asList(s1, s1b, s2));

    Assert.assertEquals(2, mapByRiskType.size());
    Assert.assertEquals(2, mapByRiskType.get(RiskClass.COMMODITY).size());
    Assert.assertEquals(1, mapByRiskType.get(RiskClass.FX).size());
  }

  @Test
  public void testNetSensitivitiesByRiskFactor() {
    Sensitivity s1 = new Sensitivity("pc", RiskType.RISK_TYPE_COMMODITY, "q", "1", "l1", "l2", new BigDecimal("3"));
    Sensitivity s1b = new Sensitivity("pc", RiskType.RISK_TYPE_COMMODITY, "q", "1", "l1", "l2", new BigDecimal("5"));
    Sensitivity s2 = new Sensitivity("pc", RiskType.RISK_TYPE_FX, "q", "2", "l1", "l2", new BigDecimal("7"));
    List<Sensitivity> nettedSensitivities = SensitivityUtils.netSensitivitiesByRiskFactor(RiskClass.COMMODITY, Arrays.asList(s1, s1b, s2));
    Assert.assertEquals(2, nettedSensitivities.size());
    Assert.assertEquals(new BigDecimal("8"), nettedSensitivities.get(0).getAmountUsd());
    Assert.assertEquals(new BigDecimal("7"), nettedSensitivities.get(1).getAmountUsd());
  }
}
