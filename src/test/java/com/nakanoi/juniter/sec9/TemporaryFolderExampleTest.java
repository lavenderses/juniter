package com.nakanoi.juniter.sec9;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/** Test TemporaryFolder with TempDir. */
public class TemporaryFolderExampleTest {
  @TempDir Path tempDir;

  /**
   * Test temporary folder IO.
   *
   * @throws IOException Exception for IO.
   */
  @Test
  void mkDefaultFilesCreates2Files() throws Exception {
    assertThat(Files.isDirectory(tempDir)).isTrue();
    TemporaryFolderExampleTest.mkDefaultFiles(tempDir);
    File[] files = tempDir.toFile().listFiles();
    assertThat(files).isNotNull();
    Arrays.sort(files);

    assertThat(files).isNotNull();
    assertThat(files.length).isEqualTo(2);
    assertThat(files[0].getName()).isEqualTo("UnitTest");
    assertThat(files[1].getName()).isEqualTo("readme.txt");
  }

  /**
   * Create "UnitTest" and "readme.txt" files.
   *
   * @param folder Folder you want to create file in.
   * @throws IOException Exception for IO.
   */
  static void mkDefaultFiles(Path folder) throws Exception {
    Path firstCreateFile = Files.createFile(folder.resolve("UnitTest"));
    Path secondCreateFile = Files.createFile(folder.resolve("readme.txt"));
  }
}
