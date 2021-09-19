package com.heqin.java8tutorials.javautilfunction.javapredicateexample;

import java.util.function.Function;

public class Student {
    private String name;
    private int age;
    private String gender;
    private int marks;

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student(String name, int age, String gender, int marks) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getMarks() {
        return marks;
    }

    public String customShow(Function<Student, String> fun) {
        return fun.apply(this);
    }

    public String toString() {
        return name + " - " + age + " - " + gender + " - " + marks;
    }
}