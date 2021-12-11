package chapter5generics.item28;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * nonreifiable types
 * 不可具体化类型
 * <p>
 * Types such as E, List<E>, and List<String> are technically known as nonreifiable types [JLS, 4.7]. Intuitively speaking,
 * a non-reifiable type is one whose runtime representation contains less information than its compile-time representation.
 * Because of erasure, the only parameterized types that are reifiable are unbounded wildcard types such as List<?> and Map<?,?> (Item 26).
 * It is legal, though rarely useful, to create arrays of unbounded wildcard types.
 * E、List<E> 和 List<string> 等类型在技术上称为不可具体化类型。
 * 直观地说，非具体化类型的运行时表示包含的信息少于其编译时表示。由于擦除，唯一可具体化的参数化类型是无限制通配符类型，如 List<?> 和 Map<?,?>（Item-26）。
 * 创建无边界通配符类型数组是合法的，但不怎么有用。
 * <p>
 * it is illegal to create an array of a generic type, a parameterized type, or a type parameter.
 * Therefore, none of these array creation expressions are legal: new List<E>[], new List<String>[], new E[].
 * All will result in generic array creation errors at compile time.
 * 创建泛型、参数化类型或类型参数的数组是非法的。因此，这些数组创建表达式都不是合法的：new List<E>[]、new List<String>[]、new E[]。
 * 所有这些都会在编译时导致泛型数组创建错误。
 *
 * @Author heqin
 * @Date 2021/11/30 2:38
 */
public class NonreifiableTypes {

//    public <E> void testNonreifiableTypes() {
//        E e = (E)new Object();
//        List<E> list = new ArrayList<>();
//        List<String> stringList = new ArrayList<>();
//    }

    @Test
    public void execTestParameterizedTypes() {
        testParameterizedTypesErasure();
    }

    /**
     * 泛型擦除
     */
    public void testParameterizedTypesErasure() {
        //List<String> 参数化类型 parameterized type
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        String firstElement = stringList.get(0);
        System.out.println(firstElement);
    }
    /**
     已编译的.class文件通过jad编译后：
     public void testParameterizedTypes(){
     ArrayList arraylist = new ArrayList();
     arraylist.add("a");
     String s = (String)arraylist.get(0);
     System.out.println(s);
     }
     */

    /**
     * bounded wildcards type 有界通配符类型
     */
    public void testBoundedWildcardsTypeErasure() {
        //List<String> bounded wildcards type
        List<? extends String> stringList = new ArrayList<>();
        String s = stringList.get(0);
    }
}
