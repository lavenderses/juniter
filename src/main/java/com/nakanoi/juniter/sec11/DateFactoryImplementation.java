package com.nakanoi.juniter.sec11;

import java.util.Date;

/** Factory creates date. */
public class DateFactoryImplementation implements DateFactory {
  @Override
  public Date newDate() {
    return new Date();
  }
}
