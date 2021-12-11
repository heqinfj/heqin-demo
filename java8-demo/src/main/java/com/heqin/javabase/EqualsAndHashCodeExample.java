package com.heqin.javabase;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 编写equals和hashCode
 *
 * @Author heqin
 * @Date 2021/10/7 17:25
 */
public class EqualsAndHashCodeExample {

    /**
     * equals()方法的正确编写方法：
     * <p>
     * 1. 先确定实例“相等”的逻辑，即哪些字段相等，就认为实例相等；
     * 2. 用instanceof判断传入的待比较的Object是不是当前类型，如果是，继续比较，否则，返回false；
     * 3. 对引用类型用Objects.equals()比较，对基本类型直接用==比较。
     * <p>
     * 使用Objects.equals()比较两个引用类型是否相等的目的是省去了判断null的麻烦。两个引用类型都是null时它们也是相等的。
     * <p>
     * 如果不调用List的contains()、indexOf()这些方法，那么放入的元素就不需要实现equals()方法。
     * <p>
     * https://www.liaoxuefeng.com/wiki/1252599548343744/1265116446975264
     */
    @Test
    public void equalsTest(){
        //java 语法糖 Arrays.asList(T... a)  -》反编译后 -》 Arrays.asList(T[] array)
        List<Person> list = Arrays.asList(
                new Person("Xiao", "Ming", 18),
                new Person("Xiao", "Hong", 25),
                new Person("Bob", "Smith", 20)
        );
        boolean exist = list.contains(new Person("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");
    }

    /**
     * HashMap中依据key的hash值来确定value存储位置
     */
    @Test
    public void hashCodeTest(){
        Map<MockKey,Person> map = new HashMap<>();
        map.put(new MockKey("a"), new Person("Xiao", "Ming", 18));
        map.put(new MockKey("b"), new Person("Xiao", "Hong", 25));

//        String str1 = "a";
//        String str2 = new String("a");
//        System.out.println(Objects.hash(str1));
//        System.out.println(Objects.hash(str2));
        System.out.println(map.get(new MockKey("b")));
    }

}

/**
 * 模拟Key对象
 */
class MockKey{

    String keyName;

    public MockKey(String keyName) {
        this.keyName = keyName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MockKey){
            MockKey mockKey = (MockKey) obj;
            return Objects.equals(this.keyName,mockKey.keyName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        //return Objects.hash(this.keyName);
        return 666;//模拟哈希码都是为666，让其产生哈希值冲突
    }
}

class Person {
    String firstName;
    String lastName;
    int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person person = (Person) o;
            return Objects.equals(this.firstName, person.firstName)
                    && Objects.equals(this.lastName, person.lastName)
                    && this.age == person.age;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

