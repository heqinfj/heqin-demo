package com.heqin.yourbatman.javavariableexeorder.case3;

/**
 * @Author heqin
 * @Date 2021/9/27 17:33
 *
 * 结果：
 * 2
 * 3
 * a=110,b=0
 * 1
 * 4
 *
 * 答案五花八门，真正能答对这道题的小伙伴少之又少。从结果中，这里先给你扔个结论：
 *
 * 先初始化静态变量，也就是执行new StaticTest()，从而打印：2
 * 再执行构造函数，打印：3和a=110,b=0
 * 为何a=110，而b却为0呢？
 * 1. 执行构造函数之前，必须初始化实例属性，所以a=110
 * 2. 静态变量从上到下初始化，而st变量还没初始化完呢，所以b此时值为0
 * 执行紧跟着的静态代码块。打印：1
 * 执行静态方法staticFunction，打印：4
 * 从该结果你应该能知道：static变量可不是100%一定在实例变量之前被赋值（初始化哦~），比如本例的b就在a之后初始化了
 *
 * 原因：
 * 类的生命周期是：加载->验证->准备->解析->初始化->使用->卸载。
 *
 * 只有在准备阶段和初始化阶段才会涉及类变量的初始化和赋值，因此只针对这两个阶段进行分析；
 *
 * 类的准备阶段：需要做是为类变量（static变量）分配内存并设置默认值（注意此处都是先给默认值），因此类变量st为null、b为0；
 *
 * 需要注意的是，如果类变量是final的，编译时javac就会为它赋上值。因此上面如果我们这样写static final int b=112它哪怕在准备阶段，值就应该是112了
 *
 * 类的初始化阶段：需要做的是执行类构造器（请注意：这里不是指的构造函数）。
 *
 * 类构造器：编译器收集所有静态语句块和类变量的赋值语句，按语句在源码中的**顺序（请注意这三者是有序的）**合并生成类构造器
 *
 * 因此现在执行：st = new StaticTest().此时我们发现，就会进行对象的初始化了（看到没，这个时候b变量的赋值语句还没有执行哦~~~）
 *
 * 而对象初始化的顺序为：成员变量 -> 普通代码块 -> 构造函数，因此这一波过后：a=110了。
 * 输出为：
 *
 * 2
 * 3
 * a=110,b=0
 * 1
 * 2
 * 3
 * 需要注意的是，此时b仍然为0，并没有被赋值哦~
 *
 * 到此st = new StaticTest()这句就执行结束了。继续执行类构造器，显然就会执行static语句块了~~~输出1，最后调用静态方法，就输出4了 完美~
 *
 */
public class StaticTest {

    public static void main(String[] args) {
        staticFunction();
    }

    // 静态变量（有实例化的过程,这就是本题的重点）
    static StaticTest st = new StaticTest();

    static {
        //System.out.println(b); // 编译报错：因为b在构造代码块后边，此处不能引用。因此Java代码是从上到下的顺序
        System.out.println("1");
    }

    {
        //System.out.println(a);// 编译报错：因为a在构造代码块后边，此处不能引用。因此Java代码是从上到下的顺序
        System.out.println("2");
    }

    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    // 这两个变量写在最后面
    int a = 110;
    static int b = 112;
}
