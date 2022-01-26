package com.heqin.javabase.generictypes.principle.nodeeample;

import org.junit.Test;

/**
 * @Author heqin
 * @Date 2021/10/19 7:37
 */
public class App {
    @Test
    public void test1() {
        MyNode mn = new MyNode(5);//声明的是MyNode变量
        //直接调用MyNode的setData(Integer data)
        mn.setData(new Integer(6));
    }

    @Test
    public void test2() {
        Object o = 6;
        Node mn = new MyNode(5);//声明的是Node变量
        //调用轨迹：Node的setData(T data) -》MyNode的setData(Object data) 编译器生成的桥接方法 -》最终调用MyNode的setData(Integer data)
        mn.setData(o);
    }

    @Test
    public void test3(){
        MyNode mn = new MyNode(5);
        Node n = mn;
        n.setData("Hello");
        Integer x = mn.data;
    }

    @Test
    public void txx(){
        int[] arr = new int[]{1,3};
        System.out.println(arr.getClass());
    }
}
