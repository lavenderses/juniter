package com.nakanoi.juniter.sec18;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/** Simple test for item stock. */
public class ItemStockTest {
  ItemStock sut = new ItemStock();

  @Nested
  class ConstructorTest {
    @Test
    void testConstructorGetsSize0() throws Exception {
      assertThat(sut.size()).isEqualTo(0);
    }
  }

  @Nested
  class WhenItemStockHasNoItemsTest {
    @Test
    void testAddNewItem() throws Exception {
      Item newItem = new Item("New Item", 200);
      sut.add(newItem);

      assertThat(sut.size()).isEqualTo(1);
      assertThat(sut.getItemNumber(newItem)).isEqualTo(1);
    }

    @Test
    void testGetItemWithNonExistingItemNameGets0() throws Exception {
      Item nonExistingItem = new Item("Non existing item", 500);
      assertThat(sut.getItemNumber(nonExistingItem)).isEqualTo(0);
    }
  }

  @Nested
  class WhenItemStockHasOneItemTest {
    Item existedItem;

    @BeforeEach
    void setUp() {
      existedItem = new Item("Existed Item", 400);
      sut.add(existedItem);
    }

    @Test
    void testGetItemNumberWithExistedItemGets1() {
      assertThat(sut.size()).isEqualTo(1);
      assertThat(sut.getItemNumber(existedItem)).isEqualTo(1);
    }

    @Test
    void testAddNewItem() throws Exception {
      Item newItem = new Item("New Item", 200);
      sut.add(newItem);

      assertThat(sut.size()).isEqualTo(2);
      assertThat(sut.getItemNumber(newItem)).isEqualTo(1);
    }

    @Test
    void testAddExistedItem() throws Exception {
      Item clone = existedItem.clone();
      sut.add(clone);

      assertThat(sut.size()).isEqualTo(1);
      assertThat(sut.getItemNumber(clone)).isEqualTo(2);
      assertThat(sut.getItemNumber(existedItem)).isEqualTo(2);
    }
  }
}
