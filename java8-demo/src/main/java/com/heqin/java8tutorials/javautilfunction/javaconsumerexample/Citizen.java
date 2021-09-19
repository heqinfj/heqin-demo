package com.heqin.java8tutorials.javautilfunction.javaconsumerexample;

class Citizen {
    private String name;
    private int age;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}