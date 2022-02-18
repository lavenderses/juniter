package com.nakanoi.juniter.sec6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;

/** Nested tests with @BeforeEach. */
public class ItemStockTest {
  @Nested
  class InitialStateTest {
    ItemStock sut;
    String itemName = "itemA";

    @BeforeEach
    void createItemStock() {
      sut = new ItemStock();
    }

    @Test
    void testSizeGet0() {
      int actual = sut.size(itemName);
      int expected = 0;

      assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testContainsGetFalse() {
      boolean actual = sut.contains(itemName);

      assertThat(actual).isFalse();
    }
  }

  @Nested
  class WhenHaveOneItemTest {
    ItemStock sut;
    String existingItemName = "itemA";
    int existingItemNumber = 1;

    @BeforeEach
    void createItemStockAndAddOneItem() {
      sut = new ItemStock();
      sut.add(existingItemName, existingItemNumber);
    }

    @Test
    void sizeGet1WithExistingItemName() {
      int actual = sut.size(existingItemName);
      int expected = existingItemNumber;

      assertThat(actual).isEqualTo(expected);
    }

    @Test
    void containsGetTrueWithExistingItemName() {
      boolean actual = sut.contains(existingItemName);

      assertThat(actual).isTrue();
    }
  }

  @Nested
  class WhenHaveTwoItemsTest {
    ItemStock sut;
    String existingItemAName = "itemA";
    String existingItemBName = "itemB";
    int existingItemANumber = 1;
    int existingItemBNumber = 2;

    @BeforeEach
    void setUp() {

      sut = new ItemStock();
      sut.add(existingItemAName, existingItemANumber);
      sut.add(existingItemBName, existingItemBNumber);
    }

    @Test
    void testSizeGet1WithItemNameA() {
      int actual = sut.size(existingItemAName);
      int expected = existingItemANumber;

      assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testSizeGet2WithItemNameB() {
      int actual = sut.size(existingItemBName);
      int expected = existingItemBNumber;

      assertThat(actual).isEqualTo(expected);
    }
  }

  /** Test With Yaml. */
  @Nested
  @Disabled
  class WhenHaveTwoItemsFromYamlTest {
    ItemStock sut;
    String existingItemAName = "itemA";
    String existingItemBName = "itemB";
    String yamlFilePath = "two_items.yaml";
    int existingItemANumber = 1;
    int existingItemBNumber = 2;

    @BeforeEach
    void setUpWithYaml() {
      Yaml yaml = new Yaml();
      sut = yaml.load(getClass().getResourceAsStream(yamlFilePath));
    }

    @Test
    void testSizeGet1WithItemNameA() {
      int actual = sut.size(existingItemAName);
      int expected = existingItemANumber;

      assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testSizeGet2WithItemNameB() {
      int actual = sut.size(existingItemBName);
      int expected = existingItemBNumber;

      assertThat(actual).isEqualTo(expected);
    }
  }
}
