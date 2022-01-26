package com.heqin.javabase.generictypes.heqinsummary;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author heqin
 * @Date 2021/12/14 8:25
 */
public class JavaTypeTest<T> {

    //字段
    private JavaTypeTest<Integer> javaTypeTest;

    private T t;

    private String str;

    private int age;

    private T[] etArray;

    private List<T>[] eListArray;

    private UserBean userBean;

    //泛型方法 这里的T与泛型类上的T不是同一个
    public <T> void testType(T t, Map.Entry<String, T> mapEntry, T[] array, List<?> a1, List<? extends T> a2, List<? super Integer> a3) {
    }


    /**
     * 测试字段上的类型信息
     */
    @Test
    public void testField() {
        Field[] declaredFields = JavaTypeTest.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("字段名：" + declaredField.getName());
            JavaTypeUtils.checkJavaType(declaredField.getGenericType());
            System.out.println("------------------------------------------");
        }
    }

    /**
     * 测试类上的类型参数
     */
    @Test
    public void testClass() {
        TypeVariable<Class<JavaTypeTest>>[] typeParameters = JavaTypeTest.class.getTypeParameters();
        for (TypeVariable<Class<JavaTypeTest>> typeVariable : typeParameters) {
            JavaTypeUtils.checkJavaType(typeVariable);
        }
    }

    /**
     * 测试方法的参数类型
     */
    @Test
    public void testMethod() {
        Method[] declaredMethods = JavaTypeTest.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Test annotation = declaredMethod.getAnnotation(Test.class);
            if (annotation != null) {
                continue;
            }
            System.out.println(declaredMethod);
            Type[] genericParameterTypes = declaredMethod.getGenericParameterTypes();
            for (Type genericParameterType : genericParameterTypes) {
                JavaTypeUtils.checkJavaType(genericParameterType);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            System.out.println("------------------------------------------");
        }
    }

    @Test
    public void testxx() throws NoSuchFieldException {
        System.out.println(JavaTypeUtils.getTypeInfo(Runnable.class));
        Field userBean = JavaTypeTest.class.getDeclaredField("userBean");
        JavaTypeUtils.checkJavaType(userBean.getGenericType());

        UserBean ub = new UserBean();
        System.out.println(ub);
    }
}
