package com.nakanoi.juniter.sec19;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/** Simple consumption tax class. */
public class ConsumptionTax {
  private final double taxRate;

  public ConsumptionTax(double taxRate) {
    this.taxRate = taxRate + 1;
  }

  public int calculate(int yen) {
    BigDecimal value = new BigDecimal(yen * taxRate, new MathContext(0, RoundingMode.DOWN));
    return value.intValue();
  }
}
