package com.nakanoi.juniter.sec20;

/** Simple exception for authentication. */
public class AuthenticationException extends Exception {
  public AuthenticationException(String s) {
    super(s);
  }
}
