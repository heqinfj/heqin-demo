package com.heqin.javabase.innerclass.anonymousclass;

import org.junit.Test;

/**
 * @Author heqin
 * @Date 2021/10/1 1:59
 */
public class InnerClassTest {

    @Test
    public void test_01(){
        Outer outer = new Outer("Nested");
        outer.asyncHello();
    }
}
