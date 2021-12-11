package com.heqin.javabase.generictypes.learn02;

/**
 * @Author heqin
 * @Date 2021/11/18 18:06
 */
public class UserDao extends BaseDao<User>{

    public static void main(String[] args) {
        BaseDao<User> UserDao = new UserDao();
    }
}
