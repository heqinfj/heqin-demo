package com.heqin.decarator.demo02;

/**
 * 增加粗体的装饰器 继承 抽象装饰器
 *
 * @Author heqin
 * @Date 2021/9/29 15:29
 */
public class BoldNodeDecorator extends NodeDecorator {

    public BoldNodeDecorator(TextNode target) {
        super(target);
    }

    @Override
    public String getText() {
        return "<b>" + target.getText() + "</b>";
    }
}
