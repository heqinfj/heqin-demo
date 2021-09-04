package com.heqin.java8guide.chapter02_lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println(names);

        //java8之前的写法
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return b.compareTo(a);
//            }
//        });

        //演进1
//        Collections.sort(names,(String a,String b) -> {
//            return a.compareTo(b);
//        });

        //演进2 对于一行方法体，您可以跳过大括号 {} 和 return 关键字
//        Collections.sort(names,(String a,String b) -> a.compareTo(b));

        //演进3
//        names.sort((a,b) -> a.compareTo(b));

        //演进4
        names.sort(Comparator.naturalOrder());

        System.out.println(names);
    }
}
