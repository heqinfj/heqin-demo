package chapter5generics;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * type token：类型标记
 *
 * @Author heqin
 * @Date 2021/11/27 21:26
 */
public class TypeToken {

    /**
     * 基本类型
     * <p>
     * Java定义了以下几种基本数据类型：
     * <p>
     * 整数类型：byte，short，int，long
     * <p>
     * 浮点数类型：float，double
     * <p>
     * 字符类型：char
     * <p>
     * 布尔类型：boolean
     */
    @Test
    public void testBasicDataType() {
        //整数类型
        Class<Byte> byteClass = Byte.class;
        Class<Byte> byteClass1 = byte.class;
        //System.out.println(byteClass == byteClass1);//false
        printClassLiteralName("Byte.class", byteClass);
        printClassLiteralName("byte.class", byteClass1);
        printClassLiteralSimpleName("Byte.class", byteClass);
        printClassLiteralSimpleName("byte.class", byteClass1);

        Class<Short> shortClass = Short.class;
        Class<Short> shortClass1 = short.class;
        printClassLiteralName("Short.class", shortClass);
        printClassLiteralName("short.class", shortClass1);
        printClassLiteralSimpleName("Short.class", shortClass);
        printClassLiteralSimpleName("short.class", shortClass1);

        Class<Integer> integerClass = Integer.class;
        Class<Integer> integerClass1 = int.class;
        printClassLiteralName("Integer.class", integerClass);
        printClassLiteralName("int.class", integerClass1);
        printClassLiteralSimpleName("Integer.class", integerClass);
        printClassLiteralSimpleName("int.class", integerClass1);

        Class<Long> longClass = Long.class;
        Class<Long> longClass1 = long.class;
        printClassLiteralName("Long.class", longClass);
        printClassLiteralName("long.class", longClass1);
        printClassLiteralSimpleName("Long.class", longClass);
        printClassLiteralSimpleName("long.class", longClass1);

        //浮点数类型
        Class<Float> floatClass = Float.class;
        Class<Float> floatClass1 = float.class;
        printClassLiteralName("Float.class", floatClass);
        printClassLiteralName("float.class", floatClass1);
        printClassLiteralSimpleName("Float.class", floatClass);
        printClassLiteralSimpleName("float.class", floatClass1);

        Class<Double> doubleClass = Double.class;
        Class<Double> doubleClass1 = double.class;
        printClassLiteralName("Double.class", doubleClass);
        printClassLiteralName("double.class", doubleClass1);
        printClassLiteralSimpleName("Double.class", doubleClass);
        printClassLiteralSimpleName("double.class", doubleClass1);

        //字符类型
        Class<Character> characterClass = Character.class;
        Class<Character> characterClass1 = char.class;
        //System.out.println(characterClass == characterClass1);//false
        printClassLiteralName("Character.class", characterClass);
        printClassLiteralName("char.class", characterClass1);
        printClassLiteralSimpleName("Character.class", characterClass);
        printClassLiteralSimpleName("char.class", characterClass1);

        //布尔类型
        Class<Boolean> booleanClass = Boolean.class;
        Class<Boolean> booleanClass1 = boolean.class;
        printClassLiteralName("Boolean.class", booleanClass);
        printClassLiteralName("boolean.class", booleanClass1);
        printClassLiteralSimpleName("Boolean.class", booleanClass);
        printClassLiteralSimpleName("boolean.class", booleanClass1);
    }

    /**
     * 引用类型
     * <p>
     * Class 对象的类型不仅仅是 Class，而是 Class<T>。例如，String.class 的类型为 Class<String>、Integer.class 的类型为 Class<Integer>。
     * <p>
     * https://github.com/clxering/Effective-Java-3rd-edition-Chinese-English-bilingual/blob/dev/Chapter-5/Chapter-5-Item-33-Consider-typesafe-heterogeneous-containers.md
     * <p>
     * https://www.liaoxuefeng.com/wiki/1252599548343744/1264799402020448
     */
    @Test
    public void testReferenceType() {
        Class<String> stringClass = String.class;
        printClassLiteralName("String.class", stringClass);
        printClassLiteralSimpleName("String.class", stringClass);
//        System.out.println(stringClass.getTypeName());
//        System.out.println(stringClass.getSimpleName());
//        System.out.println(stringClass.getCanonicalName());
        Class<Object> objectClass = Object.class;
        printClassLiteralName("Object.class", objectClass);
        printClassLiteralSimpleName("Object.class", objectClass);
        Class<Class> classClass = Class.class;
        printClassLiteralName("Class.class", classClass);
        printClassLiteralSimpleName("Class.class", classClass);
//        Type genericSuperclass = String.class.getGenericSuperclass();

        Class<Random> randomClass = Random.class;
        printClassLiteralName("Random.class", randomClass);
        printClassLiteralSimpleName("Random.class", randomClass);
    }

