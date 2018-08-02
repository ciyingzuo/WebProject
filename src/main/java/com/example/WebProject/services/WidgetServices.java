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
    @PostMapping("/api/widget/{topicId}")
    public List<Widget> saveWidget(@RequestBody List<Widget> widget, @PathVariable("topicId") Integer topicId) {
        Topic data = topicRepository.findById(topicId).get();
        List<Widget> oldWidget = data.getWidget();
        for (Widget w : oldWidget) {
            widgetRepository.deleteById(w.getId());
        }
        for (Widget w : widget) {
            w.setTopic(data);
            widgetRepository.save(w);
        }
        return widgetRepository.findByTopic(data);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/widget/{topicId}")
    public List<Widget> findByTopicId(@PathVariable Integer topicId) {

        Optional<Topic> topic = topicRepository.findById(topicId);
        Topic data = topic.get();
        return widgetRepository.findByTopic(data);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/widget/{id}")
    public void deleteWidgetByID(@PathVariable Integer id) {
        try {
            topicRepository.deleteById(id);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }


}
