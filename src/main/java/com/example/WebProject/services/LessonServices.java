package com.example.WebProject.services;

import com.example.WebProject.model.Course;
import com.example.WebProject.model.Lesson;
import com.example.WebProject.model.Module;
import com.example.WebProject.model.Topic;
import com.example.WebProject.repository.CourseRepository;
import com.example.WebProject.repository.LessonRepository;
import com.example.WebProject.repository.ModuleRepository;
import com.example.WebProject.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class LessonServices {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    TopicRepository topicRepository;

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
    @PostMapping("/api/lesson/{moduleId}")
    public Lesson createLesson(@RequestBody Lesson lesson, @PathVariable("moduleId") Integer moduleId) {
        Module data = moduleRepository.findById(moduleId).get();
        lesson.setModule(data);
        Lesson newLesson = lessonRepository.save(lesson);
        Lesson dataL = lessonRepository.findById(newLesson.getId()).get();
        Topic newTopic = new Topic();
        newTopic.setLesson(dataL);
        newTopic.setTitle("Topic1");
        topicRepository.save(newTopic);
        return lessonRepository.findById(newLesson.getId()).get();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/lesson/{moduleId}")
    public List<Lesson> findByModuleId(@PathVariable Integer moduleId) {
        Optional<Module> module = moduleRepository.findById(moduleId);
        Module data = module.get();
        return lessonRepository.findByModuleId(data);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/lesson/{lessonId}")
    public void deleteLessonById(@PathVariable Integer lessonId) {
        try {
            lessonRepository.deleteById(lessonId);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/api/lesson/{lessonId}")
    public Optional<Lesson> updateLesson(@PathVariable Integer lessonId, @RequestBody Lesson lesson) {
        Optional<Lesson> oldLesson = lessonRepository.findById(lessonId);
        Lesson data = oldLesson.get();
        data.setTitle(lesson.getTitle());
        lessonRepository.save(data);
        return lessonRepository.findById(lessonId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/lesson")
    public List<Lesson> findAllLesson() {
        return (List<Lesson>)lessonRepository.findAll();
    }
}
