package com.nakanoi.juniter.sec1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

/** Calc test. */
public class CalcTest {
  @Test
  public void testMultiplyWith3And4() {
    Calc calc = new Calc();
    int expected = 12;
    int actual = calc.multiply(3, 4);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testMultiplyWith5And7() {
    Calc calc = new Calc();
    int expected = 35;
    int actual = calc.multiply(5, 7);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testDivideWith3And2() {
    Calc calc = new Calc();
    double expected = 1.5;
    double actual = calc.divide(3, 2);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testDivideWith0DivideThrowsIllegalArgumentException() {
    Calc calc = new Calc();

    assertThatThrownBy(() -> calc.divide(3, 0)).isInstanceOf(IllegalArgumentException.class);
  }
}
