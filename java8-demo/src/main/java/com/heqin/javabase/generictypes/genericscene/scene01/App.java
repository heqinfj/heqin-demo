package com.heqin.javabase.generictypes.genericscene.scene01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author heqin
 * @Date 2021/11/3 20:15
 */
public class App {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("小明", 5, "小班",80));
        students.add(new Student("小东", 5, "小班",90));
        students.add(new Student("小军", 6, "小班",80));

        students.add(new Student("小丽", 6, "中班",100));
        students.add(new Student("小睿", 7, "中班",90));
        students.add(new Student("小军", 7, "中班",95));
        AggregateByFieldsHelper<Student> aggregateByFieldsHelper = new AggregateByFieldsHelper<>(Arrays.asList("grade"), Arrays.asList("age","score"));
        students.forEach(student -> aggregateByFieldsHelper.excute(student));
        Map<Object, Student> aggregateStudent = aggregateByFieldsHelper.getPrimaryMap();
        aggregateStudent.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(String.format("年龄合计：%s",v.getAge()));
            System.out.println(String.format("分数合计：%s",v.getScore()));
        });

        System.out.println("----------------------------------------------------------------");
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("王老师", 25, "初级"));
        teachers.add(new Teacher("黄老师", 30, "中级"));
        teachers.add(new Teacher("何老师", 40, "高级"));
        teachers.add(new Teacher("李老师", 35, "中级"));
        teachers.add(new Teacher("郑老师", 45, "特级"));
        AggregateByFieldsHelper<Teacher> aggregateByFieldsHelper2 = new AggregateByFieldsHelper<Teacher>(Arrays.asList("professionalTitle"), Arrays.asList("age"));
        teachers.forEach(teacher -> aggregateByFieldsHelper2.excute(teacher));
        Map<Object, Teacher> aggregateTeacher = aggregateByFieldsHelper2.getPrimaryMap();
        aggregateTeacher.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v.getAge());
        });
    }
}
