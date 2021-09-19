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
 * @Desc 代理类
 * @Author heqin
 * @Date 2021/9/16 14:45
 */
public class CglibDynamicProxyHelper4ClassTest {

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
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, DEBUG_LOCATION_PROPERTY);
    }

    @Test
    public void cgLibProxy() {
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, DEBUG_LOCATION_PROPERTY);
        Enhancer enhancer = new Enhancer();
        UserDao targetUserDao = new UserDaoImpl();
        // 代理类
        enhancer.setSuperclass(UserDaoImpl.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, methodProxy) -> {
            System.out.println(method.getName());
            System.out.println("Before");
            //执行被代理类的目标方法，如果被代理的是接口则不能执行该方法。
            //methodProxy invokeSuper obj（obj为代理对象也叫增强对象）-> 断点进到invokeSuper中，调用的是代理类的FastClass类 -- 可行
            //methodProxy.invokeSuper(obj, args);

            //会发生java.lang.StackOverflowError - 异常
            //methodProxy.invoke(obj,args);

            //methodProxy invoke targetUserDao（目标对象） -> 断点进到invoke中，调用的是被代理类的FastClass类 -- 可行
            methodProxy.invoke(targetUserDao,args);

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
