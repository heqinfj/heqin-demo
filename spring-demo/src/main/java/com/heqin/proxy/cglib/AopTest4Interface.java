package com.heqin.proxy.cglib;

import com.heqin.proxy.UserDao;
import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class AopTest4Interface {

    @Test
    public void cgLibProxy() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\proxy\\cglib"); // Class 文件保存路径

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class); // 代理接口
        // enhancer.setSuperclass(UserDaoImpl.class); // 代理类
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("Before");
            // methodProxy.invokeSuper(o, objects); // 执行被代理类的目标方法，如果被代理的是接口则不能执行该方法。
            System.out.println("After");
            return null;
        });
        Object userDao = enhancer.create();
    }
}
