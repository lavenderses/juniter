package com.nakanoi.juniter.sec6;

import java.util.HashMap;
import java.util.Map;

/** Stock for items. */
public class ItemStock implements Stock {
  private final Map<String, Integer> stocks = new HashMap<>();

  /**
   * Add item with its name and number.
   *
   * @param name Item name.
   * @param num Item number.
   */
  @Override
  public void add(String name, int num) {
    int stock = 0;
    if (contains(name)) {
      stock = stocks.get(name);
    }
    stocks.put(name, num + stock);
  }

  /**
   * Return item number. Return 0 when the item isn't in stocks.
   *
   * @param name Item name.
   * @return Item number. Return 0 when the item isn't in stocks.
   */
  @Override
  public int size(String name) {
    int stock = 0;
    if (contains(name)) {
      stock = stocks.get(name);
    }
    return stock;
  }

  /**
   * Is the item in stocks.
   *
   * @param name Item name
   * @return Whether the item is in stocks.
   */
  @Override
  public boolean contains(String name) {
    return stocks.containsKey(name);
  }
}
