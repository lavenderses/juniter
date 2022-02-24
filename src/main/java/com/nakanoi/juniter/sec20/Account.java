package com.nakanoi.juniter.sec20;

/** Simple Account class. */
public class Account {
  private final String username;
  private final String password;

  public Account(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  String getPassword() {
    return password;
  }
}
