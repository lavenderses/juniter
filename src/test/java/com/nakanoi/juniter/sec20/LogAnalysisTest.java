package com.nakanoi.juniter.sec20;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

/** Simple test for log analysis. */
public class LogAnalysisTest {
  @Test
  void testAnalyzeWithInvalidFileGetsIoException() {
    String filepath = "sampleFilePath.path";
    LogAnalyzer analyzer = new LogAnalyzer();
    analyzer.setLoader(
        new LogLoader() {
          @Override
          public HashMap<String, String> load(String filepath) throws IOException {
            throw new IOException("This is a message.");
          }
        });

    Exception e =
        assertThrows(
            IOException.class,
            () -> {
              analyzer.analyze(filepath);
            });
    assertThat(e.getMessage()).isEqualTo("This is a message.");
  }

  @Test
  void testAnalyzeWithMockGetsIoException() throws Exception {
    String filepath = "sampleFilePath.path";
    LogLoader mock = mock(LogLoader.class);
    when(mock.load(filepath)).thenThrow(new IOException("This is a message."));
    LogAnalyzer analyzer = new LogAnalyzer();
    analyzer.setLoader(mock);

    Exception e =
        assertThrows(
            IOException.class,
            () -> {
              analyzer.analyze(filepath);
            });
    assertThat(e.getMessage()).isEqualTo("This is a message.");
  }
}
