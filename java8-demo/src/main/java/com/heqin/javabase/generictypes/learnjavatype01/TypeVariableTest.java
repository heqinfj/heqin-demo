package com.heqin.javabase.generictypes.learnjavatype01;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class TypeVariableTest {
    public static void main(String[] args) throws NoSuchFieldException {
        //****************************TypeVariable************************
        Field v = TypeTest.class.getField("v");//用反射的方式获取属性 public V v;
        TypeVariable typeVariable = (TypeVariable) v.getGenericType();//获取属性类型
        System.out.println("TypeVariable1:" + typeVariable);
        System.out.println("TypeVariable2:" + Arrays.asList(typeVariable.getBounds()));//获取类型变量上界
        System.out.println("TypeVariable3:" + typeVariable.getGenericDeclaration());//获取类型变量声明载体
        //1.8 AnnotatedType: 如果这个这个泛型参数类型的上界用注解标记了，我们可以通过它拿到相应的注解
        AnnotatedType[] annotatedTypes = typeVariable.getAnnotatedBounds();
        System.out.println("TypeVariable4:" + Arrays.asList(annotatedTypes) + " : " +
                Arrays.asList(annotatedTypes[0].getAnnotations()));//通过annotatedTypes[0].getAnnotations()[0]获取到了类型参数V的上界Number 上的注解Custom(),这里需要重点理解一下。
        System.out.println("TypeVariable5:" + typeVariable.getName());

        //补充
        Annotation annotation = annotatedTypes[0].getAnnotations()[0];
        System.out.println(annotation.toString());
    }
}
/*
TypeVariable1:V
TypeVariable2:[class java.lang.Number, interface java.io.Serializable]
TypeVariable3:class com.heqin.javabase.generictypes.javatype.TypeTest
TypeVariable4:[sun.reflect.annotation.AnnotatedTypeFactory$AnnotatedTypeBaseImpl@63947c6b, sun.reflect.annotation.AnnotatedTypeFactory$AnnotatedTypeBaseImpl@2b193f2d] : [@com.heqin.javabase.generictypes.javatype.Custom()]
TypeVariable5:V
 */
