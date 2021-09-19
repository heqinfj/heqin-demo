package com.heqin.java8tutorials.javautilfunction.javapredicateexample;

import java.util.function.Predicate;

public class PredicateAndDemo {
    public static void main(String[] args) {
        Predicate<Student> isMaleStudent = s -> s.getAge() >= 20 && "male".equals(s.getGender());
        Predicate<Student> isFemaleStudent = s -> s.getAge() > 18 && "female".equals(s.getGender());
        Predicate<Student> isStudentPassed = s -> s.getMarks() >= 33;

        // Testing if male student passed.
        Student student1 = new Student("Mahesh", 22, "male", 30);
        Boolean result = isMaleStudent.and(isStudentPassed).test(student1);
        System.out.println(result); //false

        // Testing if female student passed.
        Student student2 = new Student("Gauri", 19, "female", 40);
        result = isFemaleStudent.and(isStudentPassed).test(student2);
        System.out.println(result); //true
    }
}
