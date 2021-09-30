package com.heqin.mergedbeandefinition.spring5x.beans;

/**
 * @Author heqin
 * @Date 2021/9/13 20:33
 */
public class TestBean {

    private String beanName;

    private String name;

    private int age;

    private boolean destroyed;

    private String remark;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
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

    public void destroy() {
        this.destroyed = true;
    }

    public boolean wasDestroyed() {
        return destroyed;
    }

    public void setDesc(String desc){
        this.remark = desc;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name +
                '\'' +
                ", age=" + age +
                '\'' +
                ", remark=" + remark +
                '}';
    }
}
