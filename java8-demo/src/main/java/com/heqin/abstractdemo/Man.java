package com.heqin.abstractdemo;

/**
 * @author heqin
 */
public class Man extends AbstractPerson{

    private String ballType;

    public Man() {
    }

    public Man(String ballType) {
        this.ballType = ballType;
    }

    public String getBallType() {
        return ballType;
    }

    public void setBallType(String ballType) {
        this.ballType = ballType;
    }
}
