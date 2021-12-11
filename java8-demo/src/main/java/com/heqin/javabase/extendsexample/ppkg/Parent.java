package com.heqin.javabase.extendsexample.ppkg;

/**
 * @Author heqin
 * @Date 2021/10/14 20:18
 */
public abstract class Parent {

    protected String name = "老李";

    public Parent() {
        System.out.println("Parent()");
        say();
    }

    public Parent(String name) {
        this.name = name;
        System.out.println("Parent(String name)");
        say();
    }

    abstract public void say();
}
