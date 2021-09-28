/*
 * Copyright (c) 2021 AcadiaSoft, Inc.
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

package com.acadiasoft.im.simm.engine.margin;

import com.acadiasoft.im.base.margin.BatchMargin;
import com.acadiasoft.im.base.margin.GroupMargin;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import com.acadiasoft.im.base.util.ListUtils;
import com.acadiasoft.im.simm.config.SimmConfig;
import com.acadiasoft.im.simm.model.Sensitivity;
import com.acadiasoft.im.simm.model.SensitivityIdentifier;
import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author alec.stewart
 */
public class RiskMargin extends GroupMargin {

  private static final String LEVEL = "4.RiskClass";

  private RiskMargin(RiskClass riskClass, BigDecimal margin, List<BatchMargin> marginBySensitivityClass) {
    super(LEVEL, riskClass, margin, marginBySensitivityClass);
  }

  public static RiskMargin calculate(RiskClass riskClass, List<Sensitivity> sensitivities, SimmConfig config) {
    List<SensitivityMargin> marginBySensitivityClass = ListUtils.groupBy(sensitivities, SensitivityIdentifier::getSensitivityClass).entrySet().stream()
      .map(entry -> SensitivityMargin.calculate(riskClass, entry.getKey(), entry.getValue(), config))
      .collect(Collectors.toList());
    // we sum across the sensitivity margins in the Risk Class to get the total IM for that Risk Class
    // NOTE: since each Risk Class Margin only has the sensitivities associated with its own risk class, we can do a straight
    //    sum because all of the base corr sensitivities are in only the Credit Qualifying Risk Class by definition
    BigDecimal sum = BigDecimalUtils.sum(marginBySensitivityClass, SensitivityMargin::getMargin);
    return new RiskMargin(riskClass, sum, new ArrayList<>(marginBySensitivityClass));
  }

}
