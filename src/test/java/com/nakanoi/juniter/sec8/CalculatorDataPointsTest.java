package com.nakanoi.juniter.sec8;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

/** Calculator data points test for 8.14. */
public class CalculatorDataPointsTest {
  /**
   * Test sum of 2 args is equal to expected value.
   *
   * @param x Arg to be summed.
   * @param y Another arg to be summed.
   * @param expected Expected value of the sum.
   */
  @ParameterizedTest
  @MethodSource("myArgumentsProvider")
  void add(int x, int y, int expected) {
    int actual = x + y;

    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> myArgumentsProvider() {
    return Stream.of(arguments(1, 2, 3), arguments(4, 5, 9));
  }

  /**
   * Test sum of 2 args is equal to expected value.
   *
   * @param argsAccessor Argument accessor from CsvSource.
   */
  @ParameterizedTest(name = "Test of {index}: Is {0} + {1} => {2}?")
  @CsvSource({"1, 2, 3", "4, 5, 9"})
  void add(ArgumentsAccessor argsAccessor) {
    int actual = argsAccessor.get(0, Integer.class) + argsAccessor.get(1, Integer.class);
    int expected = argsAccessor.getInteger(2);

    assertThat(actual).isEqualTo(expected);
  }
}
