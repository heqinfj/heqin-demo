package com.heqin.javabase;

import com.heqin.javabase.generictypes.learnjavatype02_good.TypeInfoUtils;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/12/11 19:14
 */
public class MethodApiExample {
    public <T> void test(String a, int b, List<T> list) {

    }

    @Test
    public void testGetGenericParameterTypes() throws NoSuchMethodException {
        Method method = MethodApiExample.class.getMethod("test", String.class, int.class,List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type type : genericParameterTypes) {
            System.out.println(TypeInfoUtils.getTypeInfo(type));
            if(type instanceof Class){
                Class clazz = (Class)type;
                System.out.println(String.format("是否原始类型：%s",clazz.isPrimitive()));
            }
        }
    }
}
