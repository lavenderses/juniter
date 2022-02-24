package com.nakanoi.juniter.sec11;

import java.security.SecureRandom;
import java.util.Random;

/** Implementation of RandomNumberGenerator interface. */
public class RandomNumberGeneratorImplementation implements RandomNumberGenerator {
  private final Random rand = new SecureRandom();

  @Override
  public int nextInt() {
    return rand.nextInt();
  }
}
