package com.heqin.javabase.generictypes.learnjavatype02_good;

import org.junit.Test;

/**
 * @Author heqin
 * @Date 2021/12/11 15:18
 */
public class ClassGetClassMethodTest {

    /**
     * getClass() - 返回此Object的运行时类。 | 返回表示此对象的运行时类的Class对象。
     */
    @Test
    public void testGetClass() {
        String str = "abc";
        Class<? extends String> strClass = str.getClass();
        System.out.println(strClass);//String对象的运行时类为：class java.lang.String
        Class<? extends Class> strClassClass = strClass.getClass();
        System.out.println(strClassClass);//class java.lang.String对象的运行时类为：class java.lang.Class
        System.out.println(strClassClass.getClass());//class java.lang.Class对象的运行时类为：class java.lang.Class -- 后续都是这样
        System.out.println("-------------------------------------");
        Number n = 0;
        Class<? extends Number> c = n.getClass();
        System.out.println(c);//Integer对象的运行时类为：class java.lang.Integer
        Class<? extends Class> cClass = c.getClass();
        System.out.println(cClass);//class java.lang.Integer对象的运行时类为：class java.lang.Class
        System.out.println(cClass.getClass());//class java.lang.Class对象的运行时类为：class java.lang.Class -- 后续都是这样

    }
}
