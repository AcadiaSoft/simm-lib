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

package com.acadiasoft.simm.model.sensitivity;

import com.acadiasoft.simm.model.ReflectiveEqualObject;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Conceptually from in Appendix 1 section B.8.b of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class WeightedSensitivity extends ReflectiveEqualObject implements Serializable {

  private static final long serialVersionUID = 1L;
  private BigDecimal weightedValue;
  private Sensitivity sensitivity;

  public WeightedSensitivity() {
  }

  public WeightedSensitivity(Sensitivity sensitivity, BigDecimal weightedValue) {
    this.sensitivity = sensitivity;
    this.weightedValue = weightedValue;
  }

  public BigDecimal getWeightedValue() {
    return weightedValue;
  }

  public Sensitivity getSensitivity() {
    return sensitivity;
  }

}
