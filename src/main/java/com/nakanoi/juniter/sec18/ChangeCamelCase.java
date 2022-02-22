package com.nakanoi.juniter.sec18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Change string to snake case. */
public class ChangeCamelCase {
  public String change(String s) {
    String splitRegex = "(-|_|\s)+";
    List<String> strings = Arrays.asList(s.split(splitRegex));
    List<String> capitalizeds = new ArrayList<>();

    capitalizeds.add(strings.get(0));
    capitalizeds.addAll(
        strings.subList(1, strings.size()).stream().map(this::capitalizeFirstCharacter).toList());

    return s.isEmpty() ? s : String.join("", capitalizeds);
  }

  String capitalizeFirstCharacter(String string) {
    return string.isEmpty() ? string : string.substring(0, 1).toUpperCase() + string.substring(1);
  }
}
