package com.heqin.java8guide.chapter05;

import java.util.function.Predicate;

public class MyPredicate<T> implements Predicate<T> {

    @Override
    public boolean test(T o) {
        if (o instanceof String) {
            String s = (String) o;
            return s.length() > 0;
        }
        return false;
    }

    @Override
    public Predicate<T> negate() {
        //return Predicate.super.negate();
        Predicate predicate = null;
        //写法1
        predicate = (t) -> {
            return !test((T) t);
        };
        //写法2
        predicate = (t) -> !test((T) t);

        //写法3
        predicate = new Predicate() {
            @Override
            public boolean test(Object t) {
                //当在一个类的内部类中，需要访问外外部类的方法与属性时，必须使用外部类名.this.属性/方法
                //内部类：当前所在的就是匿名内部类，外部类：MyPredicate
                return !MyPredicate.this.test((T) t);
            }
        };

        return predicate;
    }
}
