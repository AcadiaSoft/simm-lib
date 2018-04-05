package com.acadiasoft.simm.model.object;

import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import com.acadiasoft.simm.model.object.imtree.identifiers.RiskClass;
import com.acadiasoft.simm.model.param.SimmConcentrationThreshold;
import com.acadiasoft.simm.model.object.imtree.identifiers.SensitivityClass;
import com.acadiasoft.simm.model.util.BigDecimalUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConcentrationRiskGroup implements Serializable {

  public static final BigDecimal MM = new BigDecimal("1000000");

  private final MarginIdentifier riskClass;
  private final MarginIdentifier sensitivityClass;
  private final String identifier;
  private final BigDecimal concentrationRisk;

  private ConcentrationRiskGroup(MarginIdentifier riskClass, MarginIdentifier sensitivityClass, String identifier, BigDecimal concentrationRisk) {
    this.riskClass = riskClass;
    this.sensitivityClass = sensitivityClass;
    this.concentrationRisk = concentrationRisk.stripTrailingZeros();
    this.identifier = identifier;
  }

  public BigDecimal getConcentrationRisk() {
    return concentrationRisk;
  }

  public String getIdentifier() {
    return identifier;
  }

  public MarginIdentifier getRiskClass() {
    return riskClass;
  }

  public MarginIdentifier getSensitivityClass() {
    return sensitivityClass;
  }

  public static ConcentrationRiskGroup buildWithConcentrationOfOne(RiskClass riskClass, SensitivityClass sensitivityClass, String identifier) {
    return new ConcentrationRiskGroup(riskClass, sensitivityClass, identifier, BigDecimal.ONE);
  }

  /**
   *
   * @param concentrationGroup list of sensitivities all belonging to the same concentration class
   * @return concentration class of the input sensitivities
   */
  public static ConcentrationRiskGroup build(RiskClass riskClass, SensitivityClass sensitivityClass, String identifier, List<Sensitivity> concentrationGroup) {
    // we need to remove Xccy Basis sensitivities from this sum
    // base corr sensitivities need to be removed as well, but we filter those out of other sensitivites earlier on
    if (riskClass.equals(RiskClass.INTEREST_RATE)) {
      concentrationGroup = concentrationGroup.stream()
          .filter(s -> !StringUtils.equalsIgnoreCase(s.getRiskType(), RiskClass.RISK_TYPE_XCCY_BASIS))
          .collect(Collectors.toList());
    }

    BigDecimal absSum = BigDecimalUtils.sum(concentrationGroup, s -> s.getAmountUsd()).abs();
    BigDecimal threshold = SimmConcentrationThreshold.getThreshold(riskClass, sensitivityClass, identifier);
    BigDecimal concentration = BigDecimalUtils.divideWithPrecision(absSum, threshold);
    return new ConcentrationRiskGroup(riskClass, sensitivityClass, identifier, BigDecimal.ONE.max(BigDecimalUtils.sqrt(concentration)));
  }

  public static ConcentrationRiskGroup findConcentrationClass(String identifier, Map<String, ConcentrationRiskGroup> mapByIdentifier) {
    if (mapByIdentifier.containsKey(identifier)) {
      return mapByIdentifier.get(identifier);
    } else {
      throw new IllegalStateException("tried to get concentration risk class of a identifier not in the map: [" + identifier + "]!");
    }
  }

  public static BigDecimal correlateClasses(ConcentrationRiskGroup k, ConcentrationRiskGroup i) {
    BigDecimal crk = k.getConcentrationRisk();
    BigDecimal cri = i.getConcentrationRisk();
    return BigDecimalUtils.divideWithPrecision(crk.min(cri), crk.max(cri));
  }

}
