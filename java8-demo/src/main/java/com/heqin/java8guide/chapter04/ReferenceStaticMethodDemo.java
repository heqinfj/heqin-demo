package com.heqin.java8guide.chapter04;

import com.heqin.java8guide.chapter03_functionalinterface.Converter;

public class ReferenceStaticMethodDemo {
    public static void main(String[] args) {
        Converter<String, Integer> converter = null;

        //匿名内部类写法
//        converter = new Converter<String, Integer>() {
//            @Override
//            public Integer convert(String from) {
//                return Integer.valueOf(from);
//            }
//        };

        //lambda 1
//        converter = (from) -> Integer.valueOf(from);

        //lambda 2
        //进一步简化 Java 8 允许您通过::关键字传递方法或构造函数的引用
        converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);
    }


}
