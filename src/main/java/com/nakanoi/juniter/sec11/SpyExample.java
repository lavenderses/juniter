package com.nakanoi.juniter.sec11;

import java.util.logging.Logger;

/** Spy for Logger class. */
public class SpyExample {
  Logger logger = Logger.getLogger(SpyExample.class.getName());

  public void doSomething() {
    logger.info("doSomething.");
  }
}
