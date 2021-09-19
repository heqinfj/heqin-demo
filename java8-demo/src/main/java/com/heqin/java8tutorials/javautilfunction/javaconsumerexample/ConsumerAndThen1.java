package com.heqin.java8tutorials.javautilfunction.javaconsumerexample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerAndThen1 {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(3, 4, 5, 6);

        Consumer<List<Integer>> squareConsumer = new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> list) {
                for (int i = 0; i < list.size(); i++) {
                    list.set(i, list.get(i) * list.get(i));
                }
            }
        };

        Consumer<List<Integer>> printConsumer = list -> list.forEach(n -> System.out.println(n));

        squareConsumer.andThen(printConsumer).accept(numList);
    }
}
