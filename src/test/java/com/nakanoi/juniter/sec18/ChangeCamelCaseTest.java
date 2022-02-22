package com.nakanoi.juniter.sec18;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Change a string to Camel case. */
public class ChangeCamelCaseTest {
  ChangeCamelCase sut;

  @BeforeEach
  void setUp() throws Exception {
    sut = new ChangeCamelCase();
  }

  @Test
  void testChangeWith1SpaceGetCamelCase() throws Exception {
    String change = "hello world";
    String actual = sut.change(change);
    String expected = "helloWorld";

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testChangeWith2SpaceGetCamelCase() throws Exception {
    String change = "good night world";
    String actual = sut.change(change);
    String expected = "goodNightWorld";

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testChangeWithNoWordsGetEmptyString() throws Exception {
    String change = "";
    String actual = sut.change(change);
    String expected = "";

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testChangeWith2HyphensStringGetCamelCase() throws Exception {
    String change = "good-bye-world";
    String actual = sut.change(change);
    String expected = "goodByeWorld";

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testChangeWith2UnderlinesStringGetCamelCase() throws Exception {
    String change = "com_nakanoi_test";
    String actual = sut.change(change);
    String expected = "comNakanoiTest";

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testCapitalizeFirstCharacterWithhelloGetsHello() throws Exception {
    String change = "hello";
    String actual = sut.capitalizeFirstCharacter(change);
    String expected = "Hello";

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testCapitalizeFirstCharacterWithaGetsA() throws Exception {
    String change = "a";
    String actual = sut.capitalizeFirstCharacter(change);
    String expected = "A";

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testCapitalizeFirstCharacterWithEmptyStringGetsEmptyString() throws Exception {
    String change = "";
    String actual = sut.capitalizeFirstCharacter(change);
    String expected = "";

    assertThat(actual).isEqualTo(expected);
  }
}
