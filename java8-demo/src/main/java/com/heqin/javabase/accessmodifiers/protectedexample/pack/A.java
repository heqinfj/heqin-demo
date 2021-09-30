package com.heqin.javabase.accessmodifiers.protectedexample.pack;

/**
 * @Author heqin
 * @Date 2021/9/27 0:00
 */
public class A {
    /**
     * 1. https://www.javatpoint.com/access-modifiers
     * <br>
     * 2. https://www.geeksforgeeks.org/access-modifiers-java/
     * <br>
     * 3. https://www.tutorialspoint.com/java/java_access_modifiers.htm
     * <p>
     *
     * But msg method of this package is declared as protected,
     * so it can be accessed from outside the class only through inheritance.
     * <br>
     * 但是这个包的msg方法被声明为protected，所以只能通过继承从类外访问。
     * <p>
     *
     * Variables, methods, and constructors, which are declared protected in a superclass can be accessed
     * only by the subclasses in other package or any class within the package of the protected members' class.
     * </br>
     * 在超类中声明为 protected 的变量、方法和构造函数只能由其他包中的子类或受保护成员类的包内的任何类访问。
     * <p>
     */
    protected void msg() {
        System.out.println("Hello");
    }
}
