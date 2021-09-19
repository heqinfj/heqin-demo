package com.heqin.java8guide.methodandconstructorreferences;

import com.heqin.java8guide.functionalinterfaces.Converter;
import org.junit.Test;

/**
 * The type Method and constructor references example.
 *
 * @Author heqin
 * @Date 2021 /9/14 22:16
 */
public class MethodAndConstructorReferencesExample {

    /**
     * 如何引用静态方法
     */
    @Test
    public void referenceAstaticMethod() {
        Converter<String, Integer> converter = null;

        //匿名内部类写法
//        converter = new Converter<String, Integer>() {
//            @Override
//            public Integer convert(String from) {
//                return Integer.valueOf(from);
//            }
//        };

        //lambda 1
//        converter = (from) -> Integer.valueOf(from);

        //lambda 2
        //进一步简化 Java 8 允许您通过::关键字传递方法或构造函数的引用
        converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);
    }

    class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    /**
     * 如何引用对象方法
     */
    @Test
    public void referenceObjectMethods() {
        Something something = new Something();
        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("Java");
        System.out.println(converted);
    }

    /**
     * 如何引用构造函数
     */
    @Test
    public void referenceConstructor() {
        PersonFactory<Person> personFactory = null;
        //java8 之前写法
//        personFactory = new PersonFactory() {
//            @Override
//            public Person create(String firstName, String lastName) {
//                return new Person(firstName,lastName);
//            }
//        };

        //java8 之后写法
        personFactory = Person::new;

        //We create a reference to the Person constructor via Person::new.
        //The Java compiler automatically chooses the right constructor by matching the signature of PersonFactory.create.
        //我们通过 Person::new 创建对 Person 构造函数的引用。 Java 编译器通过匹配 PersonFactory.create 的签名自动选择正确的构造函数。
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);
    }

    class Person {
        String firstName;
        String lastName;

        Person() {
        }

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    // Person 工厂
    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }
}
