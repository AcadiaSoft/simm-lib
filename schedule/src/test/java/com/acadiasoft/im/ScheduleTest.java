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

package com.acadiasoft.im;

import com.acadiasoft.im.schedule.engine.Schedule;
import com.acadiasoft.im.schedule.models.ScheduleNotional;
import com.acadiasoft.im.schedule.models.SchedulePv;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 *
 * @author alec.stewart
 */
public class ScheduleTest {

  @Test
  public void testNettingWorksAsExpected() {
    ScheduleNotional one = new ScheduleNotional("trade1", "Rates", "2018-09-12", "2018-11-23", "1000");
    ScheduleNotional two = new ScheduleNotional("trade1", "Rates", "2018-09-12", "2018-11-23", "-1000");
    Assert.assertEquals(BigDecimal.ZERO, Schedule.calculate(Arrays.asList(one, two), BigDecimal.ONE).setScale(0, RoundingMode.HALF_UP));
  }

  @Test
  public void testNettingWorksAsExpectedPv() {
    ScheduleNotional notional = new ScheduleNotional("trade1", "Rates", "2018-09-12", "2018-11-23", "1000");
    SchedulePv one = new SchedulePv("trade1", "Rates", "2018-09-12", "2018-11-23", "1000");
    SchedulePv two = new SchedulePv("trade1", "Rates", "2018-09-12", "2018-11-23", "-1000");
    Assert.assertEquals(new BigDecimal("10"), Schedule.calculate(Arrays.asList(notional), Arrays.asList(one, two)).setScale(0, RoundingMode.HALF_UP));
  }

  @Test
  public void testNettingAndAbsoluteNotional() {
    ScheduleNotional notional1 = new ScheduleNotional("trade1", "Rates", "2018-09-12", "2018-11-23", "1000");
    ScheduleNotional notional2 = new ScheduleNotional("trade2", "Rates", "2018-09-12", "2018-11-23", "-1000");
    SchedulePv pv1a = new SchedulePv("trade1", "Rates", "2018-09-12", "2018-11-23", "2000");
    SchedulePv pv1b = new SchedulePv("trade1", "Rates", "2018-09-12", "2018-11-23", "-1000");
    SchedulePv pv2 = new SchedulePv("trade2", "Rates", "2018-09-12", "2018-11-23", "-1000");
    Assert.assertEquals(new BigDecimal("8"), Schedule.calculate(Arrays.asList(notional1, notional2), Arrays.asList(pv1a, pv1b, pv2)).setScale(0, RoundingMode.HALF_UP));
  }

}
