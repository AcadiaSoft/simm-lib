package com.acadiasoft.im.simm.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;

public class AssertUtils {

  private static final String TEST_RESULT_CSV = "SIMM 2.5 Unit Test Compare.csv";

  public static synchronized void assertEquals(boolean tenDay, String testId, String group, String riskMeasure, String elementOfCalcTested, String sensitivityIds,
      String passesRequired, String calculationMode, String simmDelta, String simmVega, String simmCurvature, String simmBaseCorr, String simmAddOn, BigDecimal expected,
      BigDecimal actual) {
    Assert.assertEquals(expected, actual.setScale(0, RoundingMode.HALF_UP));

    File f = new File(TEST_RESULT_CSV);
    List<String> lines = new ArrayList<>();
    if (!f.exists()) {
      lines.add(toCsv("Sort", "Span", "Combination ID", "Group", "Risk Measure", "Element of Calculation Tested", "Sensitivity IDs", "Passes Required", "Calculation Mode",
          "SIMM Delta", "SIMM Vega", "SIMM Curvature", "SIMM Base Corr", "SIMM AddOn", "SIMM Benchmark", "Calculated SIMM Exposure", "Difference"));
    }
    String spanValue = tenDay ? "10d" : "1d";

    String combinationId = testId.replaceAll("test", "");

    String replaceAll = combinationId//
        .replaceAll("C", "")//
        .replaceAll("JS", "")//
        .replaceAll("J", "")//
        .replaceAll("Unsegregated", "")//
        .replaceAll("Segregated", "");

    Integer sort = calculateSort(tenDay, testId, replaceAll);

    lines.add(toCsv(Integer.toString(sort), spanValue, combinationId, group, riskMeasure, elementOfCalcTested, sensitivityIds, passesRequired, calculationMode, //
        simmDelta, simmVega, simmCurvature, simmBaseCorr, simmAddOn, expected.toPlainString(), actual.toPlainString(), expected.subtract(actual).toPlainString()));

    try (FileWriter fw = new FileWriter(f, true)) {
      IOUtils.writeLines(lines, System.lineSeparator(), fw);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static Integer calculateSort(boolean tenDay, String testId, String replaceAll) {
    Integer sort = Integer.valueOf(replaceAll);
    if (tenDay)
      sort += 10000;
    if (testId.contains("J"))
      sort += 1000;
    if (testId.contains("JS"))
      sort += 1000;
    return sort;
  }

  private static String toCsv(String... strings) {
    StringBuffer sb = new StringBuffer();
    boolean first = true;
    for (String string : strings) {
      if (!first)
        sb.append(",");
      sb.append('"').append(string).append('"');
      first = false;
    }
    return sb.toString();
  }
}
