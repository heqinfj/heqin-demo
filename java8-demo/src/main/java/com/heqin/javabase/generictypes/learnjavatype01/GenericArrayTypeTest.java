package com.heqin.javabase.generictypes.learnjavatype01;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;

public class GenericArrayTypeTest {
    public static void main(String[] args) throws NoSuchFieldException {
        //**********************GenericArrayType*********************
        Field tArray = TypeTest.class.getField("tArray");
        System.out.println("数组参数类型1:" + tArray.getGenericType());
        Field ltArray = TypeTest.class.getField("ltArray");
        System.out.println("数组参数类型2:" + ltArray.getGenericType());//数组参数类型2:java.util.List<T>[]
        if (tArray.getGenericType() instanceof GenericArrayType) {
            GenericArrayType arrayType = (GenericArrayType) tArray.getGenericType();
            System.out.println("数组参数类型3:" + arrayType.getGenericComponentType());//数组参数类型3:T
        }
    }
}
