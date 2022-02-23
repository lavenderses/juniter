package com.nakanoi.juniter.sec19;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/** Simple test for range. */
public class RangeTest {
  @ParameterizedTest
  @CsvSource({
          "-1.01, 2.11, 1.9",
          "-1.01, 2.11, 2.11",
          "-1.01, 2.11, -1.01",
  })
  void testContainsWithInOfRange(double min, double max, double number) {
    Range sut = new Range(min, max);
    boolean actual = sut.contains(number);

    assertTrue(actual);
  }

  @ParameterizedTest
  @CsvSource({
          "-1.01, 2.11, 2.1101",
          "-1.01, 2.11, -1.01001",
  })
  void testContainsWithOutOfRange(double min, double max, double number) {
    Range sut = new Range(min, max);
    boolean actual = sut.contains(number);

    assertFalse(actual);
  }
}
