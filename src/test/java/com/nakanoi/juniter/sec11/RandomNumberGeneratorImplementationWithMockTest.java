package com.nakanoi.juniter.sec11;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.Test;

/** Test RandomNumberGeneratorImplementation with mock. */
public class RandomNumberGeneratorImplementationWithMockTest {
  @Test
  void testGetAWithIndex0() {
    List<String> options = new ArrayList<>();
    options.add("A");
    options.add("B");
    final AtomicBoolean isCalledNextInt = new AtomicBoolean(false);
    Randoms sut = new Randoms();
    sut.generator =
        new RandomNumberGenerator() {
          @Override
          public int nextInt() {
            isCalledNextInt.set(true);
            return 0;
          }
        };
    assertThat(sut.choice(options)).isEqualTo("A");
    assertThat(isCalledNextInt.get()).isTrue();
  }
}
