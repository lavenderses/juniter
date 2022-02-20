package com.nakanoi.juniter.sec9;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/** Test for TestName. */
public class TestNameExampleTest {
  @Test
  void sampleTestName(TestInfo testInfo) {
    assertThat(testInfo.getDisplayName()).isEqualTo("sampleTestName(TestInfo)");
  }

  @Test
  @DisplayName("This is a test with DisplayName.")
  void sampleTestNameWithDisplayName(TestInfo testInfo) {
    assertThat(testInfo.getDisplayName()).isEqualTo("This is a test with DisplayName.");
  }
}
