package com.heqin.javabase.generictypes.learnjavatype02_good;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @Author heqin
 * @Date 2021/12/11 8:06
 */
public class ParameterizedTypeTest {

    public static void main(String[] args) throws NoSuchMethodException {
        Method testType = ParameterizedTypeTest.class.getMethod("testType", Map.Entry.class,(new Object[]{}).getClass());
        Type[] parameterTypes = testType.getGenericParameterTypes();
        for(Type parameterType : parameterTypes){
            if(parameterType instanceof ParameterizedType){
                System.out.println("ParameterizedType类型：");
                System.out.println("" + TypeInfoUtils.getTypeInfo(parameterType));
                ParameterizedType parameterizedType = (ParameterizedType)parameterType;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                System.out.println("测试方法getActualTypeArguments：");
                for(Type typeArgument : actualTypeArguments){
                    System.out.println("    " + TypeInfoUtils.getTypeInfo(typeArgument));
                }
                Type ownerType = parameterizedType.getOwnerType();
                System.out.println("测试方法getOwnerType: ");
                System.out.println("    " + TypeInfoUtils.getTypeInfo(ownerType));
                Type rawType = parameterizedType.getRawType();
                System.out.println("测试方法getRawType: ");
                System.out.println("    " + TypeInfoUtils.getTypeInfo(rawType));
            }else if(parameterType instanceof GenericArrayType){
                System.out.println("GenericArrayType类型：");
                System.out.println("" + TypeInfoUtils.getTypeInfo(parameterType));
            }else{
                System.out.println("非ParameterizedType类型：");
                System.out.println("" + TypeInfoUtils.getTypeInfo(parameterType));
            }
        }

    }


    public <T> void testType(Map.Entry<String, T> mapEntry,T[] array) {
    }
}
