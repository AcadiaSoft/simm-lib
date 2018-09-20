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

package com.acadiasoft.im.simmple;

import com.acadiasoft.im.base.fx.FxConverter;
import com.acadiasoft.im.base.fx.NoConversionFxRate;
import com.acadiasoft.im.simm.engine.Simm;
import com.acadiasoft.im.simm.model.utils.SimmCalculationType;
import com.acadiasoft.im.simmple.engine.Simmple;
import com.acadiasoft.im.simmple.model.Crif;
import com.acadiasoft.im.simmple.model.ImRole;
import com.acadiasoft.im.simmple.model.result.ImResult;
import com.acadiasoft.im.simmple.model.result.ImTreeResult;
import com.acadiasoft.im.simmple.model.utils.SimmpleConversions;
import com.acadiasoft.im.simmple.model.utils.SimmpleUtils;
import org.junit.Assert;
import org.junit.Test;

import javax.management.relation.Role;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author alec.stewart
 */
public class WorstOfTest {

  public final FxConverter fx = new FxConverter(new NoConversionFxRate());

  @Test
  public void testWorstOfInclude() {
    Crif one = new Crif("1", "2018-02-01", "2019-02-01", null, null, "SIMM-P", "RatesFX", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "1000.00", "included", "");
    Crif two = new Crif("2", "2018-02-01", "2019-02-01", null, null, "SIMM-P", "RatesFX", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "1000.00", "", "included");

    BigDecimal amountPost = Simm.calculateStandard(Arrays.asList(SimmpleConversions.convertToSensitivity(one, fx, ImRole.PLEDGOR), SimmpleConversions.convertToSensitivity(two, fx, ImRole.PLEDGOR)), "USD");
    ImTreeResult post = Simmple.calculateSimmWorstOf(Arrays.asList(one, two),"USD", fx, "USD", ImRole.PLEDGOR, SimmCalculationType.STANDARD);
    Assert.assertEquals(amountPost.negate(), post.getImTree().getMargin());
    Assert.assertEquals("included", post.getRegulator());
    Assert.assertEquals("USD", post.getCurrency());
  }

  @Test
  public void testWorstOfAllSame() {
    Crif one = new Crif("1","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "1000.00", "CFTC,SEC", "");
    Crif two = new Crif("2","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "GBP", "", "", "", "5000.00", "USD", "5000.00", "CFTC,SEC", "");

    BigDecimal amountPost = Simm.calculateStandard(Arrays.asList(SimmpleConversions.convertToSensitivity(one, fx, ImRole.PLEDGOR), SimmpleConversions.convertToSensitivity(two, fx, ImRole.PLEDGOR)), "USD");
    ImTreeResult post = Simmple.calculateSimmWorstOf(Arrays.asList(one, two),"USD", fx, "USD", ImRole.PLEDGOR, SimmCalculationType.STANDARD);
    Assert.assertEquals(amountPost.negate(), post.getImTree().getMargin());
    Assert.assertEquals("CFTC", post.getRegulator());
    Assert.assertEquals("USD", post.getCurrency());

    ImTreeResult collect = Simmple.calculateSimmWorstOf(Arrays.asList(one, two),"USD", fx, "USD", ImRole.SECURED, SimmCalculationType.STANDARD);
    Assert.assertEquals(BigDecimal.ZERO, collect.getImTree().getMargin());
    Assert.assertEquals("", collect.getRegulator());
    Assert.assertEquals("USD", collect.getCurrency());
  }

  @Test
  public void testWorstOfAllSameReverse() {
    Crif one = new Crif("1","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "1000.00", "SEC,CFTC", "");
    Crif two = new Crif("2","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "GBP", "", "", "", "5000.00", "USD", "5000.00", "SEC,CFTC", "");

    BigDecimal amountPost = Simm.calculateStandard(Arrays.asList(SimmpleConversions.convertToSensitivity(one, fx, ImRole.PLEDGOR), SimmpleConversions.convertToSensitivity(two, fx, ImRole.PLEDGOR)), "USD");
    ImTreeResult post = Simmple.calculateSimmWorstOf(Arrays.asList(one, two),"USD", fx, "USD", ImRole.PLEDGOR, SimmCalculationType.STANDARD);
    Assert.assertEquals(amountPost.negate(), post.getImTree().getMargin());
    Assert.assertEquals("CFTC", post.getRegulator());
    Assert.assertEquals("USD", post.getCurrency());

    ImTreeResult collect = Simmple.calculateSimmWorstOf(Arrays.asList(one, two),"USD", fx, "USD", ImRole.SECURED, SimmCalculationType.STANDARD);
    Assert.assertEquals(BigDecimal.ZERO, collect.getImTree().getMargin());
    Assert.assertEquals("", collect.getRegulator());
    Assert.assertEquals("USD", collect.getCurrency());
  }

  @Test
  public void testWorstOfCompound() {
    Crif one = new Crif("1","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "1000.00", "CFTC", "" );
    Crif two = new Crif("2","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "GBP", "", "", "", "5000.00", "USD", "5000.00", "SEC,CFTC", "");

    BigDecimal amountPost = Simm.calculateStandard(Arrays.asList(SimmpleConversions.convertToSensitivity(one, fx, ImRole.PLEDGOR), SimmpleConversions.convertToSensitivity(two, fx, ImRole.PLEDGOR)), "USD");
    ImTreeResult post = Simmple.calculateSimmWorstOf(Arrays.asList(one, two),"USD", fx, "USD", ImRole.PLEDGOR, SimmCalculationType.STANDARD);
    Assert.assertEquals(amountPost.negate(), post.getImTree().getMargin());
    Assert.assertEquals("CFTC", post.getRegulator());
    Assert.assertEquals("USD", post.getCurrency());
  }

}
