package com.heqin.commonslang3;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * @Author heqin
 * @Date 2021/9/30 15:27
 */
public class ReflectionToStringBuilderExample {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionToStringBuilderExample.class);

    @Test
    public void test_01() {
        User user = new User("xiaomi", 2);
        logger.info("toString user对象：{}", ReflectionToStringBuilder.toString(user));
    }

    @Test
    public void test_02() {
        User user = new User("xiaomi", 2);
        String toString = (new ReflectionToStringBuilder(user) {
            @Override
            protected boolean accept(Field f) {
                return super.accept(f) && !f.getName().equals("age");
            }

            @Override
            protected Object getValue(Field field) throws IllegalAccessException {
                return super.getValue(field) + "【补充测试】";
            }
        }).toString();
        logger.info("toString user对象：{}", toString);
    }

    private class User {
        private String userName;
        private int age;

        public User(String userName, int age) {
            this.userName = userName;
            this.age = age;
        }
    }
}