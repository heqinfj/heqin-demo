package com.heqin.java8guide.chapter05;

import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        Comparator<Person> comparator = null;

        //java8 之前写法
//        comparator = new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.firstName.compareTo(o2.firstName);
//            }
//        };
        comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        System.out.println(comparator.compare(p1, p2));// > 0
        System.out.println(comparator.reversed().compare(p1, p2));// < 0
    }
}
