package com.acadiasoft.im.simm.calibrate;

import com.acadiasoft.im.simm.calibrate.utils.CalibrateTestUtils;
import com.acadiasoft.im.simm.model.param.cnq.CreditNonQualifyingConcentrationRisk;
import com.acadiasoft.im.simm.model.param.cnq.CreditNonQualifyingCorrelation1d;
import com.acadiasoft.im.simm.model.param.cnq.CreditNonQualifyingRiskWeight1d;
import com.acadiasoft.im.simm.model.param.commodity.CommodityConcentrationRisk;
import com.acadiasoft.im.simm.model.param.commodity.CommodityCorrelation1d;
import com.acadiasoft.im.simm.model.param.commodity.CommodityRiskWeight1d;
import com.acadiasoft.im.simm.model.param.cq.BaseCorrRisk1d;
import com.acadiasoft.im.simm.model.param.cq.CreditQualifyingConcentrationRisk;
import com.acadiasoft.im.simm.model.param.cq.CreditQualifyingCorrelation1d;
import com.acadiasoft.im.simm.model.param.cq.CreditQualifyingRiskWeight1d;
import com.acadiasoft.im.simm.model.param.equity.EquityConcentrationRisk;
import com.acadiasoft.im.simm.model.param.equity.EquityCorrelation1d;
import com.acadiasoft.im.simm.model.param.equity.EquityRiskWeight1d;
import com.acadiasoft.im.simm.model.param.fx.FXConcentrationRisk;
import com.acadiasoft.im.simm.model.param.fx.FXCorrelation1d;
import com.acadiasoft.im.simm.model.param.fx.FXCurrencyVolatility;
import com.acadiasoft.im.simm.model.param.fx.FXRiskWeight1d;
import com.acadiasoft.im.simm.model.param.interestrate.InterestRateConcentrationRisk;
import com.acadiasoft.im.simm.model.param.interestrate.InterestRateCorrelation1d;
import com.acadiasoft.im.simm.model.param.interestrate.InterestRateCurrencyVolatility;
import com.acadiasoft.im.simm.model.param.interestrate.InterestRateRiskWeight1d;
import com.acadiasoft.im.simm.model.param.risk.RiskClassCorrelation;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class CalibrateTest {

  private static final String CALIBRATE_1D_FILENAME = "calibration-1d-2.5.txt";
  private static final String CALIBRATE_10D_FILENAME = "calibration-10d-2.5.txt";
  private static final String TAB = "\t";

  @Test
  public void calibrate1d() throws IOException {
    try (InputStream resourceAsStream = CalibrateTest.class.getResourceAsStream(CALIBRATE_1D_FILENAME)) {
      List<String> calibrationLines = IOUtils.readLines(resourceAsStream, Charset.defaultCharset());

      Map<String, List<String>> linesToPrint = new LinkedHashMap<>();

      Map<String, Map<String, Map<String, String>>> fxCorrelations = new LinkedHashMap<>();
      Map<String, List<String>> interestRateCurrencyVolatilityMap = new LinkedHashMap<>();
      Map<String, List<String>> fxCurrencyVolatilityMap = new LinkedHashMap<>();

      for (String calibrationLine : calibrationLines) {
        String[] split = calibrationLine.split(TAB);
        CalibrateTestUtils.handleInterestRateCalibrations(linesToPrint, split, InterestRateRiskWeight1d.class, InterestRateCorrelation1d.class, true);
        CalibrateTestUtils.handleCreditQualifyingCalibrations(linesToPrint, split, CreditQualifyingRiskWeight1d.class, CreditQualifyingCorrelation1d.class, BaseCorrRisk1d.class);
        CalibrateTestUtils.handleCreditNonQualifyingCalibrations(linesToPrint, split, CreditNonQualifyingRiskWeight1d.class, CreditNonQualifyingCorrelation1d.class);
        CalibrateTestUtils.handleEquityCalibrations(linesToPrint, split, EquityRiskWeight1d.class, EquityCorrelation1d.class, true);
        CalibrateTestUtils.handleCommodityCalibrations(linesToPrint, split, CommodityRiskWeight1d.class, CommodityCorrelation1d.class, true);
        CalibrateTestUtils.handleFXCalibrations(linesToPrint, split, fxCorrelations, FXRiskWeight1d.class, FXCorrelation1d.class, true);
        CalibrateTestUtils.handleRiskClassCalibrations(linesToPrint, split, RiskClassCorrelation.class);
        CalibrateTestUtils.handleInterestRateCurrencyCalibrations(interestRateCurrencyVolatilityMap, split);
        CalibrateTestUtils.handleFxCurrencyCalibrations(fxCurrencyVolatilityMap, split);
      }

      CalibrateTestUtils.handlePostFxCorrelations(linesToPrint, fxCorrelations, FXCorrelation1d.class);
      CalibrateTestUtils.postCurrencyCalibrations(linesToPrint, interestRateCurrencyVolatilityMap, InterestRateCurrencyVolatility.class);
      CalibrateTestUtils.postCurrencyCalibrations(linesToPrint, fxCurrencyVolatilityMap, FXCurrencyVolatility.class);

      print(linesToPrint);
    }
  }

  @Test
  public void calibrate10d() throws IOException {
    try (InputStream resourceAsStream = CalibrateTest.class.getResourceAsStream(CALIBRATE_10D_FILENAME)) {
      List<String> calibrationLines = IOUtils.readLines(resourceAsStream, Charset.defaultCharset());

      Map<String, List<String>> linesToPrint = new LinkedHashMap<>();

      Map<String, Map<String, Map<String, String>>> fxCorrelations = new LinkedHashMap<>();
      Map<String, List<String>> interestRateCurrencyVolatilityMap = new LinkedHashMap<>();
      Map<String, List<String>> fxCurrencyVolatilityMap = new LinkedHashMap<>();
      Map<String, List<String>> interestRateCurrencyConcentrationMap = new LinkedHashMap<>();
      Map<String, List<String>> fxCurrencyConcentrationMap = new LinkedHashMap<>();

      for (String calibrationLine : calibrationLines) {
        String[] split = calibrationLine.split(TAB);
        CalibrateTestUtils.handleInterestRateCalibrations(linesToPrint, split, InterestRateRiskWeight1d.class, InterestRateCorrelation1d.class, true);
        CalibrateTestUtils.handleCreditQualifyingCalibrations(linesToPrint, split, CreditQualifyingRiskWeight1d.class, CreditQualifyingCorrelation1d.class, BaseCorrRisk1d.class);
        CalibrateTestUtils.handleCreditNonQualifyingCalibrations(linesToPrint, split, CreditNonQualifyingRiskWeight1d.class, CreditNonQualifyingCorrelation1d.class);
        CalibrateTestUtils.handleEquityCalibrations(linesToPrint, split, EquityRiskWeight1d.class, EquityCorrelation1d.class, true);
        CalibrateTestUtils.handleCommodityCalibrations(linesToPrint, split, CommodityRiskWeight1d.class, CommodityCorrelation1d.class, true);
        CalibrateTestUtils.handleFXCalibrations(linesToPrint, split, fxCorrelations, FXRiskWeight1d.class, FXCorrelation1d.class, true);
        CalibrateTestUtils.handleRiskClassCalibrations(linesToPrint, split, RiskClassCorrelation.class);
        CalibrateTestUtils.handleInterestRateCurrencyCalibrations(interestRateCurrencyVolatilityMap, split);
        CalibrateTestUtils.handleFxCurrencyCalibrations(fxCurrencyVolatilityMap, split);

        CalibrateTestUtils.handleInterestRateConcentrationRiskCalibrations(linesToPrint, split, InterestRateConcentrationRisk.class);
        CalibrateTestUtils.handleCreditConcentrationRiskCalibrations(linesToPrint, split, CreditQualifyingConcentrationRisk.class);
        CalibrateTestUtils.handleCreditNonConcentrationRiskCalibrations(linesToPrint, split, CreditNonQualifyingConcentrationRisk.class);
        CalibrateTestUtils.handleEquityConcentrationRiskCalibrations(linesToPrint, split, EquityConcentrationRisk.class);
        CalibrateTestUtils.handleCommodityConcentrationRiskCalibrations(linesToPrint, split, CommodityConcentrationRisk.class);
        CalibrateTestUtils.handleFXConcentrationRiskCalibrations(linesToPrint, split, FXConcentrationRisk.class);
        CalibrateTestUtils.handleInterestRateCurrencyConcentrationCalibrations(interestRateCurrencyConcentrationMap, split);
        CalibrateTestUtils.handleFXCurrencyConcentrationCalibrations(fxCurrencyConcentrationMap, split);
      }

      CalibrateTestUtils.handlePostFxCorrelations(linesToPrint, fxCorrelations, FXCorrelation1d.class);
      CalibrateTestUtils.postCurrencyCalibrations(linesToPrint, interestRateCurrencyVolatilityMap, InterestRateCurrencyVolatility.class);
      CalibrateTestUtils.postCurrencyCalibrations(linesToPrint, fxCurrencyVolatilityMap, FXCurrencyVolatility.class);
      CalibrateTestUtils.postCurrencyCalibrations(linesToPrint, interestRateCurrencyConcentrationMap, InterestRateConcentrationRisk.class);
      CalibrateTestUtils.postCurrencyCalibrations(linesToPrint, fxCurrencyConcentrationMap, FXConcentrationRisk.class);

      print(linesToPrint);
    }
  }

  private static void print(Map<String, List<String>> linesToPrint) {
    for (String key : linesToPrint.keySet()) {
      System.out.println();
      System.out.println("To be pasted into " + key + ":");
      System.out.println();
      for (String line : linesToPrint.get(key)) {
        System.out.println(line);
      }
    }
  }
}
