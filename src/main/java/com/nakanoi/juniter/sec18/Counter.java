package com.nakanoi.juniter.sec18;

/** Simple counter class. */
public class Counter {
  private int value;

  public Counter() {
    value = 0;
  }

  public int getValue() {
    return value;
  }

  public int get() {
    value += 1;
    return value;
  }
}
