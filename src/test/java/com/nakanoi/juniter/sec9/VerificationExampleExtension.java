package com.nakanoi.juniter.sec9;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/** Verification extension. */
public class VerificationExampleExtension implements BeforeAllCallback, AfterAllCallback {
  VerifierExample verifierExample;

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    verifierExample = new VerifierExample();
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    // Verification which verifies that verifierExample's value should be 0.
    assertThat(verifierExample.getValue()).isZero();
  }

  public VerifierExample getVerifierExample() {
    return verifierExample;
  }
}
