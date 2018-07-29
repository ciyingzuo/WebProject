package com.example.WebProject.services;

import com.example.WebProject.model.Topic;
import com.example.WebProject.model.Widget;
import com.example.WebProject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/api/widget/delete/{id}")
    public void deleteTopicByID(@PathVariable Integer id) {
        try {
            topicRepository.deleteById(id);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }



}
