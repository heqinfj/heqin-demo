package com.heqin.java8guide.chapter05.consumer;

import java.util.function.Consumer;

public class ConsumerAccept {
    public static void main(String[] args) {
        Consumer<String> nameConsumer = s -> System.out.println(s);

        nameConsumer.accept("Mahesh");
        nameConsumer.accept("Krishna");
    }
}
