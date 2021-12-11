package com.heqin.javabase.innerclass.innerclass;

import org.junit.Test;

/**
 * @Author heqin
 * @Date 2021/10/1 1:35
 */
public class InnerClassTest {

    @Test
    public void test_01(){
        Outer outer = new Outer("world");
        Outer.Inner inner = outer.new Inner();
        inner.hello();
    }
}
