package com.heqin.java8guide.chapter05;

import java.util.function.Function;

public class FunctionsDemo {
    public static void main(String[] args) {
        Function<String,Integer> toInteger = Integer::valueOf;
        //Function<String, String> backToString = toInteger.andThen(String::valueOf);
        Function<String, String> backToString = toInteger.andThen(new Function(){

            @Override
            public Object apply(Object o) {
                return String.valueOf(o) + ",测试。。。";
            }
        });
        System.out.println(backToString.apply("123"));
    }
}
