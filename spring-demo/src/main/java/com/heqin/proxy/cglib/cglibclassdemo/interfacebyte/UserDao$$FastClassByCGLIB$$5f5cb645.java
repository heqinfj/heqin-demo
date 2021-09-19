package com.heqin.proxy.cglib.cglibclassdemo.interfacebyte;

import java.lang.reflect.InvocationTargetException;

import com.heqin.proxy.dao.UserDao;
import org.springframework.cglib.core.Signature;
import org.springframework.cglib.reflect.FastClass;

/**
 * @Desc 被代理类 {@link UserDao}的FastClass类
 * @Author heqin
 * @Date 2021/9/16 19:07
 */
public class UserDao$$FastClassByCGLIB$$5f5cb645 extends FastClass {
    public UserDao$$FastClassByCGLIB$$5f5cb645(Class var1) {
        super(var1);
    }

    @Override
    public int getIndex(Signature var1) {
        String var10000 = var1.toString();
        switch (var10000.hashCode()) {
            case 225946625:
                if (var10000.equals("updateName()V")) {
                    return 0;
                }
        }

        return -1;
    }

    @Override
    public int getIndex(String var1, Class[] var2) {
        switch (var1.hashCode()) {
            case -296117516:
                if (var1.equals("updateName")) {
                    switch (var2.length) {
                        case 0:
                            return 0;
                    }
                }
        }

        return -1;
    }

    @Override
    public int getIndex(Class[] var1) {
        int var10001 = var1.length;
        return -1;
    }

    @Override
    public Object invoke(int var1, Object var2, Object[] var3) throws InvocationTargetException {
        UserDao var10000 = (UserDao) var2;
        int var10001 = var1;

        try {
            switch (var10001) {
                case 0:
                    var10000.updateName();
                    return null;
            }
        } catch (Throwable var4) {
            throw new InvocationTargetException(var4);
        }

        throw new IllegalArgumentException("Cannot find matching method/constructor");
    }

    @Override
    public Object newInstance(int var1, Object[] var2) throws InvocationTargetException {
        //new UserDao;
        throw new IllegalArgumentException("Cannot find matching method/constructor");
    }

    @Override
    public int getMaxIndex() {
        return 0;
    }
}

