package com.heqin.java8guide.chapter05.predicate;

import java.util.function.Predicate;

public class PredicateIsEqualDemo {
    public static void main(String[] args) {
        System.out.println("---Testing Hello message---");
        Predicate<String> isHelloMsg = Predicate.isEqual("Hello");
        System.out.println(isHelloMsg.test("Hello")); //true
        System.out.println(isHelloMsg.test("Hi"));  //false

        System.out.println("---Testing Mahabharat book---");
        Book mahabharatBook = new Book("Mahabharat", "Vyas");
        Predicate<Book> isMahabharatBook = Predicate.isEqual(mahabharatBook);
        System.out.println(isMahabharatBook.test(new Book("Mahabharat", "Vyas"))); //true
        System.out.println(isMahabharatBook.test(new Book("Ramayan", "Valmiki"))); //false
    }
}
