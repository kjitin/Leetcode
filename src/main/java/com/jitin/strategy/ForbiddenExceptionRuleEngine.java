package com.jitin.strategy;

import java.util.ArrayList;
import java.util.List;

public class ForbiddenExceptionRuleEngine {

    private static final List<ForbiddenErrorRule<Exception>> forbiddenErrorRules = new ArrayList<>();

    static {
        forbiddenErrorRules.add(new StaffIdError());
    }

    public static RuntimeException getException(Exception exception) {
        ForbiddenErrorRule<Exception> forbiddenErrorRule = forbiddenErrorRules
                .stream()
                .filter(rule -> rule.evaluate(exception))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Default exception"));

        return forbiddenErrorRule.getRuntimeException(exception);
    }
}
