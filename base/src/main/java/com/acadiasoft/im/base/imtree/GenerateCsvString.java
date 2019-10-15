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

package com.acadiasoft.im.base.imtree;

import com.acadiasoft.im.base.imtree.identifiers.TotalClass;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  Hacky method to make a CSV-formatted string from ImTree
 */
public class GenerateCsvString {

  private static final int TOTAL_COMMAS = 7;
  private static final String COMMA = ",";
  private static final String END_LINE = "\n";
  private static final String FLAT_CSV_HEADER = "Level,Im Model,Silo,RiskClass,SensitivityType,Bucket,WeightedSensitivity,ExposureAmount";

  public static String parseToFlatCsv(ImTree tree) {
    List<String> csv = internalFlatCsvBuilder(new ArrayList<>(), tree);
    csv.add(0, FLAT_CSV_HEADER);
    return String.join(END_LINE, csv);
  }

  private static List<String> internalFlatCsvBuilder(List<String> pastLine, ImTree tree) {
    List<String> currentLine = new ArrayList<>();
    currentLine.add(tree.getTreeLevel());
    pastLine.removeIf(string -> StringUtils.equalsIgnoreCase(string, TotalClass.TOTAL.getLabel()));
    if (!pastLine.isEmpty()) currentLine.addAll(pastLine.subList(1, pastLine.size()));
    currentLine.add(tree.getMarginIdentifier().getLabel());

    // now we need to add on any extra missing commas
    int currentCommaCount = currentLine.size() - 1;
    StringBuilder line = new StringBuilder(String.join(COMMA, currentLine));
    for (int i = 0; i < TOTAL_COMMAS - currentCommaCount; i++) {
      line.append(COMMA);
    }

    List<String> csvFormatted = new ArrayList<>();
    csvFormatted.add(line.toString() + tree.getMargin());
    for (ImTree child: tree.getChildren()) {
      csvFormatted.addAll(internalFlatCsvBuilder(currentLine, child));
    }

    return csvFormatted;
  }

}
