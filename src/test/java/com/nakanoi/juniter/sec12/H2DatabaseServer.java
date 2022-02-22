package com.nakanoi.juniter.sec12;

import org.h2.tools.Server;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/** H2 database server extension. */
public class H2DatabaseServer implements BeforeAllCallback, AfterAllCallback {
  private final String baseDir;
  Server server;

  /**
   * Constructor of H2DatabaseServer class.
   *
   * @param baseDir Base directory path.
   * @param dbName Database name.
   * @param schemaName Schema name.
   */
  public H2DatabaseServer(String baseDir, String dbName, String schemaName) {
    this.baseDir = baseDir;
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    server = Server.createTcpServer("-baseDir", baseDir);
    server.start();
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    server.shutdown();
  }
}
