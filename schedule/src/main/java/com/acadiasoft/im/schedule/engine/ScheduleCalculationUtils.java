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

package com.acadiasoft.im.schedule.engine;

import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.schedule.models.ScheduleNotional;
import com.acadiasoft.im.schedule.models.SchedulePv;
import com.acadiasoft.im.schedule.models.parameters.ScheduleParameters;

import java.math.BigDecimal;
import java.util.List;

public class ScheduleCalculationUtils {

  private static final BigDecimal STRAIGHT_FRACTION = new BigDecimal("0.4");
  private static final BigDecimal NGR_FRACTION = new BigDecimal("0.6");

  private static BigDecimal multiplyByParamsAndSum(List<ScheduleNotional> notionals) {
    return notionals.stream()
        .map(n -> n.getAmountUSD().abs().multiply(ScheduleParameters.get(n.getProductClass(), n.getValuationDate(), n.getEndDate())))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public static BigDecimal calculate(List<ScheduleNotional> notionals, List<SchedulePv> pvs) {
    // Net_Replacement_Cost = max(0,sum(-MtM))
    BigDecimal netReplacementCost = BigDecimalUtils.sum(pvs, pv -> pv.getAmountUSD().negate()).max(BigDecimal.ZERO);
    // Gross_Replacement_Cost = sum(max(0, -MtM))
    BigDecimal grossReplacementCost = BigDecimalUtils.sum(pvs, pv -> pv.getAmountUSD().negate().max(BigDecimal.ZERO));
    BigDecimal grossIM = multiplyByParamsAndSum(notionals);
    BigDecimal ngr = BigDecimal.ONE;
    if (!grossReplacementCost.stripTrailingZeros().equals(BigDecimal.ZERO)) {
      ngr = BigDecimalUtils.divideWithPrecision(netReplacementCost, grossReplacementCost);
    }

    // SCHEDULE_IM = GROSS_IM * (0.4 + (0.6 * NGR))
    return grossIM.multiply(STRAIGHT_FRACTION.add(NGR_FRACTION.multiply(ngr)));
  }

  public static BigDecimal calculate(List<ScheduleNotional> notionals, BigDecimal netGrossRate) {
    // SCHEDULE_IM = GROSS_IM * (0.4 + (0.6 * NGR))
    return multiplyByParamsAndSum(notionals).multiply(STRAIGHT_FRACTION.add(NGR_FRACTION.multiply(netGrossRate)));
  }

}
