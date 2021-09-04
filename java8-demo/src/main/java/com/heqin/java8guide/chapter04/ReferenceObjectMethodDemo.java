package com.heqin.java8guide.chapter04;

import com.heqin.java8guide.chapter03_functionalinterface.Converter;

public class ReferenceObjectMethodDemo {
    public static void main(String[] args) {
        ReferenceObjectMethodDemo referenceObjectMethodDemo = new ReferenceObjectMethodDemo();
        referenceObjectMethodDemo.work();
    }

    void work() {
        Something something = new Something();
        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("Java");
        System.out.println(converted);
    }

    class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }
}


