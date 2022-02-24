package com.nakanoi.juniter.sec18;

/** Simple sleeping thread. */
public class FiveSecondsSleepThread extends Thread {
  @Override
  public void run() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
