package com.heqin.javabase.accessmodifiers.privateexample.example01;

/**
 * @Author heqin
 * @Date 2021/9/27 8:34
 */
public class B {
    public static void main(String[] args) {
        A obj=new A();
        //System.out.println(obj.data);//Compile Time Error
        //obj.msg();//Compile Time Error
    }
}
