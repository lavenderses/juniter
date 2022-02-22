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

  public DbResource(String url, String schemaName) {
    this(
        url,
        System.getenv("H2DATABASE_USERNAME"),
        System.getenv("H2DATABASE_PASSWORD"),
        schemaName);
  }

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

  public void deleteAll() throws SQLException, DatabaseUnitException {
    String deleteALl = "DELETE FROM users WHERE id >= ?";
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      IDatabaseConnection dbConnection = new DatabaseConnection(connection, schemaName);

      try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(deleteALl)) {
        statement.setInt(1, 0);
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
