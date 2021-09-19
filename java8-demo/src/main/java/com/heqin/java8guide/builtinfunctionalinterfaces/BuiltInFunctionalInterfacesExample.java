package com.heqin.java8guide.builtinfunctionalinterfaces;

import org.junit.Test;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author heqin
 * @Date 2021/9/14 22:36
 */
public class BuiltInFunctionalInterfacesExample {

    @Test
    public void predicate(){
        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test("foo"));;              // true
        System.out.println(predicate.negate().test("foo"));;     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }

    @Test
    public void function() {
        Function<String, Integer> toInteger = Integer::valueOf;
        //相等于
//        Function<String, Integer> toInteger = s1 -> Integer.valueOf(s1);

        //相等于
//        Function<String, Integer> toInteger = (String s1) -> {
//            return Integer.valueOf(s1);
//        };

        //相等于
//        Function<String, Integer> toInteger = new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s1) {
//                return Integer.valueOf(s1);
//            }
//        };

        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        String s = backToString.apply("123");// "123"
        System.out.println(s);
    }

    @Test
    public void supplier(){
        Supplier<Person> personSupplier = null;
//        personSupplier = new Supplier<Person>() {
//            @Override
//            public Person get() {
//                return new Person("xiao","mi");
//            }
//        };
        personSupplier = Person::new; // 这个怎么能像上面那样 能直接指定有参的构造函数？
        System.out.println(personSupplier.get());
    }

    @Test
    public void consumer(){
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));
    }

    @Test
    public void comparator(){
        Comparator<Person> comparator = null;

        //java8 之前写法
//        comparator = new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.firstName.compareTo(o2.firstName);
//            }
//        };
        comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        System.out.println(comparator.compare(p1, p2));// > 0
        System.out.println(comparator.reversed().compare(p1, p2));// < 0
    }

    class Person {
        String firstName;
        String lastName;

        Person() {
            //System.out.println("无参构造函数。。。");
        }

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            //System.out.println("有参构造函数。。。");
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }


}
