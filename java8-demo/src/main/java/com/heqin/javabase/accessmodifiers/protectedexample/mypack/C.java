package com.heqin.javabase.accessmodifiers.protectedexample.mypack;

/**
 * @Author heqin
 * @Date 2021/9/27 22:12
 */
public class C {
    public static void main(String[] args) {
        B b = new B();
        //b.msg();//'msg()' has protected access in 'com.heqin.javabase.accessmodifiers.protectedexample.pack.A'
    }
}
