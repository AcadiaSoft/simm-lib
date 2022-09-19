/*
 * Copyright (c) 2022 Acadia, Inc.
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

package com.acadiasoft.im.schedule.models.utils;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.schedule.models.ScheduleNotional;
import com.acadiasoft.im.schedule.models.SchedulePv;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.function.Function;

public class ScheduleCalculationUtils {

  private static final BigDecimal STRAIGHT_FRACTION = new BigDecimal("0.4");
  private static final BigDecimal NGR_FRACTION = new BigDecimal("0.6");

  public static BigDecimal calculateMargin(BigDecimal grossIm, BigDecimal netGrossRate) {
    // SCHEDULE_IM = GROSS_IM * (0.4 + (0.6 * NGR))
    return grossIm.multiply(STRAIGHT_FRACTION.add(NGR_FRACTION.multiply(netGrossRate)));
  }

  private static Function<SchedulePv, BigDecimal> getInversePv(FxRate fx) {
    return pv -> pv.getPresentValueInUsd(fx).negate();
  }

  private static Function<SchedulePv, BigDecimal> getInversePvMaxZero(FxRate fx) {
    return pv -> pv.getPresentValueInUsd(fx).negate().max(BigDecimal.ZERO);
  }

  public static BigDecimal calculateNgr(List<SchedulePv> pvs, FxRate fx) {
    // Net_Replacement_Cost = max(0,sum(-MtM))
    BigDecimal netReplacementCost = BigDecimalUtils.sum(pvs, getInversePv(fx)).max(BigDecimal.ZERO);
    // Gross_Replacement_Cost = sum(max(0, -MtM))
    BigDecimal grossReplacementCost = BigDecimalUtils.sum(pvs, getInversePvMaxZero(fx));
    // now calculate the NGR - if the gross cost is zero we default to 1
    return (grossReplacementCost.setScale(0, RoundingMode.UP).equals(BigDecimal.ZERO)) ? BigDecimal.ONE
        : BigDecimalUtils.divideWithPrecision(netReplacementCost, grossReplacementCost);
  }

  public static BigDecimal calculateGrossIm(List<ScheduleNotional> notionals, FxRate fx) {
    return notionals.stream() //
        .map(notional -> notional.getNotionalInUsd(fx).abs()) //
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

}
