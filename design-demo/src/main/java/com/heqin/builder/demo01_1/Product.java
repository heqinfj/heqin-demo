package com.heqin.builder.demo01_1;

/**
 * 产品角色
 *
 * @Author heqin
 * @Date 2021/10/12 11:17
 */
public class Product{

    private StringBuilder content = new StringBuilder();

    public StringBuilder getContent() {
        return content;
    }

    /**
     * 构造产品
     * @param partContent
     */
    public Product buildPart(String partContent){
        this.content.append(partContent);
        return this;
    }

    /**
     * 显示最终的产品信息
     *
     * @return
     */
    public String showProduct() {
        return content.toString();
    }
}
