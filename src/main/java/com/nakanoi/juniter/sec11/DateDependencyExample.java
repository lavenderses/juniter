package com.nakanoi.juniter.sec11;

import java.util.Date;

/** Simple Date class. */
public class DateDependencyExample {
  Date date = new Date();
  DateFactory factory = new DateFactoryImplementation();

  public void doSomething(MethodType type) {
    switch (type) {
      case SIMPLE -> date = new Date();
      case METHOD -> date = newDate();
      case OBJECT -> date = factory.newDate();
    }
  }

  public Date newDate() {
    return new Date();
  }
}
