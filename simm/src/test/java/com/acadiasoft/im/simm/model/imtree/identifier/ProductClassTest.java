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

package com.acadiasoft.im.simm.model.imtree.identifier;

import com.acadiasoft.im.simm.model.imtree.identifiers.ProductClass;
import org.junit.Assert;
import org.junit.Test;

public class ProductClassTest {

  @Test
  public void assertIndexes() {
    Assert.assertEquals(ProductClass.RATES_FX, ProductClass.values()[0]);
    Assert.assertEquals(ProductClass.CREDIT, ProductClass.values()[1]);
    Assert.assertEquals(ProductClass.EQUITY, ProductClass.values()[2]);
    Assert.assertEquals(ProductClass.COMMODITY, ProductClass.values()[3]);
  }

  @Test
  public void testIndexOf() {
    Assert.assertEquals(0, ProductClass.indexOf(ProductClass.RATES_FX.getLabel()));
    Assert.assertEquals(1, ProductClass.indexOf(ProductClass.CREDIT.getLabel()));
    Assert.assertEquals(2, ProductClass.indexOf(ProductClass.EQUITY.getLabel()));
    Assert.assertEquals(3, ProductClass.indexOf(ProductClass.COMMODITY.getLabel()));
  }

  @Test
  public void testGetByLabel() {
    Assert.assertEquals(ProductClass.RATES_FX, ProductClass.determineProductClass(ProductClass.RATES_FX.getLabel().toLowerCase()));
    Assert.assertEquals(ProductClass.CREDIT, ProductClass.determineProductClass(ProductClass.CREDIT.getLabel().toLowerCase()));
    Assert.assertEquals(ProductClass.EQUITY, ProductClass.determineProductClass(ProductClass.EQUITY.getLabel().toLowerCase()));
    Assert.assertEquals(ProductClass.COMMODITY, ProductClass.determineProductClass(ProductClass.COMMODITY.getLabel().toLowerCase()));
  }

  @Test(expected = RuntimeException.class)
  public void testGetByLabelUnknown() {
    ProductClass.determineProductClass("???");
  }
}
