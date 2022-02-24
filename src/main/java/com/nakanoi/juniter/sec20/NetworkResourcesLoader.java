package com.nakanoi.juniter.sec20;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/** Simple loader of network resources. */
public class NetworkResourcesLoader {
  /**
   * Load resource from url.
   *
   * @return Resource stream.
   * @throws IOException Exception for io.
   */
  public InputStream load() throws IOException {
    String path = "https://example.com";
    URL url = new URL(path);
    return url.openStream();
  }
}
