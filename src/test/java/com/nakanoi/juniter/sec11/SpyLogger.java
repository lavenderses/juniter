package com.nakanoi.juniter.sec11;

import java.util.logging.Logger;

/** Spy class for Logger. */
public class SpyLogger extends Logger {
  final Logger base;
  final StringBuffer log = new StringBuffer();

  protected SpyLogger(Logger base) {
    super(base.getName(), base.getResourceBundleName());
    this.base = base;
  }

  @Override
  public void info(String msg) {
    log.append(msg);
    base.info(msg);
  }
}
