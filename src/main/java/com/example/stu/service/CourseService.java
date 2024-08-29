package com.example.stu.service;

import com.example.stu.dto.CourseDto;
import java.util.List;

public interface CourseService {
    CourseDto createCourse(CourseDto courseDto);
    CourseDto getCourseById(Long id);
    List<CourseDto> getAllCourses();
    CourseDto updateCourse(Long id, CourseDto courseDto);
    void deleteCourse(Long id);
}
