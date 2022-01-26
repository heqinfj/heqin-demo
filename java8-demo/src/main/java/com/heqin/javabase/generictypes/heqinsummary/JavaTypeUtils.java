package com.heqin.javabase.generictypes.heqinsummary;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/**
 * @Author heqin
 * @Date 2021/12/14 11:31
 */
public class JavaTypeUtils {

    public static void checkJavaType(Type type) {
        System.out.println("类型名称：" + type.getTypeName());
        System.out.println("当前type对象的运行时类的Class对象：" + type.getClass());
        if (type instanceof GenericArrayType) {
            System.out.println("是范型数组类型（GenericArrayType）。");
            GenericArrayType genericArrayType = (GenericArrayType) type;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            System.out.println("此数组的组件类型的Type对象：");
            System.out.println(getTypeInfo(genericComponentType));
            //checkJavaType(genericComponentType);
        } else if (type instanceof ParameterizedType) {
            System.out.println("是参数化类型（ParameterizedType）。");
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length > 0) {
                System.out.println("实际类型参数如下：");
            }
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(getTypeInfo(actualTypeArgument));
            }
            Type ownerType = parameterizedType.getOwnerType();
            System.out.println("ownerType: " + ownerType);
            Type rawType = parameterizedType.getRawType();
            System.out.println("rawType(原始类型): " + rawType);
        } else if (type instanceof TypeVariable) {
            System.out.println("是类型变量类型（TypeVariable）。");
            TypeVariable<?> typeVariable = (TypeVariable<?>) type;
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length > 0) {
                System.out.println("当前类型变量上限的Type数组：");
            }
            for (Type bound : bounds) {
                System.out.println("    " + getTypeInfo(bound));
            }

        } else if (type instanceof WildcardType) {
            System.out.println("是通配符类型（WildcardType）。");
        } else if (type instanceof Class) {
            System.out.println("是类类型（Class）。");
        } else {
            System.out.println("其他。。。");
        }
    }

    public static String getTypeInfo(Type type) {
        String typeName = type.getTypeName();//返回：描述此类型的字符串
        Class<?> clazz = type.getClass();//返回：表示此对象的运行时类的Class对象。
        //clazz.toString();
        Class<?>[] interfaces = clazz.getInterfaces();
        StringBuilder typeInterface = new StringBuilder();
        int i = 1;
        for (Class<?> clazzType : interfaces) {
            typeInterface.append(clazzType.getSimpleName());
            if (i++ < interfaces.length) {
                typeInterface.append(",");
            }
        }
        return "【类型名称：" + typeName + "】 【运行时类的Class对象：" + clazz + "】 【运行时类的Class对象的直接实现的接口数组：" + typeInterface + "】";
    }

}
