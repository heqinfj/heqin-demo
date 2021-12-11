package com.heqin.proxy.jdk.jdkclassdemo;

import com.heqin.proxy.dao.UserDao;
import com.heqin.proxy.jdk.JdkDynamicProxyHelperByJava8Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 利用类{@link JdkDynamicProxyHelperByJava8Test}得到的JDK动态代理生成的class文件（JDKProxyUserDao.class）
 * @Author heqin
 * @Date 2021/9/16 10:30
 */
public final class JDKProxyUserDao extends Proxy implements UserDao {
    private static Method m1;
    private static Method m2;
    private static Method m3;
    private static Method m0;

    public JDKProxyUserDao(InvocationHandler var1) throws UndeclaredThrowableException {
        super(var1);
    }

    public final boolean equals(Object var1) throws UndeclaredThrowableException {
        try {
            return (Boolean) super.h.invoke(this, m1, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    public final String toString() throws UndeclaredThrowableException {
        try {
            return (String) super.h.invoke(this, m2, (Object[]) null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    @Override
    public final void updateName() throws UndeclaredThrowableException {
        try {
            super.h.invoke(this, m3, (Object[]) null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final int hashCode() throws UndeclaredThrowableException {
        try {
            return (Integer) super.h.invoke(this, m0, (Object[]) null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m2 = Class.forName("java.lang.Object").getMethod("toString");
            m3 = Class.forName("com.heqin.proxy.dao.UserDao").getMethod("updateName");
            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }
}
