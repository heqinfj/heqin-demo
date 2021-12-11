package com.heqin.javabase.generictypes.learnjavatype02_good;

import java.lang.reflect.Type;

/**
 * @Author heqin
 * @Date 2021/12/11 8:17
 */
public class TypeInfoUtils {

    public static String getTypeInfo(Type type) {
        String typeName = type.getTypeName();//返回：描述此类型的字符串
        Class<?> clazz = type.getClass();//返回：表示此对象的运行时类的Class对象。
        //clazz.toString();
        Class<?>[] interfaces = clazz.getInterfaces();
        StringBuilder typeInterface = new StringBuilder();
        int i = 1;
        for (Class<?> clazzType : interfaces) {
            typeInterface.append(clazzType.getSimpleName());
            if (i++ < interfaces.length) {
                typeInterface.append(",");
            }
        }
        //return "【" + typeName + "】    【" + clazz.getSimpleName() + "】    【" + typeInterface + "】";
        //return "【" + typeName + "】    【" + clazz.getName() + "】    【" + typeInterface + "】";
        return "【" + typeName + "】    【" + clazz + "】    【" + typeInterface + "】";
    }
}
