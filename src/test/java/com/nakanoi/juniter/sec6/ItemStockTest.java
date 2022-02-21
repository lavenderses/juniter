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
    void createItemStock() throws Exception {
      sut = new ItemStock();
    }

    @Test
    void testSizeGet0() throws Exception {
      int actual = sut.size(itemName);
      int expected = 0;

      assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testContainsGetFalse() throws Exception {
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
    void createItemStockAndAddOneItem() throws Exception {
      sut = new ItemStock();
      sut.add(existingItemName, existingItemNumber);
    }

    @Test
    void sizeGet1WithExistingItemName() throws Exception {
      int actual = sut.size(existingItemName);
      int expected = existingItemNumber;

      assertThat(actual).isEqualTo(expected);
    }

    @Test
    void containsGetTrueWithExistingItemName() throws Exception {
      boolean actual = sut.contains(existingItemName);

      assertThat(actual).isTrue();
    }
  }

  @Nested
  class WhenHaveTwoItemsTest {
    ItemStock sut;
    String existingItemNameA = "itemA";
    String existingItemNameB = "itemB";
    int existingItemNumberA = 1;
    int existingItemNumberB = 2;

    @BeforeEach
    void setUp() throws Exception {

      sut = new ItemStock();
      sut.add(existingItemNameA, existingItemNumberA);
      sut.add(existingItemNameB, existingItemNumberB);
    }

    @Test
    void testSizeGet1WithItemNameA() throws Exception {
      int actual = sut.size(existingItemNameA);
      int expected = existingItemNumberA;

      assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testSizeGet2WithItemNameB() throws Exception {
      int actual = sut.size(existingItemNameB);
      int expected = existingItemNumberB;

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
    void setUpWithYaml() throws Exception {
      Yaml yaml = new Yaml();
      sut = yaml.load(getClass().getResourceAsStream(yamlFilePath));
    }

    @Test
    void testSizeGet1WithItemNameA() throws Exception {
      int actual = sut.size(existingItemAName);
      int expected = existingItemANumber;

      assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testSizeGet2WithItemNameB() throws Exception {
      int actual = sut.size(existingItemBName);
      int expected = existingItemBNumber;

      assertThat(actual).isEqualTo(expected);
    }
  }
}
