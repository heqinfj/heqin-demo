package com.heqin.yourbatman.javavariableexeorder.case3;

import lombok.Getter;

/**
 * @Desc case3
 * @Author heqin
 * @Date 2021/9/27 17:11
 * 输出结果：
 * Parent的静态块
 * Child的静态块
 * Parent的构造块
 * Parent的构造方法
 * Child的构造块
 * Child的构造方法
 * <p>
 * Tips：构造代码块优先于构造方法执行，且优先于属性初始化之前执行  -- “优先于属性初始化之前执行”现有觉得有问题，不要此句！
 * @PostConstruct是对象的属性都初始化ok了之后才去执行的（注意你new的话，@PostConstruct方法是不会执行的，他是Spring给与的支持哦~）
 *
 * 值得注意的是，此处子类没有显示调用super()，但父类的构造还是执行了的。但是，但是，但是，如果构造快为有参构造，请记得显示调用super方法，
 * 否则父类是不能被初始化的。如果子类的构造器没有显示地调用超类的构造器，则将自动调用超类默认（没有参数） 的构造器。如果超类没有不带参数的构造器，
 * 并且在子类的构造器又没有显式地调用超类的其他构造器，则 java 编译器将报告错误~
 *
 */
public class Main {
    public static void main(String[] args) {
        new Child();
    }
}

@Getter
class Child extends Parent {

    Child() {
        System.out.println("Child的构造方法");
    }

    {
        System.out.println("Child的构造块");
    }

    static {
        System.out.println("Child的静态块");
    }
}

@Getter
class Parent {
    Integer age = 18;

    static {
        System.out.println("Parent的静态块");
    }

    {
        System.out.println(age);
        System.out.println("Parent的构造块");
    }

    Parent() {
        System.out.println("Parent的构造方法");
    }
}