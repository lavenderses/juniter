package com.nakanoi.juniter.sec19;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/** Simple test for combination available. */
public class CombinationTest {
  @ParameterizedTest
  @CsvSource({"GlassFish, Oracle", "jBoss, DB2", "Tomcat, MySQL"})
  void testIsAvailableCombinationGetsTrue(String server, String database) throws Exception {
    assertTrue(Combination.isAvailable(server, database));
  }

  @ParameterizedTest
  @CsvSource({"jBoss, Oracle", "Tomcat, PostgreSQL"})
  void testIsAvailableCombinationGetsFalse(String server, String database) throws Exception {
    assertFalse(Combination.isAvailable(server, database));
  }
}
