package com.jitin.strategy;

public class StaffIdError implements ForbiddenErrorRule<Exception> {
    @Override
    public boolean evaluate(Exception sourceException) {
       if (sourceException != null)
           return sourceException.getMessage().contains("INVALID_STAFF_ID");
       return false;
    }

    @Override
    public RuntimeException getRuntimeException(Exception sourceException) {
        return new RuntimeException("RunTime exception");
    }
}
