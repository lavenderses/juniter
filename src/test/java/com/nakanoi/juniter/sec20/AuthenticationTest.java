package com.nakanoi.juniter.sec20;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/** Simple test for auth. */
public class AuthenticationTest {
  Authentication sut;
  AccountDao dao;

  @BeforeEach
  void setUp() throws Exception {
    sut = new Authentication();
    dao = mock(AccountDao.class);
  }

  @Nested
  class AuthenticationWithValidInfoTest {
    @Test
    void testAuthWithExistedAccount() throws Exception {
      String username = "username";
      String password = "password";
      when(dao.findOrNull(username)).thenReturn(new Account(username, password));
      sut.setAccountDao(dao);

      Account actual = sut.auth(username, password);

      assertThat(actual.getUsername()).isEqualTo(username);
      assertThat(actual.getPassword()).isEqualTo(password);
    }
  }

  @Nested
  class AuthenticationWithInvalidInfoTest {
    @Test
    void testAuthWithNonExistedAccount() throws Exception {
      String username = "nonExisted";
      String password = "password";
      when(dao.findOrNull(username)).thenReturn(null);
      sut.setAccountDao(dao);

      Exception e = assertThrows(AuthenticationException.class, () -> sut.auth(username, password));
      assertThat(e.getMessage()).isEqualTo("Account not found.");
    }

    @Test
    void testAuthWithInvalidPassword() throws Exception {
      String username = "username";
      String password = "password";
      String invalidPassword = "invalidPassword";
      when(dao.findOrNull(username)).thenReturn(new Account(username, password));
      sut.setAccountDao(dao);

      Exception e =
          assertThrows(AuthenticationException.class, () -> sut.auth(username, invalidPassword));
      assertThat(e.getMessage()).isEqualTo("Password is invalid.");
    }

    @Test
    void testAuthWithNullDao() throws Exception {
      String username = "username";
      String password = "password";

      Exception e = assertThrows(AuthenticationException.class, () -> sut.auth(username, password));
      assertThat(e.getMessage()).isEqualTo("Dao is not configured.");
    }
  }
}
