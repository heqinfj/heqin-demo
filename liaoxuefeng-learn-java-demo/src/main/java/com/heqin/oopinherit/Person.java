package com.heqin.oopinherit;

public class Person {

    protected String name;

    protected int age;

    private int privateVariable;//TODO: 验证私有变量，在子类（subclass或extended class）是否可以使用super.privateVariable -> 答案：不可以

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
