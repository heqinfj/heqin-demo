package com.heqin.javabase.generictypes.principle.nodeeample;

/**
 * @Author heqin
 * @Date 2021/10/19 7:15
 */
public class Node<T> {

    public T data;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}

//After type erasure, the Node classes become:
//类型擦除后，Node类变为：
/*
class Node {//type erasure

    private Object data;//type erasure

    public Node(Object data) {//type erasure
        this.data = data;
    }

    public void setData(Object data) {//type erasure
        System.out.println("Node.setData");
        this.data = data;
    }
}
 */
