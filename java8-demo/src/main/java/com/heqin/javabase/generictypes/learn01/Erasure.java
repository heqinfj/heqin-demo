package com.heqin.javabase.generictypes.learn01;

/**
 * 范型类
 *
 * @Author heqin
 * @Date 2021/11/18 17:20
 */
public class Erasure<T> {

    private T object;

    public Erasure(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    //泛型方法中的<T>与泛型类中的<T>不是同一个泛型类型
    public <T> T testMethod1(T t) {
        return t;
    }
}
