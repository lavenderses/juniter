package com.nakanoi.juniter.sec20;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/** Simple test for standard output. */
public class OutputHelloWorldTest {
  @Test
  void testOutput() {
    ArrayList<String> outputList = new ArrayList<>();

    OutputHelloWorld sut =
        new OutputHelloWorld() {
          @Override
          void output(String string) {
            outputList.add(string);
            super.output(string);
          }
        };
    String string = "Hello World";
    sut.print(string);

    assertThat(outputList.size()).isEqualTo(1);
    assertThat(outputList.get(0)).isEqualTo(string);
  }
}
