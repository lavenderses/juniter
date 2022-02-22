package com.nakanoi.juniter.sec16;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/** Calculator test class. */
public class CalculatorTest {
  @Test
  void testAdd3Plus7Gets7() throws Exception {
    Calculator sut = new Calculator();
    assertThat(sut.add(3, 4)).isEqualTo(7);
  }

  @Test
  void testAdd1Plus5Gets6() throws Exception {
    Calculator sut = new Calculator();
    assertThat(sut.add(1, 5)).isEqualTo(6);
  }
}
