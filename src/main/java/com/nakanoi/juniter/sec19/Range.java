package com.nakanoi.juniter.sec19;

/** Simple range class. */
public class Range {
  private final double min;
  private final double max;

  public Range(double min, double max) {
    this.min = min;
    this.max = max;
  }

  public boolean contains(double number) {
    return min <= number && number <= max;
  }
}
