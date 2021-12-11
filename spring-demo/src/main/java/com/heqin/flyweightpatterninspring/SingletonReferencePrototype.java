package com.heqin.flyweightpatterninspring;

/**
 * @Author heqin
 * @Date 2021/10/26 10:33
 */
public class SingletonReferencePrototype {

    private MyTestBean myTestBean;

    public MyTestBean getMyTestBean() {
        //System.out.println(String.format("属性myTestBean的hashCode的值为%s", myTestBean.hashCode()));
        return myTestBean;
    }

    public void setMyTestBean(MyTestBean myTestBean) {
        this.myTestBean = myTestBean;
    }
}
