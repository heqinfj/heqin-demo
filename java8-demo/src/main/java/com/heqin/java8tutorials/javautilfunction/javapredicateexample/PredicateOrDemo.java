package com.heqin.java8tutorials.javautilfunction.javapredicateexample;

import java.util.function.Predicate;

public class PredicateOrDemo {
    public static void main(String[] args) {
        //Predicate<Student> isMaleStudent = s -> s.getAge() >= 20 && "male".equals(s.getGender());
        Predicate<Student> isMaleStudent = new Predicate<Student>() {
            @Override
            public boolean test(Student s) {
                return s.getAge() >= 20 && "male".equals(s.getGender());
            }
        };
        Predicate<Student> isFemaleStudent = s -> s.getAge() > 18 && "female".equals(s.getGender());
        Predicate<Student> isStudentPassed = s -> s.getMarks() >= 33;

        Student student1 = new Student("Mahesh", 22, "male", 35);
        //Test either male or female student
        Boolean result = isMaleStudent.or(isFemaleStudent).test(student1);
        System.out.println(result); //true
        //Is student passed, too
        result = isMaleStudent.or(isFemaleStudent).and(isStudentPassed).test(student1);
        System.out.println(result); //true
    }
}
