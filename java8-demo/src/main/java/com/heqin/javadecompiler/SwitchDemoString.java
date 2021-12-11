package com.heqin.javadecompiler;

/**
 * @Author heqin
 * @Date 2021/10/5 18:06
 */
public class SwitchDemoString {
    public static void main(String[] args) {
        String str = "world";
        switch (str) {
            case "hello":
                System.out.println("hello");
                break;
            case "world":
                System.out.println("world");
                break;
            default:
                break;
        }
    }
}
