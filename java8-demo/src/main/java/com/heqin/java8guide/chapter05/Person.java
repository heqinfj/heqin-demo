package com.heqin.java8guide.chapter05;

public class Person {
    String firstName;
    String lastName;

    Person() {
        //System.out.println("无参构造函数。。。");
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("有参构造函数。。。");
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
