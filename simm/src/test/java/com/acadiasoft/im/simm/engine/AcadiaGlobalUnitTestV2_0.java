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

package com.acadiasoft.im.simm.engine;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.simm.model.AddOnNotional;
import com.acadiasoft.im.simm.model.AddOnNotionalFactor;
import com.acadiasoft.im.simm.model.ProductMultiplier;
import com.acadiasoft.im.simm.model.Sensitivity;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Created by alec.stewart on 9/6/17.
 */
public class AcadiaGlobalUnitTestV2_0 extends AbstractAcadiaUnitTestV2_0 {

  @Test // tested: All
  public void testGlobal() {
    List<AddOnNotionalFactor> factors = new ArrayList<>();
    factors.add(AN1);
    factors.add(AN2);
    List<AddOnNotional> notional = new ArrayList<>();
    notional.addAll(Arrays.asList(AN3, AN4, AN5));
    notional.addAll(Arrays.asList(AN6, AN7));
    notional.addAll(Arrays.asList(AN8));
    notional.addAll(Arrays.asList(AN9));
    List<ProductMultiplier> multipliers = Arrays.asList(CM12, IR10, EQ12, CQ16);
    List<Sensitivity> s = Arrays.asList(CM1, CM2, CM3, CM4, CM5, CM6, CM7, CM8, CM9, CM10, CM11, CQ1, CQ2, CQ3, CQ4, CQ5, CQ6, CQ7, CQ8, CQ9, CQ10, CQ11, CQ12, CQ13, CQ14, CQ15, BC1, BC2, BC3, BC4, CNQ1, CNQ2, CNQ3, CNQ4, CNQ5, CNQ6, CNQ7, CNQ8, EQ1, EQ2, EQ3, EQ4, EQ5, EQ6, EQ7, EQ8, EQ9, EQ10, EQ11, IR1, IR2, IR3, IR4, IR5, IR6, IR7, IR8, IR9, FX1, FX2, FX3, FX4, CMV1, CMV2, CMV3, CMV4, CMV5, CMV6, CQV1, CQV2, CQV3, CQV4, CQV5, CNQV1, CNQV2, CNQV3, CNQV4, CNQV5, EQV1, EQV2, EQV3, EQV4, EQV5, EQV6, EQV7, EQV8, EQV9, EQV10, FXV1, FXV2, FXV3, FXV4, FXV5, IRV1, IRV2, IRV3, IRV4, IRV5, IRV6, IRV7);
    Assert.assertEquals(new BigDecimal("190371821528"), Simm.calculateTotal(s, multipliers, factors, notional, Arrays.asList(AN10, AN11), FxRate.USD).setScale(0, RoundingMode.HALF_UP));
  }

}
