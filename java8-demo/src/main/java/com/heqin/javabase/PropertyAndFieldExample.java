package com.heqin.javabase;

/**
 * 从IDEA图标中探索 Property 和 Field 的区别
 * https://blog.csdn.net/weixin_44135184/article/details/117386187
 * <p>
 * field、variable和property有什么区别
 * https://blog.csdn.net/sinat_34875106/article/details/117291788
 *
 * @Author heqin
 * @Date 2021/10/21 14:42
 */
public class PropertyAndFieldExample {

    //Field
    private String privateNameField;

    public String publicNameField;

    protected String protectedNameField;

    String defaultNameField;

    //Property
    private String privateNameProperty;

    //getXxx 读属性
    public String getPrivateNameProperty() {
        return privateNameProperty;
    }

    //setXxx 写属性
    public void setPrivateNameProperty(String privateNameProperty) {
        this.privateNameProperty = privateNameProperty;
    }
}
