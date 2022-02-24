package com.nakanoi.juniter.sec20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/** Simple accessor to network resources. */
public class NetworkResources {
  private NetworkResourcesLoader loader;

  public NetworkResources() {
    loader = new NetworkResourcesLoader();
  }

  /**
   * Simple load from url.
   *
   * @return Resource content.
   * @throws IOException Exception for io.
   */
  String load() throws IOException, URISyntaxException {
    String content = "";
    InputStream stream = loader.load();
    InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
    try (BufferedReader bufferedReader = new BufferedReader(reader)) {
      content = bufferedReader.lines().collect(Collectors.joining(""));
    }

    return content;
  }

  public void setLoader(NetworkResourcesLoader loader) {
    this.loader = loader;
  }
}
