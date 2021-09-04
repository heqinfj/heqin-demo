package com.heqin.java8guide.chapter03_functionalinterface;

public class ConverterDemo {
    public static void main(String[] args) {
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
}
