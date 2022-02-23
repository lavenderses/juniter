package com.nakanoi.juniter.sec19;

/** Simple checker for combination. */
public class Combination {
  public static boolean isAvailable(String server, String database) {
    switch (server) {
      case "GlassFish":
        return true;
      case "jBoss":
        switch (database) {
          case "DB2":
          case "PostgreSQL":
            return true;
          default:
            return false;
        }
      case "Tomcat":
        return database.equals("MySQL");
      default:
        return false;
    }
  }
}
