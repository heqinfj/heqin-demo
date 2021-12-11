package com.heqin.javabase.innerclass.staticnestedclass;

import org.junit.Test;

/**
 * 静态内部类测试
 *
 * @Author heqin
 * @Date 2021/10/1 1:02
 */
public class StaticNestedClassTest {

    @Test
    public void test_01(){
        Outer.StaticNested os = new Outer.StaticNested();
        //Outer.StaticNested.hello();//编译错误：Non-static method 'hello()' cannot be referenced from a static context
        //非静态方法'hello()'不能从静态上下文中引用。
        os.hello();
    }
}

