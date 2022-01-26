package com.heqin.javabase.parentsdelegation.neo;

/**
 * @Author heqin
 * @Date 2022/1/20 14:53
 */
public class Test12 {
    static {
        System.out.println("静态初始化块执行了！");
    }

    public Test12(){
        System.out.println("Test12 默认构造函数。。。");
    }

    @Override
    public String toString() {
        return "Test12{}";
    }
}
