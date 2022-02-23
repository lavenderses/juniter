package com.nakanoi.juniter.sec18;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/** Test for background task. */
public class BackgroundTaskTest {
  @Test
  @Timeout(6)
  void testBackgroundWithThree5secsTasks() throws Exception {
    Thread fiveSecondsSleepThread;
    for (int i = 0; i < 3; i++) {
      fiveSecondsSleepThread = new FiveSecondsSleepThread();
      fiveSecondsSleepThread.start();
    }
  }
}
