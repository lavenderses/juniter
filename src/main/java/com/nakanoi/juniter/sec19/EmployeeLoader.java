package com.nakanoi.juniter.sec19;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Simple loader for employee. */
public class EmployeeLoader {
  public static ArrayList<Employee> load(String filePath)
      throws FileNotFoundException, IOException, EmployeeLoaderException {
    ArrayList<Employee> employees = new ArrayList<>();
    List<String> lines = loadLineFromFile(filePath);
    for (String line : lines) {
      String[] elements = line.split(",");
      employees.add(new Employee(elements));
    }

    return employees;
  }

  private static List<String> loadLineFromFile(String filePath)
      throws FileNotFoundException, IOException {
    List<String> lines;

    try (InputStream file = EmployeeLoader.class.getResourceAsStream(filePath)) {
      if (file == null) {
        throw new FileNotFoundException("This file " + filePath + " doesn't exist.");
      }
      try (InputStreamReader streamReader = new InputStreamReader(file, StandardCharsets.UTF_8);
          BufferedReader reader = new BufferedReader(streamReader)) {
        lines = reader.lines().collect(Collectors.toList());
      } catch (IOException e) {
        throw new IOException("Something wrong happened in I/O.");
      }
    }

    return lines;
  }
}
