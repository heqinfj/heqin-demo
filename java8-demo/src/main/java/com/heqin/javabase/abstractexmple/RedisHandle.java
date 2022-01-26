package com.heqin.javabase.abstractexmple;

/**
 * @Author heqin
 * @Date 2021/12/21 11:06
 */
public class RedisHandle extends AbstractHandle {
    @Override
    protected boolean doHandleMsg(String msg) {
        System.out.println(String.format("redis中间件消费消息：%s",msg));
        return true;
    }
}
