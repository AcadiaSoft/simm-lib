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

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.base.fx.NoConversionFxRate;
import com.acadiasoft.im.simm.engine.Simm;
import com.acadiasoft.im.simm.model.utils.SimmCalculationType;
import com.acadiasoft.im.simmple.engine.Simmple;
import com.acadiasoft.im.simmple.model.Crif;
import com.acadiasoft.im.simmple.model.ImRole;
import com.acadiasoft.im.simmple.model.result.ImTreeResult;
import com.acadiasoft.im.simmple.model.utils.SimmpleConversions;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author alec.stewart
 */
public class CalculationCurrencyTest {

  private final FxRate fx = new NoConversionFxRate();

  @Test
  public void testCalculationCurrencyBasic() {
    Crif one = new Crif("1a","2018-02-01", "2019-02-01", null, null, "SIMM-P", "RatesFX", "Risk_FX", "USD", "", "", "","1000.00","USD","1000.00", "CFTC", "CFTC");
    Crif two = new Crif("1b","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "EUR", "", "", "","5000.00","USD","5000.00", "CFTC", "CFTC");
    BigDecimal simmLibAmount = Simm.calculateStandard(Arrays.asList(SimmpleConversions.convertToSensitivity(one, fx, ImRole.PLEDGOR)), "GBP").negate();
    ImTreeResult simmpleAmount = Simmple.calculateSimmWorstOf(Arrays.asList(one, two), "EUR", fx, FxRate.USD, ImRole.PLEDGOR, SimmCalculationType.STANDARD);
    Assert.assertEquals(simmLibAmount, simmpleAmount.getImTree().getMargin());
  }

}
