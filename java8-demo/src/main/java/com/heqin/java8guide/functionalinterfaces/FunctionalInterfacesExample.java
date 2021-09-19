package com.heqin.java8guide.functionalinterfaces;

import org.junit.Test;

/**
 * @Author heqin
 * @Date 2021/9/15 0:24
 */
public class FunctionalInterfacesExample {

    @Test
    public void convert(){
        Converter<String, Integer> converter = null;
        //java8之前的写法 匿名内部类
//        converter = new Converter<String, Integer>() {
//            @Override
//            public Integer convert(String from) {
//                return Integer.valueOf(from);
//            }
//        };

        converter = (from) -> {
            return Integer.valueOf(from);
        };

        //对于一行方法体，您可以跳过大括号 {} 和 return 关键字
//        converter = (from) -> Integer.valueOf(from);

        Integer converted = converter.convert("123");
        System.out.println(converted);
    }

    @Test
    public void greet(){
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
