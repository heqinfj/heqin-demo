package com.heqin.yourbatman.javavariableexeorder.case5;

/**
 * @Desc case5：静态代码块属于类的，并且优先于main方法执行（有难度）
 * @Author heqin
 * @Date 2021/9/27 19:03
 */
public class StaticDemo1 {

    public static void main(String[] args) {
        speak();
        //StaticDemo1 t1 = new StaticDemo1();
        //System.out.println(t1.i);

    }

    // 静态变量
    static int i = 1;

    // 静态方法
    static void speak() {
        System.out.println("a");
    }

    // 静态代码块
    static {
        i = i + 3;
        System.out.println(i);
    }

    // 构造函数
    public StaticDemo1() {
        i = i + 5;
        System.out.println(i);
    }
}