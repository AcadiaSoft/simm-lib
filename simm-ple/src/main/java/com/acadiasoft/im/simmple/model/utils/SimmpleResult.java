/*
 * Copyright (c) 2020 AcadiaSoft, Inc.
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

package com.acadiasoft.im.simmple.model.utils;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.base.margin.BlankImTree;
import com.acadiasoft.im.base.model.imtree.ImTree;
import com.acadiasoft.im.base.model.imtree.MarginIdentifier;
import com.acadiasoft.im.simmple.config.SimmpleConfig;
import com.acadiasoft.im.simmple.model.Crif;

import java.io.Serializable;

/**
 *
 * @author alec.stewart
 */
public class SimmpleResult implements Serializable {

  private final String regulator;
  private final String currency;
  private final ConversionImTree tree;

  public SimmpleResult(ImTree<? extends MarginIdentifier, ? extends ImTree> tree, String regulator, SimmpleConfig config) {
    this.tree = new ConversionImTree(tree).convert(config.imRole(), config.fxRate(), FxRate.USD, config.resultCurrency());
    this.regulator = regulator;
    this.currency = config.resultCurrency();
  }

  public static SimmpleResult empty(SimmpleConfig config) {
    return new SimmpleResult(BlankImTree.buildTree(), Crif.BLANK_REGULATOR_STRING, config);
  }

  public String getCurrency() {
    return currency;
  }

  public String getRegulator() {
    return regulator;
  }

  public ConversionImTree getImTree() {
    return tree;
  }

}
