package com.nakanoi.juniter.sec4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/** Simple test. */
public class SimpleTest {
  @Test
  public void testSimpleGet7With3Plus4() throws Exception {
    int actual = 3 + 4;
    int expected = 7;

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testSimpleGetListContainsHello() throws Exception {
    ArrayList<String> actual = new ArrayList<>();
    actual.add("Hello");
    actual.add("World");
    String expected = "Hello";

    assertThat(actual).contains(expected);
  }

  @Test
  public void testCustomMatcherWithInvalidDate() throws Exception {
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    int dayPlus = 0;
    int yyyy = calendar.get(Calendar.YEAR);
    int mm = calendar.get(Calendar.MONTH) + 1;
    int dd = (calendar.get(Calendar.DAY_OF_MONTH) + dayPlus) % 31;

    // Hamcrest
    MatcherAssert.assertThat(date, Matchers.is(IsDate.dateOf(yyyy, mm, dd)));
  }
}
