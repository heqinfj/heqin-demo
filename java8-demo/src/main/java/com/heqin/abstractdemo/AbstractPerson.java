package com.heqin.abstractdemo;

/**
 * @author heqin
 */
public abstract class AbstractPerson {

    private String name = "This is a person.";

    private String privateVal;

    String defaultVal;

    protected String protectedVal;

    public String publicVal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivateVal() {
        return privateVal;
    }

    public void setPrivateVal(String privateVal) {
        this.privateVal = privateVal;
    }

    public String getDefaultVal() {
        return defaultVal;
    }

    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    public String getProtectedVal() {
        return protectedVal;
    }

    public void setProtectedVal(String protectedVal) {
        this.protectedVal = protectedVal;
    }

    public String getPublicVal() {
        return publicVal;
    }

    public void setPublicVal(String publicVal) {
        this.publicVal = publicVal;
    }
}
