package com.heqin.javabase.generictypes.principle;

import org.junit.Test;

/**
 * @Author heqin
 * @Date 2021/10/19 6:54
 */
public class UserExample {

    class User implements Comparable<User> {

        private String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            return this.name.compareTo(o.name);
        }

    }

    @Test
    public void test1() {
        User user = new User("xiaobing");
        Object other = new User("xiaohong");
        System.out.println(user.compareTo((User) other));
    }


    @Test
    public void test2() {
        Comparable<User> user = new User("xiaobing");
        Object other = new User("xiaohong");
        System.out.println(user.compareTo((User) other));
    }
}
