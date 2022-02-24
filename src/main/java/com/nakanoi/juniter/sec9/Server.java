package com.nakanoi.juniter.sec9;

/** Simulated server class. */
public class Server {
  private boolean isOn = false;

  public void start() {
    isOn = true;
  }

  public String get(String path) {
    return path;
  }

  public void shutdown() {
    isOn = false;
  }

  public boolean getStatus() {
    return isOn;
  }
}
