package com.heqin.javadecompiler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/10/4 17:11
 */
public class ForEachDemo {

    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        data.add("a");
        data.add("b");

        for (String str : data) {
            System.out.println(str);
        }
    }
}
