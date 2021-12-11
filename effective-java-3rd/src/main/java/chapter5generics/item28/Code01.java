package chapter5generics.item28;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/11/21 13:11
 */
public class Code01<T> {

    /**
     * arrays are covariant.
     * 数组是协变的。
     * <p>
     * 数组与泛型有两个重要区别。首先，数组是协变的。这个听起来很吓人的单词的意思很简单，如果 Sub 是 Super 的一个子类型，那么数组类型 Sub[]
     * 就是数组类型 Super[] 的一个子类型。相比之下，泛型是不变的：
     * 对于任何两个不同类型 Type1 和 Type2，List<Type1> 既不是 List<Type2> 的子类型，
     * 也不是 List<Type2> 的超类型 [JLS, 4.10; Naftalin07, 2.5]。
     * 你可能认为这意味着泛型是有缺陷的，但可以说数组才是有缺陷的。
     * <p>
     * 数组和泛型之间的第二个主要区别：数组是具体化的 [JLS, 4.7]。这意味着数组在运行时知道并强制执行他们的元素类型。
     * 如前所述，如果试图将 String 元素放入一个 Long 类型的数组中，就会得到 ArrayStoreException。
     * 相比之下，泛型是通过擦除来实现的 [JLS, 4.6]。这意味着它们只在编译时执行类型约束，
     * 并在运行时丢弃（或擦除）元素类型信息。擦除允许泛型与不使用泛型的遗留代码自由交互操作（Item-26），确保在 Java 5 中平稳地过渡。
     */
    @Test
    public void testArrays() {
        // Fails at runtime!
        Object[] objectArrays = new Long[3];
        System.out.println(objectArrays.length);
        objectArrays[0] = "I don't fit in";//运行失败 Throws java.lang.ArrayStoreException
        //说明当前objectArrays里面的元素类型只能是Long
        //objectArrays[1] = 1L;//运行正常
    }

    @Test
    public void testList() {
        // Won't compile!
        //List<Object> o = new ArrayList<Long>();//Incompatible types. Found: 'java.util.ArrayList<java.lang.Long>', required: 'java.util.List<java.lang.Object>'
        //o.add("I don't fit in");
    }

    /**
     * Either way you can’t put a String into a Long container, but with an array you find out that you’ve made a mistake at runtime;
     * with a list, you find out at compile time. Of course, you’d rather find out at compile time.
     *
     * 两种方法都不能将 String 放入 Long 容器，但使用数组，你会得到一个运行时错误；使用 list，你可以在编译时发现问题。当然，你更希望在编译时找到问题。
     */

    /**
     * 例如，创建泛型、参数化类型或类型参数的数组是非法的。
     * 因此，这些数组创建表达式都不是合法的：new List<E>[]、new List<String>[]、new E[]。所有这些都会在编译时导致泛型数组创建错误。
     *
     *
     * E、List<E> 和 List<string> 等类型在技术上称为不可具体化类型 [JLS, 4.7]。
     * 直观地说，非具体化类型的运行时表示包含的信息少于其编译时表示。由于擦除，唯一可具体化的参数化类型是无限制通配符类型，如 List<?> 和 Map<?,?>（Item-26）。
     * 创建无边界通配符类型数组是合法的，但不怎么有用。
     *
     */
    public void testArrayCreationExpressionArelegal(){
        // Why generic array creation is illegal - won't compile!
        //List<String>[] stringLists = new ArrayList<String>[1]; // (1)
        List<Integer> intList = List.of(42); // (2)
        List<?>[] list = new ArrayList<?>[1];
    }
}
