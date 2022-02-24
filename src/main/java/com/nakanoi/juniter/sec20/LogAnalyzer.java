package com.nakanoi.juniter.sec20;

import java.io.IOException;

/** Simple log analyzer. */
public class LogAnalyzer {
  private LogLoader logLoader;

  public LogAnalyzer() {
    logLoader = new LogLoader();
  }

  /**
   * Analyze log file from arg.
   *
   * @param filepath Log file path to analyze.
   * @throws IOException Exception for IO.
   */
  public void analyze(String filepath) throws IOException {
    try {
      logLoader.load(filepath);
    } catch (IOException e) {
      throw new IOException(e.getMessage());
    }
  }

  void setLoader(LogLoader logLoader) {
    this.logLoader = logLoader;
  }
}
