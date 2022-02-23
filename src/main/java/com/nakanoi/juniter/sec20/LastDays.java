package com.nakanoi.juniter.sec20;

import java.util.Calendar;

/** Simple calculator. */
public class LastDays {
  private final Calendar calendar;

  public LastDays(Calendar calendar) {
    this.calendar = (Calendar) calendar.clone();
  }

  public int calculate() {
    return calendar.getActualMaximum(Calendar.DAY_OF_MONTH) - calendar.get(Calendar.DAY_OF_MONTH);
  }
}
