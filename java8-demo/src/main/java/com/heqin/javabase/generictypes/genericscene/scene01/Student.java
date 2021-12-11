package com.heqin.javabase.generictypes.genericscene.scene01;

import java.io.Serializable;

/**
 * @Author heqin
 * @Date 2021/11/3 20:59
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 7958017153656095515L;

    private String name;

    private int age;

    private String grade;

    private int score;

    public Student(String name, int age, String grade,int score) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
