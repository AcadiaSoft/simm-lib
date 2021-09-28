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

package com.acadiasoft.im.base.margin;

import com.acadiasoft.im.base.model.imtree.ImTree;
import com.acadiasoft.im.base.model.imtree.identifiers.BundleClass;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class BundleMargin implements ImTree<BundleClass, SingleMargin> {

  private final String level;
  private final BigDecimal margin;
  private final BundleClass bundle;
  private final List<SingleMargin> children = new ArrayList<>();

  public BundleMargin(String level, BundleClass bundle, BigDecimal margin, List<SingleMargin> children) {
    this.level = level;
    this.margin = margin;
    this.bundle = bundle;
    this.children.addAll(children);
  }

  @Override
  public BundleClass getMarginIdentifier() {
    return bundle;
  }

  @Override
  public String getIdentifierLabel() {
    return bundle.getMarginIdentifier();
  }

  @Override
  public BigDecimal getMargin() {
    return margin;
  }

  @Override
  public List<SingleMargin> getChildren() {
    return new ArrayList<>(children);
  }

  @Override
  public String getTreeLevel() {
    return level;
  }

}
