package com.example.WebProject.services;

import com.example.WebProject.model.Course;
import com.example.WebProject.model.Lesson;
import com.example.WebProject.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessonServices {
    @Autowired
    LessonRepository lessonRepository;

//    createLesson
//    creates a lesson for a module
//    POST /api/course/{cid}/module/{mid}/lesson
//1
//    deleteLesson
//    deletes a lesson by id
//    DELETE /api/lesson/{id}
//1
//    findAllLessons
//    retrieves all the lessons
//    GET /api/lesson
//1
//    findLessonById
//    retrieves a lesson by id
//    GET /api/lesson/{id}
//0
//    findAllLessonssForModule
//    retrieves all lessons for module
//    GET /api/course/{cid}/module/{mid}/lesson
//1
//    updateLesson
//    updates a lesson by id
//    PUT /api/lesson/{id}
//0

    @CrossOrigin(origins = "*")
    @PostMapping("/api/lesson")
    public Lesson createCourse(@RequestBody Lesson lesson) {
        return lessonRepository.save(lesson);
    }
}
