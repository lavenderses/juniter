package com.nakanoi.juniter.sec9;

/** Simple class to test VerificationExampleTest. */
public class VerifierExample {
  private int value = 0;

  public void set(int x) {
    value = x;
  }

  public void add(int x) {
    value += x;
  }

  public void minus(int x) {
    value -= x;
  }

  /**
   * Get value this instance has. After getting one, it will be reset, become 0.
   *
   * @return Value this instance has.
   */
  public int getValue() {
    int ret = value;
    value = 0;
    return ret;
  }
}
