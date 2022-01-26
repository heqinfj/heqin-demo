package com.heqin.javabase.abstractexmple;

/**
 * @Author heqin
 * @Date 2021/12/21 11:07
 */
public class AppTest {
    public static void main(String[] args) {
        AbstractHandle handle = new RedisHandle();
        handle.consumeMsg("Hello World!");
    }
}
