package com.heqin.yourbatman;

/**
 * @author heqin
 */
public class User {

    private String name;

    private int age;

    public User() {
        System.out.println("instance " + this.name);
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("instance " + this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
