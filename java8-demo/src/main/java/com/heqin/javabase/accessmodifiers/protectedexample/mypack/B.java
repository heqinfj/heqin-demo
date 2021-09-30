package com.heqin.javabase.accessmodifiers.protectedexample.mypack;

import com.heqin.javabase.accessmodifiers.protectedexample.pack.A;

/**
 * @Author heqin
 * @Date 2021/9/27 0:01
 */
public class B extends A {

    public static void main(String[] args) {
        B b = new B();
        b.msg();
        //A a = new A();
        //a.msg();//'msg()' has protected access in 'com.heqin.javabase.accessmodifiers.protectedexample.pack.A'
    }
}
