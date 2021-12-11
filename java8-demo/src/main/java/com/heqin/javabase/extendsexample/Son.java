package com.heqin.javabase.extendsexample;

import com.heqin.javabase.extendsexample.ppkg.Parent;

/**
 * @Author heqin
 * @Date 2021/10/14 20:19
 */
public class Son extends Parent {

    private String name = "小明";

    public Son(){
        //super("xxx");
    }

    @Override
    public void say() {
        System.out.println(String.format("我叫%s，我的爸爸叫%s",this.name,super.name));
    }
}
