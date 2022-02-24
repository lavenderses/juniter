package com.nakanoi.juniter.sec19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

/** Matcher for joiner. */
public class JoinerMatcher extends BaseMatcher<String> {
  private final String expected;
  private final List<String> expectedLines;
  private String exceptionActual;
  private String exceptionExpected;

  public JoinerMatcher(String expected) {
    this.expected = expected;
    this.expectedLines = Arrays.stream(expected.split("\n")).collect(Collectors.toList());
  }

  @Override
  public boolean matches(Object actual) {
    if (actual == null) {
      return expected == null;
    }
    if (actual instanceof String) {
      String actualLine = String.valueOf(actual);
      List<String> actualLines = Arrays.stream(actualLine.split("\n")).collect(Collectors.toList());
      if (actualLines.size() != expectedLines.size()) {
        return false;
      }
      ArrayList<Pair<String, String>> map = zip(actualLines, expectedLines);
      for (Pair<String, String> pair : map) {
        if (pair.different()) {
          exceptionActual = pair.getFirst();
          exceptionExpected = pair.getLast();
          return false;
        }
      }
      return true;
    }
    return false;
  }

  @Override
  public void describeTo(Description description) {
    description.appendValue(exceptionExpected);
    description.appendText(". But this index got to be ");
    description.appendValue(exceptionActual);
  }

  private ArrayList<Pair<String, String>> zip(List<String> firstList, List<String> lastList) {
    ArrayList<Pair<String, String>> map = new ArrayList<>();
    for (int i = 0; i < firstList.size(); i++) {
      map.add(new Pair<String, String>(firstList.get(i), lastList.get(i)));
    }
    return map;
  }
}
