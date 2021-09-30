package com.heqin.javabase;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Author heqin
 * @Date 2021/9/20 22:25
 */
public class SystemApiExample {

    /**
     * Java System.getProperty VS. System.getenv
     * https://blog.xiayf.cn/2019/06/25/java-prop-env/
     * System 类中有两个方法，分别来读取系统属性（system properties）和环境变量（environment variables）
     *  - Java 平台使用一个 Properties 对象来提供本地系统相关的信息和配置，我们称之为 系统属性。
     *    系统属性包括当前用户、当前 Java 运行时版本 以及 文件路径分隔符诸如此类的信息。
     *    我们可以以如下格式使用命令行参数向应用传递指定属性或配置值：java -jar jarName -DpropertyName=value
     *    比如将app.jar的foo属性值设置为bar：java -jar app -Dfoo="bar"
     *  - 环境变量是类似 Properties 的一些 键/值 对。许多操作系统都提供环境变量的方式向应用传递配置信息。
     *
     * https://stackoverflow.com/questions/7054972/java-system-properties-and-environment-variables/7054981#7054981
     */
    @Test
    public void getProperties() {
        Properties properties = System.getProperties();
//        properties.list(System.out);
        Stream<String> sorted = (Stream)properties.keySet().stream();
        sorted.sorted(Comparator.naturalOrder()).forEach(str -> {
            System.out.println(str + ":" + properties.get(str));
        });
    }

    @Test
    public void getenv() {
        Map<String, String> env = System.getenv();
        Set<String> keySet = env.keySet();
        Stream<String> sorted = keySet.stream().sorted(Comparator.naturalOrder());
        sorted.forEach(str -> {
            System.out.println(str + ":" + env.get(str));
        });
    }
}
