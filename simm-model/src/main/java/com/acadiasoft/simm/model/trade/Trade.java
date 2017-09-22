/*
 * Copyright (c) 2017 AcadiaSoft, Inc.
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

package com.acadiasoft.simm.model.trade;

import com.acadiasoft.simm.model.ReflectiveEqualObject;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Trade extends ReflectiveEqualObject {

  private String id;
  private BigDecimal exposure;
  private List<Sensitivity> sensitivities = new ArrayList<>();

  public Trade() {
  }

  public Trade(String id) {
    super();
    this.id = id;
  }

  public Trade(String id, List<Sensitivity> sensitivities) {
    super();
    this.id = id;
    this.sensitivities = sensitivities;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Sensitivity> getSensitivities() {
    return sensitivities;
  }

  public void setSensitivities(List<Sensitivity> sensitivities) {
    this.sensitivities = sensitivities;
  }

  public BigDecimal getExposure() {
    return exposure;
  }

  public void setExposure(BigDecimal exposure) {
    this.exposure = exposure;
  }

}
