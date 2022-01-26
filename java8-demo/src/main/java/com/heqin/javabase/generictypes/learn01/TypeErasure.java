package com.heqin.javabase.generictypes.learn01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/12/15 10:07
 */
public class TypeErasure<Sring, K, V> {
    public K getKey() {
        return null;
    }

    public V getValue() {
        return null;
    }

    public void testList() {
        List<String> list = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
        }
    }
}
