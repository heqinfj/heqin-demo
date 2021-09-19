package com.heqin.proxy.cglib;

import com.heqin.proxy.dao.UserDao;
import com.heqin.proxy.dao.impl.UserDaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.io.File;

/**
 * @Desc 代理接口
 * @Author heqin
 * @Date 2021/9/16 14:45
 */
public class CglibDynamicProxyHelper4InterfaceTest {

    /**
     * Class文件保存路径
     */
    private static String DEBUG_LOCATION_PROPERTY = "E:\\proxy\\cglib";

    @Before
    public void initDebugLocationProperty() {
        File file = new File(DEBUG_LOCATION_PROPERTY);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @Test
    public void cgLibProxy() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, DEBUG_LOCATION_PROPERTY);

        UserDao targetUserDao = new UserDaoImpl();
        Enhancer enhancer = new Enhancer();
        // 代理接口
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, methodProxy) -> {
            System.out.println("Before");
            //执行被代理类的目标方法，如果被代理的是接口则不能执行该方法。 --> java.lang.NoSuchMethodError: java.lang.Object.updateName()V
            //methodProxy.invokeSuper(obj, args);

            //调整为invoke 并且第一个入参为目标对象targetUserDao
            methodProxy.invoke(targetUserDao,args);
            //methodProxy ——> method也可以，需要研究有什么区别？
            //method.invoke(targetUserDao,args);

            System.out.println("After");
            return null;
        });
        Object object = enhancer.create();
        if(object instanceof UserDao){
            UserDao userDao = (UserDao)object;
            userDao.updateName();
        }
    }
}
