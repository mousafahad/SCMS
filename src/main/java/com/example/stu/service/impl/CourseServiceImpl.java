package com.example.stu.service.impl;

import com.example.stu.dto.CourseDto;
import com.example.stu.entity.Course;
import com.example.stu.mapper.CourseMapper;
import com.example.stu.repository.CourseRepository;
import com.example.stu.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private  CourseRepository courseRepository;

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = CourseMapper.mapToCourse(courseDto);
        Course savedCourse = courseRepository.save(course);
        return CourseMapper.mapToCourseDto(savedCourse);
    }

    @Override
    public CourseDto getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return CourseMapper.mapToCourseDto(course);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(CourseMapper::mapToCourseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setName(courseDto.getName());
        // If you want to update students in the course, handle that here

        Course updatedCourse = courseRepository.save(course);
        return CourseMapper.mapToCourseDto(updatedCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
