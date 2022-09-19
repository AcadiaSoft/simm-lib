package com.acadiasoft.im.simm.calibrate;

import com.acadiasoft.im.simm.calibrate.utils.GeneratorUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class SimmDayGeneratorTest {

  private static final String HOLDING_PERIOD_ONE_DAY = "ONE_DAY";
  private static final String HOLDING_PERIOD_TEN_DAY = "TEN_DAY";

  private static final List<String> NOTIONAL_IDS = Arrays.asList("S_AN_3", "S_AN_4", "S_AN_5", "S_AN_6", "JS_AN_9", "S_AN");
  private static final List<String> NOTIONAL_FACTOR_IDS = Arrays.asList("S_AN_1", "S_AN_2", "JS_AN_10");
  private static final List<String> FIXED_AMOUNT_IDS = Arrays.asList("S_AN_7", "S_AN_8");
  private static final String TESTS_10D = "10d-tests.txt";
  private static final String TESTS_1D = "1d-tests.txt";

  @Test
  public void printUnitTestsForSimmTenDayTest() throws IOException {
    printTests(TESTS_10D, HOLDING_PERIOD_TEN_DAY);
  }

  @Test
  public void printUnitTestsForSimmOneDayTest() throws IOException {
    printTests(TESTS_1D, HOLDING_PERIOD_ONE_DAY);
  }

  private static void printTests(String testsFile, String holdingPeriod) throws IOException {
    try (InputStream resourceAsStream = SimmDayGeneratorTest.class.getResourceAsStream(testsFile)) {
      List<String> testLines = IOUtils.readLines(resourceAsStream, Charset.defaultCharset());
      boolean first = true;
      for (String testLine : testLines) {
        if (first) {
          first = false;
          continue;
        }
        String[] split = testLine.split("\t");
        if (split.length > 0) {
          if (split[0].startsWith("J"))
            continue;

          String[] allIds = split[4].split(",");
          List<String> fixedIds = new ArrayList<>();
          List<String> factorIds = new ArrayList<>();
          List<String> notionalIds = new ArrayList<>();
          List<String> multiplierIds = new ArrayList<>();
          List<String> sensitivityIds = new ArrayList<>();

          for (String rawId : allIds) {
            String idToUse = rawId.replaceAll("\"", "").replaceAll("All ", "");

            if ("S_".equals(idToUse)) {
              fixedIds.add("S_AN_FIXED");
              factorIds.add("S_AN_FACTORS");
              notionalIds.add("S_AN");
              multiplierIds.add("S_MUL");
              sensitivityIds.add("S_IR");
              sensitivityIds.add("S_FX");
              sensitivityIds.add("S_CRQ");
              sensitivityIds.add("S_CRNQ");
              sensitivityIds.add("S_EQ");
              sensitivityIds.add("S_CM");
              sensitivityIds.add("S_IRV");
              sensitivityIds.add("S_CRV");
              sensitivityIds.add("S_CNV");
              sensitivityIds.add("S_EQV");
              sensitivityIds.add("S_FXV");
              sensitivityIds.add("S_CMV");
            } else if ("S_AN".equals(idToUse)) {
              fixedIds.add("S_AN_FIXED");
              factorIds.add("S_AN_FACTORS");
              notionalIds.add("S_AN");
            } else if (FIXED_AMOUNT_IDS.contains(idToUse)) {
              fixedIds.add(idToUse);
            } else if (NOTIONAL_FACTOR_IDS.contains(idToUse)) {
              factorIds.add(idToUse);
            } else if (NOTIONAL_IDS.contains(idToUse)) {
              notionalIds.add(idToUse);
            } else if (idToUse.contains("_MUL")) {
              multiplierIds.add(idToUse);
            } else {
              sensitivityIds.add(idToUse);
            }
          }

          String testNameSuffix = "Total".equals(split[6]) ? "" : split[6];
          String fullTestName = "test" + split[0] + testNameSuffix;
          boolean tenDayHoldingPeriod = HOLDING_PERIOD_TEN_DAY.equals(holdingPeriod) ? true : false;

          System.out.println();
          System.out.println("/**");
          System.out.println(" * Required Passes: " + split[5] + " Element Tested: " + split[3] + " Risk Measure: " + split[2] + " Group: " + split[1]);
          System.out.println(" */");
          System.out.println("@Test");
          System.out.println("public void " + fullTestName + "() {");
          System.out.println("  List<FixedAmount> fixed = " + toCode(fixedIds));
          System.out.println("  List<NotionalFactor> factors = " + toCode(factorIds));
          System.out.println("  List<Notional> notional = " + toCode(notionalIds));
          System.out.println("  List<ProductMultiplier> multipliers = " + toCode(multiplierIds));
          System.out.println("  List<Sensitivity> sensitivities = " + toCode(sensitivityIds));
          System.out.println("  BigDecimal amount = Simm.calculateTotal(sensitivities, multipliers, factors, notional, fixed, FxRate.USD, HoldingPeriod." + holdingPeriod + ");");
          System.out.println("  AssertUtils.assertEquals(" + tenDayHoldingPeriod + ",\"" + fullTestName + "\"," + //
              GeneratorUtils.quoteIfNeeded(split[1]) + "," + GeneratorUtils.quoteIfNeeded(split[2]) + "," + GeneratorUtils.quoteIfNeeded(split[3]) + "," + GeneratorUtils.quoteIfNeeded(split[4]) + "," + GeneratorUtils.quoteIfNeeded(split[5]) + ","
              + GeneratorUtils.quoteIfNeeded(split[6]) + "," + GeneratorUtils.quoteIfNeeded(split[7]) + "," + GeneratorUtils.quoteIfNeeded(split[8]) + "," + GeneratorUtils.quoteIfNeeded(split[9]) + "," + GeneratorUtils.quoteIfNeeded(split[10]) + ","
              + GeneratorUtils.quoteIfNeeded(split[11]) + ", new BigDecimal(" + GeneratorUtils.printNumber(split[12]) + "), amount);");
          System.out.println("}");
          System.out.println();
        }
      }
    }
  }

  @Test
  public void printUnitTestsForSimmOptionalTenDayTest() throws IOException {
    printOptionalTests(TESTS_10D, HOLDING_PERIOD_TEN_DAY);
  }

  @Test
  public void printUnitTestsForSimmOptionalOneDayTest() throws IOException {
    printOptionalTests(TESTS_1D, HOLDING_PERIOD_ONE_DAY);
  }

  private void printOptionalTests(String tests10d, String holdingPeriod) throws IOException {
    try (InputStream resourceAsStream = SimmDayGeneratorTest.class.getResourceAsStream(tests10d)) {
      List<String> testLines = IOUtils.readLines(resourceAsStream, Charset.defaultCharset());

      System.out.println();
      System.out.println();
      for (String testLine : testLines) {
        String[] split = testLine.split("\t");
        if (split.length > 0 && split[0].startsWith("J")) {

          String[] allIds = split[4].split(",");
          List<String> sensitivityIds = new ArrayList<>();

          for (String rawId : allIds) {
            String idToUse = rawId.replaceAll("\"", "").replaceAll("All ", "");
            sensitivityIds.add(idToUse);
          }

          String testNameSuffix = "Total".equals(split[6]) ? "" : split[6];
          String fullTestName = "test" + split[0] + testNameSuffix;
          boolean tenDayHoldingPeriod = HOLDING_PERIOD_TEN_DAY.equals(holdingPeriod) ? true : false;

          System.out.println("/**");
          System.out.println(" * Required Passes: " + split[5] + " Element Tested: " + split[3] + " Risk Measure: " + split[2] + " Group: " + split[1]);
          System.out.println(" */");
          System.out.println("@Test");
          System.out.println("public void " + fullTestName + "() {");
          System.out.println("  List<Crif> sensitivities = " + toCode(sensitivityIds));
          System.out.println("  SimmpleConfig config =");
          System.out.println("      SimmpleConfig.Builder().calculationCurrency(\"USD\").holdingPeriod(HoldingPeriod." + holdingPeriod
              + ").imRole(ImRole.SECURED).simmCalculationType(SimmCalculationType." + split[6].toUpperCase() + ").build();");
          System.out.println("  BigDecimal amount = Simmple.calculateWorstOf(sensitivities, config).getImTree().getMargin();");
          System.out.println("  AssertUtils.assertEquals(" + tenDayHoldingPeriod + ",\"" + fullTestName + "\"," + //
              GeneratorUtils.quoteIfNeeded(split[1]) + "," + GeneratorUtils.quoteIfNeeded(split[2]) + "," + GeneratorUtils.quoteIfNeeded(split[3]) + "," + GeneratorUtils.quoteIfNeeded(split[4]) + "," + GeneratorUtils.quoteIfNeeded(split[5]) + ","
              + GeneratorUtils.quoteIfNeeded(split[6]) + "," + GeneratorUtils.quoteIfNeeded(split[7]) + "," + GeneratorUtils.quoteIfNeeded(split[8]) + "," + GeneratorUtils.quoteIfNeeded(split[9]) + "," + GeneratorUtils.quoteIfNeeded(split[10]) + ","
              + GeneratorUtils.quoteIfNeeded(split[11]) + ", new BigDecimal(" + GeneratorUtils.printNumber(split[12]) + "), amount);");
          System.out.println("}");
        }
      }
    }
  }

  private static String toCode(List<String> ids) {
    if (ids.isEmpty()) {
      return "Collections.emptyList();";
    } else if (ids.contains("S_AN_FIXED")) {
      StringBuilder sb = new StringBuilder("new ArrayList<FixedAmount>();");
      sb.append(System.lineSeparator());
      for (String string : ids) {
        sb.append("  fixed.addAll(").append(string).append(");");
        sb.append(System.lineSeparator());
      }
      return sb.toString();
    } else if (ids.contains("S_AN_FACTORS")) {
      StringBuilder sb = new StringBuilder("new ArrayList<NotionalFactor>();");
      sb.append(System.lineSeparator());
      for (String string : ids) {
        sb.append("  factors.addAll(").append(string).append(");");
        sb.append(System.lineSeparator());
      }
      return sb.toString();
    } else if (ids.contains("S_AN")) {
      StringBuilder sb = new StringBuilder("new ArrayList<Notional>();");
      sb.append(System.lineSeparator());
      for (String string : ids) {
        sb.append("  notional.addAll(").append(string).append(");");
        sb.append(System.lineSeparator());
      }
      return sb.toString();
    } else if (ids.contains("S_MUL")) {
      StringBuilder sb = new StringBuilder("new ArrayList<ProductMultiplier>();");
      sb.append(System.lineSeparator());
      for (String string : ids) {
        sb.append("multipliers.addAll(").append(string).append(");");
        sb.append(System.lineSeparator());
      }
      return sb.toString();
    } else if (ids.contains("S_IR") || //
        ids.contains("S_FX") || //
        ids.contains("S_CRQ") || //
        ids.contains("S_CRNQ") || //
        ids.contains("S_EQ") || //
        ids.contains("S_CM") || //
        ids.contains("S_IRV") || //
        ids.contains("S_CRV") || //
        ids.contains("S_CNV") || //
        ids.contains("S_EQV") || //
        ids.contains("S_FXV") || //
        ids.contains("S_CMV")) {
      StringBuilder sb = new StringBuilder("new ArrayList<Sensitivity>();");
      sb.append(System.lineSeparator());
      for (String string : ids) {
        sb.append("  sensitivities.addAll(").append(string).append(");");
        sb.append(System.lineSeparator());
      }
      return sb.toString();
    } else {
      StringBuilder sb = new StringBuilder("Arrays.asList(");
      boolean first = true;
      for (String string : ids) {
        if (first) {
          first = false;
        } else {
          sb.append(",");
        }
        sb.append(string);
      }
      sb.append(");");
      return sb.toString();
    }
  }

}
