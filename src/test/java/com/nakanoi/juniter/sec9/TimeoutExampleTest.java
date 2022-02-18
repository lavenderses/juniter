package com.nakanoi.juniter.sec9;

import org.junit.jupiter.api.Disabled;
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
  @Timeout(1)
  @Disabled
  void testMayTakeALotOfTime() throws Exception {
    Thread.sleep(2000);
  }
}
