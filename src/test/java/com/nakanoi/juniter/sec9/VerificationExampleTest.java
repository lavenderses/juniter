package com.nakanoi.juniter.sec9;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

/** Test verification */
public class VerificationExampleTest {
  @RegisterExtension
  static VerificationExampleExtension verificationExampleExtension =
      new VerificationExampleExtension();

  VerifierExample sut;

  @BeforeEach
  void setUp() throws Exception {
    sut = verificationExampleExtension.getVerifierExample();
  }

  @AfterEach
  void tearDown() throws Exception {
    // Do nothing.
  }

  @Test
  void testGetValueReturnsCalcResult() throws Exception {
    sut.set(200);
    sut.add(100);
    sut.minus(50);
    int actual = sut.getValue();

    assertThat(actual).isEqualTo(250);
  }
}
