package com.nakanoi.juniter.sec19;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Simple test for number to list conversion. */
public class NumberToListTest {
  @ParameterizedTest
  @MethodSource("sourceNumberAndExpectedList")
  void testConversion(int number, List<String> expectedList) throws Exception {
    ArrayList<String> actual = NumberToList.convert(number);
    ArrayList<String> expected = new ArrayList<String>(expectedList);

    assertThat(actual.size()).isEqualTo(number);
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> sourceNumberAndExpectedList() {
    return Stream.of(
        arguments(2, Arrays.asList("1", "2")),
        arguments(4, Arrays.asList("1", "2", "Fizz", "4")),
        arguments(6, Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz")),
        arguments(
            15,
            Arrays.asList(
                "1",
                "2",
                "Fizz",
                "4",
                "Buzz",
                "Fizz",
                "7",
                "8",
                "Fizz",
                "Buzz",
                "11",
                "Fizz",
                "13",
                "14",
                "FizzBuzz")));
  }
}
