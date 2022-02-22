package com.nakanoi.juniter.sec12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.stream.IDataSetProducer;
import org.dbunit.dataset.stream.StreamingDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.xml.sax.InputSource;

/** Database resource extension. */
public class DbResource implements BeforeEachCallback, AfterEachCallback {
  private final String url;
  private final String username;
  private final String password;
  private final String tableName;
  private final String tableStructure;
  private final String schemaName;
  private final String dropTable;
  private final String createTable;

  public DbResource(String url, String tableName, String tableStructure, String schemaName) {
    this(
        url,
        System.getenv("H2DATABASE_USERNAME"),
        System.getenv("H2DATABASE_PASSWORD"),
        tableName,
        tableStructure,
        schemaName);
  }

  public DbResource(
      String url,
      String username,
      String password,
      String tableName,
      String tableStructure,
      String schemaName) {
    this.url = url;
    this.username = username;
    this.password = password;
    this.tableName = tableName;
    this.tableStructure = tableStructure;
    this.schemaName = schemaName;
    this.dropTable = "DROP TABLE IF EXISTS " + tableName;
    this.createTable = "CREATE TABLE " + tableName + tableStructure;
  }

  @Override
  public void afterEach(ExtensionContext context) throws Exception {
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      IDatabaseConnection dbConnection = new DatabaseConnection(connection);
      // String dropTable = "DROP TABLE IF EXISTS ?";

      try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(dropTable)) {
        // statement.setString(1, tableName);
        statement.execute();
      }
    }
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      IDatabaseConnection dbConnection = new DatabaseConnection(connection, schemaName);

      // String dropTable = "DROP TABLE IF EXISTS ?";
      // String createTable = "CREATE TABLE ? ?";
      try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(dropTable)) {
        // statement.setString(1, tableName);
        statement.executeUpdate();
      }
      try (PreparedStatement statement =
          dbConnection.getConnection().prepareStatement(createTable)) {
        // statement.setString(1, tableName);
        // statement.setString(2, tableStructure);
        statement.executeUpdate();
      }
    }
  }

  public void insertFromFile(String filePath) throws Exception {
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      IDatabaseConnection dbConnection = new DatabaseConnection(connection, schemaName);

      IDataSetProducer dataSet =
          new FlatXmlProducer(new InputSource(getClass().getResourceAsStream(filePath)));
      DatabaseOperation.INSERT.execute(dbConnection, new StreamingDataSet(dataSet));
    }
  }
}
