package com.zwwhnly.springbootaction.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentInfo {
    private String name;

    private int age;

    private LocalDate birthday;

    public StudentInfo(String name, int age, LocalDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        List<StudentInfo> studentInfoList = new ArrayList<>();
        studentInfoList.add(new StudentInfo("张三", 18, LocalDate.of(1990, 1, 1)));
        studentInfoList.add(new StudentInfo("李四", 18, LocalDate.of(1991, 1, 1)));
        studentInfoList.add(new StudentInfo("王五", 19, LocalDate.of(1991, 1, 1)));
        studentInfoList.add(new StudentInfo("赵六", 20, LocalDate.of(1992, 1, 1)));

        List<String> nameList = studentInfoList.stream().map(StudentInfo::getName).collect(Collectors.toList());
        nameList.forEach(System.out::println);

        List<Integer> ageList = studentInfoList.stream().map(StudentInfo::getAge).distinct().collect(Collectors.toList());
        ageList.forEach(System.out::println);
    }
}
