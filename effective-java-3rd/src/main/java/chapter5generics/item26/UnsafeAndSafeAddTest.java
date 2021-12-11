package chapter5generics.item26;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/11/21 10:31
 */
public class UnsafeAndSafeAddTest {

    // Fails at runtime - unsafeAdd method uses a raw type (List)!
    // 运行时失败 - unsafeAdd 方法使用原始类型（List）！
    @Test
    public void testUnsafeAdd() {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        //运行时抛出：java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String
        String s = strings.get(0); // Has compiler-generated cast
    }

    /**
     * 不安全的add方法
     * @param list raw type
     * @param o
     */
    private void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    @Test
    public void testUnsafeAdd2() {
        List<String> strings = new ArrayList<>();
        //编译异常：'unsafeAdd2(java.util.List<java.lang.Object>, java.lang.Object)' cannot be applied to '(java.util.List<java.lang.String>, java.lang.Integer)'
        //unsafeAdd2(strings, Integer.valueOf(42));//error
        String s = strings.get(0); // Has compiler-generated cast
    }


    private void unsafeAdd2(List<Object> list, Object o) {
        list.add(o);
    }

    @Test
    public void testUnsafeAdd3() {
        List<String> strings = new ArrayList<>();
        unsafeAdd3(strings, Integer.valueOf(42));//error
        String s = strings.get(0); // Has compiler-generated cast
    }


    private void unsafeAdd3(List<?> list, Object o) {
        //编译时异常：'add(capture<?>)' in 'java.util.List' cannot be applied to '(java.lang.Object)'
        //list.add(o);//compile error
    }
}
