package com.nakanoi.juniter.sec6;

/** Item Stock Interface. */
public interface Stock {
  /**
   * Add item with its name and number.
   *
   * @param name item name
   * @param num item number
   */
  void add(String name, int num);

  /**
   * Return item number.
   *
   * @param name Item name.
   * @return Item number.
   */
  int size(String name);

  /**
   * Is the item in stocks.
   *
   * @param name Item name.
   * @return true if item is.
   */
  boolean contains(String name);
}
