package com.heqin.java8tutorials.javautilfunction.javaconsumerexample;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerLambda1 {
    public static void main(String[] args) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();

        Consumer<Integer> storeNumber = n -> {
            if (n % 2 == 0) {
                evenList.add(n);
            } else {
                oddList.add(n);
            }
        };

        Consumer<List<Integer>> printList = null;
//        printList = new Consumer<List<Integer>>() {
//            @Override
//            public void accept(List<Integer> integers) {
//                for(Integer n : integers){
//                    System.out.println(n);
//                }
//            }
//        };
//        //lambda写法
        printList = list -> list.forEach(n -> System.out.println(n));

        storeNumber.accept(10);
        storeNumber.accept(15);
        storeNumber.accept(25);
        storeNumber.accept(30);

        System.out.println("--- Odd number ---");

        printList.accept(oddList);

        System.out.println("--- Even number ---");

        printList.accept(evenList);
    }

}
