package com.heqin.java8guide.chapter05;

import java.util.function.Predicate;

public class MyPredicatesDemo {
    public static void main(String[] args) {
        Predicate<String> negate = new MyPredicate().negate();
        boolean test = negate.test("foo");
        System.out.println(test);
    }
}
