package com.heqin.javabase.generictypes.learnjavatype02_good;

import org.junit.Test;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/12/11 16:24
 */
public class TypeVariableTest{

    @Test
    public void testTypeVariable() throws NoSuchMethodException {
        Method method = TypeVariableTest.class.getMethod("test",Object.class);
        TypeVariable<?>[] typeVariables = method.getTypeParameters(); //返回泛型声明的 TypeVariable 数组

        for (int i = 0; i < typeVariables.length; i++) {
            TypeVariable<?> typeVariable = typeVariables[i];
            Type[] bounds = typeVariable.getBounds();
            GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration(); //public void com.heqin.javabase.generictypes.learnjavatype02_good.TypeVariableTest.testType()
            boolean isSameObj = genericDeclaration.getTypeParameters()[i] == typeVariable; // true，是同一个对象

            System.out.println(TypeInfoUtils.getTypeInfo(typeVariable));
            for (Type type : bounds) {
                System.out.println("    " + TypeInfoUtils.getTypeInfo(type));
            }
        }
    }

    public <T extends List<String>, U extends Integer, Int> void testType() {
    }

    public <E> void test(E e){

    }
}
