package com.example.stu.service.impl;

import com.example.stu.dto.StudentDto;
import com.example.stu.entity.Course;
import com.example.stu.entity.Student;
import com.example.stu.exception.ResourceNotFoundException;
import com.example.stu.mapper.StudentMapper;
import com.example.stu.repository.CourseRepository;
import com.example.stu.repository.StudentRepository;
import com.example.stu.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        Student student= StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student is not exist with given ID : " + studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());


    }

    @Override
    public StudentDto updateStudent(long studentId, StudentDto updatedStudent) {

        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student is not exists with given ID:"+ studentId));

        student.setFirstname(updatedStudent.getFirstname());
        student.setLastname(updatedStudent.getLastname());
        student.setEmail(updatedStudent.getEmail());

        Student updatedStudentObj = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudent(long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student is not exists with given ID:"+ studentId));

        studentRepository.deleteById(studentId);
    }


    public StudentDto enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.getCourses().add(course);
        course.getStudents().add(student);

        Student updatedStudent = studentRepository.save(student);
        courseRepository.save(course);

        return StudentMapper.mapToStudentDto(updatedStudent);
    }


}
