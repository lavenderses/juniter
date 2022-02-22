package com.nakanoi.juniter.sec18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** Change string to snake case. */
public class ChangeCamelCase {
  public String change(String s) {
    String splitRegex = "(-|_|\\s)+";
    List<String> strings = Arrays.asList(s.split(splitRegex));
    List<String> capitalizeds = new ArrayList<>();

    capitalizeds.add(capitalizeFirstCharacter(strings.get(0), true));
    capitalizeds.addAll(
        strings.subList(1, strings.size()).stream()
            .map(string -> capitalizeFirstCharacter(string, false))
            .collect(Collectors.toList()));

    return s.isEmpty() ? s : String.join("", capitalizeds);
  }

  String capitalizeFirstCharacter(String string, boolean isFirst) {
    if (isFirst) {
      return string.isEmpty() ? string : string.toLowerCase();
    } else {
      return string.isEmpty()
          ? string
          : string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }
  }
}
