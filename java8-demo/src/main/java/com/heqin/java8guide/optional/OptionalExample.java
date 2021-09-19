package com.heqin.java8guide.optional;

import java.util.Optional;

/**
 * The type Optional demo.
 */
public class OptionalExample {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        //optional = Optional.empty();//返回一个空的Optional实例。 此 Optional 不存在任何值。

        System.out.println(optional.isPresent());// true
        if (optional.isPresent()) {
            System.out.println(optional.get());// "bam"
        }
        System.out.println(optional.orElse("fallback"));// "bam"
        optional.ifPresent((s) -> System.out.println(s.charAt(0))); // "b"
    }
}
