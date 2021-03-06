package com.heqin.javabase.generictypes.principle.comparatorexample;

import java.util.Comparator;

/**
 * @Author heqin
 * @Date 2021/10/19 9:37
 */
public class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }

    //THIS is a "bridge method"  - Bridge method generated by the compiler
    /*
    public int compare(Object o1, Object o2) {
        return compare((Integer) o1, (Integer) o2);
    }
     */
}
