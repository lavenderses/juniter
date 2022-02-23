package com.nakanoi.juniter.sec12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.dbunit.DatabaseUnitException;
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
  private final String schemaName;

  /**
   * Constructor of DbResource with url and schema name.
   *
   * @param url DB URL.
   * @param schemaName Schema name to use.
   */
  public DbResource(String url, String schemaName) {
    this(
        url,
        System.getenv("H2DATABASE_USERNAME"),
        System.getenv("H2DATABASE_PASSWORD"),
        schemaName);
  }

  /**
   * DbResource constructor.
   *
   * @param url DB URL.
   * @param username Username to use.
   * @param password User's password.
   * @param schemaName Schema name to use.
   */
  public DbResource(String url, String username, String password, String schemaName) {
    this.url = url;
    this.username = username;
    this.password = password;
    this.schemaName = schemaName;
  }

  @Override
  public void afterEach(ExtensionContext context) throws Exception {
    deleteAll();
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    deleteAll();
  }

  /**
   * Delete all records of users table.
   *
   * @throws SQLException Exception for SQL operation.
   * @throws DatabaseUnitException DbUnit exception.
   */
  public void deleteAll() throws SQLException, DatabaseUnitException {
    String deleteAll = "DELETE FROM users WHERE id >= ?";
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      IDatabaseConnection dbConnection = new DatabaseConnection(connection, schemaName);

      try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(deleteAll)) {
        statement.setInt(1, 0);
        statement.executeUpdate();
      }
    }
  }

  /**
   * Insert records from specified xml file.
   *
   * @param filePath Xml file path which has records to be inserted to users table.
   * @throws Exception SQL exception.
   */
  public void insertFromFile(String filePath) throws Exception {
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      IDatabaseConnection dbConnection = new DatabaseConnection(connection, schemaName);

      IDataSetProducer dataSet =
          new FlatXmlProducer(new InputSource(getClass().getResourceAsStream(filePath)));
      DatabaseOperation.INSERT.execute(dbConnection, new StreamingDataSet(dataSet));
    }
  }
}
