package com.heqin.javabase.parentsdelegation;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ThreadContextClassLoader 线程上下文类加载器，存在于{@link java.lang.Thread} 中的属性contextClassLoader
 *
 * @Author heqin
 * @Date 2022/1/20 10:59
 */
public class ThreadContextClassLoaderTest {
    /**
     * [真正理解线程上下文类加载器（多案例分析）](https://blog.csdn.net/yangcheng33/article/details/52631940)
     * <p>
     * [老大难的 Java ClassLoader 再不理解就老了](https://zhuanlan.zhihu.com/p/51374915)
     * <p>
     * [《对线面试官》双亲委派机制](https://mp.weixin.qq.com/s/9mojzm8URjNRBg3r8BamdQ)
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void testMysqlJdbcDriver() throws ClassNotFoundException, SQLException {
        //Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        //System.out.println(aClass);
        String url = "jdbc:mysql://proxy.heqin.aliyun.com:6666/spring-webmvc?characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        System.out.println(connection);
        //以上就是mysql注册驱动及获取connection的过程，各位可以发现经常写的Class.forName被注释掉了，但依然可以正常运行，这是为什么呢？
        //这是因为从Java1.6开始自带的jdbc4.0版本已支持SPI服务加载机制，只要mysql的jar包在类路径中，就可以注册mysql驱动。
        //那到底是在哪一步自动注册了mysql driver的呢？重点就在DriverManager.getConnection()中。
        //我们都是知道调用类的静态方法会初始化该类，进而执行其静态代码块，DriverManager的静态代码块就是：
        //static {
        //    loadInitialDrivers();
        //    println("JDBC DriverManager initialized");
        //}
    }
}
