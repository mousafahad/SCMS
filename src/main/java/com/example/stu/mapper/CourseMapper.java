package com.example.stu.mapper;

import com.example.stu.dto.CourseDto;
import com.example.stu.dto.StudentDto;
import com.example.stu.entity.Course;
import com.example.stu.entity.Student;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseMapper {

    public static CourseDto mapToCourseDto(Course course){
        Set<StudentDto> studentDtos = course.getStudents().stream()
                .map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toSet());

        return new CourseDto(
                course.getId(),
                course.getName(),
                course.getTeacher(),
                course.getStudents().stream()
                        .map(student -> new StudentDto(student.getId(), student.getFirstname(), student.getLastname(), student.getEmail(), null))
                        .collect(Collectors.toSet())
        );
    }

    public static Course mapToCourse(CourseDto courseDto){
        Set<Student> students = courseDto.getStudents() != null ?
                courseDto.getStudents().stream()
                .map(StudentMapper::mapToStudent)
                .collect(Collectors.toSet()): new HashSet<>();

        return new Course(
                courseDto.getId(),
                courseDto.getName(),
                courseDto.getTeacher(),
                students
        );
    }
}
