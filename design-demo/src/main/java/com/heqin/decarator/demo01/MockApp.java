package com.heqin.decarator.demo01;

/**
 * 测试类
 *
 * @Author heqin
 * @Date 2021/9/29 10:25
 */
public class MockApp {

    public static void main(String[] args) {
        //普通奶茶
        AbstractMilkTea milkTea = new GenericMilkTea();

        //加冰
        IceMilkTea iceMilkTea = new IceMilkTea(milkTea);
        System.out.println(iceMilkTea);

        //加珍珠
        PearlMilkTea pearlMilkTea = new PearlMilkTea(iceMilkTea);
        System.out.println(pearlMilkTea);
    }
}
