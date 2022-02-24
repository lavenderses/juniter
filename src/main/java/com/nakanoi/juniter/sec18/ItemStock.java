package com.nakanoi.juniter.sec18;

import java.util.HashMap;

/** Simple item stock. */
public class ItemStock {
  private HashMap<Item, Integer> items;

  public ItemStock() {
    items = new HashMap<>();
  }

  public int size() {
    return items.size();
  }

  public int getItemNumber(Item item) {
    return items.getOrDefault(item, 0);
  }

  public void add(Item additionalItem) {
    int itemNumber = getItemNumber(additionalItem);
    items.put(additionalItem, itemNumber + 1);
  }
}
