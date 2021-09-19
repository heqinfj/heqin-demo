package com.heqin.java8guide.functionalinterfaces;

@FunctionalInterface
public interface Greet<T> {
    void say(T content);
}
