package com.heqin.javabase.generictypes.learnjavatype01;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class ClassTest {
    public static void main(String[] args) throws NoSuchFieldException {
        //**********************************Class*********************************
        Field tClass = TypeTest.class.getField("testClass");
        System.out.println("Class1:" + tClass.getGenericType());//获取泛型类型，由于我们这个属性声明时候没有使用泛型，所以会获得原始类型
        System.out.println("Class1的Class对象:" + tClass.getGenericType().getClass());
        Field tClass2 = TypeTest.class.getField("testClass2");
        System.out.println("Class2:" + tClass2.getGenericType());//获取泛型类型
        System.out.println("Class2的Class对象:" + tClass2.getGenericType().getClass());
        Type genericType = tClass2.getGenericType();
        if(genericType instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType)genericType;
            System.out.println(Arrays.toString(pt.getActualTypeArguments()));
            System.out.println(pt.getRawType());
        }
    }
}
