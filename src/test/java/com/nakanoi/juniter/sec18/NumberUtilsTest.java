package com.nakanoi.juniter.sec18;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/** Simple number util test. */
public class NumberUtilsTest {
  @ParameterizedTest
  @ValueSource(ints = {12, 0, -4})
  void testIsEvenGetsTrue(int number) throws Exception {
    boolean actual = NumberUtil.isEven(number);
    assertTrue(actual);
  }

  @ParameterizedTest
  @ValueSource(ints = {13, 1, -1})
  void testIsEvenGetsFalse(int number) throws Exception {
    boolean actual = NumberUtil.isEven(number);
    assertFalse(actual);
  }
}
