package com.example.stu.service;

import com.example.stu.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(long studentId);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(long studentId, StudentDto updatedStudent);

    void deleteStudent(long studentId);

    StudentDto enrollStudentInCourse(Long studentId, Long courseId);
}
