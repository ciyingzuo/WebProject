package com.example.WebProject.services;

import com.example.WebProject.model.Lesson;
import com.example.WebProject.model.Topic;
import com.example.WebProject.repository.CourseRepository;
import com.example.WebProject.repository.LessonRepository;
import com.example.WebProject.repository.TopicRepository;
import com.example.WebProject.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicServices {
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    TopicRepository topicRepository;

    @CrossOrigin(origins = "*")
    @PostMapping("/api/topic/{lessonId}/topic")
    public Topic createTopic(@RequestBody Topic topic, @PathVariable("lessonId") Integer lessonId) {

        Lesson data = lessonRepository.findById(lessonId).get();
        topic.setLesson(data);
        Topic newTopic = topicRepository.save(topic);
        return topicRepository.findById(newTopic.getId()).get();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/topic/delete/{id}")
    public void deleteTopicByID(@PathVariable Integer id) {
        try {
            topicRepository.deleteById(id);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
