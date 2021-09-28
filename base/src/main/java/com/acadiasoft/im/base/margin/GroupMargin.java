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
import com.acadiasoft.im.base.model.imtree.identifiers.GroupClass;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class GroupMargin implements ImTree<GroupClass, BatchMargin> {

  private final String level;
  private final BigDecimal margin;
  private final GroupClass group;
  private final List<BatchMargin> children = new ArrayList<>();

  public GroupMargin(String level, GroupClass group, BigDecimal margin, List<BatchMargin> children) {
    this.level = level;
    this.margin = margin;
    this.group = group;
    this.children.addAll(children);
  }

  @Override
  public GroupClass getMarginIdentifier() {
    return group;
  }

  @Override
  public String getIdentifierLabel() {
    return group.getMarginIdentifier();
  }

  @Override
  public BigDecimal getMargin() {
    return margin;
  }

  @Override
  public List<BatchMargin> getChildren() {
    return new ArrayList<>(children);
  }

  @Override
  public String getTreeLevel() {
    return level;
  }

}
