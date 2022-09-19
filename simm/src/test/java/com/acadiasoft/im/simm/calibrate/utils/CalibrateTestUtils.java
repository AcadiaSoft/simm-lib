package com.acadiasoft.im.simm.calibrate.utils;

import static com.acadiasoft.im.simm.model.param.fx.FXCurrencyVolatility.HIGH_VOLATILITY;
import static com.acadiasoft.im.simm.model.param.fx.FXCurrencyVolatility.REGULAR_VOLATILITY;
import static com.acadiasoft.im.simm.model.param.interestrate.InterestRateTenor.getByTenor;

import com.acadiasoft.im.simm.model.imtree.identifiers.BucketType;
import com.acadiasoft.im.simm.model.param.SimmHvr;
import com.acadiasoft.im.simm.model.param.fx.FXConcentrationRisk;
import com.acadiasoft.im.simm.model.param.fx.FXCurrencyVolatility;
import com.acadiasoft.im.simm.model.param.interestrate.InterestRateConcentrationRisk;
import com.acadiasoft.im.simm.model.param.interestrate.InterestRateTenor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalibrateTestUtils {

  private static final String HIGH = "HIGH";
  private static final String REGULAR = "REGULAR";
  private static final String LOW = "LOW";
  
  private static final String CALIB_IR_CORR_OUTER = "Calib_IR_CorrOuter";
  private static final String CALIB_X_CCY_BASIS_CORR = "Calib_XCcyBasis_Corr";
  private static final String CALIB_INFLATION_CORR = "Calib_Inflation_Corr";
  private static final String CALIB_IR_SUB_CURVE_CORR = "Calib_IRSubCurve_Corr";
  private static final String CALIB_IR_CURVE_CORR = "Calib_IRCurve_Corr";
  private static final String CALIB_IR_VOL_HVR = "Calib_IRVol_HVR";
  private static final String CALIB_IR_VOL_WEIGHT = "Calib_IRVol_Weight";
  private static final String CALIB_X_CCY_BASIS_WEIGHT = "Calib_XCcyBasis_Weight";
  private static final String CALIB_INFLATION_WEIGHT = "Calib_Inflation_Weight";
  private static final String CALIB_IR_CURVE_WEIGHT = "Calib_IRCurve_Weight";

  public static void handleInterestRateRiskWeight(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    String interestRateTenor = null;
    switch (split[1]) {
    case "1":
      interestRateTenor = REGULAR;
      break;
    case "2":
      interestRateTenor = LOW;
      break;
    case "3":
      interestRateTenor = HIGH;
      break;
    }
    MapUtils.safeAdd(linesToPrint, clazz.getName(), interestRateTenor + ".put(InterestRateTenor._" + split[2] + ", new BigDecimal(\"" + split[4] + "\"));");
  }

  public static void handleVolWeight(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "private static final BigDecimal VEGA = new BigDecimal(\"" + split[4] + "\");");
  }

  public static void handleInterestRateVolHVR(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz, boolean d1) {
    if (d1) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "BigDecimal IR_HVR_ONE_DAY = new BigDecimal(\"" + split[4] + "\");");
    } else {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "BigDecimal IR_HVR = new BigDecimal(\"" + split[4] + "\");");
    }
  }

  public static void handleInterestRateCorrelations(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ((InterestRateTenor._2W.equals(getByTenor(split[2])) && //
        InterestRateTenor._1M.equals(getByTenor(split[3]))) || //
        InterestRateTenor._2W.equals(getByTenor(split[3]))) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "{ // tenor " + split[2]);
    }

    int index1 = InterestRateTenor.indexOf(split[2]);
    int index2 = InterestRateTenor.indexOf(split[3]);
    if (index1 + 1 == index2) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"1\"), // tenor " + split[2]);
    }

    MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"" + split[4] + "\"), // tenor " + split[3]);

    if (InterestRateTenor._30Y.equals(getByTenor(split[2])) && index1 - 1 == index2) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"1\"), // tenor " + split[2]);
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "}");
    } else if (InterestRateTenor._30Y.equals(getByTenor(split[3]))) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "},");
    }
  }

  public static void handleInterestRateCalibrations(Map<String, List<String>> linesToPrint, String[] split, Class<?> riskWeightClass, Class<?> correlationClass, boolean d1) {
    String string = split[0];
    if (CALIB_IR_CURVE_WEIGHT.equals(string)) {
      handleInterestRateRiskWeight(linesToPrint, split, riskWeightClass);
    } else if (CALIB_INFLATION_WEIGHT.equals(string)) {
      MapUtils.safeAdd(linesToPrint, riskWeightClass.getName(), "private static final BigDecimal INFLATION = new BigDecimal(\"" + split[4] + "\");");
    } else if (CALIB_X_CCY_BASIS_WEIGHT.equals(string)) {
      MapUtils.safeAdd(linesToPrint, riskWeightClass.getName(), "private static final BigDecimal XCCY = new BigDecimal(\"" + split[4] + "\");");
    } else if (CALIB_IR_VOL_WEIGHT.equals(string)) {
      handleVolWeight(linesToPrint, split, riskWeightClass);
    } else if (CALIB_IR_VOL_HVR.equals(string)) {
      handleInterestRateVolHVR(linesToPrint, split, SimmHvr.class, d1);
    } else if (CALIB_IR_CURVE_CORR.equals(string)) {
      handleInterestRateCorrelations(linesToPrint, split, correlationClass);
    } else if (CALIB_IR_SUB_CURVE_CORR.equals(string)) {
      MapUtils.safeAdd(linesToPrint, correlationClass.getName(), " public static final BigDecimal SUB_CURVE_SAME_CCY = new BigDecimal(\"" + split[4] + "\");");
    } else if (CALIB_INFLATION_CORR.equals(string)) {
      MapUtils.safeAdd(linesToPrint, correlationClass.getName(), " public static final BigDecimal INFLATION = new BigDecimal(\"" + split[4] + "\");");
    } else if (CALIB_X_CCY_BASIS_CORR.equals(string)) {
      MapUtils.safeAdd(linesToPrint, correlationClass.getName(), " public static final BigDecimal XCCY = new BigDecimal(\"" + split[4] + "\");");
    } else if (CALIB_IR_CORR_OUTER.equals(string)) {
      MapUtils.safeAdd(linesToPrint, correlationClass.getName(), " public static final BigDecimal AGGREGATE_DIFF_CURRENCIES = new BigDecimal(\"" + split[4] + "\");");
    }
  }

  public static void handleCreditQualifyingCalibrations(Map<String, List<String>> linesToPrint, String[] split, Class<?> riskWeightClass, Class<?> correlationClass,
      Class<?> baseCorrClass) {
    String string = split[0];
    if ("Calib_CreditQ_Weight".equals(string)) {
      handleCreditQualifyingRiskWeight(linesToPrint, split, riskWeightClass);
    } else if ("Calib_CreditVol_Weight".equals(string)) {
      handleVolWeight(linesToPrint, split, riskWeightClass);
    } else if ("Calib_BaseCorr_Weight".equals(string)) {
      MapUtils.safeAdd(linesToPrint, baseCorrClass.getName(), "return new BigDecimal(\"" + split[4] + "\");");
    } else if ("Calib_CreditQ_Corr".equals(string)) {
      handleCreditCorrelationConstants(linesToPrint, split, correlationClass);
    } else if ("Calib_BaseCorr_Corr".equals(string)) {
      MapUtils.safeAdd(linesToPrint, baseCorrClass.getName(), "return new BigDecimal(\"" + split[4] + "\");");
    } else if ("Calib_CreditQ_CorrOuter".equals(string)) {
      handleCreditQualifyingCorrelations(linesToPrint, split, correlationClass);
    }
  }

  private static void handleCreditQualifyingRiskWeight(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ("Residual".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "WEIGHTS.put(BucketType.CRQRESIDUAL, new BigDecimal(\"" + split[4] + "\"));");
    } else {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "WEIGHTS.put(BucketType.CRQ" + split[1] + ", new BigDecimal(\"" + split[4] + "\"));");
    }
  }

  private static void handleCreditCorrelationConstants(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ("Residual".equals(split[2])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "public static final BigDecimal RESIDUAL = new BigDecimal(\"" + split[4] + "\");");
    } else if ("Same".equals(split[3])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "public static final BigDecimal AGGREGATE_SAME = new BigDecimal(\"" + split[4] + "\");");
    } else if ("Different".equals(split[3])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "public static final BigDecimal AGGREGATE_DIFF = new BigDecimal(\"" + split[4] + "\");");
    }
  }

  public static void handleCreditQualifyingCorrelations(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ((BucketType.CRQ1.getBucketString().equals(split[2]) && //
        BucketType.CRQ2.getBucketString().equals(split[3])) || //
        BucketType.CRQ1.getBucketString().equals(split[3])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "{ // " + split[2]);
    }

    int index1 = Integer.valueOf(split[2]);
    int index2 = Integer.valueOf(split[3]);
    if (index1 + 1 == index2) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "null, // " + split[2]);
    }

    MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"" + split[4] + "\"), // " + split[3]);

    if (BucketType.CRQ12.getBucketString().equals(split[2]) && //
        BucketType.CRQ11.getBucketString().equals(split[3])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "null, // " + split[2]);
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "}");
    } else if (BucketType.CRQ12.getBucketString().equals(split[3])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "},");
    }
  }

  public static void handleCreditNonQualifyingCalibrations(Map<String, List<String>> linesToPrint, String[] split, Class<?> riskWeightClass, Class<?> correlationClass) {
    String string = split[0];
    if ("Calib_CreditNonQ_Weight".equals(string)) {
      handleCreditNonQualifyingRiskWeight(linesToPrint, split, riskWeightClass);
    } else if ("Calib_CreditVolNonQ_Weight".equals(string)) {
      handleVolWeight(linesToPrint, split, riskWeightClass);
    } else if ("Calib_CreditNonQ_Corr".equals(string)) {
      handleCreditCorrelationConstants(linesToPrint, split, correlationClass);
    } else if ("Calib_CreditNonQ_CorrOuter".equals(string)) {
      MapUtils.safeAdd(linesToPrint, correlationClass.getName(), "public static final BigDecimal NON_RESIDUAL_TO_NON_RESIDUAL =  new BigDecimal(\"" + split[4] + "\");");
    }
  }

  private static void handleCreditNonQualifyingRiskWeight(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ("Residual".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "WEIGHTS.put(BucketType.CRNQRESIDUAL, new BigDecimal(\"" + split[4] + "\"));");
    } else {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "WEIGHTS.put(BucketType.CRNQ" + split[1] + ", new BigDecimal(\"" + split[4] + "\"));");
    }
  }

  public static void handleEquityCalibrations(Map<String, List<String>> linesToPrint, String[] split, Class<?> riskWeightClass, Class<?> correlationClass, boolean d1) {
    String string = split[0];
    if ("Calib_Equity_Weight".equals(string)) {
      handleEquityRiskWeight(linesToPrint, split, riskWeightClass);
    } else if ("Calib_EquityVol_HVR".equals(string)) {
      handleEquityVolHVR(linesToPrint, split, SimmHvr.class, d1);
    } else if ("Calib_EquityVol_Weight".equals(string)) {
      handleEquityVegaWeightConstants(linesToPrint, split, riskWeightClass);
    } else if ("Calib_Equity_Corr".equals(string)) {
      handleEquityCorrelations(linesToPrint, split, correlationClass);
    } else if ("Calib_Equity_CorrOuter".equals(string)) {
      handleEquityOuterCorrelations(linesToPrint, split, correlationClass);
    }
  }

  private static void handleEquityOuterCorrelations(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if (BucketType.EQ1.getBucketString().equals(split[2]) && //
        BucketType.EQ2.getBucketString().equals(split[3])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "  private static final BigDecimal[][] CORRELATIONS = {");
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "{ // " + split[2]);
    } else if (BucketType.EQ1.getBucketString().equals(split[3])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "{ // " + split[2]);
    }

    int index1 = Integer.valueOf(split[2]);
    int index2 = Integer.valueOf(split[3]);
    if (index1 + 1 == index2) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "null, // " + split[2]);
    }

    MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"" + split[4] + "\"), // " + split[3]);

    if (BucketType.EQ12.getBucketString().equals(split[2]) && //
        BucketType.EQ11.getBucketString().equals(split[3])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "null, // " + split[2]);
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "} } ;");
    } else if (BucketType.EQ12.getBucketString().equals(split[3])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "},");
    }
  }

  private static void handleEquityCorrelations(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ("Residual".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "public static final BigDecimal RESIDUAL = new BigDecimal(\"" + split[4] + "\");");
    } else {
      if (BucketType.EQ1.getBucketString().equals(split[1])) {
        MapUtils.safeAdd(linesToPrint, clazz.getName(), "private static final BigDecimal[] INTRA_BUCKET = {");
      }
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"" + split[4] + "\"), // " + split[1]);
      if (BucketType.EQ12.getBucketString().equals(split[1])) {
        MapUtils.safeAdd(linesToPrint, clazz.getName(), "};");
      }
    }
  }

  private static void handleEquityVegaWeightConstants(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ("Residual".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "VEGA_WEIGHTS.put(BucketType.EQRESIDUAL, new BigDecimal(\"" + split[4] + "\"));");
    } else {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "VEGA_WEIGHTS.put(BucketType.EQ" + split[1] + ", new BigDecimal(\"" + split[4] + "\"));");
    }
  }

  private static void handleEquityRiskWeight(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ("Residual".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "WEIGHTS.put(BucketType.EQRESIDUAL, new BigDecimal(\"" + split[4] + "\"));");
    } else {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "WEIGHTS.put(BucketType.EQ" + split[1] + ", new BigDecimal(\"" + split[4] + "\"));");
    }
  }

  public static void handleEquityVolHVR(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz, boolean d1) {
    if (d1) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "BigDecimal EQ_HVR_ONE_DAY = new BigDecimal(\"" + split[4] + "\");");
    } else {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "BigDecimal EQ_HVR = new BigDecimal(\"" + split[4] + "\");");
    }
  }

  public static void handleCommodityCalibrations(Map<String, List<String>> linesToPrint, String[] split, Class<?> riskWeightClass, Class<?> correlationClass, boolean d1) {
    String string = split[0];
    if ("Calib_Commodity_Weight".equals(string)) {
      MapUtils.safeAdd(linesToPrint, riskWeightClass.getName(), "WEIGHTS.put(BucketType.CM" + split[1] + ", new BigDecimal(\"" + split[4] + "\"));");
    } else if ("Calib_CommodityVol_HVR".equals(string)) {
      handleCommodityVolHVR(linesToPrint, split, SimmHvr.class, d1);
    } else if ("Calib_CommodityVol_Weight".equals(string)) {
      MapUtils.safeAdd(linesToPrint, riskWeightClass.getName(), "private static final BigDecimal VEGA = new BigDecimal(\"" + split[4] + "\");");
    } else if ("Calib_Commodity_Corr".equals(string)) {
      handleCommodityCorrelations(linesToPrint, split, correlationClass);
    } else if ("Calib_Commodity_CorrOuter".equals(string)) {
      handleCommodityOuterCorrelations(linesToPrint, split, correlationClass);
    }
  }

  public static void handleCommodityVolHVR(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz, boolean d1) {
    if (d1) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "BigDecimal CM_HVR_ONE_DAY = new BigDecimal(\"" + split[4] + "\");");
    } else {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "BigDecimal CM_HVR = new BigDecimal(\"" + split[4] + "\");");
    }
  }

  private static void handleCommodityCorrelations(Map<String, List<String>> linesToPrint, String[] split, Class<?> correlationClass) {
    if (BucketType.CM1.getBucketString().equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, correlationClass.getName(), "private static final BigDecimal[] INTRA_BUCKET = {");
    }
    MapUtils.safeAdd(linesToPrint, correlationClass.getName(), "new BigDecimal(\"" + split[4] + "\"), // " + split[1]);
    if (BucketType.CM17.getBucketString().equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, correlationClass.getName(), "};");
    }
  }

  private static void handleCommodityOuterCorrelations(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if (BucketType.CM1.getBucketString().equals(split[2]) && //
        BucketType.CM2.getBucketString().equals(split[3])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "  private static final BigDecimal[][] CORRELATIONS = {");
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "{ // " + split[2]);
    } else if (BucketType.CM1.getBucketString().equals(split[3])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "{ // " + split[2]);
    }

    int index1 = Integer.valueOf(split[2]);
    int index2 = Integer.valueOf(split[3]);
    if (index1 + 1 == index2) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "null, // " + split[2]);
    }

    MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"" + split[4] + "\"), // " + split[3]);

    if (BucketType.CM17.getBucketString().equals(split[2]) && //
        BucketType.CM16.getBucketString().equals(split[3])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "null, // " + split[2]);
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "} } ;");
    } else if (BucketType.CM17.getBucketString().equals(split[3])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "},");
    }
  }

  public static void handleFXCalibrations(Map<String, List<String>> linesToPrint, String[] split, Map<String, Map<String, Map<String, String>>> fxCorrelations,
      Class<?> riskWeightClass, Class<?> correlationClass, boolean d1) {
    String string = split[0];
    if ("Calib_FX_Weight".equals(string)) {
      handleFXRiskWeight(linesToPrint, split, riskWeightClass);
    } else if ("Calib_FXVol_HVR".equals(string)) {
      handleFXVolHVR(linesToPrint, split, SimmHvr.class, d1);
    } else if ("Calib_FXVol_Weight".equals(string)) {
      MapUtils.safeAdd(linesToPrint, riskWeightClass.getName(), "private static final BigDecimal VEGA = new BigDecimal(\"" + split[4] + "\");");
    } else if ("Calib_FX_Corr".equals(string)) {
      handleFXCorrelations(fxCorrelations, split);
    } else if ("Calib_FXVol_Corr".equals(string)) {
      MapUtils.safeAdd(linesToPrint, correlationClass.getName(), "public static final BigDecimal CORRELATION = new BigDecimal(\"" + split[4] + "\");");
    }
  }

  public static void handleFXRiskWeight(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    String fxVolatility1 = getFxVolatility(split[2]);
    String fxVolatility2 = getFxVolatility(split[3]);
    MapUtils.safeAdd(linesToPrint, clazz.getName(), fxVolatility1 + ".put(" + fxVolatility2 + "_VOLATILITY" + "," + "new BigDecimal(\"" + split[4] + "\"));");
  }

  public static void handleFXVolHVR(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz, boolean d1) {
    if (d1) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "BigDecimal FX_HVR_ONE_DAY = new BigDecimal(\"" + split[4] + "\");");
    } else {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "BigDecimal FX_HVR = new BigDecimal(\"" + split[4] + "\");");
    }
  }

  private static void handleFXCorrelations(Map<String, Map<String, Map<String, String>>> fxCorrelations, String[] split) {
    fxCorrelations.putIfAbsent(split[1], new HashMap<>());
    fxCorrelations.get(split[1]).putIfAbsent(split[2], new HashMap<>());
    fxCorrelations.get(split[1]).get(split[2]).put(split[3], split[4]);
  }

  private static String getFxVolatility(String string) {
    if (HIGH_VOLATILITY.getVolatilityType().equals(string)) {
      return HIGH;
    } else {
      return REGULAR;
    }
  }

  public static void handlePostFxCorrelations(Map<String, List<String>> linesToPrint, Map<String, Map<String, Map<String, String>>> fxCorrelations, Class<?> clazz) {
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "private static final BigDecimal[][] HIGH_CALC_CURRENCY_CORRELATIONS = {");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "{ // High");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"" + getValue(fxCorrelations, HIGH_VOLATILITY, HIGH_VOLATILITY, HIGH_VOLATILITY) + "\"), // High");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"" + getValue(fxCorrelations, HIGH_VOLATILITY, HIGH_VOLATILITY, REGULAR_VOLATILITY) + "\"), // Regular");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "},");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "{ // Regular");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"" + getValue(fxCorrelations, HIGH_VOLATILITY, REGULAR_VOLATILITY, HIGH_VOLATILITY) + "\"), // High");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"" + getValue(fxCorrelations, HIGH_VOLATILITY, REGULAR_VOLATILITY, REGULAR_VOLATILITY) + "\"), // Regular");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "} };");

    MapUtils.safeAdd(linesToPrint, clazz.getName(), "private static final BigDecimal[][] REGULAR_CALC_CURRENCY_CORRELATIONS = {");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "{ // High");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"" + getValue(fxCorrelations, REGULAR_VOLATILITY, HIGH_VOLATILITY, HIGH_VOLATILITY) + "\"), // High");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"" + getValue(fxCorrelations, REGULAR_VOLATILITY, HIGH_VOLATILITY, REGULAR_VOLATILITY) + "\"), // Regular");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "},");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "{ // Regular");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"" + getValue(fxCorrelations, REGULAR_VOLATILITY, REGULAR_VOLATILITY, HIGH_VOLATILITY) + "\"), // High");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "new BigDecimal(\"" + getValue(fxCorrelations, REGULAR_VOLATILITY, REGULAR_VOLATILITY, REGULAR_VOLATILITY) + "\"), // Regular");
    MapUtils.safeAdd(linesToPrint, clazz.getName(), "} };");

  }

  private static String getValue(Map<String, Map<String, Map<String, String>>> fxCorrelations, FXCurrencyVolatility vol1, FXCurrencyVolatility vol2, FXCurrencyVolatility vol3) {
    return fxCorrelations.get(vol1.getVolatilityType()).get(vol2.getVolatilityType()).get(vol3.getVolatilityType());
  }

  public static void handleRiskClassCalibrations(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ("Calib_RiskClass_Corr".equals(split[0])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(),
          getRiskClassCorrelationPrefix(split[2]) + ".put(RiskClass." + getRiskClassCorrelationConstant(split[3]) + ", new BigDecimal(\"" + split[4] + "\"));");
    }
  }

  private static String getRiskClassCorrelationPrefix(String s) {
    switch (s) {
    case "Equity":
      return "EQ";
    case "CreditQ":
      return "CQ";
    case "CreditNonQ":
      return "CN";
    case "Commodity":
      return "CM";
    default:
      return s;
    }
  }

  private static String getRiskClassCorrelationConstant(String s) {
    switch (s) {
    case "IR":
      return "INTEREST_RATE";
    case "CreditQ":
      return "CREDIT_QUALIFYING";
    case "CreditNonQ":
      return "CREDIT_NON_QUALIFYING";
    default:
      return s.toUpperCase();
    }
  }

  public static void handleInterestRateCurrencyCalibrations(Map<String, List<String>> currencyList, String[] split) {
    if ("Info_IRCurve_CurrencyList".equals(split[0])) {
      switch (split[1]) {
      case "1":
        MapUtils.safeAdd(currencyList, "REGULAR", split[4]);
        break;
      case "2":
        MapUtils.safeAdd(currencyList, "LOW_VOLATILITY", split[4]);
        break;
      case "3":
        MapUtils.safeAdd(currencyList, "HIGH_VOLATILITY", split[4]);
        break;
      }
    }
  }

  public static void postCurrencyCalibrations(Map<String, List<String>> linesToPrint, Map<String, List<String>> currencyMap, Class<?> clazz) {

    boolean fxCurrVol = FXCurrencyVolatility.class.equals(clazz);
    boolean irConcRisk = InterestRateConcentrationRisk.class.equals(clazz);
    boolean fxConcRisk = FXConcentrationRisk.class.equals(clazz);

    int i = 1;
    List<String> keySet = new ArrayList<>(currencyMap.keySet());

    if (fxCurrVol) {
      Collections.reverse(keySet);
    }

    for (String vol : keySet) {
      StringBuilder sb = new StringBuilder();
      for (String ccy : currencyMap.get(vol)) {
        if (!sb.toString().isEmpty()) {
          sb.append(",");
        }
        if ("Other".equals(ccy)) {
          sb.append("null");
        } else {
          sb.append('"').append(ccy).append('"');
        }
      }
      String value = null;
      if (sb.toString().equals("null")) {
        value = sb.toString();
      } else {
        value = "Arrays.asList(" + sb.toString() + ")";
      }

      String indexToUse = fxCurrVol ? "\"" + i + '"' : Integer.toString(i);

      String prefix = irConcRisk || fxConcRisk ? "private static final List<String> " : "";
      String mid = irConcRisk || fxConcRisk ? " = " : "(" + indexToUse + ", ";
      String suffix = irConcRisk || fxConcRisk ? ";" : "), //";

      MapUtils.safeAdd(linesToPrint, clazz.getName(), prefix + vol + mid + value + suffix);
      i++;
    }
  }

  public static void handleFxCurrencyCalibrations(Map<String, List<String>> currencyList, String[] split) {
    if ("Info_FX_CurrencyList".equals(split[0])) {
      switch (split[1]) {
      case "1":
        MapUtils.safeAdd(currencyList, "HIGH_VOLATILITY", split[4]);
        break;
      case "2":
        MapUtils.safeAdd(currencyList, "REGULAR_VOLATILITY", split[4]);
        break;
      }
    }
  }

  public static void handleInterestRateConcentrationRiskCalibrations(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ("Calib_IRCurve_Conc".equals(split[0])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(),
          "DELTA_THRESHOLD.put(" + getInterestRateVolume(split[1]) + ", new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("Calib_IRVol_Conc".equals(split[0])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(),
          "VEGA_THRESHOLD.put(" + getInterestRateVolume(split[1]) + ", new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    }
  }

  private static String getInterestRateVolume(String string) {
    switch (string) {
    case "1":
      return "HIGH_VOL";
    case "2":
      return "REGULAR_VOL_WELL_TRADED";
    case "3":
      return "REGULAR_VOL_LESS_TRADED";
    case "4":
      return "LOW_VOL";
    }
    return "n/a";
  }

  public static void handleCreditConcentrationRiskCalibrations(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ("Calib_CreditQ_Conc".equals(split[0])) {
      if ("1".equals(split[1])) {
        MapUtils.safeAdd(linesToPrint, clazz.getName(), "DELTA_THRESHOLD.put(SOVEREIGN, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
      } else if ("2".equals(split[1])) {
        MapUtils.safeAdd(linesToPrint, clazz.getName(), "DELTA_THRESHOLD.put(CORPORATE, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
      } else if ("Residual".equals(split[1])) {
        MapUtils.safeAdd(linesToPrint, clazz.getName(), "DELTA_THRESHOLD.put(NOT_CLASSIFIED, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
      }
    } else if ("Calib_CreditVol_Conc".equals(split[0])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "@Override");
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "public BigDecimal getVegaThreshold(String bucket) {");
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "return new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM);");
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "}");
    }
  }

  public static void handleCreditNonConcentrationRiskCalibrations(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ("Calib_CreditNonQ_Conc".equals(split[0])) {
      if ("1".equals(split[1])) {
        MapUtils.safeAdd(linesToPrint, clazz.getName(), "DELTA_THRESHOLD.put(IG, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
      } else if ("2".equals(split[1])) {
        MapUtils.safeAdd(linesToPrint, clazz.getName(), "DELTA_THRESHOLD.put(HY, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
      } else if ("Residual".equals(split[1])) {
        MapUtils.safeAdd(linesToPrint, clazz.getName(), "DELTA_THRESHOLD.put(NOT_CLASSIFIED, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
      }
    } else if ("Calib_CreditVolNonQ_Conc".equals(split[0])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "@Override");
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "public BigDecimal getVegaThreshold(String bucket) {");
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "return new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM);");
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "}");
    }
  }

  public static void handleEquityConcentrationRiskCalibrations(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ("Calib_Equity_Conc".equals(split[0])) {
      equityConcRiskCalibrationImpl(linesToPrint, split, clazz, "DELTA_THRESHOLD");
    } else if ("Calib_EquityVol_Conc".equals(split[0])) {
      equityConcRiskCalibrationImpl(linesToPrint, split, clazz, "VEGA_THRESHOLD");
    }
  }

  private static void equityConcRiskCalibrationImpl(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz, String thresholdName) {
    if ("1".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(EMERGING_MARKETS_LARGE, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("5".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(DEVELOPED_MARKETS_LARGE, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("9".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(EMERGING_MARKETS_SMALL, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("10".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(DEVELOPED_MARKETS_SMALL, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("11".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(),
          thresholdName + ".put(INDEXES_FUNDS_ETF_VOLINDEXES, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("Residual".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(NOT_CLASSIFIED, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    }
  }

  public static void handleCommodityConcentrationRiskCalibrations(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ("Calib_Commodity_Conc".equals(split[0])) {
      commodityConcRiskCalibrationImpl(linesToPrint, split, clazz, "DELTA_THRESHOLD");
    } else if ("Calib_CommodityVol_Conc".equals(split[0])) {
      commodityConcRiskCalibrationImpl(linesToPrint, split, clazz, "VEGA_THRESHOLD");
    }
  }

  private static void commodityConcRiskCalibrationImpl(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz, String thresholdName) {
    if ("1".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(COAL, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("2".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(CRUDE_OIL, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("3".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(OIL_FRACTIONS, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("6".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(NATURAL_GAS, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("8".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(POWER, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("10".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(FREIGHT, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("11".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(BASE_METALS, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("12".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(PRECIOUS_METALS, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("13".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(AGRICULTURE, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("16".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(OTHER, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("17".equals(split[1])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), thresholdName + ".put(INDEXES, new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    }
  }

  public static void handleFXConcentrationRiskCalibrations(Map<String, List<String>> linesToPrint, String[] split, Class<?> clazz) {
    if ("Calib_FX_Conc".equals(split[0])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(), "DELTA_THRESHOLD.put(CATEGORY_" + split[1] + ", new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    } else if ("Calib_FXVol_Conc".equals(split[0])) {
      MapUtils.safeAdd(linesToPrint, clazz.getName(),
          "CAT_" + split[2] + ".put(CATEGORY_" + split[3] + ", new BigDecimal(\"" + split[4] + "\").multiply(ConcentrationRiskGroup.MM));");
    }
  }

  public static void handleInterestRateCurrencyConcentrationCalibrations(Map<String, List<String>> interestRateCurrencyConcentrationMap, String[] split) {
    if ("Info_IR_Conc_CurrencyList".equals(split[0])) {
      switch (split[1]) {
      case "1":
        MapUtils.safeAdd(interestRateCurrencyConcentrationMap, "HIGH_VOL", split[4]);
        break;
      case "2":
        MapUtils.safeAdd(interestRateCurrencyConcentrationMap, "REGULAR_VOL_WELL_TRADED", split[4]);
        break;
      case "3":
        MapUtils.safeAdd(interestRateCurrencyConcentrationMap, "REGULAR_VOL_LESS_TRADED", split[4]);
        break;
      case "4":
        MapUtils.safeAdd(interestRateCurrencyConcentrationMap, "LOW_VOL", split[4]);
        break;
      }
    }
  }

  public static void handleFXCurrencyConcentrationCalibrations(Map<String, List<String>> interestRateCurrencyConcentrationMap, String[] split) {
    if ("Info_FX_Conc_CurrencyList".equals(split[0])) {
      MapUtils.safeAdd(interestRateCurrencyConcentrationMap, "CATEGORY_" + split[1], split[4]);
    }
  }
}
