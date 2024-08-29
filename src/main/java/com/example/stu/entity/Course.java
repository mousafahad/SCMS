package com.example.stu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column //(name = "Course_name")
    private String name;

    @Column //(name = "Course_teacher")
    private String Teacher;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    public Course() {
    }

    public Course(long id, String name, String teacher, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.Teacher = teacher;
        this.students = students;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return Teacher;
    }

    public Set<Student> getStudents() {
        return students;
    }
}
