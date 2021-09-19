package com.heqin.proxy.dao.impl;

import com.heqin.proxy.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void updateName() {
        System.out.println("do updateName.");
    }
}
