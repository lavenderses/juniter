package com.nakanoi.juniter.sec1;

/** Simple calculator to multiply and divide multiple numbers. */
public class Calc {
  /**
   * Multiple Method.
   *
   * @param x Number to multiply.
   * @param y Number to be multiplied.
   * @return Number multiplied with x and y.
   */
  public int multiply(int x, int y) {
    return x * y;
  }

  /**
   * Division Method.
   *
   * @param x Number to be divided.
   * @param y Number to divide.
   * @return Number divided x with y. Which is double type.
   */
  public double divide(int x, int y) {
    if (y == 0) {
      throw new IllegalArgumentException("Divide by 0.");
    }
    return (double) x / (double) y;
  }
}
