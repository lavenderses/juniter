package com.nakanoi.juniter.sec9;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;
import java.util.Set;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

/** Simple extension for precondition check. */
public class PreConditionExtension implements ExecutionCondition {
  private final ConditionEvaluationResult enabled =
      ConditionEvaluationResult.enabled("Tag matches to today.");
  private final ConditionEvaluationResult disabled =
      ConditionEvaluationResult.disabled("No tag fot today.");

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    DayOfWeek dayOfWeek = DayOfWeek.of(Calendar.DAY_OF_WEEK);
    String day = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.US);
    Set<String> tags = context.getTags();

    return tags.contains(day) ? enabled : disabled;
  }
}
