package com.heqin.javabase.generictypes.other;

/**
 * Java的类型擦除
 * https://www.hollischuang.com/archives/226
 *
 * Java泛型用了这么多年，你真的了解吗？
 * http://blog.itpub.net/31559985/viewspace-2702628/
 *
 * Java 中泛型的实现原理
 * https://www.cnblogs.com/robothy/p/13949788.html
 *
 *
 * @Author heqin
 * @Date 2021/10/6 20:28
 */
public class GenericType<T extends String> {
    private T type;

    public void setParam(T type){
        this.type = type;
    }

    public T getParam(){
        return type;
    }
}
