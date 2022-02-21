package com.nakanoi.juniter.sec9;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/** Test for OS dependency. */
public class OsDependentTest {
  @Test
  @EnabledOnOs(OS.WINDOWS)
  void onlyWindows() throws Exception {
    assertThat(System.getProperties().get("os.name")).isEqualTo("Windows");
  }

  @Test
  @EnabledOnOs(OS.MAC)
  void onlyMac() throws Exception {
    assertThat(System.getProperties().get("os.name")).isEqualTo("Mac");
  }

  @Test
  @EnabledOnOs(OS.LINUX)
  void onlyLinux() throws Exception {
    assertThat(System.getProperties().get("os.name")).isEqualTo("Linux");
  }
}
