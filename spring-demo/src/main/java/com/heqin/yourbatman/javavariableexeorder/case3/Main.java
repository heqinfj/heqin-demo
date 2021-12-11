package com.heqin.yourbatman.javavariableexeorder.case3;

import lombok.Getter;

/**
 * @Desc case3
 * @Author heqin
 * @Date 2021/9/27 17:11
 * 输出结果：
 * Parent的静态块
 * Child的静态块
 * 初始Parent的成员变量age为38
 * Parent的构造块
 * Parent的构造方法
 * Child的构造块,这里取到的age值为null
 * 初始Child的成员变量age为18
 * Child的构造方法
 * parent.age的值为38
 * parent.getAge()的值为18
 * <p>
 * Tips：构造代码块优先于构造方法执行，且优先于属性初始化之前执行  -- “优先于属性初始化之前执行”现有觉得有问题，不要此句！
 * @PostConstruct是对象的属性都初始化ok了之后才去执行的（注意你new的话，@PostConstruct方法是不会执行的，他是Spring给与的支持哦~） 值得注意的是，此处子类没有显示调用super()，但父类的构造还是执行了的。但是，但是，但是，如果构造快为有参构造，请记得显示调用super方法，
 * 否则父类是不能被初始化的。如果子类的构造器没有显示地调用超类的构造器，则将自动调用超类默认（没有参数） 的构造器。如果超类没有不带参数的构造器，
 * 并且在子类的构造器又没有显式地调用超类的其他构造器，则 java 编译器将报告错误~
 */
public class Main {
    public static void main(String[] args) {
        Parent parent = new Child();
        //难点：父类和子类有同名同类型的属性时；
        System.out.println(String.format("parent.age的值为%s", parent.age));//38
        System.out.println(String.format("parent.getAge()的值为%s", parent.getAge()));//18
        /**
         * 其实这就是Java的继承机制，对此说明如下：
         * 1. 属性属于实例自己的，所以Parent的age属性值是38，这就解释通了
         * 2. 属性不存在覆盖（即使同名），而方法是实实在在的覆盖（复写）。所以你调用getAge()方法返回的100%是18
         */
    }
}

@Getter
class Child extends Parent {

    public Child() {
        System.out.println("Child的构造方法");
    }

    /**
     * 故意将方法块代码放在成员变量age初始化之前，以便验证：
     * 成员变量与方法块哪个先执行，取决于他们的位置先后，位置在前的则先执行；
     */
    {
        System.out.println(String.format("Child的构造块,这里取到的age值为%s", this.age));
    }

    public Integer age = initAge();

    private int initAge() {
        int defaultAge = 18;
        System.out.println(String.format("初始Child的成员变量age为%s", defaultAge));
        return defaultAge;
    }


//    {
//        System.out.println("Child的构造块");
//    }

    static {
        System.out.println("Child的静态块");
    }


}

@Getter
class Parent {

    /**
     * 故意将构造函数放在前面位置；为了验证【成员变量与方法块加载优先于构造函数】
     */
    Parent() {
        System.out.println("Parent的构造方法");
    }

    public Integer age = initAge();

    private int initAge() {
        int defaultAge = 38;
        System.out.println(String.format("初始Parent的成员变量age为%s", defaultAge));
        return defaultAge;
    }


    static {
        System.out.println("Parent的静态块");
    }

    {
        System.out.println("Parent的构造块");
    }
}