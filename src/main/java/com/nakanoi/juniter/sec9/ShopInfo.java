package com.nakanoi.juniter.sec9;

import java.net.MalformedURLException;
import java.net.URL;

/** Simple shop information class to test assertAll. */
public class ShopInfo {
  Integer id;
  String name;
  String address;
  URL url;

  public ShopInfo() {}

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
