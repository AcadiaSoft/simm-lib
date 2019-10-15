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
import com.acadiasoft.im.schedule.models.utils.ScheduleCalculationType;
import com.acadiasoft.im.simmple.engine.Simmple;
import com.acadiasoft.im.simmple.model.Crif;
import com.acadiasoft.im.simmple.model.ImRole;
import com.acadiasoft.im.simmple.model.result.ImTreeResult;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author alec.stewart
 */
public class ScheduleTest {
  
  public final FxRate fx = new NoConversionFxRate();

  @Test
  public void testScheduleWithPV1() {
    // every end dates is a year

    List<Crif> crifs = Arrays.asList(
        new Crif("trade1", "2018-02-01", "2019-02-01", null, null, "Schedule", "Rates", "Notional", "", "", "", "", "100000.00", "USD", "100000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade1", "2018-02-01", "2019-02-01", null, null, "Schedule", "Rates", "PV", "", "", "", "", "500.00", "USD", "500.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade2", "2018-02-01", "2019-02-01", null, null, "Schedule", "FX", "Notional", "", "", "", "", "-50000.00", "USD", "-50000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade2", "2018-02-01", "2019-02-01", null, null, "Schedule", "FX", "PV", "", "", "", "", "-100.00", "USD", "-100.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade3", "2018-02-01", "2019-02-01", null, null, "Schedule", "Rates", "Notional", "", "", "", "", "200000.00", "USD", "200000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade3", "2018-02-01", "2019-02-01", null, null, "Schedule", "Rates", "PV", "", "", "", "", "-25.00", "USD", "-25.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade4", "2018-02-01", "2019-02-01", null, null, "Schedule", "Credit", "Notional", "", "", "", "", "300000.00", "USD", "300000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade4", "2018-02-01", "2019-02-01", null, null, "Schedule", "Credit", "PV", "", "", "", "", "20.00", "USD", "20.00", "CFTC,SEC", "CFTC,SEC")
    );

    ImTreeResult pledgorScheduleIM = Simmple.calculateScheduleWorstOf(crifs, fx, FxRate.USD, ImRole.PLEDGOR);
    ImTreeResult securedScheduleIM = Simmple.calculateScheduleWorstOf(crifs, fx, FxRate.USD, ImRole.SECURED);

    Assert.assertEquals(new BigDecimal("10269"), securedScheduleIM.getImTree().getMargin().setScale(0, RoundingMode.HALF_UP));
    Assert.assertEquals(new BigDecimal("-4800"), pledgorScheduleIM.getImTree().getMargin().setScale(0, RoundingMode.HALF_UP));
  }

  @Test
  public void testScheduleWithPV2() {
    // multiple different end dates

    List<Crif> crifs = Arrays.asList(
        new Crif("trade1", "2018-02-01", "2019-02-01", null, null, "Schedule", "Rates", "Notional", "", "", "", "", "250000.00", "USD", "250000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade1", "2018-02-01", "2019-02-01", null, null, "Schedule", "Rates", "PV", "", "", "", "", "850.00", "USD", "850.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade2", "2018-02-01", "2019-02-01", null, null, "Schedule", "FX", "Notional", "", "", "", "", "-500000.00", "USD", "-500000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade2", "2018-02-01", "2019-02-01", null, null, "Schedule", "FX", "PV", "", "", "", "", "120.00", "USD", "120.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade3", "2018-02-01", "2019-02-01", null, null, "Schedule", "Rates", "Notional", "", "", "", "", "-200000.00", "USD", "-200000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade3", "2018-02-01", "2019-02-01", null, null, "Schedule", "Rates", "PV", "", "", "", "", "-45.00", "USD", "-45.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade4", "2018-02-01", "2019-02-01", null, null, "Schedule", "Credit", "Notional", "", "", "", "", "30000.00", "USD", "30000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade4", "2018-02-01", "2019-02-01", null, null, "Schedule", "Credit", "PV", "", "", "", "", "-200.00", "USD", "-200.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade5", "2018-02-01", "2022-02-01", null, null, "Schedule", "Equity", "Notional", "", "", "", "", "120000.00", "USD", "120000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade5", "2018-02-01", "2022-02-01", null, null, "Schedule", "Equity", "PV", "", "", "", "", "-175.00", "USD", "-175.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade6", "2018-02-01", "2030-02-01", null, null, "Schedule", "Credit", "Notional", "", "", "", "", "-40000.00", "USD", "-40000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade6", "2018-02-01", "2030-02-01", null, null, "Schedule", "Credit", "PV", "", "", "", "", "230.00", "USD", "230.00", "CFTC,SEC", "CFTC,SEC")
    );


    ImTreeResult pledgorScheduleIM = Simmple.calculateScheduleWorstOf(crifs, fx, FxRate.USD, ImRole.PLEDGOR);
    ImTreeResult securedScheduleIM = Simmple.calculateScheduleWorstOf(crifs, fx, FxRate.USD, ImRole.SECURED);

//    System.out.println(pledgorScheduleIM.getAmount() + ", " + securedScheduleIM.getAmount());

    Assert.assertEquals(new BigDecimal("45109"), securedScheduleIM.getImTree().getMargin().setScale(0, RoundingMode.HALF_UP));
    Assert.assertEquals(new BigDecimal("-22840"), pledgorScheduleIM.getImTree().getMargin().setScale(0, RoundingMode.HALF_UP));
  }

