package com.nakanoi.juniter.sec10;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/** Test mixed in slow and fast tests. */
public class FooTest {
  @Test
  @Tag("slow-test")
  void slowTest(TestInfo testInfo) throws Exception {
    assertThat(testInfo.getTags().contains("slow-test")).isTrue();
    assertThat(testInfo.getTags().contains("fast-test")).isFalse();
  }

  @Test
  @Tag("fast-test")
  void fastTest(TestInfo testInfo) throws Exception {
    assertThat(testInfo.getTags().contains("slow-test")).isFalse();
    assertThat(testInfo.getTags().contains("fast-test")).isTrue();
  }
}
