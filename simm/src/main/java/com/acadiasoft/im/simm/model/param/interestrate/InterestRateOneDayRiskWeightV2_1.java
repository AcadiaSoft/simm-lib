package com.acadiasoft.im.simm.model.param.interestrate;

import com.acadiasoft.im.simm.model.imtree.identifiers.RiskClass;
import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmRiskWeight;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class InterestRateOneDayRiskWeightV2_1 implements SimmRiskWeight {

  private static final BigDecimal VEGA = new BigDecimal("0.04");
  private static final BigDecimal INFLATION = new BigDecimal("9.6");
  private static final BigDecimal XCCY = new BigDecimal("5.6");

  private static final Map<InterestRateCurrencyVolatility, Map<InterestRateTenor, BigDecimal>> WEIGHTS = new HashMap<>();
  private static final Map<InterestRateTenor, BigDecimal> HIGH = new HashMap<>();
  private static final Map<InterestRateTenor, BigDecimal> LOW = new HashMap<>();
  private static final Map<InterestRateTenor, BigDecimal> REGULAR = new HashMap<>();

  static {
    REGULAR.put(InterestRateTenor._2W, new BigDecimal("22"));
    REGULAR.put(InterestRateTenor._1M, new BigDecimal("16"));
    REGULAR.put(InterestRateTenor._3M, new BigDecimal("12"));
    REGULAR.put(InterestRateTenor._6M, new BigDecimal("12"));
    REGULAR.put(InterestRateTenor._1YR, new BigDecimal("13"));
    REGULAR.put(InterestRateTenor._2YR, new BigDecimal("15"));
    REGULAR.put(InterestRateTenor._3YR, new BigDecimal("15"));
    REGULAR.put(InterestRateTenor._5YR, new BigDecimal("16"));
    REGULAR.put(InterestRateTenor._10YR, new BigDecimal("17"));
    REGULAR.put(InterestRateTenor._15YR, new BigDecimal("15"));
    REGULAR.put(InterestRateTenor._20YR, new BigDecimal("16"));
    REGULAR.put(InterestRateTenor._30YR, new BigDecimal("16"));
    WEIGHTS.put(InterestRateCurrencyVolatility.REGULAR, REGULAR);

    LOW.put(InterestRateTenor._2W, new BigDecimal("12"));
    LOW.put(InterestRateTenor._1M, new BigDecimal("3.5"));
    LOW.put(InterestRateTenor._3M, new BigDecimal("1.7"));
    LOW.put(InterestRateTenor._6M, new BigDecimal("1.7"));
    LOW.put(InterestRateTenor._1YR, new BigDecimal("3.2"));
    LOW.put(InterestRateTenor._2YR, new BigDecimal("4.4"));
    LOW.put(InterestRateTenor._3YR, new BigDecimal("5.2"));
    LOW.put(InterestRateTenor._5YR, new BigDecimal("6.9"));
    LOW.put(InterestRateTenor._10YR, new BigDecimal("7.3"));
    LOW.put(InterestRateTenor._15YR, new BigDecimal("7.3"));
    LOW.put(InterestRateTenor._20YR, new BigDecimal("8.1"));
    LOW.put(InterestRateTenor._30YR, new BigDecimal("8.6"));
    WEIGHTS.put(InterestRateCurrencyVolatility.LOW_VOLATILITY, LOW);

    HIGH.put(InterestRateTenor._2W, new BigDecimal("32"));
    HIGH.put(InterestRateTenor._1M, new BigDecimal("38"));
    HIGH.put(InterestRateTenor._3M, new BigDecimal("22"));
    HIGH.put(InterestRateTenor._6M, new BigDecimal("21"));
    HIGH.put(InterestRateTenor._1YR, new BigDecimal("22"));
    HIGH.put(InterestRateTenor._2YR, new BigDecimal("23"));
    HIGH.put(InterestRateTenor._3YR, new BigDecimal("26"));
    HIGH.put(InterestRateTenor._5YR, new BigDecimal("27"));
    HIGH.put(InterestRateTenor._10YR, new BigDecimal("31"));
    HIGH.put(InterestRateTenor._15YR, new BigDecimal("27"));
    HIGH.put(InterestRateTenor._20YR, new BigDecimal("30"));
    HIGH.put(InterestRateTenor._30YR, new BigDecimal("32"));
    WEIGHTS.put(InterestRateCurrencyVolatility.HIGH_VOLATILITY, HIGH);
  }

  @Override
  public BigDecimal getDeltaRiskWeight(WeightingClass s) {
    if (StringUtils.equalsIgnoreCase(s.getRiskType(), RiskClass.RISK_TYPE_INFLATION)) {
      return INFLATION;
    } else if (s.getRiskType().equalsIgnoreCase(RiskClass.RISK_TYPE_XCCY_BASIS)) {
      return XCCY;
    } else {
      InterestRateCurrencyVolatility vol = InterestRateCurrencyVolatility.get(s.getQualifier());
      InterestRateTenor tenor = InterestRateTenor.getByTenor(s.getLabel1());
      return WEIGHTS.get(vol).get(tenor);
    }
  }

  @Override
  public BigDecimal getVegaRiskWeight(WeightingClass s) {
    return VEGA;
  }

}
