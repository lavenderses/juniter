package com.nakanoi.juniter.sec18;

/** Simple calculator which runs division. */
public class Calculator {
  /**
   * Run division.
   *
   * @param x Number to be divided.
   * @param y Dividing number.
   * @return Division x of y.
   * @throws IllegalArgumentException 0 division.
   */
  public int divide(int x, int y) throws IllegalArgumentException {
    if (y == 0) {
      throw new IllegalArgumentException("Division with 0 is illegal.");
    }
    return x / y;
  }
}
