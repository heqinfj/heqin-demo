package com.heqin.proxy.jdk;

import com.heqin.proxy.dao.UserDao;
import com.heqin.proxy.dao.impl.UserDaoImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetSystemProperty;
//import org.junit.Test;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理生成class文件工具类的示例
 * <p>
 * https://www.cnblogs.com/throwable/p/12272262.html
 *
 * @Author heqin
 * @Date 2021/9/16 10:38
 */
public class JdkDynamicProxyHelperByJava11Test {

    private static String JDK_PROXY_CLASS_FILE_PREFIX = "JDKProxy";

    private static String JDK_PROXY_CLASS_FILE_SUFFIX = ".class";

    private static String DEFAULT_FILE_OUTPUT_STREAM_PATH = "E:\\proxy\\jdk\\";

    /**
     * 生成jdk动态代理文件
     *
     * @param interfaceClass
     * @param filePath
     * @param <T>
     */
    private <T> void saveJdkProxyFile(T interfaceClass, String... filePath) {
        if (filePath.length == 0) {
            System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        }
        System.out.println("jdk.proxy.ProxyGenerator.saveGeneratedFiles的值：" + System.getProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles"));
    }

    private void enableSaveGeneratedFiles() {
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
    }

    @Before
    public void initFileOutputPath() {
        File file = new File(DEFAULT_FILE_OUTPUT_STREAM_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 方法1：main方法启动
     * <p>
     * System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
     *
     * @param args
     */
    public static void main(String[] args) {
        JdkDynamicProxyHelperByJava11Test jt = new JdkDynamicProxyHelperByJava11Test();
        jt.enableSaveGeneratedFiles();
        jt.createUserDaoProxy();
    }

    /**
     * 方法2：@Test启动
     * 如果要用System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");来生成jdk动态代理所生成的.class文件
     * - 不要 在 JUnit 的单元测试方法中写测试代码  ProxyGenerator类的saveGeneratedFiles属性仍为false
     * https://www.freesion.com/article/6847322754/
     * https://icode.best/i/47048633143084
     * - 如果想要生成则直接通过idea设置 -》Edit Configurations -》Add VM options -》-Djdk.proxy.ProxyGenerator.saveGeneratedFiles=true
     */
    @Test
    @SetSystemProperty(key = "jdk.proxy.ProxyGenerator.saveGeneratedFiles", value = "true")
    public void createUserDaoProxy() {
        System.out.println("jdk.proxy.ProxyGenerator.saveGeneratedFiles的值：" + System.getProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles"));
        UserDao targetUserDao = new UserDaoImpl();
        Class<?> proxyClass = Proxy.getProxyClass(targetUserDao.getClass().getClassLoader(), targetUserDao.getClass().getInterfaces());
        InvocationHandler invocationHandler = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("invoke before...");
                Object invokeResult = method.invoke(targetUserDao, args);
                System.out.println("invoke after...");
                return invokeResult;
            }
        };
        try {
            UserDao proxyUserDao = (UserDao) proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler);
            proxyUserDao.updateName();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
