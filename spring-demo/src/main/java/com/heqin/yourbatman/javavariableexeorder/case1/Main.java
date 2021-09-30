package com.heqin.yourbatman.javavariableexeorder.case1;

import lombok.Getter;
import lombok.Setter;

/**
 * @Desc case1：父类和子类有同名同类型的属性时
 * @Author heqin
 * @Date 2021/9/27 16:49
 *
 * 结论：
 * 我相信和最初的我一样，对Parent:18这个结果大吃一惊，what？其实这就是Java的继承机制，对此说明如下：
 *
 * 属性属于实例自己的，所以Parent的age属性值是18，这就解释通了
 * 属性不存在覆盖（即使同名），而方法是实实在在的覆盖（复写）。所以你调用getAge()方法返回的100%是40喽
 */
public class Main {
    public static void main(String[] args) {
        // 使用多态
        Parent chidParent = new Child();
        System.out.println("Parent:" + chidParent.getAge()); //40
        System.out.println("Parent:" + chidParent.age); //18 这个结果你能接受吗？哈哈

        // 直接使用原本类型
        Child child = new Child();
        System.out.println("Child:" + child.getAge()); //40
        System.out.println("Child:" + child.age); //40
    }
}

@Getter
@Setter
class Child extends Parent {
    public Integer age = 40;
}

@Getter
@Setter
class Parent {
    public Integer age = 18;
}
