package com.heqin.javabase.generictypes.principle.comparatorexample;

import java.util.Comparator;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/10/19 10:30
 */
public class CompareUtil {
    public static <T> T max(List<T> list, Comparator<T> comp) {
        T biggestSoFar = list.get(0);
        for (T t : list) {
            if (comp.compare(t, biggestSoFar) > 0) {
                biggestSoFar = t;
            }
        }
        return biggestSoFar;
    }

    //泛型擦除
    /*
    public Object max(List list, Comparator comp) {
        Object biggestSoFar = list.get(0);
        for (Object t : list) {
            if (comp.compare(t, biggestSoFar) > 0) { //IMPORTANT
                biggestSoFar = t;
            }
        }
        return biggestSoFar;
    }
     */

    //If the bridge method didn't exist and you passed a List<Integer> and a MyComparator to this function,
    // the call at the line tagged IMPORTANT would fail
    // since MyComparator would have no method called compare that takes two Objects...only one that takes two Integers.
}
