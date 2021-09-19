package com.heqin.java8tutorials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/9/8 10:46
 */
public class Test01 {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("2");
        a.add("1");

        HashMap<Object, Object> collect3 = a.stream().collect(HashMap::new, (m, v) -> {
                    m.put(v, "1");
                    m.forEach((q, w) -> {
                        System.out.println("q:" + q);
                        System.out.println("w:" + w);
                    });
                },
                (x, y) -> {
                    x.forEach((r, u) -> {
                        System.out.println("r:" + r);
                        System.out.println("u:" + u);
                    });
                    x.putAll(y);
                });
    }
}
