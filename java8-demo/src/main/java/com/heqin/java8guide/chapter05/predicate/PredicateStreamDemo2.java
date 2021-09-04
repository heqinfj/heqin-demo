package com.heqin.java8guide.chapter05.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateStreamDemo2 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Mahesh", 20, "male", 38));
        list.add(new Student("Gauri", 21, "female", 45));
        list.add(new Student("Krishna", 19, "male", 42));
        list.add(new Student("Radha", 20, "female", 35));

        System.out.println("--- All students scoring marks > 40 ---");
        Predicate<Student> isScoreGt40 = null;
//        isScoreGt40 = new Predicate<Student>() {
//            @Override
//            public boolean test(Student student) {
//                return student.getMarks() > 40;
//            }
//        };
        isScoreGt40 = std -> std.getMarks() > 40;
        filterStudent(isScoreGt40, list).forEach(s -> System.out.println(s));

        System.out.println("--- All Male Students ---");
        Predicate<Student> isMaleStudent = std -> "male".equals(std.getGender());
        filterStudent(isMaleStudent, list).forEach(s -> System.out.println(s));

        System.out.println("--- All Female Students ---");
        Predicate<Student> isFemaleStudent = std -> "female".equals(std.getGender());
        filterStudent(isFemaleStudent, list).forEach(s -> System.out.println(s));

        System.out.println("--- All Female Students scoring > 40 ---");
        filterStudent(isFemaleStudent.and(isScoreGt40), list).forEach(s -> System.out.println(s));
    }

    static List<Student> filterStudent(Predicate<Student> predicate, List<Student> list) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}
