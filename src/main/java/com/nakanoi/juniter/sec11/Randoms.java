package com.nakanoi.juniter.sec11;

import java.util.List;

/** Class which choice random element from options. */
public class Randoms {
  RandomNumberGenerator generator = new RandomNumberGeneratorImplementation();

  /**
   *  Choice random element from given options.
   *
   * @param options List which has elements to select.
   * @param <T> Class of list element.
   * @return Element in given options.
   */
  public <T> T choice(List<T> options) {
    if (options.isEmpty()) {
      return null;
    }
    int idx = generator.nextInt() % options.size();
    return options.get(idx);
  }
}
