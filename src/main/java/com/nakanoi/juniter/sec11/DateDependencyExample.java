package com.nakanoi.juniter.sec11;

import java.util.Date;

/** Simple Date class. */
public class DateDependencyExample {
  Date date = new Date();
  DateFactory factory = new DateFactoryImplementation();

  /**
   * Return date.
   *
   * @param type Method's type to execute.
   */
  public void doSomething(MethodType type) {
    switch (type) {
      case METHOD:
        date = newDate();
        break;
      case OBJECT:
        date = factory.newDate();
        break;
      default:
        date = new Date();
        break;
    }
  }

  public Date newDate() {
    return new Date();
  }

  public String getDate() {
    return date.toString();
  }
}
