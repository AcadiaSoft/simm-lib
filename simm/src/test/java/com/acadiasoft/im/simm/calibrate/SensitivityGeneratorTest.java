package com.acadiasoft.im.simm.calibrate;

import com.acadiasoft.im.simm.calibrate.utils.GeneratorUtils;
import com.acadiasoft.im.simm.model.imtree.identifiers.ProductClass;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class SensitivityGeneratorTest {

  private static final String SENSITIVITY_INPUTS = "sensitivity-inputs.txt";

  @Test
  public void printSensitivitiesForSimmCrifMixin() throws IOException {
    try (InputStream resourceAsStream = SensitivityGeneratorTest.class.getResourceAsStream(SENSITIVITY_INPUTS)) {
      List<String> sensitivityLines = IOUtils.readLines(resourceAsStream, Charset.defaultCharset());
      for (String sensitivityLine : sensitivityLines) {
        String[] split = sensitivityLine.split("\t");
        if (split.length > 0) {
          try {
            if ("".equals(split[0]) && !"".equals(split[1])) {
              if ("Param_AddOnNotionalFactor".equals(split[3])) {
                System.out.println("NotionalFactor " + split[1] + " = NotionalFactor.of(\"" + split[4] + "\", \"" + GeneratorUtils.printNumber(split[8]) + "\");");
              } else if ("Notional".equals(split[3])) {
                System.out.println(
                    "Notional " + split[1] + " = Notional.of(\"" + split[4] + "\", " + GeneratorUtils.printNumber(split[8]) + ", FxRate." + split[9] + ", " + GeneratorUtils.printNumber(split[10]) + ");");
              } else if ("Param_AddOnFixedAmount".equals(split[3])) {
                System.out.println("FixedAmount " + split[1] + " = FixedAmount.of(" + GeneratorUtils.printNumber(split[8]) + ", FxRate." + split[9] + ", " + GeneratorUtils.printNumber(split[10]) + ");");
              } else if ("Param_ProductClassMultiplier".equals(split[3])) {
                System.out.println("ProductMultiplier " + split[1] + " = ProductMultiplier.of(\"" + split[4] + "\", \"" + GeneratorUtils.printNumber(split[8]) + "\");");
              }
            } else if (ProductClass.determineProductClass(split[0]) != null) {
              System.out.println("Sensitivity " + split[1] + " = new DefaultSensitivity(\"" + split[0] + "\", \"" + split[3] + "\", \"" + split[4] + "\", \"" + split[5] + "\", \""
                  + split[6] + "\", \"" + split[7] + "\", " + GeneratorUtils.printNumber(split[8]) + ", FxRate." + split[9] + ", " + GeneratorUtils.printNumber(split[10]) + ");");
            }
          } catch (IllegalStateException e) {
          }
        }
      }
    }
  }

  @Test
  public void printSensitivitiesForSimmOptionalCrifMixin() throws IOException {
    try (InputStream resourceAsStream = SensitivityGeneratorTest.class.getResourceAsStream(SENSITIVITY_INPUTS)) {
      List<String> sensitivityLines = IOUtils.readLines(resourceAsStream, Charset.defaultCharset());
      for (String sensitivityLine : sensitivityLines) {
        String[] split = sensitivityLine.split("\t");
        if (split.length > 0) {
          if (split[1].startsWith("JS_") || split[1].startsWith("SS_")) {
            System.out.println("Crif " + split[1] + " = new DefaultCrif(\"\", \"\", \"\", \"\", \"\", \"SIMM\", \"" + split[0] + "\", \"" + split[3] + "\", \"" + split[4]
                + "\", \"" + split[5] + "\", \"" + split[6] + "\", \"" + split[7] + "\", " + GeneratorUtils.quoteIfNeeded(GeneratorUtils.printNumber(split[8])) + ", "
                + (split[9].length() > 0 ? "FxRate." + split[9] : "\"\"") + ", " + GeneratorUtils.quoteIfNeeded(GeneratorUtils.printNumber(split[10])) + ", \"\", " + GeneratorUtils.quoteIfNeeded(split[2]) + ");");
          }
        }
      }
    }
  }
}
