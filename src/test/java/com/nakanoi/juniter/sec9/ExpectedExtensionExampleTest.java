package com.nakanoi.juniter.sec9;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/** Test for exception. */
public class ExpectedExtensionExampleTest {
  @Test
  void testExceptionAndItsMessage() throws Exception {
    Throwable exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              throw new IllegalArgumentException("This is an exception.");
            });
    assertThat(exception.getMessage()).isEqualTo("This is an exception.");
  }
}
