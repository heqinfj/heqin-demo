package com.heqin.decarator.demo02;

/**
 * 增加下划线的装饰器 继承 抽象装饰器
 *
 * @Author heqin
 * @Date 2021/9/29 15:59
 */
public class UderlineNodeDecorator extends NodeDecorator {

    public UderlineNodeDecorator(TextNode target) {
        super(target);
    }

    @Override
    public String getText() {
        return "<u>" + target.getText() + "</u>";
    }
}