    /**
     * 数组类型
     */
    @Test
    public void testArraysType() {
        printClassLiteralName("(new int[3]).getClass()", (new int[3]).getClass());
        printClassLiteralSimpleName("(new int[3]).getClass()", (new int[3]).getClass());

        printClassLiteralName("(new Integer[3]).getClass()", (new Integer[3]).getClass());
        printClassLiteralSimpleName("(new Integer[3]).getClass()", (new Integer[3]).getClass());

        printClassLiteralName("(new boolean[3]).getClass()", (new boolean[3]).getClass());
        printClassLiteralSimpleName("(new boolean[3]).getClass()", (new boolean[3]).getClass());

        printClassLiteralName("(new Boolean[3]).getClass()", (new Boolean[3]).getClass());
        printClassLiteralSimpleName("(new Boolean[3]).getClass()", (new Boolean[3]).getClass());

        printClassLiteralName("(new long[3]).getClass()", (new long[3]).getClass());
        printClassLiteralSimpleName("(new long[3]).getClass()", (new long[3]).getClass());

        printClassLiteralName("(new Long[3]).getClass()", (new Long[3]).getClass());
        printClassLiteralSimpleName("(new Long[3]).getClass()", (new Long[3]).getClass());

        printClassLiteralName("(new Object[3]).getClass()", (new Object[3]).getClass());
        printClassLiteralSimpleName("(new Object[3]).getClass()", (new Object[3]).getClass());

        printClassLiteralName("(new int[3][4][5][6][7][8][9]).getClass()", (new int[3][4][5][6][7][8][9]).getClass());
        printClassLiteralSimpleName("(new int[3][4][5][6][7][8][9]).getClass()", (new int[3][4][5][6][7][8][9]).getClass());

        printClassLiteralName("(new Integer[3][4][5][6][7][8][9]).getClass()", (new Integer[3][4][5][6][7][8][9]).getClass());
        printClassLiteralSimpleName("(new Integer[3][4][5][6][7][8][9]).getClass()", (new Integer[3][4][5][6][7][8][9]).getClass());

        printClassLiteralName("(new ArrayList<?>[2]).getClass()", (new ArrayList<?>[2]).getClass());
        printClassLiteralSimpleName("(new ArrayList<?>[2]).getClass()", (new ArrayList<?>[2]).getClass());
    }


    /**
     * 打印类字面量的名称
     * <p>
     * 示例：
     * <p>
     * 1. 基础类型
     * <p>
     * Integer.class的name为java.lang.Integer
     * <p>
     * int.class的name为int
     * <p>
     * 2. 引用类型
     * <p>
     * String.class的name为java.lang.String
     * <p>
     * Object.class的name为java.lang.Object
     * <p>
     * Random.class的name为java.util.Random
     * <p>
     * Class.class的name为java.lang.Class
     * <p>
     * 3. 数组类型
     * (new int[3]).getClass()的name为[I
     * <p>
     * (new Integer[3]).getClass()的name为[Ljava.lang.Integer;
     * <p>
     * (new Object[3]).getClass()的name为[Ljava.lang.Object;
     * <p>
     * (new int[3][4][5][6][7][8][9]).getClass()的name为[[[[[[[I
     * <p>
     * (new Integer[3][4][5][6][7][8][9]).getClass()的name为[[[[[[[Ljava.lang.Integer;
     * <p>
     * (new ArrayList<?>[2]).getClass()的name为[Ljava.util.ArrayList;
     *
     * @param classLiteral
     * @param clazz
     */
    private void printClassLiteralName(String classLiteral, Class<?> clazz) {
        System.out.println(String.format("%s的name为%s", classLiteral, clazz.getName()));
    }

    /**
     * 示例：
     * <p>
     * 1. 基础类型
     * <p>
     * Integer.class的simple name为Integer
     * <p>
     * int.class的simple name为int
     * <p>
     * 2. 引用类型
     * <p>
     * String.class的simple name为String
     * <p>
     * Object.class的simple name为Object
     * <p>
     * Class.class的simple name为Class
     * <p>
     * Random.class的simple name为Random
     * <p>
     * <p>
     * 3. 数组类型
     * <p>
     * (new int[3]).getClass()的simple name为int[]
     * <p>
     * (new Integer[3]).getClass()的simple name为Integer[]
     * <p>
     * (new Object[3]).getClass()的simple name为Object[]
     * <p>
     * (new int[3][4][5][6][7][8][9]).getClass()的simple name为int[][][][][][][]
     * <p>
     * (new Integer[3][4][5][6][7][8][9]).getClass()的simple name为Integer[][][][][][][]
     * <p>
     * (new ArrayList<?>[2]).getClass()的simple name为ArrayList[]
     *
     * @param classLiteral
     * @param clazz
     */
    private void printClassLiteralSimpleName(String classLiteral, Class<?> clazz) {
        System.out.println(String.format("%s的simple name为%s", classLiteral, clazz.getSimpleName()));
    }

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        System.out.println(list.getClass());
        Type genericSuperclass = list.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            //获取实际类型参数
            System.out.println(Arrays.asList(parameterizedType.getActualTypeArguments()));//[E]
        }
    }

    @Test
    public void test2() {
        List<?>[] list = new ArrayList<?>[1];
        System.out.println(list.getClass());
        Type genericSuperclass = list.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            //获取实际类型参数
            System.out.println(Arrays.asList(parameterizedType.getActualTypeArguments()));//[E]
        }
    }

    /**
     * 测试元素为List（或）List<?>类型的数组
     */
    @Test
    public void testCollectionArrays() {
        //编译警告：Raw use of parameterized class 'List' 参数化类'List'的原始使用
        List[] lists2 = new ArrayList[1];

        //推荐List<?> 参数化类型  ?无界通配符
        List<?>[] lists1 = new ArrayList<?>[1];
    }
}
