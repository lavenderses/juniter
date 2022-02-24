package com.nakanoi.juniter.sec18;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/** Simple test for coutner. */
public class CounterTest {
  Counter sut;

  @BeforeEach
  void setUp() throws Exception {
    sut = new Counter();
  }

  @Nested
  class ConstructorTest {
    @Test
    void testConstructorGetInnerValueGets1() throws Exception {
      int actual = sut.getValue();
      int expected = 0;

      assertThat(actual).isEqualTo(expected);
    }
  }

  @Nested
  class WhenCounterIsInitialTest {
    @Test
    void testGetGets1AndInternalValueIs1() throws Exception {
      int actual = sut.get();
      int expected = 1;

      assertThat(actual).isEqualTo(expected);
      assertThat(sut.getValue()).isEqualTo(expected);
    }
  }

  @Nested
  class WhenCounterCalledGetOnceTest {
    @BeforeEach
    void setUpCallGetOnce() {
      sut.get();
    }

    @Test
    void testGetGets2AndInternalValueIs2() throws Exception {
      int actual = sut.get();
      int expected = 2;

      assertThat(actual).isEqualTo(expected);
      assertThat(sut.getValue()).isEqualTo(expected);
    }
  }
}
