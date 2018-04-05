package com.acadiasoft.simm.engine.margin;

import com.acadiasoft.simm.model.object.imtree.ImTree;
import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import com.acadiasoft.simm.model.object.imtree.identifiers.ProductClass;
import com.acadiasoft.simm.model.param.SimmRiskClassCorrelation;
import com.acadiasoft.simm.model.object.Sensitivity;
import com.acadiasoft.simm.model.util.SensitivityUtils;
import com.acadiasoft.simm.model.util.BigDecimalUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductMargin implements ImTree {

  private static final String LEVEL = "3.Silo";
  private final ProductClass productClass;
  private final BigDecimal margin;
  private final List<RiskMargin> marginByRiskClass = new ArrayList<>();

  private ProductMargin(ProductClass productClass, BigDecimal margin, List<RiskMargin> marginByRiskClass) {
    this.productClass = productClass;
    this.margin = margin;
    this.marginByRiskClass.addAll(marginByRiskClass);
  }

  @Override
  public BigDecimal getMargin() {
    return margin;
  }

  @Override
  public MarginIdentifier getMarginIdentifier() {
    return productClass;
  }

  @Override
  public List<ImTree> getChildren() {
    List<ImTree> list = new ArrayList<>();
    list.addAll(marginByRiskClass);
    return list;
  }

  @Override
  public String getTreeLevel() {
    return LEVEL;
  }

  public static ProductMargin calculate(ProductClass product, List<Sensitivity> sensitivities) {
    List<RiskMargin> marginByRiskClass = SensitivityUtils.listByMargin(
        e -> RiskMargin.calculate(e.getKey(), e.getValue()),
        SensitivityUtils.mapByIdentifier(s -> s.getRiskIdentifier(), sensitivities)
    );
    BigDecimal sumSquared = BigDecimalUtils.sumSquared(marginByRiskClass, m -> m.getMargin());
    BigDecimal sumCorrelated = BigDecimalUtils.sumCorrelated(
        marginByRiskClass,
        (m) -> m.getMargin(),
        (r, s) -> SimmRiskClassCorrelation.get(r.getRiskClass(), s.getRiskClass()),
        (r, s) -> !r.getRiskClass().equals(s.getRiskClass())
    );
    BigDecimal sqrt = BigDecimalUtils.sqrt(sumSquared.add(sumCorrelated));
    return new ProductMargin(product, sqrt, marginByRiskClass);
  }

  public ProductClass getProductClass() {
    return productClass;
  }
}