  @Test
  public void testScheduleExtraNotionals() {
    // NOTE: blazer uploads fine; seems that NGR is just calculated from the given sensitivities

    List<Crif> crifs = Arrays.asList(
        new Crif("trade1", "2018-02-01", "2019-02-01", null, null, "Schedule", "Rates", "Notional", "", "", "", "", "250000.00", "USD", "250000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade1", "2018-02-01", "2019-02-01", null, null, "Schedule", "Rates", "PV", "", "", "", "", "850.00", "USD", "850.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade2", "2018-02-01", "2019-02-01", null, null, "Schedule", "FX", "Notional", "", "", "", "", "-500000.00", "USD", "-500000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade2", "2018-02-01", "2019-02-01", null, null, "Schedule", "FX", "PV", "", "", "", "", "120.00", "USD", "120.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade3", "2018-02-01", "2019-02-01", null, null, "Schedule", "Rates", "Notional", "", "", "", "", "-200000.00", "USD", "-200000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade3", "2018-02-01", "2019-02-01", null, null, "Schedule", "Rates", "PV", "", "", "", "", "-45.00", "USD", "-45.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade4", "2018-02-01", "2019-02-01", null, null, "Schedule", "Credit", "Notional", "", "", "", "", "30000.00", "USD", "30000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade4", "2018-02-01", "2019-02-01", null, null, "Schedule", "Credit", "PV", "", "", "", "", "-200.00", "USD", "-200.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade5", "2018-02-01", "2022-02-01", null, null, "Schedule", "Equity", "Notional", "", "", "", "", "120000.00", "USD", "120000.00", "CFTC,SEC", "CFTC,SEC"),
        new Crif("trade6", "2018-02-01", "2030-02-01", null, null, "Schedule", "Credit", "Notional", "", "", "", "", "-40000.00", "USD", "-40000.00", "CFTC,SEC", "CFTC,SEC")
    );

    ImTreeResult pledgorScheduleIM = Simmple.calculateScheduleWorstOf(crifs, fx, FxRate.USD, ImRole.PLEDGOR);
    ImTreeResult securedScheduleIM = Simmple.calculateScheduleWorstOf(crifs, fx, FxRate.USD, ImRole.SECURED);

//    System.out.println(pledgorScheduleIM.getAmount() + ", " + securedScheduleIM.getAmount());

    Assert.assertEquals(new BigDecimal("48447"), securedScheduleIM.getImTree().getMargin().setScale(0, RoundingMode.HALF_UP));
    Assert.assertEquals(new BigDecimal("-22840"), pledgorScheduleIM.getImTree().getMargin().setScale(0, RoundingMode.HALF_UP));
  }

}
