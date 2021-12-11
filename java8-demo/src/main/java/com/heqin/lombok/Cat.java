package com.heqin.lombok;

import lombok.AllArgsConstructor;

/**
 * @Author heqin
 * @Date 2021/11/2 22:37
 */
//@AllArgsConstructor
public class Cat extends Animal{

    public Cat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
