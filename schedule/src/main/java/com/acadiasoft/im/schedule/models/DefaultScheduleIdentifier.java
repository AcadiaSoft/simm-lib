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

package com.acadiasoft.im.schedule.models;

import com.acadiasoft.im.base.model.imtree.identifiers.GroupClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class DefaultScheduleIdentifier extends GroupClass implements ScheduleIdentifier {

  private static final long serialVersionUID = 1L;
  private final String tradeId;
  private final String productClass;
  private final String riskType;
  private final String valuationDate;
  private final String endDate;

  public DefaultScheduleIdentifier(String tradeId, String productClass, String riskType, String valuationDate, String endDate) {
    super(tradeId);
    this.tradeId = tradeId;
    this.productClass = productClass;
    this.riskType = riskType;
    this.valuationDate = valuationDate;
    this.endDate = endDate;
  }

  public DefaultScheduleIdentifier(ScheduleIdentifier identifier, String riskType) {
    super(identifier.getTradeId());
    this.tradeId = identifier.getTradeId();
    this.productClass = identifier.getProductClass();
    this.riskType = riskType;
    this.valuationDate = identifier.getValuationDateAsString();
    this.endDate = identifier.getEndDateAsString();
  }

  @Override
  public String getTradeId() {
    return tradeId;
  }

  @Override
  public String getProductClass() {
    return productClass;
  }

  @Override
  public String getRiskType() {
    return riskType;
  }

  @Override
  public String getEndDateAsString() {
    return endDate;
  }

  @Override
  public String getValuationDateAsString() {
    return valuationDate;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof DefaultScheduleIdentifier))
      return false;
    DefaultScheduleIdentifier id = (DefaultScheduleIdentifier) other;
    return StringUtils.equalsIgnoreCase(tradeId, id.tradeId) //
        && StringUtils.equalsIgnoreCase(productClass, id.productClass) //
        && StringUtils.equalsIgnoreCase(valuationDate, id.valuationDate) //
        && StringUtils.equalsIgnoreCase(endDate, id.endDate);
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(tradeId) + Objects.hashCode(productClass);
    return result * 11 + Objects.hashCode(valuationDate) + Objects.hashCode(endDate);
  }

}
