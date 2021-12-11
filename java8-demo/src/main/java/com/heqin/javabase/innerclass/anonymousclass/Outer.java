package com.heqin.javabase.innerclass.anonymousclass;

/**
 * 内部类
 * <p>
 * 观察asyncHello()方法，我们在方法内部实例化了一个Runnable。Runnable本身是接口，接口是不能实例化的，所以这里实际上是定义了一个实现了Runnable接口的匿名类，
 * 并且通过new实例化该匿名类，然后转型为Runnable。在定义匿名类的时候就必须实例化它，定义匿名类的写法如下：
 * <p>
 * Runnable r = new Runnable() {
 * // 实现必要的抽象方法...
 * };
 * 匿名类和Inner Class一样，可以访问Outer Class的private字段和方法。之所以我们要定义匿名类，是因为在这里我们通常不关心类名，比直接定义Inner Class可以少写很多代码。
 * <p>
 * 观察Java编译器编译后的.class文件可以发现，Outer类被编译为Outer.class，而匿名类被编译为Outer$1.class。
 * 如果有多个匿名类，Java编译器会将每个匿名类依次命名为Outer$1、Outer$2、Outer$3……
 *
 * @Author heqin
 * @Date 2021/10/1 1:55
 */
class Outer {

    private String name;

    Outer(String name) {
        this.name = name;
    }

    /**
     * 异步hello
     */
    void asyncHello() {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello, " + Outer.this.name);
//            }
//        };
        //lambda写法
        Runnable runnable = () -> System.out.println("Hello, " + Outer.this.name);
        new Thread(runnable).start();
    }
}
