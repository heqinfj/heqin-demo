package com.heqin.validatedemo.conditionalonmissingbean.demo02;

/**
 * @Author heqin
 * @Date 2021/12/28 10:53
 */
public class Container<T> {

    private T t;

    public Container(T t) {
        this.t = t;
    }
}
