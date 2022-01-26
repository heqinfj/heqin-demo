package com.heqin.javabase.generictypes.learnjavatype03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/12/18 8:16
 */
public class ListTest {
    public <V> void testList(List<Integer> integerList,int a,boolean b,String str){
        List<V> list = new ArrayList<>();
    }

    public <E> void test(E t){

    }
}
