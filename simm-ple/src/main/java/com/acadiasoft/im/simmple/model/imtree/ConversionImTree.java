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

package com.acadiasoft.im.simmple.model.imtree;


import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.base.imtree.ImTree;
import com.acadiasoft.im.base.imtree.identifiers.MarginIdentifier;
import com.acadiasoft.im.simmple.model.ImRole;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Swaps sign and currency of the input ImTree object
 *
 * @author alec.stewart
 *
 */
public class ConversionImTree implements ImTree {

  private final String level;
  private final MarginIdentifier identifier;
  private final BigDecimal margin;
  private final List<ImTree> children;

  private ConversionImTree(String level, MarginIdentifier identifier, BigDecimal margin, List<ImTree> children) {
    this.children = children;
    this.identifier = identifier;
    this.level = level;
    this.margin = margin;
  }

  public static ImTree convert(ImRole role, ImTree old, FxRate fx, String from, String to) {
    List<ImTree> newChildren = old.getChildren().stream().map(c -> convert(role, c, fx, from, to)).collect(Collectors.toList());
    BigDecimal convertedMargin = fx.convert(old.getMargin(), from, to).abs();
    if (role.equals(ImRole.PLEDGOR)) convertedMargin = convertedMargin.negate(); // we want to display pledgor im as negative
    return new ConversionImTree(old.getTreeLevel(), old.getMarginIdentifier(), convertedMargin, newChildren);
  }

  @Override
  public MarginIdentifier getMarginIdentifier() {
    return identifier;
  }

  @Override
  public BigDecimal getMargin() {
    return margin;
  }

  @Override
  public List<ImTree> getChildren() {
    List<ImTree> list = new ArrayList<>();
    list.addAll(children);
    return list;
  }

  @Override
  public String getTreeLevel() {
    return level;
  }
}
