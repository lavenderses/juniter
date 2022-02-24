package com.nakanoi.juniter.sec9;

import java.util.Optional;
import java.util.logging.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

/** An extension for TestWatcher. */
public class TestWatcherExampleExtension implements TestWatcher {
  @Override
  public void testDisabled(ExtensionContext context, Optional<String> reason) {
    Logger.getAnonymousLogger().info(logMessageWithContext("skipped", context));
  }

  @Override
  public void testSuccessful(ExtensionContext context) {
    Logger.getAnonymousLogger().info(logMessageWithContext("succeeded", context));
  }

  @Override
  public void testAborted(ExtensionContext context, Throwable cause) {
    Logger.getAnonymousLogger().info(logMessageWithContext("aborted", context));
  }

  @Override
  public void testFailed(ExtensionContext context, Throwable cause) {
    Logger.getAnonymousLogger().info(logMessageWithContext("failed", context));
  }

  private String logMessageWithContext(String reason, ExtensionContext context) {
    return String.format("%s: %s", reason, context.getDisplayName());
  }
}
