package com.acadiasoft.im.schedule.engine.margin;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.base.margin.GroupMargin;
import com.acadiasoft.im.schedule.config.ScheduleConfig;
import com.acadiasoft.im.schedule.models.*;
import com.acadiasoft.im.schedule.models.imtree.identifiers.ScheduleTradeClass;
import com.acadiasoft.im.schedule.models.parameters.ScheduleParameters;
import com.acadiasoft.im.schedule.models.utils.ScheduleCalculationUtils;
import com.acadiasoft.im.schedule.models.utils.ScheduleRiskType;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleTradeMargin extends GroupMargin {

  private static final String LEVEL = "4.NettedTrades";
  private final ScheduleNotional nettedNotional;
  private final SchedulePv nettedPv;

  private ScheduleTradeMargin(ScheduleTradeClass weightingClass, BigDecimal notional, BigDecimal pv) {
    super(LEVEL, weightingClass, ScheduleCalculationUtils.calculateMargin(notional, pv), Collections.emptyList());
    ScheduleIdentifier notionalIdentifier = new DefaultScheduleIdentifier(weightingClass, ScheduleRiskType.SCHEDULE_NOTIONAL);
    this.nettedNotional = ScheduleSensitivity.of(notionalIdentifier, notional);
    ScheduleIdentifier pvIdentifier = new DefaultScheduleIdentifier(weightingClass, ScheduleRiskType.SCHEDULE_PV);
    this.nettedPv = ScheduleSensitivity.of(pvIdentifier, pv);
  }

  public static ScheduleTradeMargin calculate(ScheduleTradeClass id, List<ScheduleSensitivity> sensitivities, ScheduleConfig config) {
    // calculate the netted amount for the present values for this trade
    List<ScheduleSensitivity> pvs = sensitivities.stream()
      .filter(SchedulePv::isSchedulePv)
      .collect(Collectors.toList());
    BigDecimal nettedPvAmount = pvs.stream()
      .map(sensitivity -> sensitivity.getPresentValueInUsd(config.fxRate()))
      .reduce(BigDecimal.ZERO, BigDecimal::add);

    // calculate the netted amount for the notional of this trade
    List<ScheduleSensitivity> notionals = sensitivities.stream()
      .filter(ScheduleNotional::isScheduleNotional)
      .collect(Collectors.toList());
    BigDecimal nettedNotionalAmount = getNotionalAmount(id, notionals, pvs, config.fxRate());

    // get the weight for this particular trade
    BigDecimal scheduleWeight = ScheduleParameters.get(id.getScheduleProductClass(), id.getValuationDate(), id.getEndDate());
    return new ScheduleTradeMargin(id, scheduleWeight.multiply(nettedNotionalAmount), nettedPvAmount);
  }

  private static final String NO_NOTIONAL_FOR_TRADE = "There are no notional sensitivities for trade: [%s]"
    + " and the 'tradeNotional' field is not filled in for any PVs";

  private static BigDecimal getNotionalAmount(ScheduleTradeClass id, List<ScheduleSensitivity> notionals,
                                              List<ScheduleSensitivity> pvs, FxRate fx) {
    // if notional sensitivities were not provided we need to check the present values for the trade notional being set
    if (notionals.isEmpty()) {
      ScheduleSensitivity sensitivity = pvs.stream()
        .filter(ScheduleSensitivity::tradeNotionalIsSet)
        .findAny()
        .orElseThrow(() -> new IllegalStateException(String.format(NO_NOTIONAL_FOR_TRADE, id.getTradeId())));
      return sensitivity.getTradeNotionalInUsd(fx);
    } else {
      return notionals.stream()
        .map(sensitivity -> sensitivity.getNotionalInUsd(fx))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
  }

  public ScheduleNotional getNettedNotional() {
    return nettedNotional;
  }

  public SchedulePv getNettedPv() {
    return nettedPv;
  }
}
