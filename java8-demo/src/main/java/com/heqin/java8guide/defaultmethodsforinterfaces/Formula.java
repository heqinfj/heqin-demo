package com.heqin.java8guide.defaultmethodsforinterfaces;

/**
 * 定义一个公式接口
 */
public interface Formula {
    // 计算
    double calculate(int a);

    // 求平方根
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
