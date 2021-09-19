package com.heqin.java8tutorials.javautilfunction.javapredicateexample;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateStreamDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Vijay");
        list.add("Ramesh");
        list.add("Mahesh");

        Predicate<String> isNameEndsWithSh = s -> s.endsWith("sh");

        list.stream().filter(isNameEndsWithSh).forEach(s -> System.out.println(s));

//        list.stream().filter(isNameEndsWithSh).forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
//
//        list.stream().filter(isNameEndsWithSh).forEach((String s) -> {
//            System.out.println(s);
//        });
//
//        list.stream().filter(isNameEndsWithSh).forEach((String s) -> System.out.println(s));
    }
}
