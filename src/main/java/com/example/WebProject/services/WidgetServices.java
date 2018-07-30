package com.example.WebProject.services;

import com.example.WebProject.model.Topic;
import com.example.WebProject.model.Widget;
import com.example.WebProject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WidgetServices {

    @Autowired
    WidgetRepository widgetRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    TopicRepository topicRepository;

    @CrossOrigin(origins = "*")
    @PostMapping("/api/widget/{topicId}/widget")
    public Widget createWidget(@RequestBody Widget widget, @PathVariable("topicId") Integer topicId) {

        Topic data = topicRepository.findById(topicId).get();
        widget.setTopic(data);
        Widget newWidget = widgetRepository.save(widget);
        return widgetRepository.findById(newWidget.getId()).get();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/widget/{topicId}")
    public List<Widget> findByTopicId(@PathVariable Integer topicId) {

        Optional<Topic> topic = topicRepository.findById(topicId);
        Topic data = topic.get();
        return widgetRepository.findByTopic(data);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/widget/delete/{id}")
    public void deleteWidgetByID(@PathVariable Integer id) {
        try {
            topicRepository.deleteById(id);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }



}
