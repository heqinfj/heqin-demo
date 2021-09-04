package com.heqin.java8guide.chapter05;

import com.heqin.java8guide.chapter03_functionalinterface.Converter;

public class LambdaScopedDemo {
    public static void main(String[] args) {
        LambdaScopedDemo lambdaScopedDemo = new LambdaScopedDemo();
        lambdaScopedDemo.testAceessLocalVariables();

        Lambda4 lambda4 = new Lambda4();
        lambda4.testScopes();
    }

    /**
     * 访问局部变量
     */
    private void testAceessLocalVariables(){
        int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
        System.out.println(stringConverter.convert(2));
    }
}
