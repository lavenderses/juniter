package com.nakanoi.juniter.sec9;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/** Timeout test with extensions. */
public class TimeoutExampleTest {
  /**
   * Test timeout with annotation.
   *
   * @throws Exception Throw timeout.
   */
  @Test
  @Timeout(2)
  void testTimeoutWIthAnnotation() throws Exception {
    Thread.sleep(1000);
  }

  /**
   * Test timeout with assertion.
   *
   * @throws Exception Throw timeout.
   */
  @Test
  void testTimeoutWithAssertion() throws Exception {
    Duration timeout = Duration.ofSeconds(2000);

    assertTimeout(timeout, this::sleep);
  }

  void sleep() throws Exception {
    Thread.sleep(1000);
  }
}
