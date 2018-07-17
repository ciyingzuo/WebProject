package com.example.WebProject.services;

import com.example.WebProject.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModuleService {
    @Autowired
    ModuleRepository courseRepository;
}
