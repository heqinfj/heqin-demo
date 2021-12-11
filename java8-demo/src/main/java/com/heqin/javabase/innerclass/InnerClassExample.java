package com.heqin.javabase.innerclass;

import org.junit.Test;

/**
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1376414781669409
 *
 * https://fangshixiang.blog.csdn.net/article/details/80351540
 *
 * @Author heqin
 * @Date 2021/9/28 10:31
 */
public class InnerClassExample {

    /**
     * 测试非静态内部类
     */
    @Test
    public void testNotStaticInnerClass() {
        OuterClass outer = new OuterClass("Nested"); // 实例化一个Outer
        OuterClass.InnerClassNotStatic inner = outer.new InnerClassNotStatic(); // 实例化一个Inner
        inner.hello();
    }

    /**
     * 测试静态内部类
     */
    @Test
    public void testStaticInnerClass() {
        OuterClass.InnerClassStatic innerClassStatic = new OuterClass.InnerClassStatic();
        //OuterClass outer = new OuterClass("Nested");
        //OuterClass.InnerClassStatic innerClassStatic = outer.new InnerClassStatic();//编译出错：Qualified new of static class
        innerClassStatic.hello();
    }
}

class OuterClass {

    private static String NAME = "OUTER";

    private String name;

    OuterClass(String name) {
        this.name = name;
    }

    /*
    静态内部类 vs 内部类
        静态内部类：只是为了降低包的深度，方便类的使用，实现高内聚。静态内部类适用于不依赖于外部类，不用使用外在类的非静态属性和方法，只是为了方便管理类结构而定义。在创建静态内部类的时候，不需要外部类对象的引用。
        非静态内部类：它有一个很大的优点：可以自由使用外部类的所有变量和方法，对其外部类有个引用
    有了这两个区别，各位看官应该知道什么时候使用什么样的类了吧。
    */

    /**
     * 非静态内部类：它有一个很大的优点：可以自由使用外部类的所有变量和方法，对其外部类有个引用
     *
     */
    class InnerClassNotStatic {

        //private static String staticProp;//编译报错：Static declarations in inner classes are not supported at language level '8'

        void hello() {
            System.out.println("Hello, " + OuterClass.this.name);
        }
    }

    /**
     * 静态内部类：只是为了降低包的深度，方便类的使用，实现高内聚。静态内部类适用于不依赖于外部类，不用使用外在类的非静态属性和方法，只是为了方便管理类结构而定义。在创建静态内部类的时候，不需要外部类对象的引用。
     */
    static class InnerClassStatic{

        //private static String staticProp;

        public InnerClassStatic(){
            System.out.println("InnerClassStatic...");
        }
        void hello() {
            System.out.println("hello: " + OuterClass.NAME);
            //System.out.println("静态内部类。。。");
            //System.out.println("Hello, " + OuterClass.this.name);//编译出错：'com.heqin.yourbatman.innerclass.OuterClass.this' cannot be referenced from a static context
        }
    }
}

/**
 * 总结
 * 说说内部类的好处吧
 * （1）内部类可以很好的实现隐藏(一般的非内部类，是不允许有 private 与protected权限的，但内部类可以)
 *
 * （2）内部类拥有外围类的所有元素的访问权限
 *
 * （3）可以实现多重继承
 *  https://www.cnblogs.com/chenssy/p/3389027.html
 *  http://c.biancheng.net/view/1034.html
 *
 * （4）可以避免修改接口而实现同一个类中***两种同名方法***的调用
 *
 */
