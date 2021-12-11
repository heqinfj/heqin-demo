package generics.wildcards.unboundedwildcards;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Unbounded Wildcards
 * 无界通配符
 *
 * 重要的是要注意 List<Object> 和 List<?> 是不一样的。你可以将 Object 或 Object 的任何子类型插入 List<Object>。但是你只能将 null 插入 List<?>。
 *
 * @Author heqin
 * @Date 2021/12/3 22:00
 */
public class UnboundedWildcards {

    /**
     * printList 的目标是打印任何类型的列表，但它无法实现该目标 - 它只打印 Object 实例的列表;
     * 它不能打印 List<Integer>，List<String>，List<Double> 等等，因为它们不是 List<Object> 的子类型。要编写泛型的 printList 方法，请使用 List<?>：
     *
     * @param list
     */
    public static void printList(List<Object> list) {
        for (Object elem : list) {
            System.out.println(elem + " ");
        }
        System.out.println();
    }

    @Test
    public void testPrintList(){
        List<String> stringList = Arrays.asList("a","b","c");
        //'printList(java.util.List<java.lang.Object>)' in 'generics.wildcards.unboundedwildcards.UnboundedWildcards' cannot be applied to '(java.util.List<java.lang.String>)'
        //printList(stringList);//compile error

        List<Object> objectList = Arrays.asList("a","b","c");
        printList(objectList);//ok
    }


    public static void printList2(List<?> list) {
        for (Object elem : list) {
            System.out.println(elem + " ");
        }
        System.out.println();
    }

    /**
     * 对于任何具体类型 A，List<A> 是 List<?> 的子类型，你可以使用 printList2 打印任何类型的列表
     */
    @Test
    public void testPrintList2(){
        List<String> stringList = Arrays.asList("a","b","c");
        printList2(stringList);
    }

}
