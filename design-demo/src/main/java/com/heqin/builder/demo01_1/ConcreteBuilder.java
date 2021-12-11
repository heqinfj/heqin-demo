package com.heqin.builder.demo01_1;

/**
 * 具体建造者
 *
 * @Author heqin
 * @Date 2021/10/12 11:11
 */
public class ConcreteBuilder extends Builder{

    private Product product;

    public ConcreteBuilder(Product product) {
        this.product = product;
    }

    @Override
    void buildHeading(String line) {
        int n = 0;
        while (line.charAt(0) == '#') {
            n++;
            line = line.substring(1);
        }
        product.buildPart(String.format("<h%d>%s</h%d>", n, line.trim(), n)).buildPart("\n");
    }

    @Override
    void buildHr(String line) {
        product.buildPart("<hr/>").buildPart("\n");
    }

    @Override
    void buildParagraph(String line) {
        product.buildPart("<p>" + line + "</p>").buildPart("\n");
    }

    @Override
    void buildQuote(String line) {
        product.buildPart("<blockquote>" + line.substring(1).trim() + "</blockquote>").buildPart("\n");
    }
}
