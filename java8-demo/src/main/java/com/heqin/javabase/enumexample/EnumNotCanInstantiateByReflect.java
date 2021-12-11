package com.heqin.javabase.enumexample;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * 验证枚举类不能通过反射进行实例化
 *
 * @Author heqin
 * @Date 2021/10/4 22:19
 */
public class EnumNotCanInstantiateByReflect {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SingletonByEnum instance = SingletonByEnum.INSTANCE;

        Constructor<?>[] declaredConstructors = SingletonByEnum.class.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));
        Constructor<SingletonByEnum> declaredConstructor = SingletonByEnum.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        System.out.println(declaredConstructor);
        SingletonByEnum singleton = declaredConstructor.newInstance("abc", 1);
        System.out.println(instance);
        System.out.println(singleton);
        System.out.println(instance == singleton);
    }
}
