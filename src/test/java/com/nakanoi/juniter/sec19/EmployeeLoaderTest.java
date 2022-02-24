package com.nakanoi.juniter.sec19;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/** Employee class loader test. */
public class EmployeeLoaderTest {
  String filepath;

  @Nested
  class WhenFileHasOneLineTest {
    @BeforeEach
    void setUp(TestInfo testInfo) {
      filepath = testInfo.getDisplayName() + ".txt";
    }

    @Test
    @DisplayName("testLoaderOneEmployeeWithValidFormat")
    void testLoadOneEmployeeWithValidFormat() throws Exception {
      String[] employeeInfo = {"Bob", "Olsen", "bobolsen@exmple.com"};
      ArrayList<Employee> expected = new ArrayList<>();
      expected.add(new Employee(employeeInfo));

      ArrayList<Employee> actual = EmployeeLoader.load(filepath);

      assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("nonExist")
    void testLoadOneEmployeeWithNonExistFileName() throws Exception {
      Exception e = assertThrows(FileNotFoundException.class, () -> EmployeeLoader.load(filepath));
      assertThat(e.getMessage()).isEqualTo("This file nonExist.txt doesn't exist.");
    }

    @Test
    @DisplayName("invalidFormat")
    void testLoadOneEmployeeWithInvalidFormat() throws Exception {
      Exception e =
          assertThrows(EmployeeLoaderException.class, () -> EmployeeLoader.load(filepath));
      assertThat(e.getMessage()).isEqualTo("Employee file format is invalid.");
    }
  }

  @Nested
  class WhenFileHasMultipleLinesTest {
    @BeforeEach
    void setUp(TestInfo testInfo) {
      filepath = testInfo.getDisplayName() + ".txt";
    }

    @Test
    @DisplayName("multiLinesEmployee")
    void testLoadWithValidFormat() throws Exception {
      String[] bob = {"Bob", "Olsen", "bobolsen@exmple.com"};
      String[] alice = {"Alice", "Rogers", "alicerogers@exmple.com"};
      String[] eve = {"Eve", "Cooper", "evecooper@exmple.com"};
      ArrayList<Employee> expected = new ArrayList<>();
      expected.add(new Employee(bob));
      expected.add(new Employee(alice));
      expected.add(new Employee(eve));

      ArrayList<Employee> actual = EmployeeLoader.load(filepath);

      assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("multiLinesEmployeeWithInvalidFormat")
    void testLoadMultiLinesWithInvalidFormat() throws Exception {
      Exception e =
          assertThrows(EmployeeLoaderException.class, () -> EmployeeLoader.load(filepath));
      assertThat(e.getMessage()).isEqualTo("Employee file format is invalid.");
    }
  }
}
