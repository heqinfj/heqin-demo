package com.heqin.javabase.generictypes.principle.comparatorexample;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/10/19 10:04
 */
public class App {

    @Test
    public void test1() {
        Object a = 5;
        Object b = 6;
        //具体类型
        MyComparator genericComp = new MyComparator();
        int comp = genericComp.compare((Integer) a, (Integer) b);
    }

    @Test
    public void test2() {
        Object a = 5;
        Object b = 6;
        //接口类型  raw（原始）类型
        Comparator rawComp = new MyComparator();
        int comp = rawComp.compare(a, b);
    }

    @Test
    public void testMax(){
        List list = new ArrayList(){
            {
                add(5);
                add(2);
                add(8);
            }
        };
        Integer max = CompareUtil.max(list, new MyComparator());
        System.out.println(max);
    }
}
