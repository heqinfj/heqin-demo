package com.heqin.javatype;

import java.lang.reflect.Field;

public class ClassTest {
    public static void main(String[] args) throws NoSuchFieldException {
        //**********************************Class*********************************
        Field tClass = TypeTest.class.getField("testClass");
        System.out.println("Class1:" + tClass.getGenericType());//获取泛型类型，由于我们这个属性声明时候没有使用泛型，所以会获得原始类型
        System.out.println("Class1的Class对象:" + tClass.getGenericType().getClass());
        Field tClass2 = TypeTest.class.getField("testClass2");
        System.out.println("Class2:" + tClass2.getGenericType());//获取泛型类型
        System.out.println("Class2的Class对象:" + tClass2.getGenericType().getClass());
    }
}
