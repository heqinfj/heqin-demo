package com.heqin.javabase.innerclass.staticnestedclass;

/**
 * 静态内部类（Static Nested Class）
 *
 * 用static修饰的内部类和Inner Class有很大的不同，它不再依附于Outer的实例，而是一个完全独立的类，因此无法引用Outer.this，
 * 但它可以访问Outer的private静态字段和静态方法。如果把StaticNested移到Outer之外，就失去了访问private的权限。
 *
 * @Author heqin
 * @Date 2021/10/1 1:04
 */
class Outer {
    private static String NAME = "OUTER";

    private String name;

    public Outer(String name) {
        this.name = name;
    }

    static class StaticNested {
        void hello() {
            //System.out.println("Hello, " + Outer.this.name);//编译出错：'com.heqin.javabase.innerclass.staticnestedclass.Outer.this' cannot be referenced from a static context
            //'com.heqin.javabase.innerclass.staticnestedclass.Outer.this'不能从静态上下文中引用。
            System.out.println("Hello, " + Outer.NAME);
        }
    }
}
