package com.heqin.javabase;

//import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Desc 学习 {@link Class}的API
 * @Author heqin
 * @Date 2021/9/17 10:45
 */
public class ClassApiExample {

    /**
     * getSuperclass()的官方说明：
     * Returns the Class representing the superclass of the entity (class, interface, primitive type or void) represented by this Class.
     * If this Class represents either the Object class, an interface, a primitive type, or void, then null is returned.
     * If this object represents an array class then the Class object representing the Object class is returned.
     * Returns:
     * the superclass of the class represented by this object.
     * <p>
     * 返回表示此Class表示的实体（类、接口、原始类型或 void）的超类的Class 。
     * 如果此Class表示任一Object类，接口，一个基本类型，或void，则返回null。
     * 如果此对象表示一个数组类，则返回表示Object类的Class对象。
     * 返回：
     * 此对象表示的类的超类。
     */
    @Test
    public void getSuperclass() {
        //class 输出结果：class com.heqin.javabase.ClassExample$Mammal
        System.out.println(Dog.class.getSuperclass());
        //interface 输出结果：null
        System.out.println(RunCapableBehavior.class.getSuperclass());
        // primitive type   输出结果：null
        System.out.println(int.class.getSuperclass());
        //void  输出结果：null
        System.out.println(void.class.getSuperclass());
    }

    /**
     * @Desc getName()、getCanonicalName()、getSimpleName()、getTypeName()的区别
     * <p>
     * https://stackoverflow.com/questions/15202997/what-is-the-difference-between-canonical-name-simple-name-and-class-name-in-jav/15203417#15203417
     * @Author heqin
     * @Date 2021/9/18 15:32
     */
    @Test
    public void classNameTest() {
        printNamesForClass(
                int.class,
                "int.class (primitive - 基本类型)");
        printNamesForClass(
                String.class,
                "String.class (ordinary class - 普通类)");
        printNamesForClass(
                java.util.HashMap.SimpleEntry.class,
                "java.util.HashMap.SimpleEntry.class (nested class - 嵌套类)");
        printNamesForClass(
                new java.io.Serializable() {
                }.getClass(),
                "new java.io.Serializable(){}.getClass() (anonymous inner class - 匿名内部类)");
        printNamesForClass((new Object[3]).getClass(), "(new Object[3]).getClass() (one dimensional array - 一维数组类)");
        printNamesForClass((new int[3][4][5][6][7][8][9]).getClass(), "new int[3][4][5][6][7][8][9]).getClass() (multi-dimensional array - 多维数组类)");
    }

    private void printNamesForClass(final Class<?> clazz, final String label) {
        System.out.println(label + ":");
        System.out.println("    getName():          " + clazz.getName());
        System.out.println("    getCanonicalName(): " + clazz.getCanonicalName());
        System.out.println("    getSimpleName():    " + clazz.getSimpleName());
        // added in Java 8
        System.out.println("    getTypeName():      " + clazz.getTypeName());
        System.out.println();
    }

    @Test
    public void forName() throws ClassNotFoundException {
        Class<?> clazz = Class.forName(ClassApiExample.class.getName());
        System.out.println(clazz);
    }

    @Test
    public void isMemberClass() {
        printIsMemberClassForClass(
                int.class,
                "int.class (primitive - 基本类型)");
        printIsMemberClassForClass(
                String.class,
                "String.class (ordinary class - 普通类)");
        printIsMemberClassForClass(
                java.util.HashMap.SimpleEntry.class,
                "java.util.HashMap.SimpleEntry.class (nested class - 嵌套类)");
        printIsMemberClassForClass(
                new java.io.Serializable() {
                }.getClass(),
                "new java.io.Serializable(){}.getClass() (anonymous inner class - 匿名内部类)");
        printIsMemberClassForClass((new Object[3]).getClass(), "(new Object[3]).getClass() (one dimensional array - 一维数组类)");
        printIsMemberClassForClass((new int[3][4][5][6][7][8][9]).getClass(), "new int[3][4][5][6][7][8][9]).getClass() (multi-dimensional array - 多维数组类)");
    }

    private void printIsMemberClassForClass(Class<?> clazz, String label) {
        System.out.println("label: " + label);
        System.out.println(" isMemberClass(): " + clazz.isMemberClass());
    }

    /**
     * getDeclaredMethods与getMethods的区别
     */
    @Test
    public void getDeclaredMethodsAndGetMethods() {
        printMethodsForClass(Animal.class, "com.heqin.javabase.ClassApiExample.Animal.class");
    }

    private void printMethodsForClass(Class<?> clazz, String label) {
        System.out.println(label + ":");
        System.out.println("    getDeclaredMethods():  ");
        Method[] declaredMethods = Animal.class.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(method -> System.out.println("       " + method));
        System.out.println("    getMethods():          ");
        Method[] methods = Animal.class.getMethods();
        Arrays.stream(methods).forEach(method -> System.out.println("       " + method));
    }

    @Test
    public void getDeclaredConstructors_test() {
        Constructor<?>[] declaredConstructors = Animal.class.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));
    }

    @Test
    public void cast(){
        Object obj = "Hello World !";
        String s = String.class.cast(obj);
        System.out.println(s);
    }

    /**
     * getClass() - 返回此Object的运行时类。 | 返回表示此对象的运行时类的Class对象。
     */
    @Test
    public void testGetClass() {
        String str = "abc";
        Class<? extends String> strClass = str.getClass();
        System.out.println(strClass);//String对象的运行时类为：class java.lang.String
        Class<? extends Class> strClassClass = strClass.getClass();
        System.out.println(strClassClass);//class java.lang.String对象的运行时类为：class java.lang.Class
        System.out.println(strClassClass.getClass());//class java.lang.Class对象的运行时类为：class java.lang.Class -- 后续都是这样
        System.out.println("-------------------------------------");
        Number n = 0;
        Class<? extends Number> c = n.getClass();
        System.out.println(c);//Integer对象的运行时类为：class java.lang.Integer
        Class<? extends Class> cClass = c.getClass();
        System.out.println(cClass);//class java.lang.Integer对象的运行时类为：class java.lang.Class
        System.out.println(cClass.getClass());//class java.lang.Class对象的运行时类为：class java.lang.Class -- 后续都是这样

    }
}

/**
 * 生物
 */
class Organism {

    protected Organism() {

    }

    public void publicMethod() {
        System.out.println("public 方法。。。");
    }

    protected void protectedMethod() {
        System.out.println("protected 方法。。。");
    }

    void defaultPackageAccessMethod() {
        System.out.println("default (package)access 方法。。。");
    }

    private void privateMethod() {
        System.out.println("private 方法。。。");
    }
}

/**
 * Animal
 * 动物
 */
class Animal extends Organism {

    private void move() {
        System.out.println("animal move...");
    }

}

/**
 * Mammal
 * 哺乳动物
 */
class Mammal extends Animal {
}

/**
 * Reptile
 * 爬虫
 */
class Reptile extends Animal {
}

/**
 * Dog
 * 狗
 */
class Dog extends Mammal {
}

/**
 * behavior
 * 行为
 */
interface Behavior {

}

/**
 * 能游泳
 */
interface SwimCapableBehavior extends Behavior {

}

/**
 * 能奔跑
 */
interface RunCapableBehavior extends Behavior {

}
