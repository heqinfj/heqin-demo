package com.heqin.builder.demo01_1;

import java.util.Arrays;

/**
 * @Author heqin
 * @Date 2021/10/13 7:46
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void buildProduct(String markdown){
        //替代lines()方法
        String lineTerminatorRegex = "\n|\r|\r\n";
        String[] splitMarkdownArr = markdown.split(lineTerminatorRegex);
        Arrays.stream(splitMarkdownArr).forEach(line -> {
            if (line.startsWith("#")) {
                builder.buildHeading(line);
            } else if (line.startsWith(">")) {
                builder.buildQuote(line);
            } else if (line.startsWith("---")) {
                builder.buildHr(line);
            } else {
                builder.buildParagraph(line);
            }
        });
    }
}
