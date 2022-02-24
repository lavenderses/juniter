package com.nakanoi.juniter.sec18;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/** Simple tests for calculator. */
public class CalculatorTest {
  @ParameterizedTest
  @CsvSource({"4, 2, 2", "12, 3, 4", "12, 5, 2", "0, 7, 0"})
  void testDivideWithValidArgs(int x, int y, int expected) throws Exception {
    Calculator sut = new Calculator();
    int actual = sut.divide(x, y);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testDivideWith0DivisionGetsIllegalArgumentException() throws Exception {
    Calculator sut = new Calculator();
    int x = 10;
    int y = 0;

    Exception e = assertThrows(IllegalArgumentException.class, () -> sut.divide(x, y));
    assertThat(e.getMessage()).isEqualTo("Division with 0 is illegal.");
  }
}
