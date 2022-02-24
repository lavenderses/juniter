package com.nakanoi.juniter.sec18;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/** Change camel case test with parameters. */
public class ChangeCamelCaseParameterizedTest {
  @ParameterizedTest
  @CsvSource({
    "hello world, helloWorld",
    "good night world, goodNightWorld",
    ", ",
    "good-bye-world, goodByeWorld",
    "com_nakanoi_test, comNakanoiTest",
    "tHiS iS it, thisIsIt"
  })
  void testChangeCamelWithParams(String change, String expected) throws Exception {
    change = change == null ? "" : change;
    expected = expected == null ? "" : expected;
    ChangeCamelCase sut = new ChangeCamelCase();
    String actual = sut.change(change);

    assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource({"hello, Hello", "a, A", ", ", "hElLo, Hello"})
  void testCapitalizeFirstCharacterWithParams(String change, String expected) throws Exception {
    change = change == null ? "" : change;
    expected = expected == null ? "" : expected;
    ChangeCamelCase sut = new ChangeCamelCase();
    String actual = sut.capitalizeFirstCharacter(change, false);

    assertThat(actual).isEqualTo(expected);
  }
}
