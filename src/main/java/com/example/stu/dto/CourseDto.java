package com.example.stu.dto;

import java.util.Set;

public class CourseDto {
    private long id;
    private String name;
    private String teacher;
    private Set<StudentDto> students;

    public CourseDto() {
    }

    public CourseDto(long id, String name, String teacher, Set<StudentDto> students) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public Set<StudentDto> getStudents() {
        return students;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setStudents(Set<StudentDto> students) {
        this.students = students;
    }
}
