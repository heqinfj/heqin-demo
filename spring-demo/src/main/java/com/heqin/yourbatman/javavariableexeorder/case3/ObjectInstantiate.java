package com.heqin.yourbatman.javavariableexeorder.case3;

/**
 * @Author heqin
 * @Date 2021/9/27 19:33
 */
public class ObjectInstantiate {

    /**
     * # Java对象实例化顺序
     *
     * >https://blog.csdn.net/m0_38110132/article/details/78842873
     *
     * >**静态成员变量** | **静态代码块** （这2个加载时按代码的先后顺序执行） —>  **成员变量**  |  **方法块** （这2个加载时按代码的先后顺序执行） —> **构造函数** 的加载顺序
     * >
     * >Java程序在执行过程中，类，对象以及它们成员加载、初始化的顺序如下：
     * >1、首先加载要创建对象的类及其直接与间接父类。
     * >2、在类被加载的同时会将静态成员进行加载，主要包括静态成员变量的初始化，静态语句块的执行，在加载时按代码的先后顺序进行。
     * >3、需要的类加载完成后，开始创建对象，首先会加载非静态的成员，主要包括非静态成员变量的初始化，非静态语句块的执行，在加载时按代码的先后顺序进行。
     * >4、最后执行构造器，构造器执行完毕，对象生成。
     * >
     * >所以java对象实例化时的顺序为：
     * >
     * >1，父类的静态成员变量和静态代码块加载
     * >2，子类的静态成员变量和静态代码块加载
     * >3，父类成员变量和方法块加载
     * >4，父类的构造函数加载
     * >5，子类成员变量和方法块加载
     * >6，子类的构造函数加载
     */

    {
        System.out.println("执行普通代码块");
    }

    public ObjectInstantiate(){
        System.out.println("执行构造函数");
    }

    private String str = queryStr();

    public String queryStr(){
        System.out.println("成员变量str初始化");
        return "abc";
    }

    public static void main(String[] args) {
        ObjectInstantiate objectInstantiate = new ObjectInstantiate();
    }
}
