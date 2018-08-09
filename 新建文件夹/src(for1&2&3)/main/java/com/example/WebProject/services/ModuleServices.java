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

import java.util.List;
import java.util.Optional;

@RestController
public class ModuleServices {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    TopicRepository topicRepository;
//    createModule
//    creates a module for a course
//    POST /api/course/{cid}/module
//1
//    deleteModule
//    deletes a module by id
//    DELETE /api/module/{id}
//1
//    findAllModules
//    retrieves all the modules
//    GET /api/module
//1
//    findModuleById
//    retrieves a module by id
//    GET /api/module/{id}
//0
//    findAllModulesForCourse
//    retrieves all modules for course
//    GET /api/course/{cid}/module
//1
//    updateModule
//    updates a module by id
//    PUT /api/module/{id}
//0

    @CrossOrigin(origins = "*")
    @PostMapping("/api/module/{courseId}")
    public Module createModule(@RequestBody Module module, @PathVariable("courseId") Integer courseId) {
        Course data = courseRepository.findById(courseId).get();
        module.setCourse(data);
        Module newModule = moduleRepository.save(module);
        Module dataM = moduleRepository.findById(newModule.getId()).get();
        Lesson newLesson = new Lesson();
        newLesson.setModule(dataM);
        newLesson.setTitle("Lesson1");
        newLesson = lessonRepository.save(newLesson);
        Lesson dataL = lessonRepository.findById(newLesson.getId()).get();
        Topic newTopic = new Topic();
        newTopic.setLesson(dataL);
        newTopic.setTitle("Topic1");
        topicRepository.save(newTopic);
        return moduleRepository.findById(newModule.getId()).get();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/module/{id}")
    public void deleteModuleByID(@PathVariable Integer id) {
        try {
            moduleRepository.deleteById(id);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/api/module/{moduleId}")
    public Optional<Module> updateModule(@PathVariable Integer moduleId, @RequestBody Module module) {
        Optional<Module> oldModule = moduleRepository.findById(moduleId);
        Module data = oldModule.get();
        data.setTitle(module.getTitle());
        moduleRepository.save(data);
        return moduleRepository.findById(moduleId);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/api/module/{courseId}")
    public List<Module> findByCourseId(@PathVariable Integer courseId) {

        Optional<Course> course = courseRepository.findById(courseId);
        Course data = course.get();
        return moduleRepository.findByCourseId(data);
    }
}