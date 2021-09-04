package com.heqin.java8guide.chapter03_functionalinterface;

@FunctionalInterface
public interface Greet<T> {
    void say(T content);
}
