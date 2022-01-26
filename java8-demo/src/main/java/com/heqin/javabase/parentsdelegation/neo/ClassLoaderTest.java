package com.heqin.javabase.parentsdelegation.neo;

import org.junit.Test;

/**
 * @Author heqin
 * @Date 2022/1/20 14:51
 */
public class ClassLoaderTest {
    @Test
    public void test(){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }
}
