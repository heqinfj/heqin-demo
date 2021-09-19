package com.heqin.proxy.cglib.cglibclassdemo.classbyte;

import java.lang.reflect.Method;

import com.heqin.proxy.dao.impl.UserDaoImpl;
//springframework直接将cglib的代码集成进来
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.cglib.core.Signature;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Factory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @Desc 代理类，cglib实现被代理类 {@link UserDaoImpl}
 * @Author heqin
 * @Date 2021/9/16 19:30
 */
public class UserDaoImpl$$EnhancerByCGLIB$$e4871da2 extends UserDaoImpl implements Factory {
    private boolean CGLIB$BOUND;
    public static Object CGLIB$FACTORY_DATA;
    private static ThreadLocal CGLIB$THREAD_CALLBACKS;
    private static Callback[] CGLIB$STATIC_CALLBACKS;
    private MethodInterceptor CGLIB$CALLBACK_0;
    private static Object CGLIB$CALLBACK_FILTER;
    private static Method CGLIB$updateName$0$Method;
    private static MethodProxy CGLIB$updateName$0$Proxy;
    private static Object[] CGLIB$emptyArgs;
    private static Method CGLIB$equals$1$Method;
    private static MethodProxy CGLIB$equals$1$Proxy;
    private static Method CGLIB$toString$2$Method;
    private static MethodProxy CGLIB$toString$2$Proxy;
    private static Method CGLIB$hashCode$3$Method;
    private static MethodProxy CGLIB$hashCode$3$Proxy;
    private static Method CGLIB$clone$4$Method;
    private static MethodProxy CGLIB$clone$4$Proxy;

