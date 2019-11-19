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

package com.acadiasoft.im.base.model;

import com.acadiasoft.im.base.margin.BasicImTree;
import com.acadiasoft.im.base.margin.ModelMargin;
import com.acadiasoft.im.base.margin.SiloMargin;
import com.acadiasoft.im.base.margin.TotalMargin;
import com.acadiasoft.im.base.model.imtree.identifiers.ImModelClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicImTreeSerializationIT {

  @Test
  public void testSerialization() throws JsonProcessingException {
    BasicImTree one = new BasicImTree("2.Whatever", "hello", new BigDecimal("3.0"), new ArrayList<>());
    BasicImTree two = new BasicImTree("2.Whatever", "other", new BigDecimal("3.5"), new ArrayList<>());
    BasicImTree three = new BasicImTree("2.Whatever", "new", new BigDecimal("5.0"), new ArrayList<>());
    BasicImTree four = new BasicImTree("2.Whatever", "another", new BigDecimal("30.0"), Arrays.asList(one, two, three));
    System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(four));
  }

  @Test
  public void testDeserialization() throws IOException {
    String serialized = "{\n" +
      "  \"level\" : \"2.Whatever\",\n" +
      "  \"label\" : \"another\",\n" +
      "  \"margin\" : 30.0,\n" +
      "  \"children\" : [ {\n" +
      "    \"level\" : \"2.Whatever\",\n" +
      "    \"label\" : \"hello\",\n" +
      "    \"margin\" : 3.0,\n" +
      "    \"children\" : [ ]\n" +
      "  }, {\n" +
      "    \"level\" : \"2.Whatever\",\n" +
      "    \"label\" : \"other\",\n" +
      "    \"margin\" : 3.5,\n" +
      "    \"children\" : [ ]\n" +
      "  }, {\n" +
      "    \"level\" : \"2.Whatever\",\n" +
      "    \"label\" : \"new\",\n" +
      "    \"margin\" : 5.0,\n" +
      "    \"children\" : [ ]\n" +
      "  } ]\n" +
      "}";

    BasicImTree tree = new ObjectMapper().readValue(serialized, BasicImTree.class);
    Assert.assertEquals("2.Whatever", tree.getTreeLevel());
    Assert.assertEquals("another", tree.getIdentifierLabel());
    Assert.assertEquals(3, tree.getChildren().size());
  }

  @Test
  public void testCasting() throws IOException {

    class Impl extends ModelMargin {
      public Impl(ImModelClass model, BigDecimal margin, List<SiloMargin> children) {
        super(model, margin, children);
      }
    }

    ModelMargin model = new Impl(ImModelClass.SIMM, new BigDecimal(30.1203), new ArrayList<>());
    TotalMargin total = TotalMargin.build(model);

    String serialized = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(total);
    System.out.println(serialized);

    BasicImTree tree = new ObjectMapper().readValue(serialized, BasicImTree.class);
    Assert.assertEquals("Total", tree.getIdentifierLabel());
    Assert.assertEquals("1.Total", tree.getTreeLevel());
    Assert.assertEquals(new BigDecimal(30.1203), tree.getMargin());
    Assert.assertEquals(1, tree.getChildren().size());
    Assert.assertEquals("SIMM-P", tree.getChildren().get(0).getIdentifierLabel());
  }

}
