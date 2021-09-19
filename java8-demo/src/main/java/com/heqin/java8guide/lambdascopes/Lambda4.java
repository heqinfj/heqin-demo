package com.heqin.java8guide.lambdascopes;

import com.heqin.java8guide.functionalinterfaces.Converter;

class Lambda4 {
    // 静态变量
    static int outerStaticNum;
    // 成员变量
    int outerNum;

    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            // 对成员变量赋值
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            // 对静态变量赋值
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }
}