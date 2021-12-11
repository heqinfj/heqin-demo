package generics.wildcards.wildcardsandsubtyping;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Wildcards and Subtyping
 * 通配符和子类型
 *
 * @Author heqin
 * @Date 2021/12/3 22:47
 */
public class WildcardsAndSubtyping {

    @Test
    public void testAb() {
        B b = new B();
        A a = b;//OK
    }

    @Test
    public void testError() {
        List<B> bList = new ArrayList<>();
        //List<A> aList = bList;//compile-time error
    }

    @Test
    public void testOk() {
        List<? extends Integer> integers = new ArrayList<>();
        List<? extends Number> numbers = integers;//OK. List<? extends Integer> is a subtype of List<? extends Number>
    }
}

class A {
    /* ... */
}

class B extends A {
    /* ... */
}
