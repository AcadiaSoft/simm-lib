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

package com.acadiasoft.im.simmple.model.utils;

import com.acadiasoft.im.base.fx.FxConverter;
import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.schedule.models.ScheduleNotional;
import com.acadiasoft.im.schedule.models.SchedulePv;
import com.acadiasoft.im.simm.model.*;
import com.acadiasoft.im.simm.model.param.HoldingPeriod;
import com.acadiasoft.im.simmple.model.Crif;
import com.acadiasoft.im.simmple.model.ImRole;

import java.math.BigDecimal;

public class SimmpleConversions {

  static final BigDecimal SQRT10 = BigDecimalUtils.sqrt(BigDecimal.TEN);

  public static Sensitivity convertToSensitivity(Crif crif, FxConverter fx, ImRole role) {
    BigDecimal amountUSD = getCrifAmountUsd(crif, fx);
    if (role.equals(ImRole.PLEDGOR)) amountUSD = amountUSD.negate();
    return new Sensitivity(crif.getProductClass(), crif.getRiskType(), crif.getQualifier(), crif.getBucket(), crif.getLabel1(), crif.getLabel2(), amountUSD);
  }

  public static ProductMultiplier convertToMultiplier(Crif crif) {
    return new ProductMultiplier(crif.getQualifier(), crif.getAmount());
  }

  public static AddOnNotionalFactor convertToFactor(Crif crif) {
    return new AddOnNotionalFactor(crif.getQualifier(), crif.getAmount());
  }

  public static AddOnNotional convertToSimmNotional(Crif crif, FxConverter fx) {
    return new AddOnNotional(crif.getQualifier(), getCrifAmountUsd(crif, fx));
  }

  public static AddOnFixedAmount convertToFixed(Crif crif, FxConverter fx, HoldingPeriod holdingPeriod) {
    return new AddOnFixedAmount(getCrifAmountUsd(crif, fx)
            .divide(holdingPeriod == HoldingPeriod.TenDay ? BigDecimal.ONE : SQRT10));
  }

  public static ScheduleNotional convertToScheduleNotional(Crif crif, FxConverter fx) {
    return new ScheduleNotional(crif.getTradeId(), crif.getProductClass(), crif.getValuationDate(), crif.getEndDate(), getCrifAmountUsd(crif, fx).toPlainString());
  }

  public static SchedulePv convertToPv(Crif crif, FxConverter fx, ImRole role) {
    BigDecimal amountUsd = getCrifAmountUsd(crif, fx);
    if (role.equals(ImRole.SECURED)) amountUsd = amountUsd.negate(); // note that this is opposite the sensitivity conversion because it is an NPV (MTM)
    return new SchedulePv(crif.getTradeId(), crif.getProductClass(), crif.getValuationDate(), crif.getEndDate(), amountUsd.toPlainString());

  }

  public static BigDecimal getCrifAmountUsd(Crif crif, FxConverter fx) {
    if (crif.getAmountUSDString().isEmpty()) {
      // for sensitivities and parameters amountUSD is optional; however, you must have either
      // amount and a currency or and amountUSD which would allow us to convert to USD
      return fx.convert(crif.getAmount(), crif.getAmountCurrency(), FxRate.USD);
    } else {
      return crif.getAmountUSD();
    }
  }

  public static BigDecimal getCrifNotionalAmountUsd(Crif crif, FxConverter fx) {
    if (crif.getNotionalCurrency().equalsIgnoreCase(FxRate.USD)) {
      return crif.getNotional();
    } else {
      return fx.convert(crif.getNotional(), crif.getNotionalCurrency(), FxRate.USD);
    }
  }
}
