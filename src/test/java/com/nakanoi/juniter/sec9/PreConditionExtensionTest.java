package com.nakanoi.juniter.sec9;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.util.Calendar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/** Test precondition which is that is it Monday. */
@ExtendWith(TestWatcherExampleExtension.class)
public class PreConditionExtensionTest {
  static DayOfWeek dayOfWeek;

  @BeforeAll
  static void setUp() throws Exception {
    dayOfWeek = DayOfWeek.of(Calendar.DAY_OF_WEEK);
  }

  @Test
  @ExtendWith(PreConditionExtension.class)
  @Tag("Sunday")
  void testRunOnlySunday() throws Exception {
    assertThat(dayOfWeek).isEqualTo(DayOfWeek.SUNDAY);
  }

  @Test
  @ExtendWith(PreConditionExtension.class)
  @Tag("Monday")
  void testRunOnlyMonday() throws Exception {
    assertThat(dayOfWeek).isEqualTo(DayOfWeek.MONDAY);
  }
}
