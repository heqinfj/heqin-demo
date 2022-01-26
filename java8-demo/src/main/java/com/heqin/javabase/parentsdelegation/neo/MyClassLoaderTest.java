package com.heqin.javabase.parentsdelegation.neo;

/**
 * @Author heqin
 * @Date 2022/1/20 16:24
 */
public class MyClassLoaderTest {
    public static void main(String[] args) {
        MyClassLoader classLoader = new MyClassLoader();
        classLoader.setRoot("E:\\temp");

        Class<?> testClass;
        try {
            testClass = classLoader.loadClass("com.heqin.javabase.parentsdelegation.neo.Test2");
            Object object = testClass.newInstance();
            System.out.println(object.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
