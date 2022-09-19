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

package com.acadiasoft.im.base.margin;

import com.acadiasoft.im.base.model.imtree.ImTree;
import com.acadiasoft.im.base.model.imtree.identifiers.TotalClass;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TotalMargin implements ImTree<TotalClass, ModelMargin> {

  private static final long serialVersionUID = 1L;
  private final static String LEVEL = "1.Total";
  private final BigDecimal margin;
  private final List<ModelMargin> children = new ArrayList<>();

  protected TotalMargin(BigDecimal margin, List<ModelMargin> children) {
    this.margin = margin;
    this.children.addAll(children);
  }

  public static TotalMargin build(ModelMargin child) {
    if (child.isMarginZero()) {
      return BlankImTree.buildTree();
    } else {
      return new TotalMargin(child.getMargin(), Collections.singletonList(child));
    }
  }

  public static TotalMargin build(ModelMargin one, ModelMargin two) {
    if (one.isMarginZero()) {
      return TotalMargin.build(two);
    } else if (two.isMarginZero()) {
      return TotalMargin.build(one);
    } else {
      BigDecimal sum = one.getMargin().add(two.getMargin());
      return new TotalMargin(sum, Arrays.asList(one, two));
    }
  }

  @Override
  public TotalClass getMarginIdentifier() {
    return TotalClass.TOTAL;
  }

  @Override
  public String getIdentifierLabel() {
    return TotalClass.TOTAL.getMarginIdentifier();
  }

  @Override
  public BigDecimal getMargin() {
    return margin;
  }

  @Override
  public List<ModelMargin> getChildren() {
    return new ArrayList<>(children);
  }

  @Override
  public String getTreeLevel() {
    return LEVEL;
  }

}
