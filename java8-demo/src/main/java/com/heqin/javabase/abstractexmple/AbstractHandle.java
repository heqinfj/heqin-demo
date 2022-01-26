package com.heqin.javabase.abstractexmple;

/**
 * @Author heqin
 * @Date 2021/12/21 11:03
 */
public abstract class AbstractHandle {

    protected abstract boolean doHandleMsg(String msg);

    public void consumeMsg(String msg){
        handleMsgInner(msg);
    }

    private void handleMsgInner(String msg){
        AbstractHandle.this.doHandleMsg(msg);
    }
}
