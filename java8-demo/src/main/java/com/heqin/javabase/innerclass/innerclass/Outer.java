package com.heqin.javabase.innerclass.innerclass;

/**
 * 内部类
 * <p>
 * 观察测试代码 {@link com.heqin.javabase.innerclass.innerclass.InnerClassTest} ，要实例化一个Inner，我们必须首先创建一个Outer的实例，然后，调用Outer实例的new来创建Inner实例：
 * <p>
 * Outer.Inner inner = outer.new Inner();
 * 这是因为Inner Class除了有一个this指向它自己，还隐含地持有一个Outer Class实例，可以用Outer.this访问这个实例。所以，实例化一个Inner Class不能脱离Outer实例。
 * <p>
 * Inner Class和普通Class相比，除了能引用Outer实例外，
 * 还有一个额外的“特权”，就是可以修改Outer Class的private字段，因为Inner Class的作用域在Outer Class内部，所以能访问Outer Class的private字段和方法。
 * <p>
 * 观察Java编译器编译后的.class文件可以发现，Outer类被编译为Outer.class，而Inner类被编译为Outer$Inner.class。
 *
 * @Author heqin
 * @Date 2021/10/1 1:33
 */
class Outer {
    private String name;

    Outer(String name) {
        this.name = name;
    }

    class Inner {
        void hello() {
            System.out.println("Hello," + Outer.this.name);
        }
    }
}
