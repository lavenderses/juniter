package com.nakanoi.juniter.sec20;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Simple test for lasted days calculation. */
public class LastDaysTest {
  @ParameterizedTest
  @MethodSource("sourceDateAndExpectedDays")
  void testCalculate(Calendar today, int expected) throws Exception {
    LastDays sut = new LastDays(today);
    int actual = sut.calculate();

    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> sourceDateAndExpectedDays() {
    return Stream.of(
            arguments(getCalender(2022, 1, 13), 18),
            arguments(getCalender(2020, 2, 23), 6),
            arguments(getCalender(2022, 2, 23), 5),
            arguments(getCalender(2022, 12, 31), 0)
    );
  }

  private static Calendar getCalender(int year, int month, int day) {
    Calendar calender = Calendar.getInstance();
    calender.set(year, month - 1, day);
    return calender;
  }
}
