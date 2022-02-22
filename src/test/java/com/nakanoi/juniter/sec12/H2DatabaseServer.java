package com.nakanoi.juniter.sec12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.h2.tools.Server;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/** H2 database server extension. */
public class H2DatabaseServer implements BeforeAllCallback, AfterAllCallback {
  private final String baseDir;
  private final String dbName;
  private final String schemaName;
  private final String query;
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
    this.dbName = dbName;
    this.schemaName = schemaName;
    this.query = "CREATE SCHEMA IF NOT EXISTS " + schemaName;
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    server = Server.createTcpServer("-baseDir", baseDir);
    server.start();

    String url = "jdbc:h2:" + server.getURL() + "/./" + dbName + ";DATABASE_TO_UPPER=false";
    // String query = "CREATE SCHEMA IF NOT EXISTS ?";

    try (Connection connection =
            DriverManager.getConnection(
                url, System.getenv("H2DATABASE_USERNAME"), System.getenv("H2DATABASE_PASSWORD"));
        PreparedStatement statement = connection.prepareStatement(query)) {
      // statement.setString(1, schemaName);
      statement.executeUpdate();
    }
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    server.shutdown();
  }
}
