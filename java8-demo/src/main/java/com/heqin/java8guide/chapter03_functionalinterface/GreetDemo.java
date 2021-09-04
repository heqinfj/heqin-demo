package com.heqin.java8guide.chapter03_functionalinterface;

public class GreetDemo {
    public static void main(String[] args) {
        Greet greet = null;
//        greet = new Greet() {
//            @Override
//            public void say(Object content) {
//                System.out.println(String.format("欢迎您，%s!",content));
//            }
//        };
        greet = (content) -> System.out.println(String.format("欢迎您，%s!",content));
        greet.say("Tom");
        greet.say("Kate");
    }
}
