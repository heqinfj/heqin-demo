package com.heqin.javabase.innerclass;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author heqin
 * @Date 2021/9/28 0:39
 * <p>
 * 内部类
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1376414781669409
 * <p>
 * 匿名内部类
 * https://fangshixiang.blog.csdn.net/article/details/80351540
 * <p>
 * 那么，匿名内部类有什么好处呢？除了只能使用一次，其实还有其他用处哦~
 * 当你想使用一个类的protected 方法时，但是目前你的类又和他不同包且也不能继承他，这时候匿名类就派上用场了，你可以声明一个匿名类继承该类，并定义一个方法然后调用父类方法即可
 * 其实，这个做法，我是在spring-boot中的HttpMessageConverters类中看到的：
 * 所以，spring都这么干了，你还有什么理由不学习麽？
 */
public class AnonymousInnerClassExample {

    /**
     * 匿名类实现接口
     */
    @Test
    public void forInterface() {
        Outer outer = new Outer("Nested");
        outer.asyncHello();
    }

    /**
     * 匿名类继承普通类
     */
    @Test
    public void forClass() {
        HashMap<String, String> map1 = new HashMap<>();//map1是一个普通的HashMap实例
        HashMap<String, String> map2 = new HashMap() {
        }; // map2是一个匿名类实例，只是该匿名类继承自HashMap。
        HashMap<String, String> map3 = new HashMap() {
            {
                put("A", "1");
                put("B", "2");
            }

            public HashMap<String, String> log() {
                System.out.println(keySet());
                return this;
            }
        }.log();//map3也是一个继承自HashMap的匿名类实例，并且添加了static代码块来初始化数据，并新增一个log方法，然后调用父类方法keySet。
        System.out.println(map3.get("A"));
    }
}

class Outer {
    private String name;

    Outer(String name) {
        this.name = name;
    }

    void asyncHello() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, " + Outer.this.name);
            }
        };
        new Thread(r).start();
    }
}
