package com.heqin.yourbatman.javavariableexeorder.case7;

/**
 * @Desc 继续补充：子类默认调用父类构造函数问题
 * @Author heqin
 * @Date 2021/9/27 19:45
 *
 * 结论：
 *
 * 1、子类构造器执行之前必须能够先执行父类的构造函数（super(xxx)必须放在第一行代码）
 * 2、若父类有空构造，子类构造默认都会调用super()。若父类木有空构造，子类所有构造都必须显示调用super(xxx)·
 */
public class Main {

    public static void main(String[] args) {
        //Child child = new Child();
        Child child = new Child(1);
    }

}

// Java有个很有趣的现象：父类有N多个构造函数，子类如果只写一个的话那么子类最终就只有一个构造函数可用，因此子类在这方面要特别的注意喽。
// 默认情况下，子类在使用构造函数初始化时（不管是子类使用有参构造还是无参构造），默认情况下都会调用父类的无参构造函数（相当于调用了super()）。
class Parent {

    private Integer id;

//    public Parent() {
//        System.out.println("Parent默认构造函数");
//    }

    public Parent(Integer id) {
        System.out.println("this is parent cons...");
    }
}

class Child extends Parent {

    public Child(){
        super(1);
    }

    public Child(Integer id){
        super(id);
    }
}