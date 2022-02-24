package com.nakanoi.juniter.sec19;

/** Joiner of string. */
public class Joiner {
  public static String join(String... args) {
    return String.join("\n", args);
  }
}
