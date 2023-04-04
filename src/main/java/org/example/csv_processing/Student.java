package org.example.csv_processing;

import lombok.Data;

@Data
public class Student implements Comparable<Student> {
    int id;
    String name;
    String postalCode;
    int age;

    public Student(int id, String name, String postalCode, int age) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
        this.age = age;
    }

    @Override
    public int compareTo(Student student) {
        return getName().compareTo(student.getName());
    }
}
