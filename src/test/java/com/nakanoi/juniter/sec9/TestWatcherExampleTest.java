package com.nakanoi.juniter.sec9;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/** Tet for TestWatcher extension. */
@ExtendWith(TestWatcherExampleExtension.class)
public class TestWatcherExampleTest {
  @Disabled
  @Test
  void testDisabled() throws Exception {
    assertThat(1).isEqualTo(1);
  }

  @Test
  void testWillSucceed() throws Exception {
    assertThat(1).isEqualTo(1);
  }

  @Disabled
  @Test
  void testWillFail() throws Exception {
    assertThat(1).isEqualTo(2);
  }
}
