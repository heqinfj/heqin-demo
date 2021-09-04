package com.heqin.java8guide.chapter05;

import java.util.function.Supplier;

public class SuppliersDemo {
    public static void main(String[] args) {
        SuppliersDemo suppliersDemo = new SuppliersDemo();
        suppliersDemo.work();
    }

    private void work() {
        Supplier<Person> personSupplier = null;
//        personSupplier = new Supplier<Person>() {
//            @Override
//            public Person get() {
//                return new Person("xiao","mi");
//            }
//        };
        personSupplier = Person::new; // 这个怎么能像上面那样 能直接指定有参的构造函数？
        System.out.println(personSupplier.get());
    }
}
