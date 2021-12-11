package com.heqin.javabase.generictypes.learn02;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @Author heqin
 * @Date 2021/11/18 18:05
 */
public abstract class BaseDao<T> {
    public BaseDao() {
        Class clazz = getClass();
        System.out.println("class name: " + clazz.getName());
        Type genericSuperclass = clazz.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = pt.getActualTypeArguments();
            Arrays.stream(actualTypeArguments).forEach(actualTypeArgument -> System.out.println(actualTypeArgument.getTypeName()));
        }
    }
}
