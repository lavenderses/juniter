package com.nakanoi.juniter.sec20;

/** Simple authentication class. */
public class Authentication {
  AccountDao accountDao;

  /**
   * Authentication account.
   *
   * @param username Account username.
   * @param password Account password.
   * @return Account or null if not found.
   * @throws AuthenticationException Authentication error.
   */
  public Account auth(String username, String password) throws AuthenticationException {
    if (accountDao == null) {
      throw new AuthenticationException("Dao is not configured.");
    }

    Account account = accountDao.findOrNull(username);
    if (account == null) {
      throw new AuthenticationException("Account not found.");
    }
    if (!account.getPassword().equals(password)) {
      throw new AuthenticationException("Password is invalid.");
    }

    return account;
  }

  public void setAccountDao(AccountDao accountDao) {
    this.accountDao = accountDao;
  }
}
