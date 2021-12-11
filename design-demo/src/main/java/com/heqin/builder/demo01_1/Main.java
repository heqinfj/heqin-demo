package com.heqin.builder.demo01_1;

/**
 * @Author heqin
 * @Date 2021/10/13 7:55
 */
public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        Builder builder = new ConcreteBuilder(product);
        Director director = new Director(builder);
        String markdown = String.join("\n", // Markdown document
                "## Builder Pattern", // heading
                "> Seperate the construction of a complex object from its representation",
                "Use builder pattern when the construction process is complex.", "----", "Here is an example.");
        director.buildProduct(markdown);
        System.out.println(product.showProduct());
    }
}
