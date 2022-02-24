package com.nakanoi.juniter.sec19;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/** Simple joining test. */
public class JoinerTest {
  @Test
  void testJoinWithOneString() throws Exception {
    String args = "Hello";
    String actual = Joiner.join(args);
    String expected = "Hello";

    assertThat(actual, is(new JoinerMatcher(expected)));
  }

  @Test
  void testJoinWithMultipleString() throws Exception {
    String[] args = {"Hello", "World", "Fizz", "Buzz"};
    String actual = Joiner.join(args);
    String expected = "Hello\nWorld\nFizz\nBuzz";

    assertThat(actual, is(new JoinerMatcher(expected)));
  }

  @Disabled
  @Test
  void testJoinWithDifferentStrings() throws Exception {
    String[] args = {"Foo", "Bar", "Fizz", "Buzz"};
    String actual = Joiner.join(args);
    String expected = "Foo\nDIFFERENT\nFizz\nBuzz";

    assertThat(actual, is(new JoinerMatcher(expected)));
  }
}
