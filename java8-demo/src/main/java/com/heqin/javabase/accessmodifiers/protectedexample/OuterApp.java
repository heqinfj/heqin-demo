package com.heqin.javabase.accessmodifiers.protectedexample;

import com.heqin.javabase.accessmodifiers.protectedexample.mypack.B;
import com.heqin.javabase.accessmodifiers.protectedexample.pack.A;

/**
 * @Author heqin
 * @Date 2021/9/27 0:03
 */
public class OuterApp {
    public static void main(String[] args) {
        B b = new B();
        //b.msg();//'msg()' has protected access in 'com.heqin.javabase.accessmodifiers.protecteddemo.pack.A'

        A a = new A();
        //a.msg();//'msg()' has protected access in 'com.heqin.javabase.accessmodifiers.protecteddemo.pack.A'
    }
}
