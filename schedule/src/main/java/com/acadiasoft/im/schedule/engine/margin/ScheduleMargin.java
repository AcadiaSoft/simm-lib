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

package com.acadiasoft.im.schedule.engine.margin;

import com.acadiasoft.im.base.imtree.identifiers.ImModelClass;
import com.acadiasoft.im.base.imtree.ImTree;
import com.acadiasoft.im.base.imtree.identifiers.MarginIdentifier;
import com.acadiasoft.im.schedule.models.ScheduleIdentifier;
import com.acadiasoft.im.schedule.models.ScheduleNotional;
import com.acadiasoft.im.schedule.models.SchedulePv;
import com.acadiasoft.im.schedule.models.imtree.identifiers.ScheduleProductClass;
import com.acadiasoft.im.schedule.engine.ScheduleCalculationUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author alec.stewart
 */
public class ScheduleMargin implements ImTree {

  private final static String LEVEL = "2.ImModel";
  private final static MarginIdentifier IDENTIFIER = ImModelClass.SCHEDULE;
  private final BigDecimal margin;
  private final List<ScheduleProductMargin> children = new ArrayList<>();

  private ScheduleMargin(BigDecimal margin, List<ScheduleProductMargin> children) {
    this.margin = margin;
    this.children.addAll(children);
  }

  public static ScheduleMargin calculate(List<ScheduleNotional> notionals, BigDecimal netGrossRate) {
    Map<ScheduleProductClass, List<ScheduleNotional>> notionalMap = notionals.stream()
        .collect(Collectors.groupingBy(ScheduleIdentifier::getProductClass, Collectors.toList()));
    List<ScheduleProductMargin> productMargins = notionalMap.entrySet().stream()
        .map(e -> ScheduleProductMargin.calculate(e.getKey(), e.getValue(), netGrossRate))
        .collect(Collectors.toList());
    BigDecimal margin = ScheduleCalculationUtils.calculate(notionals, netGrossRate);
    return new ScheduleMargin(margin, productMargins);
  }

  public static ScheduleMargin calculate(List<ScheduleNotional> notionals, List<SchedulePv> pvs) {
    Map<ScheduleProductClass, List<ScheduleNotional>> notionalMap = notionals.stream()
        .collect(Collectors.groupingBy(ScheduleIdentifier::getProductClass, Collectors.toList()));
    Map<ScheduleProductClass, List<SchedulePv>> pvMap = pvs.stream()
        .collect(Collectors.groupingBy(ScheduleIdentifier::getProductClass, Collectors.toList()));
    List<ScheduleProductMargin> productMargins = notionalMap.entrySet().stream()
        .map(e -> {
          List<SchedulePv> list = new ArrayList<>();
          if (pvMap.containsKey(e.getKey())) list = pvMap.get(e.getKey());
          return ScheduleProductMargin.calculate(e.getKey(), e.getValue(), list);
        })
        .collect(Collectors.toList());
    BigDecimal margin = ScheduleCalculationUtils.calculate(notionals, pvs);
    return new ScheduleMargin(margin, productMargins);
  }

  @Override
  public String getTreeLevel() {
    return LEVEL;
  }

  @Override
  public BigDecimal getMargin() {
    return margin;
  }

  @Override
  public MarginIdentifier getMarginIdentifier() {
    return IDENTIFIER;
  }

  @Override
  public List<ImTree> getChildren() {
    return new ArrayList<>(children);
  }

}
