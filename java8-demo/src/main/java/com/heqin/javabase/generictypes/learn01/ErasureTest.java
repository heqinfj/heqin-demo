package com.heqin.javabase.generictypes.learn01;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author heqin
 * @Date 2021/11/18 17:21
 */
public class ErasureTest {

    /**
     * Erasure 是一个泛型类，我们查看它在运行时的状态信息可以通过反射。
     */
    @Test
    public void testGenericStatusInfo(){
        Erasure<String> erasure = new Erasure<>("abc");
        Class<? extends Erasure> erasureClass = erasure.getClass();
        System.out.println(erasureClass.getName());
    }

    /**
     * 看看泛型类中 T 的类型在 jvm 中是什么具体类型。
     */
    @Test
    public void testTType() {
        Erasure<String> erasure = new Erasure<>("abc");
        Class<? extends Erasure> erasureClass = erasure.getClass();
        System.out.println("Erasure class name: " + erasureClass.getName());
        Field[] declaredFields = erasureClass.getDeclaredFields();
        System.out.println("Field Information: ");
        Arrays.stream(declaredFields).forEach(declaredField -> System.out.println(String.format("field name: %s,field type: %s,field declaringClass: %s,field info: %s",
                declaredField.getName(), declaredField.getType().getName(),declaredField.getDeclaringClass(), declaredField.toString())));
        System.out.println("Method Information: ");
        Method[] declaredMethods = erasureClass.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(declaredMethod -> System.out.println(String.format("method info: %s",
                declaredMethod.toString())));
    }

    @Test
    public void testTType2() {
        ErasureSpecifyUpper<String> erasure = new ErasureSpecifyUpper<>("abc");
        //String abc = erasure.testMethod1("abc");
        //System.out.println(abc);
        Class<? extends ErasureSpecifyUpper> erasureClass = erasure.getClass();
        System.out.println("ErasureSpecifyUpper class name: " + erasureClass.getName());
        Field[] declaredFields = erasureClass.getDeclaredFields();
        System.out.println("Field Information: ");
        Arrays.stream(declaredFields).forEach(declaredField -> System.out.println(String.format("field name: %s,field type: %s,field declaringClass: %s,field info: %s",
                declaredField.getName(), declaredField.getType().getName(),declaredField.getDeclaringClass(), declaredField.toString())));
        System.out.println("Method Information: ");
        Method[] declaredMethods = erasureClass.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(declaredMethod -> System.out.println(String.format("method info: %s",
                declaredMethod.toString())));
    }
}
