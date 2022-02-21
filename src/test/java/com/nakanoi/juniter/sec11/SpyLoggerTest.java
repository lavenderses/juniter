package com.nakanoi.juniter.sec11;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/** Test for spy logger. */
public class SpyLoggerTest {
  @Test
  void testSpyLogger() throws Exception {
    SpyExample sut = new SpyExample();
    SpyLogger spy = new SpyLogger(sut.logger);
    sut.logger = spy;
    sut.doSomething();

    assertThat(spy.log.toString()).isEqualTo("doSomething.");
  }
}
