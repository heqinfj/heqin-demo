package com.heqin.decarator.demo02;

import org.junit.Test;

/**
 * 测试类
 *
 * @Author heqin
 * @Date 2021/9/29 16:06
 */
public class MockApp {

    @Test
    public void test(){
        TextNode spanNode = new SpanNode();
        spanNode.setText("Hello");
        System.out.println(spanNode.getText());

        TextNode boldNode = new BoldNodeDecorator(new SpanNode());
        boldNode.setText("world");
        System.out.println(boldNode.getText());

        TextNode underlineNode = new UderlineNodeDecorator(new SpanNode());
        underlineNode.setText("!!!");
        System.out.println(underlineNode.getText());

        TextNode boldUnderlineNode = new BoldNodeDecorator(new UderlineNodeDecorator(new SpanNode()));
        boldUnderlineNode.setText("您好，世界！！！");
        System.out.println(boldUnderlineNode.getText());
    }
}
