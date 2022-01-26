package com.heqin.javabase.parentsdelegation;

import org.junit.Test;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * ClassLoader 类加载器
 *
 * [Tomcat 源码分析 WebappClassLoader 分析 (基于8.0.5)](https://www.jianshu.com/p/269f60fa481e)
 *
 * @Author heqin
 * @Date 2022/1/19 15:54
 */
public class ClassLoaderTest {

    @Test
    public void testBootstrapClassLoader() {
        //加载路径
        System.out.println(System.getProperty("sun.boot.class.path"));
        //手动获取加载路径
        System.out.println(Arrays.asList(sun.misc.Launcher.getBootstrapClassPath().getURLs()));
    }

    @Test
    public void testExtClassLoader() {
        System.out.println(System.getProperty("java.ext.dirs"));
        URL[] urLs = ((URLClassLoader) ClassLoaderTest.class.getClassLoader().getParent()).getURLs();
        System.out.println(Arrays.asList(urLs));
    }

    @Test
    public void testAppClassLoader() {
        System.out.println(System.getProperty("java.class.path"));
        URL[] urLs = ((URLClassLoader) ClassLoaderTest.class.getClassLoader()).getURLs();
        System.out.println(Arrays.asList(urLs));
    }

    @Test
    public void test() {
        System.out.println(ClassLoaderTest.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
