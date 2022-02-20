package com.nakanoi.juniter.sec11;

import java.util.List;

public class Randoms {
  RandomNumberGenerator generator = new RandomNumberGeneratorImplementation();

  public <T> T choice(List<T> options) {
    if (options.isEmpty()) {
      return null;
    }
    int idx = generator.nextInt() % options.size();
    return options.get(idx);
  }
}
