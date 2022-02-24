package com.nakanoi.juniter.sec20;

/** Simple account interface. */
public interface AccountDao {
  /**
   * Find user.
   *
   * @param userId User ID to find.
   * @return Found account or null if not found.
   */
  Account findOrNull(String userId);
}
