package com.nakanoi.juniter.sec8;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/** Parameterized tests class. */
public class ParameterizedTests {
  /**
   * Test value of arg from ValueSource is grater than 2.
   *
   * @param param Int from ValueSource.
   */
  @ParameterizedTest
  @ValueSource(ints = {3, 4})
  void testMethodWithArg(int param) {
    assertThat(param).isGreaterThan(2);
  }

  /**
   * Test string length of arg from ValueSource is 3.
   *
   * @param param String value from ValueSource.
   */
  @ParameterizedTest
  @ValueSource(strings = {"foo", "bar"})
  void testMethodWithArg(String param) {
    assertThat(param.length()).isEqualTo(3);
  }
}
