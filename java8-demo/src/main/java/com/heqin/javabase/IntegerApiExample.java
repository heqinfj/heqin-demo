package com.heqin.javabase;

import org.junit.Test;

/**
 * Integer api
 *
 * @Author heqin
 * @Date 2021/10/8 11:22
 */
public class IntegerApiExample {

    @Test
    public void toHexString(){
        int i = 200;
        String hexString = Integer.toHexString(i);
        System.out.println(String.format("%s的16进制为%s",i,hexString));
    }

}