    static void CGLIB$STATICHOOK1() throws ClassNotFoundException {
        CGLIB$THREAD_CALLBACKS = new ThreadLocal();
        CGLIB$emptyArgs = new Object[0];
        Class var0 = Class.forName("com.heqin.proxy.dao.impl.UserDaoImpl$$EnhancerByCGLIB$$e4871da2");
        Class var1;
        Method[] var10000 = ReflectUtils.findMethods(new String[]{"equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "clone", "()Ljava/lang/Object;"}, (var1 = Class.forName("java.lang.Object")).getDeclaredMethods());
        CGLIB$equals$1$Method = var10000[0];
        CGLIB$equals$1$Proxy = MethodProxy.create(var1, var0, "(Ljava/lang/Object;)Z", "equals", "CGLIB$equals$1");
        CGLIB$toString$2$Method = var10000[1];
        CGLIB$toString$2$Proxy = MethodProxy.create(var1, var0, "()Ljava/lang/String;", "toString", "CGLIB$toString$2");
        CGLIB$hashCode$3$Method = var10000[2];
        CGLIB$hashCode$3$Proxy = MethodProxy.create(var1, var0, "()I", "hashCode", "CGLIB$hashCode$3");
        CGLIB$clone$4$Method = var10000[3];
        CGLIB$clone$4$Proxy = MethodProxy.create(var1, var0, "()Ljava/lang/Object;", "clone", "CGLIB$clone$4");
        CGLIB$updateName$0$Method = ReflectUtils.findMethods(new String[]{"updateName", "()V"}, (var1 = Class.forName("com.heqin.proxy.dao.impl.UserDaoImpl")).getDeclaredMethods())[0];
        CGLIB$updateName$0$Proxy = MethodProxy.create(var1, var0, "()V", "updateName", "CGLIB$updateName$0");
    }

    final void CGLIB$updateName$0() {
        super.updateName();
    }

    @Override
    public final void updateName() {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        if (var10000 != null) {
            try {
                //回调
                var10000.intercept(this, CGLIB$updateName$0$Method, CGLIB$emptyArgs, CGLIB$updateName$0$Proxy);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        } else {
            super.updateName();
        }
    }

    final boolean CGLIB$equals$1(Object var1) {
        return super.equals(var1);
    }

    @Override
    public final boolean equals(Object var1) {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        if (var10000 != null) {
            Object var2 = null;
            try {
                var2 = var10000.intercept(this, CGLIB$equals$1$Method, new Object[]{var1}, CGLIB$equals$1$Proxy);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return var2 == null ? false : (Boolean) var2;
        } else {
            return super.equals(var1);
        }
    }

    final String CGLIB$toString$2() {
        return super.toString();
    }

    @Override
    public final String toString() {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        try {
            return var10000 != null ? (String) var10000.intercept(this, CGLIB$toString$2$Method, CGLIB$emptyArgs, CGLIB$toString$2$Proxy) : super.toString();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    final int CGLIB$hashCode$3() {
        return super.hashCode();
    }

    @Override
    public final int hashCode() {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        if (var10000 != null) {
            Object var1 = null;
            try {
                var1 = var10000.intercept(this, CGLIB$hashCode$3$Method, CGLIB$emptyArgs, CGLIB$hashCode$3$Proxy);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return var1 == null ? 0 : ((Number) var1).intValue();
        } else {
            return super.hashCode();
        }
    }

    final Object CGLIB$clone$4() throws CloneNotSupportedException {
        return super.clone();
    }

    protected final Object clone() throws CloneNotSupportedException {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        try {
            return var10000 != null ? var10000.intercept(this, CGLIB$clone$4$Method, CGLIB$emptyArgs, CGLIB$clone$4$Proxy) : super.clone();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MethodProxy CGLIB$findMethodProxy(Signature var0) {
        String var10000 = var0.toString();
        switch (var10000.hashCode()) {
            case -508378822:
                if (var10000.equals("clone()Ljava/lang/Object;")) {
                    return CGLIB$clone$4$Proxy;
                }
                break;
            case 225946625:
                if (var10000.equals("updateName()V")) {
                    return CGLIB$updateName$0$Proxy;
                }
                break;
            case 1826985398:
                if (var10000.equals("equals(Ljava/lang/Object;)Z")) {
                    return CGLIB$equals$1$Proxy;
                }
                break;
            case 1913648695:
                if (var10000.equals("toString()Ljava/lang/String;")) {
                    return CGLIB$toString$2$Proxy;
                }
                break;
            case 1984935277:
                if (var10000.equals("hashCode()I")) {
                    return CGLIB$hashCode$3$Proxy;
                }
        }

        return null;
    }

    public UserDaoImpl$$EnhancerByCGLIB$$e4871da2() {
        CGLIB$BIND_CALLBACKS(this);
    }

    public static void CGLIB$SET_THREAD_CALLBACKS(Callback[] var0) {
        CGLIB$THREAD_CALLBACKS.set(var0);
    }

    public static void CGLIB$SET_STATIC_CALLBACKS(Callback[] var0) {
        CGLIB$STATIC_CALLBACKS = var0;
    }

    private static final void CGLIB$BIND_CALLBACKS(Object var0) {
        UserDaoImpl$$EnhancerByCGLIB$$e4871da2 var1 = (UserDaoImpl$$EnhancerByCGLIB$$e4871da2) var0;
        if (!var1.CGLIB$BOUND) {
            var1.CGLIB$BOUND = true;
            Object var10000 = CGLIB$THREAD_CALLBACKS.get();
            if (var10000 == null) {
                var10000 = CGLIB$STATIC_CALLBACKS;
                if (var10000 == null) {
                    return;
                }
            }

            var1.CGLIB$CALLBACK_0 = (MethodInterceptor) ((Callback[]) var10000)[0];
        }

    }

    @Override
    public Object newInstance(Callback[] var1) {
        CGLIB$SET_THREAD_CALLBACKS(var1);
        UserDaoImpl$$EnhancerByCGLIB$$e4871da2 var10000 = new UserDaoImpl$$EnhancerByCGLIB$$e4871da2();
        CGLIB$SET_THREAD_CALLBACKS((Callback[]) null);
        return var10000;
    }

    @Override
    public Object newInstance(Callback var1) {
        CGLIB$SET_THREAD_CALLBACKS(new Callback[]{var1});
        UserDaoImpl$$EnhancerByCGLIB$$e4871da2 var10000 = new UserDaoImpl$$EnhancerByCGLIB$$e4871da2();
        CGLIB$SET_THREAD_CALLBACKS((Callback[]) null);
        return var10000;
    }

    @Override
    public Object newInstance(Class[] var1, Object[] var2, Callback[] var3) {
        CGLIB$SET_THREAD_CALLBACKS(var3);
        UserDaoImpl$$EnhancerByCGLIB$$e4871da2 var10000 = new UserDaoImpl$$EnhancerByCGLIB$$e4871da2();
        switch (var1.length) {
            case 0:
                CGLIB$SET_THREAD_CALLBACKS((Callback[]) null);
                return var10000;
            default:
                throw new IllegalArgumentException("Constructor not found");
        }
    }

    @Override
    public Callback getCallback(int var1) {
        CGLIB$BIND_CALLBACKS(this);
        MethodInterceptor var10000;
        switch (var1) {
            case 0:
                var10000 = this.CGLIB$CALLBACK_0;
                break;
            default:
                var10000 = null;
        }

        return var10000;
    }

    @Override
    public void setCallback(int var1, Callback var2) {
        switch (var1) {
            case 0:
                this.CGLIB$CALLBACK_0 = (MethodInterceptor) var2;
            default:
        }
    }

    @Override
    public Callback[] getCallbacks() {
        CGLIB$BIND_CALLBACKS(this);
        return new Callback[]{this.CGLIB$CALLBACK_0};
    }

    @Override
    public void setCallbacks(Callback[] var1) {
        this.CGLIB$CALLBACK_0 = (MethodInterceptor) var1[0];
    }

    static {
        try {
            CGLIB$STATICHOOK1();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
