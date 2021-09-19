package com.heqin.java8tutorials.javautilfunction.javaconsumerexample;

import java.util.function.Consumer;

public class ConsumerLambda2 {
    public static void main(String[] args) {
        Consumer<Citizen> electionConsumer = c -> {
            if (c.getAge() < 18) {
                System.out.println(c.getName() + " is not eligible to vote.");
            } else {
                System.out.println(c.getName() + " can vote.");
            }
        };

        electionConsumer.accept(new Citizen("Ritesh", 15));

        electionConsumer.accept(new Citizen("Shreya", 20));
    }
}
