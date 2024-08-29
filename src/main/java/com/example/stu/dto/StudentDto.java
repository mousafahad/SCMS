package com.example.stu.dto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

public class StudentDto{

    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private Set<CourseDto> courses;

    public StudentDto() {
    }

    public StudentDto(long id, String firstname, String lastname, String email, Set<CourseDto> courses) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.courses = courses;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourses(Set<CourseDto> courses) {
        this.courses = courses;
    }

    public Set<CourseDto> getCourses() {
        return courses;
    }
}
