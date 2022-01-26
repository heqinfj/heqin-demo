package com.heqin.javabase.parentsdelegation.neo;

import org.junit.Test;

/**
 * [Jvm 系列(一):Java 类的加载机制](http://www.ityouknow.com/jvm/2017/08/19/class-loading-principle.html)
 * Class.forName()和ClassLoader.loadClass()区别
 * - `Class.forName()`：将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块；
 * - `ClassLoader.loadClass()`：只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。
 * - `Class.forName(name, initialize, loader)`带参函数也可控制是否加载static块。并且只有调用了newInstance()方法采用调用构造函数，创建类的对象 。
 *
 * @Author heqin
 * @Date 2022/1/20 14:52
 */
public class LoaderTest {

    public static final String TEST_CLASS_NAME = "com.heqin.javabase.parentsdelegation.neo.Test12";

    @Test
    public void testClassLoaderLoadClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassLoader loader = HelloWorld.class.getClassLoader();
        System.out.println(loader);
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
        Class<?> aClass = loader.loadClass(TEST_CLASS_NAME);
        Object o = aClass.newInstance();
        Test12 test12 = Test12.class.cast(o);
        System.out.println(test12);
    }

    @Test
    public void testClassForName() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassLoader loader = HelloWorld.class.getClassLoader();
        System.out.println(loader);
        //使用Class.forName()来加载类，默认会执行初始化块
        Class<?> aClass = Class.forName(TEST_CLASS_NAME);
        System.out.println(aClass);
        Object o = aClass.newInstance();
        Test12 test12 = Test12.class.cast(o);
        System.out.println(test12);
    }

    @Test
    public void testClassForNameAnd2ClassLoader() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassLoader loader = HelloWorld.class.getClassLoader();
        System.out.println(loader);
        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
        Class<?> aClass = Class.forName(TEST_CLASS_NAME, false, loader);
        Object o = aClass.newInstance();
        Test12 test12 = Test12.class.cast(o);
        System.out.println(test12);
    }
}
