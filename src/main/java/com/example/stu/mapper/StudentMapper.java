package com.example.stu.mapper;
import com.example.stu.dto.CourseDto;
import com.example.stu.dto.StudentDto;
import com.example.stu.entity.Course;
import com.example.stu.entity.Student;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student) {
        Set<CourseDto> courseDtos = student.getCourses().stream()
                .map(CourseMapper::mapToCourseDto)
                .collect(Collectors.toSet());

        return new StudentDto(
                student.getId(),
                student.getFirstname(),
                student.getLastname(),
                student.getEmail(),
                courseDtos
        );
    }

    public static Student mapToStudent(StudentDto studentDto) {
        Set<Course> courses = studentDto.getCourses() != null ?
                studentDto.getCourses().stream()
                .map(CourseMapper::mapToCourse)
                .collect(Collectors.toSet()): new HashSet<>();

        return new Student(
                studentDto.getId(),
                studentDto.getFirstname(),
                studentDto.getLastname(),
                studentDto.getEmail(),
                courses
        );
    }
}