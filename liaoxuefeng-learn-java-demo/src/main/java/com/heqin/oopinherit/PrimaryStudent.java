package com.heqin.oopinherit;

/**
 * 小学生类
 *
 * @Author heqin
 * @Date 2021/10/2 8:23
 */
public class PrimaryStudent extends Student {
    private int grade;

    public PrimaryStudent(String name, int age, int score, int grade) {
        super(name, age, score);
        this.grade = grade;
    }
}
