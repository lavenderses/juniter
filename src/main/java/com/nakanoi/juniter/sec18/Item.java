package com.nakanoi.juniter.sec18;

import java.util.Objects;

/** Simple item class. */
public class Item implements Cloneable {
  public final String name;
  public final int price;

  public Item(String name, int price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (o instanceof Item) {
      Item item = (Item) o;
      return item.name.equals(this.name);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public Item clone() throws CloneNotSupportedException {
    return (Item) super.clone();
  }
}
