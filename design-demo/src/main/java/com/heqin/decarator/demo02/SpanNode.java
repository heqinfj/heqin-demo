package com.heqin.decarator.demo02;

/**
 * 顶层接口的具体实现类
 *
 * @Author heqin
 * @Date 2021/9/29 15:19
 */
public class SpanNode implements TextNode {

    private String text;

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return "<span>" + text + "</span>";
    }
}
