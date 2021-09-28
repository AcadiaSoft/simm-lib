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

package com.acadiasoft.im.simm.model.imtree.identifiers;

import com.acadiasoft.im.base.model.imtree.identifiers.SiloClass;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * As defined in Appendix 1 section K of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public class ProductClass extends SiloClass {

  public static final ProductClass RATES_FX = new ProductClass("RatesFX", "Interest Rates and Foreign Exchange");
  public static final ProductClass CREDIT = new ProductClass("Credit", "Credit");
  public static final ProductClass EQUITY = new ProductClass("Equity", "Equity");
  public static final ProductClass COMMODITY = new ProductClass("Commodity", "Commodity");
  public static final ProductClass SINGLE = new ProductClass("Single", "The single product class that can contain all types");

  private static final String BAD_LABEL = "Unknown product class specified: [%s]";
  private static final Supplier<Stream<ProductClass>> ALL = () -> Stream.of(
    RATES_FX, CREDIT, EQUITY, COMMODITY
  );

  private final String description;

  private ProductClass(String label, String description) {
    super(label);
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public static ProductClass determineProductClass(String label) {
    return ALL.get().filter(product -> StringUtils.equalsIgnoreCase(label, product.label)).findAny()
      .orElseThrow(() -> new IllegalStateException(String.format(BAD_LABEL, label)));
  }
}
