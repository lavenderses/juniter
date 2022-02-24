package com.nakanoi.juniter.sec20;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/** Simple test for network resource loading. */
public class NetworkResourcesTest {
  String filename;

  @BeforeEach
  void setUp(TestInfo testInfo) {
    filename = testInfo.getDisplayName() + ".txt";
  }

  @Test
  @DisplayName("testLoadWithValidUrl")
  void testLoadWithValidUrl() throws Exception {
    String expected = "Hello world.";

    NetworkResources sut = new NetworkResources();
    NetworkResourcesLoader mock = mock(NetworkResourcesLoader.class);
    when(mock.load()).thenReturn(getStream(filename));
    sut.setLoader(mock);

    assertThat(sut.load()).isEqualTo(expected);
  }

  @Test
  @DisplayName("testLoadWithValidUrl")
  void testLoadWithByteArrayInputStream() throws Exception {
    String expected = "Hello world.";

    NetworkResources sut = new NetworkResources();
    NetworkResourcesLoader mock = mock(NetworkResourcesLoader.class);
    when(mock.load())
        .thenReturn(new ByteArrayInputStream(expected.getBytes(StandardCharsets.UTF_8)));
    sut.setLoader(mock);

    assertThat(sut.load()).isEqualTo(expected);
  }

  private InputStream getStream(String filename) {
    return getClass().getResourceAsStream(filename);
  }
}
