package com.example.WebProject.services;

import com.example.WebProject.model.Lesson;
import com.example.WebProject.model.Module;
import com.example.WebProject.model.Course;
import com.example.WebProject.model.Topic;
import com.example.WebProject.repository.CourseRepository;
import com.example.WebProject.repository.LessonRepository;
import com.example.WebProject.repository.ModuleRepository;
import com.example.WebProject.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseServices {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    TopicRepository topicRepository;
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
        Course newCourse = courseRepository.save(course);
        Course dataC = courseRepository.findById(newCourse.getId()).get();
        Module newModule = new Module();
        newModule.setCourse(dataC);
        newModule.setTitle("Module1");
        newModule = moduleRepository.save(newModule);
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
        return courseRepository.findById(newCourse.getId()).get();
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/api/course/{id}")
    public Optional<Course> updateCourse(@PathVariable Integer id, @RequestBody Course course) {
        Optional<Course> oldCourse = courseRepository.findById(id);
        Course data = oldCourse.get();
        data.setModified(Calendar.getInstance().getTime());
        data.setTitle(course.getTitle());
        courseRepository.save(data);
        return courseRepository.findById(id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/course")
    public List<Course> findAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/course/{courseId}")
    public Optional<Course> findCourseById(@PathVariable Integer courseId) {
        return courseRepository.findById(courseId);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/course/delete/{id}")
    public void deleteCourseByID(@PathVariable Integer id) {
        try {
            courseRepository.deleteById(id);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
