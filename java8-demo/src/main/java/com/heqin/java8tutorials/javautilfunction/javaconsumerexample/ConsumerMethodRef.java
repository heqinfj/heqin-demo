package com.heqin.java8tutorials.javautilfunction.javaconsumerexample;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ConsumerMethodRef {
    public static void main(String[] args) {
        Map<Integer, String> persons = new HashMap<Integer, String>();
        persons.put(101, "Mahesh");
        persons.put(102, "Krishna");

        Consumer<Map<Integer, String>> updatePersons = Utility::updateData;

        Consumer<Map<Integer, String>> displayPersons = null;

//        displayPersons = new Consumer<Map<Integer, String>>() {
//            @Override
//            public void accept(Map<Integer, String> integerStringMap) {
//                Utility.displayData(integerStringMap);
//            }
//        };

        displayPersons = Utility::displayData;

        updatePersons.accept(persons);

        displayPersons.accept(persons);
    }
}

class Utility {
    static void updateData(Map<Integer, String> persons) {
        persons.replaceAll((k, v) -> "Shree ".concat(v));
    }

    static void displayData(Map<Integer, String> persons) {
        for (Map.Entry<Integer, String> entry : persons.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}

