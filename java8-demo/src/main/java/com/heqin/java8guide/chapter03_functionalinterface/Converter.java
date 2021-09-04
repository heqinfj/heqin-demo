package com.heqin.java8guide.chapter03_functionalinterface;

//所谓函数式接口（Functional Interface）就是只包含一个抽象方法的声明。针对该接口类型的所有 Lambda 表达式都会与这个抽象方法匹配。

/**
 * 转换器
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);

}
