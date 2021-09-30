package com.heqin.yourbatman.javavariableexeorder.case1;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author heqin
 * @Date 2021/9/27 17:07
 */
public class TestMe {

    public static void main(String[] args) {
        Child01 child01 = new Child01();
        System.out.println(child01);
    }
}
@Getter
@Setter
class Parent01{
    private String name;
}

@Getter
@Setter
class Child01 extends Parent01{
    private int age;
}