package com.heqin.proxy.cglib.cglibclassdemo.classbyte;

import java.lang.reflect.InvocationTargetException;

import com.heqin.proxy.dao.impl.UserDaoImpl;
import org.springframework.cglib.core.Signature;
import org.springframework.cglib.reflect.FastClass;

/**
 * @Desc 被代理类 {@link UserDaoImpl}的FastClass类
 * @Author heqin
 * @Date 2021/9/16 19:33
 */
public class UserDaoImpl$$FastClassByCGLIB$$5a00e205 extends FastClass {
    public UserDaoImpl$$FastClassByCGLIB$$5a00e205(Class var1) {
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
                break;
            case 1826985398:
                if (var10000.equals("equals(Ljava/lang/Object;)Z")) {
                    return 1;
                }
                break;
            case 1913648695:
                if (var10000.equals("toString()Ljava/lang/String;")) {
                    return 2;
                }
                break;
            case 1984935277:
                if (var10000.equals("hashCode()I")) {
                    return 3;
                }
        }

        return -1;
    }

    @Override
    public int getIndex(String var1, Class[] var2) {
        switch (var1.hashCode()) {
            case -1776922004:
                if (var1.equals("toString")) {
                    switch (var2.length) {
                        case 0:
                            return 2;
                    }
                }
                break;
            case -1295482945:
                if (var1.equals("equals")) {
                    switch (var2.length) {
                        case 1:
                            if (var2[0].getName().equals("java.lang.Object")) {
                                return 1;
                            }
                    }
                }
                break;
            case -296117516:
                if (var1.equals("updateName")) {
                    switch (var2.length) {
                        case 0:
                            return 0;
                    }
                }
                break;
            case 147696667:
                if (var1.equals("hashCode")) {
                    switch (var2.length) {
                        case 0:
                            return 3;
                    }
                }
        }

        return -1;
    }

    @Override
    public int getIndex(Class[] var1) {
        switch (var1.length) {
            case 0:
                return 0;
            default:
                return -1;
        }
    }

    @Override
    public Object invoke(int paramInt, Object paramObject, Object[] paramArrayOfObject) throws InvocationTargetException {
        try {
            switch (paramInt) {
                case 0:
                    ((UserDaoImpl) paramObject).updateName();
                    return null;
                case 1:
                    return new Boolean(((UserDaoImpl) paramObject).equals(paramArrayOfObject[0]));
                case 2:
                    return ((UserDaoImpl) paramObject).toString();
                case 3:
                    return new Integer(((UserDaoImpl) paramObject).hashCode());
            }
        } catch (Throwable throwable) {
            throw new InvocationTargetException(null);
        }
        throw new IllegalArgumentException("Cannot find matching method/constructor");
    }

    @Override
    public Object newInstance(int paramInt, Object[] paramArrayOfObject) throws InvocationTargetException {
        try {
            switch (paramInt) {
                case 0:
                    return new UserDaoImpl();
            }
        } catch (Throwable throwable) {
            throw new InvocationTargetException(null);
        }
        throw new IllegalArgumentException("Cannot find matching method/constructor");
    }

    @Override
    public int getMaxIndex() {
        return 3;
    }
}
