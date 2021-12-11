package com.heqin.javabase.generictypes.learnjavatype01;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class ParameterizedTypeTest {
    public static void main(String[] args) throws NoSuchFieldException {
        //*********************************ParameterizedType**********************************************
        Field list = TypeTest.class.getField("list");
        Type genericType1 = list.getGenericType();
        System.out.println("参数类型1:" + genericType1.getTypeName()); //参数类型1:java.util.List<T>

        Field map = TypeTest.class.getField("map");
        Type genericType2 = map.getGenericType();
        System.out.println("参数类型2:" + genericType2.getTypeName());//参数类型2:java.util.Map<java.lang.String, T>

        if (genericType2 instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) genericType2;
            Type[] types = pType.getActualTypeArguments();
            System.out.println("参数类型列表:" + Arrays.asList(types));//参数类型列表:[class java.lang.String, T]
            System.out.println("参数原始类型:" + pType.getRawType());//参数原始类型:interface java.util.Map
            System.out.println("参数父类类型:" + pType.getOwnerType());//参数父类类型:null,因为Map没有外部类，所以为null
        }
    }
}
