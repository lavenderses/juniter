package com.nakanoi.juniter.sec9;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

/** ClassRule example implemented with ExternalResourceExampleExtension. */
public class ClassRuleExampleTest {
  @RegisterExtension
  static ExternalResourceExampleExtension externalServer =
      ExternalResourceExampleExtension.builder().build();

  @Test
  void test01() {
    assertThat(externalServer.getServer().getStatus()).isEqualTo(true);
  }

  @Test
  void test02() {
    assertThat(externalServer.getServer().get("foo")).isEqualTo("foo");
  }
}
