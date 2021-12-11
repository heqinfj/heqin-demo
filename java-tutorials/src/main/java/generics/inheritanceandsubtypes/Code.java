package generics.inheritanceandsubtypes;

import generics.Box;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/12/2 10:11
 */
public class Code {

    public void testBoxAdd() {
        Box<Number> box = new Box<>();
        box.add(new Integer(10));//ok
        box.add(new Double(10.1));//ok
    }

    /**
     * Box<Integer> 不是 Box<Number> 的子类型，即使 Integer 是 Number 的子类型。
     * 注意: 给定两种具体类型 A 和 B(例如，Number 和 Integer)，MyClass<A> 与 MyClass<B> 没有任何关系，无论 A 与 B 是否相关。MyClass<A> 和 MyClass<B> 的公共父类是 Object。
     */
    public void testBoxTest() {
        Box<Number> box = new Box<>();
        Box<Integer> integerBox = new Box<>();
        Box<Double> doubleBox = new Box<>();
        //'boxTest(generics.Box<java.lang.Number>)' in 'generics.Box' cannot be applied to '(generics.Box<java.lang.Integer>)'
        //box.boxTest(integerBox);//compile error
        //'boxTest(generics.Box<java.lang.Number>)' in 'generics.Box' cannot be applied to '(generics.Box<java.lang.Double>)'
        //box.boxTest(doubleBox);//compile error
    }

    /**
     * 泛型类和子类型
     * 你可以通过继承泛型类或实现泛型接口来对其进行子类型化。一个类或接口的类型形参与另一个的类型形参之间的关系由 extends 和 implements 子句确定。
     * <p>
     * 以 Collections 类为例，ArrayList<E> 实现 List<E>，List<E> extends Collection<E>。
     * 所以 ArrayList<String> 是 List<String> 的子类型，它是 Collection<String> 的子类型。只要不改变类型实参，就会在类型之间保留子类型关系。
     * https://pingfangx.github.io/java-tutorials/java/generics/inheritance.html
     */
    public void testCollection() {
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> list = arrayList;
        Collection<String> collection = list;
        collection = arrayList;
    }

    /**
     * PayloadList 的以下参数化是 List<String> 的子类型：
     * <p>
     * PayloadList<String,String>
     * PayloadList<String,Integer>
     * PayloadList<String,Exception>
     */
    public void testPayloadList() {
        List<String> list = null;
        PayloadList<String, Number> numberPayloadList = null;
        PayloadList<String, Integer> integerPayloadList = null;
        PayloadList<String, Exception> exceptionPayloadList = null;
        list = numberPayloadList;
        list = integerPayloadList;
        list = exceptionPayloadList;
    }

    @Test
    public void testPayloadListImpl(){
        PayloadList<String,Number> numberPayloadList = new PayloadListImpl<>();
        numberPayloadList.setPayload(1,new Integer(10));
        numberPayloadList.setPayload(1,new Double(10.1));
        numberPayloadList.printContainer();
    }
}
