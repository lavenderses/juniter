package com.nakanoi.juniter.sec12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/** Simple Dao to handle User table. */
public class UserDao {
  private final String url;
  private final String username;
  private final String password;

  /**
   * Constructor.
   *
   * @param url Database URL.
   * @param username Database username.
   * @param password Database password.
   */
  public UserDao(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
  }

  /**
   * Get users list from DB.
   *
   * @return Usernames list.
   * @throws SQLException SQL error.
   */
  public List<String> getList(String column) throws SQLException {
    String query = "SELECT * FROM \"users\"";
    LinkedList<String> result = new LinkedList<>();

    try (Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(query)) {
      try (ResultSet rs = statement.executeQuery()) {
        while (rs.next()) {
          String name = rs.getString(column);
          result.add(name);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return result;
  }

  /**
   * Insert user with username.
   *
   * @param username New user's name.
   * @throws SQLException SQL exception.
   */
  public void insert(String username) throws SQLException {
    String query = "INSERT INTO \"users\" VALUES(?)";

    try (Connection connection = DriverManager.getConnection(url)) {
      try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, username);
        statement.executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
