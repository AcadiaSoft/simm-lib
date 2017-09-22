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

package com.acadiasoft.simm.model.commodity;

/**
 * As defined in Appendix 1 of ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public enum CommodityBucket {

  _1(1, "Coal"), // 
  _2(2, "Crude"), //  
  _3(3, "Light Ends"), //  
  _4(4, "Middle Distillates"), //  
  _5(5, "Heavy Distillates"), //  
  _6(6, "North America Natural Gas"), //  
  _7(7, "European Natural Gas"), //  
  _8(8, "North American Power"), //  
  _9(9, "European Power"), //  
  _10(10, "Freight"), //  
  _11(11, "Base Metals"), //  
  _12(12, "Precious Metals"), //  
  _13(13, "Grains"), //  
  _14(14, "Softs"), //  
  _15(15, "Livestock"), //  
  _16(16, "Other"), //
  _17(17, "Indexes");

  private final int bucket;
  private final String label;

  private CommodityBucket(int bucket, String label) {
    this.bucket = bucket;
    this.label = label;
  }

  public int getBucket() {
    return bucket;
  }

  public String getLabel() {
    return label;
  }

  public static CommodityBucket getBucket(String b) {
    for (CommodityBucket cmb : values()) {
      if (Integer.valueOf(b) == cmb.getBucket()) {
        return cmb;
      }
    }

    throw new RuntimeException("found bucket that doesn't exist: " + b);
  }

}
