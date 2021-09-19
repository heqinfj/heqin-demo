package com.heqin.javabase;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc 体味回调的魅力
 * @Author heqin
 * @Date 2021/9/18 11:24
 */
public class CallbackExample {

    private static String DIVIDING_LINE = new String("====================================================================");

    @Test
    public void methodCallback() {
        //Class<?> clazz = Animal.class;
        Class<?> clazz = Mammal.class;
        List<Method> filteredMethods = new ArrayList<>();
        doWithMethods(clazz, method -> {
            if (method.getName().contains("Method")) {
                filteredMethods.add(method);
            }
        });
        System.out.println(DIVIDING_LINE);
        System.out.println("filteredMethods：    ");
        System.out.println(DIVIDING_LINE);
        filteredMethods.stream().forEach(method -> System.out.println(method));
    }

    private void doWithMethods(Class<?> clazz, MethodCallback methodCallback) {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Method[] publicMethods = clazz.getMethods();
        for (Method method : declaredMethods) {
            try {
                methodCallback.doWith(method);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for (Method method : publicMethods) {
            try {
                methodCallback.doWith(method);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println(DIVIDING_LINE);
        System.out.println("declaredMethods：    ");
        System.out.println(DIVIDING_LINE);
        Arrays.stream(declaredMethods).forEach(declaredMethod -> System.out.println(declaredMethod));
        System.out.println(DIVIDING_LINE);
        System.out.println("publicMethods：      ");
        System.out.println(DIVIDING_LINE);
        Arrays.stream(publicMethods).forEach(publicMethod -> System.out.println(publicMethod));
    }

    /**
     * Action to take on each method.
     */
    @FunctionalInterface
    public interface MethodCallback {

        /**
         * Perform an operation using the given method.
         *
         * @param method the method to operate on
         */
        void doWith(Method method) throws IllegalArgumentException, IllegalAccessException;
    }

    /**
     * Animal
     * 动物
     */
    abstract class Animal {

        private String name;

        private int weight;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        abstract public void move();

        abstract public void enjoy();

        public void publicMethod() {
            System.out.println("public 方法。。。");
        }

        protected void protectedMethod() {
            System.out.println("protected 方法。。。");
        }

        void defaultPackageAccessMethod() {
            System.out.println("default (package)access 方法。。。");
        }

        private void privateMethod() {
            System.out.println("private 方法。。。");
        }

    }

    /**
     * Mammal
     * 哺乳动物
     */
    class Mammal extends Animal {
        /**
         * 毛发颜色
         */
        private String hairColor;

        public String getHairColor() {
            return hairColor;
        }

        public void setHairColor(String hairColor) {
            this.hairColor = hairColor;
        }

        @Override
        public void move() {

        }

        @Override
        public void enjoy() {

        }

    }
}
