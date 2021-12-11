package com.heqin.javabase.innerclass.anonymousclass;

import java.util.HashMap;

/**
 * 除了接口外，匿名类也完全可以继承自普通类。观察以下代码：
 * map1是一个普通的HashMap实例，但map2是一个匿名类实例，只是该匿名类继承自HashMap。
 * map3也是一个继承自HashMap的匿名类实例，并且添加了static代码块来初始化数据。观察编译输出可发现Main$1.class和Main$2.class两个匿名类文件。
 *
 * @Author heqin
 * @Date 2021/10/1 2:31
 */
public class InnerClassExtendCommonClass {

    public static void main(String[] args) {
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap() {
        }; // 匿名类!
        HashMap<String, String> map3 = new HashMap() {
            {
                put("A", "1");
                put("B", "2");
            }
        };
        System.out.println(map3.get("A"));
    }
}
