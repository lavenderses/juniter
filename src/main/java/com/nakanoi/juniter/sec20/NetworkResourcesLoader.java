package com.nakanoi.juniter.sec20;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/** Simple loader of network resources. */
public class NetworkResourcesLoader {
  public InputStream load() throws IOException {
    String path = "https://example.com";
    URL url = new URL(path);
    return url.openStream();
  }
}
