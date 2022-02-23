package com.nakanoi.juniter.sec19;

import java.util.ArrayList;

/** Simple conversion class from number to list. */
public class NumberToList {
  /**
   * Convert number to list on particular rule.
   *
   * @param number Number want to convert from.
   * @return List from number on the rule.
   */
  public static ArrayList<String> convert(int number) {
    ArrayList<String> list = new ArrayList<>();

    for (int i = 1; i <= number; i++) {
      if (i % 15 == 0) {
        list.add("FizzBuzz");
      } else if (i % 5 == 0) {
        list.add("Buzz");
      } else if (i % 3 == 0) {
        list.add("Fizz");
      } else {
        list.add(String.valueOf(i));
      }
    }
    return list;
  }
}
