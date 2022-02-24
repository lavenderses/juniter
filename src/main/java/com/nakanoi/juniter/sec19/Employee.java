package com.nakanoi.juniter.sec19;

import java.util.Objects;

/** Simple employee object. */
public class Employee {
  private final String firstName;
  private final String lastName;
  private final String email;

  /**
   * Constructor with string array args.
   *
   * @param elements String array of employee infomation.
   * @throws EmployeeLoaderException File format validation.
   */
  public Employee(String... elements) throws EmployeeLoaderException {
    if (elements.length != 3) {
      throw new EmployeeLoaderException("Employee file format is invalid.");
    }
    this.firstName = elements[0];
    this.lastName = elements[1];
    this.email = elements[2];
  }

  /**
   * Construcotr.
   *
   * @param firstName Employee's firstname.
   * @param lastName Employee's lastname.
   * @param email Employee's email address.
   */
  public Employee(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * Compare objects.
   *
   * @param o Object to be compared.
   * @return Whether o is equal to this instance.
   */
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (o instanceof Employee) {
      Employee employee = (Employee) o;
      return employee.firstName.equals(this.firstName)
          && employee.lastName.equals(this.lastName)
          && employee.email.equals(this.email);
    }
    return false;
  }

  public int hashCode() {
    return Objects.hash(firstName, lastName, email);
  }
}
