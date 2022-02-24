package com.nakanoi.juniter.sec9;

import java.net.MalformedURLException;
import java.net.URL;

/** Simple shop information class to test assertAll. */
public class ShopInfo {
  Integer id;
  String name;
  String address;
  URL url;

  /** Constructor with no args. */
  public ShopInfo() {}

  /**
   * Constructor with all member args.
   *
   * @param id Shop ID in integer.
   * @param name Shop name in string.
   * @param address Shop Address in string.
   * @param url Shop HP URL in string.
   * @throws MalformedURLException URL exception.
   */
  public ShopInfo(int id, String name, String address, String url) throws MalformedURLException {
    this.id = id;
    this.name = name;
    this.address = address;
    this.url = new URL(url);
  }

  public String toString() {
    return String.format("ID: %s;%nName: %s;%nAddress: %s;%nURL: %s;", id, name, address, url);
  }
}
