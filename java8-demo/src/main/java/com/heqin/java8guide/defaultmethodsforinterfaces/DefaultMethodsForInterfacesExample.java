package com.heqin.java8guide.defaultmethodsforinterfaces;

import org.junit.Test;

/**
 * @Author heqin
 * @Date 2021/9/15 0:20
 */
public class DefaultMethodsForInterfacesExample {

    /**
     * Java 8 enables us to add non-abstract method implementations to interfaces by utilizing the default keyword.
     * This feature is also known as virtual extension methods.
     *
     * Java 8使我们能够通过使用 default 关键字向接口添加非抽象方法实现。 此功能也称为虚拟扩展方法。
     */
    @Test
    public void virtualExtensionMethods(){
        Formula formula = null;
//java8 之前写法
//        formula = new Formula() {
//            @Override
//            public double calculate(int a) {
//                return sqrt(a * 100);
//            }
//        };

        //演进1
        //formula = (a) -> {return a * 100;};
        //演进2
        formula = (a) -> a * 100;

        //编译不通过 Cannot resolve method 'sqrt' in 'FormulaDemo'
        //带有默认实现的接口方法，是不能在 lambda 表达式中访问的，上面这段代码将无法被编译通过。
        //formula = (a) -> sqrt(a * 100);

        double a = formula.calculate(100);
        System.out.println(a);
        System.out.println(formula.sqrt(16));
    }
}
