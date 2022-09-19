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
import com.acadiasoft.im.base.model.imtree.MarginIdentifier;
import com.acadiasoft.im.base.model.imtree.identifiers.BasicIdentifier;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author joe.peterson
 *
 */
@SuppressWarnings("unchecked")
public class BasicImTree implements ImTree<BasicIdentifier, BasicImTree> {

  private static final long serialVersionUID = 1L;
  private final String level;
  private final BigDecimal margin;
  private final String identifier;
  private final List<BasicImTree> children;

  @JsonCreator
  public BasicImTree(@JsonProperty("level") String level, @JsonProperty("label") String label, @JsonProperty("margin") BigDecimal margin,
      @JsonProperty("children") List<BasicImTree> children) {
    this.level = level;
    this.margin = margin;
    this.identifier = label;
    this.children = new ArrayList<>(children);
  }

  @SuppressWarnings("rawtypes")
  public BasicImTree(ImTree<? extends MarginIdentifier, ? extends ImTree> tree) {
    this.level = tree.getTreeLevel();
    this.margin = tree.getMargin();
    this.identifier = tree.getMarginIdentifier().getMarginIdentifier();
    this.children = tree.getChildren().stream()
        // FIXME: why does compiler require this cast??? should be redundant...
        .map(t -> new BasicImTree((ImTree<MarginIdentifier, ImTree>) t)).collect(Collectors.toList());
  }

  @Override
  public BasicIdentifier getMarginIdentifier() {
    return new BasicIdentifier(identifier);
  }

  @Override
  public String getIdentifierLabel() {
    return identifier;
  }

  @Override
  public BigDecimal getMargin() {
    return margin;
  }

  @Override
  public List<BasicImTree> getChildren() {
    return new ArrayList<>(children);
  }

  @Override
  public String getTreeLevel() {
    return level;
  }

}
