package com.heqin.javabase.generictypes.learnjavatype03;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/12/14 8:25
 */
public class TypeTest<T> {

    private TypeTest<T> typeTest;

    private TypeTest<Integer> test;

    private T item;

    private String str;

    private int age;

    private T[] etArray;

    private List<T>[] eListArray;


    @Test
    public void testField(){
        Field[] declaredFields = TypeTest.class.getDeclaredFields();
        for(Field declaredField : declaredFields){
            System.out.println("字段名：" + declaredField.getName());
            System.out.println("判断Type：");
            checkType(declaredField.getGenericType());
            System.out.println("--------------------------------------");
        }
    }


    private static void checkType(Type type) {
        if (type instanceof GenericArrayType) {
            System.out.println("是范型数组类型（GenericArrayType）。");
        } else if (type instanceof ParameterizedType) {
            System.out.println("是参数化类型（ParameterizedType）。");
        } else if (type instanceof TypeVariable) {
            System.out.println("是类型变量类型（TypeVariable）。");
        } else if (type instanceof WildcardType) {
            System.out.println("是通配符类型（WildcardType）。");
        } else if (type instanceof Class) {
            System.out.println("是类类型（Class）。");
        } else {
            System.out.println("其他。。。");
        }
        System.out.println("类型名称：" + type.getTypeName());
        System.out.println("此type对象的运行时类的Class对象：" + type.getClass());
    }
}
