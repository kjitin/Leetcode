package com.jitin.strategy;

public interface ForbiddenErrorRule<E> {

    boolean evaluate(E sourceException);

    RuntimeException getRuntimeException(E sourceException);
}
