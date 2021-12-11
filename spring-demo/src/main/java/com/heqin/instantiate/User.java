package com.heqin.instantiate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author heqin
 * @Date 2021/9/30 16:59
 */
@Component
public class User {
    public User(Cat cat) {
        System.out.println(cat);
    }
}
