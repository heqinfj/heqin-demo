package com.heqin.javabase.generictypes.other;

/**
 * @Author heqin
 * @Date 2021/10/6 20:27
 */
public class Pair<T> {
    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
}
