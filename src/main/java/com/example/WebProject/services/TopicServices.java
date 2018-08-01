package com.example.WebProject.services;

import com.example.WebProject.model.Lesson;
import com.example.WebProject.model.Topic;
import com.example.WebProject.model.Widget;
import com.example.WebProject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicServices {
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    WidgetRepository widgetRepository;

    @CrossOrigin(origins = "*")
    @PostMapping("/api/topic/{lessonId}/topic")
    public Topic createTopic(@RequestBody Topic topic, @PathVariable("lessonId") Integer lessonId) {
        Lesson data = lessonRepository.findById(lessonId).get();
        topic.setLesson(data);
        Topic newTopic = topicRepository.save(topic);
        Topic dataT = topicRepository.findById(newTopic.getId()).get();
        Widget newWidget = new Widget();
        newWidget.setTopic(dataT);
        widgetRepository.save(newWidget);
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
