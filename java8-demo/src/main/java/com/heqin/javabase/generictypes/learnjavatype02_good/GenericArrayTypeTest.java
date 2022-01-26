package com.heqin.javabase.generictypes.learnjavatype02_good;

import org.junit.Test;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/**
 * GenericArrayType 泛型数组类型
 *
 * @Author heqin
 * @Date 2021/12/11 17:45
 */
public class GenericArrayTypeTest {

    @Test
    public void testGenericArrayType() throws NoSuchMethodException {
        Method method = GenericArrayTypeTest.class.getMethod("testType", Object[].class, String[].class, List.class);
        Type[] types = method.getGenericParameterTypes(); //返回按声明顺序表示底层可执行文件的形参类型的Type数组
        for (Type type : types) {
            System.out.println(TypeInfoUtils.getTypeInfo(type));
            if (type instanceof GenericArrayType) {
                GenericArrayType genericArrayType = (GenericArrayType) type;
                System.out.println("    " + TypeInfoUtils.getTypeInfo(genericArrayType.getGenericComponentType()));//返回表示此数组的组件类型的Type对象
            }
        }
    }

    // 只有第一个参数是【泛型数组】类型
    public <T> T testType(T[] a1, String[] a2, List<T> a3) {
        return null;
    }

}
