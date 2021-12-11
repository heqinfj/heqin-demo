package chapter5generics.item28;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/11/23 10:40
 */
public class Code02<E> {

    public void test(){
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1d);

        Double aDouble = doubleList.get(0);
        System.out.println(aDouble);
    }

    /**
     * 使用原始类型的潜在风险
     * 原始类型（raw types）List
     * Throws ClassCastException
     */
    @Test
    public void testClassCastException(){
        List list = new ArrayList();
        list.add("1");
        int a = (int)list.get(0);//java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer
    }

    /**
     * 使用参数化类型的好处
     * 参数化类型（parameterized types）List<Integer> 限制了list中元素必须是Integer型
     */
    @Test
    public void testGenericGood(){
        List<Integer> list = new ArrayList<>();
        //list.add("a");//compile error 'add(java.lang.Integer)' in 'java.util.List' cannot be applied to '(java.lang.String)'
        list.add(1);
        int a = list.get(0);
        Integer b = list.get(0);
        Object o = list.get(0);
    }
}
