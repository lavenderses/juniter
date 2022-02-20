package com.nakanoi.juniter.sec9;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/** Shop info test tests for assertAll. */
public class ShopInfoTest {
  @Nested
  class InstantiateTest {
    @Test
    void testDefaultConstructor() throws Exception {
      ShopInfo instance = new ShopInfo();

      assertAll(
          () -> {
            assertThat(instance).isNotNull();
            assertThat(instance.id).isNull();
            // Fails.
            // assertThat(instance.name).isEqualTo("");
            // assertThat(instance.address).isEqualTo("");
            assertThat(instance.name).isNull();
            assertThat(instance.address).isNull();
            assertThat(instance.url).isNull();
          });
    }
  }
}
