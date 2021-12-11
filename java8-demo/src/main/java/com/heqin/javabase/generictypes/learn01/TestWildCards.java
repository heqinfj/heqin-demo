package com.heqin.javabase.generictypes.learn01;


import java.util.Collection;

/**
 * @Author heqin
 * @Date 2021/11/18 16:30
 */
public class TestWildCards {
    public void testWildCards(Collection<?> collection) {
        //collection.add(1);//error
        //collection.add("abc");//error
        //collection.add(new Object());//error

        collection.size();
        collection.iterator().next();
    }
}
