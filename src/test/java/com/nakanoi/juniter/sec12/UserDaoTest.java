package com.nakanoi.juniter.sec12;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

/** Test for UserDao with database. */
public class UserDaoTest {
  private static final String baseDir = "h2";
  private static final String dbName = "db";
  private static final String schemaName = "uu";
  private static final String tableName = "\"users\"";
  private static final String tableStructure = "(id INT AUTO_INCREMENT, name VARCHAR(255))";
  private final String url =
      String.format(
          "jdbc:h2:%s/./%s;SCHEMA=%s;DATABASE_TO_UPPER=false",
          server.server.getURL(), dbName, schemaName);

  @RegisterExtension
  static H2DatabaseServer server = new H2DatabaseServer(baseDir, dbName, schemaName);

  @RegisterExtension
  DbResource dbResource = new DbResource(url, tableName, tableStructure, schemaName);

  @Nested
  class WhenTableHasNoRecordsTest {
    UserDao sut;

    @BeforeEach
    void setUp() throws Exception {
      sut =
          new UserDao(
              url, System.getenv("H2DATABASE_USERNAME"), System.getenv("H2DATABASE_PASSWORD"));
    }

    @Test
    void testGetListGetsNoRecordsWithName() throws Exception {
      List<String> actual = sut.getList("name");

      assertThat(actual).isNotNull();
      assertThat(actual.size()).isEqualTo(0);
    }

    @Test
    void testInsert1Record() throws Exception {
      sut.insert("User name");
    }
  }

  @Nested
  class WhenTableHas2RecordsTest {
    UserDao sut;
    String userDaoResourceFileWith2Records = "UserDaoWith2Records.xml";

    @BeforeEach
    void setUp() throws Exception {
      sut =
          new UserDao(
              url, System.getenv("H2DATABASE_USERNAME"), System.getenv("H2DATABASE_PASSWORD"));
      dbResource.insertFromFile(userDaoResourceFileWith2Records);
    }

    @Test
    void testGetListGets2RecordsWithName() throws Exception {
      List<String> actual = sut.getList("name");

      assertThat(actual).isNotNull();
      assertThat(actual.size()).isEqualTo(2);
      assertThat(actual.get(0)).isEqualTo("Ichiro");
      assertThat(actual.get(1)).isEqualTo("Jiro");
    }

    @Test
    void testInsert1Record() throws Exception {}
  }
}
