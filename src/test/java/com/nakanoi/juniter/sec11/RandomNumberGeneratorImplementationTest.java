package com.nakanoi.juniter.sec11;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Test for RandomNumberGeneratorImplementation. */
public class RandomNumberGeneratorImplementationTest {
  List<String> options;

  @BeforeEach
  void setUp() throws Exception {
    options = new ArrayList<>();
    options.add("A");
    options.add("B");
  }

  @Test
  void testChoiceGetAwithIndex0() throws Exception {
    Randoms sut = new Randoms();
    sut.generator =
        new RandomNumberGenerator() {
          @Override
          public int nextInt() {
            return 0;
          }
        };
    assertThat(sut.choice(options)).isEqualTo("A");
  }

  @Test
  void testChoiceGetBwithIndex0ImplementedWithStub() throws Exception {
    Randoms sut = new Randoms();
    sut.generator = new RandomNumberGeneratorStub();
    assertThat(sut.choice(options)).isEqualTo("B");
  }
}
