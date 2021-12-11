package com.heqin.javabase.generictypes.learn03;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/11/19 17:36
 */
public class Test01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> stringList = new ArrayList<String>();
        stringList.add("abc");
        //stringList.add(1);//error

        Class<? extends List> aClass = stringList.getClass();
        Method addMethod = aClass.getMethod("add", Object.class);
        addMethod.setAccessible(true);
        addMethod.invoke(stringList,1);
        System.out.println(stringList.size());
        stringList.forEach(obj -> System.out.println(obj));
    }
}
