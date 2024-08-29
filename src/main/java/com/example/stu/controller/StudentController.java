package com.example.stu.controller;

import com.example.stu.dto.StudentDto;
import com.example.stu.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    //build add students REST API
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto savedStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudent , HttpStatus.CREATED);
    }

    // build get student REST API
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") long studentId){
        StudentDto studentDto = studentService.getStudentById(studentId);
        return ResponseEntity.ok(studentDto);
    }

    //build getAll Students REST API
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // build update Student REST API
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updatedStudent(@PathVariable("id") long studentId,@RequestBody StudentDto updatedStudent){
        StudentDto studentDto = studentService.updateStudent(studentId, updatedStudent);
        return ResponseEntity.ok(studentDto);
    }

    // build delete Student REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted succesfully");
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<StudentDto> enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        StudentDto updatedStudent = studentService.enrollStudentInCourse(studentId, courseId);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }
}
