package com.heqin.builder.demo01_1;

/**
 * 抽象建造者
 *
 * 扩展：接口，实际可称为抽象的抽象类
 *
 * @Author heqin
 * @Date 2021/10/12 11:04
 */
public abstract class Builder {

    /**
     * 建造标题
     * @param line
     */
    abstract void buildHeading(String line);

    /**
     * 建造水平线
     * @param line
     */
    abstract void buildHr(String line);

    /**
     * 建造段落
     * @param line
     */
    abstract void buildParagraph(String line);

    /**
     * 建造块引用
     * @param line
     */
    abstract void buildQuote(String line);

}
