package com.example.WebProject.services;

import com.example.WebProject.model.Course;
import com.example.WebProject.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
//    createCourse
//    creates a course
//    POST /api/course
//1
//    deleteCourse
//    deletes a course by id
//    DELETE /api/course/{id}
//1
//    findAllCourses
//    retrieves all the courses
//    GET /api/course
//1
//    findCourseById
//    retrieves a course by id
//    GET /api/course/{id}
//0
//    updateCourse
//    updates a course by id
//    PUT /api/course/{id}
//0
    @CrossOrigin(origins = "*")
    @PostMapping("/api/course")
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/course")
    public List<Course> findAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

}
