package com.heqin.lombok;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @Author heqin
 * @Date 2021/11/2 22:26
 */
@AllArgsConstructor
public class Animal {

    protected String name;

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
