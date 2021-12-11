package com.heqin.javabase.generictypes.genericscene.scene01;

import java.io.Serializable;

/**
 * @Author heqin
 * @Date 2021/11/3 21:45
 */
public class Teacher implements Serializable {

    private static final long serialVersionUID = 2437530753306441739L;

    private String name;

    private int age;

    private String professionalTitle;

    public Teacher(String name, int age, String professionalTitle) {
        this.name = name;
        this.age = age;
        this.professionalTitle = professionalTitle;
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

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
    }
}
