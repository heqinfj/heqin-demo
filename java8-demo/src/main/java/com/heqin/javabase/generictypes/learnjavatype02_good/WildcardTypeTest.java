package com.heqin.javabase.generictypes.learnjavatype02_good;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * WildcardType
 * 通配符类型
 *
 * @Author heqin
 * @Date 2021/12/11 17:55
 */
public class WildcardTypeTest {

    @Test
    public void testWildcardType() throws NoSuchMethodException {
        Method method = WildcardTypeTest.class.getMethod("testType", List.class, List.class, List.class, List.class);
        Type[] types = method.getGenericParameterTypes(); //按照方法参数声明顺序返回参数的 Type 数组
        for (Type type : types) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments(); //返回表示此类型【实际类型参数】的 Type 数组
            if (actualTypeArguments[0] instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) actualTypeArguments[0];
                System.out.println("是通配符类型" + TypeInfoUtils.getTypeInfo(wildcardType));
                for (Type upperType : wildcardType.getUpperBounds()) {
                    System.out.println("  upperType" + TypeInfoUtils.getTypeInfo(upperType));
                }
                for (Type lowerType : wildcardType.getLowerBounds()) {
                    System.out.println("  lowerType" + TypeInfoUtils.getTypeInfo(lowerType));
                }
            } else {
                System.out.println("非通配符类型" + TypeInfoUtils.getTypeInfo(actualTypeArguments[0]));
            }
        }
    }

    public <T> void testType(List<T> a1, List<?> a2, List<? extends T> a3, List<? super Integer> a4) {
    }
}
