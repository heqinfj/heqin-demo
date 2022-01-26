package com.heqin.javabase.generictypes.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 范型擦除
 *
 * @Author heqin
 * @Date 2021/10/6 20:52
 */
public class GenericErase {

    public void genericEraseTest() {
        List<String> list = new ArrayList<>();
        System.out.println(list.size() > 0 ? list.get(0).toUpperCase() : "none");
        System.out.println(list.toString());
    }

    public void test2(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "hollis");
        map.put("age", 22);
        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
    }

    public void test3(){
        GenericType<String> genericType = new GenericType();
        genericType.setParam("goood");
    }

}
