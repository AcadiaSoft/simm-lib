package com.acadiasoft.simm.engine.margin;

import com.acadiasoft.simm.model.object.imtree.ImTree;
import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import com.acadiasoft.simm.model.object.imtree.identifiers.TotalClass;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TotalMargin implements ImTree {

  private final static String LEVEL = "1.Total";
  private final BigDecimal margin;
  private final List<ImTree> children = new ArrayList();

  private TotalMargin(BigDecimal margin, List<ImTree> children) {
    this.margin = margin;
    this.children.addAll(children);
  }

  public static TotalMargin build(BigDecimal margin, ImTree child) {
    return new TotalMargin(margin, Arrays.asList(child));
  }

  public static TotalMargin build(BigDecimal margin, ImTree child1, ImTree child2) {
    return new TotalMargin(margin, Arrays.asList(child1, child2));
  }

  @Override
  public MarginIdentifier getMarginIdentifier() {
    return TotalClass.TOTAL;
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
    return LEVEL;
  }

}
