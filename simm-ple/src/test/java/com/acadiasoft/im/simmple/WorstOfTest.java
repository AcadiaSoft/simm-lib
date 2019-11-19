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
import com.acadiasoft.im.simm.config.SimmCalculationType;
import com.acadiasoft.im.simm.engine.Simm;
import com.acadiasoft.im.simmple.config.ImRole;
import com.acadiasoft.im.simmple.engine.Simmple;
import com.acadiasoft.im.simmple.model.Crif;
import com.acadiasoft.im.simmple.model.DefaultCrif;
import com.acadiasoft.im.simmple.model.utils.SimmpleResult;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 *
 * @author alec.stewart
 */
public class WorstOfTest {

  public final FxRate fx = new NoConversionFxRate();

  @Test
  public void testWorstOfInclude() {
    DefaultCrif one = new DefaultCrif("1", "2018-02-01", "2019-02-01", null, null, "SIMM-P", "RatesFX", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "1000.00", "included", "");
    DefaultCrif two = new DefaultCrif("2", "2018-02-01", "2019-02-01", null, null, "SIMM-P", "RatesFX", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "1000.00", "", "included");

    BigDecimal amountPost = Simm.calculateStandard(Arrays.asList(one, two), "USD");
    SimmpleResult post = Simmple.calculateSimmWorstOf(Arrays.asList(one, two),"USD", fx, "USD", ImRole.PLEDGOR, SimmCalculationType.STANDARD);
    Assert.assertEquals(amountPost.negate(), post.getImTree().getMargin());
    Assert.assertEquals("included", post.getRegulator());
    Assert.assertEquals("USD", post.getCurrency());
  }

