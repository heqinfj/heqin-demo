package com.heqin.proxy.jdk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.heqin.proxy.dao.UserDao;
import com.heqin.proxy.dao.impl.UserDaoImpl;
import org.junit.Before;
import org.junit.Test;
import sun.misc.ProxyGenerator;

/**
 * jdk动态代理生成class文件工具类的示例
 *
 * @Author heqin
 * @Date 2021/9/16 10:38
 */
public class JdkDynamicProxyHelperTest {

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
            System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
            //当前还不知道生成的文件具体是在哪个路径下？
        } else {
            FileOutputStream outputStream = null;
            byte[] bytes = ProxyGenerator.generateProxyClass("JDKProxyUserDao", new Class[]{UserDao.class});
            try {
                String interfaceName = ((Class) interfaceClass).getName();
                String shortName = interfaceName.substring(interfaceName.lastIndexOf(".") + 1);
                String fileOutputStreamPath = filePath[0] + JDK_PROXY_CLASS_FILE_PREFIX + shortName + JDK_PROXY_CLASS_FILE_SUFFIX;
                outputStream = new FileOutputStream(fileOutputStreamPath);
                outputStream.write(bytes);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Before
    public void initFileOutputPath() {
        File file = new File(DEFAULT_FILE_OUTPUT_STREAM_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

//    @Test
//    public void jdkProxy() throws Exception {
//        byte[] bytes = ProxyGenerator.generateProxyClass("JDKProxyUserDao", new Class[]{UserDao.class});
//        FileOutputStream outputStream = new FileOutputStream(new File("E:\\proxy\\jdk\\JDKProxyUserDao.class"));
//        outputStream.write(bytes);
//        outputStream.flush();
//        outputStream.close();
//    }

    @Test
    public void createUserDaoProxy() {
        saveJdkProxyFile(UserDao.class, DEFAULT_FILE_OUTPUT_STREAM_PATH);
        //saveJdkProxyFile(UserDao.class);

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
