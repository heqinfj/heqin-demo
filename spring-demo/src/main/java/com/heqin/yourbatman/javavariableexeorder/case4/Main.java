package com.heqin.yourbatman.javavariableexeorder.case4;

import lombok.Getter;
import lombok.Setter;

/**
 * @Desc case4：子类和父类有同名同类型的静态变量的时候
 * 结论就不用解释了：静态变量属于类的，和继承无关。
 * @Author heqin
 * @Date 2021/9/27 16:49
 */
public class Main {
    public static void main(String[] args) {
        // 使用多态
        Parent chidParent = new Child();
        System.out.println("Parent:" + chidParent.age); //18 这个结果你能接受吗？哈哈

        // 直接使用原本类型
        Child child = new Child();
        System.out.println("Child:" + child.age); //40
    }
}

@Getter
@Setter
class Child extends Parent {
    public static Integer age = 40;
}

@Getter
@Setter
class Parent {
    static Integer age = 18;
}
