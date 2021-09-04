package com.heqin.java8guide.chapter05;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        ConsumerDemo consumerDemo = new ConsumerDemo();
        consumerDemo.work();
    }

    private void work(){
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));
    }
}
