package com.nakanoi.juniter.sec11;

import java.util.Date;

/** Simple Date class. */
public class DateDependencyExample {
  Date date = new Date();
  DateFactory factory = new DateFactoryImplementation();

  /**
   * Return date.
   *
   * @param type Method type to execute.
   */
  public void doSomething(MethodType type) {
    switch (type) {
      case METHOD -> date = newDate();
      case OBJECT -> date = factory.newDate();
      default -> date = new Date();
    }
  }

  public Date newDate() {
    return new Date();
  }
}
