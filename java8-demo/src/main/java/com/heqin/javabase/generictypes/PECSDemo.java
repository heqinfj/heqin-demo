package com.heqin.javabase.generictypes;

import org.junit.Test;

import java.io.Serializable;

/**
 * https://www.zhihu.com/question/20400700
 * <p>
 * PECS原则
 * PECS（Producer Extends Consumer Super）原则，已经很好理解了：
 * 1. 频繁往外读取内容的，适合用上界Extends。
 * 2. 经常往里插入的，适合用下界Super。
 *
 *
 *
 * @Author heqin
 * @Date 2021/11/17 17:29
 */
public class PECSDemo {

    public void test1() {
        //Plate<Number> a = new Plate<Integer>();//error
        Plate<? extends Number> plate = new Plate<Integer>();

        Plate<? super Integer> plate1 = new Plate<Number>();
        Plate<? super Integer> plate2 = new Plate<Object>();
        //Plate<? super Integer> plate3 = new Plate<Long>();//error
    }

    /**
     * 上界<? extends T>不能往里存，只能往外取
     * <p>
     * <? extends Number>会使往盘子里放东西的set( )方法失效。但取东西get( )方法还有效
     */
    @Test
    public void testExtends() {
        Plate<? extends Number> plate = new Plate<Integer>();
        //不能存入任何元素
        //plate.setItem(Integer.valueOf(1));//error
        //plate.setItem(1);//error
        //plate.setItem(new Object());//error

        //读取出来的东西只能存放在Number或它的基类里
        Number item1 = plate.getItem();
        Object item2 = plate.getItem();
        //Integer item3 = plate.getItem();//error
    }


    /**
     * 下界<? super T>不影响往里存，但往外取只能放在Object对象里
     * <p>
     * 使用下界<? super Number>会使从盘子里取东西的get( )方法部分失效，只能存放到Object对象里。set( )方法正常。
     */
    @Test
    public void testGet() {
        Plate<? super Number> plate = new Plate<Number>();
        //存入元素正常
        plate.setItem(Integer.valueOf(1));
        plate.setItem(Long.valueOf(1));

        //读取出来的东西只能存放在Object类里。
        Object item1 = plate.getItem();
        //Number item2 = plate.getItem();//error
        //Integer item3 = plate.getItem();//error
    }

    /**
     * 盘子
     *
     * @param <T>
     */
    private class Plate<T> {

        private T item;

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }
}
