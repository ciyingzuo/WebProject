package com.example.WebProject.services;

import com.example.WebProject.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessonService {
    @Autowired
    LessonRepository courseRepository;
}
