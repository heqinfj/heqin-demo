package com.heqin.java8guide.chapter04;

public class ReferenceConstructorsDemo {
    public static void main(String[] args) {
        ReferenceConstructorsDemo referenceConstructorsDemo = new ReferenceConstructorsDemo();
        referenceConstructorsDemo.work();
    }

    private void work() {
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
