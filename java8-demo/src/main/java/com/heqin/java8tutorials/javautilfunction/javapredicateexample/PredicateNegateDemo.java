package com.heqin.java8tutorials.javautilfunction.javapredicateexample;

import java.util.function.Predicate;

public class PredicateNegateDemo {
    public static void main(String[] args) {
        Predicate<Integer> isNumberMatched = n -> n > 10 && n < 20;
        //With negate()
        Boolean result = isNumberMatched.negate().test(15);
        System.out.println(result); //false

        //Without negate()
        result = isNumberMatched.test(15);
        System.out.println(result); //true

        Predicate<String> isValidName = s -> s.length() > 5 && s.length() < 15;
        System.out.println(isValidName.negate().test("Krishna")); //false

        Predicate<Integer> isLessThan50 = n -> n < 50;
        System.out.println(isLessThan50.negate().test(60)); //true

        Predicate<Integer> isGreaterThan20 = n -> n > 20;
        System.out.println(isGreaterThan20.negate().test(30));  //false

        result = isLessThan50.and(isGreaterThan20).negate().test(25);
        System.out.println(result); //false
    }
}
