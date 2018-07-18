package com.example.WebProject.services;

import com.example.WebProject.model.Module;
import com.example.WebProject.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModuleService {
    @Autowired
    ModuleRepository moduleRepository;
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
    @PostMapping("/api/module")
    public Module createCourse(@RequestBody Module lesson) {
        return moduleRepository.save(lesson);
    }
}
