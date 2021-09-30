package com.heqin.decarator.demo02;

/**
 * 抽象类装饰器
 *
 * @Author heqin
 * @Date 2021/9/29 15:21
 */
public abstract class NodeDecorator implements TextNode {

    //需要被装饰的textNode对象 注意此处的修饰符为protected
    protected TextNode target;

    public NodeDecorator(TextNode target) {
        this.target = target;
    }

    @Override
    public void setText(String text) {
        this.target.setText(text);
    }

}
