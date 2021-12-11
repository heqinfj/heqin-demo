package com.heqin.javabase.generictypes.learnjavatype02_good;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author heqin
 * @Date 2021/12/11 6:34
 */
public class ComprehensiveTest {

    public static void main(String[] args) throws NoSuchMethodException {
        new ComprehensiveTest().showType();
    }

    private void showType() throws NoSuchMethodException {
        // 注意 int.class 和 Integer.class 是不一样的(没有所谓的自动装箱、自动拆箱机制)，不能互用
        Class<?> clazz = List.class;
        Method method = ComprehensiveTest.class.getMethod("testType", int.class, Boolean.class, clazz, clazz, clazz, clazz, clazz, Map.class,UserVo.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes(); //按照方法参数声明顺序返回参数的 Type 数组
        int index = 1;
        for (Type type : genericParameterTypes) {
            System.out.println(String.format("方法%s第%s个参数：%s",method.getName(),index++,type));
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] types = parameterizedType.getActualTypeArguments(); //返回表示此类型【实际类型参数】的 Type 数组
                for (int i = 0; i < types.length; i++) {
                    System.out.println(String.format("  第%s个实际类型参数：%s",i,TypeInfoUtils.getTypeInfo(types[i])));
                }
            } else {
                System.out.println("  " + TypeInfoUtils.getTypeInfo(type));
            }
            System.out.println("");
        }
    }

//    private String getTypeInfo(Type type) {
//        String typeName = type.getTypeName();
//        Class<?> clazz = type.getClass();
//        Class<?>[] interfaces = clazz.getInterfaces();
//        StringBuilder typeInterface = new StringBuilder();
//        int i = 1;
//        for (Class<?> clazzType : interfaces) {
//            typeInterface.append(clazzType.getSimpleName());
//            if(i++ < interfaces.length){
//                typeInterface.append(",");
//            }
//        }
//        //return "【" + typeName + "】    【" + clazz.getSimpleName() + "】    【" + typeInterface + "】";
//        return "【" + typeName + "】    【" + clazz.getName() + "】    【" + typeInterface + "】";
//    }

    /**
     * @param i
     * @param b
     * @param a1
     * @param a2
     * @param a3
     * @param a4
     * @param a5
     * @param a6
     * @param userVo
     * @param <T>
     *
     * 利用【Show Decompile Code】工具，可看出signature（签名）的值为：
     * JavaP分栏看到的：
     * Signature: #105 // <T:Ljava/lang/Object;>(ILjava/lang/Boolean;Ljava/util/List<Ljava/lang/String;>;Ljava/util/List<Ljava/util/ArrayList<Ljava/lang/String;>;>;Ljava/util/List<TT;>;Ljava/util/List<+Ljava/lang/Number;>;Ljava/util/List<[Ljava/util/ArrayList<Ljava/lang/String;>;>;Ljava/util/Map<Ljava/lang/Boolean;Ljava/lang/Integer;>;Lcom/heqin/javabase/generictypes/learnjavatype02/Test$UserVo;)V
     * ByteCode分栏看到的：
     * signature <T:Ljava/lang/Object;>(ILjava/lang/Boolean;Ljava/util/List<Ljava/lang/String;>;Ljava/util/List<Ljava/util/ArrayList<Ljava/lang/String;>;>;Ljava/util/List<TT;>;Ljava/util/List<+Ljava/lang/Number;>;Ljava/util/List<[Ljava/util/ArrayList<Ljava/lang/String;>;>;Ljava/util/Map<Ljava/lang/Boolean;Ljava/lang/Integer;>;Lcom/heqin/javabase/generictypes/learnjavatype02/Test$UserVo;)V
     * 查看的结果是一样的，只是查看方式不同而已；
     */
    public <T> void testType(int i, Boolean b, List<String> a1, List<ArrayList<String>> a2, List<T> a3, //
                             List<? extends Number> a4, List<ArrayList<String>[]> a5, Map<Boolean, Integer> a6,UserVo userVo) {
    }

    //自定义类UserVo 内部类
    class UserVo{

    }

}