  @Test
  public void testWorstOfAllSame() {
    DefaultCrif one = new DefaultCrif("1","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "1000.00", "CFTC,SEC", "");
    DefaultCrif two = new DefaultCrif("2","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "GBP", "", "", "", "5000.00", "USD", "5000.00", "CFTC,SEC", "");

    BigDecimal amountPost = Simm.calculateStandard(Arrays.asList(one, two), "USD");
    SimmpleResult post = Simmple.calculateSimmWorstOf(Arrays.asList(one, two),"USD", fx, "USD", ImRole.PLEDGOR, SimmCalculationType.STANDARD);
    Assert.assertEquals(amountPost.negate(), post.getImTree().getMargin());
    Assert.assertEquals("CFTC", post.getRegulator());
    Assert.assertEquals("USD", post.getCurrency());

    SimmpleResult collect = Simmple.calculateSimmWorstOf(Arrays.asList(one, two),"USD", fx, "USD", ImRole.SECURED, SimmCalculationType.STANDARD);
    Assert.assertEquals(BigDecimal.ZERO, collect.getImTree().getMargin());
    Assert.assertEquals("", collect.getRegulator());
    Assert.assertEquals("USD", collect.getCurrency());
  }

  @Test
  public void testWorstOfAllSameReverse() {
    DefaultCrif one = new DefaultCrif("1","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "1000.00", "SEC,CFTC", "");
    DefaultCrif two = new DefaultCrif("2","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "GBP", "", "", "", "5000.00", "USD", "5000.00", "SEC,CFTC", "");

    BigDecimal amountPost = Simm.calculateStandard(Arrays.asList(one, two), "USD");
    SimmpleResult post = Simmple.calculateSimmWorstOf(Arrays.asList(one, two),"USD", fx, "USD", ImRole.PLEDGOR, SimmCalculationType.STANDARD);
    Assert.assertEquals(amountPost.negate(), post.getImTree().getMargin());
    Assert.assertEquals("CFTC", post.getRegulator());
    Assert.assertEquals("USD", post.getCurrency());

    SimmpleResult collect = Simmple.calculateSimmWorstOf(Arrays.asList(one, two),"USD", fx, "USD", ImRole.SECURED, SimmCalculationType.STANDARD);
    Assert.assertEquals(BigDecimal.ZERO, collect.getImTree().getMargin());
    Assert.assertEquals("", collect.getRegulator());
    Assert.assertEquals("USD", collect.getCurrency());
  }

  @Test
  public void testWorstOfCompound() {
    DefaultCrif one = new DefaultCrif("1","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "1000.00", "CFTC", "" );
    DefaultCrif two = new DefaultCrif("2","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "GBP", "", "", "", "5000.00", "USD", "5000.00", "SEC,CFTC", "");

    BigDecimal amountPost = Simm.calculateStandard(Arrays.asList(one, two), "USD");
    SimmpleResult post = Simmple.calculateSimmWorstOf(Arrays.asList(one, two),"USD", fx, "USD", ImRole.PLEDGOR, SimmCalculationType.STANDARD);
    Assert.assertEquals(amountPost.negate(), post.getImTree().getMargin());
    Assert.assertEquals("CFTC", post.getRegulator());
    Assert.assertEquals("USD", post.getCurrency());
  }

  @Test
  public void testAlwaysIncludedFunctionality() {
    DefaultCrif one = new DefaultCrif("1","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "1000.00", "CFTC", "" );
    DefaultCrif two = new DefaultCrif("2","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "GBP", "", "", "", "5000.00", "USD", "5000.00", "SEC,CFTC", "");
    DefaultCrif three = new DefaultCrif("3","2018-02-01", "2019-02-01", null, null,"SIMM-P", "Credit", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "1000.00",  Crif.ALL_REGULATORS_STRING, "" );


    BigDecimal amountPost = Simm.calculateStandard(Arrays.asList(one, two, three), "USD");
    SimmpleResult post = Simmple.calculateSimmWorstOf(Arrays.asList(one, two, three),"USD", fx, "USD", ImRole.PLEDGOR, SimmCalculationType.STANDARD);
    Assert.assertEquals(amountPost.negate(), post.getImTree().getMargin());
    Assert.assertEquals("CFTC", post.getRegulator());
    Assert.assertEquals("USD", post.getCurrency());
    Assert.assertEquals(2, post.getImTree().getChildren().get(0).getChildren().size());
  }

  @Test
  public void testWorstOfOnlyAddsNonZeroMarginClassesWhenPossible() {
    DefaultCrif one = new DefaultCrif("1","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "1000.00", "CFTC", "" );
    DefaultCrif two = new DefaultCrif("2","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "GBP", "", "", "", "5000.00", "USD", "5000.00", "SEC,CFTC", "");
    DefaultCrif three = new DefaultCrif("3","2018-02-01", "2019-02-01", null, null,"SIMM-P", "Credit", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "1000.00",  Crif.ALL_REGULATORS_STRING, "" );

    BigDecimal amountPost = Simm.calculateStandard(Arrays.asList(one, two, three), "USD");
    SimmpleResult post = Simmple.calculateWorstOf(Arrays.asList(one, two, three),"USD", fx, "USD", ImRole.PLEDGOR, SimmCalculationType.STANDARD);
    Assert.assertEquals(amountPost.negate(), post.getImTree().getMargin());
    Assert.assertEquals("CFTC", post.getRegulator());
    Assert.assertEquals("USD", post.getCurrency());
    Assert.assertEquals(1, post.getImTree().getChildren().size());
    Assert.assertEquals("SIMM-P", post.getImTree().getChildren().get(0).getMarginIdentifier().getMarginIdentifier());
    Assert.assertEquals(2, post.getImTree().getChildren().get(0).getChildren().size());
  }

  @Test
  public void testWorstOfReturnsBlankTreeWhenZero() {
    DefaultCrif one = new DefaultCrif("1","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "0", "CFTC", "" );
    DefaultCrif two = new DefaultCrif("2","2018-02-01", "2019-02-01", null, null,"SIMM-P", "RatesFX", "Risk_FX", "GBP", "", "", "", "5000.00", "USD", "0", "SEC,CFTC", "");
    DefaultCrif three = new DefaultCrif("3","2018-02-01", "2019-02-01", null, null,"SIMM-P", "Credit", "Risk_FX", "EUR", "", "", "", "1000.00", "USD", "0",  Crif.ALL_REGULATORS_STRING, "" );

    BigDecimal amountPost = Simm.calculateStandard(Arrays.asList(one, two, three), "USD");
    SimmpleResult post = Simmple.calculateWorstOf(Arrays.asList(one, two, three),"USD", fx, "USD", ImRole.PLEDGOR, SimmCalculationType.STANDARD);
    Assert.assertEquals(amountPost.negate().setScale(0, RoundingMode.HALF_UP), post.getImTree().getMargin().setScale(0, BigDecimal.ROUND_HALF_UP));
    Assert.assertTrue(post.getImTree().getChildren().isEmpty());
  }

}
