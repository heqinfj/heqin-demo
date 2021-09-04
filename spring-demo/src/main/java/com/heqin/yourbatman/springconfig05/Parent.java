package com.heqin.yourbatman.springconfig05;

/**
 * @author heqin
 */
public class Parent {

    private Son son;

    public Parent() {
    }

    public Parent(Son son) {
        this.son = son;
    }

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }
}
